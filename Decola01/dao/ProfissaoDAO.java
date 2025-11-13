package Decola01.dao;

import Decola02.entity.Profissao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProfissaoDAO {
    public List<Profissao> listar() {
        List<Profissao> lista = new ArrayList<>();
        String sql = "SELECT * FROM profissoes";
        try (Connection con = ConnectionFactory.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Profissao p = new Profissao(
                    rs.getInt("id"),
                    rs.getString("nome")
                );
                lista.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar profissões: " + e.getMessage());
        }
        return lista;
    }
}
