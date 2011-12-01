/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ApplicationFrame.java
 *
 * Created on 2011-12-01, 17:27:55
 */
package dbmigrate.gui;

import dbmigrate.executor.ExecutorEngine;
import dbmigrate.model.db.DbConnector;
import dbmigrate.model.operation.MigrationConfiguration;
import dbmigrate.parser.Loader;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.io.File;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

/**
 *
 * @author zyxist
 */
public class ApplicationFrame extends javax.swing.JFrame {
	private DbConnector dbConnector;
	private Connection connection;
	private MigrationConfiguration migrationConfiguration;
	
	
	/** Creates new form ApplicationFrame */
	public ApplicationFrame() {
		this.dbConnector = new DbConnector();
		
		initComponents();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public DbConnector getDbConnector() {
		return this.dbConnector;
	}
	
	public MigrationConfiguration getMigrationConfiguration() {
		return this.migrationConfiguration;
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        hintPanel = new javax.swing.JToolBar();
        statusText = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        logList = new javax.swing.JList();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        historyList = new javax.swing.JList();
        jToolBar2 = new javax.swing.JToolBar();
        buttonPanel = new javax.swing.JToolBar();
        runButton = new javax.swing.JButton();
        undoButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        loadMigrationItem = new javax.swing.JMenuItem();
        quitItem = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        dbConfigItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        hintPanel.setRollover(true);

        statusText.setText("Please load a migration.");
        hintPanel.add(statusText);

        logList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(logList);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Logs", jPanel1);

        historyList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(historyList);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("History", jPanel2);

        jToolBar2.setRollover(true);

        buttonPanel.setRollover(true);

        runButton.setText("Run");
        runButton.setFocusable(false);
        runButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        runButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonPanel.add(runButton);

        undoButton.setText("Undo");
        undoButton.setFocusable(false);
        undoButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        undoButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonPanel.add(undoButton);

        jMenu1.setText("File");

        loadMigrationItem.setText("Load migration");
        loadMigrationItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadMigrationItemActionPerformed(evt);
            }
        });
        jMenu1.add(loadMigrationItem);

        quitItem.setText("Quit");
        quitItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitItemActionPerformed(evt);
            }
        });
        jMenu1.add(quitItem);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Preferences");

        dbConfigItem.setText("Database connection");
        dbConfigItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dbConfigItemActionPerformed(evt);
            }
        });
        jMenu2.add(dbConfigItem);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(hintPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
            .addComponent(buttonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(buttonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hintPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void quitItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitItemActionPerformed
	this.setVisible(false);
	WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
	Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);
}//GEN-LAST:event_quitItemActionPerformed

private void dbConfigItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dbConfigItemActionPerformed
	DbConfigurationDialog dialog = new DbConfigurationDialog(this, true);
	dialog.setVisible(true);
}//GEN-LAST:event_dbConfigItemActionPerformed

private void loadMigrationItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadMigrationItemActionPerformed
	JFileChooser fc = new JFileChooser();
	fc.setDragEnabled(false);
	fc.setMultiSelectionEnabled(false);
	fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
	fc.setDialogTitle("Load migration...");
	if(fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
		try {
			this.migrationConfiguration = Loader.load(new File(fc.getSelectedFile().getAbsolutePath()), false);
			this.statusText.setText(fc.getSelectedFile().getName()+" successfully loaded.");
		} catch (Exception ex) {
			this.statusText.setText(ex.getMessage());
		}
	}
}//GEN-LAST:event_loadMigrationItemActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToolBar buttonPanel;
    private javax.swing.JMenuItem dbConfigItem;
    private javax.swing.JToolBar hintPanel;
    private javax.swing.JList historyList;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JMenuItem loadMigrationItem;
    private javax.swing.JList logList;
    private javax.swing.JMenuItem quitItem;
    private javax.swing.JButton runButton;
    private javax.swing.JLabel statusText;
    private javax.swing.JButton undoButton;
    // End of variables declaration//GEN-END:variables
}
