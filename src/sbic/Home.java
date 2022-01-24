/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sbic;

import java.awt.Color;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import static sbic.Items.tableRowSorter;

/**
 *
 * @author YofA
 */
public class Home extends javax.swing.JPanel {

    /**
     * Creates new form Home
     */
    public Home() throws SQLException, ParseException {
        initComponents();
        loadHomeTables();

        homeTab.setBackground(ProgramWindow.primaryColor);
        homeTab.setForeground(ProgramWindow.secondaryColor);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        homeTab = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        todaySalesTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        todayGRNsTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        todayDisposalsTable = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        outOfStockItemsTable = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        belowMinStockItemsTable = new javax.swing.JTable();

        homeTab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeTabMouseClicked(evt);
            }
        });

        todaySalesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(todaySalesTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
        );

        homeTab.addTab("Today's Sales", jPanel1);

        todayGRNsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(todayGRNsTable);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
        );

        homeTab.addTab("Today's GRNs", jPanel2);

        todayDisposalsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(todayDisposalsTable);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
        );

        homeTab.addTab("Today's Disposals", jPanel3);

        outOfStockItemsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(outOfStockItemsTable);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
        );

        homeTab.addTab("Out Of Stock Items", jPanel4);

        belowMinStockItemsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane5.setViewportView(belowMinStockItemsTable);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
        );

        homeTab.addTab("Below Inventory Level Items", jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(homeTab)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 28, Short.MAX_VALUE)
                .addComponent(homeTab, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void homeTabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeTabMouseClicked
        try {
            loadHomeTables();        // 
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_homeTabMouseClicked

    void loadHomeTables() throws SQLException, ParseException {

        loadSalesTable();
        loadGRNsTable();
        loadDisposalsTable();
        loadOutOfStockItems();
        loadBelowMinStockItems();

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable belowMinStockItemsTable;
    private javax.swing.JTabbedPane homeTab;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable outOfStockItemsTable;
    private javax.swing.JTable todayDisposalsTable;
    private javax.swing.JTable todayGRNsTable;
    private javax.swing.JTable todaySalesTable;
    // End of variables declaration//GEN-END:variables

    void loadSalesTable() throws SQLException, ParseException {

        String tableColumns[] = {"No", "Invoice Number", "Date", "Customer TIN", "User", "Item", "Sold Quantity", "Unit Price", "Total Price"};

        Sale[] sales = Sale.findAllToday();

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

        TableModel homeTableModel = new DefaultTableModel(tableDataRows, tableColumns);

        todaySalesTable.setModel(homeTableModel);

        tableRowSorter = new TableRowSorter(todaySalesTable.getModel());

        todaySalesTable.setRowSorter(tableRowSorter);

        homeTab.setTitleAt(0, "Today's Sales (" + sales.length + ")");
    }

    void loadGRNsTable() throws SQLException, ParseException {

        String tableColumns[] = {"No", "GRN Number", "Date", "Supplier Name", "Supplier Telephone", "Supplier TIN", "User", "Item", "Received Quantity", "Unit Cost", "Total Cost"};

        GRN[] grns = GRN.findAllToday();

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

        TableModel homeTableModel = new DefaultTableModel(tableDataRows, tableColumns){
        
            @Override
            public boolean isCellEditable(int row, int column){
            return false;
            }
        };

        todayGRNsTable.setModel(homeTableModel);

        tableRowSorter = new TableRowSorter(todayGRNsTable.getModel());

        todayGRNsTable.setRowSorter(tableRowSorter);

        homeTab.setTitleAt(1, "Today's GRNs (" + grns.length + ")");
    }

    void loadDisposalsTable() throws SQLException, ParseException {
        String tableColumns[] = {"No", "Disposal Number", "Date", "Description", "User", "Item", "Disposed Quantity"};

        Disposal[] disposals = Disposal.findAllToday();

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

        TableModel homeTableModel = new DefaultTableModel(tableDataRows, tableColumns){
        
            @Override
            public boolean isCellEditable(int row, int column){
            return false;
            }
        };

        todayDisposalsTable.setModel(homeTableModel);

        ListSelectionModel homeTableSelectionModel = todayDisposalsTable.getSelectionModel();

        tableRowSorter = new TableRowSorter(todayDisposalsTable.getModel());

        todayDisposalsTable.setRowSorter(tableRowSorter);

        homeTab.setTitleAt(2, "Today's Disposals (" + disposals.length + ")");
    }

    void loadOutOfStockItems() throws SQLException {

        String tableColumns[] = {"No", "Code", "Name", "Item Category", "Unit Of Measurement", "Unit Price", "Quantity At Hand", "Minimum Stock Level", "Description"};

        Item[] items = Item.findOutOfStock();

        Object tableDataRows[][] = new Object[items.length][9];

        int numberOfRows = 0;

        for (Item item : items) {

            tableDataRows[numberOfRows][0] = (numberOfRows + 1);
            tableDataRows[numberOfRows][1] = item.getCode();
            tableDataRows[numberOfRows][2] = item.getName();
            tableDataRows[numberOfRows][3] = item.getItemCategory().getName();
            tableDataRows[numberOfRows][4] = item.getUom();
            tableDataRows[numberOfRows][5] = item.getUnitPrice();
            tableDataRows[numberOfRows][6] = item.getQuantityAtHand();
            tableDataRows[numberOfRows][7] = item.getMinStockLevel();
            tableDataRows[numberOfRows][8] = item.getDescription();

            numberOfRows++;
        }

        TableModel homeTableModel = new DefaultTableModel(tableDataRows, tableColumns){
        
            @Override
            public boolean isCellEditable(int row, int column){
            return false;
            }
        };

        outOfStockItemsTable.setModel(homeTableModel);

        tableRowSorter = new TableRowSorter(outOfStockItemsTable.getModel());

        outOfStockItemsTable.setRowSorter(tableRowSorter);

        homeTab.setTitleAt(3, "Out Of Stock Items (" + items.length + ")");
    }

    void loadBelowMinStockItems() throws SQLException {

        String tableColumns[] = {"No", "Code", "Name", "Item Category", "Unit Of Measurement", "Unit Price", "Quantity At Hand", "Minimum Stock Level", "Description"};

        Item[] items = Item.findBelowMinStock();

        Object tableDataRows[][] = new Object[items.length][9];

        int numberOfRows = 0;

        for (Item item : items) {

            tableDataRows[numberOfRows][0] = (numberOfRows + 1);
            tableDataRows[numberOfRows][1] = item.getCode();
            tableDataRows[numberOfRows][2] = item.getName();
            tableDataRows[numberOfRows][3] = item.getItemCategory().getName();
            tableDataRows[numberOfRows][4] = item.getUom();
            tableDataRows[numberOfRows][5] = item.getUnitPrice();
            tableDataRows[numberOfRows][6] = item.getQuantityAtHand();
            tableDataRows[numberOfRows][7] = item.getMinStockLevel();
            tableDataRows[numberOfRows][8] = item.getDescription();

            numberOfRows++;
        }

        TableModel homeTableModel = new DefaultTableModel(tableDataRows, tableColumns){
        
            @Override
            public boolean isCellEditable(int row, int column){
            return false;
            }
        };

        belowMinStockItemsTable.setModel(homeTableModel);

        tableRowSorter = new TableRowSorter(belowMinStockItemsTable.getModel());

        belowMinStockItemsTable.setRowSorter(tableRowSorter);
        
         homeTab.setTitleAt(4, "Below Inventory Level Items (" + items.length + ")");

    }
}
