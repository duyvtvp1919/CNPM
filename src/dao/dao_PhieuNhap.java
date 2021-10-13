/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.PhieuNhap;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class dao_PhieuNhap {
    public static List<PhieuNhap> getAllPN() throws ClassNotFoundException, SQLException{
        List<PhieuNhap> lstPhieuNhap = new ArrayList<>();
        Connection cnn = tien_ich.connect.getConnection();
        String query = "select * from PhieuNhap ";
        PreparedStatement stm = cnn.prepareStatement(query);
        ResultSet rs = stm.executeQuery();
        while(rs.next()){
            PhieuNhap pn = new PhieuNhap();
            pn.setMaphieunhap(rs.getInt("MaPhieuNhap"));
            pn.setManhanvien(rs.getInt("MaNhanVien"));
            pn.setManhaphanphoi(rs.getInt("MaNhaPhanPhoi"));
            pn.setTongtien(rs.getString("TongTien"));
            pn.setNgaynhap(rs.getString("NgayNhap"));
            lstPhieuNhap.add(pn);
        }
        return lstPhieuNhap;
    }
    
    public static void insertPN(PhieuNhap pn) throws SQLException, ClassNotFoundException{
        Connection conn = tien_ich.connect.getConnection();
        String inSert = "insert into PhieuNhap(MaPhieuNhap,MaNhanVien,MaNhaPhanPhoi,TongTien,NgayNhap) values('"+pn.getMaphieunhap()+"'"
                + ",'"+pn.getManhanvien()+"','"+pn.getManhaphanphoi()+"','"+pn.getTongtien()+"','"+pn.getNgaynhap()+"')";
        PreparedStatement stm = conn.prepareStatement(inSert);
        stm.executeUpdate();
        tien_ich.connect.closePreparedStatement(stm);
        tien_ich.connect.closeConnection(conn);
    }
   
   public static void updatePN(PhieuNhap pn) throws SQLException, ClassNotFoundException{
        Connection conn = tien_ich.connect.getConnection();
        String upDate = "update PhieuNhap set MaPhieuNhap = '"+pn.getMaphieunhap()+"'"
                + ",MaNhanVien = '"+pn.getManhanvien()+"',MaNhaPhanPhoi = '"+pn.getManhaphanphoi()+"',TongTien = '"+pn.getTongtien()+"'"
                + ",NgayNhap = '"+pn.getNgaynhap()+"' where MaPhieuNhap = '"+pn.getMaphieunhap()+"'";
        PreparedStatement stm = conn.prepareStatement(upDate);
        stm.executeUpdate();
        tien_ich.connect.closePreparedStatement(stm);
        tien_ich.connect.closeConnection(conn);
    }
    
    public static void deletePN(String maphieunhap) throws ClassNotFoundException, SQLException{
        Connection conn = tien_ich.connect.getConnection();
        String delete = "delete from PhieuNhap where MaPhieuNhap = '"+maphieunhap+"'";
        PreparedStatement stm = conn.prepareStatement(delete);
        stm.executeUpdate();
        tien_ich.connect.closePreparedStatement(stm);
        tien_ich.connect.closeConnection(conn);
    }
    public static List<PhieuNhap> baseondate(Date ngaydau, Date ngaycuoi) throws ClassNotFoundException, SQLException{
        List<PhieuNhap> lstPhieuNhap = new ArrayList<>();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Connection cnn = tien_ich.connect.getConnection();
        String query = "select * from PhieuNhap where NgayNhap > '" + dateFormat.format(ngaydau) + "' and NgayNhap < '" + dateFormat.format(ngaycuoi) + "'";
        PreparedStatement stm = cnn.prepareStatement(query);
        ResultSet rs = stm.executeQuery();
        while(rs.next()){
            PhieuNhap pn = new PhieuNhap();
            pn.setMaphieunhap(rs.getInt("MaPhieuNhap"));
            pn.setManhanvien(rs.getInt("MaNhanVien"));
            pn.setManhaphanphoi(rs.getInt("MaNhaPhanPhoi"));
            pn.setTongtien(rs.getString("TongTien"));
            pn.setNgaynhap(rs.getString("NgayNhap"));
            lstPhieuNhap.add(pn);
        }
        return lstPhieuNhap;
    }
}
