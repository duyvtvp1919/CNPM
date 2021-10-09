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
public class SanPham {
    int masanpham;
    String tensanpham;
    int maloaisanpham;
    String noisanxuat;
    String gianhap;
    String giaban;
    int tonkho;
    
    public SanPham(){
        
    }
    public SanPham(int masanpham, String tensanpham, int maloaisanpham, String noisanxuat, String gianhap, String giaban, int tonkho) {
        this.masanpham = masanpham;
        this.tensanpham = tensanpham;
        this.maloaisanpham = maloaisanpham;
        this.noisanxuat = noisanxuat;
        this.gianhap = gianhap;
        this.giaban = giaban;
        this.tonkho = tonkho;
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

    public int getMaloaisanpham() {
        return maloaisanpham;
    }

    public void setMaloaisanpham(int maloaisanpham) {
        this.maloaisanpham = maloaisanpham;
    }

    public String getNoisanxuat() {
        return noisanxuat;
    }

    public void setNoisanxuat(String noisanxuat) {
        this.noisanxuat = noisanxuat;
    }

    public String getGianhap() {
        return gianhap;
    }

    public void setGianhap(String gianhap) {
        this.gianhap = gianhap;
    }

    public String getGiaban() {
        return giaban;
    }

    public void setGiaban(String giaban) {
        this.giaban = giaban;
    }

    public int getTonkho() {
        return tonkho;
    }

    public void setTonkho(int tonkho) {
        this.tonkho = tonkho;
    }

    
    
}
