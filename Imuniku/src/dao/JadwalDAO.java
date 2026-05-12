package Imuniku.src.dao;

import Imuniku.src.model.JadwalImunisasi;
import java.util.List;

/**
 * JadwalDAO - Data Access Object untuk JadwalImunisasi
 * Placeholder implementation untuk struktur project
 */
public class JadwalDAO extends BaseDAO<JadwalImunisasi> {

    @Override
    public void save(JadwalImunisasi jadwal) {
        // TODO: Implementasi save JadwalImunisasi ke database
        System.out.println("[TODO] JadwalDAO.save() belum diimplementasi");
    }

    @Override
    public List<JadwalImunisasi> findAll() {
        // TODO: Implementasi findAll JadwalImunisasi
        System.out.println("[TODO] JadwalDAO.findAll() belum diimplementasi");
        return List.of();
    }

    @Override
    public JadwalImunisasi findById(int id) {
        // TODO: Implementasi findById JadwalImunisasi
        System.out.println("[TODO] JadwalDAO.findById() belum diimplementasi");
        return null;
    }

    @Override
    public void update(JadwalImunisasi jadwal) {
        // TODO: Implementasi update JadwalImunisasi
        System.out.println("[TODO] JadwalDAO.update() belum diimplementasi");
    }

    @Override
    public void delete(int id) {
        // TODO: Implementasi delete JadwalImunisasi
        System.out.println("[TODO] JadwalDAO.delete() belum diimplementasi");
    }

    /**
     * Mengambil jadwal berdasarkan ID Anak
     */
    public List<JadwalImunisasi> findByAnakId(int anakId) {
        // TODO: Implementasi findByAnakId JadwalImunisasi
        System.out.println("[TODO] JadwalDAO.findByAnakId() belum diimplementasi");
        return List.of();
    }

    /**
     * Update status jadwal berdasarkan ID
     */
    public void updateStatus(int id, String status) {
        // TODO: Implementasi updateStatus JadwalImunisasi
        System.out.println("[TODO] JadwalDAO.updateStatus() belum diimplementasi");
    }
}
