# Sistem-Manajemen-Data-Jadwal-Imunisasi-Anak-

PROYEK PBO — SISTEM INFORMASI IMUNISASI IBU DAN ANAK
Institut Teknologi Del | S1 Sistem Informasi | Semester 4
________________________________________
A. DESKRIPSI PROYEK
Nama Proyek
ImuniKu — Sistem Informasi Imunisasi Ibu dan Anak Berbasis Java Console
Tujuan Proyek
Proyek ini bertujuan membangun sistem informasi berbasis Java console yang mampu mengelola data imunisasi ibu dan anak secara digital, menggantikan pencatatan manual di Buku KIA dan kartu imunisasi Posyandu. Sistem ini dirancang sebagai backend engine yang menjadi fondasi logika bisnis dari aplikasi ImuniKu yang telah dirancang pada proyek UI/UX sebelumnya.
Permasalahan yang Diselesaikan
Berdasarkan riset lapangan yang telah dilakukan pada proyek UI/UX, ditemukan fakta bahwa 85% orang tua hanya mengandalkan Buku KIA fisik untuk mencatat riwayat imunisasi anak. Pencatatan manual ini rawan hilang, rusak, sulit dianalisis, dan tidak memberikan pengingat aktif kepada orang tua. Di sisi tenaga kesehatan Posyandu, kader belum memiliki alat bantu digital sehingga data imunisasi tidak dapat diakses secara agregat untuk keperluan pelaporan. Sistem ini hadir untuk menjawab seluruh permasalahan tersebut.
Manfaat Sistem
Dari sisi orang tua, sistem ini menyimpan riwayat imunisasi anak secara digital sehingga tidak akan hilang meski Buku KIA rusak atau tertinggal. Jadwal imunisasi berikutnya dihitung otomatis berdasarkan tanggal lahir anak mengacu pada jadwal resmi Kemenkes RI. Dari sisi tenaga kesehatan, sistem ini memungkinkan pencatatan yang lebih cepat dan laporan sederhana yang dapat diakses kapan saja tanpa harus membuka tumpukan berkas manual.
Alasan Cocok untuk Mahasiswa SI Semester 4
Proyek ini ideal karena menerapkan seluruh konsep wajib PBO secara natural tanpa dipaksakan. JDBC muncul di setiap operasi database, JCF digunakan untuk mengelola koleksi data, Inheritance diterapkan pada hierarki kelas Person, dan ORM Data Mapper mengkonversi hasil query ke objek Java. Kompleksitasnya pas untuk semester 4 — tidak terlalu trivial, tidak terlalu kompleks.
Relevansi dengan Dunia Nyata
Proyek ini relevan secara langsung dengan kondisi lapangan di Sumatera Utara, khususnya Kabupaten Toba, yang menjadi wilayah riset proyek UI/UX. Data dari Survei Kesehatan Indonesia 2023 menunjukkan hanya 35,8% anak usia 12–23 bulan mendapat Imunisasi Dasar Lengkap. Sistem ini berkontribusi langsung pada upaya peningkatan angka tersebut melalui digitalisasi pencatatan imunisasi.
________________________________________
B. README PROJECT
markdown
# ImuniKu — Sistem Informasi Imunisasi Ibu dan Anak

> Sistem pencatatan dan pengelolaan data imunisasi
> berbasis Java Console dengan MySQL Database

---

## Deskripsi Aplikasi

ImuniKu adalah sistem informasi berbasis Java console
yang dirancang untuk membantu tenaga kesehatan di
Posyandu, Puskesmas, dan Klinik Desa dalam mengelola
data imunisasi ibu dan anak secara digital.

Sistem ini menggantikan pencatatan manual di Buku KIA
dengan solusi digital yang terstruktur, dapat diandalkan,
dan memberikan informasi jadwal imunisasi berikutnya
secara otomatis.

---

## Fitur Utama

- Manajemen data ibu (tambah, lihat, cari, hapus)
- Manajemen data anak (tambah, lihat, cari per ibu)
- Master data vaksin sesuai jadwal Kemenkes RI
- Pencatatan riwayat imunisasi anak
- Generasi jadwal imunisasi otomatis dari tanggal lahir
- Tampil status kelengkapan imunisasi per anak
- Laporan sederhana imunisasi per wilayah/faskes
- Menu konsol interaktif yang mudah digunakan

---

## Teknologi yang Digunakan

| Teknologi | Versi | Kegunaan |
|-----------|-------|---------|
| Java | 17 / 21 | Bahasa pemrograman utama |
| MySQL | 8.x | Database penyimpanan data |
| JDBC | Built-in | Koneksi Java ke MySQL |
| MySQL Connector/J | 8.x | Driver JDBC MySQL |
| NetBeans / IntelliJ | Terbaru | IDE pengembangan |

---

## Konsep PBO yang Diterapkan

### 1. Inheritance
- `Person` (abstract) → `Ibu`, `PetugasKesehatan`
- `BaseMapper` (abstract) → semua Mapper konkret
- `BaseDAO` (abstract) → semua DAO konkret

### 2. JDBC
- Koneksi singleton ke MySQL via `DatabaseConnection`
- PreparedStatement untuk semua operasi CRUD
- ResultSet untuk membaca hasil query

### 3. JCF (Java Collection Framework)
- `ArrayList<Anak>` untuk daftar anak per ibu
- `ArrayList<JadwalImunisasi>` untuk jadwal per anak
- `HashMap<String, List<JadwalImunisasi>>` untuk
  pengelompokan jadwal berdasarkan status

### 4. ORM Data Mapper
- Setiap entity memiliki Mapper tersendiri
- Method `mapRow(ResultSet)` mengkonversi baris DB
  ke objek Java
- Memisahkan logika domain dari logika database

---

## Struktur Folder Project
 
---

## Cara Menjalankan Program

### Prasyarat
- Java JDK 17 atau 21 sudah terinstall
- MySQL Server 8.x sudah berjalan
- MySQL Connector/J sudah ditambahkan ke classpath

### Langkah 1 — Setup Database
```sql
mysql -u root -p < database/imuniku.sql
```

### Langkah 2 — Konfigurasi Koneksi
Buka `src/driver/DatabaseConnection.java` dan
sesuaikan:
```java
private static final String URL =
    "jdbc:mysql://localhost:3306/imuniku_db";
private static final String USER = "root";
private static final String PASS = "password_kamu";
```

### Langkah 3 — Compile dan Jalankan
```bash
# Compile
javac -cp lib/mysql-connector-j.jar \
      -d out src/**/*.java

# Jalankan
java -cp out:lib/mysql-connector-j.jar \
     main.Main
```

---

## Setup Database MySQL

Jalankan file `database/imuniku.sql` yang sudah
disertakan dalam proyek. File ini berisi:
- CREATE DATABASE
- CREATE TABLE (7 tabel)
- INSERT data master vaksin (15 jenis vaksin)
- INSERT data dummy untuk testing

---

## Flow Penggunaan Aplikasi
 
---

## Author

| Nama | NIM | Prodi |
|------|-----|-------|
| [Nama Kamu] | [NIM Kamu] | S1 Sistem Informasi |

Institut Teknologi Del — 2026

---

## Lisensi

