/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giao_dien;


import entity.HoaDon;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author LENOVO
 */
public class frm_ThongKe extends javax.swing.JPanel {

    /**
     * Creates new form frm_ThongKe
     */
    public frm_ThongKe() throws ClassNotFoundException, SQLException {
        initComponents();
        LoadData_HoaDon();
    }
    private void LoadData_HoaDon() throws ClassNotFoundException, SQLException{
        List<HoaDon> lst_HoaDon = dao.dao_HoaDon.getAllHD();
        DefaultTableModel tblModel = new DefaultTableModel();
        tblModel.addColumn("Mã Hoá Đơn");
        tblModel.addColumn("Mã nhân viên");
        tblModel.addColumn("Mã Khách Hàng");      
        tblModel.addColumn("Ngày Lập");   
        tblModel.addColumn("Tổng tiền"); 
        for (HoaDon pn : lst_HoaDon) {
            Vector<String> row = new Vector<String>();
            row.addElement(String.valueOf(pn.getMahoadon()));
            row.addElement(String.valueOf(pn.getManhanvien()));
            row.addElement(String.valueOf(pn.getMakhachhang()));   
            row.addElement(pn.getNgaylap());;
            row.addElement(pn.getTongtien());;
            tblModel.addRow(row);
        }
        tbl_hoadon.setModel(tblModel);
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_hoadon = new org.jdesktop.swingx.JXTable();
        dtn_ngaydau = new org.jdesktop.swingx.JXDatePicker();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_tongban = new javax.swing.JTextField();
        label = new javax.swing.JLabel();
        dtn_ngaycuoi = new org.jdesktop.swingx.JXDatePicker();
        btn_thongke = new javax.swing.JButton();

        setBackground(new java.awt.Color(53, 47, 87));

        jPanel1.setBackground(new java.awt.Color(53, 47, 87));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách hoá đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 11), new java.awt.Color(221, 245, 165))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(221, 245, 165));

        tbl_hoadon.setBackground(new java.awt.Color(243, 209, 156));
        tbl_hoadon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tbl_hoadon);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
        );

        jLabel1.setForeground(new java.awt.Color(221, 245, 165));
        jLabel1.setText("Ngày đầu");

        jLabel3.setForeground(new java.awt.Color(221, 245, 165));
        jLabel3.setText(" Tổng tiền bán: ");

        label.setForeground(new java.awt.Color(221, 245, 165));
        label.setText("Ngày cuối");

        btn_thongke.setBackground(new java.awt.Color(184, 72, 99));
        btn_thongke.setForeground(new java.awt.Color(221, 245, 165));
        btn_thongke.setText("Thống kê");
        btn_thongke.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_thongkeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dtn_ngaydau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(label)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btn_thongke)
                                    .addComponent(dtn_ngaycuoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(jLabel3)
                        .addGap(45, 45, 45)
                        .addComponent(txt_tongban, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_tongban, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(dtn_ngaydau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label)
                            .addComponent(dtn_ngaycuoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addComponent(btn_thongke, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(314, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_thongkeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_thongkeMouseClicked
        // TODO add your handling code here:
        Date ngaydau = dtn_ngaydau.getDate();
        Date ngaycuoi = dtn_ngaycuoi.getDate();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        try {
            //----Thong Ke Hoa Don--------------------
            int tong = 0;
            List<HoaDon> lst_HoaDon = dao.dao_HoaDon.baseondate(ngaydau, ngaycuoi);
            DefaultTableModel tblModel = new DefaultTableModel();
            tblModel.addColumn("Mã Hoá Đơn");
            tblModel.addColumn("Mã nhân viên");
            tblModel.addColumn("Mã Khách Hàng");      
            tblModel.addColumn("Ngày Lập");   
            tblModel.addColumn("Tổng tiền"); 
            for (HoaDon pn : lst_HoaDon) {
                tong += Integer.valueOf(pn.getTongtien());
                Vector<String> row = new Vector<String>();
                row.addElement(String.valueOf(pn.getMahoadon()));
                row.addElement(String.valueOf(pn.getManhanvien()));
                row.addElement(String.valueOf(pn.getMakhachhang()));   
                row.addElement(pn.getNgaylap());;
                row.addElement(pn.getTongtien());;
                tblModel.addRow(row);
            }
            tbl_hoadon.setModel(tblModel);
            txt_tongban.setText(String.valueOf(tong));
            //----Thong Ke Phieu Nhap--------------------
//            int tong1 = 0;
//            List<PhieuNhap> lst_PhieuNhap = dao.dao_PhieuNhap.baseondate(ngaydau, ngaycuoi);
//            DefaultTableModel tblModel1 = new DefaultTableModel();
//            tblModel1.addColumn("Mã phiếu nhập");
//            tblModel1.addColumn("Mã nhân viên");
//            tblModel1.addColumn("Mã nhà cung cấp");      
//            tblModel1.addColumn("Ngày nhập");   
//            tblModel1.addColumn("Tổng tiền"); 
//            for (PhieuNhap pn : lst_PhieuNhap) {
//                tong1 += Integer.valueOf(pn.getTongtien());
//                Vector<String> row = new Vector<String>();
//                row.addElement(String.valueOf(pn.getMaphieunhap()));
//                row.addElement(String.valueOf(pn.getManhanvien()));
//                row.addElement(String.valueOf(pn.getManhaphanphoi()));   
//                row.addElement(pn.getNgaynhap());;
//                row.addElement(pn.getTongtien());;
//                tblModel1.addRow(row);
//            }
//            tbl_phieunhap.setModel(tblModel1);
//            txt_tongnhap.setText(String.valueOf(tong1));
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(frm_ThongKe.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(frm_ThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_thongkeMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_thongke;
    private org.jdesktop.swingx.JXDatePicker dtn_ngaycuoi;
    private org.jdesktop.swingx.JXDatePicker dtn_ngaydau;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel label;
    private org.jdesktop.swingx.JXTable tbl_hoadon;
    private javax.swing.JTextField txt_tongban;
    // End of variables declaration//GEN-END:variables
}
