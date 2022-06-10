package domain.customer;

import java.util.ArrayList;
import java.util.List;

import domain.cashier.Cashier;
import domain.menu.MenuKnown;
import domain.menu.MenuItem;
import domain.payment.Payment;
import dto.OrderResult;

/*
*
* 캐셔의 메인 서비스는 주문을 받는게 아닐까?
* 메인 서비스에 좀 더 우선순위를 뒀어야 하지 않을까?
*
* */
public class Customer {
	private final List<MenuItem> consideringMenus = new ArrayList<>(); // FIXME: 추가한 것 _ 현재 구현상 - 내부 원소들의 구성은 가변적이다 (askMenu 에 따라 )

	public MenuItem askOneMenu(MenuKnown menuKnownPeople, String name){
		return menuKnownPeople.inform(name);
	}

	public OrderResult order(Cashier cashier){
		return cashier.receiveOrder(selectPayment(), consideringMenus);
	}

	private Payment selectPayment(){
		return new Payment();
	}
}
