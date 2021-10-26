package org.hshekhar.entity

import org.hibernate.annotations.GenericGenerator
import org.springframework.data.jpa.repository.JpaRepository
import javax.persistence.*

/**
 * @created 10/22/2021'T'5:59 PM
 * @author Himanshu Shekhar (609080540)
 **/
@Entity(name = "organization")
data class OrganizationEntity(
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    val id: String? = null,
    val name: String,
    val nameType: String? = null,
    val isHeadOffice: Boolean = false,
    val isLegalEntity: Boolean = false,
    val organizationType: String? = null,
    val tradingName: String? = null,


    @OneToMany(cascade = [CascadeType.ALL])
    val relatedParty: List<RelatedPartyEntity>? = null,
    @OneToMany(cascade = [CascadeType.ALL])
    val contactMedium: List<ContactMediumEntity>? = null,

    /*
    val creditRating: List<Any>? = null,
    val existsDuring: Any? = null,
    val externalReference: List<Any>? = null,
    val organizationChildRelationship: List<Any>? = null,
    val organizationIdentification: List<Any>? = null,
    val organizationParentRelationship: List<Any>? = null,
    val otherName: List<Any>? = null,
    val partyCharacteristic: List<Any>? = null,
    val status: Any? = null,
    val taxExemptionCertificate: List<Any>? = null,
    */
)

interface OrganizationRepository : JpaRepository<OrganizationEntity, String>