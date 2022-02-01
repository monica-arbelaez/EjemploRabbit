package co.com.compensar.events;

import co.com.compensar.model.events.gateways.EventsGateway;
import co.com.compensar.model.person.Person;
import co.com.compensar.model.person.gateways.PersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.reactivecommons.api.domain.DomainEvent;
import org.reactivecommons.api.domain.DomainEventBus;
import org.reactivecommons.async.impl.config.annotations.EnableDomainEventBus;
import reactor.core.publisher.Mono;

import java.util.UUID;
import java.util.logging.Level;

import static reactor.core.publisher.Mono.from;

@Log
@RequiredArgsConstructor
@EnableDomainEventBus
public class ReactiveEventsGateway implements EventsGateway, PersonRepository {
    public static final String SOME_EVENT_NAME = "some.event.name";
    public static final String PERSON_ROUTING_KEY = "person.event";
    private final DomainEventBus domainEventBus;


    @Override
    public Mono<Void> emit(Object event) {
        log.log(Level.INFO, "Sending domain event: {0}: {1}", new String[]{SOME_EVENT_NAME, event.toString()});
        return from(domainEventBus.emit(new DomainEvent<>(SOME_EVENT_NAME, UUID.randomUUID().toString(), event)));
    }

    @Override
    public Mono<Person> sendPerson(Person person) {
        return from(domainEventBus.emit(new DomainEvent<>(PERSON_ROUTING_KEY, UUID.randomUUID().toString(), person)))
                .then(Mono.just(person));
    }

}
