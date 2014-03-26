import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import org.hibernate.cfg.*;
import org.hibernate.*;
import p1.EmpBean;

public class DBServlet extends HttpServlet
{
  Session session=null;
public void init(ServletConfig  config)
	{
		try 
		{
			 SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			 session = sessionFactory.openSession();
		}
		catch(HibernateException e)
        {
            e.printStackTrace();
        }
	} // init(ServletConfig)

public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
{
  //read form data
  int no=Integer.parseInt(req.getParameter("no"));

//Writing business and persistance logic
 try 
 {
    EmpBean eb=(EmpBean)session.get(EmpBean.class, new Integer(no));

//send result to result.jsp
req.setAttribute("result",eb);

//Forward the req to result.jsp
RequestDispatcher rd=req.getRequestDispatcher("/result.jsp");
rd.forward(req,res);
} //try
catch(Exception e)
{
 e.printStackTrace();
}
} //doGet

public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
{
  doGet(req,res);
}

 public void destroy()
 {
    try
    {
        session.close();
   } catch(Exception e)
   {
     e.printStackTrace();
  }
}
}
