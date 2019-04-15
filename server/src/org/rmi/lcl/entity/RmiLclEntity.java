package org.rmi.lcl.entity;

import java.io.Serializable;

public class RmiLclEntity implements Serializable, Cloneable {

	private static final long serialVersionUID = -8930534867464834811L;
	
	private Long id;
	private String firstName;
	private String lastName;
	private Float salary;
	private Integer age;
	private Boolean sex;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Float getSalary() {
		return salary;
	}
	public void setSalary(Float salary) {
		this.salary = salary;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Boolean getSex() {
		return sex;
	}
	public void setSex(Boolean sex) {
		this.sex = sex;
	}

}
