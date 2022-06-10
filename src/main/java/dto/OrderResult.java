package dto;

import java.util.Collection;

import domain.coffee.Coffee;
import domain.menu.MenuItem;

/*
* dto - "계층"간의 전송인가? 과연 DTO 라는 이름은 적절한가?
* 현재 상황상 서비스 역할을 하는 어떤 것이 중간에 무조건 필요하다..
* 돌아가는 콘솔 프로그램? 에서 이런 컴포넌트들을 호출하는식으로 구조를 가져갈것인가?
*
*	TODO : 원래 record 로 했었는데 -> 상속을 못하네용
* 	null 을 반환하는게 좋을까 ? 아니면 NullOrderResult 처럼 현재 주문할 수 없어서 비어있는 결과의 OrderResult 를 나타내는 클래스를 따로 두는게 좋을까?
* */
public record OrderResult(int totalPrice, Collection<Coffee> coffees) {

}
