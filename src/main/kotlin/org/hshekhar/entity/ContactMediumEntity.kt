package org.hshekhar.entity

import org.hibernate.annotations.GenericGenerator
import javax.persistence.*

/**
 * @created 10/25/2021'T'8:50 AM
 * @author Himanshu Shekhar (609080540)
 **/

@Entity(name = "contact_medium")
data class ContactMediumEntity(
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Id
    var id: String? = null,
    var mediumType: String? = null,
    var preferred: Boolean? = false,
    @OneToOne(cascade = [CascadeType.ALL])
    var characteristic: MediumCharacteristicEntity? = null,

    var atType: String? = null
)