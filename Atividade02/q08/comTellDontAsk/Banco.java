package Atividade02.q08.comTellDontAsk;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private List<ContaBancaria> contas = new ArrayList<>();

    public void adicionarConta(ContaBancaria conta) {
        contas.add(conta);
    }

    public void realizarDeposito(int numeroConta, double valor) {
        for (ContaBancaria conta : contas) {
            if (conta.getNumero() == numeroConta) {
                conta.depositar(valor);
            }
        }
    }

    public void realizarSaque(int numeroConta, double valor) {
        for (ContaBancaria conta : contas) {
            if (conta.getNumero() == numeroConta) {
                conta.sacar(valor);
            }
        }
    }
}
