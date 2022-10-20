package com.example.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicInteger;

public class HelloServlet extends HttpServlet {

    private AtomicInteger counter;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        try (PrintWriter writer = resp.getWriter()) {
            writer.write("<h2>" + counter + "</h2>");
            writer.write("<div>");
            writer.write(req.getMethod());
            writer.write("<br>");
            writer.write(req.getLocalAddr());
            writer.write("</br>");
            writer.write("<br>");
            writer.write("<h2>Privet sonia</h2>");
            writer.write("</br>");
            writer.write("</div>");

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        counter.addAndGet(1);
        System.out.println("hello");
    }

    @Override
    public void init() throws ServletException {
        counter = new AtomicInteger();
    }
}
