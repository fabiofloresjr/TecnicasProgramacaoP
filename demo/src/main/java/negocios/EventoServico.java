package negocios;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entidades.Evento;
//Responsabilidade Única: A interface EventoServico declara operações relacionadas a eventos,
//enquanto a implementação EventoServicoImpl as implementa. Ambas estão focadas em uma única responsabilidade
@Service
public interface EventoServico {
	List<Evento> obterTodosEventos();

	Evento obterEventoPorId(int idEvento);

	void salvarEvento(Evento evento) throws Exception;

	void atualizarEvento(Evento evento) throws Exception;

	void excluirEvento(int idEvento) throws Exception;
}