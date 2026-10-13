public final class Recompensa {
    private final String descricao;
    private final int energia;
    private final Item item;

    public Recompensa(String descricao, int energia, Item item) {
        if (descricao == null || descricao.isBlank()) {
            throw new IllegalArgumentException("A descrição da recompensa não pode ser vazia.");
        }
        if (energia < 0) {
            throw new IllegalArgumentException("A energia da recompensa não pode ser negativa.");
        }
        this.descricao = descricao;
        this.energia = energia;
        this.item = item;
    }

    public Recompensa(String descricao, int energia) {
        this(descricao, energia, null);
    }

    public String getDescricao() {
        return descricao;
    }

    public int getEnergia() {
        return energia;
    }

    public Item getItem() {
        return item;
    }
}