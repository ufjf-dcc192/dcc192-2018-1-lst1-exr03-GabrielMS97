package br.ufjf.dcc192;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "InicialServlet", urlPatterns = {"/index.html"})
public class InicialServlet extends HttpServlet {

    private double tj = 0.01;
    private int meses = 12;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Exercício 3</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Exercício 3 </h1>");
            out.println("<form>");
            out.println("<label>Número de meses<input name='mes'/></label><br/>");
            out.println("<label>Taxa de juros<input name='taxa'/></label><br/>");
            out.println("<input type='submit'/>");
            meses = Integer.parseInt(request.getParameter("mes"));
            tj = Double.parseDouble(request.getParameter("taxa"))/100;
            out.println("</form>");
            out.println("<table border ='1'>");
            out.println("<tr>");
            out.println("<th>Valor final do mês</th>");
            out.println("<th>0,5 X taxa de juros</th>");
            out.println("<th>taxa de juros</th>");
            out.println("<th>1,5 X taxa de juros</th>");
            out.println("</tr>");
            for (int i = 1; i <= meses; i++) {
                double vf = 1000 * (1 + i * (tj));
                out.println("<tr>");
                out.println("<td>" + vf + "</td>");
                out.println("<td>" + 0.5 * tj + "</td>");
                out.println("<td>" + tj + "</td>");
                out.println("<td>" + 1.5 * tj + "</td>");
                out.println("</tr>");
            }
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
        }
    }   
}
