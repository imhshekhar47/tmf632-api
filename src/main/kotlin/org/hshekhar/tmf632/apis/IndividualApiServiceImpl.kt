package org.hshekhar.tmf632.apis

import org.hshekhar.entity.IndividualRepository
import org.hshekhar.error.EntityNotFoundError
import org.hshekhar.mapper.IndividualMapper
import org.hshekhar.tmf632.models.Individual
import org.hshekhar.tmf632.models.IndividualCreate
import org.hshekhar.tmf632.models.IndividualUpdate
import org.slf4j.LoggerFactory
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service

/**
 * @created 10/22/2021'T'4:32 PM
 * @author Himanshu Shekhar (609080540)
 **/

@Service
class IndividualApiServiceImpl(
    private val individualMapper: IndividualMapper,
    private val individualRepository: IndividualRepository,
) : IndividualApiService {

    companion object {
        private val LOG = LoggerFactory.getLogger(IndividualApiServiceImpl::class.java)
    }

    override fun createIndividual(individual: IndividualCreate): Individual {
        LOG.debug("entry: createIndividual($individual)")
        val entity = individualMapper.toEntity(individualMapper.mapCreateToDTO(individual))
        val savedEntity = individualRepository.save(entity)
        LOG.debug("exit: createIndividual()")
        return individualMapper.toDTO(savedEntity)
    }

    override fun deleteIndividual(id: String) {
        TODO("Not yet implemented")
    }

    override fun listIndividual(fields: String?, offset: Int?, limit: Int?): List<Individual> {
        LOG.debug("entry: listIndividual($fields, $offset, $limit)")
        val listOfIndividuals = individualRepository
            .findAll(PageRequest.of(offset ?: 0 / 10, limit ?: 10))
            .map { entity -> individualMapper.toDTO(entity) }
            .toList()
        LOG.debug("exit: listIndividual()")
        return listOfIndividuals
    }

    override fun patchIndividual(id: String, individual: IndividualUpdate): Individual {
        TODO("Not yet implemented")
    }

    override fun retrieveIndividual(id: String, fields: String?): Individual {
        LOG.debug("entry: retrieveIndividual($id, $fields)")
        val entity = individualRepository.findById(id)
        LOG.debug("exit: retrieveIndividual($id, $fields)")
        return if (entity.isEmpty) throw EntityNotFoundError() else individualMapper.toDTO(entity.get())
    }
}