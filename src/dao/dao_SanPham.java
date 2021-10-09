/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.SanPham;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class dao_SanPham {
    
    public static List<SanPham> getAllSP() throws ClassNotFoundException, SQLException{
        List<SanPham> lstSanPham = new ArrayList<>();
        Connection cnn = tien_ich.connect.getConnection();
        String query = "select * from SanPham ";
        PreparedStatement stm = cnn.prepareStatement(query);
        ResultSet rs = stm.executeQuery();
        while(rs.next()){
            SanPham sp = new SanPham();
            sp.setMasanpham(rs.getInt("MaSanPham"));
            sp.setTensanpham(rs.getString("TenSanPham"));
            sp.setMaloaisanpham(rs.getInt("MaLoaiSanPham"));
            sp.setNoisanxuat(rs.getString("NoiSanXuat"));
            sp.setGianhap(rs.getString("GiaNhap"));
            sp.setGiaban(rs.getString("GiaBan"));
            sp.setTonkho(rs.getInt("TonKho"));
            lstSanPham.add(sp);
        }
        return lstSanPham;
    }
   public static SanPham getOneSanPham(String _masanpham) throws SQLException, ClassNotFoundException
    {
        SanPham _sanpham = new SanPham();
        //- mở kết nối ; xác định câu lệnh truy vấn ; thực thi câu lệnh truy vấn
        //--- Kết nối CSDL, lấy dữ liệu
        Connection cnn = tien_ich.connect.getConnection();
        //-- Xây dựng câu lệnh truy vấn
        String sql = "select * from SanPham where MaSanPham = '"+ _masanpham +"'";
        // -- Thực thi câu lệnh truy vấn
        PreparedStatement pStmt = cnn.prepareStatement(sql);
        ResultSet rs = pStmt.executeQuery();
        while(rs.next())
        {   
            SanPham sp = new SanPham();
            sp.setMasanpham(rs.getInt("MaSanPham"));
            sp.setTensanpham(rs.getString("TenSanPham"));
            sp.setMaloaisanpham(rs.getInt("MaLoaiSanPham"));
            sp.setNoisanxuat(rs.getString("NoiSanXuat"));
            sp.setGianhap(rs.getString("GiaNhap"));
            sp.setGiaban(rs.getString("GiaBan"));
            sp.setTonkho(rs.getInt("TonKho"));
        }
        return _sanpham;
    }
   
   public static void insertSP(SanPham sp) throws SQLException, ClassNotFoundException{
        Connection conn = tien_ich.connect.getConnection();
        String inSert = "insert into SanPham(MaSanPham,TenSanPham,MaLoaiSanPham,NoiSanXuat,GiaNhap,GiaBan,TonKho) values('"+sp.getMasanpham()+"'"
                + ",'"+sp.getTensanpham()+"','"+sp.getMaloaisanpham()+"','"+sp.getNoisanxuat()+"','"+sp.getGianhap()+"'"
                + " ,'"+sp.getGiaban()+"','"+sp.getTonkho()+"')";
        PreparedStatement stm = conn.prepareStatement(inSert);
        stm.executeUpdate();
        tien_ich.connect.closePreparedStatement(stm);
        tien_ich.connect.closeConnection(conn);
    }
   
   public static void updateSP(SanPham sp) throws SQLException, ClassNotFoundException{
        Connection conn = tien_ich.connect.getConnection();
        String upDate = "update SanPham set MaSanPham = '"+sp.getMasanpham()+"'"
                + ",TenSanPham = '"+sp.getTensanpham()+"',MaLoaiSanPham = '"+sp.getMaloaisanpham()+"',NoiSanXuat = '"+sp.getNoisanxuat()+"'"
                + ",GiaNhap = '"+sp.getGianhap()+"',GiaBan = '"+sp.getGiaban()+"', TonKho = '"+sp.getTonkho()+"' where MaSanPham = '"+sp.getMasanpham()+"'";
        PreparedStatement stm = conn.prepareStatement(upDate);
        stm.executeUpdate();
        tien_ich.connect.closePreparedStatement(stm);
        tien_ich.connect.closeConnection(conn);
    }
    
    public static void deleteSP(String masanpham) throws ClassNotFoundException, SQLException{
        Connection conn = tien_ich.connect.getConnection();
        String delete = "delete from SanPham where MaSanPham = '"+masanpham+"'";
        PreparedStatement stm = conn.prepareStatement(delete);
        stm.executeUpdate();
        tien_ich.connect.closePreparedStatement(stm);
        tien_ich.connect.closeConnection(conn);
    }
    
    public static List<SanPham> searchSP(String tk) throws ClassNotFoundException, SQLException{
        List<SanPham> lstSanPham = new ArrayList<>();
        try{
            Connection cnn = tien_ich.connect.getConnection();
            String query = "select * from SanPham where TenSanPham like '%"+tk+"%'";
            PreparedStatement stm = cnn.prepareStatement(query);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                SanPham nv = new SanPham();
                nv.setMasanpham(rs.getInt("MaSanPham"));
                nv.setTensanpham(rs.getString("TenSanPham"));
                nv.setMaloaisanpham(rs.getInt("MaLoaiSanPham"));
                nv.setNoisanxuat(rs.getString("NoiSanXuat"));
                nv.setGianhap(rs.getString("GiaNhap"));
                nv.setGiaban(rs.getString("GiaBan"));
                nv.setTonkho(rs.getInt("TonKho"));
                lstSanPham.add(nv);
        }
        }
        catch(Exception ex){
            System.out.println(ex.toString());
        }
        return lstSanPham;
    }
}
