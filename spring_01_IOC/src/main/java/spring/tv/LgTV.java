package spring.tv;

public class LgTV implements TV{
	public LgTV(){
		System.out.println("LgTV() 생성");
	}
	@Override
	public void on() {
		System.out.println("LgTV on");
	}

	@Override
	public void off() {
		System.out.println("LgTV off");
	}
	public void init() {
		System.out.println("LgTV init() 초기화작업");
	}
	public void destory() {
		System.out.println("LgTV destory() 자원 반납...");
	}
}
