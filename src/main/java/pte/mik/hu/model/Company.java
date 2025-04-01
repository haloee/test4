package pte.mik.hu.model;
import java.util.Objects;
public class Company extends Client{
    private String taxNumber;

    public Company(Long id, String name, String email, String taxNumber) {
        super(id, name, email);
        this.taxNumber = taxNumber;
    }

    public String getTaxNumber() { return taxNumber; }
    public void setTaxNumber(String taxNumber) { this.taxNumber = taxNumber; }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        Company company = (Company) o;
        return Objects.equals(taxNumber, company.taxNumber);
    }

    @Override
    public int hashCode() {
        return 31 * super.hashCode() + Objects.hashCode(taxNumber);
    }

    @Override
    public String toString() {
        return super.toString() + ", taxNumber='" + taxNumber + "'";
    }
}
