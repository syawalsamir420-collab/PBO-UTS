/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.utspbo1;

public class PaketUnlimited extends PaketData {
    private String batasFUP;
    private String kecepatanBypass;

    // Constructor dengan 6 parameter
    public PaketUnlimited(String idPaket, String namaLayanan, double harga, int stok, int kuotaGB, String batasFUP) {
        super(idPaket, namaLayanan, harga, stok, kuotaGB);
        this.batasFUP = batasFUP;
        this.kecepatanBypass = "10 Mbps";
    }

    // Constructor dengan 7 parameter
    public PaketUnlimited(String idPaket, String namaLayanan, double harga, int stok, int kuotaGB, String batasFUP, String kecepatanBypass) {
        super(idPaket, namaLayanan, harga, stok, kuotaGB);
        this.batasFUP = batasFUP;
        this.kecepatanBypass = kecepatanBypass;
    }

    @Override
    public void tampilkanDetail() {
        super.tampilkanDetail();
        System.out.printf(" Batas FUP     : %s/hari\n", batasFUP);
        System.out.printf(" Kecepatan     : Max %s\n", kecepatanBypass);
        System.out.println(" Fitur Khusus  : Unlimited 24 Jam Anti Kehabisan Kuota!");
    }

    public String getBatasFUP() {
        return batasFUP;
    }

    public void setBatasFUP(String batasFUP) {
        this.batasFUP = batasFUP;
    }

    public String getKecepatanBypass() {
        return kecepatanBypass;
    }

    public void setKecepatanBypass(String kecepatanBypass) {
        this.kecepatanBypass = kecepatanBypass;
    }
}