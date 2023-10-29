package in.ineuron.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import in.ineuron.Model.*;
import in.ineuron.Util.HibernateUtil;

public class SelectRecordApp {

	public static void main(String[] args) {
		Session session=HibernateUtil.getSession();
		Employee employee=null;
		try {
			if(session!=null) {
			employee=session.load(Employee.class, 1);
			
				System.out.println("ID :: "+employee.getEmpId()+" \nNAME :: "+employee.getEmpName()+"\nSALARY :: "+employee.getEmpSal());
			
			}
		} catch (HibernateException e) {
			System.out.println("Record not Found...");
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			HibernateUtil.closeSession();
		}
	}

}
