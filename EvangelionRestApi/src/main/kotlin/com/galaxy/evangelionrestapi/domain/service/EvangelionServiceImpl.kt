package com.galaxy.evangelionrestapi.domain.service

import com.galaxy.evangelionrestapi.data.repository.EvangelionRepository
import com.galaxy.evangelionrestapi.domain.model.Evangelion
import com.galaxy.evangelionrestapi.domain.service.util.Path.PICTURE_PATH
import com.galaxy.evangelionrestapi.web.service.EvangelionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class EvangelionServiceImpl(
    @Autowired
    private val repository: EvangelionRepository
): EvangelionService {
    override fun getByName(name: String): Evangelion {
        val eva = repository.findByName(name).also { it?.picture = PICTURE_PATH + it?.picture}
        return eva ?: throw NullPointerException("Evangelion not found")
    }

    override fun getEvangelions(): List<Evangelion> {
        return repository.findAll().onEach { it.picture = PICTURE_PATH + it.picture}
    }

    override fun getByPk(pk: Long): Evangelion {
        val eva = repository.findByPk(pk).also { it?.picture = PICTURE_PATH + it?.picture}
        return eva ?: throw NullPointerException("Evangelion not found")
    }
}