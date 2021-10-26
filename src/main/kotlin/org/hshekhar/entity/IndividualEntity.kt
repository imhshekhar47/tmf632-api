package org.hshekhar.entity

import org.hibernate.annotations.GenericGenerator
import org.hshekhar.tmf632.models.IndividualStateType
import org.springframework.data.jpa.repository.JpaRepository
import java.time.OffsetDateTime
import javax.persistence.*

/**
 * @created 10/22/2021'T'5:27 PM
 * @author Himanshu Shekhar (609080540)
 **/

@Entity(name = "individual")
data class IndividualEntity(
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    var id: String? = null,
    var title: String? = null,
    var givenName: String? = null,
    var middleName: String? = null,
    var familyName: String? = null,

    var placeOfBirth: String? = null,
    var birthDate: OffsetDateTime? = null,
    var deathDate: OffsetDateTime? = null,
    var countryOfBirth: String? = null,
    var nationality: String? = null,
    var maritalStatus: String? = null,
    var location: String? = null,
    var gender: String? = null,
    @OneToMany(cascade = [CascadeType.ALL])
    val relatedParty: List<RelatedPartyEntity> = mutableListOf(),
    @OneToMany(cascade = [CascadeType.ALL])
    val contactMedium: List<ContactMediumEntity> = mutableListOf(),
    @OneToMany(cascade = [CascadeType.ALL])
    val creditRating: List<PartyCreditProfileEntity> = mutableListOf(),
    @OneToMany(cascade = [CascadeType.ALL])
    val disability: List<DiabilityEntity> = mutableListOf(),
    @OneToMany(cascade = [CascadeType.ALL])
    val externalReference: List<ExternalReferenceEntity> = mutableListOf(),
    @OneToMany(cascade = [CascadeType.ALL])
    val skill: List<SkillEntity> = mutableListOf(),
    val status: String = IndividualStateType.initialized.value,
    /*
    // TODO
    val individualIdentification: List<Any>? = null,
    val languageAbility: List<Any>? = null,

    val partyCharacteristic: List<Any>? = null,

    val status: Any? = null,
    val taxExemptionCertificate: List<Any>? = null,
    */

    // Below can be ignored
    // val otherName: List<Any>? = null,
    // val formattedName: String? = null,
    // val generation: String? = null,
    // val familyNamePrefix: String? = null,
    // val aristocraticTitle: String? = null,
    // val fullName: String? = null, // not required
    // val legalName: String? = null, // not required
    // val preferredGivenName: String? = null,
)

interface IndividualRepository : JpaRepository<IndividualEntity, String>
