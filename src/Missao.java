public final class Missao {

    public enum EstadoMissao {
        DISPONIVEL,
        EM_ANDAMENTO,
        CONCLUIDA
    }

    private final String titulo;
    private final Recompensa recompensa;
    private EstadoMissao estado;

    public Missao(String titulo, Recompensa recompensa) {
        if (titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException("Título da missão não pode ser vazio.");
        }
        if (recompensa == null) {
            throw new IllegalArgumentException("A missão exige uma recompensa válida.");
        }
        this.titulo = titulo;
        this.recompensa = recompensa;
        this.estado = EstadoMissao.DISPONIVEL;
    }

    public String getTitulo() {
        return titulo;
    }

    public EstadoMissao getEstado() {
        return estado;
    }

    public void iniciar() {
        if (this.estado != EstadoMissao.DISPONIVEL) {
            throw new IllegalStateException("Apenas missões com estado DISPONIVEL podem ser iniciadas.");
        }
        this.estado = EstadoMissao.EM_ANDAMENTO;
    }

    public Recompensa concluir() {
        if (this.estado != EstadoMissao.EM_ANDAMENTO) {
            throw new IllegalStateException("Apenas missões com estado EM_ANDAMENTO podem ser concluídas.");
        }
        this.estado = EstadoMissao.CONCLUIDA;
        return this.recompensa;
    }
}