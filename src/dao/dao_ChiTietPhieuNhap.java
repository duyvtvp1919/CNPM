/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import entity.ChiTietPhieuNhap;
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
public class dao_ChiTietPhieuNhap {
    public static List<ChiTietPhieuNhap> getAllCTPN() throws ClassNotFoundException, SQLException{
        List<ChiTietPhieuNhap> lst_ctpn = new ArrayList<>();
        Connection cnn = tien_ich.connect.getConnection();
        String query = "select * from ChiTietPhieuNhap";
        PreparedStatement stm = cnn.prepareStatement(query);
        ResultSet rs = stm.executeQuery();
        while(rs.next()){
            ChiTietPhieuNhap ctpn = new ChiTietPhieuNhap();
            ctpn.setMactpn(rs.getInt("MaCTPN"));
            ctpn.setMaphieunhap(rs.getInt("MaPhieuNhap"));
            ctpn.setMasanpham(rs.getInt("MaSanPham"));
            ctpn.setSoluong(rs.getInt("SoLuong"));
            ctpn.setDongia(rs.getString("DonGia"));
            lst_ctpn.add(ctpn);
        }
        return lst_ctpn;
    }
    
    public static void insertCTPN(ChiTietPhieuNhap ctpn) throws SQLException, ClassNotFoundException{
        Connection conn = tien_ich.connect.getConnection();
        String inSert = "insert into ChiTietPhieuNhap(MaCTPN,MaPhieuNhap,MaSanPham,SoLuong,DonGia) values('"+ctpn.getMactpn()+"'"
                + ",'"+ctpn.getMaphieunhap()+"','"+ctpn.getMasanpham()+"','"+ctpn.getSoluong()+"','"+ctpn.getDongia()+"')";
        PreparedStatement stm = conn.prepareStatement(inSert);
        stm.executeUpdate();
        tien_ich.connect.closePreparedStatement(stm);
        tien_ich.connect.closeConnection(conn);
    }
   
   public static void updateCTPN(ChiTietPhieuNhap ctpn) throws SQLException, ClassNotFoundException{
        Connection conn = tien_ich.connect.getConnection();
        String upDate = "update ChiTietPhieuNhap set MaCTPN = '"+ctpn.getMactpn()+"'"
                + ",MaPhieuNhap = '"+ctpn.getMaphieunhap()+"',MaSanPham = '"+ctpn.getMasanpham()+"',SoLuong = '"+ctpn.getSoluong()+"'"
                + ",DonGia = '"+ctpn.getDongia()+"' where MaCTPN = '"+ctpn.getMactpn()+"'";
        PreparedStatement stm = conn.prepareStatement(upDate);
        stm.executeUpdate();
        tien_ich.connect.closePreparedStatement(stm);
        tien_ich.connect.closeConnection(conn);
    }
    
    public static void deleteCTPN(String machitietphieunhap) throws ClassNotFoundException, SQLException{
        Connection conn = tien_ich.connect.getConnection();
        String delete = "delete from ChiTietPhieuNhap where MaCTPN = '"+machitietphieunhap+"'";
        PreparedStatement stm = conn.prepareStatement(delete);
        stm.executeUpdate();
        tien_ich.connect.closePreparedStatement(stm);
        tien_ich.connect.closeConnection(conn);
    }
}
