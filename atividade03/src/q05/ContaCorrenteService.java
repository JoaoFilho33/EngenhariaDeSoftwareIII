package q05;

import java.util.ArrayList;
import java.util.List;

class ContaCorrenteService {

    public List<Transacao> filtrarTransacoesInvalidas(List<Transacao> transacoes) {
        List<Transacao> transacoesInvalidas = new ArrayList<>();
        for (Transacao transacao : transacoes) {
            if (transacao.getValor() < 0) {
                transacoesInvalidas.add(transacao);
            }
        }
        return transacoesInvalidas;
    }
}
