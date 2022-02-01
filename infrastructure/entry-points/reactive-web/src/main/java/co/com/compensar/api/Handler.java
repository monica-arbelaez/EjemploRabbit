package co.com.compensar.api;

import co.com.compensar.api.dto.PersonDTO;
import co.com.compensar.usecase.person.PersonUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import factory.MapperObjet;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
@Log
public class Handler implements MapperObjet {
    private final PersonUseCase personUseCase;



    public Mono<ServerResponse> listenPersonUseCase(ServerRequest serverRequest) {
        return Mono.just(serverRequest)
                .flatMap(serverRequest1 -> serverRequest1.bodyToMono(PersonDTO.class))
                .map(this::dtoToModel)
                .flatMap(personUseCase::getPerson)
                .then(ServerResponse.ok().bodyValue("ok"));
    }


}
