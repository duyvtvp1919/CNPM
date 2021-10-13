package dao;

import entity.NhanVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class dao_NhanVien {
    public static List<NhanVien> getAll() throws ClassNotFoundException, SQLException{
        List<NhanVien> lstNhanVien = new ArrayList<>();
        Connection cnn = tien_ich.connect.getConnection();
        String query = "select * from NhanVien";
        PreparedStatement stm = cnn.prepareStatement(query);
        ResultSet rs = stm.executeQuery();
        while(rs.next()){
            NhanVien nv = new NhanVien();
            nv.setMaNV(rs.getInt("MaNhanVien"));
            nv.setTenNV(rs.getString("TenNhanVien"));
            nv.setNgaySinh(rs.getString("NgaySinh"));
            nv.setGioiTinh(rs.getInt("GioiTinh"));
            nv.setNgayVaoLam(rs.getString("NgayVaoLam"));
            nv.setDiaChi(rs.getString("DiaChi"));
            nv.setSdt(rs.getString("Sdt"));
            lstNhanVien.add(nv);
        }
        return lstNhanVien;
    }
    public static void insertNV(NhanVien nv) throws SQLException, ClassNotFoundException{
        Connection conn = tien_ich.connect.getConnection();
        String inSert = "insert into NhanVien(MaNhanVien,TenNhanVien,NgaySinh,GioiTinh,NgayVaoLam,DiaChi,Sdt) values('"+nv.getMaNV()+"',"
                + "'"+nv.getTenNV()+"','"+nv.getNgaySinh()+"','"+nv.getGioiTinh()+"',"
                + "'"+nv.getNgayVaoLam()+"','"+nv.getDiaChi()+"','"+nv.getSdt()+"')";
        PreparedStatement stm = conn.prepareStatement(inSert);
        stm.executeUpdate();
        tien_ich.connect.closePreparedStatement(stm);
        tien_ich.connect.closeConnection(conn);
    }
    public static List<NhanVien> searchNV(String tk) throws ClassNotFoundException, SQLException{
        List<NhanVien> lstNhanVien = new ArrayList<>();
        Connection cnn = tien_ich.connect.getConnection();
        String query = "select * from NhanVien where TenNhanVien like '%"+tk+"%'";
        PreparedStatement stm = cnn.prepareStatement(query);
        ResultSet rs = stm.executeQuery();
        while(rs.next()){
            NhanVien nv = new NhanVien();
            nv.setMaNV(rs.getInt("MaNhanVien"));
            nv.setTenNV(rs.getString("TenNhanVien"));
            nv.setNgaySinh(rs.getString("NgaySinh"));
            nv.setGioiTinh(rs.getInt("GioiTinh"));
            nv.setNgayVaoLam(rs.getString("NgayVaoLam"));
            nv.setDiaChi(rs.getString("DiaChi"));
            nv.setSdt(rs.getString("Sdt"));
            lstNhanVien.add(nv);
        }
        return lstNhanVien;
    }
    
    
    public static void updateNV(NhanVien nv) throws ClassNotFoundException, SQLException{
        Connection conn = tien_ich.connect.getConnection();
        String upDate = "update NhanVien set MaNhanVien = '"+nv.getMaNV()+"', TenNhanVien = '"+nv.getTenNV()+"',"
                + "NgaySinh='"+nv.getNgaySinh()+"',GioiTinh='"+nv.getGioiTinh()+"',"
                + "NgayVaolam='"+nv.getNgayVaoLam()+"',DiaChi='"+nv.getDiaChi()+"',"
                + "Sdt='"+nv.getSdt()+"' where MaNhanVien = '"+nv.getMaNV()+"'";
        PreparedStatement stm = conn.prepareStatement(upDate);
        stm.executeUpdate();
        tien_ich.connect.closePreparedStatement(stm);
        tien_ich.connect.closeConnection(conn);
    }
    public static void deleteNV(String manv) throws ClassNotFoundException, SQLException{
        Connection conn = tien_ich.connect.getConnection();
        String delete = "delete from NhanVien where MaNhanVien = '"+manv+"'";
        PreparedStatement stm = conn.prepareStatement(delete);
        stm.executeUpdate();
        tien_ich.connect.closePreparedStatement(stm);
        tien_ich.connect.closeConnection(conn);
    }
}
