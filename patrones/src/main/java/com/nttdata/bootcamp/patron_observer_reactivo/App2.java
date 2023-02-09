package com.nttdata.bootcamp.patron_observer_reactivo;


import org.reactivestreams.Subscription;

import reactor.core.CoreSubscriber;
import reactor.core.publisher.Flux;

public class App2 {

	public static void main(String[] args) {
		
		Flux<String> flux = Flux.just("Cadena1", "Cadena2", "Cadena3", "Cadena4");
		
		flux.subscribe(
				m-> System.out.println("Consumer 1, received: " + m),
				e -> System.out.println("Algo ha salido mal "),
				() -> System.out.println("Completed")
				);
		
		flux.subscribe(
				m-> System.out.println("Consumer 2, received: " + m),
				e -> System.out.println("Algo ha salido mal "),
				() -> System.out.println("Completed")
				);
		
		

	}

}
