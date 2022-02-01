package co.com.compensar.events;

import co.com.compensar.events.handlers.EventsHandler;
import co.com.compensar.model.person.Person;
import org.reactivecommons.async.api.HandlerRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HandlerRegistryConfiguration {

    // see more at: https://reactivecommons.org/reactive-commons-java/#_handlerregistry_2
    @Bean
    public HandlerRegistry handlerRegistry( EventsHandler events) {
        return HandlerRegistry.register()
                .listenEvent("person.event", events::handleEventA, Person.class);
//                .listenEvent("some.event.name", events::handleEventA, Object.class/*change for proper model*/)
//                .handleCommand("some.command.name", commands::handleCommandA, Object.class/*change for proper model*/)
//                .serveQuery("some.query.name", queries::handleQueryA, Object.class/*change for proper model*/);
    }
}
