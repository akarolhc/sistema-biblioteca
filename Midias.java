import java.util.ArrayList;

public class Midias extends ItemBibliografico {

    int ano;

    private boolean disponibilidade;

    private String titulo;

    public static ArrayList<Midias> midias = new ArrayList<>();


    public Midias(String titulo, int ano, boolean disponibilidade) {
        super(titulo, disponibilidade);
        this.ano = ano;
        
        midias.add(this);

    }
    public static void listaMidias() {
        for (int i = 0; i < midias.size(); i++) {
            System.out.println(i + " - " + midias.get(i).toString());
        }
    }

    //polimorfismo, sobrecarga
    public Midias(String titulo, int ano) {
        this(titulo, ano, true);
    }
    //criar a mesma estrutura do livro e aplicar no main
    public void emprestimo(Usuario usuario) throws Exception {
        if (!this.disponibilidade) {
            throw new Exception("Esta mídia não está disponível para empréstimo no momento!");
        }
        this.disponibilidade = false;
        
        System.out.println("Mídia " + this.titulo + " emprestada para " + usuario.getUsuario());
    }

    public void devolucao() throws Exception {
        if (this.disponibilidade) {
            throw new Exception("Mídia disponível para empréstimo!");
        }
        this.disponibilidade = true;
    }
    //puxa a lista de midias e retorna ela para o usuario
    public static ArrayList<Midias> getlistaMidias() {
        return midias;
    }
}
