package Atividade02.q08.comTellDontAsk;

public class ContaBancaria {
    private int numero;
    private double saldo;

    public ContaBancaria(int numero, double saldoInicial) {
        this.numero = numero;
        this.saldo = saldoInicial;
    }

    public int getNumero() {
        return numero;
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    public void sacar(double valor) {
        saldo -= valor;
    }

    public double consultarSaldo() {
        return saldo;
    }
}
