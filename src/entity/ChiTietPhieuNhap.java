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
public class ChiTietPhieuNhap {
    int mactpn;
    int maphieunhap;
    int masanpham;
    int soluong;
    String dongia;

    public ChiTietPhieuNhap(int mactpn, int maphieunhap, int masanpham, int soluong, String dongia) {
        this.mactpn = mactpn;
        this.maphieunhap = maphieunhap;
        this.masanpham = masanpham;
        this.soluong = soluong;
        this.dongia = dongia;
    }
    
    public ChiTietPhieuNhap(){
    
    }

    public int getMactpn() {
        return mactpn;
    }

    public void setMactpn(int mactpn) {
        this.mactpn = mactpn;
    }

    public int getMaphieunhap() {
        return maphieunhap;
    }

    public void setMaphieunhap(int maphieunhap) {
        this.maphieunhap = maphieunhap;
    }

    public int getMasanpham() {
        return masanpham;
    }

    public void setMasanpham(int masanpham) {
        this.masanpham = masanpham;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public String getDongia() {
        return dongia;
    }

    public void setDongia(String dongia) {
        this.dongia = dongia;
    }
    
    
    
}
