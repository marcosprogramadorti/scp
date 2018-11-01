package br.gov.transportes.scp.config.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("scp")
public class ScpServiceProperty {
	
	
	private String origemPermitida = "";
	
	private String urlFotoRequerente = "/usr/upload_fotos/fotos/";
	
	private String urlSuiteCorpService = "";
	
	private String urlScaService ="";
	
	private String urlScaLogout = "";
	private String urlScaApi = "";
	
	
	
	


	public String getUrlSuiteCorpService() {
		return urlSuiteCorpService;
	}


	public void setUrlSuiteCorpService(String urlSuiteCorpService) {
		this.urlSuiteCorpService = urlSuiteCorpService;
	}


	public String getUrlFotoRequerente() {
		return urlFotoRequerente;
	}
	

	public void setUrlFotoRequerente(String urlFotoRequerente) {
		this.urlFotoRequerente = urlFotoRequerente;
	}


	public String getOrigemPermitida() {
		return origemPermitida;
	}


	public void setOrigemPermitida(String origemPermitida) {
		this.origemPermitida = origemPermitida;
	}


	private final Seguranca seguranca = new Seguranca();
	
	
	public Seguranca getSecuranca() {
		return seguranca;
	}

	
	public String getUrlScaService() {
		return urlScaService;
	}


	public void setUrlScaService(String urlScaService) {
		this.urlScaService = urlScaService;
	}
	public static class Seguranca {
		
		private boolean EnableHttps;

		public boolean isEnableHttps() {
			return EnableHttps;
		}

		public void setEnableHttps(boolean enableHttps) {
			EnableHttps = enableHttps;
		}
		
		
		
	}
	public String getUrlScaLogout() {
		return urlScaLogout;
	}


	public void setUrlScaLogout(String urlScaLogout) {
		this.urlScaLogout = urlScaLogout;
	}


	public String getUrlScaApi() {
		return urlScaApi;
	}


	public void setUrlScaApi(String urlScaApi) {
		this.urlScaApi = urlScaApi;
	}
	
	

	
	
	
	
	

}
