package excecoes;

public class DatasInvalidasException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DatasInvalidasException(String mensagem) {
		super(mensagem);
	}
}