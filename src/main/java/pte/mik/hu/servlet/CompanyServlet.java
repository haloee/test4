package pte.mik.hu.servlet;
import java.io.IOException;
import pte.mik.hu.model.Company;
import pte.mik.hu.service.CompanyService;
import pte.mik.hu.service.IdProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
public class CompanyServlet extends HttpServlet {
    private final CompanyService companyService = new CompanyService();
    private final IdProvider idProvider = IdProvider.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setAttribute("companies", companyService.listAll());
        req.getRequestDispatcher("/company.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String taxNumber = req.getParameter("taxNumber");

        Company company = new Company(idProvider.nextId(), name, email, taxNumber);
        companyService.register(company);

        resp.sendRedirect("company");
    }
}
