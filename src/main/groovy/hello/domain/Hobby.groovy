package hello.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Hobby {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id
    String name
    String description
}
