package co.com.compensar.model.person.gateways;

import co.com.compensar.model.person.Person;
import reactor.core.publisher.Mono;

public interface PersonRepository {
    Mono<Person> sendPerson(Person person);
}
