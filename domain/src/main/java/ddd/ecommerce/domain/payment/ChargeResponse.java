package ddd.ecommerce.domain.payment;

public class ChargeResponse {
    private String transactionId;
    private boolean isPaid;

    public ChargeResponse(String transactionId, boolean isPaid) {
        this.transactionId = transactionId;
        this.isPaid = isPaid;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public boolean isPaid() {
        return isPaid;
    }
}
