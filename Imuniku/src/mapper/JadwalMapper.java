package Imuniku.src.mapper;

import Imuniku.src.model.JadwalImunisasi;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * JadwalMapper - ORM Data Mapper untuk JadwalImunisasi
 * Placeholder implementation untuk struktur project
 */
public class JadwalMapper extends BaseMapper<JadwalImunisasi> {

    @Override
    public JadwalImunisasi mapRow(ResultSet rs) throws SQLException {
        // TODO: Implementasi mapping ResultSet ke JadwalImunisasi
        System.out.println("[TODO] JadwalMapper.mapRow() belum diimplementasi");
        return null;
    }

    @Override
    public List<JadwalImunisasi> mapRows(ResultSet rs) throws SQLException {
        // TODO: Implementasi mapping ResultSet ke List<JadwalImunisasi>
        System.out.println("[TODO] JadwalMapper.mapRows() belum diimplementasi");
        return new ArrayList<>();
    }
}
