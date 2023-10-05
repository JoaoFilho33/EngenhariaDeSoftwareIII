package q05;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Exemplo de uso das classes de serviço
        List<Transacao> transacoes = new ArrayList<>();
        transacoes.add(new Transacao(1, -300, TipoTransacao.DEBITO));
        transacoes.add(new Transacao(2, 750, TipoTransacao.DEBITO));
        transacoes.add(new Transacao(3, 1700, TipoTransacao.CREDITO));

        ContaCorrente conta = new ContaCorrente("123456", 1000, transacoes);
        ContaCorrenteService contaCorrenteService = new ContaCorrenteService();
        List<Transacao> transacoesInvalidas = contaCorrenteService.filtrarTransacoesInvalidas(conta.getTransacoes());

        System.out.println("Transações inválidas:");
        for (Transacao transacao : transacoesInvalidas) {
            System.out.println("ID: " + transacao.getId() + ", Valor: " + transacao.getValor() +
                    ", Tipo: " + transacao.getTipo());
        }

        Investimento investimento = new Investimento(1, 12000, TipoInvestimento.RENDA_FIXA);
        InvestimentoService investimentoService = new InvestimentoService();
        String statusRisco = investimentoService.avaliarRisco(investimento);
        System.out.println("Status de Risco do Investimento: " + statusRisco);

        Transacao transacao = new Transacao(4, 2000, TipoTransacao.DEBITO);
        TransacaoService transacaoService = new TransacaoService();
        boolean isFraudulenta = transacaoService.verificarFraude(transacao);
        if (isFraudulenta) {
            System.out.println("Transação fraudulenta detectada!");
        } else {
            System.out.println("Transação válida.");
        }
    }
}
