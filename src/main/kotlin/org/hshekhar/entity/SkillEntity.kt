package org.hshekhar.entity

import org.hibernate.annotations.GenericGenerator
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

/**
 * @created 10/25/2021'T'5:11 PM
 * @author Himanshu Shekhar (609080540)
 **/

@Entity(name = "skill")
data class SkillEntity(
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Id
    var skillCode: String,
    var skillName: String,
    var comment: String? = null,
    var evaluatedLevel: String? = null,
    var validFor: TimePeriodEntity? = null,
)