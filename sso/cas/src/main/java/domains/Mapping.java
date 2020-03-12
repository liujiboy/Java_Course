package domains;


public class Mapping {
	private Long id;
	private User casUser;
	private String localUser;
	private String host;
	private String app;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public User getCasUser() {
		return casUser;
	}
	public void setCasUser(User casUser) {
		this.casUser = casUser;
	}
	public String getLocalUser() {
		return localUser;
	}
	public void setLocalUser(String localUser) {
		this.localUser = localUser;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getApp() {
		return app;
	}
	public void setApp(String app) {
		this.app = app;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((app == null) ? 0 : app.hashCode());
		result = prime * result + ((casUser == null) ? 0 : casUser.hashCode());
		result = prime * result + ((host == null) ? 0 : host.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mapping other = (Mapping) obj;
		if (app == null) {
			if (other.app != null)
				return false;
		} else if (!app.equals(other.app))
			return false;
		if (casUser == null) {
			if (other.casUser != null)
				return false;
		} else if (!casUser.equals(other.casUser))
			return false;
		if (host == null) {
			if (other.host != null)
				return false;
		} else if (!host.equals(other.host))
			return false;
		return true;
	}
	
}
