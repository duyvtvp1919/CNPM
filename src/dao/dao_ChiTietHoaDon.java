/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.ChiTietHoaDon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class dao_ChiTietHoaDon {
    public static List<ChiTietHoaDon> getAllCTPN() throws ClassNotFoundException, SQLException{
        List<ChiTietHoaDon> lst_ctpn = new ArrayList<>();
        Connection cnn = tien_ich.connect.getConnection();
        String query = "select * from ChiTietHoaDon";
        PreparedStatement stm = cnn.prepareStatement(query);
        ResultSet rs = stm.executeQuery();
        while(rs.next()){
            ChiTietHoaDon ctpn = new ChiTietHoaDon();
            ctpn.setMasanpham(rs.getInt("MaSanPham"));
            ctpn.setSoluong(rs.getInt("SoLuong"));
            lst_ctpn.add(ctpn);
        }
        return lst_ctpn;
    }
    
    public static void insertCTPN(ChiTietHoaDon ctpn) throws SQLException, ClassNotFoundException{
        Connection conn = tien_ich.connect.getConnection();
        String inSert = "insert into ChiTietHoaDon(MaSanPham,SoLuong) values('"+ctpn.getMasanpham()+"'"
                +",'"+ctpn.getSoluong()+"')";
        PreparedStatement stm = conn.prepareStatement(inSert);
        stm.executeUpdate();
        tien_ich.connect.closePreparedStatement(stm);
        tien_ich.connect.closeConnection(conn);
    }
   
   public static void updateCTPN(ChiTietHoaDon ctpn) throws SQLException, ClassNotFoundException{
        Connection conn = tien_ich.connect.getConnection();
        String upDate = "update ChiTietHoaDon set MaSanPham = '"+ctpn.getMasanpham()+"',SoLuong = '"+ctpn.getSoluong()+"'";
        PreparedStatement stm = conn.prepareStatement(upDate);
        stm.executeUpdate();
        tien_ich.connect.closePreparedStatement(stm);
        tien_ich.connect.closeConnection(conn);
    }
    
    public static void deleteCTPN(String msp) throws ClassNotFoundException, SQLException{
        Connection conn = tien_ich.connect.getConnection();
        String delete = "delete from ChiTietHoaDon where MaSanPham = '"+msp+"'";
        PreparedStatement stm = conn.prepareStatement(delete);
        stm.executeUpdate();
        tien_ich.connect.closePreparedStatement(stm);
        tien_ich.connect.closeConnection(conn);
    }
    
    public static void remove() throws ClassNotFoundException, SQLException{
        Connection conn = tien_ich.connect.getConnection();
        String remove = "delete from ChiTietHoaDon";
        PreparedStatement stm = conn.prepareStatement(remove);
        stm.executeUpdate();
        tien_ich.connect.closePreparedStatement(stm);
        tien_ich.connect.closeConnection(conn);
    }
}
