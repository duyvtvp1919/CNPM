/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import entity.SanPham_LoaiSanPham;
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
public class dao_SanPham_LoaiSanPham {
    public static List<SanPham_LoaiSanPham> getAllSP_LSP() throws ClassNotFoundException, SQLException 
    {
        List<SanPham_LoaiSanPham> lst_SanPham_LoaiSanPham = new ArrayList<>();
        Connection cnn = tien_ich.connect.getConnection();
        String query = "select * from v_sanpham";
        PreparedStatement stm = cnn.prepareStatement(query);
        ResultSet rs = stm.executeQuery();
        while(rs.next()){
            SanPham_LoaiSanPham lsp = new SanPham_LoaiSanPham();
            lsp.setMasanpham(rs.getInt("MaSanPham"));
            lsp.setTensanpham(rs.getString("TenSanPham"));
            lsp.setTenloaisanpham(rs.getString("TenLoaiSanPham")); // TenLoaiSanPham,MaLoaiSanPhamTenSaSanPham --> 3 cot từ bảng vSanpham
            lst_SanPham_LoaiSanPham.add(lsp);
        }
        return lst_SanPham_LoaiSanPham;
    }
    
    public static List<SanPham_LoaiSanPham> getSanPham_LoaiSanPham(String _tenloaisanpham) throws ClassNotFoundException, SQLException{
        List<SanPham_LoaiSanPham> lst_SanPham_LoaiSanPham = new ArrayList<>();
        Connection cnn = tien_ich.connect.getConnection();
        String query = "select * from v_sanpham where TenLoaiSanPham Like '%"+_tenloaisanpham+"%'";
        PreparedStatement stm = cnn.prepareStatement(query);
        ResultSet rs = stm.executeQuery();
        while(rs.next()){
            SanPham_LoaiSanPham sp_lsp = new SanPham_LoaiSanPham();
            sp_lsp.setMasanpham(rs.getInt("MaSanPham"));
            sp_lsp.setTensanpham(rs.getString("TenSanPham"));
            sp_lsp.setTenloaisanpham(rs.getString("TenLoaiSanPham"));
            lst_SanPham_LoaiSanPham.add(sp_lsp);
        }
        return lst_SanPham_LoaiSanPham;
    }
}
