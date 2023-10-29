package in.ineuron.Util;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Transaction;
import in.ineuron.Model.Employee;


public class HibernateUtil {
	static Configuration cfg=null;
	static SessionFactory sessionFactory=null;
	static Session session=null;
	Transaction transaction=null;
	static {
		try {
			cfg=new Configuration();
			cfg.configure();
			sessionFactory=cfg.buildSessionFactory();
		} catch (HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static Session getSession() {
		if(session == null)
			session=sessionFactory.openSession();
		return session;
		
	}
	public static void closeSession() {
		if(session == null)
			session.close();
	}
	public static void closeSessionFactory() {
		if(sessionFactory != null)
			sessionFactory.close();
	}
	

}
