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
public class TTHoaDon {
    int masanpham;
    int soluong;
    int mahoadon;

    public TTHoaDon() {
    }

    public TTHoaDon(int masanpham, int soluong, int mahoadon) {
        this.masanpham = masanpham;
        this.soluong = soluong;
        this.mahoadon = mahoadon;
    }

    public void setMasanpham(int masanpham) {
        this.masanpham = masanpham;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public void setMahoadon(int mahoadon) {
        this.mahoadon = mahoadon;
    }

    public int getMasanpham() {
        return masanpham;
    }

    public int getSoluong() {
        return soluong;
    }

    public int getMahoadon() {
        return mahoadon;
    }
    
    
}
