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

/**
 *
 * @author Yoftahe
 */
public class Sales extends javax.swing.JPanel {

    static TableRowSorter tableRowSorter;

    static boolean newForm;
    static Item[] listedItems;

    static Sale selectedSale;

    /**
     * Creates new form Sales
     */
    public Sales() throws SQLException, ParseException {
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
        invoiceNumberField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        customerTINNumberField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        itemField = new javax.swing.JComboBox<>();
        soldQuantityField = new javax.swing.JSpinner();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        unitPriceField = new javax.swing.JSpinner();
        jLabel11 = new javax.swing.JLabel();
        totalPriceField = new javax.swing.JSpinner();
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

        jLabel1.setText("Add \\ Edit Sale");

        jLabel2.setText("Invoice Number");

        jLabel3.setText("Date (dd/mm/yyyy)");

        jLabel7.setText("Customer TIN Number");

        jLabel8.setText("Item");

        soldQuantityField.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, 1.0E7d, 1.0d));
        soldQuantityField.setEditor(new javax.swing.JSpinner.NumberEditor(soldQuantityField, ""));

        jLabel9.setText("Quantity");

        jLabel10.setText("Unit Price");

        unitPriceField.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, 1.0E7d, 1.0d));

        jLabel11.setText("Total Price");

        totalPriceField.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, 1.0E7d, 1.0d));
        totalPriceField.setEnabled(false);

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
                            .addComponent(totalPriceField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dateField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(customerTINNumberField)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(invoiceNumberField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(itemField, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(soldQuantityField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(unitPriceField, javax.swing.GroupLayout.Alignment.LEADING))
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
                .addComponent(invoiceNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(customerTINNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(itemField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(soldQuantityField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(unitPriceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalPriceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(saveBtn)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout formLayout = new javax.swing.GroupLayout(form.getContentPane());
        form.getContentPane().setLayout(formLayout);
        formLayout.setHorizontalGroup(
            formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        formLayout.setVerticalGroup(
            formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, formLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(171, 171, 171))
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

                if (invoiceNumberField.getText().equals("")) {

                    JOptionPane.showMessageDialog(this, "Enter Sale Number", "Add Sale", JOptionPane.ERROR_MESSAGE);

                }  else if (soldQuantityField.getValue().equals("") || soldQuantityField.getValue() == null) {

                    JOptionPane.showMessageDialog(this, "Enter Quantity", "Add Sale", JOptionPane.ERROR_MESSAGE);

                } else if (unitPriceField.getValue().equals("") || soldQuantityField.getValue() == null) {

                    JOptionPane.showMessageDialog(this, "Enter Unit Price", "Add Sale", JOptionPane.ERROR_MESSAGE);

                } else if (Sale.invoiceNumberExists(invoiceNumberField.getText(), "")) {

                    JOptionPane.showMessageDialog(this, "This Sale Number is already in use.", "Add Sale", JOptionPane.ERROR_MESSAGE);

                } else if (!Validator.isProperTINNumber(customerTINNumberField) && !customerTINNumberField.equals("")) {

                    JOptionPane.showMessageDialog(this, "The tin number is not acceptable", "Add Sale", JOptionPane.ERROR_MESSAGE);

                } else if (!Validator.isNumberGreaterThan(soldQuantityField, 0)) {

                    JOptionPane.showMessageDialog(this, "The quantity needs to be a valid number greater than 0", "Add Sale", JOptionPane.ERROR_MESSAGE);

                } else if (!Validator.isNumberGreaterThan(unitPriceField, 0)) {

                    JOptionPane.showMessageDialog(this, "The unit cost needs to be a valid number greater than 0", "Add Sale", JOptionPane.ERROR_MESSAGE);

                } else {

                    setTotalPrice();
                    Sale newSale = new Sale(invoiceNumberField.getText(), (Date) dateField.getValue(), customerTINNumberField.getText(), Session.getLoggedInUser(), listedItems[itemField.getSelectedIndex()], (double) soldQuantityField.getValue(), (double) unitPriceField.getValue(), (double) totalPriceField.getValue());

                    if (newSale.save()) {

                        JOptionPane.showMessageDialog(this, "Sale Registered Succesfully", "Add Sale", JOptionPane.INFORMATION_MESSAGE);
                        form.setVisible(false);
                        loadData();
                    } else {
                        JOptionPane.showMessageDialog(this, "Sale Registration Failed", "Add Sale", JOptionPane.ERROR_MESSAGE);

                    }

                }
            } else {

                if (invoiceNumberField.getText().equals("")) {

                    JOptionPane.showMessageDialog(this, "Enter Sale Number", "Edit Sale", JOptionPane.ERROR_MESSAGE);

                } else if (soldQuantityField.getValue().equals("") || soldQuantityField.getValue() == null) {

                    JOptionPane.showMessageDialog(this, "Enter Quantity", "Edit Sale", JOptionPane.ERROR_MESSAGE);

                } else if (unitPriceField.getValue().equals("") || soldQuantityField.getValue() == null) {

                    JOptionPane.showMessageDialog(this, "Enter Unit Price", "Edit Sale", JOptionPane.ERROR_MESSAGE);

                } else if (Sale.invoiceNumberExists(invoiceNumberField.getText(), selectedSale.getInvoiceNumber())) {

                    JOptionPane.showMessageDialog(this, "This Sale Number is already in use.", "Edit Sale", JOptionPane.ERROR_MESSAGE);

                } else if (!Validator.isProperTINNumber(customerTINNumberField) && !customerTINNumberField.equals("")) {

                    JOptionPane.showMessageDialog(this, "The tin number is not acceptable", "Add Sale", JOptionPane.ERROR_MESSAGE);

                }else if (!Validator.isNumberGreaterThan(soldQuantityField, 0)) {

                    JOptionPane.showMessageDialog(this, "The quantity needs to be a valid number greater than 0", "Edit Sale", JOptionPane.ERROR_MESSAGE);

                } else if (!Validator.isNumberGreaterThan(soldQuantityField, (selectedSale.getItem().getQuantityAtHand() + 0.1))) {

                    JOptionPane.showMessageDialog(this, "You can't reduce the quantity more than the available quantity of the item!", "Edit Sale", JOptionPane.ERROR_MESSAGE);

                } else if (!Validator.isNumberGreaterThan(unitPriceField, 0)) {

                    JOptionPane.showMessageDialog(this, "The unit cost needs to be a valid number greater than 0", "Edit Sale", JOptionPane.ERROR_MESSAGE);

                } else {

                    setTotalPrice();
                    selectedSale.setInvoiceNumber(invoiceNumberField.getText());
                    selectedSale.setDate((Date) dateField.getValue());
                    selectedSale.setCustomerTIN(customerTINNumberField.getText());
                    selectedSale.setItem(listedItems[itemField.getSelectedIndex()]);
                    selectedSale.setSoldQuantity((double) soldQuantityField.getValue());
                    selectedSale.setUnitPrice((double) unitPriceField.getValue());
                    selectedSale.setTotalPrice((double) totalPriceField.getValue());

                    if (selectedSale.save()) {

                        JOptionPane.showMessageDialog(this, "Sale Updated Succesfully", "Edit Sale", JOptionPane.INFORMATION_MESSAGE);
                        form.setVisible(false);
                        loadData();
                    } else {
                        JOptionPane.showMessageDialog(this, "Sale Update Failed", "Edit Sale", JOptionPane.ERROR_MESSAGE);

                    }

                }

            }

        } catch (SQLException | ParseException ex) {
            Logger.getLogger(Sales.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_saveBtnActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed

        try {
            clearForm();
            loadItemField();

            newForm = true;

            invoiceNumberField.setEnabled(true);
            dateField.setEnabled(true);
            itemField.setEnabled(true);
            soldQuantityField.setEnabled(true);
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

            invoiceNumberField.setText(selectedSale.getInvoiceNumber());
            dateField.setValue(selectedSale.getDate());
            customerTINNumberField.setText(selectedSale.getCustomerTIN());

            itemField.setSelectedItem(selectedSale.getItem().getName());

            customerTINNumberField.setText(selectedSale.getCustomerTIN());

            soldQuantityField.setValue(selectedSale.getSoldQuantity());
            unitPriceField.setValue(selectedSale.getUnitPrice());
            totalPriceField.setValue(selectedSale.getTotalPrice());

            //Lock some Fields For Data Integrity Purposes
            invoiceNumberField.setEnabled(false);
            dateField.setEnabled(false);
            itemField.setEnabled(false);
            soldQuantityField.setEnabled(false);

            form.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Items.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_editBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed

        try {
            if (!selectedSale.canDelete()) {

                JOptionPane.showMessageDialog(this, "You can not delete this " + selectedSale.getInvoiceNumber() + " because you dont have sufficient quantity of " + selectedSale.getItem().getName() + " !", "Delete Sale", JOptionPane.ERROR_MESSAGE);
            } else {

                if (JOptionPane.showConfirmDialog(this, "Are You Sure You Want To Delete " + selectedSale.getInvoiceNumber() + "? It will increase the amount of " + selectedSale.getItem().getName() + " by " + selectedSale.getSoldQuantity(), "Delete Sale", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {

                    if (selectedSale.delete()) {
                        JOptionPane.showMessageDialog(this, selectedSale.getInvoiceNumber() + " deleted succesfully!", "Delete Sale", JOptionPane.INFORMATION_MESSAGE);
                        loadData();
                    } else {
                        JOptionPane.showMessageDialog(this, "Deleting " + selectedSale.getInvoiceNumber() + " failed!", "Delete Sale", JOptionPane.ERROR_MESSAGE);
                    }
                } else {

                }

            }
        } catch (SQLException e) {

        } catch (ParseException ex) {
            Logger.getLogger(Sales.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void refreshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshBtnActionPerformed
        try {
            // TODO add your handling code here:
            loadData();
        } catch (SQLException ex) {
            Logger.getLogger(Items.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Sales.class.getName()).log(Level.SEVERE, null, ex);
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

        editBtn.setEnabled(false);

        deleteBtn.setEnabled(false);

        String tableColumns[] = {"No", "Invoice Number", "Date", "Customer TIN", "User", "Item", "Sold Quantity", "Unit Price", "Total Price"};

        Sale[] sales = Sale.findAll();

        Object tableDataRows[][] = new Object[sales.length][9];

        int numberOfRows = 0;

        for (Sale sale : sales) {

            tableDataRows[numberOfRows][0] = (numberOfRows + 1);
            tableDataRows[numberOfRows][1] = sale.getInvoiceNumber();
            tableDataRows[numberOfRows][2] = sale.getDate();
            tableDataRows[numberOfRows][3] = sale.getCustomerTIN();
            tableDataRows[numberOfRows][4] = sale.getUser().getUserName();
            tableDataRows[numberOfRows][5] = sale.getItem().getName();
            tableDataRows[numberOfRows][6] = sale.getSoldQuantity();
            tableDataRows[numberOfRows][7] = sale.getUnitPrice();
            tableDataRows[numberOfRows][8] = sale.getTotalPrice();

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
                    selectedSale = sales[itemCategoriesTableSelectionModel.getMaxSelectionIndex()];

                    System.out.println(itemCategoriesTableSelectionModel.getMaxSelectionIndex() + " from " + sales.length);

                }
            }
        });

    }

    void setTotalPrice() {

        System.out.println("total Cost Update");

        double unitCost = Double.valueOf(unitPriceField.getValue().toString());
        double receivedQuantity = Double.valueOf(unitPriceField.getValue().toString());

        totalPriceField.setValue((unitCost * receivedQuantity));

    }

    void clearForm() throws SQLException {

        loadItemField();

        invoiceNumberField.setText("");

        customerTINNumberField.setText("");

        dateField.setValue(new Date());
        itemField.setSelectedIndex(0);
        soldQuantityField.setValue(0);
        unitPriceField.setValue(0);
        totalPriceField.setValue(0);

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JTextField customerTINNumberField;
    private javax.swing.JSpinner dateField;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton editBtn;
    private javax.swing.JFrame form;
    private javax.swing.JTextField invoiceNumberField;
    private javax.swing.JComboBox<String> itemField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton refreshBtn;
    private javax.swing.JButton saveBtn;
    private javax.swing.JTextField searchField;
    private javax.swing.JSpinner soldQuantityField;
    private javax.swing.JTable table;
    private javax.swing.JSpinner totalPriceField;
    private javax.swing.JSpinner unitPriceField;
    // End of variables declaration//GEN-END:variables
}
