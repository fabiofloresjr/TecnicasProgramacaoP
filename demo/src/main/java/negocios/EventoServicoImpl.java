package negocios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entidades.Evento;

import repositorio.EventoRepositorio;
import validadores.EventoValidador;

@Service
public class EventoServicoImpl implements EventoServico {

	@Autowired
	private EventoRepositorio eventoRepositorio;

	@Autowired
	private EventoValidador eventoValidador;

    @Override
    public List<Evento> obterTodosEventos() {
        return eventoRepositorio.obterTodosEventos();
    }

    @Override
    public Evento obterEventoPorId(int idEvento) {
        return eventoRepositorio.obterEventoPorId(idEvento);
    }

    @Override
    public void salvarEvento(Evento evento) throws Exception {
        eventoValidador.validarEvento(evento);
		eventoRepositorio.salvarEvento(evento);
    }

    @Override
    public void atualizarEvento(Evento evento) throws Exception {
		eventoValidador.validarEvento(evento);
		eventoRepositorio.atualizarEvento(evento);
    }

    @Override
    public void excluirEvento(int idEvento) throws Exception {
        eventoRepositorio.excluirEvento(idEvento);
    }
}
