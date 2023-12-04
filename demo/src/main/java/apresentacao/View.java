package apresentacao;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.entidades.Evento;

import negocios.EventoServico;

@Component
public class View implements CommandLineRunner {

	@Autowired
    private EventoServico eventoServico;

    @Override
    public void run(String... args) {
        while (true) {
            String escolha = JOptionPane.showInputDialog("Escolha uma opção:\n1 - Exibir Eventos\n2 - Adicionar Evento\nq - Sair");

            switch (escolha != null ? escolha.toLowerCase() : "") {
                case "1":
                    exibirEventos();
                    break;
                case "2":
                    try {
                        adicionarEvento();
                    } catch (Exception e) {
                        exibirErro("Erro ao adicionar evento: " + e.getMessage());
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

    private void exibirEventos() {
        List<Evento> eventos = eventoServico.obterTodosEventos();
        StringBuilder eventosStr = new StringBuilder("Eventos:\n");
        for (Evento evento : eventos) {
            eventosStr.append(evento).append("\n");
        }
        exibirMensagem(eventosStr.toString());
    }

    private void adicionarEvento() throws Exception {
        String titulo = JOptionPane.showInputDialog("Digite o título do novo evento:");
        String dataInicioStr = JOptionPane.showInputDialog("Digite a data de início (formato dd/MM/yyyy):");
        String dataFinalStr = JOptionPane.showInputDialog("Digite a data final (formato dd/MM/yyyy):");

        LocalDateTime dataInicio = parseLocalDateTime(dataInicioStr);
        LocalDateTime dataFinal = parseLocalDateTime(dataFinalStr);

        Evento novoEvento = new Evento(titulo, dataInicio, dataFinal);

        eventoServico.adicionarEvento(novoEvento);
        exibirMensagem("Novo evento adicionado com sucesso!");
    }

    private LocalDateTime parseLocalDateTime(String input) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDateTime.parse(input, formatter);
    }

    private void exibirMensagem(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem);
    }

    private void exibirErro(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
    }

}