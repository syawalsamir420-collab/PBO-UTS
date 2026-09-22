package com.mycompany.utspbo1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Syawal
 */
public class LayananInternet {
    protected String idPaket;
    protected String namaLayanan;
    protected double harga;
    protected int stok;

    public LayananInternet(String idPaket, String namaLayanan, double harga, int stok) {
        this.idPaket = idPaket;
        this.namaLayanan = namaLayanan;
        this.harga = harga;
        this.stok = stok;
    }

    public String getIdPaket() { return idPaket; }
    public String getNamaLayanan() { return namaLayanan; }
    public double getHarga() { return harga; }
    public void setHarga(double harga) { this.harga = harga; }
    public int getStok() { return stok; }
    public void setStok(int stok) { this.stok = stok; }

    public void tampilkanDetail() {
        System.out.println("ID Paket     : " + idPaket);
        System.out.println("Nama Layanan : " + namaLayanan);
        System.out.println("Harga        : Rp " + harga);
        System.out.println("Stok Tersedia: " + stok + " Pcs");
    }
}