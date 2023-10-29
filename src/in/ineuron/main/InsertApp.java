package in.ineuron.main;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import in.ineuron.Model.Employee;
import in.ineuron.Util.HibernateUtil;

public class InsertApp {

	public static void main(String[] args) {
		Session session=null;
		Transaction transaction=null;
		Employee employee=null;
		boolean flag=false;
		try {
			session=HibernateUtil.getSession();
			transaction=session.beginTransaction();
			employee=new Employee();
			employee.setEmpId(13);
			employee.setEmpName("uma");
			employee.setEmpSal(900123.0);
			session.save(employee);
			flag=true;
		} 
		catch (HibernateException he) {
			he.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
		if(flag==true)
			transaction.commit();
		else
			transaction.rollback();
			
			HibernateUtil.closeSession();
		}
	}

}
