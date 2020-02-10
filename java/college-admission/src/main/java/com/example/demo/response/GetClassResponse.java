package com.example.demo.response;

public class GetClassResponse {
	private Integer id;
	private Integer dept_allocate_id;
	private String class_name;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getDept_allocate_id() {
		return dept_allocate_id;
	}
	public void setDept_allocate_id(Integer dept_allocate_id) {
		this.dept_allocate_id = dept_allocate_id;
	}
	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	
}
