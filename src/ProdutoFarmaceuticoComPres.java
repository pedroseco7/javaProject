public class ProdutoFarmaceuticoComPres extends ProdutoFarmaceutico {
    private String nomeMedico;

    public ProdutoFarmaceuticoComPres(String nome, String descricao, int quantidade,double valorUnitario, String nomeMedico) {
        super(nome, descricao, quantidade, valorUnitario, true);
        this.nomeMedico = nomeMedico;
    }

    public String getNomeMedico() {
        return nomeMedico;
    }

    @Override
    public double calcularIVA(local localizacao) {
        double iva;

    // Switch tradicional para calcular o IVA base
        switch (localizacao) {
            case CONTINENTE:
                iva = 6;
                break;
            case MADEIRA:
                iva = 5;
                break;
            case ACORES:
                iva = 4;
                break;
            default:
                throw new IllegalArgumentException("Localização inválida");
        }
        return iva;
    }
}
