package cashier;

import java.util.HashMap;
import java.util.Map;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import domain.coffee.MenuBoard;
import domain.coffee.MenuItem;
import domain.coffee.MenuKnown;
import domain.coffee.Menus;
import domain.coffee.NotExistException;

public class MenuKnownTest {

	private MenuKnown menuKnown;

	@BeforeEach
	void setUp() {
		Map<String, MenuItem> menuMap = new HashMap<>();

		MenuItem americano = new MenuItem("아이스아메리카노", 4500);
		MenuItem vanilla = new MenuItem("바닐라라떼", 5000);

		menuMap.put(americano.name(), americano);
		menuMap.put(vanilla.name(), vanilla);

		Menus menus = new Menus(menuMap);

		menuKnown = new MenuBoard(menus);
	}

	@Nested
	@DisplayName("inform 메소드는")
	public class InformTest {

		@Nested
		@DisplayName("메뉴이름을 물어보면")
		public class WithMenuNameGivenTest {
			@Test
			@DisplayName("매핑하는 메뉴가 존재하는 경우 MenuItem 을 리턴한다")
			void test_mappedMenu() {
				String menuName = "아이스아메리카노";

				MenuItem menuItem = menuKnown.inform(menuName);

				Assertions.assertThat(menuItem.name())
					.isEqualTo("아이스아메리카노");
			}

			@Test
			@DisplayName("매핑하는 메뉴가 존재하지 않는 경우 예외를 던진다")
			void test_emptyMenu() {
				String menuName = "따뜻한 아이스아메리카노";

				Assertions.assertThatThrownBy(() ->
						menuKnown.inform(menuName))
					.isInstanceOf(NotExistException.class);
			}
		}
	}
}
