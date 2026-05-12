package Imuniku.src.mapper;

import Imuniku.src.model.Anak;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * AnakMapper - ORM Data Mapper untuk Anak
 * Placeholder implementation untuk struktur project
 */
public class AnakMapper extends BaseMapper<Anak> {

    @Override
    public Anak mapRow(ResultSet rs) throws SQLException {
        // TODO: Implementasi mapping ResultSet ke Anak
        System.out.println("[TODO] AnakMapper.mapRow() belum diimplementasi");
        return null;
    }

    @Override
    public List<Anak> mapRows(ResultSet rs) throws SQLException {
        // TODO: Implementasi mapping ResultSet ke List<Anak>
        System.out.println("[TODO] AnakMapper.mapRows() belum diimplementasi");
        return new ArrayList<>();
    }
}
