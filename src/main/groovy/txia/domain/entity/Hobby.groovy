package txia.domain.entity

import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
/*
    TODO: when I have the @Canonical tag here, the APIDocumentation tests throw the StackOverFlow error due to recursive calls to the toString() method. Need to fix that
    the actual API calls (when tested in POSTMAN does not throw errors). it is a problem with the RestAPI documentation plugin
 */
class Hobby {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    Long id

    String name

    String description

    @OneToMany(fetch = FetchType.LAZY, orphanRemoval = true, mappedBy = 'hobby', cascade = CascadeType.REMOVE)
    List<PersonalHobby> personalHobbies
}
