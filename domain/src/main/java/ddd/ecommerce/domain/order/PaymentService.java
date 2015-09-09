package ddd.ecommerce.domain.order;

import ddd.ecommerce.domain.common.Amount;
import ddd.ecommerce.domain.payment.ChargeResponse;
import ddd.ecommerce.domain.payment.CreditCardInfo;

public interface PaymentService {

    public ChargeResponse charge(CreditCardInfo creditCardInfo,
                                 Amount amount,
                                 String description);
}

