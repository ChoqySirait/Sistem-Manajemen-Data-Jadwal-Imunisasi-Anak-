package Imuniku.src.dao;

import java.util.List;

/**
 * Abstract class BaseDAO mendefinisikan kontrak
 * yang harus diimplementasikan oleh semua DAO.
 *
 * Konsep PBO: Inheritance, Abstraction
 * Pola desain: DAO (Data Access Object)
 *
 * @param <T> Tipe entity yang dikelola
 */
public abstract class BaseDAO<T> {

    /**
     * Menyimpan entity baru ke database
     */
    public abstract void save(T entity);

    /**
     * Mengambil semua entity dari database
     */
    public abstract List<T> findAll();

    /**
     * Mengambil entity berdasarkan ID
     */
    public abstract T findById(int id);

    /**
     * Memperbarui entity yang sudah ada
     */
    public abstract void update(T entity);

    /**
     * Menghapus entity berdasarkan ID
     */
    public abstract void delete(int id);
}
