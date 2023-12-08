package apresentacao;

import javax.swing.JOptionPane;

public class InteracaoUsuarioSwing implements InteracaoUsuario {
	
	@Override
    public String obterEscolhaUsuario() {
        return JOptionPane.showInputDialog("Escolha uma opção:\n1 - Exibir Eventos\n2 - Adicionar Evento\n3 - Atualizar Evento\nq - Sair");
    }

    @Override
    public void exibirMensagem(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem);
    }

    @Override
    public void exibirErro(String mensagemErro) {
        JOptionPane.showMessageDialog(null, mensagemErro, "Erro", JOptionPane.ERROR_MESSAGE);
    }
}
