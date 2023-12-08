package excecoes;

public class TituloInvalidoException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TituloInvalidoException(String mensagem) {
        super(mensagem);
    }
}