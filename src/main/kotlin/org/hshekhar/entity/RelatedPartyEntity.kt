package org.hshekhar.entity

import org.hibernate.annotations.GenericGenerator
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

/**
 * @created 10/22/2021'T'6:07 PM
 * @author Himanshu Shekhar (609080540)
 **/
@Entity(name = "related_party")
data class RelatedPartyEntity(
    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @GeneratedValue(generator = "uuid")
    var id: String? = null,
    var name: String? = null,
    var role: String? = null,

    var atReferredType: String,
)