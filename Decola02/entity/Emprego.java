package Decola02.entity;

public class Emprego {
    private int id;
    private String nome;
    private int profissaoId;

    public Emprego() {}

    public Emprego(String nome, int profissaoId) {
        this.nome = nome;
        this.profissaoId = profissaoId;
    }

    public Emprego(int id, String nome, int profissaoId) {
        this.id = id;
        this.nome = nome;
        this.profissaoId = profissaoId;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public int getProfissaoId() { return profissaoId; }
    public void setProfissaoId(int profissaoId) { this.profissaoId = profissaoId; }
}
