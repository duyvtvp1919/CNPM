/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.ChiTietHoaDon;
import entity.TTHoaDon;
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
public class dao_TTHoaDon {
    public static List<TTHoaDon> getTTHD(int mahd) throws ClassNotFoundException, SQLException{
        List<TTHoaDon> lst_ctpn = new ArrayList<>();
        Connection cnn = tien_ich.connect.getConnection();
        String query = "select * from TTHoaDon where MaHoaDon = '" + mahd +"'";
        PreparedStatement stm = cnn.prepareStatement(query);
        ResultSet rs = stm.executeQuery();
        while(rs.next()){
            TTHoaDon ctpn = new TTHoaDon();
            ctpn.setMasanpham(rs.getInt("MaSanPham"));
            ctpn.setSoluong(rs.getInt("SoLuong"));
            ctpn.setMahoadon(mahd);
            lst_ctpn.add(ctpn);
        }
        return lst_ctpn;
    }
    
    public static void insertTTHD(TTHoaDon ctpn) throws SQLException, ClassNotFoundException{
        Connection conn = tien_ich.connect.getConnection();
        String inSert = "insert into TTHoaDon(MaSanPham,SoLuong,MaHoaDon) values('"+ctpn.getMasanpham()+"'"
                +",'"+ctpn.getSoluong()+"'" + ", '" + ctpn.getMahoadon() + "')";
        PreparedStatement stm = conn.prepareStatement(inSert);
        stm.executeUpdate();
        tien_ich.connect.closePreparedStatement(stm);
        tien_ich.connect.closeConnection(conn);
    }
    
    public static void deleteTTHD(String maphieunhap) throws ClassNotFoundException, SQLException{
        Connection conn = tien_ich.connect.getConnection();
        String delete = "delete from TTHoaDon where MaHoaDon = '"+maphieunhap+"'";
        PreparedStatement stm = conn.prepareStatement(delete);
        stm.executeUpdate();
        tien_ich.connect.closePreparedStatement(stm);
        tien_ich.connect.closeConnection(conn);
    }
}
