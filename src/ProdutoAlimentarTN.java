public class ProdutoAlimentarTN extends ProdutoAlimentar {

    public ProdutoAlimentarTN(String nome, String descricao, int quantidade, double valorUnitario, boolean eBiologico) {
        super(nome, descricao, quantidade, valorUnitario, eBiologico, Taxas.NORMAL);
    }

    @Override
    public double calcularIVA(local localizacao) {
        double iva;

        switch (localizacao) {
            case CONTINENTE:
                iva = 23;
                break;
            case MADEIRA:
                iva = 22;
                break;
            case ACORES:
                iva = 16;
                break;
            default:
                throw new IllegalArgumentException("Localização inválida");
        }

        if (eBiologico) {
            iva *= 0.9; // Redução de 10% para produtos biológicos
        }

        return iva;
    }
}
