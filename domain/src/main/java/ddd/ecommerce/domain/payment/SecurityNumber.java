package ddd.ecommerce.domain.payment;


public class SecurityNumber {
    private String securityNumber;

    public SecurityNumber(String securityNumber) {
        this.securityNumber = securityNumber;
    }

    public String getSecurityNumber() {
        return securityNumber;
    }
}
