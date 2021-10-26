package org.hshekhar.entity

import java.time.OffsetDateTime
import javax.persistence.Embeddable

/**
 * @created 10/25/2021'T'5:02 PM
 * @author Himanshu Shekhar (609080540)
 **/

@Embeddable
data class TimePeriodEntity(
    var startDateTime: OffsetDateTime? = null,
    var endDateTime: OffsetDateTime? = null,
)