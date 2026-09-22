<h1>Gudang Internet Comtelindo</h1>

## 👤 Identitas

| | |
|---|---|
| **NAMA** | Muhammad Syawal Samir |
| **NIM** | 2509116079 |
| **Kelas** | Sistem Informasi 25'B |
| **Tema** | Gudang Internet  |
| **UTS PBO** | 1 |

<h1>1. Gambaran Umum Program</h1>

Aplikasi ini adalah sistem manajemen inventaris berbasis konsol (CLI) yang digunakan untuk mengelola data stok paket internet pada sebuah gudang distributor.

Program ini memiliki fitur CRUD (Create, Read, Update, Delete) lengkap serta fitur Analytics/Valuasi untuk menghitung total nilai aset gudang secara otomatis.

<h1>2. Penerapan Konsep OOP (Object-Oriented Programming)</h1>

**A. Inheritance (Pewarisan Kelas)**

- Single Inheritance: Kelas PaketData mewarisi properti dasar (seperti idPaket, namaLayanan, harga, stok) dari superclass LayananInternet.

- Multilevel Inheritance: Kelas PaketUnlimited mewarisi seluruh variabel dan method dari PaketData yang merupakan turunan dari LayananInternet.

**B. Polymorphism (Banyak Bentuk)**

- Method Overriding:

  - Class PaketData dan PaketUnlimited meng-override method tampilkanDetail().

  - Saat dipanggil dari list List<LayananInternet>, Java secara otomatis menentukan tampilan detail sesuai tipe objek aslinya (Dynamic Binding).

- Method Overloading:

  - Di dalam ManajerGudang.java, terdapat pemanggilan method cetakHeader() dengan jumlah/tipe parameter berbeda.

**C. Encapsulation (Pembungkusan Data)**

  - Penggunaan akses atribut protected dan private untuk melindungi variabel agar tidak diubah sembarangan dari luar kelas.

  - Penggunaan Getter & Setter (getIdPaket(), setHarga(), dll) untuk mengakses dan memperbarui data secara aman.

**D. Abstraksi & Modul**

  - Kode dipisah menjadi beberapa modul terstruktur dalam package com.mycompany.utspbo1 agar mudah dipelihara (maintainable).

<h1>3. Struktur File & Perannya</h1>

| Nama File | Jenis Class | Tipe Inheritance | Deklarasi Variabel Utama | Method Utama | Deskripsi & Peran |
| :--- | :--- | :--- | :--- | :--- | :--- |
| LayananInternet.java | Superclass (Parent) | - (Awal) | idPaket, namaLayanan, harga, stok | tampilkanDetail(), *Getter/Setter* | Menjadi fondasi/dasar kelas untuk semua jenis layanan internet. |
| PaketData.java | Subclass (Child) | Single Inheritance | kuotaGB | tampilkanDetail() *(Override)* | Turunan dari LayananInternet khusus paket data kuota. |
| PaketUnlimited.java | Subclass (Grandchild) | Multilevel Inheritance | batasFUP, kecepatanBypass | tampilkanDetail() *(Override)* | Turunan dari PaketData khusus paket kuota tanpa batas. |
| ManajerGudang.java | Utility Class | - | - | cetakHeader() *(Overloading)*, cetakSummary() | Menyediakan fungsi pencetakan header dan analisis valuasi stok. |
| Main.java | Driver Class | - | inventarisGudang *(ArrayList)* | main(), `cariPaketById() | Eksekusi utama program yang menjalankan menu interaktif CRUD. |

Tampilan output di atas menunjukkan antarmuka konsol dari System Inventaris Gudang Internet saat pertama kali dijalankan.   Pada bagian atas, program menampilkan header yang diproduksi secara dinamis menggunakan konsep Method Overloading dari kelas ManajerGudang, yang menyajikan informasi identitas petugas login (Admin Gudang) beserta tanggal/sesi aktif yang diambil secara real-time (2026-09-22).   Di bawah bagian header, sistem menyajikan Menu Utama berbasis teks yang menyediakan navigasi operasional interaktif lengkap untuk pengelolaan gudang. Menu ini mencakup seluruh fungsionalitas CRUD (Create, Read, Update, Delete) serta fitur analisis inventaris:   Menu 1 (Read): Menampilkan seluruh daftar stok paket yang tersimpan di dalam memori gudang.Menu 2 (Create): Menambahkan data paket internet baru (baik PaketData maupun PaketUnlimited).Menu 3 (Update): Memperbarui informasi harga atau stok dari paket yang sudah ada.Menu 4 (Delete): Menghapus data paket tertentu dari inventaris berdasarkan ID.Menu 5 (Info/Analytics): Mencetak ringkasan valuasi dan total stok inventaris gudang secara otomatis.Menu 0 (Exit): Menghentikan dan keluar dari program.

