package q05;

import java.util.List;

class ContaCorrente {
    private String numero;
    private double saldo;
    private List<Transacao> transacoes;

    public ContaCorrente(String numero, double saldo, List<Transacao> transacoes) {
        this.numero = numero;
        this.saldo = saldo;
        this.transacoes = transacoes;
    }

    public String getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
    }
}