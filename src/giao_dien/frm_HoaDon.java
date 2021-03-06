/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giao_dien;
import entity.ChiTietHoaDon;
import entity.LoaiSanPham;
import entity.NhaPhanPhoi;
import entity.HoaDon;
import entity.SanPham;
import entity.SanPham_LoaiSanPham;
import entity.TTHoaDon;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.*;
import java.util.function.Supplier;



/**
 *
 * @author LENOVO
 */
public class frm_HoaDon extends javax.swing.JPanel {

    /**
     * Creates new form frm_HoaDon
     */
    public frm_HoaDon() throws SQLException, ClassNotFoundException, ParseException {
        initComponents();
        LoadData_ChiTietHoaDon();
        LoadData_ChiTietHoaDon_control();
        LoadData_HoaDon();
        LoadData_HoaDon_control();
    }
    private void LoadData_ChiTietHoaDon() throws SQLException, ClassNotFoundException{
        List<ChiTietHoaDon> lst_ChiTietHoaDon = dao.dao_ChiTietHoaDon.getAllCTPN();
        DefaultTableModel tblModel = new DefaultTableModel();
        tblModel.addColumn("Mã sản phẩm");      
        tblModel.addColumn("Số lượng");   
        for (ChiTietHoaDon ctpn : lst_ChiTietHoaDon) {
            Vector<String> row = new Vector<String>();
            row.addElement(String.valueOf(ctpn.getMasanpham()));   
            row.addElement(String.valueOf(ctpn.getSoluong()));;
            tblModel.addRow(row);
        }
        tbl_chitiethoadon.setModel(tblModel);
        //-----Tinh Tong Tien------
        List<SanPham> lst_SanPham = dao.dao_SanPham.getAllSP();
//                List<ChiTietHoaDon> lst_ChiTietHoaDon = dao.dao_ChiTietHoaDon.getAllCTPN();
        List<SanPham> lst_SanPham1 = new ArrayList<>();
        int tong = 0;
        for (ChiTietHoaDon ct : lst_ChiTietHoaDon) {
            for(SanPham sp : lst_SanPham) {
                if (ct.getMasanpham() == sp.getMasanpham()) {
                    SanPham sp1 = new SanPham();
                    tong += ct.getSoluong()*Integer.parseInt(sp.getGiaban());
                    //sp1 = sp;
                    sp1.setMasanpham(sp.getMasanpham());
                    sp1.setTensanpham(sp.getTensanpham());
                    sp1.setMaloaisanpham(sp.getMaloaisanpham());
                    sp1.setNoisanxuat(sp.getNoisanxuat());
                    sp1.setGianhap(sp.getGianhap());
                    sp1.setGiaban(sp.getGiaban());
                    sp1.setTonkho(sp.getTonkho()-ct.getSoluong());
                    //dao.dao_SanPham.updateSP(sp1);
                    lst_SanPham1.add(sp1);
                }
            }
        }
        txt_tongtien.setText(String.valueOf(tong));
    }
    private void LoadData_ChiTietHoaDon_control() throws ParseException, ClassNotFoundException, SQLException{
        if (tbl_chitiethoadon.getSelectedRow() != -1) {
            //-- Xác định hàng đã click
            int i = tbl_chitiethoadon.getSelectedRow();
            
            //-- Lấy được danh sách sinh viên
            List<ChiTietHoaDon> lst_ctpn = dao.dao_ChiTietHoaDon.getAllCTPN();
            //-- Xác định là sinh viên nào đang được click
            
            ChiTietHoaDon ctpn = lst_ctpn.get(i);
            //--- Set giá trị cho các control
            txt_masanpham.setText(String.valueOf(ctpn.getMasanpham()));
            txt_soluong.setText(String.valueOf(ctpn.getSoluong()));
        }
    }
    private void clear_chitiethoadon() {
        txt_masanpham.setText("");
        txt_soluong.setText("");
    }
    private void LoadData_HoaDon() throws ClassNotFoundException, SQLException{
        List<HoaDon> lst_HoaDon = dao.dao_HoaDon.getAllHD();
        DefaultTableModel tblModel = new DefaultTableModel();
        tblModel.addColumn("Mã Hoá Đơn");
        tblModel.addColumn("Nhân viên");
        tblModel.addColumn("Khách Hàng");      
        tblModel.addColumn("Ngày Lập");   
        tblModel.addColumn("Tổng tiền"); 
        for (HoaDon pn : lst_HoaDon) {
            Vector<String> row = new Vector<String>();
            row.addElement(String.valueOf(pn.getMahoadon()));
            row.addElement(String.valueOf(pn.getManhanvien()));
            row.addElement(String.valueOf(pn.getMakhachhang()));   
            row.addElement(pn.getNgaylap());
            row.addElement(pn.getTongtien());
            tblModel.addRow(row);
        }
        tbl_hoadon.setModel(tblModel);
        tbl_hoadon1.setModel(tblModel);
    }
    private void LoadData_HoaDon_control() throws ParseException, ClassNotFoundException, SQLException{
        if (tbl_hoadon1.getSelectedRow() != -1) {
            //-- Xác định hàng đã click
            int i = tbl_hoadon1.getSelectedRow();
            
            //-- Lấy được danh sách sinh viên
            List<HoaDon> lst_pn = dao.dao_HoaDon.getAllHD();
            //-- Xác định là sinh viên nào đang được click
            
            HoaDon pn = lst_pn.get(i);
            //--- Set giá trị cho các control
            txt_manhanvien1.setText(String.valueOf(pn.getManhanvien()));
            txt_makhachhang1.setText(String.valueOf(pn.getMakhachhang()));
            txt_mahoadon1.setText(String.valueOf(pn.getMahoadon()));
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            dtn_ngaylap1.setDate(dateFormat.parse(pn.getNgaylap()));
            txt_tongtien1.setText(pn.getTongtien());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_chitiethoadon = new org.jdesktop.swingx.JXTable();
        jButton1 = new javax.swing.JButton();
        btn_xoachitiet = new javax.swing.JButton();
        btn_themhoadon = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txt_mahoadon = new javax.swing.JTextField();
        dtn_ngaylap = new org.jdesktop.swingx.JXDatePicker();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_hoadon = new org.jdesktop.swingx.JXTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_manhanvien = new javax.swing.JTextField();
        txt_makhachhang = new javax.swing.JTextField();
        txt_masanpham = new javax.swing.JTextField();
        txt_soluong = new javax.swing.JTextField();
        btn_themchitiet = new javax.swing.JButton();
        btn_suasanpham = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        txt_tongtien = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_hoadon1 = new org.jdesktop.swingx.JXTable();
        btn_xoahoadon = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_manhanvien1 = new javax.swing.JTextField();
        txt_makhachhang1 = new javax.swing.JTextField();
        txt_mahoadon1 = new javax.swing.JTextField();
        dtn_ngaylap1 = new org.jdesktop.swingx.JXDatePicker();
        jLabel11 = new javax.swing.JLabel();
        txt_tongtien1 = new javax.swing.JTextField();
        btn_xemchitiet = new javax.swing.JButton();

        setBackground(new java.awt.Color(53, 47, 87));

        jPanel1.setBackground(new java.awt.Color(53, 47, 87));

        tbl_chitiethoadon.setBackground(new java.awt.Color(243, 209, 156));
        tbl_chitiethoadon.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_chitiethoadon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_chitiethoadonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_chitiethoadon);

        jButton1.setBackground(new java.awt.Color(184, 72, 99));
        jButton1.setForeground(new java.awt.Color(221, 245, 165));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rs.png"))); // NOI18N
        jButton1.setText("Reset");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        btn_xoachitiet.setBackground(new java.awt.Color(184, 72, 99));
        btn_xoachitiet.setForeground(new java.awt.Color(221, 245, 165));
        btn_xoachitiet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.png"))); // NOI18N
        btn_xoachitiet.setText("Xoá Sản Phẩm");
        btn_xoachitiet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_xoachitietMouseClicked(evt);
            }
        });

        btn_themhoadon.setBackground(new java.awt.Color(184, 72, 99));
        btn_themhoadon.setForeground(new java.awt.Color(221, 245, 165));
        btn_themhoadon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/iconfinder_Add_728898.png"))); // NOI18N
        btn_themhoadon.setText("Thêm Hoá Đơn");
        btn_themhoadon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_themhoadonMouseClicked(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(221, 245, 165));
        jLabel5.setText("Mã Hoá Đơn");

        jLabel6.setForeground(new java.awt.Color(221, 245, 165));
        jLabel6.setText("Ngày Lập");

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

        jLabel1.setForeground(new java.awt.Color(221, 245, 165));
        jLabel1.setText("Nhân Viên");

        jLabel2.setForeground(new java.awt.Color(221, 245, 165));
        jLabel2.setText("Tên Khách Hàng");

        jLabel3.setForeground(new java.awt.Color(221, 245, 165));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Mã Sản Phẩm");

        jLabel4.setForeground(new java.awt.Color(221, 245, 165));
        jLabel4.setText("Số Lượng");

        btn_themchitiet.setBackground(new java.awt.Color(184, 72, 99));
        btn_themchitiet.setForeground(new java.awt.Color(221, 245, 165));
        btn_themchitiet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/iconfinder_Add_728898.png"))); // NOI18N
        btn_themchitiet.setText("Thêm Sản Phẩm");
        btn_themchitiet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_themchitietMouseClicked(evt);
            }
        });

        btn_suasanpham.setBackground(new java.awt.Color(184, 72, 99));
        btn_suasanpham.setForeground(new java.awt.Color(221, 245, 165));
        btn_suasanpham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/replace.png"))); // NOI18N
        btn_suasanpham.setText("Sửa Sản Phẩm");
        btn_suasanpham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_suasanphamMouseClicked(evt);
            }
        });

        jLabel12.setForeground(new java.awt.Color(221, 245, 165));
        jLabel12.setText("Tổng Tiền");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_themhoadon)
                        .addGap(82, 82, 82)
                        .addComponent(btn_themchitiet)
                        .addGap(33, 33, 33)
                        .addComponent(btn_xoachitiet)
                        .addGap(33, 33, 33)
                        .addComponent(btn_suasanpham)
                        .addGap(33, 33, 33)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_makhachhang)
                                    .addComponent(txt_mahoadon)
                                    .addComponent(dtn_ngaylap, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(txt_manhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(66, 66, 66)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_soluong, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txt_masanpham, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(69, 69, 69)
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txt_tongtien, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 856, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_masanpham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(txt_tongtien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_soluong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_manhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_makhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_mahoadon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dtn_ngaylap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_themchitiet, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_xoachitiet, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_themhoadon, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_suasanpham, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Thêm Hoá Đơn", jPanel1);

        jPanel2.setBackground(new java.awt.Color(53, 47, 87));

        tbl_hoadon1.setBackground(new java.awt.Color(243, 209, 156));
        tbl_hoadon1.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_hoadon1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_hoadon1MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_hoadon1);

        btn_xoahoadon.setBackground(new java.awt.Color(184, 72, 99));
        btn_xoahoadon.setForeground(new java.awt.Color(221, 245, 165));
        btn_xoahoadon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.png"))); // NOI18N
        btn_xoahoadon.setText("Xoá Hoá Đơn");
        btn_xoahoadon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_xoahoadonMouseClicked(evt);
            }
        });

        jLabel7.setForeground(new java.awt.Color(221, 245, 165));
        jLabel7.setText("Nhân Viên");

        jLabel8.setForeground(new java.awt.Color(221, 245, 165));
        jLabel8.setText("Khách Hàng");

        jLabel9.setForeground(new java.awt.Color(221, 245, 165));
        jLabel9.setText("Mã Hoá Đơn");

        jLabel10.setForeground(new java.awt.Color(221, 245, 165));
        jLabel10.setText("Ngày Lập");

        jLabel11.setForeground(new java.awt.Color(221, 245, 165));
        jLabel11.setText("Tổng Tiền");

        btn_xemchitiet.setBackground(new java.awt.Color(184, 72, 99));
        btn_xemchitiet.setForeground(new java.awt.Color(221, 245, 165));
        btn_xemchitiet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/chitiet.png"))); // NOI18N
        btn_xemchitiet.setText("Xem Chi Tiết");
        btn_xemchitiet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_xemchitietMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE))
                            .addComponent(jLabel11))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_manhanvien1)
                            .addComponent(txt_makhachhang1)
                            .addComponent(txt_mahoadon1)
                            .addComponent(dtn_ngaylap1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_tongtien1)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btn_xoahoadon)
                        .addGap(35, 35, 35)
                        .addComponent(btn_xemchitiet)))
                .addContainerGap(569, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_manhanvien1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_makhachhang1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_mahoadon1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dtn_ngaylap1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txt_tongtien1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_xoahoadon, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_xemchitiet, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(451, 451, 451))
        );

        jTabbedPane1.addTab("Thông Tin Hoá Đơn", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(416, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_suasanphamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_suasanphamMouseClicked
        // TODO add your handling code here:
        ChiTietHoaDon ctpn = new ChiTietHoaDon();
        ctpn.setMasanpham(Integer.valueOf(txt_masanpham.getText()));
        ctpn.setSoluong(Integer.valueOf(txt_soluong.getText()));

        try {
            List<SanPham> lst_SanPham = dao.dao_SanPham.getAllSP();
            boolean ok = false, ok1 = false;
            for(SanPham sp : lst_SanPham) {
                if (sp.getMasanpham() == ctpn.getMasanpham()) {
                    ok1 = true;
                    if  (sp.getTonkho() < ctpn.getSoluong()) {
                        ok = true;
                    }
                }
            }
            if (ok1 == false) {
                JOptionPane.showMessageDialog(this, "Mã sản phẩm không đúng!");
            }
            else if (ok == false) {
                JOptionPane.showMessageDialog(this, "Sửa thành công!");
                dao.dao_ChiTietHoaDon.updateCTPN(ctpn);
                LoadData_ChiTietHoaDon();
            }
            else JOptionPane.showMessageDialog(this, "Số lượng tồn kho không đủ!");

        } catch (SQLException ex) {
            Logger.getLogger(frm_SanPham.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(frm_SanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_suasanphamMouseClicked

    private void btn_themchitietMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_themchitietMouseClicked
        // TODO add your handling code here:
        ChiTietHoaDon ctpn = new ChiTietHoaDon();
        ctpn.setMasanpham(Integer.valueOf(txt_masanpham.getText()));
        ctpn.setSoluong(Integer.valueOf(txt_soluong.getText()));

        try {
            List<SanPham> lst_SanPham = dao.dao_SanPham.getAllSP();
            List<ChiTietHoaDon> lst_ChiTietHoaDon = dao.dao_ChiTietHoaDon.getAllCTPN();
            boolean ok = false, ok1 = false, ok2 = false;
            for(SanPham sp : lst_SanPham) {
                if (sp.getMasanpham() == ctpn.getMasanpham()) {
                    ok1 = true;
                    if  (sp.getTonkho() < ctpn.getSoluong()) {
                        ok = true;
                    }
                }
            }
            for (ChiTietHoaDon ct : lst_ChiTietHoaDon) {
                if (ct.getMasanpham() == ctpn.getMasanpham()) ok2 = true;
            }
            if (ok1 == false) {
                JOptionPane.showMessageDialog(this, "Mã sản phẩm không đúng!");
            }
            else if (ok2 == true) {
                JOptionPane.showMessageDialog(this, "Mã sản phẩm đã được thêm!");
            }
            else if (ok == false) {
                JOptionPane.showMessageDialog(this, "Thêm thành công!");
                dao.dao_ChiTietHoaDon.insertCTPN(ctpn);
                LoadData_ChiTietHoaDon();
            }
            else JOptionPane.showMessageDialog(this, "Số lượng tồn kho không đủ!");

        } catch (SQLException ex) {
            Logger.getLogger(frm_SanPham.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(frm_SanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_themchitietMouseClicked

    private void btn_themhoadonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_themhoadonMouseClicked

        try {
            // TODO add your handling code here:
            //-----Check Ma Nhan Vien----------
//            List<NhanVien> lst_NhanVien = dao.dao_NhanVien.getAll();
//            boolean checknv = false;
//            String mnv = txt_manhanvien.getText();
//            for (NhanVien nv : lst_NhanVien) {
//                if (nv.getMaNV() != Integer.valueOf(mnv)) {
//                } else {
//                    checknv = true;
//                }
//            }
//            //-----Check Ma Khach Hang----------
//            List<KhachHang> lst_KhachHang = dao.dao_KhachHang.getAllKH();
//            boolean checkkh = false;
//            String mkh = txt_makhachhang.getText();
//            for (KhachHang kh : lst_KhachHang) {
//                if (kh.getMakh() != Integer.valueOf(mkh)) {
//                } else {
//                    checkkh = true;
//                }
//            }
            //-------Check Ma Hoa Don--------------
            List<HoaDon> lst_HoaDon = dao.dao_HoaDon.getAllHD();
            boolean checkhd = false;
            String mhd = txt_mahoadon.getText();
            for (HoaDon nv : lst_HoaDon) {
                if (nv.getMahoadon() != Integer.valueOf(mhd)) {
                } else {
                    checkhd = true;
                }
            }
            //------------------------------------
            if (checkhd == false) {
                //-----Tinh Tong Tien------
                List<SanPham> lst_SanPham = dao.dao_SanPham.getAllSP();
                List<ChiTietHoaDon> lst_ChiTietHoaDon = dao.dao_ChiTietHoaDon.getAllCTPN();
                List<SanPham> lst_SanPham1 = new ArrayList<>();
                int tong = 0;
                for (ChiTietHoaDon ct : lst_ChiTietHoaDon) {
                    for(SanPham sp : lst_SanPham) {
                        if (ct.getMasanpham() == sp.getMasanpham()) {
                            SanPham sp1 = new SanPham();
                            tong += ct.getSoluong()*Integer.parseInt(sp.getGiaban());
                            //sp1 = sp;
                            sp1.setMasanpham(sp.getMasanpham());
                            sp1.setTensanpham(sp.getTensanpham());
                            sp1.setMaloaisanpham(sp.getMaloaisanpham());
                            sp1.setNoisanxuat(sp.getNoisanxuat());
                            sp1.setGianhap(sp.getGianhap());
                            sp1.setGiaban(sp.getGiaban());
                            sp1.setTonkho(sp.getTonkho()-ct.getSoluong());
                            //dao.dao_SanPham.updateSP(sp1);
                            lst_SanPham1.add(sp1);
                        }
                    }
                }

                //------Them Vao Bang Hoa Don----------
                HoaDon hd = new HoaDon();
                hd.setManhanvien(txt_manhanvien.getText());
                hd.setMakhachhang(txt_makhachhang.getText());
                hd.setMahoadon(Integer.valueOf(txt_mahoadon.getText()));
                hd.setTongtien(String.valueOf(tong));
                Date dtn_nl = dtn_ngaylap.getDate();
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                hd.setNgaylap(dateFormat.format(dtn_nl));
                
                try {
                    
                    dao.dao_HoaDon.insertHD(hd);
                    LoadData_HoaDon();
                    //clear_chitiethoadon();
                    dao.dao_ChiTietHoaDon.remove();
                    LoadData_ChiTietHoaDon();
                    for (SanPham sp : lst_SanPham1) {
                        dao.dao_SanPham.updateSP(sp);
                    }
                    for (ChiTietHoaDon ct : lst_ChiTietHoaDon) {
                        TTHoaDon tthd = new TTHoaDon();
                        tthd.setMasanpham(ct.getMasanpham());
                        tthd.setSoluong(ct.getSoluong());
                        tthd.setMahoadon(Integer.valueOf(txt_mahoadon.getText()));
                        try {
                            dao.dao_TTHoaDon.insertTTHD(tthd);
                        } catch (SQLException ex) {
                            Logger.getLogger(frm_HoaDon.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(frm_HoaDon.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    dao.dao_ChiTietHoaDon.remove();
                    txt_masanpham.setText("");
                    txt_soluong.setText("");
                    txt_manhanvien.setText("");
                    txt_makhachhang.setText("");
                    dtn_ngaylap.setDate(null);
                    txt_mahoadon.setText("");
                    //LoadData_LoaiSanPham();
                    JOptionPane.showMessageDialog(this,"Thêm Hoá Đơn Thành Công\nTổng tiền là " + tong);
                } catch (SQLException ex) {
                    Logger.getLogger(frm_SanPham.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(frm_SanPham.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else {
                String error = "";
//                if (checknv == false) error += "Ma Nhan Vien Sai\n";
//                if (checkkh == false) error += "Ma Khach Hang Sai\n";
                if (checkhd == true) error += "Ma Hoa Don Da ton tai";
                JOptionPane.showMessageDialog(this,error);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(frm_HoaDon.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(frm_HoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btn_themhoadonMouseClicked

    private void btn_xoachitietMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_xoachitietMouseClicked
        // TODO add your handling code here:
        try {
            dao.dao_ChiTietHoaDon.deleteCTPN(txt_masanpham.getText());
            LoadData_ChiTietHoaDon();
            clear_chitiethoadon();
            LoadData_ChiTietHoaDon();
            JOptionPane.showMessageDialog(this, "Xóa thành công!");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(frm_SanPham.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(frm_SanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_xoachitietMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked

        // TODO add your handling code here:
        txt_masanpham.setText("");
        txt_soluong.setText("");
        txt_manhanvien.setText("");
        txt_makhachhang.setText("");
        dtn_ngaylap1.setDate(null);
        
    }//GEN-LAST:event_jButton1MouseClicked

    private void tbl_chitiethoadonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_chitiethoadonMouseClicked
        // TODO add your handling code here:
        try {
            LoadData_ChiTietHoaDon_control();
        } catch (ParseException ex) {
            Logger.getLogger(frm_SanPham.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(frm_SanPham.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(frm_SanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tbl_chitiethoadonMouseClicked

    private void btn_xoahoadonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_xoahoadonMouseClicked
        // TODO add your handling code here:
        try {
            dao.dao_TTHoaDon.deleteTTHD(txt_mahoadon1.getText());
            dao.dao_HoaDon.deletePN(txt_mahoadon1.getText());
            LoadData_HoaDon();
            txt_manhanvien1.setText("");
            txt_makhachhang1.setText("");
            txt_mahoadon1.setText("");
            txt_tongtien1.setText("");
            dtn_ngaylap1.setDate(null);
            JOptionPane.showMessageDialog(this, "Xóa thành công!");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(frm_SanPham.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(frm_SanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_xoahoadonMouseClicked

    private void tbl_hoadon1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_hoadon1MouseClicked
        try {
            // TODO add your handling code here:
            LoadData_HoaDon_control();
        } catch (ParseException ex) {
            Logger.getLogger(frm_HoaDon.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(frm_HoaDon.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(frm_HoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tbl_hoadon1MouseClicked

    private void btn_xemchitietMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_xemchitietMouseClicked
        HienThiTTHoaDon frm = new HienThiTTHoaDon(txt_mahoadon1.getText());
        frm.setLocationRelativeTo(null);
        frm.setVisible(true);   
    }//GEN-LAST:event_btn_xemchitietMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_suasanpham;
    private javax.swing.JButton btn_themchitiet;
    private javax.swing.JButton btn_themhoadon;
    private javax.swing.JButton btn_xemchitiet;
    private javax.swing.JButton btn_xoachitiet;
    private javax.swing.JButton btn_xoahoadon;
    private org.jdesktop.swingx.JXDatePicker dtn_ngaylap;
    private org.jdesktop.swingx.JXDatePicker dtn_ngaylap1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private org.jdesktop.swingx.JXTable tbl_chitiethoadon;
    private org.jdesktop.swingx.JXTable tbl_hoadon;
    private org.jdesktop.swingx.JXTable tbl_hoadon1;
    private javax.swing.JTextField txt_mahoadon;
    private javax.swing.JTextField txt_mahoadon1;
    private javax.swing.JTextField txt_makhachhang;
    private javax.swing.JTextField txt_makhachhang1;
    private javax.swing.JTextField txt_manhanvien;
    private javax.swing.JTextField txt_manhanvien1;
    private javax.swing.JTextField txt_masanpham;
    private javax.swing.JTextField txt_soluong;
    private javax.swing.JTextField txt_tongtien;
    private javax.swing.JTextField txt_tongtien1;
    // End of variables declaration//GEN-END:variables
}
