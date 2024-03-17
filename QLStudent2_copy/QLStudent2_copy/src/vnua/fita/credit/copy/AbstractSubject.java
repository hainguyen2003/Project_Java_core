package vnua.fita.credit.copy;

public abstract class AbstractSubject {

	private String subjectCode;
	private String subjectName;
	private int credit;
	private float attendanceMark;// điểm cc
	private float midExamMark;//điểm giữa kì
	private float finalExamMark;// điểm thi
	public Object code;

	public abstract float calSubjectMark();
	
 public String calGrade() {
		float subjectMark = calSubjectMark();
		String grade =  null;
		if(subjectMark <0)
		{
			grade = "error";
		}
		else if(subjectMark <= CreditRule.LEVEL_F)
		{
			grade = "F";
		}
		else if(subjectMark  <= CreditRule.LEVEL_D)
		{
			grade = "D";
		}
		else if(subjectMark  <= CreditRule.LEVEL_D)
		{
			grade = "D+";
		}
		else if(subjectMark  <= CreditRule.LEVEL_C)
		{
			grade = "C";
		}
		else if(subjectMark  <= CreditRule.LEVEL_C)
		{
			grade = "C+";
		}
		else if(subjectMark  <= CreditRule.LEVEL_B)
		{
			grade = "B";
		}
		else if(subjectMark  <= CreditRule.LEVEL_B)
		{
			grade = "B+";
		}
		else if( subjectMark <= CreditRule.LEVEL_A)
		{
			grade = "A";
		}
		else if(subjectMark <= CreditRule.LEVEL_A1)
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


//tinhs thang diem 4
	public float calConversionMark() {
		float subjectMark = calSubjectMark();
		float conversionMark = -1;
		if(subjectMark <= CreditRule.LEVEL_F) {
			conversionMark = 0;
			}
		else if(subjectMark<= CreditRule.LEVEL_D) {
				conversionMark = 1;
		}
		else if(subjectMark <= CreditRule.LEVEL_C) {
			conversionMark = 2;
	}
		else if(subjectMark <= CreditRule.LEVEL_B) {
			conversionMark = 3;
	}
		else if(subjectMark <= CreditRule.LEVEL_A1) {
				conversionMark = 4;
			
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
	public String getSubjectCode() {
		return subjectCode;
	}
	

	@Override
	public String toString() {
		return subjectName +"_"+ getSubjectCode() +"_"+ credit +"_"+ calSubjectMark() +"_"+ calConversionMark() +"_"+ calGrade();
	}
	
	public AbstractSubject() {
		// TODO Auto-generated constructor stub
	}

}
