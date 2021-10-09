/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author ADMIN
 */
public class SanPham_LoaiSanPham {
    int masanpham;
    String tensanpham;
    String tenloaisanpham;

    public SanPham_LoaiSanPham() {
        
    }

    public SanPham_LoaiSanPham(int masanpham, String tensanpham, String tenloaisanpham) {
        this.masanpham = masanpham;
        this.tensanpham = tensanpham;
        this.tenloaisanpham = tenloaisanpham;
    }

    public int getMasanpham() {
        return masanpham;
    }

    public void setMasanpham(int masanpham) {
        this.masanpham = masanpham;
    }

    public String getTensanpham() {
        return tensanpham;
    }

    public void setTensanpham(String tensanpham) {
        this.tensanpham = tensanpham;
    }

    public String getTenloaisanpham() {
        return tenloaisanpham;
    }

    public void setTenloaisanpham(String tenloaisanpham) {
        this.tenloaisanpham = tenloaisanpham;
    }


    
}
