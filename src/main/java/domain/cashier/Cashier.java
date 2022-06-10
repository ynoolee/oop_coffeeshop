package domain.cashier;

import java.util.Collection;
import java.util.List;

import domain.coffee.Coffee;
import domain.coffeemaker.CoffeeMakeable;
import domain.menu.MenuItem;
import domain.menu.MenuKnown;
import domain.menu.Menus;
import domain.payment.PaySystem;
import domain.payment.Payment;
import dto.OrderResult;

public class Cashier implements MenuKnown {
	private final Menus menus;
	private final PaySystem paySystem;
	private CoffeeMakeable barista;

	public Cashier(Menus menus, PaySystem paySystem) {
		this.menus = menus;
		this.paySystem = paySystem;
	}

	public void setBarista(CoffeeMakeable barista) {
		this.barista = barista;
	}

	@Override
	public MenuItem inform(String name) {
		return menus.find(name);
	}

	public OrderResult receiveOrder(Payment payment,
			Collection<MenuItem> items) { // MenuItem... 보다는 Collection 이 좋지 않을까?
		if (barista == null) {
			throw new RuntimeException("바리스타가 존재하지 않습니다");
		}

		List<Coffee> coffees = items.stream()
				.map(orderItem ->
						requestMakeCoffee(barista, orderItem)).toList();

		// TODO : 설계대로 만들었지만, 책임 분리하고 싶은 부분
		int sum = items.stream()
				.mapToInt(menu -> menu.price())
				.reduce(0, (op1,op2) -> op1 + op2);

		return new OrderResult(sum, coffees);
	}

	private Coffee requestMakeCoffee(CoffeeMakeable barista, MenuItem menuItem) {
		return barista.makeCoffee(menuItem);
	}

	private boolean requestPay(Payment payment, PaySystem paySystem) {
		return paySystem.pay(payment);
	}

}
