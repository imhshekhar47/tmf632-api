package org.hshekhar.util

import java.time.LocalDate
import java.time.OffsetDateTime
import java.time.ZoneOffset
import java.util.*

/**
 * @created 10/22/2021'T'6:32 PM
 * @author Himanshu Shekhar (609080540)
 **/

fun date(year: Int, month: Int, dayOfMonth: Int) = Date(LocalDate.of(year, month, dayOfMonth)
    .atStartOfDay()
    .toInstant(ZoneOffset.UTC)
    .toEpochMilli())

fun Date.toOffSetDateTime(): OffsetDateTime = this.toInstant().atOffset(ZoneOffset.UTC)

fun OffsetDateTime.toDate(): Date = this.toDate()