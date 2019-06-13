package spring.tv;

import java.util.Calendar;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class TVUser04 {
	public static void main(String[] args) {
		String config = "applicationContext.xml";
		//BeanFactory factory = 
			//new XmlBeanFactory(new ClassPathResource(config));
		
		ApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext(config);
		TV user = (TV) applicationContext.getBean("lg");
		user.on();
		
		TV user2 = (TV) applicationContext.getBean("lg",TV.class);
		user2.on();
		
		System.out.println("singletone ? "+(user==user2)); //user와 user2는 같다. 즉 user와 user2는 메모리에 
		//id값이"lg"인 객체 하나를 나타낸다.
		
		Calendar now = (Calendar) applicationContext.getBean("now");
		Calendar.getInstance();
	}
}
