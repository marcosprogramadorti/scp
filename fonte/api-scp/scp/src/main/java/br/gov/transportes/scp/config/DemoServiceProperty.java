package br.gov.transportes.scp.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("scepl")
public class DemoServiceProperty {
	
	
	
	private String username = "a";
	 
	private String login = "a";
	private String home = "a";
	private String security = "a";
	private String prefix = "a";
	private String redirect    = "a"; 
	private String logout = "a";
	

	public String getLogout() {
		return logout;
	}


	public void setLogout(String logout) {
		this.logout = logout;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getHome() {
		return home;
	}


	public void setHome(String home) {
		this.home = home;
	}


	public String getSecurity() {
		return security;
	}


	public void setSecurity(String security) {
		this.security = security;
	}


	public String getPrefix() {
		return prefix;
	}


	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}


	public String getRedirect() {
		return redirect;
	}


	public void setRedirect(String redirect) {
		this.redirect = redirect;
	}


	private final Seguranca seguranca = new Seguranca();
	
	
	public Seguranca getSecuranca() {
		return seguranca;
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
	
	
	

}
