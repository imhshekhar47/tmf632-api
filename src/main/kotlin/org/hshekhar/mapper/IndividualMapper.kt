package org.hshekhar.mapper

import org.hshekhar.entity.IndividualEntity
import org.hshekhar.entity.IndividualRepository
import org.hshekhar.tmf632.models.Individual
import org.hshekhar.tmf632.models.IndividualCreate
import org.hshekhar.tmf632.models.IndividualUpdate
import org.hshekhar.util.APIBaseUrlConfig
import org.hshekhar.util.date
import org.hshekhar.util.toOffSetDateTime
import org.mapstruct.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component


/**
 * @created 10/22/2021'T'6:13 PM
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
abstract class IndividualMapper {

    fun linkTo(vararg tokens: String): String {
        return arrayOf(APIBaseUrlConfig.lookupBaseUrl(code = 632), *tokens)
            .joinToString("/")
    }

    /* DTO interchange */
    @Mappings(
        Mapping(target = "id", expression = "java(\"\")")
    )
    abstract fun mapCreateToDTO(dto: IndividualCreate): Individual

    //abstract fun mapUpdateToDTO(id: String, dto: IndividualUpdate): Individual

    @Mappings(
        value = [
            Mapping(target = "href", expression = "java(linkTo(\"individual\", entity.getId()))"),
            Mapping(
                target = "fullName",
                expression = "java(entity.getGivenName() + \" \" + entity.getMiddleName() + \" \" + entity.getFamilyName())"
            ),
            Mapping(
                target = "formattedName",
                expression = "java(entity.getFamilyName() + \",\" + entity.getMiddleName() + \",\" + entity.getGivenName())"
            )
        ]
    )
    abstract fun toDTO(entity: IndividualEntity): Individual

    abstract fun toEntity(dto: Individual): IndividualEntity
    /*
    fun toEntity(dto: Individual): IndividualEntity {
        return IndividualEntity(
            id = dto.id,
            title = dto.title,
            givenName = dto.givenName,
            middleName = dto.middleName,
            familyName = dto.familyName,
            placeOfBirth = dto.placeOfBirth,
            birthDate = dto.birthDate,
            deathDate = dto.deathDate?: date(2999, 12,31).toOffSetDateTime(),
            countryOfBirth = dto.countryOfBirth,
            nationality = dto.nationality,
            maritalStatus = dto.maritalStatus,
            location = dto.location,
            gender = dto.gender,
        )
    }*/
}