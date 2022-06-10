package domain.coffeemaker;

import domain.coffee.Coffee;
import domain.menu.MenuItem;

public interface CoffeeMakeable {
	Coffee makeCoffee(MenuItem menuItem);
}
