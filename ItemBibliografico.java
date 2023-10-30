public class ItemBibliografico {
    protected String titulo;
    public boolean disponibilidade;

    public ItemBibliografico(String titulo, boolean disponibilidade) {
        this.titulo = titulo;
        this.disponibilidade = disponibilidade;

    }

public String toString() {
        return "Título: " + this.titulo
                + ". Disponível: " + (this.disponibilidade ? "SIM" : "NÃO");
    }
}