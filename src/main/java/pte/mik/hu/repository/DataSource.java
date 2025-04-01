package pte.mik.hu.repository;
import pte.mik.hu.model.*;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
public class DataSource{
    private final List<Client> clients = new ArrayList<>();
    private Long nextId = 1L;

    private static final DataSource INSTANCE = new DataSource();

    private DataSource() {
        // Dummy adatok
        clients.add(new Person(nextId++, "Anna", "anna@email.com", "P123"));
        clients.add(new Company(nextId++, "TechCorp", "contact@tech.com", "C456"));
    }

    public static DataSource getInstance() {
        return INSTANCE;
    }

    public Long nextId() {
        return nextId++;
    }

    public List<Person> getAllPersons() {
        return clients.stream()
                .filter(p -> p instanceof Person)
                .map(p -> (Person) p)
                .collect(Collectors.toList());
    }

    public List<Company> getAllCompanies() {
        return clients.stream()
                .filter(c -> c instanceof Company)
                .map(c -> (Company) c)
                .collect(Collectors.toList());
    }

    public void save(Client client) {
        clients.add(client);
    }
}
