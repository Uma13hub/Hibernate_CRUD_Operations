package in.ineuron.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Transaction;
import in.ineuron.Model.Employee;


public class TestApp {

	public static void main(String[] args) throws Exception {
		//1. Create configuration object
		Configuration cfg=new Configuration();
		
		//2.configure hiberante.cfg.xml to Configuration object
		cfg.configure();
		
		//3.create sessionFactory object
		SessionFactory sessionFactory=cfg.buildSessionFactory();
		
		//4.get the session object
		Session session=sessionFactory.openSession();
		
		//5.get the transaction object from session object
		Transaction transaction= session.beginTransaction();
		
		Employee employee=new Employee();
		employee.setEmpId(18);
		employee.setEmpName("kholi");
		employee.setEmpSal(9000023.0);
		
		//6.perform operation
		session.save(employee);
		
		//7/commit or rollback
		transaction.commit();
		
		//8.session close
		
		session.close();
	}

}
