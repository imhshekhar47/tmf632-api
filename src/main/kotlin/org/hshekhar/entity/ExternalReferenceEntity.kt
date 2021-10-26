package org.hshekhar.entity

import org.hibernate.annotations.GenericGenerator
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

/**
 * @created 10/25/2021'T'5:09 PM
 * @author Himanshu Shekhar (609080540)
 **/
@Entity(name = "external_reference")
data class ExternalReferenceEntity(
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Id
    var id: String? = null,
    var externalReferenceType: String,
    var name: String
)