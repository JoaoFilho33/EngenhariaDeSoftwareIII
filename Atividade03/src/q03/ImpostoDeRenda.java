package q03;

import java.util.List;

public class ImpostoDeRenda {
    private String cpfContribuinte;
    private List<Double> rendimentos;
    private List<Double> despesas;

    public ImpostoDeRenda(String cpfContribuinte, List<Double> rendimentos, List<Double> despesas) {
        this.cpfContribuinte = cpfContribuinte;
        this.rendimentos = rendimentos;
        this.despesas = despesas;
    }

    public String getCpfContribuinte() {
        return cpfContribuinte;
    }

    public List<Double> getRendimentos() {
        return rendimentos;
    }

    public List<Double> getDespesas() {
        return despesas;
    }

    public void processar() {
        CalculadoraImpostoDeRenda calculadora = new CalculadoraImpostoDeRenda();
        double impostoDevido = calculadora.calcularImposto(rendimentos, despesas);
        RelatorioImpostoRenda relatorio = new RelatorioImpostoRenda();
        relatorio.gerarRelatorio(this, impostoDevido);
    }

    public static void main(String[] args) {
        List<Double> rendimentos = List.of(60000.0, 12000.0);
        List<Double> despesas = List.of(25000.0, 7000.0);

        ImpostoDeRenda impostoDeRenda = new ImpostoDeRenda("123456789", rendimentos, despesas);
        impostoDeRenda.processar();
    }
}
