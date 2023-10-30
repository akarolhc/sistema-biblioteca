public class Pessoa {
    protected String nomeAutor;

    public Pessoa(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }

    public String getNomeAutor() {
        return this.nomeAutor;
    }

    public String toString() {
        return "Nome: " + this.nomeAutor;
    }
}