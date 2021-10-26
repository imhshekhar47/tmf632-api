package org.hshekhar.tmf632.apis

import org.hshekhar.entity.OrganizationRepository
import org.hshekhar.mapper.OrganizationMapper
import org.hshekhar.tmf632.models.Organization
import org.hshekhar.tmf632.models.OrganizationCreate
import org.hshekhar.tmf632.models.OrganizationUpdate
import org.slf4j.LoggerFactory
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service

/**
 * @created 10/22/2021'T'5:08 PM
 * @author Himanshu Shekhar (609080540)
 **/

@Service
class OrganizationApiServiceImpl(
    private val organizationMapper: OrganizationMapper,
    private val organizationRepository: OrganizationRepository
) : OrganizationApiService {
    companion object {
        private val LOG = LoggerFactory.getLogger(OrganizationApiServiceImpl::class.java)
    }

    override fun createOrganization(organization: OrganizationCreate): Organization {
        TODO("Not yet implemented")
    }

    override fun deleteOrganization(id: String) {
        TODO("Not yet implemented")
    }

    override fun listOrganization(fields: String?, offset: Int?, limit: Int?): List<Organization> {
        LOG.debug("entry: listOrganization($fields, $offset, $limit)")
        val organizations = organizationRepository
            .findAll(PageRequest.of(offset?:0 ,limit?: 15))
            .map { entity -> organizationMapper.toDTO(entity) }
            .toList()
        LOG.debug("exit: listOrganization()")
        return organizations
    }

    override fun patchOrganization(id: String, organization: OrganizationUpdate): Organization {
        TODO("Not yet implemented")
    }

    override fun retrieveOrganization(id: String, fields: String?): Organization {
        TODO("Not yet implemented")
    }
}