package vnua.fita.credit.copy;

public class JavaSubject extends AbstractSubject implements CreditRule{

	private float attendanceMark;// điểm cc
	private float midExamMark;//điểm giữa kì
	private float priceExamMark;//diem thuc hanh
	private float finalExamMark;// điểm thi
	
	public JavaSubject() {
		// TODO Auto-generated constructor stub
	}

		public JavaSubject(float attendanceMark, float midExamMark, float finalExamMark) {
				super();
				this.attendanceMark = attendanceMark;
				this.priceExamMark = priceExamMark;

				this.midExamMark = midExamMark;
				this.finalExamMark = finalExamMark;
			}
		
		public float calSubjectMark() {
			float subjectMark = (attendanceMark*0.1f +priceExamMark*0.2f + midExamMark*0.3f + finalExamMark*0.4f);
			return subjectMark;
			
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
