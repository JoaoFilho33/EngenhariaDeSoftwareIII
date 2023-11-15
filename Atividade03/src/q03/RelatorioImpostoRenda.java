package q03;

public class RelatorioImpostoRenda {
    public void gerarRelatorio(ImpostoDeRenda contribuinte, double impostoDevido) {
        System.out.println("CPF: " + contribuinte.getCpfContribuinte());
        System.out.println("Rendimentos: " + contribuinte.getRendimentos());
        System.out.println("Despesas: " + contribuinte.getDespesas());
        System.out.println("Imposto Devido: " + impostoDevido);
    }
}
