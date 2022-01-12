/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sbic;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yoftahe
 */
public class ThemeSetting extends javax.swing.JPanel {

    /**
     * Creates new form ThemeSetting
     */
    public ThemeSetting() throws IOException {
        initComponents();
        loadConfig();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jColorChooser1 = new javax.swing.JColorChooser();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        primaryColorField = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        secondaryColorField = new javax.swing.JComboBox<>();
        saveThemeBtn = new javax.swing.JButton();

        jLabel1.setText("Theme Setting");

        primaryColorField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));

        jLabel2.setText("Primary Colour");

        jLabel3.setText("Secondary Colour");

        secondaryColorField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));

        saveThemeBtn.setText("Save");
        saveThemeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveThemeBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(saveThemeBtn)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(secondaryColorField, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                        .addComponent(primaryColorField, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(primaryColorField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(secondaryColorField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(saveThemeBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void saveThemeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveThemeBtnActionPerformed
        try {
            // TODO add your handling code here:

            ProgramWindow.setThemeConfig(primaryColorField.getSelectedItem().toString(), secondaryColorField.getSelectedItem().toString());
            ProgramWindow.restartWindow();
            ProgramWindow.mainTab.setSelectedIndex(8); 
            loadConfig();

        } catch (Exception ex) {
            Logger.getLogger(ThemeSetting.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_saveThemeBtnActionPerformed

    void loadConfig() throws IOException {

        primaryColorField.addItem("White");
        primaryColorField.addItem("Black");
        primaryColorField.addItem("Green");
        primaryColorField.addItem("Red");
        primaryColorField.addItem("Yellow");
        primaryColorField.addItem("Blue");
        primaryColorField.addItem("Orange");
        primaryColorField.addItem("Pink");
        primaryColorField.addItem("Gray");

        secondaryColorField.addItem("White");
        secondaryColorField.addItem("Black");
        secondaryColorField.addItem("Green");
        secondaryColorField.addItem("Red");
        secondaryColorField.addItem("Yellow");
        secondaryColorField.addItem("Blue");
        secondaryColorField.addItem("Orange");
        secondaryColorField.addItem("Pink");
        secondaryColorField.addItem("Gray");

        ProgramWindow.loadThemeConfig();

        System.err.println(ProgramWindow.primaryColor);

        primaryColorField.setSelectedItem(ProgramWindow.colorToString(ProgramWindow.primaryColor));
        secondaryColorField.setSelectedItem(ProgramWindow.colorToString(ProgramWindow.secondaryColor));

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JColorChooser jColorChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JComboBox<String> primaryColorField;
    private javax.swing.JButton saveThemeBtn;
    private javax.swing.JComboBox<String> secondaryColorField;
    // End of variables declaration//GEN-END:variables
}
