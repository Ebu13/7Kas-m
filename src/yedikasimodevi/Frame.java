package yedikasimodevi;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class Frame extends javax.swing.JFrame {

    public Frame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl = new javax.swing.JTable();
        btnlist = new javax.swing.JButton();
        btnkaydet = new javax.swing.JButton();
        lblad = new javax.swing.JLabel();
        lblsoyad = new javax.swing.JLabel();
        txtad = new javax.swing.JTextField();
        txtsoyad = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ad", "Soyad"
            }
        ));
        jScrollPane1.setViewportView(tbl);

        btnlist.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnlist.setText("Listele");
        btnlist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlistActionPerformed(evt);
            }
        });

        btnkaydet.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnkaydet.setText("Kaydet");
        btnkaydet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnkaydetActionPerformed(evt);
            }
        });

        lblad.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblad.setText("Ad:");

        lblsoyad.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblsoyad.setText("Soyad:");

        txtad.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtsoyad.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout pnlLayout = new javax.swing.GroupLayout(pnl);
        pnl.setLayout(pnlLayout);
        pnlLayout.setHorizontalGroup(
            pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lblad)
                        .addGap(74, 74, 74)
                        .addComponent(txtad))
                    .addGroup(pnlLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblsoyad)
                        .addGap(49, 49, 49)
                        .addComponent(txtsoyad))
                    .addGroup(pnlLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(btnlist)
                        .addGap(18, 18, 18)
                        .addComponent(btnkaydet)
                        .addGap(0, 42, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlLayout.setVerticalGroup(
            pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblad)
                    .addComponent(txtad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblsoyad)
                    .addComponent(txtsoyad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnlist)
                    .addComponent(btnkaydet))
                .addGap(85, 85, 85))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnkaydetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnkaydetActionPerformed
        PersonManager mng = new PersonManager();
        String name = txtad.getText().toString();
        String surname = txtsoyad.getText().toString();
        try {
            mng.add(name, surname);
            txtad.setText("");
            txtsoyad.setText("");
        } catch (IOException ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnkaydetActionPerformed

    private void btnlistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlistActionPerformed
        PersonManager mng = new PersonManager();
        DefaultTableModel tblModel = (DefaultTableModel) tbl.getModel();
        tblModel.setRowCount(0);
        try {
            List<Person> prsn = mng.getList();
            for (Person i : prsn) {
                String data[] = {i.name, i.surname};
                tblModel.addRow(data);
            }
        } catch (IOException ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnlistActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnkaydet;
    private javax.swing.JButton btnlist;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblad;
    private javax.swing.JLabel lblsoyad;
    private javax.swing.JPanel pnl;
    private javax.swing.JTable tbl;
    private javax.swing.JTextField txtad;
    private javax.swing.JTextField txtsoyad;
    // End of variables declaration//GEN-END:variables
}
