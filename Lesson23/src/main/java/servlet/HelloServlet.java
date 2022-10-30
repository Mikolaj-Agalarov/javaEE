package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text.html");
        try (PrintWriter writer = resp.getWriter()) {
            writer.write("<h1>H12 1111</h1>");
        }
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }
}
