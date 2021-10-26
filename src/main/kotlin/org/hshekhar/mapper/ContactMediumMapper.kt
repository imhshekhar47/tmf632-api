package org.hshekhar.mapper

import org.hshekhar.entity.ContactMediumEntity
import org.hshekhar.tmf632.models.ContactMedium
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy

/**
 * @created 10/25/2021'T'9:26 AM
 * @author Himanshu Shekhar (609080540)
 **/

@Mapper(
    componentModel = "spring",
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    unmappedSourcePolicy = ReportingPolicy.IGNORE,
    uses = [
        MediumCharacteristicMapper::class
    ]
)
abstract class ContactMediumMapper {
    abstract fun toDTO(entity: ContactMediumEntity): ContactMedium
    abstract fun toEntity(dto: ContactMedium): ContactMediumEntity
}