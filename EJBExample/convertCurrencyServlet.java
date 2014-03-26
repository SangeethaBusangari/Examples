package servlet;

import ejb.CurrencyConverterBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="convertCurrencyServlet", urlPatterns={"/convertCurrencyServlet"})
public class convertCurrencyServlet extends HttpServlet {
    @EJB
    CurrencyConverterBean converterBean;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String amount = request.getParameter("amount");
            if (amount != null && amount.length() > 0) {
                BigDecimal d = new BigDecimal(amount);
                BigDecimal convertedAmount = converterBean.convert(request.getParameter("From"), request.getParameter("To"), d);
                out.println("<html>");
                out.println("<head><title>Converted Currency</title></head>");
                out.println("<body>");
                out.println(amount + " " + request.getParameter("From") + " = ");
                out.println(convertedAmount + " " + request.getParameter("To"));
                out.println("<br/>Click <a href='index.jsp'>here</a> to go back");
                out.println("</body>");
                out.println("</html>");
            }
        } finally {
            out.close();
        }
    } 
}
