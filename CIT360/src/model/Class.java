package model;

import java.util.ArrayList;

import model.Student;

public class Class {

	String name;
	ArrayList<Student> classList;
	
	public Class(String name, ArrayList<Student> classList) {
		this.name = name;
		this.classList = new ArrayList<Student>(classList);
	}
	
	public void enroll(Student student) {
		classList.add(student);
	}
	
	public void drop(Student student) {
		classList.remove(student);
	}
	
	public String list() {
		StringBuilder description = new StringBuilder();
		
		description.append(this.name + "\n\n");
		
		for (Student s : classList) {
			description.append(s.getName() + "\n");
		}
		
		return description.toString();
	}
}
