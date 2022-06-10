package dto;

import java.util.Collection;

import domain.coffee.Coffee;

public record OrderResult(int totalPrice, Collection<Coffee> coffees) {
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("OrderResult{");
		sb.append("totalPrice=").append(totalPrice);
		sb.append(", coffees=").append(coffees);
		sb.append('}');
		return sb.toString();
	}
}
