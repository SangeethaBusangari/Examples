import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.HibernateException;
public class TestClient
{
	public static void main(String args[])throws Exception
	{
		try
		{
			Configuration cfg=new Configuration();
			Configuration cf=cfg.configure();//accesing hibernate.cfg.xml file
			SessionFactory factory=cf.buildSessionFactory();
			Session ses=factory.openSession();
			Transaction tx=ses.beginTransaction();
			EmpBean eb=new EmpBean();
			eb.setEid(101);
			eb.setEname("sangeetha");
			eb.setSalary(10000);
			eb.setEmail("sangeetha@gmail.com");
			ses.save(eb);
			EmpBean eb1=new EmpBean();
			eb1.setEid(102);
			eb1.setEname("sahitha");
			eb1.setSalary(20000);
			eb1.setEmail("sahitha@gmail.com");
			ses.save(eb1);
			tx.commit();
			System.out.println("Records commited successfully");
			
			/*EmpBean e=(EmpBean)ses.get(EmpBean.class,new Integer(101));
			System.out.println(e.getEId()+" "+e.getEname()+" "+e.getSalary+" "+e.getEmail());
			tx.commit();
			System.out.println("Records retrieved successfully");
			
			eb.setEid(101);
			eb.setEname("sangeetha");
			eb.setSalary(10000);
			eb.setEmail("sangeetha.785@gmail.com");
			ses.save(eb);
			tx.commit();
			System.out.println("Record updated successfully");
			EmpBean eb1=new EmpBean();
			eb1.setEid(102);
			ses.delete(eb1);
			tx.commit();
			System.out.println("Record deleted Successfully");*/
			ses.close();
			factory.close();
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		}
	}
}
