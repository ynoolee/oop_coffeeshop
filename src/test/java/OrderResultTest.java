import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import domain.cashier.Cashier;
import domain.coffee.Coffee;
import domain.coffeemaker.Barista;
import domain.coffeemaker.CoffeeMakeable;
import domain.menu.MenuItem;
import domain.menu.Menus;
import domain.payment.Payment;
import domain.payment.SimplePaymentSystem;
import dto.OrderItems;
import dto.OrderResult;

public class OrderResultTest {

	private MenuItem americano;
	private MenuItem vanilla;
	private Cashier cashier;

	@BeforeEach
	void setUp() {
		americano = new MenuItem("아이스아메리카노", 4500);
		vanilla = new MenuItem("바닐라라떼", 5000);

		Map<String, MenuItem> menuItems = new HashMap<>();

		menuItems.put(americano.name(), americano);
		menuItems.put(vanilla.name(), vanilla);

		Menus menus = new Menus(menuItems);

		CoffeeMakeable barista = new Barista();

		cashier = new Cashier(menus, new SimplePaymentSystem());
		cashier.setBarista(barista);
	}

	@Test
	@DisplayName("캐셔를 통해 주문한다")
	public void test() {

		Coffee americanoCoffee = Coffee.of(americano);
		Coffee vanillaCoffee = Coffee.of(vanilla);

		List<MenuItem> orderedMenus = List.of(americano, vanilla);
		List<Coffee> coffees = List.of(americanoCoffee, vanillaCoffee);

		OrderResult orderResult = cashier.receiveOrder(new Payment(), orderedMenus);
		int calculatedTotal = coffees.stream()
			.map(c -> cashier.inform(c.getName()).price())
			.reduce(0, (a, b) -> a + b);

		Assertions.assertThat(orderResult.totalPrice())
			.isEqualTo(calculatedTotal);
	}

}
