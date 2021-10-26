package org.hshekhar.entity

import org.hibernate.annotations.GenericGenerator
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

/**
 * @created 10/25/2021'T'5:05 PM
 * @author Himanshu Shekhar (609080540)
 **/

@Entity(name = "disability")
data class DiabilityEntity(
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Id
    var id: String? = null,
    @Column(unique = true)
    var disabilityCode: String,
    var disabilityName: String,
    var validFor: TimePeriodEntity? = null,
)