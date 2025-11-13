package Decola01.dao;

import Decola02.entity.TesteVocacional;
import java.sql.*;

public class TesteVocacionalDAO {
    public void inserir(TesteVocacional t) {
        String sql = "INSERT INTO teste_vocacional (usuario_id, resultado) VALUES (?, ?)";
        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, t.getUsuarioId());
            ps.setString(2, t.getResultado());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao inserir teste: " + e.getMessage());
        }
    }
}
