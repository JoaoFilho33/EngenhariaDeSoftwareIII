package Atividade02.q11;

public class Post implements Conteudo {
    private String conteudo;

    public Post(String conteudo) {
        this.conteudo = conteudo;
    }

    @Override
    public String getConteudo() {
        return conteudo;
    }
}
