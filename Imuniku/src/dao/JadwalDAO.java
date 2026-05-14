package Imuniku.src.dao;

import Imuniku.src.driver.DatabaseConnection;
import Imuniku.src.mapper.JadwalMapper;
import Imuniku.src.model.JadwalImunisasi;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * JadwalDAO - Data Access Object untuk JadwalImunisasi
 * Menangani semua operasi database untuk entity JadwalImunisasi.
 *
 * Konsep PBO: Inheritance (extends BaseDAO)
 * Konsep JDBC: PreparedStatement, ResultSet
 * Konsep JCF: List
 */
public class JadwalDAO extends BaseDAO<JadwalImunisasi> {

    private Connection conn;
    private JadwalMapper mapper;

    public JadwalDAO() {
        this.conn = DatabaseConnection.getConnection();
        this.mapper = new JadwalMapper();
    }

    /**
     * Menyimpan data JadwalImunisasi baru ke database.
     * JDBC: menggunakan PreparedStatement
     * untuk keamanan dari SQL Injection.
     */
    @Override
    public void save(JadwalImunisasi jadwal) {
        String sql =
            "INSERT INTO jadwal_imunisasi "
            + "(anak_id, vaksin_id, tanggal_target, status) "
            + "VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps =
                 conn.prepareStatement(
                     sql,
                     Statement.RETURN_GENERATED_KEYS
                 )) {

            ps.setInt(1, jadwal.getAnakId());
            ps.setInt(2, jadwal.getVaksinId());
            
            if (jadwal.getTanggalTarget() != null) {
                ps.setDate(3, Date.valueOf(
                    jadwal.getTanggalTarget()
                ));
            } else {
                ps.setNull(3, Types.DATE);
            }
            
            ps.setString(4, jadwal.getStatus() != null ? jadwal.getStatus() : "MENDATANG");
            
            ps.executeUpdate();

            // Ambil ID yang di-generate database
            ResultSet generatedKeys =
                ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                jadwal.setId(generatedKeys.getInt(1));
                System.out.println(
                    "[OK] Jadwal imunisasi berhasil disimpan "
                    + "(ID: " + jadwal.getId() + ")"
                );
            }

        } catch (SQLException e) {
            System.err.println(
                "[ERROR] Gagal menyimpan jadwal imunisasi: "
                + e.getMessage()
            );
        }
    }

    /**
     * Mengambil semua data JadwalImunisasi dari database.
     * JCF: mengembalikan List<JadwalImunisasi>
     * ORM: menggunakan JadwalMapper.mapRows()
     */
    @Override
    public List<JadwalImunisasi> findAll() {
        List<JadwalImunisasi> daftarJadwal = new ArrayList<>();
        String sql =
            "SELECT * FROM jadwal_imunisasi ORDER BY tanggal_target";

        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            daftarJadwal = mapper.mapRows(rs);

        } catch (SQLException e) {
            System.err.println(
                "[ERROR] Gagal mengambil data jadwal: "
                + e.getMessage()
            );
        }
        return daftarJadwal;
    }

    /**
     * Mencari JadwalImunisasi berdasarkan ID.
     * JDBC: PreparedStatement dengan parameter
     */
    @Override
    public JadwalImunisasi findById(int id) {
        String sql =
            "SELECT * FROM jadwal_imunisasi WHERE id = ?";

        try (PreparedStatement ps =
                 conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return mapper.mapRow(rs);
            }

        } catch (SQLException e) {
            System.err.println(
                "[ERROR] Gagal mencari jadwal: "
                + e.getMessage()
            );
        }
        return null;
    }

    /**
     * Memperbarui data JadwalImunisasi yang sudah ada.
     */
    @Override
    public void update(JadwalImunisasi jadwal) {
        String sql =
            "UPDATE jadwal_imunisasi SET vaksin_id=?, "
            + "tanggal_target=?, status=? WHERE id=?";

        try (PreparedStatement ps =
                 conn.prepareStatement(sql)) {

            ps.setInt(1, jadwal.getVaksinId());
            
            if (jadwal.getTanggalTarget() != null) {
                ps.setDate(2, Date.valueOf(
                    jadwal.getTanggalTarget()
                ));
            } else {
                ps.setNull(2, Types.DATE);
            }
            
            ps.setString(3, jadwal.getStatus());
            ps.setInt(4, jadwal.getId());
            
            ps.executeUpdate();
            System.out.println(
                "[OK] Data jadwal berhasil diperbarui."
            );

        } catch (SQLException e) {
            System.err.println(
                "[ERROR] Gagal update jadwal: "
                + e.getMessage()
            );
        }
    }

    /**
     * Menghapus data JadwalImunisasi berdasarkan ID.
     */
    @Override
    public void delete(int id) {
        String sql =
            "DELETE FROM jadwal_imunisasi WHERE id=?";

        try (PreparedStatement ps =
                 conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            int affected = ps.executeUpdate();
            
            if (affected > 0) {
                System.out.println(
                    "[OK] Data jadwal berhasil dihapus."
                );
            }

        } catch (SQLException e) {
            System.err.println(
                "[ERROR] Gagal hapus jadwal: "
                + e.getMessage()
            );
        }
    }

    /**
     * Mengambil jadwal berdasarkan ID Anak.
     * JCF: mengembalikan List<JadwalImunisasi>
     */
    public List<JadwalImunisasi> findByAnakId(int anakId) {
        List<JadwalImunisasi> hasil = new ArrayList<>();
        String sql =
            "SELECT * FROM jadwal_imunisasi "
            + "WHERE anak_id = ? ORDER BY tanggal_target";

        try (PreparedStatement ps =
                 conn.prepareStatement(sql)) {

            ps.setInt(1, anakId);
            ResultSet rs = ps.executeQuery();
            hasil = mapper.mapRows(rs);

        } catch (SQLException e) {
            System.err.println(
                "[ERROR] Gagal mencari jadwal by anak: "
                + e.getMessage()
            );
        }
        return hasil;
    }

    /**
     * Update status jadwal berdasarkan ID.
     */
    public void updateStatus(int id, String status) {
        String sql =
            "UPDATE jadwal_imunisasi SET status = ? WHERE id = ?";

        try (PreparedStatement ps =
                 conn.prepareStatement(sql)) {

            ps.setString(1, status);
            ps.setInt(2, id);
            
            int affected = ps.executeUpdate();
            if (affected > 0) {
                System.out.println(
                    "[OK] Status jadwal berhasil diperbarui ke: " + status
                );
            }

        } catch (SQLException e) {
            System.err.println(
                "[ERROR] Gagal update status jadwal: "
                + e.getMessage()
            );
        }
    }
}