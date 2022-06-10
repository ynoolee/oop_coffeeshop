package domain.coffee;

import domain.menu.MenuItem;

// TODO : Coffee 의 존재감이 애매하네요.. 단순히 name 만을 갖고 있는 것이 참 그런데, Coffee 의 경우 "식별자"가 따로 필요한 존재하는 생각이 듭니다
public class Coffee {
	private final String name;

	public Coffee(String menuName) {
		this.name = menuName;
	}

	public static Coffee of(MenuItem menuItem) {
		return new Coffee(menuItem.name());
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Coffee{");
		sb.append("name='").append(name).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
