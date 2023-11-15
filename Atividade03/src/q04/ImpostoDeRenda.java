package q04;

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

    public void processar(List<ValidacaoImpostoDeRenda> validacoes) {
        boolean dadosValidos = true;
        for (ValidacaoImpostoDeRenda validacao : validacoes) {
            if (!validacao.validarCPF(cpfContribuinte) || !validacao.validarRendimentosDespesas(rendimentos, despesas)) {
                dadosValidos = false;
                break;
            }
        }

        if (dadosValidos) {
            CalculadorImpostoDeRenda calculadora = new CalculadorImpostoDeRenda();
            double impostoDevido = calculadora.calcularImposto(rendimentos, despesas);
            RelatorioImpostoRenda relatorio = new RelatorioImpostoRenda();
            relatorio.gerarRelatorio(this, impostoDevido);
        } else {
            System.out.println("Dados inválidos.");
        }
    }

    public static void main(String[] args) {
        // Exemplo de uso
        List<Double> rendimentos = List.of(60000.0, 12000.0);
        List<Double> despesas = List.of(25000.0, 7000.0);
        String cpf = "98765432101";

        ValidacaoImpostoDeRenda validacaoPadrao = new ValidacaoRendimentosDespesas();

        ImpostoDeRenda impostoDeRenda = new ImpostoDeRenda(cpf, rendimentos, despesas);
        impostoDeRenda.processar(List.of(validacaoPadrao));
    }
}
