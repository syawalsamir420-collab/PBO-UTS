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


1. <img width="700" height="398" alt="Cuplikan layar 2026-09-22 183722" src="https://github.com/user-attachments/assets/95949834-8528-4efc-a520-195bef914ffc" />

Tampilan output di atas menunjukkan antarmuka konsol dari System Inventaris Gudang Internet saat pertama kali dijalankan. Pada bagian atas, program menampilkan header yang diproduksi secara dinamis menggunakan konsep Method Overloading dari kelas ManajerGudang, yang menyajikan informasi identitas petugas login (Admin Gudang) beserta tanggal/sesi aktif yang diambil secara real-time (2026-09-22).   Di bawah bagian header, sistem menyajikan Menu Utama berbasis teks yang menyediakan navigasi operasional interaktif lengkap untuk pengelolaan gudang. Menu ini mencakup seluruh fungsionalitas CRUD (Create, Read, Update, Delete) serta fitur analisis inventaris:  

- Menu 1 (Read): Menampilkan seluruh daftar stok paket yang tersimpan di dalam memori gudang.Menu 
- Menu 2 (Create): Menambahkan data paket internet baru (baik PaketData maupun PaketUnlimited).Menu
- Menu 3 (Update): Memperbarui informasi harga atau stok dari paket yang sudah ada.Menu
- Menu 4 (Delete): Menghapus data paket tertentu dari inventaris berdasarkan ID.Menu
- Menu 5 (Info/Analytics): Mencetak ringkasan valuasi dan total stok inventaris gudang secara otomatis.Menu
- Menu 0 (Exit): Menghentikan dan keluar dari program.

2. <img width="563" height="732" alt="Cuplikan layar 2026-09-22 184350" src="https://github.com/user-attachments/assets/30e0399e-80d8-439a-945a-f73cb3362e0c" />

Tampilan output menunjukkan eksekusi operasi Read (Menu 1) untuk menampilkan seluruh daftar stok paket internet yang tersimpan di dalam memori gudang. Pada proses ini, program memanfaatkan penerapan konsep Polymorphism (Method Overriding) melalui pemanggilan method tampilkanDetail() secara dinamis untuk setiap objek di dalam ArrayList.

Item Gudang #1 (PKT01) dan #2 (PKT02) dirender berdasarkan struktur kelas PaketData, di mana sistem mengevaluasi jumlah kuota menggunakan percabangan if-else untuk menetapkan kategori layanan, yakni Paket Reguler / Normal (kuota < 50 GB) atau Paket Jumbo / High Usage (kuota >= 50 GB). Sementara itu, Item Gudang #3 (PKT03) diproses dari kelas turunan PaketUnlimited, yang secara otomatis menampilkan atribut tambahan spesifik seperti Batas FUP, Kecepatan, dan Fitur Khusus. Selain pencetakan spesifikasi paket, sistem secara otomatis mengevaluasi kondisi batas stok fisik untuk menampilkan status indikator [AMAN] apabila stok mencapai 10 Pcs atau lebih, serta peringatan [WARNING] Stok Menipis! Segera Restock. jika stok berada di bawah 10 Pcs.

3. <img width="563" height="457" alt="Cuplikan layar 2026-09-22 184631" src="https://github.com/user-attachments/assets/a4734a57-05c1-468a-b2db-46306e28225b" />

Tampilan output menampilkan proses eksekusi fungsi Create (Menu 2) untuk menambahkan data paket internet baru ke dalam sistem inventaris gudang. Pengguna memilih opsi tipe layanan nomor 2 (Paket Unlimited), kemudian menginputkan atribut pendukung secara berurutan mulai dari ID Paket (PKT04), nama paket (Unlimited), harga (1000000), stok (1), hingga kuota utama (500 GB). Karena tipe yang dipilih adalah paket unlimited, sistem secara spesifik meminta parameter tambahan berupa batas FUP (50/bulan), lalu menginstansiasi objek baru dari kelas PaketUnlimited dan menyimpannya ke dalam koleksi ArrayList. Setelah seluruh parameter terisi, sistem memberikan konfirmasi keberhasilan transaksi berupa pesan [SUCCESS] Paket berhasil ditambahkan ke gudang! sebelum akhirnya kembali menstabilkan alur program ke tampilan menu utama.

4. <img width="666" height="450" alt="Cuplikan layar 2026-09-22 185144" src="https://github.com/user-attachments/assets/029c394c-c489-4107-875f-5d0205d4d1ff" />

