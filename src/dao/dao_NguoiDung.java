/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.NguoiDung;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class dao_NguoiDung {
    public static List<NguoiDung> getOne(String _taikhoan, String _pass) throws ClassNotFoundException, SQLException{
        List<NguoiDung>lstNguoiDung = new ArrayList<>();
        Connection cnn = tien_ich.connect.getConnection();
        String query = "select * from TaiKhoan where TenDangNhap = '"+_taikhoan+"' and MatKhau = '"+_pass+"'";
        PreparedStatement stm = cnn.prepareStatement(query);
        ResultSet rs = stm.executeQuery();
        while (rs.next()){
            NguoiDung x = new NguoiDung();
            x.setUsername(rs.getString("TenDangNhap"));
            x.setPass(rs.getString("MatKhau"));
            lstNguoiDung.add(x);
        }
        return lstNguoiDung;
    }
    public static void insertND(NguoiDung nd) throws SQLException, ClassNotFoundException{
        Connection conn = tien_ich.connect.getConnection();
        String TenDangNhap = nd.getUsername().trim();
        String MatKhau = nd.getPass().trim();
        String inSert = "insert into TaiKhoan(TenDangNhap,MatKhau) values('"+TenDangNhap+"','"+MatKhau+"')";
        PreparedStatement stm = conn.prepareStatement(inSert);
        stm.executeUpdate();
        tien_ich.connect.closePreparedStatement(stm);
        tien_ich.connect.closeConnection(conn);
    }
}
