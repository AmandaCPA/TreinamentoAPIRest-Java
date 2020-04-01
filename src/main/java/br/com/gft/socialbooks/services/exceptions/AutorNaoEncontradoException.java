package br.com.gft.socialbooks.services.exceptions;

public class AutorNaoEncontradoException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4111086230203314483L;

	public AutorNaoEncontradoException (String mensagem)
	{
		super(mensagem);
	}
	
	public AutorNaoEncontradoException(String mensagem, Throwable causa)
	{
		super(mensagem, causa);
	}
}
