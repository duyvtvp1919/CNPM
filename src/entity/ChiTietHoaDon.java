/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author LENOVO
 */
public class ChiTietHoaDon {
    int masanpham;
    int soluong;

    public ChiTietHoaDon() {
    }

    public ChiTietHoaDon(int masanpham, int soluong) {
        this.masanpham = masanpham;
        this.soluong = soluong;
    }

    public int getMasanpham() {
        return masanpham;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setMasanpham(int masanpham) {
        this.masanpham = masanpham;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    

    
    
}
