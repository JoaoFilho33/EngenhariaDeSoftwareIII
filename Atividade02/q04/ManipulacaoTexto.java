package Atividade02.q04;

public class ManipulacaoTexto {
    private String texto;

    public ManipulacaoTexto(String texto) {
        this.texto = texto;
    }

    public String removerEspacos() {
        return texto.replace(" ", "");
    }

    public String[] quebrarEmPalavras() {
        return texto.split(" ");
    }
}