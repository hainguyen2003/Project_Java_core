package vn.edu.vnua.fita.hello;

import java.util.Scanner;

public class Lecturer  extends Human{
	private String password;

	public Lecturer() {
		// TODO Auto-generated constructor stub
	}
	
	public Lecturer(String code, String password) {
		this.code = code;
		this.password = password;
	}
	
	public Lecturer(String code, String fullname, String address) {
		super(code,fullname,address);
	}
	
	/*
	@Override
	public String toString() {
		return code + "_" + fullname +"_" + address;
	}
	*/
	
	@Override
	public void enterInfo(Scanner sc) {
		super.enterInfo(sc);// goi phuong thuc lop cha
		System.out.println("hap mat khau:");
		password = sc.nextLine();
	}
	

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
