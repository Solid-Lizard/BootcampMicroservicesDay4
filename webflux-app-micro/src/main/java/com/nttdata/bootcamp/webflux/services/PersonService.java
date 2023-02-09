package com.nttdata.bootcamp.webflux.services;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.nttdata.bootcamp.server.controller.Person;

import reactor.core.publisher.Flux;

@Component
public class PersonService {
	WebClient client1 = WebClient.create("http://localhost:8080/person-list-1");
	WebClient client2 = WebClient.create("http://localhost:8080/person-list-2");
	WebClient client3 = WebClient.create("http://localhost:8080/person-list-3");
	WebClient client4 = WebClient.create("http://localhost:8080/person-list-4");
	
	public Flux<Person> allPersons() {
		@SuppressWarnings("unchecked")
		Flux<Person> flux = client1.get().retrieve().bodyToFlux(Person.class);
		
		Flux<Person> allPersons = Flux.merge(client1.get().retrieve().bodyToFlux(Person.class), client2.get().retrieve().bodyToFlux(Person.class),
				client3.get().retrieve().bodyToFlux(Person.class), client4.get().retrieve().bodyToFlux(Person.class));
		
		return allPersons;
	}
	
}
