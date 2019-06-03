package kr.or.connet.diexam;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextExam04 {
	public static void main(String[] arg) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig2.class);
		
		Car car = (Car) ac.getBean(Car.class);
		car.run();
	}
}
