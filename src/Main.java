public class Main {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   CENÁRIO 1   ");
        System.out.println("==================================================");

        Item espada = new Item("Espada de Ferro", Item.TipoItem.ARMA, Item.Raridade.COMUM, 40);
        Item pocao = new Item("Elixir de Vida", Item.TipoItem.CONSUMIVEL, Item.Raridade.RARO, 25);

        Recompensa recompensaCaverna = new Recompensa("Tesouro da Gruta", 30, pocao);
        Missao missao1 = new Missao("Limpar a caverna infestada", recompensaCaverna);

        Aventureiro aventureiro = new Aventureiro("Hercules", 60, 3);
        System.out.println("Aventureiro: " + aventureiro.getNome() + " | Energia inicial: " + aventureiro.getEnergia());

        aventureiro.getInventario().adicionar(espada);

        aventureiro.sofrerDano(30);
        System.out.println("Após batalha -> Energia: " + aventureiro.getEnergia());

        aventureiro.aceitarMissao(missao1);
        aventureiro.concluirMissaoAtiva();

        System.out.println("Após concluir missão -> Energia: " + aventureiro.getEnergia());

        System.out.println("==================================================");
        System.out.println("   CENÁRIO 2   ");
        System.out.println("==================================================");

        Aventureiro aventureiro2 = new Aventureiro("Turing");
        System.out.println("Energia padrão: " + aventureiro2.getEnergia());

        aventureiro2.descansar();
        System.out.println("Energia após descansar (limitada a " + Aventureiro.ENERGIA_MAXIMA + "): " + aventureiro2.getEnergia() + "\n");

        System.out.println("==================================================");
        System.out.println("   CENÁRIO 3   ");
        System.out.println("==================================================");

        try {
            System.out.println("Tentando concluir sem ter missão ativa:");
            aventureiro.concluirMissaoAtiva();
        } catch (IllegalStateException e) {
            System.out.println("ERRO: " + e.getMessage());
        }

        try {
            System.out.println("\nTentando reiniciar missão que já foi concluída:");
            missao1.iniciar();
        } catch (IllegalStateException e) {
            System.out.println("ERRO: " + e.getMessage());
        }

        try {
            System.out.println("\nTentando criar Item com valor negativo:");
            new Item("Item Inválido", Item.TipoItem.EQUIPAMENTO, Item.Raridade.COMUM, -50);
        } catch (IllegalArgumentException e) {
            System.out.println("ERRO: " + e.getMessage());
        }

        try {
            System.out.println("\nTentando adicionar item diretamente pela lista retornada:");
            aventureiro.getInventario().getItens().add(new Item("Item Hackeado", Item.TipoItem.ARMA, Item.Raridade.LENDARIO, 999));
        } catch (UnsupportedOperationException e) {
            System.out.println("ERRO: Modificação externa impedida por List.copyOf.");
        }
    }
}