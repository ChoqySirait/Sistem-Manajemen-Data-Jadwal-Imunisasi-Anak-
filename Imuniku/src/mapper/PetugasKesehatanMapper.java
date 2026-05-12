package Imuniku.src.mapper;

import Imuniku.src.model.PetugasKesehatan;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * PetugasKesehatanMapper - ORM Data Mapper untuk PetugasKesehatan
 * Placeholder implementation untuk struktur project
 */
public class PetugasKesehatanMapper extends BaseMapper<PetugasKesehatan> {

    @Override
    public PetugasKesehatan mapRow(ResultSet rs) throws SQLException {
        // TODO: Implementasi mapping ResultSet ke PetugasKesehatan
        System.out.println("[TODO] PetugasKesehatanMapper.mapRow() belum diimplementasi");
        return null;
    }

    @Override
    public List<PetugasKesehatan> mapRows(ResultSet rs) throws SQLException {
        // TODO: Implementasi mapping ResultSet ke List<PetugasKesehatan>
        System.out.println("[TODO] PetugasKesehatanMapper.mapRows() belum diimplementasi");
        return new ArrayList<>();
    }
}
