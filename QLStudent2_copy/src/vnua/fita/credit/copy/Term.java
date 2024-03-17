package vnua.fita.credit.copy;

import java.util.ArrayList;
import java.util.List;

public class Term {

	private String termCode;
	private List<CreditRule> AbstractSubjectList;
	
	
		public Term(String termCode) {
			this.termCode = termCode;
			AbstractSubjectList = new ArrayList<CreditRule>();
		}
		
		public int getSumOfCredit() {
			int sum = 0;
			for(CreditRule sub: AbstractSubjectList) {
				sum += sub.getCretdit();
			}
			return sum;
		}
		
		public void addAbstractSubject(CreditRule AbstractSubject) {
			AbstractSubjectList.add(AbstractSubject);
		}
		
		public void editAbstractSubject(CreditRule AbstractSubject) {
			for(CreditRule sub: AbstractSubjectList) {
				if(AbstractSubject.getSubjectCode().equals(sub.getSubjectCode())) {
					sub = AbstractSubject;
				}
			}
		}
		
		public boolean removeAbstractSubject(String AbstractSubjectCode) {
			for(CreditRule sub: AbstractSubjectList) {
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
			for(CreditRule sub: AbstractSubjectList) {
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
			StringBuilder builder= new StringBuilder();
			for (CreditRule subject : AbstractSubjectList) {
				builder.append(subject);
			}
			return "Term [termCode=" + termCode + ", subjectList=" + builder + "]";
		}
			

	

}
