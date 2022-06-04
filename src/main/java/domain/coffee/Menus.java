package domain.coffee;

import java.util.Map;
import java.util.Optional;

public class Menus {
	private final Map<String, MenuItem> menus;

	public Menus(Map<String, MenuItem> menus) {
		this.menus = menus;
	}

	public MenuItem find(String name) {
		return Optional.ofNullable(
			menus.get(name))
			.orElseThrow(()-> new NotExistException(MenuItem.class));
	}
}
