package Atividade02.q12;

public class Relacionamento {
    private Usuario2 iniciador;
    private Usuario2 receptor;
    private TipoRelacionamento tipo;

    public Relacionamento(Usuario2 iniciador, Usuario2 receptor, TipoRelacionamento tipo) {
        this.iniciador = iniciador;
        this.receptor = receptor;
        this.tipo = tipo;
    }

    public Usuario2 getIniciador() {
        return iniciador;
    }

    public Usuario2 getReceptor() {
        return receptor;
    }

    public TipoRelacionamento getTipo() {
        return tipo;
    }
}
