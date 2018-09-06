package br.gov.transportes.scp.repository.pessoasuitecorporativa.negocio.to;

public class ErroTO {
		
	private String mensagemUsuario;
	private String mensagemDesenvolvedor;
	
	
	public ErroTO() {
		super();
	}
	
	public ErroTO(String mensagemUsuario, String mensagemDesenvolvedor) {
		super();
		this.mensagemUsuario = mensagemUsuario;
		this.mensagemDesenvolvedor = mensagemDesenvolvedor;
	}
	public String getMensagemUsuario() {
		return mensagemUsuario;
	}
	public void setMensagemUsuario(String mensagemUsuario) {
		this.mensagemUsuario = mensagemUsuario;
	}
	public String getMensagemDesenvolvedor() {
		return mensagemDesenvolvedor;
	}
	public void setMensagemDesenvolvedor(String mensagemDesenvolvedor) {
		this.mensagemDesenvolvedor = mensagemDesenvolvedor;
	}

	@Override
	public String toString() {
		return "ErroTO [mensagemUsuario=" + mensagemUsuario + ", mensagemDesenvolvedor=" + mensagemDesenvolvedor + "]";
	}
	
	
	

}
