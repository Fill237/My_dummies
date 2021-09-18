package ru.appline;

import ru.appline.logic.Model;
import ru.appline.logic.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Map;

@WebServlet(urlPatterns = "/get")
public class ServletList extends HttpServlet {

    Model model = Model.getInstance();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset:utf-8");
        PrintWriter pw = response.getWriter();

        int id = Integer.parseInt(request.getParameter("id"));


        if (id == 0) {
            pw.print("<html>" +
                    "<h3>Available user:</h3><br/>" +
                    "ID user:" +
                    "<ul>");
        for (Map.Entry<Integer, User> entry : model.getFromList().entrySet()) {
            pw.print("<li>" + entry.getKey() + "</li>" +
                    "<ul>" +
                    "<li>Name: " + entry.getValue().getName() + "</li>" +
                    "<li>Surname: " + entry.getValue().getSurname() + "</li>" +
                    "<li>Salary: " + entry.getValue().getSalary() + "</li>" +
                    "</ul>");
        }
        pw.print("</ul>" +
                "<a href=\"index.jsp\">Home</a>" +
                "</html>");
    }else if (id > 0 ) {

            if (id > model.getFromList().size()) {
            //if (id < model.getFromList().size()) {
                pw.print("<html>" +
                        "<h3> No such user exists</h3>" +
                        "<a href=\"index.jsp\">Home</a>" +
                        "</html>");
            } else {
                pw.print("<html>" +
                        "<h3> Requested user: </h3>" +
                        "<br/>" +
                        "Name: " + model.getFromList().get(id).getName() + "<br/>" +
                        "Surname: " + model.getFromList().get(id).getSurname() + "<br/>" +
                        "Salary: " + model.getFromList().get(id).getSalary() + "<br/>" +
                        "<a href=\"index.jsp\">Home</a>" +
                        "</html>");
            }
        } else {
            pw.print("<html>" +
                    "<h3>ID mus be greater than 0!</h3>" +
                    "<a href=\"index.jsp\">Home</a>" +
                    "</html>");
        }
    }
}
