package txia.domain

import groovy.transform.Canonical

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity
@Canonical
class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id

    String addressLineOne

    String addressLineTwo

    String city

    String state

    String zipCode

    @ManyToOne
    @JoinColumn(name='person_id')
    Person person
}
