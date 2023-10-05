package q04;

import java.util.List;

public interface ValidacaoImpostoDeRenda {
    boolean validarCPF(String cpf);
    boolean validarRendimentosDespesas(List<Double> rendimentos, List<Double> despesas);
}
