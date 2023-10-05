package q01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class RepositorioDePosts {
    private List<Post> posts;
    private String filePath;

    public RepositorioDePosts(String filePath) {
        this.posts = new ArrayList<>();
        this.filePath = filePath;
    }

    public void adicionarPost(Post post) {
        posts.add(post);
        salvarPosts();
    }

    private void salvarPosts() {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (Post post : posts) {
                writer.write("ID: " + post.getId() + "\n");
                writer.write("Texto: " + post.getTexto() + "\n");
                writer.write("Autor: " + post.getAutor().getNome() + "\n");
                writer.write("Data: " + post.getData() + "\n");
                writer.write("Quantidade de Likes: " + post.getQuantidadeDeLikes() + "\n\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Post> lerPosts() {
        List<Post> postsLidos = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                int id = Integer.parseInt(line.split(": ")[1]);
                String texto = reader.readLine().split(": ")[1];
                String autorNome = reader.readLine().split(": ")[1];
                String dataString = reader.readLine().split(": ")[1];
                Date data = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH).parse(dataString);

                int quantidadeDeLikes = Integer.parseInt(reader.readLine().split(": ")[1]);

                Autor autor = new Autor(1, autorNome, "autor@email.com");

                Post post = new Post(id, texto, autor, data);
                post.setQuantidadeDeLikes(quantidadeDeLikes);
                postsLidos.add(post);

                reader.readLine();
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return postsLidos;
    }

}
