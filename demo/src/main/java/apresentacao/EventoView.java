package apresentacao;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import negocios.EventoServico;

@Component
public class EventoView implements CommandLineRunner {

	@Autowired
	private EventoServico eventoServico;

	@Autowired
	private ExibicaoEventosView exibicaoEventosView;

	@Autowired
	private AdicaoEventoView adicaoEventoView;

	@Autowired
	private AtualizacaoEventoView atualizacaoEventoView;

	@Override
	public void run(String... args) {
		while (true) {
			String escolha = JOptionPane.showInputDialog(
					"Escolha uma opção:\n1 - Exibir Eventos\n2 - Adicionar Evento\n3 - Atualizar Evento\nq - Sair");

			switch (escolha != null ? escolha.toLowerCase() : "") {
			case "1":
				exibicaoEventosView.exibirEventos(eventoServico.obterTodosEventos());
				break;
			case "2":
				try {
					eventoServico.salvarEvento(adicaoEventoView.adicionarEvento());
					exibirMensagem("Novo evento adicionado com sucesso!");
				} catch (Exception e) {
					exibirErro("Erro ao adicionar evento: " + e.getMessage());
				}
				break;
			case "3":
				try {
					atualizacaoEventoView.atualizarEvento(eventoServico);
					exibirMensagem("Evento atualizado com sucesso!");
				} catch (Exception e) {
					exibirErro("Erro ao atualizar evento: " + e.getMessage());
				}
				break;
			case "q":
				exibirMensagem("Saindo...");
				return;
			default:
				exibirErro("Opção inválida. Tente novamente.");
			}
		}
	}

	private void exibirMensagem(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem);
	}

	private void exibirErro(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
	}
}