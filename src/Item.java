public final class Item {
    private final String nome;
    private final TipoItem tipo;
    private final Raridade raridade;
    private final int valor;

    public enum Raridade {
        COMUM, RARO,SUPER_RARO, EPICO, LENDARIO
    }

    public enum TipoItem {
        CONSUMIVEL, EQUIPAMENTO, ARMA
    }

    public Item(String nome, TipoItem tipo, Raridade raridade, int valor) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O nome do item não pode ser vazio.");
        }
        if (tipo == null || raridade == null || valor < 0) {
            throw new IllegalArgumentException("Dados do item inválidos.");
        }
        this.nome = nome;
        this.tipo = tipo;
        this.raridade = raridade;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public TipoItem getTipo() {
        return tipo;
    }

    public Raridade getRaridade() {
        return raridade;
    }

    public int getValor() {
        return valor;
    }

}