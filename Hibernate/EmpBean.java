public class EmpBean
{
	private int eid,salary;
	private String ename,email;
	public EmpBean(){}
	public EmpBean(int eid,String ename ,int salary,String email)
	{
		this.eid=eid;
		this.ename=ename;
		this.salary=salary;
	}
	public void setEid(int eid)
	{
		this.eid=eid;
	}
	public void setEname(String ename)
	{
		this.ename=ename;
	}
	public void setSalary(int salary)
	{
		this.salary=salary;
	}
	public void setEmail(String email)
	{
		this.email=email;
	}
	public int getEid()
	{
		return eid;
	}
	public String getEname()
	{
		return ename;
	} 
	public int getSalary()
	{
		return salary;
	}
	public String getEmail()
	{
		return email;
	}
}

