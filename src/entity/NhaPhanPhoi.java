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
public class NhaPhanPhoi {
    int manhaphanphoi;
    String tennhaphanphoi;
    String diachi;
    String sdt;
    String email;

    public NhaPhanPhoi() {
    
    }
    public NhaPhanPhoi(int manhaphanphoi, String tennhaphanphoi, String diachi, String sdt, String email) {
        this.manhaphanphoi = manhaphanphoi;
        this.tennhaphanphoi = tennhaphanphoi;
        this.diachi = diachi;
        this.sdt = sdt;
        this.email = email;
    }

    public int getManhaphanphoi() {
        return manhaphanphoi;
    }

    public void setManhaphanphoi(int manhaphanphoi) {
        this.manhaphanphoi = manhaphanphoi;
    }

    public String getTennhaphanphoi() {
        return tennhaphanphoi;
    }

    public void setTennhaphanphoi(String tennhaphanphoi) {
        this.tennhaphanphoi = tennhaphanphoi;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
  
}
