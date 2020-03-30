package br.com.gft.socialbooks.services.exceptions;

public class LivroNaoEncontradoException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4111086230203314483L;

	public LivroNaoEncontradoException (String mensagem)
	{
		super(mensagem);
	}
	
	public LivroNaoEncontradoException(String mensagem, Throwable causa)
	{
		super(mensagem, causa);
	}
}
