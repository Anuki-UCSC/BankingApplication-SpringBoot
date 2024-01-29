package com.anucode.banking;

import com.anucode.banking.dataAccess.CustomerDataAccess;
import com.anucode.banking.services.CustomerService;
import com.anucode.banking.services.TransferService;
import com.anucode.banking.views.BankServiceView;
import com.anucode.banking.views.CustomerView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BankingApplication implements CommandLineRunner {

	private static Logger logger = LoggerFactory.getLogger(BankingApplication.class);
	private static CustomerService customerService;

	public BankingApplication(CustomerService customerService) {
		this.customerService = customerService;
	}

	public static void main(String[] args) throws Exception {
		ApplicationContext applicationContext = SpringApplication.run(BankingApplication.class, args);
		logger.info("\n--------------------------BANKING APPLICATION---------------------------------");
		System.out.println("------ Welcome to Mobile Banking -------");

		//call customer details view
		CustomerView customerView = new CustomerView(customerService);
		boolean valid = customerView.askCustomerDetails();

		if (valid) {
			// call bank services view
			BankServiceView bankServiceView = new BankServiceView();
			bankServiceView.provideListOfBankServicesToChoose();
		}
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("---------------anucode.banking------------------");

	}
}
