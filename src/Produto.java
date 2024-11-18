public abstract class Produto {
    //Atributtes

    private static int count = 1;
    protected int num;
    protected String nome;
    protected String descricao;
    protected int quantidade;
    protected double valorUnit; //Sem IVA

    public Produto(String nome, String descricao, int quantidade, double valorUnit) {
        this.num = count++;
        this.nome = nome;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.valorUnit = valorUnit;
    }

    public abstract double calcularIVA(local localizacao);

    public double calcularValorComIVA(local localizacao) {
        double iva = calcularIVA(localizacao);
        return (valorUnit * quantidade) * (1 + iva / 100);
    }

    // Getters e Setters
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorUnit() {
        return valorUnit;
    }

    public void setValorUnit(double valorUnit) {
        this.valorUnit = valorUnit;
    }



    @Override
    public String toString() {
        return nome + " (" + descricao + "), Quantidade: " + quantidade + 
               ", Valor Unitário: " + valorUnit + "€";
    }
}
