package org.hshekhar.mapper

import org.hshekhar.entity.RelatedPartyEntity
import org.hshekhar.tmf632.models.RelatedParty
import org.hshekhar.util.APIBaseUrlConfig
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings
import org.mapstruct.ReportingPolicy

/**
 * @created 10/22/2021'T'7:04 PM
 * @author Himanshu Shekhar (609080540)
 **/

@Mapper(
    componentModel = "spring",
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    unmappedSourcePolicy = ReportingPolicy.IGNORE
)
abstract class RelatePartyMapper {

    protected fun linkTo(vararg tokens: String): String {
        return arrayOf(APIBaseUrlConfig.lookupBaseUrl(code = 632), *tokens)
            .joinToString("/")
    }

    abstract fun toEntity(dto: RelatedParty): RelatedPartyEntity

    @Mappings(value = [
        Mapping(target = "href", expression = "java(linkTo(entity.getAtReferredType(), entity.getId()))")
    ])
    abstract fun toDTO(entity: RelatedPartyEntity): RelatedParty
}