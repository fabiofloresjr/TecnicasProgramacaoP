package validadores;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.example.demo.entidades.Evento;

@Component
public class EventoValidador {
	public void validarEvento(Evento evento) throws Exception {
		if (!validarTitulo(evento.getTitulo())) {
			throw new Exception("Título invállido");
		}
		if (!validarDatas(evento.getDataInicio(), evento.getDataFinal())) {
			throw new Exception("Datas inválidas");
		}
	}

	private static boolean validarTitulo(String titulo) {
		return titulo != null && !titulo.trim().isEmpty();
	}

	private static boolean validarDatas(LocalDateTime dataInicio, LocalDateTime dataFinal) {
		return dataInicio != null && dataFinal != null && !dataInicio.isAfter(dataFinal);
	}
}
