package q05;

class InvestimentoService {

    public String avaliarRisco(Investimento investimento) {
        if (investimento.getTipo() == TipoInvestimento.RENDA_FIXA && investimento.getValor() > 10000) {
            return "Alto Risco";
        } else {
            return "Baixo Risco";
        }
    }
}
