package org.hshekhar.entity

import org.hibernate.annotations.GenericGenerator
import javax.persistence.Embedded
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

/**
 * @created 10/25/2021'T'5:00 PM
 * @author Himanshu Shekhar (609080540)
 **/
@Entity(name = "party_credit_profile")
data class PartyCreditProfileEntity(
    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @GeneratedValue(generator = "uuid")
    var id: String? = null,
    var creditAgencyName: String? = null,
    var ratingReference: String? = null,
    var ratingScore: Int = 0,
    @Embedded
    var validFor: TimePeriodEntity? = null,
)