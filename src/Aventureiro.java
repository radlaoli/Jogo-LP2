public final class Aventureiro {
    public static final int ENERGIA_MAXIMA = 100;

    private final String nome;
    private int energia;
    private final Inventario inventario;
    private Missao missaoAtiva;

    public Aventureiro(String nome, int energia, int capacidadeInventario) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome do aventureiro não pode ser vazio.");
        }
        if (energia < 0 || energia > ENERGIA_MAXIMA) {
            throw new IllegalArgumentException("Energia inicial deve estar entre 0 e " + ENERGIA_MAXIMA);
        }
        this.nome = nome;
        this.energia = energia;
        this.inventario = new Inventario(capacidadeInventario);
        this.missaoAtiva = null;
    }

    public Aventureiro(String nome) {
        this(nome, ENERGIA_MAXIMA, 5);
    }

    public String getNome() {
        return nome;
    }

    public int getEnergia() {
        return energia;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public Missao getMissaoAtiva() {
        return missaoAtiva;
    }

    public void sofrerDano(int dano) {
        if (dano <= 0) {
            throw new IllegalArgumentException("O dano deve ser maior que zero.");
        }
        this.energia = Math.max(0, this.energia - dano);
    }

    public void descansar() {
        this.energia = Math.min(ENERGIA_MAXIMA, this.energia + 10);
    }

    public void aceitarMissao(Missao missao) {
        if (missao == null) {
            throw new IllegalArgumentException("Missão não pode ser nula.");
        }
        if (this.missaoAtiva != null) {
            throw new IllegalStateException("O aventureiro já possui uma missão em andamento.");
        }
        missao.iniciar();
        this.missaoAtiva = missao;
        System.out.println(this.nome + " aceitou a missão: '" + missao.getTitulo() + "'");
    }

    public void concluirMissaoAtiva() {
        if (this.missaoAtiva == null) {
            throw new IllegalStateException("Nenhuma missão ativa para ser concluída.");
        }

        Recompensa recompensa = this.missaoAtiva.concluir();

        this.energia = Math.min(ENERGIA_MAXIMA, this.energia + recompensa.getEnergia());

        if (recompensa.getItem() != null) {
            boolean adicionado = this.inventario.adicionar(recompensa.getItem());
            if (!adicionado) {
                System.out.println("Inventário cheio! O item '" + recompensa.getItem().getNome() + "' não pôde ser guardado.");
            }
        }

        System.out.println(this.nome + " concluiu a missão '" + this.missaoAtiva.getTitulo() + "'!");
        System.out.println("Recompensa recebida: " + recompensa.getDescricao() + " (+" + recompensa.getEnergia() + " energia)");

        this.missaoAtiva = null;
    }
}