package in.ineuron.main;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import in.ineuron.Model.Employee;
import in.ineuron.Util.HibernateUtil;

public class UpdateRecordApp {

	public static void main(String[] args) {
		Session session=null;
		Transaction transaction=null;
		Employee employee=null;
		boolean flag=false;
		try {
			session=HibernateUtil.getSession();
			transaction=session.beginTransaction();
			employee=new Employee();
			employee.setEmpId(18);
			employee.setEmpName("kholi");
			employee.setEmpSal(90003.0);
			session.saveOrUpdate(employee);
			flag=true;
		} 
		catch (HibernateException he) {
			he.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
		if(flag==true) {
			transaction.commit();
		System.out.println("updateddd........");}
		else {
			transaction.rollback();
			System.out.println(" not  updateddd........");}
			
			HibernateUtil.closeSession();
		}
	}

}
