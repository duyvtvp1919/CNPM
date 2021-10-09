/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.NhaPhanPhoi;
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
public class dao_NhaPhanPhoi {
    public static List<NhaPhanPhoi> getAllNPP() throws ClassNotFoundException, SQLException{
        List<NhaPhanPhoi> lst_NhaPhanPhoi = new ArrayList<>();
        Connection cnn = tien_ich.connect.getConnection();
        String query = "select * from NhaPhanPhoi";
        PreparedStatement stm = cnn.prepareStatement(query);
        ResultSet rs = stm.executeQuery();
        while(rs.next()){
            NhaPhanPhoi npp = new NhaPhanPhoi();
            npp.setManhaphanphoi(rs.getInt("MaNhaPhanPhoi"));
            npp.setTennhaphanphoi(rs.getString("TenNhaPhanPhoi"));
            npp.setDiachi(rs.getString("DiaChi"));
            npp.setSdt(rs.getString("Sdt"));
            npp.setEmail(rs.getString("Email"));  
            lst_NhaPhanPhoi.add(npp);
        }
        return lst_NhaPhanPhoi;
    }
    
    public static void insertNPP(NhaPhanPhoi npp) throws SQLException, ClassNotFoundException{
        Connection conn = tien_ich.connect.getConnection();
        String inSert = "insert into NhaPhanPhoi(MaNhaPhanPhoi,TenNhaPhanPhoi,DiaChi,Sdt,Email) values('"+npp.getManhaphanphoi()+"',"
                + "'"+npp.getTennhaphanphoi()+"','"+npp.getDiachi()+"','"+npp.getSdt()+"','"+npp.getEmail()+"')";
        PreparedStatement stm = conn.prepareStatement(inSert);
        stm.executeUpdate();
        tien_ich.connect.closePreparedStatement(stm);
        tien_ich.connect.closeConnection(conn);
    }
    
    public static void updateNPP(NhaPhanPhoi npp) throws SQLException, ClassNotFoundException{
        Connection conn = tien_ich.connect.getConnection();
        String upDate = "update NhaPhanPhoi set MaNhaPhanPhoi = '"+npp.getManhaphanphoi()+"',TenNhaPhanPhoi = '"+npp.getTennhaphanphoi()+"',"
                + "DiaChi = '"+npp.getDiachi()+"',Sdt = '"+npp.getSdt()+"',Email = '"+npp.getEmail()+"'where MaNhaPhanPhoi = '"+npp.getManhaphanphoi()+"'";
        PreparedStatement stm = conn.prepareStatement(upDate);
        stm.executeUpdate();
        tien_ich.connect.closePreparedStatement(stm);
        tien_ich.connect.closeConnection(conn);
    }
    
    public static void deleteNPP(String manhaphanphoi) throws ClassNotFoundException, SQLException{
        Connection conn = tien_ich.connect.getConnection();
        String delete = "delete from NhaPhanPhoi where MaNhaPhanPhoi = '"+manhaphanphoi+"'";
        PreparedStatement stm = conn.prepareStatement(delete);
        stm.executeUpdate();
        tien_ich.connect.closePreparedStatement(stm);
        tien_ich.connect.closeConnection(conn);
    }
    public static List<NhaPhanPhoi> searchNPP(String tk) throws ClassNotFoundException, SQLException{
        List<NhaPhanPhoi> lstNhanVien = new ArrayList<>();
        Connection cnn = tien_ich.connect.getConnection();
        String query = "select * from NhaPhanPhoi where TenNhaPhanPhoi like '%"+tk+"%'";
        PreparedStatement stm = cnn.prepareStatement(query);
        ResultSet rs = stm.executeQuery();
        while(rs.next()){
            NhaPhanPhoi nv = new NhaPhanPhoi();
            nv.setManhaphanphoi(rs.getInt("MaNhaPhanPhoi"));
            nv.setTennhaphanphoi(rs.getString("TenNhaPhanPhoi"));
            nv.setDiachi(rs.getString("DiaChi"));
            nv.setSdt(rs.getString("Sdt"));
            nv.setEmail(rs.getString("Email"));
            lstNhanVien.add(nv);
        }
        return lstNhanVien;
    }
}
