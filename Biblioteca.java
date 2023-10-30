import java.util.ArrayList;

public class Biblioteca {
    String nome;
    ArrayList<Livro> listaLivros;
    ArrayList<Midias> listaMidias;

    public static ArrayList<Biblioteca> bibliotecas = new ArrayList<>();


    public Biblioteca(String nome) {
        this.nome = nome;
        this.listaLivros = new ArrayList<>();
        this.listaMidias = new ArrayList<>();

        bibliotecas.add(this);
    }

    public String toString() {
        return "Nome: " + this.nome;
    }

    // adiciona os livros na lista de livros da classe Livro
    public void adicionarLivro(Livro livro) {
        this.listaLivros.add(livro);
    }

    public void adicionarMidias (Midias midias) {
        this.listaMidias.add(midias);
    }

    public void listaMidias(Midias midias) {
        this.listaMidias.add(midias);
    }

    public void listaMidias() {
        for (int i = 0; i < this.listaMidias.size(); i++) {
            System.out.println(i + " - " + this.listaMidias.get(i).toString());
        }
    }

    // mostra a lista de livros adicionados
    public void listaLivros() {
        for (int i = 0; i < this.listaLivros.size(); i++) {
            System.out.println(i + " - " + this.listaLivros.get(i).toString());
        }
    }

    // mostra a lista de bibliotecas que podem ser criadas pelo usuário
    public static void listarBibliotecas() {
        // for que percorre a lista de bibliotecas criada
        for (int i = 0; i < bibliotecas.size(); i++) {
            Biblioteca biblioteca = bibliotecas.get(i); // get puxa a lista de bibliotecas e depois mostra na tela pro
                                                        // usuário com o sysout
            System.out.println(i + " - " + biblioteca.toString());
            biblioteca.listaLivros(); // mostra a lista de livros da bilbioteca x
        }
    }
}
