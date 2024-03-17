package vnua.fita.credit.copy;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;



public class StudentDAO {
	@SuppressWarnings("unchecked")
	public static List<Student>getAllStudent(){
		Transaction transaction  = null;
		List<Student>ListOfStudent  = null;
		try (Session session = CreditHibernateUtil.getSessionFactory().openSession()){
			//start a transaction
			transaction = session.beginTransaction();
			//get an User object
			ListOfStudent =  session.createQuery("from Student").getResultList();
			
			//commit transaction
			transaction.commit();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			if(transaction != null) {
				transaction.rollback();
			}e.printStackTrace();
		}
		return ListOfStudent;
	}
	
	public static Student getStudent(int id) {
		Transaction transaction = null;
		Student student = null;
		try(Session session = CreditHibernateUtil.getSessionFactory().openSession()) {
			//start a transaction
			transaction = session.beginTransaction();
			//get an User object
			student =  session.get(Student.class,id);
			
			//commit transaction
			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
			if(transaction != null) {
				transaction.rollback();
			}e.printStackTrace();
		}
		return student;
	}
	
	public StudentDAO() {
		// TODO Auto-generated constructor stub
		
	}

}
