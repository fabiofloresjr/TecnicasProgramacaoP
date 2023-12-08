package apresentacao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;

import org.springframework.stereotype.Component;

import com.example.demo.entidades.Evento;

@Component
public class AdicaoEventoView {

	public Evento adicionarEvento() throws Exception {
		String titulo = JOptionPane.showInputDialog("Digite o título do novo evento:");
		String dataInicioStr = JOptionPane.showInputDialog("Digite a data de início (formato dd/MM/yyyy):");
		String dataFinalStr = JOptionPane.showInputDialog("Digite a data final (formato dd/MM/yyyy):");

		LocalDateTime dataInicio = parseLocalDateTime(dataInicioStr);
		LocalDateTime dataFinal = parseLocalDateTime(dataFinalStr);

		return new Evento(titulo, dataInicio, dataFinal);
	}

	private LocalDateTime parseLocalDateTime(String input) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return LocalDate.parse(input, formatter).atStartOfDay();
	}
}