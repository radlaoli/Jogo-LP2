import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class MissaoRepositorio {
    private final Map<String, Missao> porTitulo = new HashMap<>();

    public void salvar(Missao missao) {
        if (missao == null) {
            throw new IllegalArgumentException("Missão não pode ser nula.");
        }
        if (porTitulo.putIfAbsent(missao.getTitulo(), missao) != null) {
            throw new IllegalArgumentException("Já existe uma missão cadastrada com o título: " + missao.getTitulo());
        }
    }

    public Missao buscar(String titulo) throws MissaoIndisponivelException {
        Missao missao = porTitulo.get(titulo);
        if (missao == null) {
            throw new MissaoIndisponivelException("Nenhuma missão encontrada com o título: " + titulo);
        }
        return missao;
    }

    public List<Missao> listar() {
        return List.copyOf(porTitulo.values());
    }
}