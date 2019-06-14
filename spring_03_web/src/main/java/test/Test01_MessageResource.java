package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.biz.user.service.UserService;

public class Test01_MessageResource { 

	public static void main(String[] args) { 
		String[] config = {"applicationContext.xml"};
		ApplicationContext context = 
				new ClassPathXmlApplicationContext(config);
		
		//System.out.println(context.getMessage("hello", null, Locale.ENGLISH));
		//System.out.println(context.getMessage("hello", null, Locale.KOREA));
		
		//String msg = context.getMessage("login.success", new Object[] {"java01"}, Locale.KOREA);
		//로그인성공 ~~~ ^_^java01 <-login.success값 뒤에 Object[] arg값을 받는다.
		//System.out.println(msg);
		
		UserService service = 
				(UserService)context.getBean("us");
		
		service.login("admin", "a1234");
		//UserVO vo = service.login("admin", "a1234");
		//System.out.println("====================");
		//System.out.println(vo);
	}

}
