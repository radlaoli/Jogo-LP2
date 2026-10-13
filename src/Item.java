public abstract class Item {
    private final String nome;
    private final Raridade raridade;
    private final int valor;

    public enum Raridade {
        COMUM, RARO, SUPER_RARO, EPICO, LENDARIO
    }

    protected Item(String nome, Raridade raridade, int valor) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O nome do item não pode ser vazio.");
        }
        if (raridade == null || valor < 0) {
            throw new IllegalArgumentException("Dados do item inválidos.");
        }
        this.nome = nome;
        this.raridade = raridade;
        this.valor = valor;
    }

    public String getNome() { return nome; }
    public Raridade getRaridade() { return raridade; }
    public int getValor() { return valor; }

    public abstract String descricaoDetalhada();
}