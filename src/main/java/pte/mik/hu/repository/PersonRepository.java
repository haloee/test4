package pte.mik.hu.repository;
import pte.mik.hu.model.Person;
import java.util.List;
public class PersonRepository implements ClientRepository<Person> {
    private final DataSource dataSource = DataSource.getInstance();

    @Override
    public List<Person> listAll() {
        return dataSource.getAllPersons();
    }

    @Override
    public void save(Person client) {
        dataSource.save(client);
    }
}
