package Imuniku.src.dao;

import Imuniku.src.driver.DatabaseConnection;
import Imuniku.src.mapper.AnakMapper;
import Imuniku.src.model.Anak;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * AnakDAO - Data Access Object untuk Anak
 * Menangani semua operasi database untuk entity Anak.
 *
 * Konsep PBO: Inheritance (extends BaseDAO)
 * Konsep JDBC: PreparedStatement, ResultSet
 * Konsep JCF: List
 */
public class AnakDAO extends BaseDAO<Anak> {

    private Connection conn;
    private AnakMapper mapper;

    public AnakDAO() {
        this.conn = DatabaseConnection.getConnection();
        this.mapper = new AnakMapper();
    }

    /**
     * Menyimpan data Anak baru ke database.
     * JDBC: menggunakan PreparedStatement
     * untuk keamanan dari SQL Injection.
     */
    @Override
    public void save(Anak anak) {
        String sql =
            "INSERT INTO anak "
            + "(nama, tanggal_lahir, jenis_kelamin, "
            + " orang_tua_id, tanggal_daftar) "
            + "VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement ps =
                 conn.prepareStatement(
                     sql,
                     Statement.RETURN_GENERATED_KEYS
                 )) {

            ps.setString(1, anak.getNama());
            
            if (anak.getTanggalLahir() != null) {
                ps.setDate(2, Date.valueOf(
                    anak.getTanggalLahir()
                ));
            } else {
                ps.setNull(2, Types.DATE);
            }
            
            ps.setString(3, anak.getJenisKelamin());
            ps.setInt(4, anak.getIbuId());
            ps.setDate(5, Date.valueOf(LocalDate.now()));
            
            ps.executeUpdate();

            // Ambil ID yang di-generate database
            ResultSet generatedKeys =
                ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                anak.setId(generatedKeys.getInt(1));
                System.out.println(
                    "[OK] Anak " + anak.getNama()
                    + " berhasil didaftarkan "
                    + "(ID: " + anak.getId() + ")"
                );
            }

        } catch (SQLException e) {
            System.err.println(
                "[ERROR] Gagal menyimpan data anak: "
                + e.getMessage()
            );
        }
    }

    /**
     * Mengambil semua data Anak dari database.
     * JCF: mengembalikan List<Anak>
     * ORM: menggunakan AnakMapper.mapRows()
     */
    @Override
    public List<Anak> findAll() {
        List<Anak> daftarAnak = new ArrayList<>();
        String sql =
            "SELECT * FROM anak ORDER BY nama";

        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            daftarAnak = mapper.mapRows(rs);

        } catch (SQLException e) {
            System.err.println(
                "[ERROR] Gagal mengambil data anak: "
                + e.getMessage()
            );
        }
        return daftarAnak;
    }

    /**
     * Mencari Anak berdasarkan ID.
     * JDBC: PreparedStatement dengan parameter
     */
    @Override
    public Anak findById(int id) {
        String sql =
            "SELECT * FROM anak WHERE id = ?";

        try (PreparedStatement ps =
                 conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return mapper.mapRow(rs);
            }

        } catch (SQLException e) {
            System.err.println(
                "[ERROR] Gagal mencari anak: "
                + e.getMessage()
            );
        }
        return null;
    }

    /**
     * Memperbarui data Anak yang sudah ada.
     */
    @Override
    public void update(Anak anak) {
        String sql =
            "UPDATE anak SET nama=?, tanggal_lahir=?, "
            + "jenis_kelamin=? WHERE id=?";

        try (PreparedStatement ps =
                 conn.prepareStatement(sql)) {

            ps.setString(1, anak.getNama());
            
            if (anak.getTanggalLahir() != null) {
                ps.setDate(2, Date.valueOf(
                    anak.getTanggalLahir()
                ));
            } else {
                ps.setNull(2, Types.DATE);
            }
            
            ps.setString(3, anak.getJenisKelamin());
            ps.setInt(4, anak.getId());
            
            ps.executeUpdate();
            System.out.println(
                "[OK] Data anak berhasil diperbarui."
            );

        } catch (SQLException e) {
            System.err.println(
                "[ERROR] Gagal update anak: "
                + e.getMessage()
            );
        }
    }

    /**
     * Menghapus data Anak berdasarkan ID.
     */
    @Override
    public void delete(int id) {
        String sql =
            "DELETE FROM anak WHERE id=?";

        try (PreparedStatement ps =
                 conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            int affected = ps.executeUpdate();
            
            if (affected > 0) {
                System.out.println(
                    "[OK] Data anak berhasil dihapus."
                );
            }

        } catch (SQLException e) {
            System.err.println(
                "[ERROR] Gagal hapus anak: "
                + e.getMessage()
            );
        }
    }

    /**
     * Mengambil anak berdasarkan ID Orang Tua (Ibu).
     * JCF: mengembalikan List<Anak>
     */
    public List<Anak> findByOrangTuaId(int ibuId) {
        List<Anak> hasil = new ArrayList<>();
        String sql =
            "SELECT * FROM anak "
            + "WHERE orang_tua_id = ? ORDER BY nama";

        try (PreparedStatement ps =
                 conn.prepareStatement(sql)) {

            ps.setInt(1, ibuId);
            ResultSet rs = ps.executeQuery();
            hasil = mapper.mapRows(rs);

        } catch (SQLException e) {
            System.err.println(
                "[ERROR] Gagal mencari anak by ibu: "
                + e.getMessage()
            );
        }
        return hasil;
    }
}