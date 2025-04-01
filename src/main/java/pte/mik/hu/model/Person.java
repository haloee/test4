package pte.mik.hu.model;
import java.util.Objects;
public class Person extends Client {
    private String idNumber;

    public Person(Long id, String name, String email, String idNumber) {
        super(id, name, email);
        this.idNumber = idNumber;
    }

    public String getIdNumber() { return idNumber; }
    public void setIdNumber(String idNumber) { this.idNumber = idNumber; }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        Person person = (Person) o;
        return Objects.equals(idNumber, person.idNumber);
    }

    @Override
    public int hashCode() {
        return 31 * super.hashCode() + Objects.hashCode(idNumber);
    }

    @Override
    public String toString() {
        return super.toString() + ", idNumber='" + idNumber + "'";
    }
}
