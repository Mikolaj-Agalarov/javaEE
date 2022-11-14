package servlet;

import model.User;
import service.UserService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet("/filteredUsers")
public class FilteredUsersServlet extends HttpServlet {
    private UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        userService = (UserService) config.getServletContext().getAttribute("userService");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = userService.filterUsers(req.getParameter("prefix"));
        req.setAttribute("users", users);
        System.out.println(Arrays.toString(users.toArray()));
        getServletContext().getRequestDispatcher("/users.jsp").forward(req, resp);
    }
}
