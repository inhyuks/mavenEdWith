package kr.or.connet.diexam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Car {
	@Autowired // 너가 알아서 생성객체를 주입해라
	private Engine v8;
	
	public Car() {
		System.out.println("Car 생성자!!");
	}

	public void setEngine(Engine e) {
		this.v8 = e;
	}
	
	public void run() {
		System.out.println("엔진을 이용하여 달립니다.");
		v8.exec();
	}
	
/*	public static void main(String[] arg) {
		
		Engine e = new Engine();
		Car c =new Car();
		c.setEngine(e);
		c.run();
		//ioc를 이용하지않은경우
	
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Car car = (Car)ac.getBean("c");
		car.run();
	}*/
}
