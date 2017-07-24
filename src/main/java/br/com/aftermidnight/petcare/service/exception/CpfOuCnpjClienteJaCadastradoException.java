package br.com.aftermidnight.petcare.service.exception;


public class CpfOuCnpjClienteJaCadastradoException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public CpfOuCnpjClienteJaCadastradoException(String msg) {
		super(msg);
	}	

}
