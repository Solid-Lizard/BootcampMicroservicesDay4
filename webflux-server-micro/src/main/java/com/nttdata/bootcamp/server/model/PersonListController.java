package com.nttdata.bootcamp.server.model;

import java.time.Duration;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.bootcamp.server.controller.Person;

import reactor.core.publisher.Flux;

@RestController
public class PersonListController {
	@GetMapping(path = "/person-list-1", produces="text/event-stream")
	public Flux<Person> personList1() {	
		Flux<Person> flux = Flux.just(new Person ("Santiago", "López", 19), 
				new Person ("Bruce", "Wayne", 30)).delaySequence(Duration.ofSeconds(2));
		
		return flux;
	}
	
	@GetMapping(path = "/person-list-2", produces="text/event-stream")
	public Flux<Person> personList2() {				
		Flux<Person> flux = Flux.just(new Person ("Clark", "Kent", 32), 
				new Person ("Peter", "Parker", 22)).delaySequence(Duration.ofSeconds(4));
		return flux;
	}
	
	@GetMapping(path = "/person-list-3", produces="text/event-stream")
	public Flux<Person> personList3() {				
		Flux<Person> flux = Flux.just(new Person ("Matt", "Murdock", 35), 
				new Person ("Frank", "Castle", 42)).delaySequence(Duration.ofSeconds(6));
		
		return flux;
	}
	
	@GetMapping(path = "/person-list-4", produces="text/event-stream")
	public Flux<Person> personList4() {				
		Flux<Person> flux = Flux.just(new Person ("Anakin", "Skywalker", 42), 
				new Person ("Obi-wan", "Kenobi", 60)).delaySequence(Duration.ofSeconds(8));
		
		return flux;
	}
}
