import java.util.ArrayList;
import java.util.List;

enum Certificacao {
    ISO22000, FSSC22000, HACCP, GMP;
}

public class ProdutoAlimentarTR extends ProdutoAlimentar {
    private ArrayList<Certificacao> certificacoes;

    public ProdutoAlimentarTR(String nome, String descricao, int quantidade, double valorUnitario, boolean eBiologico, ArrayList<Certificacao> certificacoes) {
        super(nome, descricao, quantidade, valorUnitario, eBiologico, Taxas.REDUZIDA);
        this.certificacoes = certificacoes;
    }

    public List<Certificacao> getCertificacoes() {
        return certificacoes;
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

    // Verifica se há exatamente 4 certificações e se são diferentes
    if (certificacoes != null && certificacoes.size() == 4 && 
        certificacoes.stream().distinct().count() == 4) {
        iva -= 1; // Redução de 1% se houver 4 certificações diferentes
    }

    // Aplica desconto adicional para produtos biológicos
    if (eBiologico) {
        iva *= 0.9; // Redução de 10%
    }

    return iva;
}

}
