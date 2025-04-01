package pte.mik.hu.repository;
import pte.mik.hu.model.Company;
import java.util.List;
public class CompanyRepository implements ClientRepository<Company> {
    private final DataSource dataSource = DataSource.getInstance();

    @Override
    public List<Company> listAll() {
        return dataSource.getAllCompanies();
    }

    @Override
    public void save(Company client) {
        dataSource.save(client);
    }
}
