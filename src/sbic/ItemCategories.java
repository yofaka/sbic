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
import static sbic.ItemCategories.tableRowSorter;


public class ItemCategories extends javax.swing.JPanel {

    static TableRowSorter tableRowSorter;
    static ItemCategory selectedItemCategory; // contains Item category object from the the currently selected row of table
    static boolean newForm; // is true if form is loaded to  save new and false if form is loaded to update
    static ItemCategory[] itemCategories;
    
    /**
     * Creates new form Items
     */
    public ItemCategories() throws SQLException {
        initComponents();
        loadItemCategories();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        itemCategoryForm = new javax.swing.JFrame();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        saveItemCategoryBtn = new javax.swing.JButton();
        nameField = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        descriptionField = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        addBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        itemCategoriesTable = new javax.swing.JTable();
        editItemCategoryBtn = new javax.swing.JButton();
        deleteItemCategoryBtn = new javax.swing.JButton();
        searchField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        refreshBtn = new javax.swing.JButton();

        itemCategoryForm.setSize(new java.awt.Dimension(400, 400));

        jLabel1.setText("Add / Edit Item Category");

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

        descriptionField.setColumns(20);
        descriptionField.setRows(5);
        jScrollPane2.setViewportView(descriptionField);

        jLabel2.setText("Description");

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
                                .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(131, Short.MAX_VALUE))
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
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(saveItemCategoryBtn)
                .addContainerGap(108, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout itemCategoryFormLayout = new javax.swing.GroupLayout(itemCategoryForm.getContentPane());
        itemCategoryForm.getContentPane().setLayout(itemCategoryFormLayout);
        itemCategoryFormLayout.setHorizontalGroup(
            itemCategoryFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        itemCategoryFormLayout.setVerticalGroup(
            itemCategoryFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        addBtn.setText("Add");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        itemCategoriesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(itemCategoriesTable);

        editItemCategoryBtn.setText("Edit");
        editItemCategoryBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editItemCategoryBtnActionPerformed(evt);
            }
        });

