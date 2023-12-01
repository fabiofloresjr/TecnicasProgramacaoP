package negocios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entidades.Evento;

import repositorio.EventoRepositorio;

public class EventoServicoImpl implements EventoServico {

	@Autowired
	private EventoRepositorio eventoRepositorio;

	public EventoServicoImpl(EventoRepositorio eventoRepositorio) {
		this.eventoRepositorio = eventoRepositorio;
	}

	@Override
	public List<Evento> obterTodosEventos() {
		return eventoRepositorio.obterTodosEventos();
	}

	@Override
	public Evento obterEventoPorId(int idEvento) {
		return eventoRepositorio.obterEventoPorId(idEvento);
	}

	@Override
	public void adicionarEvento(Evento evento) {
		eventoRepositorio.adicionarEvento(evento);
	}

	@Override
	public void atualizarEvento(Evento evento) {
		eventoRepositorio.atualizarEvento(evento);
	}

	@Override
	public void excluirEvento(int idEvento) {
		eventoRepositorio.excluirEvento(idEvento);
	}
}
