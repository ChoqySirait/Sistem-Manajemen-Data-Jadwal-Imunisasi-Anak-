package Imuniku.src.model;

/**
 * Model Vaksin - Merepresentasikan data vaksin
 * 
 * Konsep PBO:
 * - Encapsulation: atribut private dengan getter/setter
 */
public class Vaksin {
    private int id;
    private String kodeVaksin;
    private String namaVaksin;
    private String namaUmum;
    private String penyakitDicegah;
    private int usiaBulanPemberian;
    private int dosisDiperlukan;
    private String caraPemberian;

    public Vaksin() {}

    public Vaksin(String kodeVaksin, String namaVaksin, String namaUmum,
                  String penyakitDicegah, int usiaBulanPemberian,
                  int dosisDiperlukan, String caraPemberian) {
        this.kodeVaksin = kodeVaksin;
        this.namaVaksin = namaVaksin;
        this.namaUmum = namaUmum;
        this.penyakitDicegah = penyakitDicegah;
        this.usiaBulanPemberian = usiaBulanPemberian;
        this.dosisDiperlukan = dosisDiperlukan;
        this.caraPemberian = caraPemberian;
    }

    // ── Getter & Setter ──────────────────────────
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getKodeVaksin() { return kodeVaksin; }
    public void setKodeVaksin(String kode) { this.kodeVaksin = kode; }

    public String getNamaVaksin() { return namaVaksin; }
    public void setNamaVaksin(String nama) { this.namaVaksin = nama; }

    public String getNamaUmum() { return namaUmum; }
    public void setNamaUmum(String nama) { this.namaUmum = nama; }

    public String getPenyakitDicegah() { return penyakitDicegah; }
    public void setPenyakitDicegah(String penyakit) { this.penyakitDicegah = penyakit; }

    public int getUsiaBulanPemberian() { return usiaBulanPemberian; }
    public void setUsiaBulanPemberian(int usia) { this.usiaBulanPemberian = usia; }

    public int getDosisDiperlukan() { return dosisDiperlukan; }
    public void setDosisDiperlukan(int dosis) { this.dosisDiperlukan = dosis; }

    public String getCaraPemberian() { return caraPemberian; }
    public void setCaraPemberian(String cara) { this.caraPemberian = cara; }

    @Override
    public String toString() {
        return String.format("ID: %d | Kode: %s | Nama: %s | Usia: %d bulan | Dosis: %d",
            id, kodeVaksin, namaVaksin, usiaBulanPemberian, dosisDiperlukan);
    }
}
