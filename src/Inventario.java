import java.util.ArrayList;
import java.util.List;

public final class Inventario {
    private final int capacidade;
    private final List<Item> itens; // Agregação: 1 -> *

    public Inventario(int capacidade) {
        if (capacidade <= 0) {
            throw new IllegalArgumentException("A capacidade do inventário deve ser maior que zero.");
        }
        this.capacidade = capacidade;
        this.itens = new ArrayList<>();
    }

    public boolean adicionar(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Item não pode ser nulo.");
        }
        if (this.itens.size() >= this.capacidade) {
            return false;
        }
        return this.itens.add(item);
    }

    public boolean remover(Item item) {
        return this.itens.remove(item);
    }

    public List<Item> getItens() {
        return List.copyOf(this.itens);
    }

    public int getCapacidade() {
        return capacidade;
    }

    public int getQuantidadeAtual() {
        return itens.size();
    }
}