Proyek ini dibuat untuk keperluan akademik mata kuliah
Pemrograman Berorientasi Objek (PBO), Program Studi
S1 Sistem Informasi, Institut Teknologi Del.
Diperbolehkan untuk digunakan sebagai referensi
pembelajaran dengan menyertakan atribusi.
________________________________________
C. DESKRIPSI SOAL / STUDI KASUS
________________________________________
INSTITUT TEKNOLOGI DEL Fakultas Informatika dan Teknik Elektro Program Studi S1 Sistem Informasi
TUGAS BESAR MATA KULIAH Pemrograman Berorientasi Objek
________________________________________
Studi Kasus: Sistem Informasi Imunisasi Ibu dan Anak
Latar Belakang
Imunisasi merupakan salah satu intervensi kesehatan paling efektif dalam mencegah penyakit menular dan menurunkan angka kematian ibu dan anak. Berdasarkan data Survei Kesehatan Indonesia 2023 yang diterbitkan oleh Kementerian Kesehatan Republik Indonesia, hanya 35,8% anak Indonesia pada usia 12–23 bulan yang mendapatkan Imunisasi Dasar Lengkap. Data UNICEF juga mencatat bahwa sekitar 1,7 juta anak per tahun di Indonesia tidak mendapatkan imunisasi lengkap. Provinsi Sumatera Utara, termasuk Kabupaten Toba, belum termasuk dalam wilayah dengan pemberian imunisasi yang sesuai target nasional.
Salah satu penyebab rendahnya cakupan imunisasi adalah sistem pencatatan yang masih sepenuhnya manual. Kader Posyandu mencatat data imunisasi langsung di Buku KIA (Kesehatan Ibu dan Anak) menggunakan tulisan tangan. Data mudah hilang, rusak, atau tidak terbaca. Tidak ada sistem pengingat aktif yang menginformasikan jadwal imunisasi berikutnya kepada orang tua maupun tenaga kesehatan.
Permasalahan
Berdasarkan latar belakang di atas, terdapat beberapa permasalahan utama yang perlu diselesaikan melalui pendekatan sistem informasi, yaitu:
Pertama, tidak adanya sistem digital untuk mencatat dan menyimpan data imunisasi anak secara terstruktur dan terpusat. Kedua, tenaga kesehatan tidak dapat dengan mudah mengakses riwayat imunisasi anak tanpa Buku KIA fisik yang harus selalu dibawa. Ketiga, jadwal imunisasi berikutnya tidak dihitung secara otomatis berdasarkan tanggal lahir anak sesuai panduan Kemenkes RI. Keempat, tidak ada laporan agregat yang bisa dihasilkan secara cepat untuk keperluan pelaporan ke Dinas Kesehatan.
Tujuan Sistem
Mahasiswa diminta membangun sebuah Sistem Informasi Imunisasi Ibu dan Anak berbasis Java Console yang mampu menyelesaikan permasalahan di atas. Sistem harus dapat menyimpan data ibu dan anak, mengelola master data vaksin, mencatat riwayat imunisasi, menghitung jadwal imunisasi berikutnya secara otomatis, dan menghasilkan laporan status imunisasi per anak.
Ketentuan Teknis
Sistem wajib dibangun menggunakan bahasa pemrograman Java versi 17 atau 21 dengan antarmuka berbasis konsol. Database yang digunakan adalah MySQL versi 8.x. Koneksi ke database wajib menggunakan JDBC dengan MySQL Connector/J. Seluruh operasi basis data wajib menggunakan PreparedStatement untuk mencegah SQL Injection.
Teknologi Wajib
Setiap mahasiswa wajib menerapkan empat konsep berikut secara eksplisit dan dapat didemonstrasikan saat presentasi: pertama JDBC untuk koneksi dan operasi database, kedua Java Collection Framework dengan minimal menggunakan ArrayList dan HashMap, ketiga Inheritance dengan minimal satu hierarki class parent-child yang relevan dengan domain masalah, dan keempat ORM Data Mapper sederhana tanpa menggunakan framework eksternal seperti Hibernate atau MyBatis.
Output yang Diharapkan
Mahasiswa mengumpulkan source code lengkap, file SQL untuk pembuatan database, dokumentasi teknis, dan laporan proyek yang menjelaskan implementasi setiap konsep PBO. Presentasi dilakukan secara live dengan mendemonstrasikan seluruh fitur sistem dan kemampuan menjelaskan kode yang ditulis.
________________________________________

E. DESAIN OOP
Daftar Class dan Atribut
Person (Abstract Class — Parent)
Atribut:
- int id
- String nama
- String noHp
- LocalDate tanggalLahir
- LocalDate tanggalDaftar

Method:
+ Person(String nama, String noHp, LocalDate tglLahir)
+ getId(): int
+ getNama(): String
+ getNoHp(): String
+ getTanggalLahir(): LocalDate
+ setNama(String): void
+ getInfo(): String  [abstract]
+ toString(): String
Ibu (extends Person)
Atribut tambahan:
- String nik
- String alamat
- List<Anak> daftarAnak [JCF]

Method:
+ Ibu(String nama, String nik, String alamat,
      String noHp, LocalDate tglLahir)
+ getNik(): String
+ getAlamat(): String
+ getDaftarAnak(): List<Anak>
+ tambahAnak(Anak): void
+ getInfo(): String  [override]
PetugasKesehatan (extends Person)
Atribut tambahan:
- String nip
- String jabatan
- String namaFaskes

Method:
+ PetugasKesehatan(String nama, String nip,
                   String jabatan, String faskes,
                   String noHp, LocalDate tglLahir)
+ getNip(): String
+ getJabatan(): String
+ getNamaFaskes(): String
+ getInfo(): String  [override]
Anak
Atribut:
- int id
- String nama
- LocalDate tanggalLahir
- String jenisKelamin
- int ibuId
- List<JadwalImunisasi> daftarJadwal [JCF]
- List<RiwayatImunisasi> daftarRiwayat [JCF]

Method:
+ getUsiaBulan(): int  [kalkulasi otomatis]
+ getDaftarJadwal(): List<JadwalImunisasi>
+ getDaftarRiwayat(): List<RiwayatImunisasi>
+ getStatusKelengkapan(): String
Vaksin
Atribut:
- int id
- String kodeVaksin
- String namaVaksin
- String namaUmum
- String penyakitDicegah
- int usiaBulanPemberian
- int dosisDiperlukan
- String caraPemberian

Method:
+ getter/setter semua atribut
+ toString(): String
JadwalImunisasi
Atribut:
- int id
- int anakId
- int vaksinId
- String namaVaksin
- LocalDate tanggalTarget
- String status

Method:
+ isLewatJatuhTempo(): boolean
+ getter/setter semua atribut
RiwayatImunisasi
Atribut:
- int id
- int anakId
- int vaksinId
- String namaVaksin
- LocalDate tanggalPelaksanaan
- String namaFaskes
- String namaPetugas
- String catatan

Method:
+ getter/setter semua atribut
+ toString(): String
Class Diagram Teks
 ________________________________________
F. STRUKTUR PROJECT JAVA
ImuniKu/
├── src/
│   ├── model/          → Kelas domain/entity
│   ├── driver/         → Koneksi database
│   ├── dao/            → Data Access Object (CRUD)
│   ├── mapper/         → ORM Data Mapper
│   ├── service/        → Logika bisnis
│   ├── util/           → Helper & utilitas
│   └── main/           → Entry point program
├── database/
│   └── imuniku.sql
└── lib/
    └── mysql-connector-j.jar
