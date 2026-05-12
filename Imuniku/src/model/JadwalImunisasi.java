package Imuniku.src.model;

import java.time.LocalDate;

/**
 * Model JadwalImunisasi - Merepresentasikan jadwal imunisasi anak
 * 
 * Konsep PBO:
 * - Encapsulation: atribut private dengan getter/setter
 */
public class JadwalImunisasi {
    private int id;
    private int anakId;
    private int vaksinId;
    private String namaVaksin;
    private LocalDate tanggalTarget;
    private String status; // MENDATANG, SELESAI, TERTUNDA, TERLEWAT

    public JadwalImunisasi() {}

    public JadwalImunisasi(int anakId, int vaksinId, String namaVaksin,
                          LocalDate tanggalTarget, String status) {
        this.anakId = anakId;
        this.vaksinId = vaksinId;
        this.namaVaksin = namaVaksin;
        this.tanggalTarget = tanggalTarget;
        this.status = status;
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

    public LocalDate getTanggalTarget() { return tanggalTarget; }
    public void setTanggalTarget(LocalDate tgl) { this.tanggalTarget = tgl; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    /**
     * Mengecek apakah jadwal sudah lewat jatuh tempo
     */
    public boolean isLewatJatuhTempo() {
        if (tanggalTarget == null) return false;
        if ("SELESAI".equals(status)) return false;
        return LocalDate.now().isAfter(tanggalTarget);
    }

    @Override
    public String toString() {
        return String.format("ID: %d | Vaksin: %s | Target: %s | Status: %s",
            id, namaVaksin, tanggalTarget, status);
    }
}
