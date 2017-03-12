package it.coderunner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import it.coderunner.dao.CarDAO;
import it.coderunner.dao.PersonDAO;
import it.coderunner.model.Car;
import it.coderunner.model.Person;

public class SpringHibernateMain {
	
	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

		PersonDAO personDAO = context.getBean(PersonDAO.class);

		Person person = new Person();
		person.setName("Michał");
		person.setCountry("Poland");

		personDAO.save(person);

		System.out.println("Person::" + person);

		personDAO.list().forEach(System.out::println);

				
		
		CarDAO carDAO = context.getBean(CarDAO.class);

		Car car = new Car();
		car.setName("Ferrari");
		car.setCountry("Italy");
		car.setYear(2013);

		carDAO.save(car);

		System.out.println("Car::" + car);

		carDAO.list().forEach(System.out::println);
		
		context.close();

	}

}
