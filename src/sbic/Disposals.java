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
public class Disposals extends javax.swing.JPanel {

    static TableRowSorter tableRowSorter;

    static boolean newForm;
    static Item[] listedItems;

    static Disposal selectedDisposal;

    /**
     * Creates new form Disposals
     */
    public Disposals() throws SQLException, ParseException {
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
        disposalNumberField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        itemField = new javax.swing.JComboBox<>();
        disposedQuantity = new javax.swing.JSpinner();
        jLabel9 = new javax.swing.JLabel();
        saveBtn = new javax.swing.JButton();
        dateField = new javax.swing.JSpinner();
        jScrollPane2 = new javax.swing.JScrollPane();
        descriptionField = new javax.swing.JTextArea();
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

        jLabel1.setText("Add \\ Edit Disposal");

        jLabel2.setText("Disposal Number");

        jLabel3.setText("Date (dd/mm/yyyy)");

        jLabel7.setText("Description");

        jLabel8.setText("Item");

        disposedQuantity.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, 1.0E7d, 1.0d));
        disposedQuantity.setEditor(new javax.swing.JSpinner.NumberEditor(disposedQuantity, ""));

        jLabel9.setText("Quantity");

        saveBtn.setText("Save");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        dateField.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), null, new java.util.Date(), java.util.Calendar.DAY_OF_MONTH));

        descriptionField.setColumns(20);
        descriptionField.setRows(5);
        jScrollPane2.setViewportView(descriptionField);

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
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dateField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(disposalNumberField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(itemField, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(disposedQuantity, javax.swing.GroupLayout.Alignment.LEADING))
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
                .addComponent(disposalNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(itemField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(disposedQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(saveBtn)
                .addContainerGap(104, Short.MAX_VALUE))
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

                if (disposalNumberField.getText().equals("")) {

                    JOptionPane.showMessageDialog(this, "Enter Disposal Number", "Add Disposal", JOptionPane.ERROR_MESSAGE);

                } else if (descriptionField.getText().equals("")) {

                    JOptionPane.showMessageDialog(this, "Enter Description (Reason) Number", "Add Disposal", JOptionPane.ERROR_MESSAGE);

                } else if (disposedQuantity.getValue().equals("") || disposedQuantity.getValue() == null) {

                    JOptionPane.showMessageDialog(this, "Enter Quantity", "Add Disposal", JOptionPane.ERROR_MESSAGE);

                }  else if (!Validator.properDocumentNumber(disposalNumberField)) {

                    JOptionPane.showMessageDialog(this, "Disposal Number can't be longer than 10 characters", "Add GRN", JOptionPane.ERROR_MESSAGE);

                }else if (Disposal.disposalNumberExists(disposalNumberField.getText(), "")) {

                    JOptionPane.showMessageDialog(this, "This Disposal Number is already in use.", "Add Disposal", JOptionPane.ERROR_MESSAGE);

                } else if (!Validator.isNumberGreaterThan(disposedQuantity, 0)) {

                    JOptionPane.showMessageDialog(this, "The quantity needs to be a valid number greater than 0", "Add Disposal", JOptionPane.ERROR_MESSAGE);

                } else {

                    Disposal newDisposal = new Disposal(disposalNumberField.getText(), (Date) dateField.getValue(), descriptionField.getText(), Session.getLoggedInUser(), listedItems[itemField.getSelectedIndex()], (double) disposedQuantity.getValue());

                    if (newDisposal.save()) {

                        JOptionPane.showMessageDialog(this, "Disposal Registered Succesfully", "Add Disposal", JOptionPane.INFORMATION_MESSAGE);
                        form.setVisible(false);
                        loadData();
                    } else {
                        JOptionPane.showMessageDialog(this, "Disposal Registeration Failed", "Add Disposal", JOptionPane.ERROR_MESSAGE);

                    }

                }
            } else {

                if (disposalNumberField.getText().equals("")) {

                    JOptionPane.showMessageDialog(this, "Enter Disposal Number", "Edit Disposal", JOptionPane.ERROR_MESSAGE);

                } else if (descriptionField.getText().equals("")) {

                    JOptionPane.showMessageDialog(this, "Enter Description (Reason) Number", "Edit Disposal", JOptionPane.ERROR_MESSAGE);

                } else if (disposedQuantity.getValue().equals("") || disposedQuantity.getValue() == null) {

                    JOptionPane.showMessageDialog(this, "Enter Quantity", "Edit Disposal", JOptionPane.ERROR_MESSAGE);

                } else if (!Validator.properDocumentNumber(disposalNumberField)) {

                    JOptionPane.showMessageDialog(this, "Disposal Number can't be longer than 10 characters", "Add GRN", JOptionPane.ERROR_MESSAGE);

                }else if (Disposal.disposalNumberExists(disposalNumberField.getText(), selectedDisposal.getDisposalNumber())) {

                    JOptionPane.showMessageDialog(this, "This Disposal Number is already in use.", "Edit Disposal", JOptionPane.ERROR_MESSAGE);

                } else if (!Validator.isNumberGreaterThan(disposedQuantity, 0)) {

                    JOptionPane.showMessageDialog(this, "The quantity needs to be a valid number greater than 0", "Edit Disposal", JOptionPane.ERROR_MESSAGE);

                } else if (!Validator.isNumberGreaterThan(disposedQuantity, (selectedDisposal.getItem().getQuantityAtHand() + 0.1))) {

                    JOptionPane.showMessageDialog(this, "You can't reduce the quantity more than the available quantity of the item!", "Edit Disposal", JOptionPane.ERROR_MESSAGE);

                } else {

                    selectedDisposal.setDisposalNumber(disposalNumberField.getText());
                    selectedDisposal.setDate((Date) dateField.getValue());
                    selectedDisposal.setDescription(descriptionField.getText());
                    selectedDisposal.setItem(listedItems[itemField.getSelectedIndex()]);
                    selectedDisposal.setDisposedQuantity((double) disposedQuantity.getValue());

                    if (selectedDisposal.save()) {

                        JOptionPane.showMessageDialog(this, "Disposal Updated Succesfully", "Edit Disposal", JOptionPane.INFORMATION_MESSAGE);
                        form.setVisible(false);
                        loadData();
                    } else {
                        JOptionPane.showMessageDialog(this, "Disposal Update Failed", "Edit Disposal", JOptionPane.ERROR_MESSAGE);

                    }

                }

            }

        } catch (SQLException | ParseException ex) {
            Logger.getLogger(Disposals.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_saveBtnActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed

        try {
            clearForm();
            if (itemField.getItemCount() > 0) {

                newForm = true;

                disposalNumberField.setEnabled(true);
                dateField.setEnabled(true);
                itemField.setEnabled(true);
                disposedQuantity.setEnabled(true);
                form.setVisible(true);

            } else {
                JOptionPane.showMessageDialog(this, "You can't add a Disposal because there are no items.", "Add GRN", JOptionPane.ERROR_MESSAGE);

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

            disposalNumberField.setText(selectedDisposal.getDisposalNumber());
            dateField.setValue(selectedDisposal.getDate());
            itemField.setSelectedItem(selectedDisposal.getItem().getName());
            descriptionField.setText(selectedDisposal.getDescription());
            disposedQuantity.setValue(selectedDisposal.getDisposedQuantity());

            //Lock some Fields For Data Integrity Purposes
            disposalNumberField.setEnabled(false);
            dateField.setEnabled(false);
            itemField.setEnabled(false);
            disposedQuantity.setEnabled(false);

            form.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Items.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_editBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed

        try {
            if (!selectedDisposal.canDelete()) {

                JOptionPane.showMessageDialog(this, "You can not delete this " + selectedDisposal.getDisposalNumber() + " because you dont have sufficient quantity of " + selectedDisposal.getItem().getName() + " !", "Delete Disposal", JOptionPane.ERROR_MESSAGE);
            } else {

                if (JOptionPane.showConfirmDialog(this, "Are You Sure You Want To Delete " + selectedDisposal.getDisposalNumber() + "? It will increase the amount of " + selectedDisposal.getItem().getName() + " by " + selectedDisposal.getDisposedQuantity(), "Delete Disposal", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {

                    if (selectedDisposal.delete()) {
                        JOptionPane.showMessageDialog(this, selectedDisposal.getDisposalNumber() + " deleted succesfully!", "Delete Disposal", JOptionPane.INFORMATION_MESSAGE);
                        loadData();
                    } else {
                        JOptionPane.showMessageDialog(this, "Deleting " + selectedDisposal.getDisposalNumber() + " failed!", "Delete Disposal", JOptionPane.ERROR_MESSAGE);
                    }
                } else {

                }

            }
        } catch (SQLException e) {

        } catch (ParseException ex) {
            Logger.getLogger(Disposals.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void refreshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshBtnActionPerformed
        try {
            // TODO add your handling code here:
            loadData();
        } catch (SQLException ex) {
            Logger.getLogger(Items.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Disposals.class.getName()).log(Level.SEVERE, null, ex);
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
        
         if(!Session.getLoggedInUser().getRole().equals("Administrator")){
        
            addBtn.setEnabled(false);
        }


        editBtn.setEnabled(false);

        deleteBtn.setEnabled(false);

        String tableColumns[] = {"No", "Disposal Number", "Date", "Description", "User", "Item", "Disposed Quantity"};

        Disposal[] disposals = Disposal.findAll();

        Object tableDataRows[][] = new Object[disposals.length][7];

        int numberOfRows = 0;

        for (Disposal disposal : disposals) {

            tableDataRows[numberOfRows][0] = (numberOfRows + 1);
            tableDataRows[numberOfRows][1] = disposal.getDisposalNumber();
            tableDataRows[numberOfRows][2] = disposal.getDate();
            tableDataRows[numberOfRows][3] = disposal.getDescription();
            tableDataRows[numberOfRows][4] = disposal.getUser().getUserName();
            tableDataRows[numberOfRows][5] = disposal.getItem().getName();
            tableDataRows[numberOfRows][6] = disposal.getDisposedQuantity();

            numberOfRows++;
        }

        TableModel DisposalsTableModel = new DefaultTableModel(tableDataRows, tableColumns);

        table.setModel(DisposalsTableModel);

        ListSelectionModel DisposalsTableSelectionModel = table.getSelectionModel();

        tableRowSorter = new TableRowSorter(table.getModel());

        table.setRowSorter(tableRowSorter);

        DisposalsTableSelectionModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                if (DisposalsTableSelectionModel.getMaxSelectionIndex() == -1) {

                    editBtn.setEnabled(false);

                    deleteBtn.setEnabled(false);

                } else {

                    if (Session.getLoggedInUser().getRole() == "Administrator") {
                        editBtn.setEnabled(true);

                        deleteBtn.setEnabled(true);
                    }
                    selectedDisposal = disposals[DisposalsTableSelectionModel.getMaxSelectionIndex()];

                    System.out.println(DisposalsTableSelectionModel.getMaxSelectionIndex() + " from " + disposals.length);

                }
            }
        });

    }

    void clearForm() throws SQLException {

        loadItemField();

        disposalNumberField.setText("");

        descriptionField.setText("");

        dateField.setValue(new Date());

        if (itemField.getItemCount() > 0) {
            itemField.setSelectedIndex(0);
        }

        disposedQuantity.setValue(0);

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JSpinner dateField;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JTextArea descriptionField;
    private javax.swing.JTextField disposalNumberField;
    private javax.swing.JSpinner disposedQuantity;
    private javax.swing.JButton editBtn;
    private javax.swing.JFrame form;
    private javax.swing.JComboBox<String> itemField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton refreshBtn;
    private javax.swing.JButton saveBtn;
    private javax.swing.JTextField searchField;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
