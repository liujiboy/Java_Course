package domains;

import java.sql.Timestamp;

public class ServiceTicket {
	private String st;
	private User user;
	private Timestamp created=new Timestamp(System.currentTimeMillis());
	public String getSt() {
		return st;
	}
	public void setSt(String st) {
		this.st = st;
	}

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Timestamp getCreated() {
		return created;
	}
	public void setCreated(Timestamp created) {
		this.created = created;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((st == null) ? 0 : st.hashCode());
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
		ServiceTicket other = (ServiceTicket) obj;
		if (st == null) {
			if (other.st != null)
				return false;
		} else if (!st.equals(other.st))
			return false;
		return true;
	}
	
}
