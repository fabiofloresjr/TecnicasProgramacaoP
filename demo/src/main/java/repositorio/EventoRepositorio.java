package repositorio;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entidades.Evento;

@Repository
public class EventoRepositorio {
	private final List<Evento> eventos;
	//Evitar números mágicos
	private int proximoId = 1;
	//Uso de Injeção de Dependência
	@Autowired
	public EventoRepositorio(List<Evento> eventos) {
		this.eventos = eventos;
	}

	public List<Evento> obterTodosEventos() {
		return eventos;
	}
	//Mensagens de Erro Significativas
	public Evento obterEventoPorId(int idEvento) {
		return eventos.stream().filter(evento -> evento.getId() == idEvento).findFirst()
				.orElseThrow(() -> new NoSuchElementException("Evento não encontrado com o ID: " + idEvento));
	}

	public void salvarEvento(Evento evento) {
		evento.setId(proximoId++);
		eventos.add(evento);
	}

	public void atualizarEvento(Evento eventoAtualizado) throws Exception {
		int indice = obterIndiceEventoPorId(eventoAtualizado.getId());
		if (indice != -1) {
			eventos.set(indice, eventoAtualizado);
		}
	}

	public void excluirEvento(int idEvento) throws Exception {
		int indice = obterIndiceEventoPorId(idEvento);
		if (indice != -1) {
			eventos.remove(indice);
		}
	}

	private int obterIndiceEventoPorId(int idEvento) throws Exception {
		for (int i = 0; i < eventos.size(); i++) {
			if (eventos.get(i).getId() == idEvento) {
				return i;
			}
		}
		throw new Exception("Evento não encontrado");
	}
}
