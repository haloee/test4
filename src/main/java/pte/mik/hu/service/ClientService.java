package pte.mik.hu.service;
import pte.mik.hu.model.Client;
import java.util.List;
public interface ClientService<T extends Client> {
    void register(T client);
    List<T> listAll();
}
