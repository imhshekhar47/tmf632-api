package org.hshekhar.entity

import org.hibernate.annotations.GenericGenerator
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

/**
 * @created 10/25/2021'T'8:50 AM
 * @author Himanshu Shekhar (609080540)
 **/

@Entity(name = "medium_characteristic")
data class MediumCharacteristicEntity(
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Id
    var id: String? = null,
    var city: String? = null,
    var contactType: String? = null,
    var country: String? = null,
    var emailAddress: String? = null,
    var faxNumber: String? = null,
    var phoneNumber: String? = null,
    var postCode: String? = null,
    var socialNetworkId: String? = null,
    var stateOrProvince: String? = null,
    var street1: String? = null,
    var street2: String? = null,

    var atType: String? = null,
)