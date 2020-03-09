package cn.edu.cqu.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class College {
	@Id
	@Column(length=10,nullable=false)
	private String id;
	
	@Column(length=50,nullable=false)
	private String name;
	
	@OneToMany(mappedBy="college",cascade=CascadeType.REMOVE)
	public Set<Student> students;
	
	public College() {
	}
	public College(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	
}
