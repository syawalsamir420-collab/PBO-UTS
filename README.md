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

| | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | |

|---------------|-------------------|------------------------|------------------------------------------|------------------|-----------------------|

| **Nama File** |  **Jenis Class**  |  **Tipe Inheritance**  |  **Deklarasi Variabel Utama / Atribut**  |  **Method Utama  |  **Deskripsi & Peran  | 


