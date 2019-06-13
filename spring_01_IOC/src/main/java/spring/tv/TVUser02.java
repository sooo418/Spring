package spring.tv;

public class TVUser02 {

	public static void main(String[] args) {
		TV user = (TV)TvFactory.getBean("lg");
		user.on();
	}

}
