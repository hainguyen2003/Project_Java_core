package vnua.fita.credit.copy;

import java.util.Scanner;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Transient;

@MappedSuperclass
public class Human {
	@Id
	@Column(name = "MaSV")
		private String code;
	@Column(name = "Ten")
		protected String fullname;
	@Transient
		protected String address;

	

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public String getFullname() {
			return fullname;
		}

		public void setFullname(String fullname) {
			this.fullname = fullname;
		}

		public  Human() {}
		
		public Human(String code) {
			this.code = code;
		}
		
		public Human(String code, String fullname) {
			this.code = code;
			this.fullname= fullname;
		}
		
		public Human(String code,String fullname, String address) {
			this(code,fullname);
			this.address = address;
		}
		
		public void enterInfo(Scanner sc) {
		System.out.println("nhap ma:");
		code = sc.nextLine();
		System.out.println("nhap ho ten:");
		fullname = sc.nextLine();
		System.out.println("nhap dia chi:");
		address = sc.nextLine();
		}
		
		@Override
		public String toString() {
			return code + "_" + fullname +"_" + address;
		}
		
		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		@Override
		public boolean equals(Object obj) {
			Human anotherhuman = (Human)obj;
			return this.code.equals(anotherhuman.code);
			//goi equal qua lop string
			
		}

	/* public static void main(String[] args) {
		// TODO Auto-generated method stub

	}*/

}
