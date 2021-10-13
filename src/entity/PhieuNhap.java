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
public class PhieuNhap {
    int maphieunhap;
    int manhanvien;
    int manhaphanphoi;
    String tongtien;
    String ngaynhap;

    public PhieuNhap(int maphieunhap, int manhanvien, int manhaphanphoi, String tongtien, String ngaynhap) {
        this.maphieunhap = maphieunhap;
        this.manhanvien = manhanvien;
        this.manhaphanphoi = manhaphanphoi;
        this.tongtien = tongtien;
        this.ngaynhap = ngaynhap;
    }
    public PhieuNhap(){
    
    }

    public int getMaphieunhap() {
        return maphieunhap;
    }

    public void setMaphieunhap(int maphieunhap) {
        this.maphieunhap = maphieunhap;
    }

    public int getManhanvien() {
        return manhanvien;
    }

    public void setManhanvien(int manhanvien) {
        this.manhanvien = manhanvien;
    }

    public int getManhaphanphoi() {
        return manhaphanphoi;
    }

    public void setManhaphanphoi(int manhaphanphoi) {
        this.manhaphanphoi = manhaphanphoi;
    }

    public String getTongtien() {
        return tongtien;
    }

    public void setTongtien(String tongtien) {
        this.tongtien = tongtien;
    }

    public String getNgaynhap() {
        return ngaynhap;
    }

    public void setNgaynhap(String ngaynhap) {
        this.ngaynhap = ngaynhap;
    }
    
}
