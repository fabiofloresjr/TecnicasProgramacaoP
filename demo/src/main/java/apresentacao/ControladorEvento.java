package apresentacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entidades.Evento;

import negocios.EventoServico;

@RestController
@RequestMapping("/api/eventos")
public class ControladorEvento {
    @Autowired
    private EventoServico eventoServico;

    @GetMapping
    public List<Evento> obterTodosEventos() {
        return eventoServico.obterTodosEventos();
    }

    @GetMapping("/{idEvento}")
    public Evento obterEventoPorId(@PathVariable Long idEvento) {
        return eventoServico.obterEventoPorId(idEvento);
    }

    @PostMapping
    public void adicionarEvento(@RequestBody Evento evento) {
        eventoServico.adicionarEvento(evento);
    }

    @PutMapping("/{idEvento}")
    public void atualizarEvento(@PathVariable Long idEvento, @RequestBody Evento evento) {
        eventoServico.atualizarEvento(evento);
    }

    @DeleteMapping("/{idEvento}")
    public void excluirEvento(@PathVariable Long idEvento) {
        eventoServico.excluirEvento(idEvento);
    }
}