Penjelasan setiap package:
model menyimpan semua kelas domain yang merepresentasikan entitas dalam sistem seperti Person, Ibu, Anak, Vaksin, dan sebagainya. Kelas di package ini murni berisi atribut dan method getter/setter tanpa logika database.
driver menyimpan satu kelas DatabaseConnection yang mengelola koneksi JDBC ke MySQL menggunakan pola Singleton.
dao menyimpan kelas Data Access Object yang bertanggung jawab atas operasi CRUD ke database. Setiap entity memiliki DAO tersendiri yang menggunakan Mapper untuk konversi data.
mapper menyimpan kelas ORM Data Mapper yang bertugas mengkonversi ResultSet dari database menjadi objek Java dan sebaliknya.
service menyimpan kelas layanan yang berisi logika bisnis sistem seperti penghitungan jadwal otomatis dan kalkulasi status kelengkapan imunisasi.
util menyimpan kelas utilitas seperti InputHelper untuk membaca input konsol dan DateHelper untuk operasi tanggal.
main menyimpan kelas Main sebagai entry point dan kelas menu konsol interaktif.
________________________________________
G. DATABASE DESIGN
ERD Sederhana
orang_tua ||──o{ anak : memiliki
anak      ||──o{ jadwal_imunisasi : punya
anak      ||──o{ riwayat_imunisasi : mencatat
vaksin    ||──o{ jadwal_imunisasi : digunakan_di
vaksin    ||──o{ riwayat_imunisasi : digunakan_di
petugas_kesehatan ||──o{ riwayat_imunisasi : mencatat
SQL Lengkap
sql
-- ================================================
-- ImuniKu Database Schema
-- Institut Teknologi Del | PBO 2026
-- ================================================

CREATE DATABASE IF NOT EXISTS imuniku_db
    CHARACTER SET utf8mb4
    COLLATE utf8mb4_unicode_ci;

USE imuniku_db;

-- Tabel orang_tua
CREATE TABLE orang_tua (
    id              INT PRIMARY KEY AUTO_INCREMENT,
    nama            VARCHAR(100) NOT NULL,
    nik             VARCHAR(16) UNIQUE NOT NULL,
    no_hp           VARCHAR(20) NOT NULL,
    alamat          TEXT,
    tanggal_lahir   DATE,
    tanggal_daftar  DATE NOT NULL DEFAULT (CURDATE()),
    INDEX idx_nik (nik),
    INDEX idx_nama (nama)
);

-- Tabel anak
CREATE TABLE anak (
    id              INT PRIMARY KEY AUTO_INCREMENT,
    nama            VARCHAR(100) NOT NULL,
    tanggal_lahir   DATE NOT NULL,
    jenis_kelamin   ENUM('Laki-laki','Perempuan')
                    NOT NULL,
    orang_tua_id    INT NOT NULL,
    tanggal_daftar  DATE NOT NULL DEFAULT (CURDATE()),
    FOREIGN KEY (orang_tua_id)
        REFERENCES orang_tua(id)
        ON DELETE CASCADE,
    INDEX idx_orang_tua (orang_tua_id)
);

-- Tabel petugas_kesehatan
CREATE TABLE petugas_kesehatan (
    id              INT PRIMARY KEY AUTO_INCREMENT,
    nama            VARCHAR(100) NOT NULL,
    nip             VARCHAR(20) UNIQUE,
    jabatan         VARCHAR(50),
    nama_faskes     VARCHAR(150),
    no_hp           VARCHAR(20),
    tanggal_lahir   DATE,
    tanggal_daftar  DATE NOT NULL DEFAULT (CURDATE())
);

-- Tabel vaksin
CREATE TABLE vaksin (
    id                      INT PRIMARY KEY
                            AUTO_INCREMENT,
    kode_vaksin             VARCHAR(20) UNIQUE NOT NULL,
    nama_vaksin             VARCHAR(100) NOT NULL,
    nama_umum               VARCHAR(100),
    penyakit_dicegah        TEXT,
    usia_bulan_pemberian    INT NOT NULL,
    dosis_diperlukan        INT NOT NULL DEFAULT 1,
    cara_pemberian          VARCHAR(50),
    INDEX idx_usia (usia_bulan_pemberian)
);

-- Tabel jadwal_imunisasi
CREATE TABLE jadwal_imunisasi (
    id              INT PRIMARY KEY AUTO_INCREMENT,
    anak_id         INT NOT NULL,
    vaksin_id       INT NOT NULL,
    tanggal_target  DATE NOT NULL,
    status          ENUM('MENDATANG','SELESAI',
                         'TERTUNDA','TERLEWAT')
                    NOT NULL DEFAULT 'MENDATANG',
    FOREIGN KEY (anak_id)
        REFERENCES anak(id) ON DELETE CASCADE,
    FOREIGN KEY (vaksin_id)
        REFERENCES vaksin(id),
    INDEX idx_anak_status (anak_id, status)
);

-- Tabel riwayat_imunisasi
CREATE TABLE riwayat_imunisasi (
    id                  INT PRIMARY KEY AUTO_INCREMENT,
    anak_id             INT NOT NULL,
    vaksin_id           INT NOT NULL,
    petugas_id          INT,
    tanggal_pelaksanaan DATE NOT NULL,
    nama_faskes         VARCHAR(150),
    nama_petugas        VARCHAR(100),
    catatan             TEXT,
    FOREIGN KEY (anak_id)
        REFERENCES anak(id) ON DELETE CASCADE,
    FOREIGN KEY (vaksin_id)
        REFERENCES vaksin(id),
    FOREIGN KEY (petugas_id)
        REFERENCES petugas_kesehatan(id)
        ON DELETE SET NULL
);

-- ================================================
-- Master Data Vaksin (Jadwal Kemenkes RI 2024)
-- ================================================
INSERT INTO vaksin
(kode_vaksin, nama_vaksin, nama_umum,
 penyakit_dicegah, usia_bulan_pemberian,
 dosis_diperlukan, cara_pemberian)
VALUES
('HB0','Hepatitis B (HB-0)','HB-0',
 'Hepatitis B',0,1,'Suntik'),
('BCG','BCG','BCG',
 'Tuberkulosis',1,1,'Suntik'),
('OPV1','OPV 1','Polio Tetes 1',
 'Polio',1,1,'Tetes'),
('DPT1','DPT-HB-Hib 1','DPT 1',
 'Difteri, Pertusis, Tetanus, HepB, Hib',
 2,1,'Suntik'),
('OPV2','OPV 2','Polio Tetes 2',
 'Polio',2,1,'Tetes'),
('PCV1','PCV 1','PCV 1',
 'Pneumonia',2,1,'Suntik'),
('DPT2','DPT-HB-Hib 2','DPT 2',
 'Difteri, Pertusis, Tetanus, HepB, Hib',
 3,1,'Suntik'),
('OPV3','OPV 3','Polio Tetes 3',
 'Polio',3,1,'Tetes'),
('DPT3','DPT-HB-Hib 3','DPT 3',
 'Difteri, Pertusis, Tetanus, HepB, Hib',
 4,1,'Suntik'),
('OPV4','OPV 4','Polio Tetes 4',
 'Polio',4,1,'Tetes'),
('IPV1','IPV 1','Polio Suntik 1',
 'Polio',4,1,'Suntik'),
('MR1','Campak-Rubella 1','MR 1',
 'Campak dan Rubella',9,1,'Suntik'),
('PCV3','PCV 3','PCV 3',
 'Pneumonia',12,1,'Suntik'),
('DPT4','DPT-HB-Hib 4','DPT Lanjutan',
 'Difteri, Pertusis, Tetanus, HepB, Hib',
 18,1,'Suntik'),
('MR2','Campak-Rubella 2','MR Lanjutan',
 'Campak dan Rubella',18,1,'Suntik');

-- ================================================
-- Data Dummy untuk Testing
-- ================================================
INSERT INTO orang_tua
(nama, nik, no_hp, alamat, tanggal_lahir)
VALUES
('Rosanti Sitorus','1202034501900001',
 '081234567890','Jl. Mawar No. 5, Balige',
 '1990-01-05'),
('Margaretha Sirait','1202035502950002',
 '082345678901','Jl. Anggrek No. 12, Toba',
 '1995-05-15'),
('Veronika Turnip','1202036003000003',
 '083456789012','Jl. Melati No. 3, Balige',
 '2000-03-20');

INSERT INTO anak
(nama, tanggal_lahir, jenis_kelamin, orang_tua_id)
VALUES
('Naira Sitorus','2025-10-10','Perempuan',1),
('Bintang Sirait','2025-08-15','Laki-laki',2),
('Bunga Turnip','2025-12-01','Perempuan',3);

INSERT INTO petugas_kesehatan
(nama, nip, jabatan, nama_faskes, no_hp)
VALUES
('Bidan Sri Nora','198501012010012001',
 'Bidan Desa','Posyandu Mawar Balige',
 '085678901234');
________________________________________
H. IMPLEMENTASI JDBC
JDBC adalah API standar Java untuk berinteraksi dengan database relasional. Dalam proyek ini, JDBC digunakan di seluruh kelas DAO untuk melakukan operasi CRUD ke MySQL.
DatabaseConnection.java
java
package driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Kelas DatabaseConnection menggunakan pola Singleton
 * untuk memastikan hanya ada satu koneksi aktif
 * ke database MySQL sepanjang siklus hidup program.
 *
 * Konsep PBO: Encapsulation (constructor private)
 * Pola desain: Singleton
 */
public class DatabaseConnection {

    // Konfigurasi koneksi — sesuaikan dengan setup lokal
    private static final String URL =
        "jdbc:mysql://localhost:3306/imuniku_db"
        + "?useSSL=false"
        + "&serverTimezone=Asia/Jakarta"
        + "&allowPublicKeyRetrieval=true";
    private static final String USER = "root";
    private static final String PASS = "password123";

    // Satu-satunya instance koneksi
    private static Connection instance = null;

    // Constructor private — mencegah instantiasi luar
    private DatabaseConnection() {}

    /**
     * Mengembalikan koneksi aktif ke database.
     * Jika belum ada atau sudah tertutup,
     * akan membuat koneksi baru.
     *
     * @return Connection objek koneksi JDBC
     */
    public static Connection getConnection() {
        try {
            if (instance == null
                    || instance.isClosed()) {

                // Load driver MySQL
                Class.forName(
                    "com.mysql.cj.jdbc.Driver"
                );

                // Buat koneksi baru
                instance = DriverManager.getConnection(
                    URL, USER, PASS
                );

                System.out.println(
                    "[DB] Koneksi ke database "
                    + "berhasil dibuat."
                );
            }
        } catch (ClassNotFoundException e) {
            System.err.println(
                "[ERROR] Driver MySQL tidak ditemukan. "
                + "Pastikan mysql-connector-j.jar "
                + "sudah ditambahkan ke classpath."
            );
            System.err.println(e.getMessage());
        } catch (SQLException e) {
            System.err.println(
                "[ERROR] Gagal terhubung ke database. "
                + "Periksa URL, user, dan password."
            );
            System.err.println(e.getMessage());
        }
        return instance;
    }

    /**
     * Menutup koneksi database secara aman.
     * Dipanggil saat program akan ditutup.
     */
    public static void closeConnection() {
        try {
            if (instance != null
                    && !instance.isClosed()) {
                instance.close();
                System.out.println(
                    "[DB] Koneksi database ditutup."
                );
            }
        } catch (SQLException e) {
            System.err.println(
                "[ERROR] Gagal menutup koneksi: "
                + e.getMessage()
            );
        }
    }
}
________________________________________
I. IMPLEMENTASI ORM DATA MAPPER
BaseMapper.java
java
package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Abstract class BaseMapper mendefinisikan kontrak
 * yang harus diimplementasikan oleh semua Mapper.
 *
 * Konsep PBO: Inheritance, Abstraction
 * Pola desain: Data Mapper (ORM sederhana)
 *
 * @param <T> Tipe entity yang di-mapping
 */
public abstract class BaseMapper<T> {

    /**
     * Mengkonversi satu baris ResultSet
     * menjadi objek Java.
     * Ini adalah inti dari ORM Data Mapper.
     *
     * @param rs ResultSet dari hasil query SQL
     * @return objek T yang sudah terisi data
     */
    public abstract T mapRow(ResultSet rs)
        throws SQLException;

    /**
     * Mengkonversi semua baris ResultSet
     * menjadi List objek Java.
     * Menggunakan JCF ArrayList.
     */
    public abstract List<T> mapRows(ResultSet rs)
        throws SQLException;
}
IbuMapper.java
java
package mapper;

import model.Ibu;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * IbuMapper bertanggung jawab untuk mengkonversi
 * data dari tabel orang_tua ke objek Ibu Java
 * dan sebaliknya.
 *
 * Konsep PBO: Inheritance (extends BaseMapper)
 * Konsep ORM: mapRow() adalah inti Data Mapper
 */
public class IbuMapper extends BaseMapper<Ibu> {

    /**
     * Mengkonversi satu baris ResultSet
     * dari tabel orang_tua menjadi objek Ibu.
     *
     * Ini adalah implementasi ORM Data Mapper:
     * database row → Java object
     */
    @Override
    public Ibu mapRow(ResultSet rs)
        throws SQLException {

        Ibu ibu = new Ibu();

        ibu.setId(rs.getInt("id"));
        ibu.setNama(rs.getString("nama"));
        ibu.setNik(rs.getString("nik"));
        ibu.setNoHp(rs.getString("no_hp"));
        ibu.setAlamat(rs.getString("alamat"));

        // Konversi java.sql.Date → java.time.LocalDate
        java.sql.Date tglLahir =
            rs.getDate("tanggal_lahir");
        if (tglLahir != null) {
            ibu.setTanggalLahir(tglLahir.toLocalDate());
        }

        java.sql.Date tglDaftar =
            rs.getDate("tanggal_daftar");
        if (tglDaftar != null) {
            ibu.setTanggalDaftar(tglDaftar.toLocalDate());
        }

        return ibu;
    }

    /**
     * Mengkonversi semua baris ResultSet
     * menjadi List<Ibu>.
     * JCF: menggunakan ArrayList
     */
    @Override
    public List<Ibu> mapRows(ResultSet rs)
        throws SQLException {

        // JCF: ArrayList untuk menyimpan koleksi Ibu
        List<Ibu> daftarIbu = new ArrayList<>();

        while (rs.next()) {
            daftarIbu.add(mapRow(rs));
        }

        return daftarIbu;
    }
}
________________________________________
J. IMPLEMENTASI JCF
IbuDAO.java (JCF + JDBC)
java
package dao;

import driver.DatabaseConnection;
import mapper.IbuMapper;
import model.Ibu;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * IbuDAO menangani semua operasi database
 * untuk entity Ibu.
 *
 * Konsep PBO: Inheritance (extends BaseDAO)
 * Konsep JDBC: PreparedStatement, ResultSet
 * Konsep JCF: List, Map
 */
public class IbuDAO extends BaseDAO<Ibu> {

    private Connection conn;
    private IbuMapper mapper;

    public IbuDAO() {
        this.conn = DatabaseConnection.getConnection();
        this.mapper = new IbuMapper();
    }

    /**
     * Menyimpan data Ibu baru ke database.
     * JDBC: menggunakan PreparedStatement
     * untuk keamanan dari SQL Injection.
     */
    @Override
    public void save(Ibu ibu) {
        String sql =
            "INSERT INTO orang_tua "
            + "(nama, nik, no_hp, alamat, "
            + " tanggal_lahir, tanggal_daftar) "
            + "VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps =
                 conn.prepareStatement(
                     sql,
                     Statement.RETURN_GENERATED_KEYS
                 )) {

            ps.setString(1, ibu.getNama());
            ps.setString(2, ibu.getNik());
            ps.setString(3, ibu.getNoHp());
            ps.setString(4, ibu.getAlamat());

            if (ibu.getTanggalLahir() != null) {
                ps.setDate(5, Date.valueOf(
                    ibu.getTanggalLahir()
                ));
            } else {
                ps.setNull(5, Types.DATE);
            }

            ps.setDate(6, Date.valueOf(LocalDate.now()));
            ps.executeUpdate();

            // Ambil ID yang di-generate database
            ResultSet generatedKeys =
                ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                ibu.setId(generatedKeys.getInt(1));
                System.out.println(
                    "[OK] Ibu " + ibu.getNama()
                    + " berhasil didaftarkan "
                    + "(ID: " + ibu.getId() + ")"
                );
            }

        } catch (SQLIntegrityConstraintViolationException e) {
            System.err.println(
                "[ERROR] NIK " + ibu.getNik()
                + " sudah terdaftar di sistem."
            );
        } catch (SQLException e) {
            System.err.println(
                "[ERROR] Gagal menyimpan data ibu: "
                + e.getMessage()
            );
        }
    }

    /**
     * Mengambil semua data Ibu dari database.
     * JCF: mengembalikan List<Ibu>
     * ORM: menggunakan IbuMapper.mapRows()
     */
    @Override
    public List<Ibu> findAll() {
        // JCF: ArrayList sebagai container hasil query
        List<Ibu> daftarIbu = new ArrayList<>();
        String sql =
            "SELECT * FROM orang_tua ORDER BY nama";

        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            // ORM Data Mapper: konversi ResultSet→List
            daftarIbu = mapper.mapRows(rs);

        } catch (SQLException e) {
            System.err.println(
                "[ERROR] Gagal mengambil data ibu: "
                + e.getMessage()
            );
        }
        return daftarIbu;
    }

    /**
     * Mencari Ibu berdasarkan NIK.
     * JDBC: PreparedStatement dengan parameter
     */
    public Ibu findByNik(String nik) {
        String sql =
            "SELECT * FROM orang_tua WHERE nik = ?";

        try (PreparedStatement ps =
                 conn.prepareStatement(sql)) {

            ps.setString(1, nik);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return mapper.mapRow(rs); // ORM Mapper
            }

        } catch (SQLException e) {
            System.err.println(
                "[ERROR] Gagal mencari ibu: "
                + e.getMessage()
            );
        }
        return null;
    }

    /**
     * Mencari Ibu berdasarkan nama (LIKE search).
     * JCF: mengembalikan List<Ibu>
     */
    public List<Ibu> findByNama(String nama) {
        List<Ibu> hasil = new ArrayList<>();
        String sql =
            "SELECT * FROM orang_tua "
            + "WHERE nama LIKE ? ORDER BY nama";

        try (PreparedStatement ps =
                 conn.prepareStatement(sql)) {

            ps.setString(1, "%" + nama + "%");
            ResultSet rs = ps.executeQuery();
            hasil = mapper.mapRows(rs);

        } catch (SQLException e) {
            System.err.println(
                "[ERROR] Gagal mencari ibu: "
                + e.getMessage()
            );
        }
        return hasil;
    }

    /**
     * Mengambil data untuk laporan menggunakan HashMap.
     * JCF: HashMap<String, Integer> untuk statistik
     * Contoh: {"total": 25, "baru_bulan_ini": 5}
     */
    public Map<String, Integer> getStatistik() {
        // JCF: HashMap untuk menyimpan data statistik
        Map<String, Integer> statistik = new HashMap<>();

        String sqlTotal =
            "SELECT COUNT(*) as total FROM orang_tua";
        String sqlBaru =
            "SELECT COUNT(*) as baru "
            + "FROM orang_tua "
            + "WHERE MONTH(tanggal_daftar) = MONTH(NOW()) "
            + "AND YEAR(tanggal_daftar) = YEAR(NOW())";

        try (Statement st = conn.createStatement()) {

            ResultSet rs1 = st.executeQuery(sqlTotal);
            if (rs1.next()) {
                statistik.put("total", rs1.getInt("total"));
            }

            ResultSet rs2 = st.executeQuery(sqlBaru);
            if (rs2.next()) {
                statistik.put(
                    "baru_bulan_ini",
                    rs2.getInt("baru")
                );
            }

        } catch (SQLException e) {
            System.err.println(
                "[ERROR] Gagal mengambil statistik: "
                + e.getMessage()
            );
        }
        return statistik;
    }

    @Override
    public Ibu findById(int id) {
        String sql =
            "SELECT * FROM orang_tua WHERE id = ?";
        try (PreparedStatement ps =
                 conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return mapper.mapRow(rs);
            }
        } catch (SQLException e) {
            System.err.println(
                "[ERROR] findById ibu: "
                + e.getMessage()
            );
        }
        return null;
    }

    @Override
    public void update(Ibu ibu) {
        String sql =
            "UPDATE orang_tua SET nama=?, no_hp=?, "
            + "alamat=? WHERE id=?";
        try (PreparedStatement ps =
                 conn.prepareStatement(sql)) {
            ps.setString(1, ibu.getNama());
            ps.setString(2, ibu.getNoHp());
            ps.setString(3, ibu.getAlamat());
            ps.setInt(4, ibu.getId());
            ps.executeUpdate();
            System.out.println(
                "[OK] Data ibu berhasil diperbarui."
            );
        } catch (SQLException e) {
            System.err.println(
                "[ERROR] Gagal update ibu: "
                + e.getMessage()
            );
        }
    }

    @Override
    public void delete(int id) {
        String sql =
            "DELETE FROM orang_tua WHERE id=?";
        try (PreparedStatement ps =
                 conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            int affected = ps.executeUpdate();
            if (affected > 0) {
                System.out.println(
                    "[OK] Data ibu berhasil dihapus."
                );
            }
        } catch (SQLException e) {
            System.err.println(
                "[ERROR] Gagal hapus ibu: "
                + e.getMessage()
            );
        }
    }
}
________________________________________
K. IMPLEMENTASI INHERITANCE
Person.java
java
package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Abstract class Person adalah parent class
 * untuk semua entitas manusia dalam sistem.
 *
 * Konsep PBO:
 * - Abstraction: class abstract dengan method abstract
 * - Encapsulation: atribut protected dengan getter/setter
 * - Inheritance: diwariskan oleh Ibu & PetugasKesehatan
 */
public abstract class Person {

    // Protected: bisa diakses child class
    protected int id;
    protected String nama;
    protected String noHp;
    protected LocalDate tanggalLahir;
    protected LocalDate tanggalDaftar;

    protected static final DateTimeFormatter DATE_FMT =
        DateTimeFormatter.ofPattern("dd-MM-yyyy");

    // Default constructor
    public Person() {
        this.tanggalDaftar = LocalDate.now();
    }

    // Parameterized constructor
    public Person(
            String nama,
            String noHp,
            LocalDate tanggalLahir) {
        this.nama = nama;
        this.noHp = noHp;
        this.tanggalLahir = tanggalLahir;
        this.tanggalDaftar = LocalDate.now();
    }

    // ── Getter & Setter ──────────────────────────

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNama() { return nama; }
    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNoHp() { return noHp; }
    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public LocalDate getTanggalLahir() {
        return tanggalLahir;
    }
    public void setTanggalLahir(LocalDate tgl) {
        this.tanggalLahir = tgl;
    }

    public LocalDate getTanggalDaftar() {
        return tanggalDaftar;
    }
    public void setTanggalDaftar(LocalDate tgl) {
        this.tanggalDaftar = tgl;
    }

    // ── Abstract Method ───────────────────────────

    /**
     * Setiap subclass WAJIB mengimplementasikan
     * cara menampilkan info dirinya sendiri.
     * Ini adalah contoh Abstraction dan Polymorphism.
     */
    public abstract String getInfo();

    // ── Concrete Method (diwariskan) ──────────────

    @Override
    public String toString() {
        return String.format(
            "ID: %d | Nama: %s | HP: %s",
            id, nama, noHp
        );
    }
}
Ibu.java
java
package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Ibu adalah child class dari Person.
 * Menambahkan atribut spesifik ibu dan
 * menggunakan JCF untuk menyimpan daftar anak.
 *
 * Konsep PBO:
 * - Inheritance: extends Person
 * - Polymorphism: override getInfo()
 * - JCF: List<Anak> daftarAnak
 */
public class Ibu extends Person {

    private String nik;
    private String alamat;

    // JCF: ArrayList untuk menyimpan koleksi anak
    private List<Anak> daftarAnak;

    public Ibu() {
        super();  // Panggil constructor Person
        this.daftarAnak = new ArrayList<>();
    }

    public Ibu(
            String nama,
            String nik,
            String alamat,
            String noHp,
            LocalDate tanggalLahir) {

        // super() memanggil constructor Person
        super(nama, noHp, tanggalLahir);
        this.nik = nik;
        this.alamat = alamat;
        this.daftarAnak = new ArrayList<>();
    }

    // ── Getter & Setter ──────────────────────────

    public String getNik() { return nik; }
    public void setNik(String nik) { this.nik = nik; }

    public String getAlamat() { return alamat; }
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public List<Anak> getDaftarAnak() {
        return daftarAnak;
    }
    public void setDaftarAnak(List<Anak> list) {
        this.daftarAnak = list;
    }

    public void tambahAnak(Anak anak) {
        this.daftarAnak.add(anak);
    }

    // ── Override Method ───────────────────────────

    /**
     * Polymorphism: implementasi spesifik Ibu
     * dari method abstract getInfo() di Person.
     */
    @Override
    public String getInfo() {
        return String.format(
            "=== Data Ibu ===\n"
            + "ID      : %d\n"
            + "Nama    : %s\n"
            + "NIK     : %s\n"
            + "No HP   : %s\n"
            + "Alamat  : %s\n"
            + "Jml Anak: %d orang",
            id, nama, nik, noHp, alamat,
            daftarAnak.size()
        );
    }

    @Override
    public String toString() {
        return String.format(
            "ID: %-4d | Nama: %-25s | NIK: %s",
            id, nama, nik
        );
    }
}
PetugasKesehatan.java
java
package model;

import java.time.LocalDate;

/**
 * PetugasKesehatan adalah child class dari Person.
 * Merepresentasikan bidan/kader Posyandu
 * yang mencatat imunisasi.
 *
 * Konsep PBO:
 * - Inheritance: extends Person
 * - Polymorphism: override getInfo()
 */
public class PetugasKesehatan extends Person {

    private String nip;
    private String jabatan;
    private String namaFaskes;

    public PetugasKesehatan() {
        super();
    }

    public PetugasKesehatan(
            String nama,
            String nip,
            String jabatan,
            String namaFaskes,
            String noHp,
            LocalDate tanggalLahir) {

        super(nama, noHp, tanggalLahir);
        this.nip = nip;
        this.jabatan = jabatan;
        this.namaFaskes = namaFaskes;
    }

    public String getNip() { return nip; }
    public void setNip(String nip) { this.nip = nip; }

    public String getJabatan() { return jabatan; }
    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public String getNamaFaskes() { return namaFaskes; }
    public void setNamaFaskes(String faskes) {
        this.namaFaskes = faskes;
    }

    /**
     * Polymorphism: implementasi berbeda dari
     * getInfo() khusus untuk PetugasKesehatan.
     */
    @Override
    public String getInfo() {
        return String.format(
            "=== Data Petugas Kesehatan ===\n"
            + "ID      : %d\n"
            + "Nama    : %s\n"
            + "NIP     : %s\n"
            + "Jabatan : %s\n"
            + "Faskes  : %s\n"
            + "No HP   : %s",
            id, nama, nip, jabatan,
            namaFaskes, noHp
        );
    }
}
________________________________________
L. KODE PROGRAM JAVA LENGKAP
JadwalService.java (Business Logic + JCF)
java
package service;

import dao.JadwalDAO;
import dao.VaksinDAO;
import model.Anak;
import model.JadwalImunisasi;
import model.Vaksin;

import java.time.LocalDate;
import java.util.*;

/**
 * JadwalService berisi logika bisnis untuk
 * pengelolaan jadwal imunisasi.
 *
 * Konsep JCF: List, Map digunakan untuk
 * mengelola dan mengelompokkan jadwal.
 */
public class JadwalService {

    private VaksinDAO vaksinDAO;
    private JadwalDAO jadwalDAO;

    public JadwalService() {
        this.vaksinDAO = new VaksinDAO();
        this.jadwalDAO = new JadwalDAO();
    }

    /**
     * Membuat jadwal imunisasi secara otomatis
     * berdasarkan tanggal lahir anak.
     *
     * Logika: tanggalTarget = tglLahir + usiaBulan
     *
     * @param anak objek Anak yang baru didaftarkan
     */
    public void generateJadwal(Anak anak) {
        System.out.println(
            "\n[PROSES] Membuat jadwal imunisasi "
            + "untuk " + anak.getNama() + "..."
        );

        // JCF: ambil semua vaksin ke dalam List
        List<Vaksin> semuaVaksin = vaksinDAO.findAll();

        int berhasil = 0;
        for (Vaksin vaksin : semuaVaksin) {

            // Hitung tanggal target otomatis
            LocalDate tglTarget =
                anak.getTanggalLahir()
                    .plusMonths(
                        vaksin.getUsiaBulanPemberian()
                    );

            JadwalImunisasi jadwal =
                new JadwalImunisasi();
            jadwal.setAnakId(anak.getId());
            jadwal.setVaksinId(vaksin.getId());
            jadwal.setNamaVaksin(vaksin.getNamaVaksin());
            jadwal.setTanggalTarget(tglTarget);
            jadwal.setStatus("MENDATANG");

            jadwalDAO.save(jadwal);
            berhasil++;
        }

        System.out.println(
            "[OK] " + berhasil
            + " jadwal imunisasi berhasil dibuat."
        );
    }

    /**
     * Mengelompokkan jadwal berdasarkan status.
     * JCF: menggunakan HashMap<String, List<>>
     *
     * @param anakId ID anak yang ingin dilihat
     * @return Map dengan key=status, value=List jadwal
     */
    public Map<String, List<JadwalImunisasi>>
    getJadwalGroupedByStatus(int anakId) {

        // Ambil semua jadwal anak
        List<JadwalImunisasi> semuaJadwal =
            jadwalDAO.findByAnakId(anakId);

        // Update status TERLEWAT secara otomatis
        LocalDate hari = LocalDate.now();
        for (JadwalImunisasi j : semuaJadwal) {
            if ("MENDATANG".equals(j.getStatus())
                    && j.getTanggalTarget()
                         .isBefore(hari)) {
                j.setStatus("TERLEWAT");
                jadwalDAO.updateStatus(
                    j.getId(), "TERLEWAT"
                );
            }
        }

        // JCF: HashMap untuk grouping
        Map<String, List<JadwalImunisasi>> grouped =
            new LinkedHashMap<>();
        grouped.put("MENDATANG", new ArrayList<>());
        grouped.put("SELESAI",   new ArrayList<>());
        grouped.put("TERTUNDA",  new ArrayList<>());
        grouped.put("TERLEWAT",  new ArrayList<>());

        for (JadwalImunisasi j : semuaJadwal) {
            List<JadwalImunisasi> list =
                grouped.get(j.getStatus());
            if (list != null) {
                list.add(j);
            }
        }

        return grouped;
    }

    /**
     * Menghitung persentase kelengkapan imunisasi.
     *
     * @param anakId ID anak
     * @return String format laporan kelengkapan
     */
    public String getLaporanKelengkapan(int anakId) {
        List<JadwalImunisasi> semua =
            jadwalDAO.findByAnakId(anakId);

        if (semua.isEmpty()) {
            return "Belum ada jadwal imunisasi.";
        }

        long selesai = semua.stream()
            .filter(j -> "SELESAI".equals(j.getStatus()))
            .count();

        long terlewat = semua.stream()
            .filter(j -> "TERLEWAT".equals(j.getStatus()))
            .count();

        int total = semua.size();
        double persen = (selesai * 100.0 / total);

        return String.format(
            "Total  : %d vaksin\n"
            + "Selesai: %d vaksin (%.0f%%)\n"
            + "Terlewat: %d vaksin\n"
            + "Sisa   : %d vaksin",
            total, selesai, persen,
            terlewat, (total - selesai)
        );
    }
}
Main.java (Menu Console Lengkap)
java
package main;

import dao.*;
import driver.DatabaseConnection;
import model.*;
import service.*;
import util.InputHelper;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * Main adalah entry point program ImuniKu.
 * Menampilkan menu konsol interaktif dan
 * menghubungkan semua komponen sistem.
 */
public class Main {

    // DAO dan Service yang digunakan
    private static IbuDAO ibuDAO = new IbuDAO();
    private static AnakDAO anakDAO = new AnakDAO();
    private static VaksinDAO vaksinDAO = new VaksinDAO();
    private static RiwayatDAO riwayatDAO =
        new RiwayatDAO();
    private static JadwalService jadwalService =
        new JadwalService();
    private static InputHelper input = new InputHelper();

    public static void main(String[] args) {

        // Inisialisasi koneksi database
        if (DatabaseConnection.getConnection() == null) {
            System.err.println(
                "Program tidak dapat berjalan "
                + "tanpa koneksi database."
            );
            return;
        }

        System.out.println(
            "\n======================================="
        );
        System.out.println(
            "  IMUNIKU — Sistem Informasi Imunisasi"
        );
        System.out.println(
            "  Ibu dan Anak | IT Del 2026"
        );
        System.out.println(
            "======================================="
        );

        boolean running = true;
        while (running) {
            tampilMenuUtama();
            int pilihan = input.readInt("Pilihan: ");

            switch (pilihan) {
                case 1 -> menuManajemenIbu();
                case 2 -> menuManajemenAnak();
                case 3 -> menuImunisasi();
                case 4 -> menuMasterVaksin();
                case 5 -> menuLaporan();
                case 0 -> running = false;
                default ->
                    System.out.println(
                        "[!] Pilihan tidak valid."
                    );
            }
        }

        System.out.println(
            "\nTerima kasih menggunakan ImuniKu."
        );
        DatabaseConnection.closeConnection();
        input.close();
    }

    // ─────────────────────────────────────────────
    // MENU UTAMA
    // ─────────────────────────────────────────────

    private static void tampilMenuUtama() {
        System.out.println(
            "\n─────────────────────────────"
        );
        System.out.println("  MENU UTAMA");
        System.out.println(
            "─────────────────────────────"
        );
        System.out.println("1. Manajemen Ibu");
        System.out.println("2. Manajemen Anak");
        System.out.println("3. Imunisasi");
        System.out.println("4. Master Data Vaksin");
        System.out.println("5. Laporan");
        System.out.println("0. Keluar");
        System.out.println(
            "─────────────────────────────"
        );
    }

    // ─────────────────────────────────────────────
    // MENU MANAJEMEN IBU
    // ─────────────────────────────────────────────

    private static void menuManajemenIbu() {
        boolean kembali = false;
        while (!kembali) {
            System.out.println(
                "\n── Manajemen Ibu ──"
            );
            System.out.println("1. Daftarkan Ibu Baru");
            System.out.println("2. Lihat Semua Ibu");
            System.out.println("3. Cari Ibu");
            System.out.println("0. Kembali");

            int p = input.readInt("Pilihan: ");
            switch (p) {
                case 1 -> daftarIbuBaru();
                case 2 -> lihatSemuaIbu();
                case 3 -> cariIbu();
                case 0 -> kembali = true;
                default ->
                    System.out.println(
                        "[!] Pilihan tidak valid."
                    );
            }
        }
    }

    private static void daftarIbuBaru() {
        System.out.println("\n─── Daftar Ibu Baru ───");

        String nama = input.readString("Nama lengkap  : ");
        String nik  = input.readString("NIK (16 digit): ");
        String alamat = input.readString("Alamat        : ");
        String noHp = input.readString("No HP         : ");
        String tglStr = input.readString(
            "Tgl lahir (yyyy-MM-dd): "
        );

        LocalDate tglLahir = null;
        try {
            tglLahir = LocalDate.parse(tglStr);
        } catch (Exception e) {
            System.out.println(
                "[!] Format tanggal tidak valid. "
                + "Menggunakan null."
            );
        }

        Ibu ibu = new Ibu(nama, nik, alamat,
                          noHp, tglLahir);
        ibuDAO.save(ibu);
    }

    private static void lihatSemuaIbu() {
        System.out.println("\n─── Daftar Semua Ibu ───");
        List<Ibu> daftarIbu = ibuDAO.findAll();

        if (daftarIbu.isEmpty()) {
            System.out.println(
                "Belum ada data ibu terdaftar."
            );
            return;
        }

        System.out.printf(
            "%-5s %-25s %-18s %-15s%n",
            "ID", "Nama", "NIK", "No HP"
        );
        System.out.println("-".repeat(65));

        // JCF: iterasi List<Ibu>
        for (Ibu ibu : daftarIbu) {
            System.out.printf(
                "%-5d %-25s %-18s %-15s%n",
                ibu.getId(),
                ibu.getNama(),
                ibu.getNik(),
                ibu.getNoHp()
            );
        }
        System.out.println(
            "Total: " + daftarIbu.size() + " ibu"
        );
    }

    private static void cariIbu() {
        System.out.println("\n─── Cari Ibu ───");
        System.out.println(
            "Cari berdasarkan: 1.NIK  2.Nama"
        );
        int p = input.readInt("Pilihan: ");

        if (p == 1) {
            String nik = input.readString("Masukkan NIK: ");
            Ibu ibu = ibuDAO.findByNik(nik);
            if (ibu != null) {
                System.out.println(ibu.getInfo());
            } else {
                System.out.println(
                    "[!] Ibu dengan NIK " + nik
                    + " tidak ditemukan."
                );
            }
        } else if (p == 2) {
            String nama =
                input.readString("Masukkan nama: ");
            List<Ibu> hasil =
                ibuDAO.findByNama(nama);
            if (hasil.isEmpty()) {
                System.out.println(
                    "[!] Tidak ditemukan."
                );
            } else {
                hasil.forEach(System.out::println);
            }
        }
    }

    // ─────────────────────────────────────────────
    // MENU MANAJEMEN ANAK
    // ─────────────────────────────────────────────

    private static void menuManajemenAnak() {
        boolean kembali = false;
        while (!kembali) {
            System.out.println(
                "\n── Manajemen Anak ──"
            );
            System.out.println("1. Daftarkan Anak Baru");
            System.out.println("2. Lihat Anak per Ibu");
            System.out.println("0. Kembali");

            int p = input.readInt("Pilihan: ");
            switch (p) {
                case 1 -> daftarAnakBaru();
                case 2 -> lihatAnakPerIbu();
                case 0 -> kembali = true;
            }
        }
    }

    private static void daftarAnakBaru() {
        System.out.println(
            "\n─── Daftar Anak Baru ───"
        );

        int ibuId = input.readInt("ID Ibu         : ");
        Ibu ibu = ibuDAO.findById(ibuId);
        if (ibu == null) {
            System.out.println(
                "[!] Ibu dengan ID " + ibuId
                + " tidak ditemukan."
            );
            return;
        }
        System.out.println(
            "Ibu: " + ibu.getNama()
        );

        String nama =
            input.readString("Nama anak      : ");
        String tglStr = input.readString(
            "Tgl lahir (yyyy-MM-dd): "
        );
        System.out.println(
            "Jenis kelamin: 1.Laki-laki  2.Perempuan"
        );
        int jk = input.readInt("Pilihan: ");
        String jenisKelamin =
            (jk == 1) ? "Laki-laki" : "Perempuan";

        LocalDate tglLahir;
        try {
            tglLahir = LocalDate.parse(tglStr);
        } catch (Exception e) {
            System.out.println(
                "[!] Format tanggal tidak valid."
            );
            return;
        }

        Anak anak = new Anak(
            nama, tglLahir, jenisKelamin, ibuId
        );
        anakDAO.save(anak);

        if (anak.getId() > 0) {
            // Generate jadwal otomatis setelah
            // anak berhasil didaftarkan
            jadwalService.generateJadwal(anak);
        }
    }

    private static void lihatAnakPerIbu() {
        int ibuId = input.readInt("Masukkan ID Ibu: ");
        List<Anak> daftarAnak =
            anakDAO.findByOrangTuaId(ibuId);

        if (daftarAnak.isEmpty()) {
            System.out.println(
                "Belum ada anak terdaftar untuk ibu ini."
            );
            return;
        }

        System.out.println(
            "\n── Daftar Anak ──"
        );
        for (Anak anak : daftarAnak) {
            System.out.println(anak);
        }
    }

    // ─────────────────────────────────────────────
    // MENU IMUNISASI
    // ─────────────────────────────────────────────

    private static void menuImunisasi() {
        boolean kembali = false;
        while (!kembali) {
            System.out.println(
                "\n── Manajemen Imunisasi ──"
            );
            System.out.println("1. Catat Imunisasi");
            System.out.println("2. Lihat Jadwal Anak");
            System.out.println("3. Lihat Riwayat Anak");
            System.out.println("0. Kembali");

            int p = input.readInt("Pilihan: ");
            switch (p) {
                case 1 -> catatImunisasi();
                case 2 -> lihatJadwal();
                case 3 -> lihatRiwayat();
                case 0 -> kembali = true;
            }
        }
    }

    private static void lihatJadwal() {
        int anakId = input.readInt(
            "Masukkan ID Anak: "
        );
        Anak anak = anakDAO.findById(anakId);
        if (anak == null) {
            System.out.println(
                "[!] Anak tidak ditemukan."
            );
            return;
        }

        System.out.println(
            "\n── Jadwal Imunisasi: "
            + anak.getNama() + " ──"
        );

        // JCF: Map<String, List<>> dari JadwalService
        Map<String, List<JadwalImunisasi>> grouped =
            jadwalService.getJadwalGroupedByStatus(
                anakId
            );

        for (Map.Entry<String,
                 List<JadwalImunisasi>> entry
             : grouped.entrySet()) {

            String status = entry.getKey();
            List<JadwalImunisasi> list = entry.getValue();

            if (!list.isEmpty()) {
                System.out.println(
                    "\n[" + status + "]"
                );
                for (JadwalImunisasi j : list) {
                    System.out.printf(
                        "  %-30s → %s%n",
                        j.getNamaVaksin(),
                        j.getTanggalTarget()
                    );
                }
            }
        }

        System.out.println(
            "\n── Status Kelengkapan ──"
        );
        System.out.println(
            jadwalService.getLaporanKelengkapan(anakId)
        );
    }

    private static void catatImunisasi() {
        System.out.println(
            "\n─── Catat Imunisasi ───"
        );

        int anakId = input.readInt("ID Anak  : ");
        int vaksinId = input.readInt("ID Vaksin: ");
        String faskes =
            input.readString("Nama Faskes: ");
        String petugas =
            input.readString("Nama Petugas: ");
        String catatan =
            input.readString("Catatan (Enter=kosong): ");

        RiwayatImunisasi riwayat =
            new RiwayatImunisasi();
        riwayat.setAnakId(anakId);
        riwayat.setVaksinId(vaksinId);
        riwayat.setTanggalPelaksanaan(LocalDate.now());
        riwayat.setNamaFaskes(faskes);
        riwayat.setNamaPetugas(petugas);
        riwayat.setCatatan(catatan);

        riwayatDAO.save(riwayat);
    }

    private static void lihatRiwayat() {
        int anakId = input.readInt("ID Anak: ");
        List<RiwayatImunisasi> riwayat =
            riwayatDAO.findByAnakId(anakId);

        if (riwayat.isEmpty()) {
            System.out.println(
                "Belum ada riwayat imunisasi."
            );
            return;
        }

        System.out.println(
            "\n── Riwayat Imunisasi ──"
        );
        for (RiwayatImunisasi r : riwayat) {
            System.out.println(r);
        }
    }

    // ─────────────────────────────────────────────
    // MENU MASTER VAKSIN
    // ─────────────────────────────────────────────

    private static void menuMasterVaksin() {
        System.out.println(
            "\n─── Daftar Master Vaksin ───"
        );
        List<Vaksin> vaksinList = vaksinDAO.findAll();

        System.out.printf(
            "%-5s %-10s %-30s %-8s%n",
            "ID", "Kode", "Nama Vaksin", "Usia(bln)"
        );
        System.out.println("-".repeat(55));

        for (Vaksin v : vaksinList) {
            System.out.printf(
                "%-5d %-10s %-30s %-8d%n",
                v.getId(),
                v.getKodeVaksin(),
                v.getNamaVaksin(),
                v.getUsiaBulanPemberian()
            );
        }
    }

    // ─────────────────────────────────────────────
    // MENU LAPORAN
    // ─────────────────────────────────────────────

    private static void menuLaporan() {
        System.out.println(
            "\n─── Laporan ───"
        );
        System.out.println(
            "1. Status Imunisasi per Anak"
        );
        System.out.println(
            "2. Statistik Ibu Terdaftar"
        );
        System.out.println("0. Kembali");

        int p = input.readInt("Pilihan: ");

        if (p == 1) {
            int anakId =
                input.readInt("ID Anak: ");
            System.out.println(
                jadwalService.getLaporanKelengkapan(
                    anakId
                )
            );
        } else if (p == 2) {
            Map<String, Integer> stat =
                ibuDAO.getStatistik();
            System.out.println(
                "\n── Statistik Ibu ──"
            );
            System.out.println(
                "Total terdaftar  : "
                + stat.get("total")
            );
            System.out.println(
                "Baru bulan ini   : "
                + stat.get("baru_bulan_ini")
            );
        }
    }
}
InputHelper.java (Util)
java
package util;

import java.util.Scanner;

/**
 * InputHelper menyediakan method helper
 * untuk membaca input dari konsol dengan
 * penanganan error yang baik.
 */
public class InputHelper {

    private Scanner scanner;

    public InputHelper() {
        this.scanner = new Scanner(System.in);
    }

    public String readString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    public int readInt(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                int value =
                    Integer.parseInt(
                        scanner.nextLine().trim()
                    );
                return value;
            } catch (NumberFormatException e) {
                System.out.println(
                    "[!] Masukkan angka yang valid."
                );
            }
        }
    }

    public void close() {
        scanner.close();
    }
}
________________________________________
M. FLOW PROGRAM
1. Program dimulai → Main.main()
        │
        ▼
