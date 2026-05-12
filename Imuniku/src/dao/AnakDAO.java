package Imuniku.src.dao;

import Imuniku.src.model.Anak;
import java.util.List;

/**
 * AnakDAO - Data Access Object untuk Anak
 * Placeholder implementation untuk struktur project
 */
public class AnakDAO extends BaseDAO<Anak> {

    @Override
    public void save(Anak anak) {
        // TODO: Implementasi save Anak ke database
        System.out.println("[TODO] AnakDAO.save() belum diimplementasi");
    }

    @Override
    public List<Anak> findAll() {
        // TODO: Implementasi findAll Anak
        System.out.println("[TODO] AnakDAO.findAll() belum diimplementasi");
        return List.of();
    }

    @Override
    public Anak findById(int id) {
        // TODO: Implementasi findById Anak
        System.out.println("[TODO] AnakDAO.findById() belum diimplementasi");
        return null;
    }

    @Override
    public void update(Anak anak) {
        // TODO: Implementasi update Anak
        System.out.println("[TODO] AnakDAO.update() belum diimplementasi");
    }

    @Override
    public void delete(int id) {
        // TODO: Implementasi delete Anak
        System.out.println("[TODO] AnakDAO.delete() belum diimplementasi");
    }

    /**
     * Mengambil anak berdasarkan ID Orang Tua
     */
    public List<Anak> findByOrangTuaId(int ibuId) {
        // TODO: Implementasi findByOrangTuaId
        System.out.println("[TODO] AnakDAO.findByOrangTuaId() belum diimplementasi");
        return List.of();
    }
}
