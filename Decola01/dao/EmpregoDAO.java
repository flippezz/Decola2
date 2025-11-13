package Decola01.dao;

import Decola02.entity.Emprego;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpregoDAO {
    public List<Emprego> listarPorProfissao(int profissaoId) {
        List<Emprego> lista = new ArrayList<>();
        String sql = "SELECT * FROM empregos WHERE profissao_id = ?";
        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, profissaoId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Emprego e = new Emprego(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getInt("profissao_id")
                );
                lista.add(e);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar empregos: " + e.getMessage());
        }
        return lista;
    }
}
