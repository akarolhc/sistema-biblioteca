import java.util.ArrayList;

public class Livro extends ItemBibliografico {
    public Autor autor;

    public static ArrayList<Livro> livros = new ArrayList<>();

    public Livro(Autor autor, String titulo) {
        super(titulo, true);
        this.autor = autor;

        livros.add(this);
    }

    public static void listaLivros() {
        for (int i = 0; i < livros.size(); i++) {
            System.out.println(i + " - " + livros.get(i).toString());
        }
    }

    public void emprestimo(Usuario usuario) throws Exception {
        if (!this.disponibilidade) {
            throw new Exception("Livro não está disponível para empréstimo no momento!");
        }
        this.disponibilidade = false;
        
        System.out.println("Livro " + this.titulo + " emprestado para " + usuario.getUsuario());
    }

    public void devolucao() throws Exception {
        if (this.disponibilidade) {
            throw new Exception("Livro disponível para empréstimo!");
        }
        this.disponibilidade = true;
    }

}