        deleteItemCategoryBtn.setText("Delete");
        deleteItemCategoryBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteItemCategoryBtnActionPerformed(evt);
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
                        .addComponent(editItemCategoryBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteItemCategoryBtn)
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
                    .addComponent(editItemCategoryBtn)
                    .addComponent(deleteItemCategoryBtn)
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
        clearItemCategoryForm();
        itemCategoryForm.setVisible(true);
    }//GEN-LAST:event_addBtnActionPerformed

    private void nameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameFieldActionPerformed

    private void saveItemCategoryBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveItemCategoryBtnActionPerformed

        try {

            if (newForm) {

                if (nameField.getText().equals("")) {

                    JOptionPane.showMessageDialog(this, "Enter Name", "Add Item Category", JOptionPane.ERROR_MESSAGE);
                } else if (!Validator.isProperName(nameField)) {

                    JOptionPane.showMessageDialog(this, "Name can't be longer than 30 characters.", "Add Item Category", JOptionPane.ERROR_MESSAGE);
                } else {

                    if (ItemCategory.nameExists(nameField.getText(), "")) {

                        JOptionPane.showMessageDialog(this, "Item Category Name Exists", "Add Item Category", JOptionPane.ERROR_MESSAGE);

                    } else {

                        ItemCategory newItemCategory = new ItemCategory(nameField.getText(), descriptionField.getText());
                        if (newItemCategory.save()) {
                            JOptionPane.showMessageDialog(this, "Item Category Registered Succesfully", "Add Item Category", JOptionPane.INFORMATION_MESSAGE);
                            itemCategoryForm.setVisible(false);
                            loadItemCategories();
                        }
                    }

                }

            } else {

                if (nameField.getText().equals("")) {

                    JOptionPane.showMessageDialog(this, "Enter Name", "Edit Item Category", JOptionPane.ERROR_MESSAGE);
                } else if (!Validator.isProperName(nameField)) {

                    JOptionPane.showMessageDialog(this, "Name can't be longer than 30 characters.", "Add Item Category", JOptionPane.ERROR_MESSAGE);
                } else {

                    if (ItemCategory.nameExists(nameField.getText(), selectedItemCategory.getName())) {

                        JOptionPane.showMessageDialog(this, "Item Category Name Exists", "Edit Item Category", JOptionPane.ERROR_MESSAGE);

                    } else {

                        selectedItemCategory.setName(nameField.getText());
                        selectedItemCategory.setDescription(descriptionField.getText());

                        if (selectedItemCategory.save()) {
                            JOptionPane.showMessageDialog(this, "Item Category Updated Succesfully", "Edit Item Category", JOptionPane.INFORMATION_MESSAGE);
                            itemCategoryForm.setVisible(false);
                            loadItemCategories();
                        }
                    }

                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(ItemCategories.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_saveItemCategoryBtnActionPerformed

    private void editItemCategoryBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editItemCategoryBtnActionPerformed

        newForm = false;
        clearItemCategoryForm();
        nameField.setText(selectedItemCategory.getName());
        descriptionField.setText(selectedItemCategory.getDescription());
        itemCategoryForm.setVisible(true);

    }//GEN-LAST:event_editItemCategoryBtnActionPerformed

    private void deleteItemCategoryBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteItemCategoryBtnActionPerformed

        try {
            if (!selectedItemCategory.canDelete()) {

                JOptionPane.showMessageDialog(this, "You can not delete this Item Category because it has items attached to it.", "Delete Item Category", JOptionPane.ERROR_MESSAGE);
            } else {

                if (JOptionPane.showConfirmDialog(this, "Are You Sure You Want To Delete " + selectedItemCategory.getName() + "?", "Delete Item Category", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {

                    if (selectedItemCategory.delete()) {
                        JOptionPane.showMessageDialog(this, selectedItemCategory.getName() + " deleted succesfully!", "Delete Item Category", JOptionPane.INFORMATION_MESSAGE);
                        loadItemCategories();
                    } else {
                        JOptionPane.showMessageDialog(this, "Deleting " + selectedItemCategory.getName() + " failed!", "Delete Item Category", JOptionPane.ERROR_MESSAGE);
                    }
                } else {

                }

            }
        } catch (SQLException e) {

        }

    }//GEN-LAST:event_deleteItemCategoryBtnActionPerformed

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
            loadItemCategories();
        } catch (SQLException ex) {
            Logger.getLogger(ItemCategories.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_refreshBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JButton deleteItemCategoryBtn;
    private javax.swing.JTextArea descriptionField;
    private javax.swing.JButton editItemCategoryBtn;
    private javax.swing.JTable itemCategoriesTable;
    private javax.swing.JFrame itemCategoryForm;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField nameField;
    private javax.swing.JButton refreshBtn;
    private javax.swing.JButton saveItemCategoryBtn;
    private javax.swing.JTextField searchField;
    // End of variables declaration//GEN-END:variables

    void loadItemCategories() throws SQLException {
        
        if(!Session.getLoggedInUser().getRole().equals("Administrator")){
        
            addBtn.setEnabled(false);
        }

        editItemCategoryBtn.setEnabled(false);

        deleteItemCategoryBtn.setEnabled(false);

        String tableColumns[] = {"No", "Name", "Description"};

         itemCategories = ItemCategory.findAll();

        Object tableDataRows[][] = new Object[itemCategories.length][3];

        int numberOfRows = 0;

        for (ItemCategory itemCategory : itemCategories) {

            tableDataRows[numberOfRows][0] = (numberOfRows+1);
            tableDataRows[numberOfRows][1] = itemCategory.getName();
            tableDataRows[numberOfRows][2] = itemCategory.getDescription();
            //tableDataRows[numberOfRows][3] = (Object) new JButton("Edit");
            numberOfRows++;
        }

        TableModel itemCategoriesTableModel = new DefaultTableModel(tableDataRows, tableColumns){
        
            @Override
            public boolean isCellEditable(int row, int column){
            return false;
            }
        };

        itemCategoriesTable.setModel(itemCategoriesTableModel);

        ListSelectionModel itemCategoriesTableSelectionModel = itemCategoriesTable.getSelectionModel();

        tableRowSorter = new TableRowSorter(itemCategoriesTable.getModel());

        itemCategoriesTable.setRowSorter(tableRowSorter);
        
        itemCategoriesTableSelectionModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                if (itemCategoriesTableSelectionModel.getMaxSelectionIndex() == -1) {

                    editItemCategoryBtn.setEnabled(false);

                    deleteItemCategoryBtn.setEnabled(false);

                } else {

                if(Session.getLoggedInUser().getRole().equals("Administrator") )  {  
                    editItemCategoryBtn.setEnabled(true);

                    deleteItemCategoryBtn.setEnabled(true);
                    
                }
                    selectedItemCategory = itemCategories[itemCategoriesTableSelectionModel.getMaxSelectionIndex()];
                }
            }
        });
        

        
    }

    void clearItemCategoryForm() {

        nameField.setText("");
        descriptionField.setText("");

    }

}
