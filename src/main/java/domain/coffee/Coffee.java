package domain.coffee;

import domain.menu.MenuItem;

public class Coffee {
	private final String name;

	public Coffee(String menuName) {
		this.name = menuName;
	}

	public static Coffee of(MenuItem menuItem) {
		return new Coffee(menuItem.name());
	}
}
