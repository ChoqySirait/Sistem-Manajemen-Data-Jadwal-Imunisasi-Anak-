package Imuniku.src.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

/**
 * Model Anak - Merepresentasikan data anak
 * 
 * Konsep PBO:
 * - Encapsulation: atribut private dengan getter/setter
 * - JCF: Menggunakan List untuk koleksi jadwal dan riwayat imunisasi
 */
public class Anak {
    private int id;
    private String nama;
    private LocalDate tanggalLahir;
    private String jenisKelamin;
    private int ibuId;
    private List<JadwalImunisasi> daftarJadwal;
    private List<RiwayatImunisasi> daftarRiwayat;

    public Anak() {
        this.daftarJadwal = new ArrayList<>();
        this.daftarRiwayat = new ArrayList<>();
    }

    public Anak(String nama, LocalDate tanggalLahir, String jenisKelamin, int ibuId) {
        this.nama = nama;
        this.tanggalLahir = tanggalLahir;
        this.jenisKelamin = jenisKelamin;
        this.ibuId = ibuId;
        this.daftarJadwal = new ArrayList<>();
        this.daftarRiwayat = new ArrayList<>();
    }

    // ── Getter & Setter ──────────────────────────
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public LocalDate getTanggalLahir() { return tanggalLahir; }
    public void setTanggalLahir(LocalDate tgl) { this.tanggalLahir = tgl; }

    public String getJenisKelamin() { return jenisKelamin; }
    public void setJenisKelamin(String jk) { this.jenisKelamin = jk; }

    public int getIbuId() { return ibuId; }
    public void setIbuId(int ibuId) { this.ibuId = ibuId; }

    public List<JadwalImunisasi> getDaftarJadwal() { return daftarJadwal; }
    public void setDaftarJadwal(List<JadwalImunisasi> list) { this.daftarJadwal = list; }

    public List<RiwayatImunisasi> getDaftarRiwayat() { return daftarRiwayat; }
    public void setDaftarRiwayat(List<RiwayatImunisasi> list) { this.daftarRiwayat = list; }

    /**
     * Menghitung usia anak dalam bulan dari tanggal lahir
     * Konsep: Business logic di model
     */
    public int getUsiaBulan() {
        if (this.tanggalLahir == null) return 0;
        return (int) ChronoUnit.MONTHS.between(tanggalLahir, LocalDate.now());
    }

    /**
     * Mengembalikan status kelengkapan imunisasi
     */
    public String getStatusKelengkapan() {
        if (daftarJadwal.isEmpty()) {
            return "Belum ada jadwal";
        }
        
        long selesai = daftarJadwal.stream()
            .filter(j -> "SELESAI".equals(j.getStatus()))
            .count();
        
        double persentase = (selesai / (double) daftarJadwal.size()) * 100;
        
        if (persentase == 100) return "Lengkap";
        if (persentase >= 75) return "Sebagian Besar";
        if (persentase >= 50) return "Setengah";
        return "Belum Lengkap";
    }

    @Override
    public String toString() {
        return String.format("ID: %d | Nama: %s | Usia: %d bulan | JK: %s",
            id, nama, getUsiaBulan(), jenisKelamin);
    }
}
