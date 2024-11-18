import java.util.ArrayList;

public class Fatura {
    //Atributtes

    private static int count = 1;
    private int num;
    private Cliente cliente;
    private String data;
    private ArrayList<Produto> listaProducts;

    public Fatura(){}

    public Fatura(Cliente cliente, String data, ArrayList<Produto> listaProducts){
        this.num = count++;
        this.cliente = cliente;
        this.data = data;
        this.listaProducts = listaProducts;
    }

    /**
     * Calcula o total sem IVA iterativamente.
     * @return o total sem IVA.
     */
    public double calcularTotalSemIVA() {
        double total = 0;
        for (Produto produto : listaProducts) {
            total += produto.valorUnit * produto.quantidade;
        }
        return total;
    }

    /**
     * Calcula o total com IVA iterativamente.
     * @return o total com IVA.
     */
    public double calcularTotalComIVA() {
        double total = 0;
        for (Produto produto : listaProducts) {
            total += produto.calcularValorComIVA(cliente.getLocalizacao());
        }
        return total;
    }

    public String toString() {
        return "Fatura Nº: " + num + ", Cliente: " + cliente.getNome() + "Localização do Cliente: " + cliente.getLocalizacao() +
               ", Data Fatura: " + this.data +
               ", Total Sem IVA: " + calcularTotalSemIVA() +
               ", Total Com IVA: " + calcularTotalComIVA();
    }

}
