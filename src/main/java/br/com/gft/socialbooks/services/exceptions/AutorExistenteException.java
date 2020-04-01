package br.com.gft.socialbooks.services.exceptions;

public class AutorExistenteException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4111086230203314483L;

	public AutorExistenteException(String mensagem) 
	{
		
		super(mensagem);
	}
	
	public AutorExistenteException(String mensagem, Throwable causa)
	{
		super(mensagem, causa);
	}
}

