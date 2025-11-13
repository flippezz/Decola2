package Decola02.entity;

public class TesteVocacional {
    private int id;
    private int usuarioId;
    private String resultado;

    public TesteVocacional() {}

    public TesteVocacional(int usuarioId, String resultado) {
        this.usuarioId = usuarioId;
        this.resultado = resultado;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getUsuarioId() { return usuarioId; }
    public void setUsuarioId(int usuarioId) { this.usuarioId = usuarioId; }

    public String getResultado() { return resultado; }
    public void setResultado(String resultado) { this.resultado = resultado; }
}
