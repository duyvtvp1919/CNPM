/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.KhachHang;
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
public class dao_KhachHang {
    public static List<KhachHang> getAllKH() throws ClassNotFoundException, SQLException{
        List<KhachHang> lstKhachHang = new ArrayList<>();
        Connection cnn = tien_ich.connect.getConnection();
        String query = "select * from KhachHang";
        PreparedStatement stm = cnn.prepareStatement(query);
        ResultSet rs = stm.executeQuery();
        while(rs.next()){
            KhachHang kh = new KhachHang();
            kh.setMakh(rs.getInt("MaKhachHang"));
            kh.setTenkh(rs.getString("TenKhachHang"));
            kh.setNgaysinhkh(rs.getString("NgaySinh"));
            kh.setGioitinh(rs.getInt("GioiTinh"));
            kh.setDiachi(rs.getString("DiaChi"));
            kh.setSdt(rs.getString("Sdt"));
            lstKhachHang.add(kh);
        }
        return lstKhachHang;
    }
    public static void insertKH(KhachHang kh) throws SQLException, ClassNotFoundException{
        Connection conn = tien_ich.connect.getConnection();
        String inSert = "insert into KhachHang(MaKhachHang,TenKhachHang,NgaySinh,GioiTinh,DiaChi,Sdt) values('"+kh.getMakh()+"',"
                + "'"+kh.getTenkh()+"','"+kh.getNgaysinhkh()+"','"+kh.getGioitinh()+"',"
                + "'"+kh.getDiachi()+"','"+kh.getSdt()+"')";
        PreparedStatement stm = conn.prepareStatement(inSert);
        stm.executeUpdate();
        tien_ich.connect.closePreparedStatement(stm);
        tien_ich.connect.closeConnection(conn);
    }
    public static void deleteKH(String makh) throws ClassNotFoundException, SQLException{
        Connection conn = tien_ich.connect.getConnection();
        String delete = "delete from KhachHang where MaKhachHang = '"+makh+"'";
        PreparedStatement stm = conn.prepareStatement(delete);
        stm.executeUpdate();
        tien_ich.connect.closePreparedStatement(stm);
        tien_ich.connect.closeConnection(conn);
    }
    public static void updateKH(KhachHang kh) throws ClassNotFoundException, SQLException{
        Connection conn = tien_ich.connect.getConnection();
        String upDate = "update KhachHang set  TenKhachHang = '"+kh.getTenkh()+"',"
                + "NgaySinh='"+kh.getNgaysinhkh()+"',GioiTinh='"+kh.getGioitinh()+"',"
                + "DiaChi='"+kh.getDiachi()+"',"
                + "Sdt='"+kh.getSdt()+"' where MaKhachHang = '"+kh.getMakh()+"'";
        PreparedStatement stm = conn.prepareStatement(upDate);
        stm.executeUpdate();
        tien_ich.connect.closePreparedStatement(stm);
        tien_ich.connect.closeConnection(conn);
    }
    public static List<KhachHang> searchKH(String tk) throws ClassNotFoundException, SQLException{
        List<KhachHang> lstKhachHang = new ArrayList<>();
        Connection cnn = tien_ich.connect.getConnection();
        String query = "select * from KhachHang where TenKhachHang like '%"+tk+"%'";
        PreparedStatement stm = cnn.prepareStatement(query);
        ResultSet rs = stm.executeQuery();
        while(rs.next()){
            KhachHang kh = new KhachHang();
            kh.setMakh(rs.getInt("MaKhachHang"));
            kh.setTenkh(rs.getString("TenKhachHang"));
            kh.setNgaysinhkh(rs.getString("NgaySinh"));
            kh.setGioitinh(rs.getInt("GioiTinh"));
            kh.setDiachi(rs.getString("DiaChi"));
            kh.setSdt(rs.getString("Sdt"));
            lstKhachHang.add(kh);
        }
        return lstKhachHang;
    }
}
