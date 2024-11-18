enum CategoriaFarmaceutica {
    BELEZA, BEM_ESTAR, BEBES, ANIMAIS, OUTRO;
}

public class ProdutoFarmaceuticoSemPres extends ProdutoFarmaceutico {
    private CategoriaFarmaceutica categoria;

    public ProdutoFarmaceuticoSemPres(String nome, String descricao, int quantidade, double valorUnitario, CategoriaFarmaceutica categoria) {
        super(nome, descricao, quantidade, valorUnitario, false);
        this.categoria = categoria;
    }

    public CategoriaFarmaceutica getCategoria() {
        return categoria;
    }

    @Override
    public double calcularIVA(local localizacao) {
        double iva = 23; // Taxa padrão

        if (categoria == CategoriaFarmaceutica.ANIMAIS) {
            iva -= 1; // Redução de 1% para produtos da categoria "ANIMAIS"
        }

        return iva;
    }
}
