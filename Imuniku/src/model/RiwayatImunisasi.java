package Imuniku.src.model;

import java.time.LocalDate;

/**
 * Model RiwayatImunisasi - Merepresentasikan riwayat pelaksanaan imunisasi
 * 
 * Konsep PBO:
 * - Encapsulation: atribut private dengan getter/setter
 */
public class RiwayatImunisasi {
    private int id;
    private int anakId;
    private int vaksinId;
    private String namaVaksin;
    private LocalDate tanggalPelaksanaan;
    private String namaFaskes;
    private String namaPetugas;
    private String catatan;
    private int petugasId;

    public RiwayatImunisasi() {}

    public RiwayatImunisasi(int anakId, int vaksinId, String namaVaksin,
                           LocalDate tanggalPelaksanaan, String namaFaskes,
                           String namaPetugas, String catatan) {
        this.anakId = anakId;
        this.vaksinId = vaksinId;
        this.namaVaksin = namaVaksin;
        this.tanggalPelaksanaan = tanggalPelaksanaan;
        this.namaFaskes = namaFaskes;
        this.namaPetugas = namaPetugas;
        this.catatan = catatan;
    }

    // ── Getter & Setter ──────────────────────────
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getAnakId() { return anakId; }
    public void setAnakId(int anakId) { this.anakId = anakId; }

    public int getVaksinId() { return vaksinId; }
    public void setVaksinId(int vaksinId) { this.vaksinId = vaksinId; }

    public String getNamaVaksin() { return namaVaksin; }
    public void setNamaVaksin(String nama) { this.namaVaksin = nama; }

    public LocalDate getTanggalPelaksanaan() { return tanggalPelaksanaan; }
    public void setTanggalPelaksanaan(LocalDate tgl) { this.tanggalPelaksanaan = tgl; }

    public String getNamaFaskes() { return namaFaskes; }
    public void setNamaFaskes(String nama) { this.namaFaskes = nama; }

    public String getNamaPetugas() { return namaPetugas; }
    public void setNamaPetugas(String nama) { this.namaPetugas = nama; }

    public String getCatatan() { return catatan; }
    public void setCatatan(String catatan) { this.catatan = catatan; }

    public int getPetugasId() { return petugasId; }
    public void setPetugasId(int petugasId) { this.petugasId = petugasId; }

    @Override
    public String toString() {
        return String.format("ID: %d | Vaksin: %s | Tgl: %s | Faskes: %s | Petugas: %s",
            id, namaVaksin, tanggalPelaksanaan, namaFaskes, namaPetugas);
    }
}
