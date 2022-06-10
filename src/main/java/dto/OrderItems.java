package dto;

import java.util.Collection;

import domain.menu.MenuItem;

public class OrderItems {
	private final Collection<MenuItem> menuItems;

	public OrderItems(Collection<MenuItem> menuItems) {
		this.menuItems = menuItems;
	}

	public Collection<MenuItem> getMenuItems() {
		return menuItems;
	}

	public int totalPrice() {
		return menuItems.stream()
				.mapToInt(item -> item.price())
				.sum();
	}
}
