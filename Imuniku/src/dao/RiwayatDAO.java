package Imuniku.src.dao;

import Imuniku.src.model.RiwayatImunisasi;
import java.util.List;

/**
 * RiwayatDAO - Data Access Object untuk RiwayatImunisasi
 * Placeholder implementation untuk struktur project
 */
public class RiwayatDAO extends BaseDAO<RiwayatImunisasi> {

    @Override
    public void save(RiwayatImunisasi riwayat) {
        // TODO: Implementasi save RiwayatImunisasi ke database
        System.out.println("[TODO] RiwayatDAO.save() belum diimplementasi");
    }

    @Override
    public List<RiwayatImunisasi> findAll() {
        // TODO: Implementasi findAll RiwayatImunisasi
        System.out.println("[TODO] RiwayatDAO.findAll() belum diimplementasi");
        return List.of();
    }

    @Override
    public RiwayatImunisasi findById(int id) {
        // TODO: Implementasi findById RiwayatImunisasi
        System.out.println("[TODO] RiwayatDAO.findById() belum diimplementasi");
        return null;
    }

    @Override
    public void update(RiwayatImunisasi riwayat) {
        // TODO: Implementasi update RiwayatImunisasi
        System.out.println("[TODO] RiwayatDAO.update() belum diimplementasi");
    }

    @Override
    public void delete(int id) {
        // TODO: Implementasi delete RiwayatImunisasi
        System.out.println("[TODO] RiwayatDAO.delete() belum diimplementasi");
    }

    /**
     * Mengambil riwayat berdasarkan ID Anak
     */
    public List<RiwayatImunisasi> findByAnakId(int anakId) {
        // TODO: Implementasi findByAnakId
        System.out.println("[TODO] RiwayatDAO.findByAnakId() belum diimplementasi");
        return List.of();
    }
}