2. DatabaseConnection.getConnection()
   → Cek koneksi MySQL
   → Jika gagal: tampil error, program berhenti
        │
        ▼
3. Tampil banner selamat datang ImuniKu
        │
        ▼
4. Masuk loop Menu Utama
        │
        ├── Pilih 1: Manajemen Ibu
        │       ├── Daftar Ibu Baru
        │       │   → Input data → IbuDAO.save()
        │       │   → PreparedStatement INSERT
        │       │   → Ibu tersimpan di database
        │       ├── Lihat Semua Ibu
        │       │   → IbuDAO.findAll()
        │       │   → IbuMapper.mapRows(ResultSet)
        │       │   → Tampil List<Ibu>
        │       └── Cari Ibu
        │           → IbuDAO.findByNik() / findByNama()
        │
        ├── Pilih 2: Manajemen Anak
        │       └── Daftar Anak Baru
        │           → Input data → AnakDAO.save()
        │           → JadwalService.generateJadwal()
        │             → VaksinDAO.findAll() → List<Vaksin>
        │             → Loop: hitung tanggal target
        │             → JadwalDAO.save() × 15 jadwal
        │
        ├── Pilih 3: Imunisasi
        │       ├── Catat Imunisasi
        │       │   → Input → RiwayatDAO.save()
        │       │   → JadwalDAO.updateStatus(SELESAI)
        │       ├── Lihat Jadwal
        │       │   → JadwalService.getJadwalGroupedByStatus()
        │       │   → Map<String, List<JadwalImunisasi>>
        │       │   → Tampil dikelompokkan per status
        │       └── Lihat Riwayat
        │           → RiwayatDAO.findByAnakId()
        │           → Tampil List<RiwayatImunisasi>
        │
        ├── Pilih 4: Master Vaksin
        │       → VaksinDAO.findAll() → Tampil tabel
        │
        ├── Pilih 5: Laporan
        │       → Statistik HashMap, kelengkapan %
        │
        └── Pilih 0: Keluar
                → DatabaseConnection.closeConnection()
                → InputHelper.close()
                → Program selesai
