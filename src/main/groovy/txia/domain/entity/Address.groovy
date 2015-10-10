package txia.domain.entity

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

    /* TODO: this throws the following error... not sure why

    Caused by: org.h2.jdbc.JdbcSQLException: Data conversion error converting "'PHYSICAL' (ADDRESS: ADDRESS_TYPE INTEGER)"; SQL statement:
    insert into address(id, address_line_one, address_line_two, city, state, zip_code, person_id, address_type)
    values(100, '8105 Fairy Lane', 'Apt 103', 'Alexandria', 'VA', '22309', 100, 'PHYSICAL') -- (100, '8105 Fairy Lane', 'Apt 103', 'Alexandria', 'VA', '22309', 100, 'PHYSICAL') [22018-187]

    AddressType addressType
    */

    String addressType

    @ManyToOne
    @JoinColumn(name='person_id')
    Person person
}

