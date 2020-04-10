package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PaymentMethodTest {

    @Test
    void findPaymentMethodBy_inputValidPaymentMethod_returnPaymentMethodInstance() {
        int paymentMethod = 1;
        assertThat(PaymentMethod.findPaymentMethodBy(paymentMethod)).isEqualTo(PaymentMethod.CARD);
    }
}