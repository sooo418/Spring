package spring.tv;

public class TvFactory {
	//spring의 역할 
		//객체들을 생성하는 공장같은 개념
	public static TV getLgTV() {
		return new LgTV();
	}

	public static TV getSamsungTV() {
		return new SamsungTV();
	}

	public static Object getBean(String beanName) {
		if(beanName.equals("samsung")) {
			return new SamsungTV();
		}else {
			return new LgTV();
		}
	}
}
