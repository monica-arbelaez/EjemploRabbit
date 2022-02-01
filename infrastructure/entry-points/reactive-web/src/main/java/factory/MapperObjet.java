package factory;

import co.com.compensar.api.dto.PersonDTO;
import co.com.compensar.model.person.Person;


public interface MapperObjet {

    default Person dtoToModel(PersonDTO personDTO) {
        return Person.builder()
                .name(personDTO.getNombre())
                .mail(personDTO.getCorreo())
                .build();
    }
}
