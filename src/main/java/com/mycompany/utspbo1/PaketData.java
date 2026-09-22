/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.utspbo1;

public class PaketData extends LayananInternet {
    protected int kuotaGB;

    // Constructor dengan 5 parameter
    public PaketData(String idPaket, String namaLayanan, double harga, int stok, int kuotaGB) {
        super(idPaket, namaLayanan, harga, stok);
        this.kuotaGB = kuotaGB;
    }

    @Override
    public void tampilkanDetail() {
        super.tampilkanDetail();
        System.out.printf(" Kuota Utama   : %d GB\n", kuotaGB);
        
        // CONDITION (If-Else)
        if (kuotaGB >= 50) {
            System.out.println(" Kategori      : Paket Jumbo / High Usage");
        } else {
            System.out.println(" Kategori      : Paket Reguler / Normal");
        }
    }

    public int getKuotaGB() {
        return kuotaGB;
    }

    public void setKuotaGB(int kuotaGB) {
        this.kuotaGB = kuotaGB;
    }
}