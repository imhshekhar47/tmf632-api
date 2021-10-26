package org.hshekhar.mapper

import org.hshekhar.entity.MediumCharacteristicEntity
import org.hshekhar.tmf632.models.MediumCharacteristic
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy

/**
 * @created 10/25/2021'T'9:26 AM
 * @author Himanshu Shekhar (609080540)
 **/

@Mapper(
    componentModel = "spring",
    unmappedSourcePolicy = ReportingPolicy.IGNORE,
    unmappedTargetPolicy = ReportingPolicy.IGNORE
)
abstract class MediumCharacteristicMapper {

    abstract fun toDTO(mediumCharacteristic: MediumCharacteristicEntity): MediumCharacteristic
    abstract fun toEntity(mediumCharacteristic: MediumCharacteristic): MediumCharacteristicEntity
}