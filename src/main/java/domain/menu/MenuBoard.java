package domain.menu;

public class MenuBoard implements MenuKnown {
	private final Menus menus;

	public MenuBoard(Menus menus) {
		this.menus = menus;
	}

	@Override
	public MenuItem inform(String name) {
		return menus.find(name);
	}
}
