// src/main/java/com/melibootcamp/DtoDeportes/DtoDeportesApplication.java
package com.melibootcamp.DtoDeportes;

import com.melibootcamp.DtoDeportes.entity.Person;
import com.melibootcamp.DtoDeportes.entity.Sport;
import com.melibootcamp.DtoDeportes.repository.PersonRepository;
import com.melibootcamp.DtoDeportes.repository.SportRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class DtoDeportesApplication {

	public static void main(String[] args) {
		SpringApplication.run(DtoDeportesApplication.class, args);

		// Create sports
		Sport soccer = new Sport("Football","high");
		Sport basketball = new Sport("Basketball","high");
		Sport tennis = new Sport("Tennis","high");
		Sport swimming = new Sport("Swimming","high");
		Sport running = new Sport("Running", "high");

		// Add sports to repository
		SportRepository.addSport(soccer);
		SportRepository.addSport(basketball);
		SportRepository.addSport(tennis);
		SportRepository.addSport(swimming);
		SportRepository.addSport(running);

		// Create persons
		Person person1 = new Person("pepe", "martin", 22);
		Person person2 = new Person("sol", "sanchez", 32);
		Person person3 = new Person("brenda", "martinez", 42);
		Person person4 = new Person( "Bob", "bomba",25);

		person2.addSport(basketball);
		person2.addSport(swimming);
		person1.addSport(soccer);
		person1.addSport(tennis);
		person3.addSport(running);
		person4.addSport(running);

		// Add persons to repository
		PersonRepository.addPerson(person1);
		PersonRepository.addPerson(person2);
		PersonRepository.addPerson(person3);
		PersonRepository.addPerson(person4);
	}
}