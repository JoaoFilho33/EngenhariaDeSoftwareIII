package Atividade02.q08.semTellDontAsk;

import java.util.ArrayList;
import java.util.List;

public class Banco {
     private List<ContaBancaria> contas = new ArrayList<>();

    public void adicionarConta(ContaBancaria conta) {
        contas.add(conta);
    }

    public double consultarSaldo(int numeroConta) {
        for (ContaBancaria conta : contas) {
            if (conta.getNumero() == numeroConta) {
                return conta.getSaldo();
            }
        }
        return 0.0;
    }
}
