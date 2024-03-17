package vn.edu.vnua.fita.hello;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;


public class Student extends Human{

	private String class_;
	private List<Subject> subjetList = new ArrayList<Subject>();
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	public Student(String code) {
		this.code = code;
	}
	
	public Student(String code, String fullname) {
		super(code,fullname);
	}
	
	public Student(String code, String fullname, String class_){
		super(code,fullname);
		this.class_= class_;
	}
	
	public Student(String code, String fullname, String class_, String address) {
		this(code,fullname,class_);
		this.address =address;
	}
	
	public void addSubject(Subject sub) {
		subjetList.add(sub);
	}
	
	// ting diem trung binh hoc ky
	public float calTermAverageMark() {
		float ts = 0;//tu so
		int ms = 0;//mau so
		for (Subject sub: subjetList) {
			ts += sub.getCretdit() * sub.calConversionMark();
			ms += sub.getCretdit();
		}
		float tm = ts/ms;
		return tm;
		
	}
		// ep kieu khi tra ve dung kieu vi du : lop address thay vao lop class_theo kieu tra ve ; dong kieu ep nay de theo lop human
		/*@Override
		public String toString() {
			return code + "_" + fullname +"_" + class_;
		}
	*/
		@Override
		public boolean equals(Object obj) {
			// hai sv la tuong duong nhau ve hoc luc neu tri tuyet doi hieu so diem TBHK<0.3
			Student anotherStd = (Student)obj;
			float d = Math.abs(this.calTermAverageMark() - anotherStd.calTermAverageMark());
			return d <0.3;
		}
		
		public String getClass_() {
			return class_;
		}
		public void setClass_(String class_) {
			this.class_ = class_;
		}
		
		public static void main(String[] args) {
			Student std = new Student("6666089", "Nguyen Quan Van","k66cnpm");
			
			Subject sub1 = new Subject("TH0001","LT Java",3);
			sub1.setAttendanceMark(8.5f);
			sub1.setMidExamMark(6.8f);
			sub1.setFinalExamMark(7.5f);
			
			Subject sub2 = new Subject("TH0101","CTDL&GT",3);
			sub2.setAttendanceMark(8.2f);
			sub2.setMidExamMark(6.6f);
			sub2.setFinalExamMark(7.2f);
			
			Subject sub3 = new Subject("TH1101","LT HDT",3);
			sub3.setAttendanceMark(7.7f);
			sub3.setMidExamMark(6.8f);
			sub3.setFinalExamMark(7.1f);
			
			std.addSubject(sub1);
			std.addSubject(sub2);
			std.addSubject(sub3);
			
			System.out.println("TBHK: " + std.calTermAverageMark());
		}

	
	
	
}
