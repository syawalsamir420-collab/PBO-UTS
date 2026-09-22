/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.utspbo1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<LayananInternet> inventarisGudang = new ArrayList<>();

        // Initial Data Dummy
        inventarisGudang.add(new PaketData("PKT01", "Paket Lite 20GB", 45000, 15, 20));
        inventarisGudang.add(new PaketData("PKT02", "Paket Super 60GB", 110000, 5, 60));
        inventarisGudang.add(new PaketUnlimited("PKT03", "Ultra Unlimited", 180000, 8, 100, "2 GB/Hari"));

        boolean berjalan = true;

        while (berjalan) {
            ManajerGudang.cetakHeader("Admin Gudang");
            System.out.println("=== MENU UTAMA SYSTEM GUDANG INTERNET ===");
            System.out.println("1.Tampilkan Semua Stok Paket");
            System.out.println("2.Tambah Paket Internet Baru");
            System.out.println("3.Ubah Harga / Stok Paket");
            System.out.println("4.Hapus Paket dari Gudang");
            System.out.println("5.Cetak Ringkasan Valuasi Gudang");
            System.out.println("0.Keluar Aplikasi");
            System.out.println("=========================================");
            System.out.print("Pilih Menu (0-5): ");
            
            int pilihan = input.nextInt();
            input.nextLine(); // Clear buffer

            System.out.println();

            switch (pilihan) {
                case 1:
                    // READ
                    System.out.println(">>> DAFTAR STOK GUDANG INTERNET <<<");
                    if (inventarisGudang.isEmpty()) {
                        System.out.println("Stok gudang saat ini kosong!");
                    } else {
                        for (int i = 0; i < inventarisGudang.size(); i++) {
                            System.out.println("\n--- Item Gudang #" + (i + 1) + " ---");
                            inventarisGudang.get(i).tampilkanDetail();

                            // Condition (If-Else)
                            if (inventarisGudang.get(i).getStok() < 10) {
                                System.out.println("STATUS STOK : [WARNING] Stok Menipis! Segera Restock.");
                            } else {
                                System.out.println("STATUS STOK : [AMAN] Stok Cukup.");
                            }
                        }
                    }
                    break;

                case 2:
                    // CREATE
                    System.out.println(">>> TAMBAH PAKET INTERNET BARU <<<");
                    System.out.println("Pilih Tipe Paket:");
                    System.out.println("1. Paket Data Biasa");
                    System.out.println("2. Paket Unlimited");
                    System.out.print("Pilihan (1/2): ");
                    int tipe = input.nextInt();
                    input.nextLine();

                    System.out.print("Masukkan ID Paket (ex: PKT04) : ");
                    String id = input.nextLine();
                    System.out.print("Masukkan Nama Paket           : ");
                    String nama = input.nextLine();
                    System.out.print("Masukkan Harga Paket (Rp)     : ");
                    double harga = input.nextDouble();
                    System.out.print("Masukkan Jumlah Stok          : ");
                    int stok = input.nextInt();
                    System.out.print("Masukkan Kuota Utama (GB)     : ");
                    int kuota = input.nextInt();
                    input.nextLine();

                    if (tipe == 2) {
                        System.out.print("Masukkan Batas FUP (ex: 2GB/Hari): ");
                        String fup = input.nextLine();
                        inventarisGudang.add(new PaketUnlimited(id, nama, harga, stok, kuota, fup));
                    } else {
                        inventarisGudang.add(new PaketData(id, nama, harga, stok, kuota));
                    }
                    System.out.println("\n[SUCCESS] Paket berhasil ditambahkan ke gudang!");
                    break;

                case 3:
                    // UPDATE
                    System.out.println(">>> UPDATE STOK / HARGA PAKET <<<");
                    System.out.print("Masukkan ID Paket yang ingin diubah: ");
                    String idUpdate = input.nextLine();
                    
                    LayananInternet itemUpdate = cariPaketById(inventarisGudang, idUpdate);
                    if (itemUpdate != null) {
                        System.out.println("Data Ditemukan: " + itemUpdate.getNamaLayanan());
                        System.out.print("Masukkan Harga Baru (0 jika tidak ubah) : Rp ");
                        double hargaBaru = input.nextDouble();
                        System.out.print("Masukkan Stok Baru (-1 jika tidak ubah) : ");
                        int stokBaru = input.nextInt();

                        if (hargaBaru > 0) itemUpdate.setHarga(hargaBaru);
                        if (stokBaru >= 0) itemUpdate.setStok(stokBaru);

                        System.out.println("\n[SUCCESS] Data paket berhasil diperbarui!");
                    } else {
                        System.out.println("[ERROR] Paket dengan ID " + idUpdate + " tidak ditemukan!");
                    }
                    break;

                case 4:
                    // DELETE
                    System.out.println(">>> HAPUS PAKET DARI GUDANG <<<");
                    System.out.print("Masukkan ID Paket yang ingin dihapus: ");
                    String idDelete = input.nextLine();

                    LayananInternet itemDelete = cariPaketById(inventarisGudang, idDelete);
                    if (itemDelete != null) {
                        inventarisGudang.remove(itemDelete);
                        System.out.println("\n[SUCCESS] Paket " + itemDelete.getNamaLayanan() + " berhasil dihapus!");
                    } else {
                        System.out.println("[ERROR] Paket dengan ID " + idDelete + " tidak ditemukan!");
                    }
                    break;

                case 5:
                    // INFO & SUMMARY
                    ManajerGudang.cetakSummary(inventarisGudang);
                    break;

                case 0:
                    berjalan = false;
                    System.out.println("Terima kasih telah menggunakan System Gudang Internet!");
                    break;

                default:
                    System.out.println("Pilihan tidak valid, silakan coba lagi.");
            }

            if (berjalan) {
                System.out.print("\nTekan Enter untuk melanjutkan...");
                input.nextLine();
            }
        }
        input.close();
    }

    private static LayananInternet cariPaketById(List<LayananInternet> list, String id) {
        for (LayananInternet item : list) {
            if (item.getIdPaket().equalsIgnoreCase(id)) {
                return item;
            }
        }
        return null;
    }
}