/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sbic;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import static sbic.Units.tableRowSorter;

public class Units extends javax.swing.JPanel {

    static TableRowSorter tableRowSorter;
    static Unit selectedUnit; // contains Item category object from the the currently selected row of table
    static boolean newForm; // is true if form is loaded to  save new and false if form is loaded to update
    static Unit[] units;

    /**
     * Creates new form Items
     */
    public Units() throws SQLException {
        initComponents();
        loadUnits();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        unitForm = new javax.swing.JFrame();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        saveItemCategoryBtn = new javax.swing.JButton();
        nameField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        addBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        unitsTable = new javax.swing.JTable();
        editBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        searchField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        refreshBtn = new javax.swing.JButton();

        unitForm.setSize(new java.awt.Dimension(400, 400));

        jLabel1.setText("Add / Edit Unit");

        saveItemCategoryBtn.setText("Save");
        saveItemCategoryBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveItemCategoryBtnActionPerformed(evt);
            }
        });

        nameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameFieldActionPerformed(evt);
            }
        });

        jLabel3.setText("Name");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(saveItemCategoryBtn)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(132, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(4, 4, 4)
                .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(saveItemCategoryBtn)
                .addContainerGap(249, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout unitFormLayout = new javax.swing.GroupLayout(unitForm.getContentPane());
        unitForm.getContentPane().setLayout(unitFormLayout);
        unitFormLayout.setHorizontalGroup(
            unitFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        unitFormLayout.setVerticalGroup(
            unitFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        addBtn.setText("Add");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        unitsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(unitsTable);

        editBtn.setText("Edit");
        editBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtnActionPerformed(evt);
            }
        });

        deleteBtn.setText("Delete");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        searchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchFieldKeyReleased(evt);
            }
        });

        jLabel4.setText("Search");

        refreshBtn.setText("Refresh");
        refreshBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshBtnActionPerformed(evt);
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
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(refreshBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addBtn)
                    .addComponent(editBtn)
                    .addComponent(deleteBtn)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(refreshBtn))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                .addGap(117, 117, 117))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed

        newForm = true;
        clearUnitForm();
        unitForm.setVisible(true);
    }//GEN-LAST:event_addBtnActionPerformed

    private void nameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameFieldActionPerformed

    private void saveItemCategoryBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveItemCategoryBtnActionPerformed

        try {

            if (newForm) {

                if (nameField.getText().equals("")) {

                    JOptionPane.showMessageDialog(this, "Enter Name", "Add Unit", JOptionPane.ERROR_MESSAGE);
                } else if (!Validator.isProperName(nameField)) {

                    JOptionPane.showMessageDialog(this, "Name can't be longer than 30 characters.", "Add Unit", JOptionPane.ERROR_MESSAGE);
                } else {

                    if (Unit.nameExists(nameField.getText(), "")) {

                        JOptionPane.showMessageDialog(this, "Unit Name Exists", "Add Unit", JOptionPane.ERROR_MESSAGE);

                    } else {

                        Unit newUnit = new Unit(nameField.getText());
                        if (newUnit.save()) {
                            JOptionPane.showMessageDialog(this, "Unit Registered Succesfully", "Add Unit", JOptionPane.INFORMATION_MESSAGE);
                            unitForm.setVisible(false);
                            loadUnits();
                        }
                    }

                }

            } else {

                if (nameField.getText().equals("")) {

                    JOptionPane.showMessageDialog(this, "Enter Name", "Edit Unit", JOptionPane.ERROR_MESSAGE);
                } else if (!Validator.isProperName(nameField)) {

                    JOptionPane.showMessageDialog(this, "Name can't be longer than 30 characters.", "Add Unit", JOptionPane.ERROR_MESSAGE);
                } else {

                    if (Unit.nameExists(nameField.getText(), selectedUnit.getName())) {

                        JOptionPane.showMessageDialog(this, "Unit Name Exists", "Edit Unit", JOptionPane.ERROR_MESSAGE);

                    } else {

                        selectedUnit.setName(nameField.getText());
                       

                        if (selectedUnit.save()) {
                            JOptionPane.showMessageDialog(this, "Unit Updated Succesfully", "Edit Unit", JOptionPane.INFORMATION_MESSAGE);
                            unitForm.setVisible(false);
                            loadUnits();
                        }
                    }

                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(Units.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_saveItemCategoryBtnActionPerformed

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed

        newForm = false;
        clearUnitForm();
        nameField.setText(selectedUnit.getName());
 
        unitForm.setVisible(true);

    }//GEN-LAST:event_editBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed

        try {
            if (!selectedUnit.canDelete()) {

                JOptionPane.showMessageDialog(this, "You can not delete this Unit because it has items attached to it.", "Delete Unit", JOptionPane.ERROR_MESSAGE);
            } else {

                if (JOptionPane.showConfirmDialog(this, "Are You Sure You Want To Delete " + selectedUnit.getName() + "?", "Delete Unit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {

                    if (selectedUnit.delete()) {
                        JOptionPane.showMessageDialog(this, selectedUnit.getName() + " deleted succesfully!", "Delete Unit", JOptionPane.INFORMATION_MESSAGE);
                        loadUnits();
                    } else {
                        JOptionPane.showMessageDialog(this, "Deleting " + selectedUnit.getName() + " failed!", "Delete Unit", JOptionPane.ERROR_MESSAGE);
                    }
                } else {

                }

            }
        } catch (SQLException e) {

        }

    }//GEN-LAST:event_deleteBtnActionPerformed

    private void searchFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchFieldKeyReleased
        // TODO add your handling code here:

        String searchKey = searchField.getText();
        if (searchKey.trim().length() == 0) {
            tableRowSorter.setRowFilter(null);
        } else {
            tableRowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchKey));
        }
    }//GEN-LAST:event_searchFieldKeyReleased

    private void refreshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshBtnActionPerformed
        try {
            // TODO add your handling code here:
            loadUnits();
        } catch (SQLException ex) {
            Logger.getLogger(Units.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_refreshBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton editBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField nameField;
    private javax.swing.JButton refreshBtn;
    private javax.swing.JButton saveItemCategoryBtn;
    private javax.swing.JTextField searchField;
    private javax.swing.JFrame unitForm;
    private javax.swing.JTable unitsTable;
    // End of variables declaration//GEN-END:variables

    void loadUnits() throws SQLException {

        searchField.setText("");

        if (!Session.getLoggedInUser().getRole().equals("Administrator")) {

            addBtn.setEnabled(false);
        }

        editBtn.setEnabled(false);

        deleteBtn.setEnabled(false);

        String tableColumns[] = {"No", "Serial", "Name"};

        units = Unit.findAll();

        Object tableDataRows[][] = new Object[units.length][3];

        int numberOfRows = 0;

        for (Unit itemCategory : units) {

            tableDataRows[numberOfRows][0] = (numberOfRows + 1);
            tableDataRows[numberOfRows][1] = itemCategory.getId();
            tableDataRows[numberOfRows][2] = itemCategory.getName();
          

            numberOfRows++;
        }

        TableModel itemCategoriesTableModel = new DefaultTableModel(tableDataRows, tableColumns) {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        unitsTable.setModel(itemCategoriesTableModel);

        ListSelectionModel itemCategoriesTableSelectionModel = unitsTable.getSelectionModel();

        tableRowSorter = new TableRowSorter(unitsTable.getModel());

        unitsTable.setRowSorter(tableRowSorter);

        itemCategoriesTableSelectionModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                if (itemCategoriesTableSelectionModel.getMaxSelectionIndex() == -1) {

                    editBtn.setEnabled(false);

                    deleteBtn.setEnabled(false);

                } else {

                    if (Session.getLoggedInUser().getRole().equals("Administrator")) {
                        editBtn.setEnabled(true);
                        
                        deleteBtn.setEnabled(true);
                        
                    }
                    selectedUnit = Unit.find((int) unitsTable.getValueAt(unitsTable.getSelectedRow(), 1));
                }
            }
        });
    }

    void clearUnitForm() {

        nameField.setText("");


    }

}
