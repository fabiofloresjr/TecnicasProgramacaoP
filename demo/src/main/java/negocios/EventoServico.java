package negocios;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entidades.Evento;

@Service
public interface EventoServico {
	List<Evento> obterTodosEventos();

	Evento obterEventoPorId(int idEvento);

	void adicionarEvento(Evento evento);

	void atualizarEvento(Evento evento);

	void excluirEvento(int idEvento);
}