package pte.mik.hu.servlet;
import pte.mik.hu.model.Person;
import pte.mik.hu.service.PersonService;
import pte.mik.hu.service.IdProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import java.io.IOException;
public class PersonServlet  extends HttpServlet {
    private final PersonService personService = new PersonService();
    private final IdProvider idProvider = IdProvider.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setAttribute("persons", personService.listAll());
        req.getRequestDispatcher("/person.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String idNumber = req.getParameter("idNumber");

        Person person = new Person(idProvider.nextId(), name, email, idNumber);
        personService.register(person);

        resp.sendRedirect("person");
    }
}
