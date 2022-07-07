package com.vaitheeswaran.client;

public class Student {

	private int rollNo;
    private String name;
    private String dept;
    private int age;
    
    public Student() {}
	public Student(int rollNo, String name, String dept, int age) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		this.dept = dept;
		this.age = age;
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		String str = "RollNo : "+getRollNo()+"\n";
		str += "Name : "+getName()+"\n";
		str += "Department : "+getDept()+"\n";
		str += "Age : "+getAge()+"\n";
		return str;
	}
}
