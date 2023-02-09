package com.nttdata.bootcamp.webflux.controller;

import java.time.Duration;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.bootcamp.webflux.subscribers.Subscriber;

import reactor.core.publisher.Flux;

@RestController
public class Controller {
	@GetMapping (path="/numbers", produces="text/event-stream")
	public Flux<Integer> numbers() {
				
		//Flux flux = Flux.interval(Duration.ofSeconds(1), Duration.ofSeconds(1)).take(Duration.ofSeconds(31));
		
		Flux flux = Flux.range(1, 30).delayElements(Duration.ofSeconds(1));
		
		return flux; // Este se convierte en un observador del flux que nos permite evaluar su funcionamiento
		
	}
	
	@GetMapping (path="/numbers-with-subscribers", produces="text/event-stream")
	public Flux<Integer> numbersWithSubscribers() {
		Flux <Integer> flux = Flux.range(1, 30).delayElements(Duration.ofSeconds(1));
		
		// El flux en el primer subscriber va en un hilo distinto al segundo y al tercero, al estar 
		// atrasado con thread.sleep, tarda más tiempo en entregar todos los datos.
		flux.subscribe(n -> Subscriber.print(n));
		
		// En este subscriber el flux actua de manera normal y se muestra por pantalla
		flux.subscribe(n -> System.out.println("Subscriptor 2: " + n));
		
		return flux; // Subscriber del ejemplo anterior
	}

}
