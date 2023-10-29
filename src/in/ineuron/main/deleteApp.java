package in.ineuron.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.Model.Employee;
import in.ineuron.Util.HibernateUtil;

public class deleteApp {

	public static void main(String[] args) {
		Session session=null;
		Transaction transaction=null;
		Employee employee=null;
		boolean flag=false;
		try {
			session=HibernateUtil.getSession();
			if(session!=null) {
			transaction=session.beginTransaction();
			employee=session.get(Employee.class, 1);
			if(employee!=null) {
				session.delete(employee);
				flag=true;
				System.out.println("Record deleted successfully....");
			}
			}
		} 
		catch (HibernateException he) {
			System.out.println("Record not available..........");
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(flag == true) {
				transaction.commit();
			}
			else {
				transaction.rollback();
			}
			
			HibernateUtil.closeSession();
		}
	}
}
