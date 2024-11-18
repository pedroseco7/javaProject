public abstract class ProdutoFarmaceutico extends Produto {
    protected boolean prescricao;

    public ProdutoFarmaceutico(String nome, String descricao, int quantidade, double valorUnitario, boolean prescricao) {
        super(nome, descricao, quantidade, valorUnitario);
        this.prescricao = prescricao;
    }

    public boolean isPrescricao() {
        return prescricao;
    }

    @Override
    public abstract double calcularIVA(local localizacao);
}
