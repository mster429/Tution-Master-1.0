/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package coursesmanagement;

import database.Connect;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nadun
 */
public class InstituteSelector extends javax.swing.JFrame {

    /**
     * Creates new form InstituteSelecter
     */
    private DefaultTableModel dtm;
    private static InstituteSelector instance = new InstituteSelector();
    public InstituteSelector() {
        initComponents();
        dtm=(DefaultTableModel) instituteSelecterTable.getModel();
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int width=(int) dimension.getWidth();
        int height=(int) dimension.getHeight();
        this.setLocation((width/2)-205,(height/2)-135);
    }
    
    
     public static InstituteSelector getInstance(){
        return instance;  
    }
    
    public void showInterface(){
        instance.setVisible(true);
        
        retrieveData();
        if(dtm.getRowCount()>0){
        instituteSelecterTable.setRowSelectionInterval(0, 0);
        }
    }
    
     private void cleanTable(){
      dtm.getDataVector().removeAllElements();
      dtm.fireTableDataChanged();
    }
    
    private void addInstitute(String institute,String city){
        dtm.addRow(new Object[]{institute,city});
    }
    
    private void retrieveData(){
      cleanTable();
      String query="SELECT * FROM institution WHERE delete_status=0";
      Connect c=new Connect();
        ResultSet r=c.getQuery(query);
        try {
            while(r.next()){
            
            String institute=r.getString("name");
            String city=r.getString("city");
            addInstitute(institute, city);
            }
        } catch (SQLException ex) {
            Logger.getLogger(InstituteSelector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        instituteSelecterTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        okBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(21, 21, 41));
        jPanel1.setPreferredSize(new java.awt.Dimension(500, 350));

        jScrollPane1.setBackground(new java.awt.Color(21, 21, 41));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(36, 36, 64)));

        instituteSelecterTable.setBackground(new java.awt.Color(21, 21, 41));
        instituteSelecterTable.setFont(new java.awt.Font("Swis721 LtEx BT", 0, 16)); // NOI18N
        instituteSelecterTable.setForeground(new java.awt.Color(153, 153, 153));
        instituteSelecterTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Institute Name", "City / Town"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        instituteSelecterTable.setFocusable(false);
        instituteSelecterTable.setGridColor(new java.awt.Color(36, 36, 64));
        instituteSelecterTable.setRowHeight(30);
        instituteSelecterTable.setSelectionBackground(new java.awt.Color(36, 36, 64));
        instituteSelecterTable.setSelectionForeground(new java.awt.Color(204, 204, 204));
        instituteSelecterTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        instituteSelecterTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(instituteSelecterTable);
        instituteSelecterTable.getColumnModel().getColumn(0).setResizable(false);
        instituteSelecterTable.getColumnModel().getColumn(0).setPreferredWidth(200);
        instituteSelecterTable.getColumnModel().getColumn(1).setResizable(false);
        instituteSelecterTable.getColumnModel().getColumn(1).setPreferredWidth(250);

        jLabel1.setFont(new java.awt.Font("Swis721 LtEx BT", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setText("Institution");

        jPanel2.setBackground(new java.awt.Color(21, 21, 41));
        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        okBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/okCircle.png"))); // NOI18N
        okBtn.setBorder(null);
        okBtn.setFocusPainted(false);
        okBtn.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/image/okCircleSelected.png"))); // NOI18N
        okBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okBtnActionPerformed(evt);
            }
        });
        jPanel2.add(okBtn);

        cancelBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/CloseCircle.png"))); // NOI18N
        cancelBtn.setBorder(null);
        cancelBtn.setFocusPainted(false);
        cancelBtn.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/image/CloseCircle-selected.png"))); // NOI18N
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });
        jPanel2.add(cancelBtn);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okBtnActionPerformed
       int selectedRow = instituteSelecterTable.getSelectedRow();
        String institute=dtm.getValueAt(selectedRow, 0).toString();
        String city=dtm.getValueAt(selectedRow, 1).toString();
        NewCourse.getInstance().getInstituteTxt().setText(institute);
        NewCourse.getInstance().getCityTxt().setText(city);
        this.dispose();
    }//GEN-LAST:event_okBtnActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InstituteSelector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InstituteSelector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InstituteSelector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InstituteSelector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InstituteSelector().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelBtn;
    private javax.swing.JTable instituteSelecterTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton okBtn;
    // End of variables declaration//GEN-END:variables
}
