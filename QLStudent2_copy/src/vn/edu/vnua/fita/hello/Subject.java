package vn.edu.vnua.fita.hello;

import java.util.HashMap;
import java.util.Scanner;

public class Subject {
	private String subjectCode;
	private String subjectName;
	private int credit;
	private float attendanceMark;// điểm cc
	private float midExamMark;//điểm giữa kì
	private float finalExamMark;// điểm thi
	
	
	
	
	public Subject () {
		
	}
	public Subject (String subjectCode,String subjectName, int credit) {
		this.subjectCode = subjectCode;
		this.subjectName  = subjectName;
		this.credit = credit;
		
	}
	
// tính thang điểm 
	
	public float calSubjectMark() {
		float subjectMark = (attendanceMark*0.1f + midExamMark*0.4f + finalExamMark*0.5f);
		return subjectMark;
		
	}
	
// tinhs thang diem 4
	public float calConversionMark() {
		float subjectMark = calSubjectMark();
		float conversionMark = -1;
		if(subjectMark <= 3.9) {
			conversionMark = 0;
			}
		else if(subjectMark <= 4.9) {
				conversionMark = 1;
		}
		else if(subjectMark <= 6) {
			conversionMark = 2;
	}
		else if(subjectMark <= 8) {
			conversionMark = 3;
	}
		else if(subjectMark <= 10) {
				conversionMark = 4;
			
		}
		return conversionMark;
		
	}
	
	public String calGrade() {
		float subjectMark = calSubjectMark();
		String grade =  null;
		if(subjectMark <0)
		{
			grade = "error";
		}
		else if(subjectMark <3.9)
		{
			grade = "f";
		}
		else if(subjectMark <4.9)
		{
			grade = "d";
		}
		else if(subjectMark <5.4)
		{
			grade = "D+";
		}
		else if(subjectMark <6.4)
		{
			grade = "C";
		}
		else if(subjectMark <6.9)
		{
			grade = "c+";
		}
		else if(subjectMark <7.5)
		{
			grade = "B";
		}
		else if(subjectMark <7.9)
		{
			grade = "b+";
		}
		else if(subjectMark <8.5)
		{
			grade = "A";
		}
		else if(subjectMark <9.9)
		{
			grade = "A+";
		}
		return grade;
		
	}
	
	// chuyen tu thanchu sang thang so
	public float calConversionMark(String grade) {
		float conversionMark = -1;
		switch (grade) {
		case "F": 
			conversionMark = 0;
			break;
		case "D": 
			conversionMark = 1;
			break;
		
		case "C": 
			conversionMark = 2;
			break;
		
		case "B": 
			conversionMark = 3;
			break;
		
		case "A+": 
			conversionMark = 4;
			break;
		
		}
		return conversionMark;
		
	}
	
	public int getCretdit() {
		return credit;
	}
	public void setAttendanceMark(float attendanceMark) {
		this.attendanceMark = attendanceMark;
	}
	public void setMidExamMark(float midExamMark) {
		this.midExamMark = midExamMark;
	}
	public void setFinalExamMark(float finalExamMark) {
		this.finalExamMark = finalExamMark;
	}
	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	
	@Override
	public String toString() {
		return subjectName +"_"+ subjectCode +"_"+ credit +"_"+ calSubjectMark() +"_"+ calConversionMark() +"_"+ calGrade();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Subject sub = new Subject("TH03111","lAP TRINH JAVA",3);
		sub.setAttendanceMark(8.5f);
		sub.setMidExamMark(7.8f);
		sub.setFinalExamMark(9);
		System.out.println(sub);
		
		Subject sub2 = new Subject();
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap ma mon hoc:");
		String subjectCode = sc.nextLine();
		System.out.println("nhap ten mon hoc:");
		String subjectName = sc.nextLine();
		System.out.println("nhap tin chi on hoc:");
		int credit =  sc.nextInt();
		sc.nextLine();//co the thay doi
		
		sub2.setSubjectCode(subjectCode);
		sub2.setSubjectCode(subjectName);
		sub2.setCredit(credit);
		System.out.println(sub2);
		
	}
	/*
HashMap<K, V>  */
}
