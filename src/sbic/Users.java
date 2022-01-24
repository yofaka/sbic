/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sbic;

import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Arrays;
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
public class Users extends javax.swing.JPanel {

    static TableRowSorter tableRowSorter;

    static boolean newForm;
    static Item[] listedItems;

    static User selectedUser;
    static User[] users;

    /**
     * Creates new form Users
     */
    public Users() throws SQLException, ParseException {
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
        userNameField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        roleField = new javax.swing.JComboBox<>();
        saveBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        confirmPasswordField = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        activeField = new javax.swing.JComboBox<>();
        passwordResetForm = new javax.swing.JFrame();
        jPanel1 = new javax.swing.JPanel();
        resetPasswordField = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        resetConfirmPasswordField = new javax.swing.JPasswordField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        saveResetPasswordBtn = new javax.swing.JButton();
        addBtn = new javax.swing.JButton();
        editBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        refreshBtn = new javax.swing.JButton();
        searchField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        resetPasswordBtn = new javax.swing.JButton();

        form.setResizable(false);
        form.setSize(new java.awt.Dimension(400, 500));

        jLabel1.setText("Add User");

        jLabel2.setText("User Name");

        jLabel8.setText("Role");

        roleField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrator", "Sales\t" }));

        saveBtn.setText("Save");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        jLabel3.setText("Password");

        jLabel5.setText("Confirm Password");

        jLabel6.setText("Active");

        activeField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Active", "Inactive" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(127, 127, 127)
                                .addComponent(saveBtn))
                            .addComponent(confirmPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6))
                        .addGap(0, 172, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(activeField, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(passwordField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(userNameField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(roleField, javax.swing.GroupLayout.Alignment.LEADING, 0, 188, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                .addComponent(userNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roleField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(6, 6, 6)
                .addComponent(activeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(confirmPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(saveBtn)
                .addContainerGap(221, Short.MAX_VALUE))
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
                .addGap(0, 0, 0))
        );

        passwordResetForm.setTitle("Reset User Password");
        passwordResetForm.setResizable(false);
        passwordResetForm.setSize(new java.awt.Dimension(400, 300));

        jLabel7.setText("Password");

        jLabel9.setText("Confirm Password");

        jLabel10.setText("Reset Password");

        saveResetPasswordBtn.setText("Save");
        saveResetPasswordBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveResetPasswordBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(saveResetPasswordBtn)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9)
                            .addComponent(resetConfirmPasswordField, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                            .addComponent(resetPasswordField))))
                .addContainerGap(208, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(resetPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(resetConfirmPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(saveResetPasswordBtn)
                .addContainerGap(69, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout passwordResetFormLayout = new javax.swing.GroupLayout(passwordResetForm.getContentPane());
        passwordResetForm.getContentPane().setLayout(passwordResetFormLayout);
        passwordResetFormLayout.setHorizontalGroup(
            passwordResetFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        passwordResetFormLayout.setVerticalGroup(
            passwordResetFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        resetPasswordBtn.setText("Reset Password");
        resetPasswordBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetPasswordBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(212, 212, 212)
                .addComponent(resetPasswordBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(refreshBtn)
                .addContainerGap(278, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 673, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(addBtn)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(editBtn)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(deleteBtn)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(resetPasswordBtn)
                    .addComponent(refreshBtn))
                .addContainerGap(262, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(addBtn)
                        .addComponent(editBtn)
                        .addComponent(deleteBtn)
                        .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addGap(34, 34, 34)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                    .addContainerGap()))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        try {

            boolean isActive = false;
            if (activeField.getSelectedItem().toString().equals("Active")) {
                isActive = true;

            }

            setTotalPrice();
            if (newForm) {

                if (userNameField.getText().equals("")) {

                    JOptionPane.showMessageDialog(this, "Enter User Number", "Add User", JOptionPane.ERROR_MESSAGE);

                } else if (passwordField.getText().equals("")) {

                    JOptionPane.showMessageDialog(this, "Enter Password", "Add User", JOptionPane.ERROR_MESSAGE);

                } else if (confirmPasswordField.getText().equals("")) {

                    JOptionPane.showMessageDialog(this, "Confirm Password", "Add User", JOptionPane.ERROR_MESSAGE);

                } else if (!Validator.isProperUserName(userNameField)) {

                    JOptionPane.showMessageDialog(this, "This User Name can't have longer than 25 digits.", "Add User", JOptionPane.ERROR_MESSAGE);

                } else if (User.userNameExists(userNameField.getText(), "")) {

                    JOptionPane.showMessageDialog(this, "This User Name is already in use.", "Add User", JOptionPane.ERROR_MESSAGE);

                } else if (!passwordField.getText().equals(confirmPasswordField.getText())) {

                    JOptionPane.showMessageDialog(this, "Two Passwords Must Be The Same", "Edit User", JOptionPane.ERROR_MESSAGE);

                } else {

                    User newUser = new User(userNameField.getText(), passwordField.getText().toString(), roleField.getSelectedItem().toString(), isActive);

                    if (newUser.save()) {

                        JOptionPane.showMessageDialog(this, "User Registered Succesfully", "Add User", JOptionPane.INFORMATION_MESSAGE);
                        clearForm();
                        form.setVisible(false);
                        loadData();
                    } else {
                        JOptionPane.showMessageDialog(this, "User Registeration Failed", "Add User", JOptionPane.ERROR_MESSAGE);

                    }

                }
            } else {

                if (userNameField.getText().equals("")) {

                    JOptionPane.showMessageDialog(this, "Enter User Number", "Edit User", JOptionPane.ERROR_MESSAGE);

                } else if (!Validator.isProperUserName(userNameField)) {

                    JOptionPane.showMessageDialog(this, "This User Name can't have longer than 25 digits.", "Add User", JOptionPane.ERROR_MESSAGE);

                } else if (User.userNameExists(userNameField.getText(), selectedUser.getUserName())) {

                    JOptionPane.showMessageDialog(this, "This User Number is already in use.", "Edit User", JOptionPane.ERROR_MESSAGE);

                } else {

                    selectedUser.setUserName(userNameField.getText());
                    selectedUser.setRole(roleField.getSelectedItem().toString());

                    selectedUser.setActive(isActive);

                    if (selectedUser.save()) {

                        JOptionPane.showMessageDialog(this, "User Updated Succesfully", "Edit User", JOptionPane.INFORMATION_MESSAGE);
                        clearForm();
                        form.setVisible(false);
                        loadData();
                    } else {
                        JOptionPane.showMessageDialog(this, "User Update Failed", "Edit User", JOptionPane.ERROR_MESSAGE);

                    }

                }

            }

        } catch (SQLException | ParseException ex) {
            Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_saveBtnActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed

        try {
            clearForm();

            newForm = true;

            passwordField.setEnabled(true);
            confirmPasswordField.setEnabled(true);

            form.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Items.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_addBtnActionPerformed

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed

        try {

            clearForm();
            newForm = false;

            userNameField.setText(selectedUser.getUserName());
            roleField.setSelectedItem(selectedUser.getRole());

            if (selectedUser.isActive()) {
                activeField.setSelectedItem("Active");
            } else {
                activeField.setSelectedItem("Inactive");
            }

            //Lock some Fields For Data Integrity Purposes
            passwordField.setEnabled(false);
            confirmPasswordField.setEnabled(false);

            form.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Items.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_editBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed

        try {
            if (!selectedUser.canDelete()) {

                JOptionPane.showMessageDialog(this, "You can not delete this " + selectedUser.getUserName() + " because it has GRNs, Sales or Disposals attached to it!", "Delete User", JOptionPane.ERROR_MESSAGE);
            } else {

                if (JOptionPane.showConfirmDialog(this, "Are You Sure You Want To Delete " + selectedUser.getUserName() + "? ", "Delete User", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {

                    if (selectedUser.delete()) {
                        JOptionPane.showMessageDialog(this, selectedUser.getUserName() + " deleted succesfully!", "Delete User", JOptionPane.INFORMATION_MESSAGE);
                        loadData();
                    } else {
                        JOptionPane.showMessageDialog(this, "Deleting " + selectedUser.getUserName() + " failed!", "Delete User", JOptionPane.ERROR_MESSAGE);
                    }
                } else {

                }

            }
        } catch (SQLException e) {

        } catch (ParseException ex) {
            Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void refreshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshBtnActionPerformed
        try {
            // TODO add your handling code here:
            loadData();
        } catch (SQLException ex) {
            Logger.getLogger(Items.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
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

    private void resetPasswordBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetPasswordBtnActionPerformed

        resetPasswordField.setText("");
        resetConfirmPasswordField.setText("");

        passwordResetForm.setVisible(true);

    }//GEN-LAST:event_resetPasswordBtnActionPerformed

    private void saveResetPasswordBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveResetPasswordBtnActionPerformed

        if (resetPasswordField.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Enter Password", "Reset User Password", JOptionPane.ERROR_MESSAGE);

        } else if (resetConfirmPasswordField.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Confirm Password", "Reset User Password", JOptionPane.ERROR_MESSAGE);

        } else if (!resetPasswordField.getText().equals(resetConfirmPasswordField.getText())) {
            JOptionPane.showMessageDialog(this, "The two passwords need to be the same!", "Reset User Password", JOptionPane.ERROR_MESSAGE);

        } else {

            try {
                selectedUser.setPassword(resetPasswordField.getText());
                if (selectedUser.savePassword()) {
                    JOptionPane.showMessageDialog(this, "Password reset succefully!", "Reset User Password", JOptionPane.INFORMATION_MESSAGE);
                    passwordResetForm.setVisible(false);

                } else {
                    JOptionPane.showMessageDialog(this, "Password reset failed!", "Reset User Password", JOptionPane.ERROR_MESSAGE);

                }
            } catch (SQLException ex) {
                Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_saveResetPasswordBtnActionPerformed

    void loadData() throws SQLException, ParseException {

        editBtn.setEnabled(false);

        deleteBtn.setEnabled(false);

        String tableColumns[] = {"No", "User Name", "Role", "Active"};

       users = User.findAll();

        Object tableDataRows[][] = new Object[users.length][7];

        int numberOfRows = 0;

        for (User user : users) {

            tableDataRows[numberOfRows][0] = (numberOfRows + 1);
            tableDataRows[numberOfRows][1] = user.getUserName();
            tableDataRows[numberOfRows][2] = user.getRole();
            tableDataRows[numberOfRows][3] = user.getActive();

            numberOfRows++;
        }

        TableModel UsersTableModel = new DefaultTableModel(tableDataRows, tableColumns){
        
            @Override
            public boolean isCellEditable(int row, int column){
            return false;
            }
        };

        table.setModel(UsersTableModel);

        ListSelectionModel UsersTableSelectionModel = table.getSelectionModel();

        tableRowSorter = new TableRowSorter(table.getModel());

        table.setRowSorter(tableRowSorter);

        UsersTableSelectionModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                if (UsersTableSelectionModel.getMaxSelectionIndex() == -1) {

                    editBtn.setEnabled(false);
                    resetPasswordBtn.setEnabled(false);
                    deleteBtn.setEnabled(false);

                } else {

                    editBtn.setEnabled(true);
                    resetPasswordBtn.setEnabled(true);
                    deleteBtn.setEnabled(true);
                    selectedUser = users[UsersTableSelectionModel.getMaxSelectionIndex()];

                    System.out.println(UsersTableSelectionModel.getMaxSelectionIndex() + " from " + users.length);

                }
            }
        });

    }

    void setTotalPrice() {

    }

    void clearForm() throws SQLException {

        userNameField.setText("");
        roleField.setSelectedIndex(0);
        activeField.setSelectedIndex(0);
        passwordField.setText("");
        confirmPasswordField.setText("");

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> activeField;
    private javax.swing.JButton addBtn;
    private javax.swing.JPasswordField confirmPasswordField;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton editBtn;
    private javax.swing.JFrame form;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JFrame passwordResetForm;
    private javax.swing.JButton refreshBtn;
    private javax.swing.JPasswordField resetConfirmPasswordField;
    private javax.swing.JButton resetPasswordBtn;
    private javax.swing.JPasswordField resetPasswordField;
    private javax.swing.JComboBox<String> roleField;
    private javax.swing.JButton saveBtn;
    private javax.swing.JButton saveResetPasswordBtn;
    private javax.swing.JTextField searchField;
    private javax.swing.JTable table;
    private javax.swing.JTextField userNameField;
    // End of variables declaration//GEN-END:variables
}
