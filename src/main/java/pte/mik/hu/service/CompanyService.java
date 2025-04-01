package pte.mik.hu.service;
import pte.mik.hu.model.Company;
import pte.mik.hu.repository.CompanyRepository;
import java.util.List;
public class CompanyService implements ClientService<Company> {
    private final CompanyRepository companyRepository = new CompanyRepository();

    @Override
    public void register(Company company) {
        companyRepository.save(company);
    }

    @Override
    public List<Company> listAll() {
        return companyRepository.listAll();
    }
}
