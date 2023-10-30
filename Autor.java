import java.util.ArrayList;

public class Autor extends Pessoa {
    private String nacionalidade;
    private static ArrayList<Autor> listaAutors = new ArrayList<Autor>();

    public Autor(String nomeAutor, String nacionalidade) {
        super(nomeAutor);
        this.nacionalidade=nacionalidade;

        listaAutors.add(this);
    }
    // polimorfismo estático, com sobrecarga
    public Autor(String nome) {
        this(nome, "Brasil");
    }

    public void setNacionalidade (String nacionalidade){
        this.nacionalidade = nacionalidade;
    }

    public String getNacionalidade (){
        return this.nacionalidade;
    }

    public static ArrayList<Autor> getlistaAutors() {
        return listaAutors;
    }

    public String toString() {
        return super.toString() + ". Nacionalidade: " + this.nacionalidade;
    }

    public static void listaAutors() {
        for (int i = 0; i < listaAutors.size(); i++) {
            System.out.println(i + " - " + listaAutors.get(i).toString());
        }
    }
}