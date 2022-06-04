package domain.coffee;

public class NotExistException extends RuntimeException {
	public NotExistException(Class<?> clazz) {
		super(clazz.getSimpleName() + ": 해당 메뉴는 존재하지 않습니다.");
	}
}
