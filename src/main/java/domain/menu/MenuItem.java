package domain.menu;

public record MenuItem(String name, int price) {
	public static MenuItem of(String name, int price) {
		return new MenuItem(name, price);
	}
}
