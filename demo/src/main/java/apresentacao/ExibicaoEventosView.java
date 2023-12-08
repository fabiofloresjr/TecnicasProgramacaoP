package apresentacao;

import java.util.List;

import javax.swing.JOptionPane;

import org.springframework.stereotype.Component;

import com.example.demo.entidades.Evento;

@Component
public class ExibicaoEventosView {

    public void exibirEventos(List<Evento> eventos) {
        StringBuilder eventosStr = new StringBuilder("Eventos:\n");
        for (Evento evento : eventos) {
            eventosStr.append(evento).append("\n");
        }
        exibirMensagem(eventosStr.toString());
    }

    private void exibirMensagem(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem);
    }
}