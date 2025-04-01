package pte.mik.hu.servlet;
import pte.mik.hu.model.Client;
import pte.mik.hu.service.ClientService;
import pte.mik.hu.service.CompanyService;
import pte.mik.hu.service.PersonService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
public class ClientListServlet  extends HttpServlet {
    private final PersonService personService = new PersonService();
    private final CompanyService companyService = new CompanyService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        List<Client> allClients = new ArrayList<>();
        allClients.addAll(personService.listAll());
        allClients.addAll(companyService.listAll());
        allClients.sort(Comparator.comparing(Client::getId));

        req.setAttribute("clients", allClients);
        req.getRequestDispatcher("/clients.jsp").forward(req, resp);
    }
}
