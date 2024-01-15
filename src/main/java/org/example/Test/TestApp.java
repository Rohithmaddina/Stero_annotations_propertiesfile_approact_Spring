package org.example.Test;

import java.util.Arrays;
import java.util.Scanner;

import org.example.Vo.CustomerVo;
import org.example.controller.Maincontroller;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class TestApp {

	public static void main(String[] args) throws Exception {

		// Reading the inputs

		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the customerName:: ");
		String customerName = scanner.next();

		System.out.print("Enter the customerAddress:: ");
		String customerAddress = scanner.next();

		System.out.print("Enter the principalAmount:: ");
		String pamt = scanner.next();

		System.out.print("Enter the RateOfInterest:: ");
		String rate = scanner.next();

		System.out.print("Enter the TimePeriod:: ");
		String time = scanner.next();

		CustomerVo customerVO = new CustomerVo();
		customerVO.setCustomerName(customerName);
		customerVO.setCustomerAddress(customerAddress);
		customerVO.setPamt(pamt);
		customerVO.setRate(rate);
		customerVO.setTime(time);

		ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		System.out.println("************Container Started***************");
		System.out.println("Bean ids are :: " + Arrays.toString(factory.getBeanDefinitionNames()));


		Maincontroller controller = factory.getBean(Maincontroller.class);
		try {
			String result = controller.processCustomer(customerVO);
			System.out.println(result);
		} catch (Exception e) {
			System.out.println("Internal problem.. Try again....." + e.getMessage());
		}

		System.out.println("\n************Container Stopped***************");
		factory.close();
		scanner.close();
	}

}
