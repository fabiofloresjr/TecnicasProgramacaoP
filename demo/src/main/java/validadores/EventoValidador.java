package validadores;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.example.demo.entidades.Evento;

import excecoes.DatasInvalidasException;
import excecoes.TituloInvalidoException;

@Component
public class EventoValidador {
    public boolean validarEvento(Evento evento) throws TituloInvalidoException, DatasInvalidasException {
    	return validarTitulo(evento.getTitulo()) && validarDatas(evento.getDataInicio(), evento.getDataFinal());
    }

    private static boolean validarTitulo(String titulo) {
        return titulo != null && !titulo.trim().isEmpty();
    }

    private static boolean validarDatas(LocalDateTime dataInicio, LocalDateTime dataFinal) {
        return dataInicio != null && dataFinal != null && !dataInicio.isAfter(dataFinal);
    }
}