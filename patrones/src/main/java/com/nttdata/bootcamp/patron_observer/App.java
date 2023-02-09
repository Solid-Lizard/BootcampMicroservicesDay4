package com.nttdata.bootcamp.patron_observer;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	/* Para esta práctica, vamos a aplicar el patrón observador
    	 * en este caso vamos a utilizar dos objetos, el observador
    	 * y el observable
    	 */
    	
    	/*
    	 * El observador es el elemento en nuestor código que 
    	 * se encarga de, como su nombre indica, observar todos los
    	 * observables suscritos a el.
    	 * 
    	 * Cada uno de estos métodos se ejecutan dependiendo del ciclo de vida
    	 * del objeto.
    	 * 
    	 */
    	Observer obs = new Observer() {

			@Override
			public void onSubscribe(Disposable d) {
				// Se ejecuta al suscribirse un observale
				System.out.println("Objeto suscrito");
				
			}

			@Override
			public void onNext(Object t) {
				// Se ejecuta cada vez que el observador reciba un objeto que observar
				// por parte del observable
				System.out.println("onNext() cadena: " + t);
				
			}

			@Override
			public void onError(Throwable e) {
				// Se ejecuta cada vez que se produzca un error
				
			}

			@Override
			public void onComplete() {
				// Se ejecuta cuando un observable ha terminado de enviar objetos al observador
				System.out.println("Observable completado");
				
			}};
    	
    	/*
    	 * El observable es el objeto que se suscribe a un oservador y envía los distintos parámetros
    	 * que este debe observar.
    	 */
    	Observable stringObservable = Observable.create(emitter -> {
    		// Enviamos los objetos a través del método onNext()
			emitter.onNext("Cadena1");
			emitter.onNext("Cadena2");
			emitter.onNext("Cadena3");
			emitter.onNext("Cadena4");
			
			// Una vez terminada la comunicación, ejecutamos el método
			// onComplete para finalizarla correctamente
			emitter.onComplete();
			
		});
    	
    	// Sejundo ejemplo de observable
    	Observable stringObservable2 = Observable.create(emitter -> {
			emitter.onNext("Cadena1");
			emitter.onNext("Cadena2");
			emitter.onNext("Cadena3");
			emitter.onNext("Cadena4");
			emitter.onComplete();
			
		});
    	
    	
    	
    		    	
			stringObservable.subscribe(obs);
			stringObservable2.subscribe(obs);
    		
    }
}
