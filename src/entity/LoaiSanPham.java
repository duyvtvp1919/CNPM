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
public class LoaiSanPham {
    int maloaisanpham;
    String tenloaisanpham;
    
    public LoaiSanPham(){
        
    }
    public LoaiSanPham(int maloaisanpham, String tenloaisanpham) {
        this.maloaisanpham = maloaisanpham;
        this.tenloaisanpham = tenloaisanpham;
    }

    public int getMaloaisanpham() {
        return maloaisanpham;
    }

    public void setMaloaisanpham(int maloaisanpham) {
        this.maloaisanpham = maloaisanpham;
    }

    public String getTenloaisanpham() {
        return tenloaisanpham;
    }

    public void setTenloaisanpham(String tenloaisanpham) {
        this.tenloaisanpham = tenloaisanpham;
    }
}