Tampilan output menunjukkan eksekusi fungsi Update (Menu 3) untuk memperbarui informasi data paket internet yang sudah ada di inventaris gudang. Pengguna memasukkan angka 3 pada pilihan menu, lalu menginputkan kriteria ID Paket PKT03. Sistem melakukan pencarian data di dalam ArrayList dan berhasil menemukan objek target dengan nama paket Ultra Unlimited. Selanjutnya, pengguna memperbarui atribut harga menjadi 3.000.000 serta stok fisik menjadi 4 Pcs melalui pemanggilan method setter (setHarga() dan setStok()) yang menerapkan konsep Encapsulation. Setelah variabel instance berhasil diperbarui, sistem mencetak konfirmasi [SUCCESS] Data paket berhasil diperbarui! sebelum mengembalikan alur eksekusi ke menu utama.

5. <img width="527" height="798" alt="Cuplikan layar 2026-09-22 185301" src="https://github.com/user-attachments/assets/f4ff39e4-07ef-4e26-b824-86bc4f7ea610" />

Tampilan output menampilkan eksekusi fitur Delete (Menu 4) yang dilanjutkan dengan pencetakan ulang daftar inventaris menggunakan Read (Menu 1) untuk memverifikasi perubahan data. Pada tahap awal, pengguna memilih menu 4 lalu memasukkan ID Paket PKT02 untuk dihapus dari gudang. Sistem mencari objek sasaran di dalam ArrayList, menghapusnya menggunakan method .remove(), dan menampilkan konfirmasi [SUCCESS] Paket Paket Super 60GB berhasil dihapus!. Setelahnya, pengguna kembali memilih menu 1 untuk menampilkan seluruh stok tersisa. Hasilnya mengonfirmasi bahwa data PKT02 sudah hilang dari koleksi, sehingga inventaris kini hanya menyisakan dua item yaitu PKT01 dan PKT03 yang urutan indeksnya disesuaikan kembali secara otomatis oleh sistem.

6. <img width="792" height="573" alt="Cuplikan layar 2026-09-22 185349" src="https://github.com/user-attachments/assets/8bfd1b60-9e53-43b7-af90-8058e7db2e09" />

Tampilan output menunjukkan eksekusi fitur Analytics / Ringkasan Valuasi Gudang (Menu 5) untuk menghitung total aset secara otomatis. Saat pengguna memilih menu 5, sistem mengeksekusi method statis cetakSummary() pada kelas ManajerGudang dengan melewatkan parameter daftar ArrayList. Melalui perulangan internal, program mengkalkulasi akumulasi data inventaris terkini, yaitu Total Jenis Produk sebanyak 2 Item (PKT01 dan PKT03), Total Unit Stok gabungan sebanyak 19 Pcs (15 Pcs PKT01 + 4 Pcs PKT03), serta Total Valuasi senilai Rp 12.675.000,00 yang didapat dari perkalian harga dan jumlah stok masing-masing barang. Fitur ini mempermudah pemantauan estimasi nilai finansial total barang yang tersimpan di gudang secara akurat dan real-time.

7. <img width="776" height="387" alt="Cuplikan layar 2026-09-22 185429" src="https://github.com/user-attachments/assets/29ccd75d-8105-4288-9c43-a84923a4f282" />

Tampilan output menunjukkan eksekusi opsi Keluar Aplikasi (Menu 0) untuk menghentikan seluruh sesi operasional program. Saat pengguna memasukkan angka 0, variabel kontrol boolean (berjalan) diubah nilainya menjadi false, sehingga perulangan while yang menopang menu utama berhenti secara normal. Sistem kemudian mencetak pesan penutup Terima kasih telah menggunakan System Gudang Internet!, menutup objek Scanner, dan mengembalikan kontrol ke IDE NetBeans dengan status BUILD SUCCESS yang menandakan program telah selesai dieksekusi tanpa mengalami runtime error atau crash.

Ucapan Terima Kasih

Terima kasih kepada Dosen Pengampu mata kuliah **Pemrograman Berbasis Objek (PBO)** atas bimbingan dan materi yang telah diberikan selama proses perkuliahan. Terima kasih juga kepada rekan-rekan mahasiswa yang telah memberikan masukan serta dukungan dalam penyelesaian proyek *System Gudang Internet* ini.
