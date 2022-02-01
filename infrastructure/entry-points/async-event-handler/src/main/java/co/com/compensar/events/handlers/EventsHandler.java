package co.com.compensar.events.handlers;

import co.com.compensar.model.person.Person;
import co.com.compensar.usecase.person.PersonUseCase;
import lombok.AllArgsConstructor;
import org.reactivecommons.api.domain.DomainEvent;
import org.reactivecommons.async.impl.config.annotations.EnableEventListeners;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@EnableEventListeners
public class EventsHandler {
    private final PersonUseCase personUseCase;


    public Mono<Void> handleEventA(DomainEvent<Person> event) {
        System.out.println("event received: " + event.getName() + " ->" + event.getData());
        //return personUseCase.getEvent(event.getData(), event.getEventId());
        return Mono.empty();
    }
}