________________________________________
N. PANDUAN LANGKAH DEMI LANGKAH
Step 1 — Install Java JDK
Download Java JDK 17 atau 21 dari adoptium.net (Eclipse Temurin). Install dan tambahkan ke PATH sistem. Verifikasi dengan menjalankan java -version di terminal — harus muncul versi yang sesuai.
Step 2 — Install MySQL
Download MySQL Community Server 8.x dari mysql.com/downloads. Install dengan memilih Developer Default setup. Catat password root yang dibuat saat instalasi. Verifikasi dengan menjalankan mysql -u root -p di terminal.
Step 3 — Install IDE
Download dan install IntelliJ IDEA Community Edition atau NetBeans IDE 18+. Keduanya gratis dan mendukung Java 17/21 dengan baik.
Step 4 — Download MySQL Connector/J
Kunjungi dev.mysql.com/downloads/connector/j dan download versi Platform Independent (JAR file). Simpan file JAR di lokasi yang mudah diakses, misalnya di folder lib dalam project.
Step 5 — Buat Project Java
Di IntelliJ: File → New Project → Java → Pilih Java SDK 17/21 → Beri nama ImuniKu. Di NetBeans: File → New Project → Java Application → Beri nama ImuniKu.
Step 6 — Tambahkan JDBC Driver ke Project
Di IntelliJ: klik kanan project → Open Module Settings → Dependencies → + → JARs → pilih mysql-connector-j.jar. Di NetBeans: klik kanan Libraries → Add JAR/Folder → pilih file JAR yang sudah didownload.
Step 7 — Buat Struktur Package
Di src, buat package berikut dengan klik kanan → New Package: model, driver, dao, mapper, service, util, main.
Step 8 — Buat Database
Buka MySQL Workbench atau terminal MySQL, kemudian jalankan file database/imuniku.sql yang sudah disiapkan. Pastikan semua tabel terbuat dan data master vaksin sudah ter-insert dengan menjalankan SELECT * FROM vaksin; — harus muncul 15 baris data vaksin.
Step 9 — Implementasi Kelas (Urutan Pengerjaan)
Kerjakan kelas dalam urutan berikut agar tidak ada dependency error: pertama DatabaseConnection.java, kedua semua kelas model mulai dari Person.java lalu Ibu.java, PetugasKesehatan.java, Anak.java, Vaksin.java, JadwalImunisasi.java, RiwayatImunisasi.java. Ketiga buat BaseMapper.java dan BaseDAO.java, keempat implementasikan semua Mapper dan DAO, kelima buat JadwalService.java, keenam buat InputHelper.java, dan terakhir buat Main.java.
Step 10 — Testing Bertahap
Jangan langsung jalankan Main.java. Test setiap komponen secara bertahap. Pertama test koneksi database dengan membuat class test sementara yang hanya memanggil DatabaseConnection.getConnection(). Kedua test IbuDAO.save() dengan data hardcoded. Ketiga test findAll() dan verifikasi data tampil. Keempat test generateJadwal() dan verifikasi 15 jadwal terbuat di tabel.
Step 11 — Jalankan Program Lengkap
Setelah semua komponen tertest, jalankan Main.java. Ikuti alur: daftar ibu baru → daftar anak → lihat jadwal yang terbentuk otomatis → catat imunisasi → lihat riwayat → lihat laporan kelengkapan.
________________________________________
O. EVALUASI PROYEK
Kelebihan
Proyek ini menerapkan semua konsep PBO secara natural dan tidak dipaksakan. Setiap konsep muncul karena memang dibutuhkan oleh domain masalah, bukan sekadar untuk memenuhi syarat akademik. Topiknya relevan dengan isu kesehatan masyarakat di daerah yang menjadi konteks riset proyek UI/UX sebelumnya. Kode dapat langsung dijalankan dan didemonstrasikan di hadapan dosen. Struktur project terorganisir dengan baik menggunakan package yang mencerminkan layered architecture sederhana.
Kekurangan
Antarmuka berbasis konsol membatasi pengalaman pengguna — tidak ada validasi input yang komprehensif untuk semua skenario. Sistem belum memiliki fitur autentikasi/login yang sesungguhnya. Notifikasi pengingat jadwal belum bisa dikirim secara aktif karena keterbatasan platform konsol.
Tingkat Kesulitan
Sedang. Cocok untuk mahasiswa semester 4 yang sudah memahami OOP dasar dan memiliki pengalaman dengan database sederhana. Waktu pengerjaan estimasi dua hingga tiga minggu dengan kecepatan kerja normal.
Kesesuaian dengan Tugas PBO
Sangat sesuai. Seluruh empat konsep wajib (JDBC, JCF, Inheritance, ORM Data Mapper) diterapkan secara eksplisit dan dapat diidentifikasi dengan jelas dalam kode.
Nilai Portfolio
Tinggi. Proyek ini menunjukkan kemampuan mengintegrasikan Java dengan database, memahami pola desain Data Mapper, dan menerapkan OOP dalam konteks masalah nyata. Relevansi sosialnya terhadap isu imunisasi anak menjadi nilai tambah saat presentasi.
________________________________________
P. OUTPUT TAMBAHAN
Fitur Lanjutan yang Disarankan
Sistem notifikasi SMS atau WhatsApp menggunakan API seperti Twilio atau Fonnte untuk mengirimkan pengingat jadwal imunisasi kepada orang tua beberapa hari sebelum jadwal tiba. Fitur import dan export data dalam format CSV atau PDF menggunakan library Apache POI atau iText. Pencarian lanjutan dengan filter berdasarkan wilayah, status imunisasi, atau rentang usia anak. Fitur reschedule otomatis yang memperbarui tanggal target dan notifikasi secara bersamaan.
Ide Pengembangan Web atau Mobile
Backend sistem ini dapat dikembangkan menjadi REST API menggunakan Spring Boot, kemudian dikonsumsi oleh aplikasi Android (Kotlin/Java) atau aplikasi web (React atau Vue.js). Struktur DAO dan Service yang sudah ada dapat digunakan kembali hampir tanpa perubahan ketika migrasi ke Spring Boot.
Ide Dashboard Admin
Dashboard berbasis web menggunakan teknologi sederhana seperti JSP/Servlet atau Spring MVC yang menampilkan peta sebaran anak berdasarkan kelurahan, grafik cakupan imunisasi per bulan, tabel anak yang jadwalnya terlewat dan perlu di-follow up, serta rekap laporan yang bisa diekspor ke Excel untuk keperluan pelaporan ke Dinas Kesehatan.
Ide Laporan Statistik
Laporan agregat yang menampilkan persentase cakupan imunisasi per desa atau kelurahan, tren cakupan dari bulan ke bulan, daftar anak yang belum mendapat imunisasi tertentu, dan perbandingan antara target nasional 95% dengan capaian aktual wilayah setempat.

