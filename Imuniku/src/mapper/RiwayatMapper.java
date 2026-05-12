package Imuniku.src.mapper;

import Imuniku.src.model.RiwayatImunisasi;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * RiwayatMapper - ORM Data Mapper untuk RiwayatImunisasi
 * Placeholder implementation untuk struktur project
 */
public class RiwayatMapper extends BaseMapper<RiwayatImunisasi> {

    @Override
    public RiwayatImunisasi mapRow(ResultSet rs) throws SQLException {
        // TODO: Implementasi mapping ResultSet ke RiwayatImunisasi
        System.out.println("[TODO] RiwayatMapper.mapRow() belum diimplementasi");
        return null;
    }

    @Override
    public List<RiwayatImunisasi> mapRows(ResultSet rs) throws SQLException {
        // TODO: Implementasi mapping ResultSet ke List<RiwayatImunisasi>
        System.out.println("[TODO] RiwayatMapper.mapRows() belum diimplementasi");
        return new ArrayList<>();
    }
}
