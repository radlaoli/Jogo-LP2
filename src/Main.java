import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

            System.out.print("Digite o nome do seu aventureiro: ");
            String nomeAventureiro = scanner.nextLine();

            System.out.println("==================================================");
            System.out.println("   CENÁRIO 1   ");
            System.out.println("==================================================");

            Arma espada = new Arma("Espada de Ferro", Item.Raridade.COMUM, 40, 15);
            Pocao pocao = new Pocao("Elixir de Vida", Item.Raridade.RARO, 25, 30);

            Recompensa recompensaCaverna = new Recompensa("Tesouro da Gruta", 30, pocao);
            Missao missao1 = new Missao("Limpar a caverna infestada", recompensaCaverna);

            MissaoRepositorio repositorio = new MissaoRepositorio();
            repositorio.salvar(missao1);

            Aventureiro aventureiro = new Aventureiro(nomeAventureiro, 60, 3);
            System.out.println("Aventureiro: " + aventureiro.getNome() + " | Energia inicial: " + aventureiro.getEnergia());

            aventureiro.getInventario().adicionar(espada);
            System.out.println(espada.descricaoDetalhada());

            aventureiro.sofrerDano(30);
            System.out.println("Após batalha -> Energia: " + aventureiro.getEnergia());

            try {
                Missao missaoEncontrada = repositorio.buscar("Limpar a caverna infestada");
                aventureiro.aceitarMissao(missaoEncontrada);
                aventureiro.concluirMissaoAtiva();
            } catch (MissaoIndisponivelException e) {
                System.out.println("ERRO: " + e.getMessage());
            }

            System.out.println("Após concluir missão -> Energia: " + aventureiro.getEnergia());

            try {
                aventureiro.usarItem("Elixir de Vida");
            } catch (ItemNaoEncontradoException e) {
                System.out.println("ERRO: " + e.getMessage());
            }

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
            } catch (IllegalStateException | MissaoIndisponivelException e) {
                System.out.println("ERRO: " + e.getMessage());
            }

            try {
                System.out.println("\nTentando reiniciar missão que já foi concluída:");
                missao1.iniciar();
            } catch (MissaoIndisponivelException e) {
                System.out.println("ERRO: " + e.getMessage());
            }

            try {
                System.out.println("\nTentando buscar missão inexistente no repositório:");
                repositorio.buscar("Missão Fantasma");
            } catch (MissaoIndisponivelException e) {
                System.out.println("ERRO: " + e.getMessage());
            }

            try {
                System.out.println("\nTentando salvar missão com título duplicado:");
                repositorio.salvar(new Missao("Limpar a caverna infestada", new Recompensa("Outra recompensa", 10)));
            } catch (IllegalArgumentException e) {
                System.out.println("ERRO: " + e.getMessage());
            }

            try {
                System.out.println("\nTentando criar Equipamento com defesa inválida:");
                new Equipamento("Item Inválido", Item.Raridade.COMUM, 10, -5);
            } catch (IllegalArgumentException e) {
                System.out.println("ERRO: " + e.getMessage());
            }

            try {
                System.out.println("\nTentando usar item que não existe no inventário:");
                aventureiro.usarItem("Poção Inexistente");
            } catch (ItemNaoEncontradoException e) {
                System.out.println("ERRO: " + e.getMessage());
            }

            try {
                System.out.println("\nTentando adicionar item diretamente pela lista retornada:");
                aventureiro.getInventario().getItens().add(new Arma("Item Hackeado", Item.Raridade.LENDARIO, 999, 50));
            } catch (UnsupportedOperationException e) {
                System.out.println("ERRO: Modificação externa impedida por List.copyOf.");
            }

        }
    }
}