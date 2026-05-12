package Imuniku.src.mapper;

import Imuniku.src.model.Vaksin;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * VaksinMapper - ORM Data Mapper untuk Vaksin
 * Placeholder implementation untuk struktur project
 */
public class VaksinMapper extends BaseMapper<Vaksin> {

    @Override
    public Vaksin mapRow(ResultSet rs) throws SQLException {
        // TODO: Implementasi mapping ResultSet ke Vaksin
        System.out.println("[TODO] VaksinMapper.mapRow() belum diimplementasi");
        return null;
    }

    @Override
    public List<Vaksin> mapRows(ResultSet rs) throws SQLException {
        // TODO: Implementasi mapping ResultSet ke List<Vaksin>
        System.out.println("[TODO] VaksinMapper.mapRows() belum diimplementasi");
        return new ArrayList<>();
    }
}
