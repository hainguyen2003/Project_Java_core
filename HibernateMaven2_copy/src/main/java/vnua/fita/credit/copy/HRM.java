package vnua.fita.credit.copy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HRM {
	private List<Human>hrList;

	public HRM() {
		// TODO Auto-generated constructor stub
		hrList = new ArrayList<Human>();
	}
	
	public void addHR(Human hm) {
		hrList.add(hm);
	}
	
	public void addHR(Scanner sc) {
		int loai;
		System.out.println("chon loai nhan su (sv:0, gv:1): ");
		loai = sc.nextInt();
		sc.nextLine();
		
		Human human = null;
		if(loai == 0) {
			human = new Student();
		}
		else if(loai == 1) {
			human = new Lecturer();
		}
		
		human.enterInfo(sc);
		
		addHR(human);
	}
	
	public void printHRList() {
		for(Human human : hrList) {		
			System.out.println(human.toString());
		}
	}
	
	public void printStudentList() {
		Student std =null ;
		for(Human human : hrList) {
			if(human instanceof Student)
			std = (Student)human;
			System.out.println(std.getClass_());
		}
	}
	
	public void printLecturerInfo() {
		for(Human human :hrList) {
			if(human instanceof Lecturer) {
				// eps kieeu ve lecturer
				Lecturer lec =(Lecturer)human;
				System.out.println(lec.fullname + "_"+ lec.getPassword());
			}
		}
	}
	
	public void initDemoData() {
		Human h1 =  new Student("669543","nguyen tran anh","k66dfhg","ccv");
		Human h2 =  new Student("665457","nguyen an huyen","k66dhg","ccv");
		Human h3 =  new Student("669773","nguyen huyen thuong","k66dfg","ccv");
		
		addHR(h1);
		addHR(h2);
		addHR(h3);
	}
	
	public void initDemoData(Scanner sc) {
		String chon;
		do {
			// nhap thong tin nhan su
			addHR(sc);
			//hoi muon tiep tuc ko
			System.out.println("ban muon nhap tiep (c/k): ");
			chon = sc.nextLine();
		} while("c".equalsIgnoreCase(chon));
	}
	
	public List<Human> searchHuman(String code){
		List<Human> humanList = new ArrayList<Human>();
		for(Human human : hrList) {
//			if(human.code.contains(code)) {
//				// neu co chua ma can tim
//				humanList.add(human);// them vao ds
//			}
		}
		return humanList;
		
	}
	
	public static void main(String[] args) {
		HRM hrm = new HRM();
		Scanner sc = new Scanner(System.in);
		//hrm.initDemoData();
		hrm.initDemoData(sc);// them d sach tu ban phim
		hrm.printHRList();
		hrm.searchHuman("66");
	}
}
