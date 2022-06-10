package domain.coffeemaker;

import domain.coffee.Coffee;
import domain.menu.MenuItem;

public class Barista implements CoffeeMakeable {
	@Override
	public Coffee makeCoffee(MenuItem menuItem) {
		return new Coffee(menuItem.name());
	}
}
