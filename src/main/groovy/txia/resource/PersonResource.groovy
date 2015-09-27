package txia.resource

import groovy.transform.Canonical

@Canonical
class PersonResource {
    Long id
    String firstName
    String lastName
    String userName
    Integer age
    Boolean isAdult
}
