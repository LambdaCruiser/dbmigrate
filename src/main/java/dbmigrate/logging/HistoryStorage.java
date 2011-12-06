package dbmigrate.logging;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbmigrate.executor.CreateTableExecutor;
import dbmigrate.model.db.Column;
import dbmigrate.model.db.IColumn;
import dbmigrate.model.db.Table;
import dbmigrate.model.db.TypeEnum;
import dbmigrate.model.operation.CreateTableOperationDescriptor;

public class HistoryStorage {
	
	private Connection conn;
	private String tableName = "history_storage";
	
	private void createTable() {
		Table table = new Table();
		table.setName(tableName);
		
		List<IColumn> columns =  new ArrayList<IColumn> ();
		Column ip = new Column();
		ip.setName("ip");
		ip.setType(TypeEnum.VARCHAR);
		ip.setLength(15);
		ip.setNullable(true);
		
		Column migrationId = new Column();
		migrationId.setName("migration_id");
		migrationId.setType(TypeEnum.VARCHAR);
		migrationId.setLength(100);
		migrationId.setNullable(false);
		
		Column date = new Column();
		date.setName("migration_date");
		date.setType(TypeEnum.DATE);
		
		Column direction = new Column();
		direction.setName("direction");
		direction.setType(TypeEnum.INT);
		
		Column operations = new Column();
		operations.setName("operations");
		operations.setType(TypeEnum.TEXT);
		
		Column success = new Column();
		success.setName("success");
		success.setType(TypeEnum.INT);
		
		columns.add(ip);
		columns.add(migrationId);
		columns.add(date);
		columns.add(direction);
		columns.add(operations);
		columns.add(success);
		
		table.setColumns(columns);
		
		
		CreateTableOperationDescriptor createDesc = new CreateTableOperationDescriptor();
		createDesc.setTable(table);
		
		CreateTableExecutor createExec = new CreateTableExecutor(conn);
		
		try {
			createExec.execute(createDesc);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void store(String ip, String migration_id, String date, int direction, String operations, boolean success) {
		StringBuffer query = new StringBuffer();
		query.append("INSERT INTO \"" + tableName + "\" (ip, migration_id, migration_date, direction, operations, success) VALUES(");
		query.append("'" + ip + "', ");
		query.append("'" + migration_id + "', ");
		query.append("'" + date + "', ");
		query.append("" + direction + ", ");
		query.append("'" + operations + "', ");
		int succ = 0;
		if (success) {
			succ = 1;
		}
		query.append("" + succ + ");");
		LoggerFactory.getLogger().log(query.toString(), Level.Info);
		
		try {
			conn.createStatement().executeUpdate(query.toString());
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public HistoryStorage(Connection conn) {
		this.conn = conn;
		
		String query = "SELECT COUNT(*) FROM information_schema.tables WHERE table_schema = 'public' AND table_name='" + tableName + "';";
		
		try {
			ResultSet rset = conn.createStatement().executeQuery(query);
			Boolean hasTable = rset.next();
			int count = rset.getInt(1);
			LoggerFactory.getLogger().log("Table count: " + count, Level.Info);
			
			if (count == 0) {
				createTable();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			
		}
		
	}

	
}
