enum local{
    CONTINENTE, MADEIRA, ACORES;
}

public class Cliente {
    private String nome;
    private int nif;
    private local localizacao;

    public Cliente(String nome, int nif, local localizacao) {
        this.nome = nome;
        this.nif = nif;
        this.localizacao = localizacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public int getNif() {
        return nif;
    }

    public void setNif(int nif){
        this.nif = nif;
    }

    public local getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(local localizacao){
        this.localizacao = localizacao;
    }

    @Override
    public String toString() {
        return "Cliente: " + nome + ", NIF: " + nif + ", Localização: " + localizacao;
    }
}
