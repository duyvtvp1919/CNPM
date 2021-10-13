/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import entity.HoaDon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

/**
 *
 * @author LENOVO
 */



public class dao_HoaDon {
    public static List<HoaDon> getAllHD() throws ClassNotFoundException, SQLException{
        List<HoaDon> lstHoaDon = new ArrayList<>();
        Connection cnn = tien_ich.connect.getConnection();
        String query = "select * from HoaDon ";
        PreparedStatement stm = cnn.prepareStatement(query);
        ResultSet rs = stm.executeQuery();
        while(rs.next()){
            HoaDon pn = new HoaDon();
            pn.setMahoadon(rs.getInt("MaHoaDon"));
            pn.setManhanvien(rs.getString("MaNhanVien"));
            pn.setTongtien(rs.getString("TongTien"));
            pn.setNgaylap(rs.getString("NgayLapHoaDon"));
            pn.setMakhachhang(rs.getString("MaKhachHang"));
            lstHoaDon.add(pn);
        }
        return lstHoaDon;
    }
    
    public static void insertHD(HoaDon pn) throws SQLException, ClassNotFoundException{
        Connection conn = tien_ich.connect.getConnection();
        String inSert = "insert into HoaDon(MaHoaDon,MaNhanVien,TongTien,NgayLapHoaDon,MaKhachHang) values('"+pn.getMahoadon()+"'"
                + ",'"+pn.getManhanvien()+"','"+pn.getTongtien()+"','"+pn.getNgaylap()+"','"+pn.getMakhachhang()+"')";
        PreparedStatement stm = conn.prepareStatement(inSert);
        stm.executeUpdate();
        tien_ich.connect.closePreparedStatement(stm);
        tien_ich.connect.closeConnection(conn);
    }
   
   public static void updateHD(HoaDon pn) throws SQLException, ClassNotFoundException{
        Connection conn = tien_ich.connect.getConnection();
        String upDate = "update HoaDon set MaHoaDon = '"+pn.getMahoadon()+"'"
                + ",MaNhanVien = '"+pn.getManhanvien()+"',TongTien = '"+pn.getTongtien()+"',MaKhachHang = '"+pn.getMakhachhang()+"'"
                + ",NgayLapHoaDon = '"+pn.getNgaylap()+"' where MaHoaDon = '"+pn.getMahoadon()+"'";
        PreparedStatement stm = conn.prepareStatement(upDate);
        stm.executeUpdate();
        tien_ich.connect.closePreparedStatement(stm);
        tien_ich.connect.closeConnection(conn);
    }
    
    public static void deletePN(String maphieunhap) throws ClassNotFoundException, SQLException{
        Connection conn = tien_ich.connect.getConnection();
        String delete = "delete from HoaDon where MaHoaDon = '"+maphieunhap+"'";
        PreparedStatement stm = conn.prepareStatement(delete);
        stm.executeUpdate();
        tien_ich.connect.closePreparedStatement(stm);
        tien_ich.connect.closeConnection(conn);
    }
    public static List<HoaDon> baseondate(Date ngaydau, Date ngaycuoi) throws ClassNotFoundException, SQLException{
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        List<HoaDon> lstHoaDon = new ArrayList<>();
        Connection cnn = tien_ich.connect.getConnection();
        String query = "select * from HoaDon where NgayLapHoaDon >= '" + dateFormat.format(ngaydau) + "' and NgayLapHoaDon <= '" + dateFormat.format(ngaycuoi) + "'";
        PreparedStatement stm = cnn.prepareStatement(query);
        ResultSet rs = stm.executeQuery();
        while(rs.next()){
            HoaDon pn = new HoaDon();
            pn.setMahoadon(rs.getInt("MaHoaDon"));
            pn.setManhanvien(rs.getString("MaNhanVien"));
            pn.setTongtien(rs.getString("TongTien"));
            pn.setNgaylap(rs.getString("NgayLapHoaDon"));
            pn.setMakhachhang(rs.getString("MaKhachHang"));
            lstHoaDon.add(pn);
        }
        return lstHoaDon;
    }
}
