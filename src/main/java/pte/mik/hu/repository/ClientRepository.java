package pte.mik.hu.repository;
import pte.mik.hu.model.Client;
import java.util.List;
public interface ClientRepository <T extends Client> {
    List<T> listAll();
    void save(T client);
}
