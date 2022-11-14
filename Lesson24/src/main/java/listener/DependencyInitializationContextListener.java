package listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.UserService;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class DependencyInitializationContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(final ServletContextEvent sce) {
        final ApplicationContext context = new ClassPathXmlApplicationContext("Lesson24.xml");
        final UserService userService = context.getBean(UserService.class);
        sce.getServletContext().setAttribute("userService", userService);
    }
//        final String dbDriver = "org.postgresql.Driver";
//        final String username = sce.getServletContext().getInitParameter("db_user");
//        final String password = sce.getServletContext().getInitParameter("db_password");
//        final String dbUrl = sce.getServletContext().getInitParameter("db_url");
//
//        try {
//            Class.forName(dbDriver);
//            final Connection con = DriverManager.getConnection(dbUrl, username, password);
//            UserRepository repository = new JdbcUsersRepository(con);
//            UserService userService = new UserService(repository);
//            sce.getServletContext().setAttribute("userService", userService);
//        } catch (Exception e) {
//
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Override
//    public void contextDestroyed(ServletContextEvent sce) {
//        try {
//            final Connection connection = (Connection) sce.getServletContext().getAttribute("connection");
//            connection.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
}


