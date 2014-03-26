import org.hibernate.*;
import org.hibernate.cfg.*;
import java.util.*;
class Test 
{
	public static void main(String[] args) 
	{
		//System.out.println("Hello World!");
//activate HB
Configuration cfg=new Configuration();
cfg=cfg.configure();
SessionFactory fac=cfg.buildSessionFactory();
Session ses=fac.openSession();
Query q1=ses.createQuery("from Employee as eb");
q1.setFirstResult(2);
q1.setMaxResults(5);
List l=q1.list();
for(int i=0;i<l.size();++i)
		{
Employee eb=(Employee)l.get(i);
System.out.println(eb.getNo()+" "+eb.getName());
		}
/*eb.setNo(101);
eb.setName("kaja");
eb.setEmail("kaja@k.com");
/*Transaction tx=ses.beginTransaction();
ses.save(eb);
tx.commit();*/
	}
}
