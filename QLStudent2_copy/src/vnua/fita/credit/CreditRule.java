package vnua.fita.credit;

public interface CreditRule {

	float LEVEL_F = 3.9f;
	float LEVEL_D = 4.9f;
	float LEVEL_C = 6.9f;
	float LEVEL_B = 7.9f;
	float LEVEL_A = 8.9f;
	float LEVEL_A1 = 10f;

	float calSubjectMark();
	String calGrade();
	float calConversionMark();
	
	String getSubjectCode();
	public void setSubjectCode(String subjectCode);
	String getSubjectName();
	public void setSubjectName(String subjectName);
	
	int getCredit();
	public void setCredit(int credit);
	
	int getCretdit();
	public void setCretdit(int cretdit);
	
	

}
