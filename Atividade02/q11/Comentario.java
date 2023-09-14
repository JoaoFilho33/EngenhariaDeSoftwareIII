package Atividade02.q11;

public class Comentario implements Conteudo{
    private String conteudo;

    public Comentario(String conteudo) {
        this.conteudo = conteudo;
    }

    @Override
    public String getConteudo() {
        return conteudo;
    }
}
