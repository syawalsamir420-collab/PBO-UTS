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
| ManajerGudang.java | Utility Class | - | - | cetakHeader() *(Overloading)*, cetakSummary() | Menyediakan fungsi pencetakan header dan analisis valuasi stok. 
| Main.java | Driver Class | - | inventarisGudang *(ArrayList)* | main(), `cariPaketById() | Eksekusi utama program yang menjalankan menu interaktif CRUD. |


|<img width="700" height="398" alt="Cuplikan layar 2026-09-22 183722" src="https://github.com/user-attachments/assets/95949834-8528-4efc-a520-195bef914ffc" />

Tampilan output di atas menunjukkan antarmuka konsol dari System Inventaris Gudang Internet saat pertama kali dijalankan. Pada bagian atas, program menampilkan header yang diproduksi secara dinamis menggunakan konsep Method Overloading dari kelas ManajerGudang, yang menyajikan informasi identitas petugas login (Admin Gudang) beserta tanggal/sesi aktif yang diambil secara real-time (2026-09-22).   Di bawah bagian header, sistem menyajikan Menu Utama berbasis teks yang menyediakan navigasi operasional interaktif lengkap untuk pengelolaan gudang. Menu ini mencakup seluruh fungsionalitas CRUD (Create, Read, Update, Delete) serta fitur analisis inventaris:  

- Menu 1 (Read): Menampilkan seluruh daftar stok paket yang tersimpan di dalam memori gudang.Menu 
- Menu 2 (Create): Menambahkan data paket internet baru (baik PaketData maupun PaketUnlimited).Menu
- Menu 3 (Update): Memperbarui informasi harga atau stok dari paket yang sudah ada.Menu
- Menu 4 (Delete): Menghapus data paket tertentu dari inventaris berdasarkan ID.Menu
- Menu 5 (Info/Analytics): Mencetak ringkasan valuasi dan total stok inventaris gudang secara otomatis.Menu
- Menu 0 (Exit): Menghentikan dan keluar dari program.

<img width="563" height="732" alt="Cuplikan layar 2026-09-22 184350" src="https://github.com/user-attachments/assets/30e0399e-80d8-439a-945a-f73cb3362e0c" />

Tampilan output menunjukkan eksekusi operasi Read (Menu 1) untuk menampilkan seluruh daftar stok paket internet yang tersimpan di dalam memori gudang. Pada proses ini, program memanfaatkan penerapan konsep Polymorphism (Method Overriding) melalui pemanggilan method tampilkanDetail() secara dinamis untuk setiap objek di dalam ArrayList.

Item Gudang #1 (PKT01) dan #2 (PKT02) dirender berdasarkan struktur kelas PaketData, di mana sistem mengevaluasi jumlah kuota menggunakan percabangan if-else untuk menetapkan kategori layanan, yakni Paket Reguler / Normal (kuota < 50 GB) atau Paket Jumbo / High Usage (kuota >= 50 GB). Sementara itu, Item Gudang #3 (PKT03) diproses dari kelas turunan PaketUnlimited, yang secara otomatis menampilkan atribut tambahan spesifik seperti Batas FUP, Kecepatan, dan Fitur Khusus. Selain pencetakan spesifikasi paket, sistem secara otomatis mengevaluasi kondisi batas stok fisik untuk menampilkan status indikator [AMAN] apabila stok mencapai 10 Pcs atau lebih, serta peringatan [WARNING] Stok Menipis! Segera Restock. jika stok berada di bawah 10 Pcs.

<img width="563" height="457" alt="Cuplikan layar 2026-09-22 184631" src="https://github.com/user-attachments/assets/a4734a57-05c1-468a-b2db-46306e28225b" />

Tampilan output menampilkan proses eksekusi fungsi Create (Menu 2) untuk menambahkan data paket internet baru ke dalam sistem inventaris gudang. Pengguna memilih opsi tipe layanan nomor 2 (Paket Unlimited), kemudian menginputkan atribut pendukung secara berurutan mulai dari ID Paket (PKT04), nama paket (Unlimited), harga (1000000), stok (1), hingga kuota utama (500 GB). Karena tipe yang dipilih adalah paket unlimited, sistem secara spesifik meminta parameter tambahan berupa batas FUP (50/bulan), lalu menginstansiasi objek baru dari kelas PaketUnlimited dan menyimpannya ke dalam koleksi ArrayList. Setelah seluruh parameter terisi, sistem memberikan konfirmasi keberhasilan transaksi berupa pesan [SUCCESS] Paket berhasil ditambahkan ke gudang! sebelum akhirnya kembali menstabilkan alur program ke tampilan menu utama.

<img width="472" height="457" alt="Cuplikan layar 2026-09-22 184820" src="https://github.com/user-attachments/assets/cbcedd8c-9589-448d-8061-61e8b5f7dc37" />

Tampilan output menunjukkan eksekusi fitur pencarian data atau Read by ID (Menu 3) pada Sistem Gudang Internet. Pengguna memilih angka 3 untuk masuk ke sublini pencarian, kemudian menginputkan nilai kriteria berupa ID barang 1. Sistem lantas melakukan iterasi pada koleksi data menggunakan method pencarian khusus untuk membandingkan parameter masukan dengan identitas objek yang tersimpan. Setelah kecocokan ditemukan, program memanggil method tampilkanDetail() secara polymorphic dari objek kelas turunan KabelJaringan untuk mencetak spesifikasi lengkap item, yang meliputi ID Barang (1), Nama Barang (Kabel UTP Cat 6), Kategori (Kabel), Harga (Rp5.000), Stok (200), Panjang (100.0 meter), hingga Jenis Kabel (UTP Cat 6).

