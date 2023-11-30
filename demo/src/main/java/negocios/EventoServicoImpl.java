package negocios;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.entidades.Evento;

public class EventoServicoImpl implements EventoServico {
	private List<Evento> eventos = new ArrayList<>();

    @Override
    public List<Evento> obterTodosEventos() {
        return eventos;
    }

    @Override
    public Evento obterEventoPorId(Long idEvento) {
        // Implemente a lógica para obter um evento pelo ID
        return null;
    }

    @Override
    public void adicionarEvento(Evento evento) {
        // Implemente a lógica para adicionar um novo evento
    }

    @Override
    public void atualizarEvento(Evento evento) {
        // Implemente a lógica para atualizar um evento existente
    }

    @Override
    public void excluirEvento(Long idEvento) {
        // Implemente a lógica para excluir um evento pelo ID
    }
}
