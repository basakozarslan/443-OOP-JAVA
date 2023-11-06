package Swing;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import animalsPackage.Cow;
import animalsPackage.Sheep;
import mainPackage.FarmApp;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

/**
 *
 * @author basak
 */
public class getTreatmentsSwing extends javax.swing.JFrame {
    DefaultTableModel model;
    /**
     * Creates new form getTreatmentsSwing
     */
    public getTreatmentsSwing() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblTreatment = new javax.swing.JTable();
        btnMenu = new javax.swing.JButton();
        btnGetTreatment = new javax.swing.JButton();
        txtAnimalID = new javax.swing.JTextField();
        lblAnimalID = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblTreatment.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null},
                        {null},
                        {null},
                        {null}
                },
                new String [] {
                        "Date Of Treatment"
                }
        ) {
            boolean[] canEdit = new boolean [] {
                    false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblTreatment);
        if (tblTreatment.getColumnModel().getColumnCount() > 0) {
            tblTreatment.getColumnModel().getColumn(0).setResizable(false);
        }

        btnMenu.setText("Menu");
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });

        btnGetTreatment.setText("Get Treatment");
        btnGetTreatment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGetTreatmentActionPerformed(evt);
            }
        });

        txtAnimalID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAnimalIDActionPerformed(evt);
            }
        });

        lblAnimalID.setText("Animal ID:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(97, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(86, 86, 86))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(147, 147, 147)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnMenu)
                                        .addComponent(btnGetTreatment)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblAnimalID, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(72, 72, 72)
                                                .addComponent(txtAnimalID, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addComponent(btnMenu)
                                .addGap(28, 28, 28)
                                .addComponent(btnGetTreatment)
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblAnimalID)
                                        .addComponent(txtAnimalID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(61, 61, 61))
        );

        pack();
    }// </editor-fold>

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {
        FarmAppSwing farmAppSwing = new FarmAppSwing();
        this.setVisible(false);
        farmAppSwing.setVisible(true);
    }

    private void btnGetTreatmentActionPerformed(java.awt.event.ActionEvent evt) {
        model = (DefaultTableModel)tblTreatment.getModel();
        String aID = txtAnimalID.getText();
        int animalID = Integer.parseInt(aID);

        ArrayList<Cow> cows = FarmApp.CowArrayList();
        for(Cow cow: cows){
            Object[] row = {animalID, cow.getGender(), cow.isPurchased(),
                    cow.getMilking().toString(), cow.getWeight(), cow.getDateOfBirth()};
            model.addRow(row);
        }
        ArrayList<Sheep>sheeps = FarmApp.SheepArrayList();
        for(Sheep sheep: sheeps){
            Object[] row = {animalID,sheep.getGender(), sheep.isPurchased(),
                    sheep.getMilking().toString(), sheep.getDateOfBirth()};
            model.addRow(row);
        }
    }

    private void txtAnimalIDActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

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
            java.util.logging.Logger.getLogger(getTreatmentsSwing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(getTreatmentsSwing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(getTreatmentsSwing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(getTreatmentsSwing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new getTreatmentsSwing().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton btnGetTreatment;
    private javax.swing.JButton btnMenu;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAnimalID;
    private javax.swing.JTable tblTreatment;
    private javax.swing.JTextField txtAnimalID;
    // End of variables declaration
}