package q05;

class TransacaoService {

    public boolean verificarFraude(Transacao transacao) {
        if (transacao.getValor() > 1000 && transacao.getTipo() == TipoTransacao.DEBITO) {
            return true;
        } else {
            return false;
        }
    }
}