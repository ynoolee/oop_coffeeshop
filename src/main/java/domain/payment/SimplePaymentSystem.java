package domain.payment;

public class SimplePaymentSystem implements PaySystem {
	@Override
	public boolean pay(Payment payment) {
		return true;
	}
}
