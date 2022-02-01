package co.com.compensar.usecase.person;

import co.com.compensar.model.person.Person;
import co.com.compensar.model.person.gateways.PersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Log
public class PersonUseCase {
    private final PersonRepository personRepository;

    public Mono<Void> getEvent(Person person, String id){
        return Mono.empty();

    }
    public  Mono<Person> getPerson (Person person){
        log.info("PersonUseCase getPerson " + person);
        return Mono.just(person)
                .flatMap(personRepository::sendPerson)
                .doOnNext(person1 -> log.info("Llegada desde handler: " + person1))
                .thenReturn(person);
    }
}
