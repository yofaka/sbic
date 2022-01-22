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
import static sbic.Items.newForm;

/**
 *
 * @author Yoftahe
 */
public class GRNs extends javax.swing.JPanel {

    static TableRowSorter tableRowSorter;

    static boolean newForm;
    static Item[] listedItems;

    static GRN selectedGRN;

    /**
     * Creates new form GRNs
     */
    public GRNs() throws SQLException, ParseException {
        initComponents();
        loadData();
        loadItemField();

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
        supplierNameField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        supplierTelephoneNumberField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        supplierTINNumberField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        itemField = new javax.swing.JComboBox<>();
        receivedQuantityField = new javax.swing.JSpinner();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        unitCostField = new javax.swing.JSpinner();
        jLabel11 = new javax.swing.JLabel();
        totalCostField = new javax.swing.JSpinner();
        saveBtn = new javax.swing.JButton();
        dateField = new javax.swing.JSpinner();
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

        jLabel5.setText("Supplier Name");

        jLabel6.setText("Supplier Telephone Number");

        supplierTelephoneNumberField.setText("+251");

        jLabel7.setText("Supplier TIN Number");

        jLabel8.setText("Item");

        receivedQuantityField.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, 1.0E7d, 1.0d));
        receivedQuantityField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                receivedQuantityFieldKeyReleased(evt);
            }
        });

        jLabel9.setText("Quantity");

        jLabel10.setText("Unit Cost");

        unitCostField.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, 1.0E7d, 1.0d));
        unitCostField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                unitCostFieldKeyReleased(evt);
            }
        });

        jLabel11.setText("Total Cost");

        totalCostField.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, 1.0E7d, 1.0d));
        totalCostField.setEnabled(false);

        saveBtn.setText("Save");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        dateField.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), null, new java.util.Date(), java.util.Calendar.DAY_OF_MONTH));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(saveBtn))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(totalCostField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dateField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(supplierTINNumberField)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(grnNumberField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(supplierNameField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(supplierTelephoneNumberField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(itemField, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(receivedQuantityField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(unitCostField, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(146, 146, 146))
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
                .addComponent(supplierNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(supplierTelephoneNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(supplierTINNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(itemField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(receivedQuantityField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(unitCostField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalCostField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(saveBtn)
                .addContainerGap(77, Short.MAX_VALUE))
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

                    JOptionPane.showMessageDialog(this, "Enter GRN Number", "Add GRN", JOptionPane.ERROR_MESSAGE);

                } else if (supplierNameField.getText().equals("")) {

                    JOptionPane.showMessageDialog(this, "Enter Supplier Name", "Add GRN", JOptionPane.ERROR_MESSAGE);

                } else if (supplierTelephoneNumberField.getText().equals("")) {

                    JOptionPane.showMessageDialog(this, "Enter Supplier Telephone Number", "Add GRN", JOptionPane.ERROR_MESSAGE);

                } else if (supplierTINNumberField.getText().equals("")) {

                    JOptionPane.showMessageDialog(this, "Enter Supplier TIN Number", "Add GRN", JOptionPane.ERROR_MESSAGE);

                } else if (receivedQuantityField.getValue().equals("") || receivedQuantityField.getValue() == null) {

                    JOptionPane.showMessageDialog(this, "Enter Quantity", "Add GRN", JOptionPane.ERROR_MESSAGE);

                } else if (unitCostField.getValue().equals("") || receivedQuantityField.getValue() == null) {

                    JOptionPane.showMessageDialog(this, "Enter Unit Cost", "Add GRN", JOptionPane.ERROR_MESSAGE);

                } else if (GRN.GRNNumberExists(grnNumberField.getText(), "")) {

                    JOptionPane.showMessageDialog(this, "This GRN Number is already in use.", "Add GRN", JOptionPane.ERROR_MESSAGE);

                } /*
                else if (!Validator.isProperDate(dateField)) {

                    JOptionPane.showMessageDialog(this, "This date is not acceptable.", "Add GRN", JOptionPane.ERROR_MESSAGE);

                } else if (!Validator.isNotFutureDate(dateField)) {

                    JOptionPane.showMessageDialog(this, "The date is a future date", "Add GRN", JOptionPane.ERROR_MESSAGE);

                } 
                 */ else if (!Validator.isProperTelephoneNumber(supplierTelephoneNumberField)) {

                    JOptionPane.showMessageDialog(this, "The telephone number is not acceptable", "Add GRN", JOptionPane.ERROR_MESSAGE);

                } else if (!Validator.isProperTINNumber(supplierTINNumberField)) {

                    JOptionPane.showMessageDialog(this, "The tin number is not acceptable", "Add GRN", JOptionPane.ERROR_MESSAGE);

                } else if (!Validator.isNumberGreaterThan(receivedQuantityField, 0)) {

                    JOptionPane.showMessageDialog(this, "The quantity needs to be a valid number greater than 0", "Add GRN", JOptionPane.ERROR_MESSAGE);

                } else if (!Validator.isNumberGreaterThan(unitCostField, 0)) {

                    JOptionPane.showMessageDialog(this, "The unit cost needs to be a valid number greater than 0", "Add GRN", JOptionPane.ERROR_MESSAGE);

                } else {

                    GRN newGRN = new GRN(grnNumberField.getText(), (Date) dateField.getValue(), supplierNameField.getText(), supplierTelephoneNumberField.getText(), supplierTINNumberField.getText(), Session.getLoggedInUser(), listedItems[itemField.getSelectedIndex()], (double) receivedQuantityField.getValue(), (double) receivedQuantityField.getValue(), (double) receivedQuantityField.getValue());
                    if (newGRN.save()) {

                        JOptionPane.showMessageDialog(this, "GRN Registered Succesfully", "Add Item", JOptionPane.INFORMATION_MESSAGE);
                        form.setVisible(false);
                        loadData();
                    } else {
                        JOptionPane.showMessageDialog(this, "GRN Registeration Failed", "Add Item", JOptionPane.ERROR_MESSAGE);

                    }

                }
            } else {

            }

        } catch (SQLException | ParseException ex) {
            Logger.getLogger(GRNs.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_saveBtnActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed

        try {
            loadItemField();
            newForm = true;
            form.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Items.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_addBtnActionPerformed

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed

        try {
            newForm = false;
            clearForm();
            loadItemField();

            grnNumberField.setText(selectedGRN.getGRNNumber());

            form.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Items.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_editBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed

        try {
            if (!selectedGRN.canDelete()) {

                JOptionPane.showMessageDialog(this, "You can not delete this " + selectedGRN.getGRNNumber() + " because you dont have sufficient quantity of " + selectedGRN.getItem().getName() + " !", "Delete Item", JOptionPane.ERROR_MESSAGE);
            } else {

                if (JOptionPane.showConfirmDialog(this, "Are You Sure You Want To Delete " + selectedGRN.getGRNNumber() + "?", "Delete Item Category", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {

                    if (selectedGRN.delete()) {
                        JOptionPane.showMessageDialog(this, selectedGRN.getGRNNumber() + " deleted succesfully!", "Delete Item", JOptionPane.INFORMATION_MESSAGE);
                        loadData();
                    } else {
                        JOptionPane.showMessageDialog(this, "Deleting " + selectedGRN.getGRNNumber() + " failed!", "Delete Item Category", JOptionPane.ERROR_MESSAGE);
                    }
                } else {

                }

            }
        } catch (SQLException e) {

        } catch (ParseException ex) {
            Logger.getLogger(GRNs.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void refreshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshBtnActionPerformed
        try {
            // TODO add your handling code here:
            loadData();
        } catch (SQLException ex) {
            Logger.getLogger(Items.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(GRNs.class.getName()).log(Level.SEVERE, null, ex);
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

    private void receivedQuantityFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_receivedQuantityFieldKeyReleased
        setTotalCost();
    }//GEN-LAST:event_receivedQuantityFieldKeyReleased

    private void unitCostFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_unitCostFieldKeyReleased
        setTotalCost();
    }//GEN-LAST:event_unitCostFieldKeyReleased

    void loadItemField(String selectedItemName) throws SQLException {

        listedItems = Item.findAll();

        for (Item item : listedItems) {

            itemField.addItem(item.getName());

            if (selectedItemName.equals(item.getName())) {

                itemField.setSelectedItem(selectedItemName);
            }

        }

    }

    void loadItemField() throws SQLException {

        listedItems = Item.findAll();

        for (Item itemCategory : listedItems) {

            itemField.addItem(itemCategory.getName());

        }

    }

    void loadData() throws SQLException, ParseException {

        editBtn.setEnabled(false);

        deleteBtn.setEnabled(false);

        String tableColumns[] = {"No", "GRN Number", "Date", "Supplier Name", "Supplier Telephone", "Supplier TIN", "User", "Item", "Received Quantity", "Unit Cost", "Total Cost"};

        GRN[] grns = GRN.findAll();

        Object tableDataRows[][] = new Object[grns.length][11];

        int numberOfRows = 0;

        for (GRN grn : grns) {

            tableDataRows[numberOfRows][0] = (numberOfRows + 1);
            tableDataRows[numberOfRows][1] = grn.getGRNNumber();
            tableDataRows[numberOfRows][2] = grn.getDate();
            tableDataRows[numberOfRows][3] = grn.getSupplierName();
            tableDataRows[numberOfRows][4] = grn.getSupplierTelephone();
            tableDataRows[numberOfRows][5] = grn.getSupplierTIN();
            tableDataRows[numberOfRows][6] = grn.getUser().getUserName();
            tableDataRows[numberOfRows][7] = grn.getItem().getName();
            tableDataRows[numberOfRows][8] = grn.getReceivedQuantity();
            tableDataRows[numberOfRows][9] = grn.getUnitCost();
            tableDataRows[numberOfRows][10] = grn.getTotalCost();

            numberOfRows++;
        }

        TableModel itemCategoriesTableModel = new DefaultTableModel(tableDataRows, tableColumns);

        table.setModel(itemCategoriesTableModel);

        ListSelectionModel itemCategoriesTableSelectionModel = table.getSelectionModel();

        tableRowSorter = new TableRowSorter(table.getModel());

        table.setRowSorter(tableRowSorter);

        itemCategoriesTableSelectionModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                if (itemCategoriesTableSelectionModel.getMaxSelectionIndex() == -1) {

                    editBtn.setEnabled(false);

                    deleteBtn.setEnabled(false);

                } else {

                    editBtn.setEnabled(true);

                    deleteBtn.setEnabled(true);
                    selectedGRN = grns[e.getFirstIndex()];
                }
            }
        });

    }

    void setTotalCost() {

        totalCostField.setValue(((double) unitCostField.getValue() * (double) receivedQuantityField.getValue()));

    }

    void clearForm() throws SQLException {

        loadItemField();

        grnNumberField.setText("");

        supplierNameField.setText("");
        supplierTelephoneNumberField.setText("");
        supplierTINNumberField.setText("");

        dateField.setValue(new Date());
        itemField.setSelectedIndex(0);
        receivedQuantityField.setValue(0);
        unitCostField.setValue(0);
        totalCostField.setValue(0);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JSpinner dateField;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton editBtn;
    private javax.swing.JFrame form;
    private javax.swing.JTextField grnNumberField;
    private javax.swing.JComboBox<String> itemField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JSpinner receivedQuantityField;
    private javax.swing.JButton refreshBtn;
    private javax.swing.JButton saveBtn;
    private javax.swing.JTextField searchField;
    private javax.swing.JTextField supplierNameField;
    private javax.swing.JTextField supplierTINNumberField;
    private javax.swing.JTextField supplierTelephoneNumberField;
    private javax.swing.JTable table;
    private javax.swing.JSpinner totalCostField;
    private javax.swing.JSpinner unitCostField;
    // End of variables declaration//GEN-END:variables
}
