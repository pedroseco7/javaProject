enum Categoria {
    VINHO, CONGELADO, ENLATADO;
}

public class ProdutoAlimentarTI extends ProdutoAlimentar {
    private Categoria categoria;

    public ProdutoAlimentarTI(String nome, String descricao, int quantidade, double valorUnitario, boolean eBiologico, Categoria categoria) {
        super(nome, descricao, quantidade, valorUnitario, eBiologico, Taxas.INTERMEDIA);
        this.categoria = categoria;
    }

    public Categoria getCategoria() {
        return categoria;
    }


    @Override
    public double calcularIVA(local localizacao) {

        double iva;

        switch (localizacao) {
            case CONTINENTE:
                iva = 13;
                break;
            case MADEIRA:
                iva = 12;
                break;
            case ACORES:
                iva = 9;
                break;
            default:
                throw new IllegalArgumentException("Localização inválida");
        }

        if (categoria == Categoria.VINHO) {
            iva += 1; // Aumento de 1% para produtos da categoria "vinho"
        }

        if (eBiologico) {
            iva *= 0.9; // Redução de 10% para produtos biológicos
        }

        return iva;
    }
}
