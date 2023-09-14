package Atividade02.q12;

import java.util.ArrayList;
import java.util.List;

public class Usuario2 {
    private List<Relacionamento> relacionamentos;

    public Usuario2() {
        relacionamentos = new ArrayList<>();
    }

    public void adicionarRelacionamento(Usuario2 iniciador, Usuario2 receptor, TipoRelacionamento tipo) {
        Relacionamento relacionamento = new Relacionamento(iniciador, receptor, tipo);
        relacionamentos.add(relacionamento);
    }

    public List<Usuario2> getAmigos() {
        List<Usuario2> amigos = new ArrayList<>();
        for (Relacionamento relacionamento : relacionamentos) {
            if (relacionamento.getTipo() == TipoRelacionamento.AMIGO) {
                amigos.add(relacionamento.getReceptor());
            }
        }
        return amigos;
    }
}