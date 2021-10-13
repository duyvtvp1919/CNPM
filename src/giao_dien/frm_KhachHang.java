/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giao_dien;

import entity.KhachHang;
import entity.NhanVien;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class frm_KhachHang extends javax.swing.JPanel {
    String find_name = "";
    /**
     * Creates new form frm_KhachHang
     */
    public frm_KhachHang() throws SQLException, ClassNotFoundException {
        initComponents();
        LoadData_KhachHang();
    }
    private void LoadData_KhachHang() throws SQLException, ClassNotFoundException{
        List<KhachHang> lstKhachHang = dao.dao_KhachHang.getAllKH();
        DefaultTableModel tblModel = new DefaultTableModel();
        tblModel.addColumn("Mã khách hàng");
        tblModel.addColumn("Tên khách hàng");
        tblModel.addColumn("Ngày sinh");
        tblModel.addColumn("Giới tính");
        tblModel.addColumn("Địa chỉ");
        tblModel.addColumn("Điện thoại");
        for (KhachHang kh : lstKhachHang) {
            Vector<String> row = new Vector<String>();
            row.addElement(String.valueOf(kh.getMakh()));
            row.addElement(kh.getTenkh());
            row.addElement(String.valueOf(kh.getNgaysinhkh()));
            row.addElement(String.valueOf(kh.getGioitinh()));
            row.addElement(kh.getDiachi());
            row.addElement(kh.getSdt());
            tblModel.addRow(row);
        }
        tb_khachhang.setModel(tblModel);
    }
    private void find() throws ClassNotFoundException, SQLException{
        List<KhachHang> lstKhachHang = dao.dao_KhachHang.searchKH(find_name);
        DefaultTableModel tblModel = new DefaultTableModel();
        tblModel.addColumn("Mã khách hàng");
        tblModel.addColumn("Tên khách hàng");
        tblModel.addColumn("Ngày sinh");
        tblModel.addColumn("Giới tính");
        tblModel.addColumn("Địa chỉ");
        tblModel.addColumn("Điện thoại");
        for (KhachHang kh : lstKhachHang) {
            Vector<String> row = new Vector<String>();
            row.addElement(String.valueOf(kh.getMakh()));
            row.addElement(kh.getTenkh());
            row.addElement(String.valueOf(kh.getNgaysinhkh()));
            row.addElement(String.valueOf(kh.getGioitinh()));
            row.addElement(kh.getDiachi());
            row.addElement(kh.getSdt());
            tblModel.addRow(row);
        }
        tb_khachhang.setModel(tblModel);
    }
    private void loadData_control() throws ClassNotFoundException, SQLException, ParseException{
        if (tb_khachhang.getSelectedRow() != -1) {
            //-- Xác định hàng đã click
            int i = tb_khachhang.getSelectedRow();
            
            //-- Lấy được danh sách sinh viên
            List<KhachHang> lstkh = dao.dao_KhachHang.getAllKH();
            //-- Xác định là sinh viên nào đang được click
            
            KhachHang kh = lstkh.get(i);
            //--- Set giá trị cho các control
            txt_makhachhang.setText(String.valueOf(kh.getMakh()));
            txt_tenkhachhang.setText(kh.getTenkh());
            int check = kh.getGioitinh();
            if (check == 1) {
                rd_nam.setSelected(true);
            }
            else if (check == 0) {
                rd_nu.setSelected(true);
            }
            txt_diachi.setText(kh.getDiachi());
            txt_sdt.setText(kh.getSdt());
            //- Xác định lớp học của sv1                          
            //- Set giá trị của components JXdatepicker
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            dtn_ngaysinhKH.setDate(dateFormat.parse(kh.getNgaysinhkh()));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        txt_makhachhang = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_tenkhachhang = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        dtn_ngaysinhKH = new org.jdesktop.swingx.JXDatePicker();
        jLabel4 = new javax.swing.JLabel();
        rd_nam = new javax.swing.JRadioButton();
        rd_nu = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        txt_diachi = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_sdt = new javax.swing.JTextField();
        btn_them = new javax.swing.JButton();
        btn_sua = new javax.swing.JButton();
        btn_reset = new javax.swing.JButton();
        btn_xoa = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_khachhang = new org.jdesktop.swingx.JXTable();
        jLabel7 = new javax.swing.JLabel();
        txt_search = new javax.swing.JTextField();
        btn_search = new javax.swing.JButton();

        setBackground(new java.awt.Color(53, 47, 87));
        setForeground(new java.awt.Color(221, 245, 165));

        jLabel1.setForeground(new java.awt.Color(221, 245, 165));
        jLabel1.setText("Mã khách hàng:");

        jLabel2.setForeground(new java.awt.Color(221, 245, 165));
        jLabel2.setText("Tên khách hàng:");

        jLabel3.setForeground(new java.awt.Color(221, 245, 165));
        jLabel3.setText("Ngày sinh:");

        dtn_ngaysinhKH.setBackground(new java.awt.Color(229, 134, 116));

        jLabel4.setForeground(new java.awt.Color(221, 245, 165));
        jLabel4.setText("Giới tính:");

        buttonGroup1.add(rd_nam);
        rd_nam.setForeground(new java.awt.Color(221, 245, 165));
        rd_nam.setText("Nam");

        buttonGroup1.add(rd_nu);
        rd_nu.setForeground(new java.awt.Color(221, 245, 165));
        rd_nu.setText("Nữ");

        jLabel5.setForeground(new java.awt.Color(221, 245, 165));
        jLabel5.setText("Địa chỉ:");

        jLabel6.setForeground(new java.awt.Color(221, 245, 165));
        jLabel6.setText("SĐT:");

        btn_them.setBackground(new java.awt.Color(184, 72, 99));
        btn_them.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/iconfinder_Add_728898.png"))); // NOI18N
        btn_them.setText("Thêm");
        btn_them.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_themMouseClicked(evt);
            }
        });

        btn_sua.setBackground(new java.awt.Color(184, 72, 99));
        btn_sua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/replace.png"))); // NOI18N
        btn_sua.setText("Sửa");
        btn_sua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_suaMouseClicked(evt);
            }
        });

        btn_reset.setBackground(new java.awt.Color(184, 72, 99));
        btn_reset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rs.png"))); // NOI18N
        btn_reset.setText("Reset");
        btn_reset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_resetMouseClicked(evt);
            }
        });

        btn_xoa.setBackground(new java.awt.Color(184, 72, 99));
        btn_xoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.png"))); // NOI18N
        btn_xoa.setText("Xóa");
        btn_xoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_xoaMouseClicked(evt);
            }
        });

        tb_khachhang.setBackground(new java.awt.Color(243, 209, 156));
        tb_khachhang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "null", "null"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tb_khachhang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_khachhangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_khachhang);

        jLabel7.setForeground(new java.awt.Color(221, 245, 165));
        jLabel7.setText("Tìm kiếm:");

        txt_search.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_searchCaretUpdate(evt);
            }
        });

        btn_search.setBackground(new java.awt.Color(184, 72, 99));
        btn_search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/find.png"))); // NOI18N
        btn_search.setText("Tìm");
        btn_search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_searchMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(rd_nam)
                        .addGap(59, 59, 59)
                        .addComponent(rd_nu))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_makhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_tenkhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dtn_ngaysinhKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(59, 59, 59)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_sdt)
                            .addComponent(txt_diachi, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(txt_search)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_search))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_them)
                        .addGap(54, 54, 54)
                        .addComponent(btn_xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(btn_sua, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(btn_reset)))
                .addContainerGap(123, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_makhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_tenkhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_diachi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dtn_ngaysinhKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_search))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rd_nam)
                    .addComponent(rd_nu))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_them, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_sua, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_reset, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(91, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tb_khachhangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_khachhangMouseClicked
        try {
            loadData_control();
        } catch (ClassNotFoundException | SQLException | ParseException ex) {
            Logger.getLogger(frm_KhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tb_khachhangMouseClicked

    private void btn_themMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_themMouseClicked
        Date dtn_ns = dtn_ngaysinhKH.getDate();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        KhachHang kh = new KhachHang();
        kh.setMakh(Integer.valueOf(txt_makhachhang.getText()));
        kh.setTenkh(txt_tenkhachhang.getText());
        kh.setNgaysinhkh(dateFormat.format(dtn_ns));
        kh.setDiachi(txt_diachi.getText());
        kh.setSdt(txt_sdt.getText());
        if (rd_nam.isSelected() == true) {
            kh.setGioitinh(1);
        }
        else if (rd_nu.isSelected() == true) {
            kh.setGioitinh(0);
        }
        
        try {
            dao.dao_KhachHang.insertKH(kh);
            JOptionPane.showMessageDialog(this,"Thêm thành công");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"Mã bị trùng");
            Logger.getLogger(frm_NhanVien.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(frm_NhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            LoadData_KhachHang();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(frm_NhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btn_themMouseClicked

    private void btn_xoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_xoaMouseClicked
        try {
            dao.dao_KhachHang.deleteKH(txt_makhachhang.getText());
            JOptionPane.showMessageDialog(this,"Xóa thành công");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(frm_KhachHang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(frm_KhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            LoadData_KhachHang();
        } catch (SQLException ex) {
            Logger.getLogger(frm_KhachHang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(frm_KhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_xoaMouseClicked

    private void btn_suaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_suaMouseClicked
        Date dtn_ns = dtn_ngaysinhKH.getDate();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        KhachHang kh = new KhachHang();
        kh.setMakh(Integer.valueOf(txt_makhachhang.getText()));
        kh.setTenkh(txt_tenkhachhang.getText());
        kh.setNgaysinhkh(dateFormat.format(dtn_ns));
        kh.setDiachi(txt_diachi.getText());
        kh.setSdt(txt_sdt.getText());
        if (rd_nam.isSelected() == true) {
            kh.setGioitinh(1);
        }
        else if (rd_nu.isSelected() == true) {
            kh.setGioitinh(0);
        }
        try {
            dao.dao_KhachHang.updateKH(kh);
            LoadData_KhachHang();
            JOptionPane.showMessageDialog(this, "Sửa thành công!");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(frm_NhanVien.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(frm_NhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_suaMouseClicked

    private void btn_resetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_resetMouseClicked
        txt_makhachhang.setText("");
        txt_diachi.setText("");
        txt_sdt.setText("");
        txt_tenkhachhang.setText("");
    }//GEN-LAST:event_btn_resetMouseClicked

    private void txt_searchCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_searchCaretUpdate
        find_name = txt_search.getText();
        try {
            find();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(frm_KhachHang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(frm_KhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txt_searchCaretUpdate

    private void btn_searchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_searchMouseClicked
        find_name = txt_search.getText();
        try {
            find();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(frm_KhachHang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(frm_KhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_searchMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_reset;
    private javax.swing.JButton btn_search;
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_them;
    private javax.swing.JButton btn_xoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private org.jdesktop.swingx.JXDatePicker dtn_ngaysinhKH;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rd_nam;
    private javax.swing.JRadioButton rd_nu;
    private org.jdesktop.swingx.JXTable tb_khachhang;
    private javax.swing.JTextField txt_diachi;
    private javax.swing.JTextField txt_makhachhang;
    private javax.swing.JTextField txt_sdt;
    private javax.swing.JTextField txt_search;
    private javax.swing.JTextField txt_tenkhachhang;
    // End of variables declaration//GEN-END:variables
}
