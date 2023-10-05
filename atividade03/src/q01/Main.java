package q01;

import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Autor autor = new Autor(1, "Autor Nome", "autor@email.com");
        Post post = new Post(1, "Conteúdo do post", autor, new Date());

        // Instanciar RepositorioDePosts
        RepositorioDePosts repositorio = new RepositorioDePosts("./file");

        // Adicionar post ao repositório e salvar no arquivo
        repositorio.adicionarPost(post);

        // Ler posts do arquivo
        List<Post> postsLidos = repositorio.lerPosts();

        // Exibir posts lidos
        for (Post p : postsLidos) {
            System.out.println("ID: " + p.getId());
            System.out.println("Texto: " + p.getTexto());
            System.out.println("Autor: " + p.getAutor().getNome());
            System.out.println("Data: " + p.getData());
            System.out.println("Quantidade de Likes: " + p.getQuantidadeDeLikes());
            System.out.println();
        }
    }
}
