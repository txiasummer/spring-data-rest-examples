package txia.domain.entity

import groovy.transform.Canonical

import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
@Canonical
class Hobby {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    Long id

    String name

    String description

    @OneToMany(fetch = FetchType.LAZY, orphanRemoval = true, mappedBy = 'hobby', cascade = CascadeType.REMOVE)
    List<PersonalHobby> personalHobbies
}
