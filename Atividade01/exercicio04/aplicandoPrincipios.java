//https://github.com/karolinaq20/ProjetoJava/blob/main/Projeto/Filmes.java

public class Filmes extends Midia {
    private int duracao;

    public Filmes(String titulo, String genero, String autor, String sinopse, int ano, int duracao) {
        super(titulo, genero, autor, sinopse, ano);
        this.duracao = duracao;
    }

    public int executeOpcao(Scanner ler) {
        System.out.println("\tInformações do filme escolhido");
        System.out.println("-----------------------------------------------");
        System.out.println("\nTítulo: " + getTitulo() + "\nGenero: " + getGenero());
        System.out.println("Diretor: " + getAutor() + "\nAno: " + getAno() + "\nDuração: " + getDuracao() + "\nSinopse: " + getSinopse());

        System.out.println("\n\n\tOpções");
        int decisao;
        do {
            System.out.println("\nDigite o número de acordo com o que você quer fazer: "
                + "\n1- Marcar como concluído"
                + "\n2- Adicionar como favorito"
                + "\n3- Voltar");
            decisao = ler.nextInt();

            if (decisao == 3) {
                return decisao;
            } else if (decisao < 1 || decisao > 3) {
                System.out.println("Número digitado incorreto! Tente novamente.");
            }
        } while (true); // Loop executará até que a entrada seja válida.
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }
}
