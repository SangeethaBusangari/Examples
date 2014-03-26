/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.*;
import org.hibernate.cfg.*;
import java.util.*;

//@WebServlet(name="FSrv", urlPatterns={"/furl"})
public class PageSrv extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
	 Configuration cfg;
	 Session ses;
	 public void init()
	{
		  cfg=new Configuration();
cfg=cfg.configure();
SessionFactory fac=cfg.buildSessionFactory();
 ses=fac.openSession();
 System.out.println("HB activated in init()");
	 }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html");
PrintWriter pw=response.getWriter();
Query q1=ses.createQuery("from Employee as eb");
List l=q1.list();
int totrec=l.size();
int initval;

HttpSession session=request.getSession();
if(session.getAttribute("count")==null)
		{
	initval=0;
	session.setAttribute("count",initval);
}//if
else
		{
	int i1=(Integer)session.getAttribute("count");
	initval=i1+2;
session.setAttribute("count",initval);
	}//else
q1.setFirstResult(initval);
q1.setMaxResults(2);
l=q1.list();
pw.println("<table><tr><td>Number</td><td>Name</td><td>Email</td>");
for(int i=0;i<l.size();++i)
		{
Employee eb=(Employee)l.get(i);
pw.println("<tr><td>"+eb.getNo()+"</td><td>"+eb.getName()+"</td><td>"+eb.getEmail());
System.out.println(eb.getNo()+" "+eb.getName());
		}
		pw.println("</table>");
if(initval+2<totrec)
	pw.println("<a href=pgurl>next</a>");
else
{
		pw.println("<a href=input.html>Home</a>");
		session.invalidate();
}
    }//processreq 

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException 
	{
        processRequest(request, response);
    } 

      protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException 
	{
        processRequest(request, response);
    }
}
