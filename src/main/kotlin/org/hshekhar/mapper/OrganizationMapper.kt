package org.hshekhar.mapper

import org.hshekhar.entity.OrganizationEntity
import org.hshekhar.tmf632.models.Organization
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy

/**
 * @created 10/25/2021'T'9:29 AM
 * @author Himanshu Shekhar (609080540)
 **/

@Mapper(
    componentModel = "spring",
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    unmappedSourcePolicy = ReportingPolicy.IGNORE,
    uses = [
        RelatePartyMapper::class,
        ContactMediumMapper::class
    ]
)
abstract class OrganizationMapper {
    abstract fun toDTO(entity: OrganizationEntity): Organization
    abstract fun toEntity(dto: Organization): OrganizationEntity
}