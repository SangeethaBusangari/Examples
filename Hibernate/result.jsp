<%@ page import="p1.EmpBean" %>

<%EmpBean eb=(EmpBean)request.getAttribute("result"); %>

<b>Employee Details are </b>
<%= eb.getId() %>&nbsp; <%= eb.getFname()%>&nbsp;
<%= eb.getLname() %>&nbsp; <%= eb.getEmail()%>&nbsp;
