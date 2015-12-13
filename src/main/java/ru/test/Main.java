package ru.test;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.internal.StandardServiceRegistryImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by enibeni on 08.12.15.
 */
public class Main extends HttpServlet{
    private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;

    private static void initHibernate(){
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    private static void destroyHibernate() {
        StandardServiceRegistryBuilder.destroy(serviceRegistry);
    }




    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        initHibernate();
        Session s = sessionFactory.getCurrentSession();
        s.beginTransaction();

        Criteria criteria = s.createCriteria(Book.class);
        List<Book> books = criteria.list();

        req.setAttribute("booksList", books);

        getServletContext().getRequestDispatcher("/books.jsp").forward(req, resp);


    }
}


//Spring context

/*public class Main extends HttpServlet{
    public static List<String> list;
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"springContext.xml"});
        JdbcTemplate jdbc = context.getBean("jdbcTemplate", JdbcTemplate.class);
        queryForSimpleObject(jdbc);
    }

    private static String queryForSimpleObject(JdbcTemplate jdbc) {
        String fname = jdbc.queryForObject("SELECT fname FROM authors where author_id = ?", new String[]{"2"}, String.class);
        //System.out.println(fname);
        return fname;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"springContext.xml"});
        JdbcTemplate jdbc = context.getBean("jdbcTemplate", JdbcTemplate.class);
        String s = queryForSimpleObject(jdbc);


        req.setAttribute("fnamelist", s);

       *//* list = new ArrayList<String>();
        list.add("d1");
        list.add("d2");
        list.add("31");*//*

        //req.setAttribute("fnamelist", list);

        req.getRequestDispatcher("books.jsp").forward(req, resp);
    }
}*/
