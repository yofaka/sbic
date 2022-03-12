/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sbic;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
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


public class Transfers extends javax.swing.JPanel {

    static TableRowSorter tableRowSorter;

    static boolean newForm;
    static Item[] listedItems;

    static Transfer selectedTransfer;
    static Transfer[] grns;
    /**
     * Creates new form Transfers
     */
    public Transfers() throws SQLException, ParseException {
        initComponents();
        loadData();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        form = new javax.swing.JFrame();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        grnNumberField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        itemField = new javax.swing.JComboBox<>();
        transferedQuantityField = new javax.swing.JSpinner();
        jLabel9 = new javax.swing.JLabel();
        saveBtn = new javax.swing.JButton();
        dateField = new javax.swing.JSpinner();
        supplierField = new javax.swing.JComboBox<>();
        expiryDateField = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        addBtn = new javax.swing.JButton();
        editBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        refreshBtn = new javax.swing.JButton();
        searchField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        form.setResizable(false);
        form.setSize(new java.awt.Dimension(400, 800));

        jLabel1.setText("Add \\ Edit GRN");

        jLabel2.setText("GRN Number");

        jLabel3.setText("Date (dd/mm/yyyy)");

        jLabel5.setText("Supplier");

        jLabel8.setText("Item");

        transferedQuantityField.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, 1.0E7d, 1.0d));
        transferedQuantityField.setEditor(new javax.swing.JSpinner.NumberEditor(transferedQuantityField, ""));

        jLabel9.setText("Quantity");

        saveBtn.setText("Save");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        dateField.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), null, new java.util.Date(), java.util.Calendar.DAY_OF_MONTH));

        jLabel6.setText("Expiry Date");

        jLabel7.setText("Target Location");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(saveBtn))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(expiryDateField, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(supplierField, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(dateField, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(grnNumberField, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(itemField, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(transferedQuantityField, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(146, 146, 146))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(grnNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(supplierField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(itemField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(expiryDateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(transferedQuantityField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(saveBtn)
                .addContainerGap(193, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout formLayout = new javax.swing.GroupLayout(form.getContentPane());
        form.getContentPane().setLayout(formLayout);
        formLayout.setHorizontalGroup(
            formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        formLayout.setVerticalGroup(
            formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        addBtn.setText("Add");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

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

        refreshBtn.setText("Refresh");
        refreshBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshBtnActionPerformed(evt);
            }
        });

        searchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchFieldActionPerformed(evt);
            }
        });
        searchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchFieldKeyReleased(evt);
            }
        });

        jLabel4.setText("Search");

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(table);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 474, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
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
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(addBtn)
                        .addComponent(editBtn)
                        .addComponent(deleteBtn)
                        .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(refreshBtn))
                    .addGap(34, 34, 34)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                    .addContainerGap()))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        try {

            if (newForm) {

                if (grnNumberField.getText().equals("")) {

                    JOptionPane.showMessageDialog(this, "Enter Transfer Number", "Add Transfer", JOptionPane.ERROR_MESSAGE);

                } else if (transferedQuantityField.getValue().equals("") || transferedQuantityField.getValue() == null) {

                    JOptionPane.showMessageDialog(this, "Enter Quantity", "Add Transfer", JOptionPane.ERROR_MESSAGE);

                }  else if (!Validator.properDocumentNumber(grnNumberField)) {

                    JOptionPane.showMessageDialog(this, "Transfer Number can't be longer than 10 characters", "Add Transfer", JOptionPane.ERROR_MESSAGE);

                } else if (Transfer.transferNumberExists(grnNumberField.getText(), "")) {

                    JOptionPane.showMessageDialog(this, "This Transfer Number is already in use.", "Add Transfer", JOptionPane.ERROR_MESSAGE);

                }  else if (!Validator.isNumberGreaterThan(transferedQuantityField, 0)) {

                    JOptionPane.showMessageDialog(this, "The quantity needs to be a valid number greater than 0", "Add Transfer", JOptionPane.ERROR_MESSAGE);

                } else {

                    setTotalCost();
                   Transfer newTransfer = new Transfer();//grnNumberField.getText(), (Date) dateField.getValue(), supplierNameField.getText(), supplierTelephoneNumberField.getText(), supplierTINNumberField.getText(), Session.getLoggedInUser(), listedItems[itemField.getSelectedIndex()], (double) transferedQuantityField.getValue(), (double) unitCostField.getValue(), (double) totalCostField.getValue());

                    if (newTransfer.save()) {

                        JOptionPane.showMessageDialog(this, "Transfer Registered Succesfully", "Add Transfer", JOptionPane.INFORMATION_MESSAGE);
                        form.setVisible(false);
                        loadData();
                    } else {
                        JOptionPane.showMessageDialog(this, "Transfer Registeration Failed", "Add Transfer", JOptionPane.ERROR_MESSAGE);

                    }

                }
            } else {

                if (grnNumberField.getText().equals("")) {

                    JOptionPane.showMessageDialog(this, "Enter Transfer Number", "Add Transfer", JOptionPane.ERROR_MESSAGE);

                }  else if (transferedQuantityField.getValue().equals("") || transferedQuantityField.getValue() == null) {

                    JOptionPane.showMessageDialog(this, "Enter Quantity", "Add Transfer", JOptionPane.ERROR_MESSAGE);

                }  else if (!Validator.properDocumentNumber(grnNumberField)) {

                    JOptionPane.showMessageDialog(this, "Transfer Number can't be longer than 10 characters", "Add Transfer", JOptionPane.ERROR_MESSAGE);

                }  else if (!Validator.isNumberGreaterThan(transferedQuantityField, 0)) {

                    JOptionPane.showMessageDialog(this, "The quantity needs to be a valid number greater than 0", "Add Transfer", JOptionPane.ERROR_MESSAGE);

                } else if (!Validator.isNumberGreaterThan(transferedQuantityField, (selectedTransfer.getItem().getQuantityAtHand() + 0.1))) {

                    JOptionPane.showMessageDialog(this, "You can't reduce the quantity more than the available quantity of the item!", "Add Transfer", JOptionPane.ERROR_MESSAGE);

                } else {

                    setTotalCost();
                    selectedTransfer.setTransferNumber(grnNumberField.getText());
                    selectedTransfer.setDate((Date) dateField.getValue());
//                    selectedTransfer.setSupplierName(supplierNameField.getText());
 //                   selectedTransfer.setSupplierTelephone(supplierTelephoneNumberField.getText());
 //                   selectedTransfer.setSupplierTIN(supplierTINNumberField.getText());
                    selectedTransfer.setItem(listedItems[itemField.getSelectedIndex()]);
                    selectedTransfer.setTransferedQuantity((double) transferedQuantityField.getValue());
                    

                    if (selectedTransfer.save()) {

                        JOptionPane.showMessageDialog(this, "Transfer Updated Succesfully", "Edit Transfer", JOptionPane.INFORMATION_MESSAGE);
                        form.setVisible(false);
                        loadData();
                    } else {
                        JOptionPane.showMessageDialog(this, "Transfer Update Failed", "Edit Transfer", JOptionPane.ERROR_MESSAGE);

                    }

                }

            }

        } catch (SQLException | ParseException ex) {
            Logger.getLogger(Transfers.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_saveBtnActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed

        try {
            clearForm();
            if (itemField.getItemCount() > 0) {

                newForm = true;

                grnNumberField.setEnabled(true);
                dateField.setEnabled(true);
                itemField.setEnabled(true);
                transferedQuantityField.setEnabled(true);
                form.setVisible(true);
            } else {

                JOptionPane.showMessageDialog(this, "You can't add Transfer because there are no items.", "Add Transfer", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Items.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_addBtnActionPerformed

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed

        try {
            newForm = false;
            clearForm();
            loadItemField();

            grnNumberField.setText(selectedTransfer.getTransferNumber());
            dateField.setValue(selectedTransfer.getDate());
//            supplierNameField.setText(selectedTransfer.getSupplierName());
 //           supplierTelephoneNumberField.setText(selectedTransfer.getSupplierTelephone());
 //           supplierTINNumberField.setText(selectedTransfer.getSupplierTIN());

            itemField.setSelectedItem(selectedTransfer.getItem().getName());

    //        supplierTINNumberField.setText(selectedTransfer.getSupplierTIN());

            transferedQuantityField.setValue(selectedTransfer.getTransferedQuantity());
      

            //Lock some Fields For Data Integrity Purposes
            grnNumberField.setEnabled(false);
            dateField.setEnabled(false);
            itemField.setEnabled(false);
            transferedQuantityField.setEnabled(false);

            form.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Items.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_editBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed

        try {
            if (!selectedTransfer.canDelete()) {

                JOptionPane.showMessageDialog(this, "You can not delete this " + selectedTransfer.getTransferNumber() + " because you dont have sufficient quantity of " + selectedTransfer.getItem().getName() + " !", "Delete Item", JOptionPane.ERROR_MESSAGE);
            } else {

                if (JOptionPane.showConfirmDialog(this, "Are You Sure You Want To Delete " + selectedTransfer.getTransferNumber() + "? It will reduce the amount of " + selectedTransfer.getItem().getName() + " by " + selectedTransfer.getTransferedQuantity(), "Delete Item Category", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {

                    if (selectedTransfer.delete()) {
                        JOptionPane.showMessageDialog(this, selectedTransfer.getTransferNumber() + " deleted succesfully!", "Delete Item", JOptionPane.INFORMATION_MESSAGE);
                        loadData();
                    } else {
                        JOptionPane.showMessageDialog(this, "Deleting " + selectedTransfer.getTransferNumber() + " failed!", "Delete Item Category", JOptionPane.ERROR_MESSAGE);
                    }
                } else {

                }

            }
        } catch (SQLException e) {

        } catch (ParseException ex) {
            Logger.getLogger(Transfers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void refreshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshBtnActionPerformed
        try {
            // TODO add your handling code here:
            loadData();
        } catch (SQLException ex) {
            Logger.getLogger(Items.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Transfers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_refreshBtnActionPerformed

    private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchFieldActionPerformed

    private void searchFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchFieldKeyReleased
        // TODO add your handling code here:

        String searchKey = searchField.getText();
        if (searchKey.trim().length() == 0) {
            tableRowSorter.setRowFilter(null);
        } else {
            tableRowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchKey));
        }
    }//GEN-LAST:event_searchFieldKeyReleased

    void loadItemField(String selectedItemName) throws SQLException {

        listedItems = Item.findAll();

        itemField.removeAllItems();

        for (Item item : listedItems) {

            itemField.addItem(item.getName());

            if (selectedItemName.equals(item.getName())) {

                itemField.setSelectedItem(selectedItemName);
            }

        }

    }

    void loadItemField() throws SQLException {

        listedItems = Item.findAll();

        itemField.removeAllItems();

        for (Item itemCategory : listedItems) {

            itemField.addItem(itemCategory.getName());

        }

    }

    void loadData() throws SQLException, ParseException {

        if (!Session.getLoggedInUser().getRole().equals("Administrator")) {

            addBtn.setEnabled(false);
        }

        editBtn.setEnabled(false);

        deleteBtn.setEnabled(false);

        String tableColumns[] = {"No", "Serial", "Transfer Number", "Date", "Supplier Name", "Supplier Telephone", "Supplier TIN", "User", "Item", "Transfered Quantity", "Unit Cost", "Total Cost"};

         grns = Transfer.findAll();

        Object tableDataRows[][] = new Object[grns.length][12];

        int numberOfRows = 0;

        for (Transfer grn : grns) {

            tableDataRows[numberOfRows][0] = (numberOfRows + 1);
            tableDataRows[numberOfRows][1] = grn.getId();
            tableDataRows[numberOfRows][2] = grn.getTransferNumber();
            tableDataRows[numberOfRows][3] = grn.getDate();
//            tableDataRows[numberOfRows][4] = grn.getSupplierName();
//            tableDataRows[numberOfRows][5] = grn.getSupplierTelephone();
 //           tableDataRows[numberOfRows][6] = grn.getSupplierTIN();
            tableDataRows[numberOfRows][7] = grn.getUser().getUserName();
            tableDataRows[numberOfRows][8] = grn.getItem().getName();
            tableDataRows[numberOfRows][9] = grn.getTransferedQuantity();
          
            numberOfRows++;
        }

        TableModel TransfersTableModel = new DefaultTableModel(tableDataRows, tableColumns) {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        table.setModel(TransfersTableModel);

        ListSelectionModel TransfersTableSelectionModel = table.getSelectionModel();

        tableRowSorter = new TableRowSorter(table.getModel());

        table.setRowSorter(tableRowSorter);

        TransfersTableSelectionModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                if (TransfersTableSelectionModel.getMaxSelectionIndex() == -1) {

                    editBtn.setEnabled(false);

                    deleteBtn.setEnabled(false);

                } else {

                    try {
                        System.out.println("Some Transfer selected");
                        
                        if (Session.getLoggedInUser().getRole().equals("Administrator")) {
                            System.out.println("Some Transfer selected -> by admin");
                            editBtn.setEnabled(true);
                            
                            deleteBtn.setEnabled(true);
                        }
                        
                        try {
                            selectedTransfer = Transfer.find((int) table.getValueAt(table.getSelectedRow(),1));
                        } catch (ParseException ex) {
                            Logger.getLogger(Transfers.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(Transfers.class.getName()).log(Level.SEVERE, null, ex);
                    }

                   

                }
            }
        });

    }

    void setTotalCost() {

        System.out.println("total Cost Update");

     
        double transferedQuantity = Double.valueOf(0);

       
    }

    void clearForm() throws SQLException {

        loadItemField();

        grnNumberField.setText("");
supplierField.setSelectedIndex(0);

        dateField.setValue(new Date());

        if (itemField.getItemCount() > 0) {
            itemField.setSelectedIndex(0);
        }

        transferedQuantityField.setValue(0);
       

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JSpinner dateField;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton editBtn;
    private javax.swing.JSpinner expiryDateField;
    private javax.swing.JFrame form;
    private javax.swing.JTextField grnNumberField;
    private javax.swing.JComboBox<String> itemField;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton refreshBtn;
    private javax.swing.JButton saveBtn;
    private javax.swing.JTextField searchField;
    private javax.swing.JComboBox<String> supplierField;
    private javax.swing.JTable table;
    private javax.swing.JSpinner transferedQuantityField;
    // End of variables declaration//GEN-END:variables
}