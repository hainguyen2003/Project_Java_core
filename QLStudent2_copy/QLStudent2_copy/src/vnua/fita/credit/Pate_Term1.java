package vnua.fita.credit;

import java.util.ArrayList;
import java.util.List;

public class Pate_Term1 {

	private String termCode;
	private List<AbstractSubject> AbstractSubjectList;
	
	
		public Pate_Term1(String termCode) {
			this.termCode = termCode;
			AbstractSubjectList = new ArrayList<AbstractSubject>();
		}
		
		public int getSumOfCredit() {
			int sum = 0;
			for(AbstractSubject sub: AbstractSubjectList) {
				sum += sub.getCretdit();
			}
			return sum;
		}
		
		public void addAbstractSubject(AbstractSubject AbstractSubject) {
			AbstractSubjectList.add(AbstractSubject);
		}
		
		public void editAbstractSubject(AbstractSubject AbstractSubject) {
			for(AbstractSubject sub: AbstractSubjectList) {
				if(AbstractSubject.getSubjectCode().equals(sub.getSubjectCode())) {
					sub = AbstractSubject;
				}
			}
		}
		
		public boolean removeAbstractSubject(String AbstractSubjectCode) {
			for(AbstractSubject sub: AbstractSubjectList) {
				if(AbstractSubjectCode.equals(sub.getSubjectCode())) {
					AbstractSubjectList.remove(sub);
					return true;
				}
			}
			return false;
		}
		
		public float calTermAverageMark() {
			float tu = 0;
			float mau = 0;
			// Duyet qua danh sach mon hoc
			for(AbstractSubject sub: AbstractSubjectList) {
				tu = tu + sub.getCretdit()*sub.calConversionMark();
				mau += sub.getCretdit();
			}
			return tu/mau;
		}

		public String getTermCode() {
			return termCode;
		}

		public void setTermCode(String termCode) {
			this.termCode = termCode;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			StringBuilder sb = new StringBuilder();
			for(AbstractSubject sub : AbstractSubjectList)
			{
				sb.append(sub.getSubjectCode() +"_"+ sub.getClass() +"\n");
			}
			return sb.toString();
		}
			

	

}
