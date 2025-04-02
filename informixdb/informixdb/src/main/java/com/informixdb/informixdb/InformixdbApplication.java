package com.informixdb.informixdb;

import com.informixdb.informixdb.Repository.CustomerRepository;
import com.informixdb.informixdb.entity.Customer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@SpringBootApplication
@RequiredArgsConstructor
public class InformixdbApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(InformixdbApplication.class, args);

	}


	private final CustomerRepository customerRepository;


	@Override
	@Transactional
	public void run(String... args) throws Exception {

		List<Customer> customerList = (List<Customer>) this.customerRepository.findAll();
		log.info("\n");
		log.info("Persona: " + customerList);
	}

}
