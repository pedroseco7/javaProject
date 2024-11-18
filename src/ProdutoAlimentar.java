enum Taxas {
    REDUZIDA, INTERMEDIA, NORMAL;
}

public abstract class ProdutoAlimentar extends Produto {
    protected boolean eBiologico;
    protected Taxas taxas;

    public ProdutoAlimentar(String nome, String descricao, int quantidade, double valorUnitario, boolean eBiologico, Taxas taxas) {
        super(nome, descricao, quantidade, valorUnitario);
        this.eBiologico = eBiologico;
        this.taxas = taxas;
    }

    public boolean isEBiologico() {
        return eBiologico;
    }

    public Taxas getTaxas() {
        return taxas;
    }

    @Override
    public abstract double calcularIVA(local localizacao);
}
