package vnua.fita.credit;

public class OOPSubject extends AbstractSubject  implements CreditRule{

	private float attendanceMark;// điểm cc
	private float midExamMark;//điểm giữa kì
	private float finalExamMark;// điểm thi
	
	
/*
	//tinhs thang diem 4
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
		*/
		public float calSubjectMark() {
			float subjectMark = (attendanceMark*0.1f + midExamMark*0.4f + finalExamMark*0.5f);
			return subjectMark;
			
		}

		
		public OOPSubject(float attendanceMark, float midExamMark, float finalExamMark) {
			super();
			this.attendanceMark = attendanceMark;
			this.midExamMark = midExamMark;
			this.finalExamMark = finalExamMark;
		}
		

		@Override
		public String getSubjectName() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int getCredit() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public void setCretdit(int cretdit) {
			// TODO Auto-generated method stub
			
		}

		
		
		


}
