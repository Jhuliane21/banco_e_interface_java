package Model;

public class Doenca {
    private String  CID10, descricao,nome;

    public Doenca(String CID10, String descricao, String nome) {
        this.CID10 = CID10;
        this.descricao = descricao;
        this.nome = nome;
    }

    public Doenca() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCID10() {
        return CID10;
    }

    public void setCID10(String CID10) {
        this.CID10 = CID10;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return CID10;
    }
}
