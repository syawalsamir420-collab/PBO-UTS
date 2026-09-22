/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.utspbo1;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Syawal
 */
public class ManajerGudang {

public static void cetakHeader() {
System.out.println("=");
System.out.println("                SYSTEM INVENTARIS GUDANG INTERNET                      ");
System.out.println("=");
}

// Method Overloading 2: Dengan parameter nama petugas
public static void cetakHeader(String namaPetugas) {
cetakHeader();
System.out.println(" Petugas Login : " + namaPetugas);
System.out.println(" Tanggal/Sesi  : " + java.time.LocalDate.now());
System.out.println("=======================================================================\n");
}

// Method Overloading 3: Dengan kriteria pencarian kategori
public static void cetakSummary(List<LayananInternet> daftarProduk) {
int totalStok = 0;
double totalNilaiInventaris = 0;

 // Looping (For-Each)
 for (LayananInternet item : daftarProduk) {
     totalStok += item.getStok();
     totalNilaiInventaris += (item.getHarga() * item.getStok());
 }

 System.out.println("\n=======================================================================");
 System.out.println("                         RINGKASAN GUDANG                              ");
 System.out.println("=======================================================================");
 System.out.println(" Total Jenis Produk : " + daftarProduk.size() + " Item");
 System.out.println(" Total Unit Stok   : " + totalStok + " Pcs");
 System.out.printf(" Total Valuasi     : Rp %,.2f\n", totalNilaiInventaris);
 System.out.println("=======================================================================");


}
}
