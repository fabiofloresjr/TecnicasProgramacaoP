package apresentacao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;

import org.springframework.stereotype.Component;

import com.example.demo.entidades.Evento;

import negocios.EventoServico;

@Component
public class AtualizacaoEventoView {

    public void atualizarEvento(EventoServico eventoServico) throws Exception {
        int idEvento = obterIdEventoParaAtualizacao();
        Evento eventoAtualizado = adicionarEventoAtualizado();

        eventoAtualizado.setId(idEvento);

        eventoServico.atualizarEvento(eventoAtualizado);
    }

    private int obterIdEventoParaAtualizacao() throws Exception {
        String idEventoStr = JOptionPane.showInputDialog("Digite o ID do evento que deseja atualizar:");
        return Integer.parseInt(idEventoStr);
    }

    private Evento adicionarEventoAtualizado() throws Exception {
        String titulo = JOptionPane.showInputDialog("Digite o novo título do evento:");
        String dataInicioStr = JOptionPane.showInputDialog("Digite a nova data de início (formato dd/MM/yyyy):");
        String dataFinalStr = JOptionPane.showInputDialog("Digite a nova data final (formato dd/MM/yyyy):");

        LocalDateTime dataInicio = parseLocalDateTime(dataInicioStr);
        LocalDateTime dataFinal = parseLocalDateTime(dataFinalStr);

        return new Evento(titulo, dataInicio, dataFinal);
    }

    private LocalDateTime parseLocalDateTime(String input) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(input, formatter).atStartOfDay();
    }
}