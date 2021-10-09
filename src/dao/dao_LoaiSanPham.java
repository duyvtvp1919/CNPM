/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.LoaiSanPham;
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
public class dao_LoaiSanPham {
    public static List<LoaiSanPham> getAllLSP() throws ClassNotFoundException, SQLException
    {
        List<LoaiSanPham> lst_LoaiSanPham = new ArrayList<>();
        Connection cnn = tien_ich.connect.getConnection();
        String query = "select * from  LoaiSanPham";
        PreparedStatement stm = cnn.prepareStatement(query);
        ResultSet rs = stm.executeQuery();
        while(rs.next()){
            LoaiSanPham lsp = new LoaiSanPham();
            lsp.setMaloaisanpham(rs.getInt("MaLoaiSanPham"));
            lsp.setTenloaisanpham(rs.getString("TenLoaiSanPham"));
            lst_LoaiSanPham.add(lsp);
        }
        return lst_LoaiSanPham;
    }
    public static LoaiSanPham getOneLoaiSanPham(String _maloaisanpham) throws SQLException, ClassNotFoundException
    {
        LoaiSanPham _loaisanpham = new LoaiSanPham();
        //- mở kết nối ; xác định câu lệnh truy vấn ; thực thi câu lệnh truy vấn
        //--- Kết nối CSDL, lấy dữ liệu
        Connection cnn = tien_ich.connect.getConnection();
        //-- Xây dựng câu lệnh truy vấn
        String sql = "select * from LoaiSanPham where MaLoaiSanPham = '"+ _maloaisanpham +"'";
        // -- Thực thi câu lệnh truy vấn
        PreparedStatement pStmt = cnn.prepareStatement(sql);
        ResultSet rs = pStmt.executeQuery();
        while(rs.next())
        {            
            _loaisanpham.setMaloaisanpham(rs.getInt("Maloaisanpham"));
            _loaisanpham.setTenloaisanpham(rs.getString("Tenloaisanpham"));            
        }
        return _loaisanpham;
    }
    
    
    public static void insertLSP(LoaiSanPham lsp) throws SQLException, ClassNotFoundException{
        Connection conn = tien_ich.connect.getConnection();
        String inSert = "insert into LoaiSanPham(MaLoaiSanPham,TenLoaiSanPham) values('"+lsp.getMaloaisanpham()+"','"+lsp.getTenloaisanpham()+"')";
        PreparedStatement stm = conn.prepareStatement(inSert);
        stm.executeUpdate();
        tien_ich.connect.closePreparedStatement(stm);
        tien_ich.connect.closeConnection(conn);
    }
    
    public static void updateLSP(LoaiSanPham lsp) throws SQLException, ClassNotFoundException{
        Connection conn = tien_ich.connect.getConnection();
        String upDate = "update LoaiSanPham set MaLoaiSanPham = '"+lsp.getMaloaisanpham()+"'"
                + ",TenLoaiSanPham = '"+lsp.getTenloaisanpham()+"' where MaLoaiSanPham = '"+lsp.getMaloaisanpham()+"'";
        PreparedStatement stm = conn.prepareStatement(upDate);
        stm.executeUpdate();
        tien_ich.connect.closePreparedStatement(stm);
        tien_ich.connect.closeConnection(conn);
    }
    
    public static void deleteLSP(String maloaisanpham) throws ClassNotFoundException, SQLException{
        Connection conn = tien_ich.connect.getConnection();
        String delete = "delete from LoaiSanPham where MaLoaiSanPham = '"+maloaisanpham+"'";
        PreparedStatement stm = conn.prepareStatement(delete);
        stm.executeUpdate();
        tien_ich.connect.closePreparedStatement(stm);
        tien_ich.connect.closeConnection(conn);
    }
}
