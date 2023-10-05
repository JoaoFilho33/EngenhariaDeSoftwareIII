package q04;

import java.util.List;

public class ValidacaoRendimentosDespesas implements ValidacaoImpostoDeRenda {
    @Override
    public boolean validarCPF(String cpf) {
        return cpf != null && cpf.length() == 11;
    }

    @Override
    public boolean validarRendimentosDespesas(List<Double> rendimentos, List<Double> despesas) {
        if (rendimentos.size() > 5) {
            return false;
        }
        for (Double rendimento : rendimentos) {
            if (rendimento < 0) {
                return false;
            }
        }
        for (Double despesa : despesas) {
            if (despesa < 0) {
                return false;
            }
        }
        return true;
    }
}
