package com.galaxy.evangelionrestapi.domain.service

import com.galaxy.evangelionrestapi.data.repository.StuffRepository
import com.galaxy.evangelionrestapi.domain.model.Stuff
import com.galaxy.evangelionrestapi.web.service.StuffService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class StuffServiceImpl(
    @Autowired
    private val stuffRepository: StuffRepository
): StuffService {
    override fun getStuff(): List<Stuff> {
        return stuffRepository.findAll()
    }

    override fun geByName(name: String): Stuff {
        val stuff = stuffRepository.findByName(name)
        return stuff ?: throw NullPointerException("Stuff not found")
    }

    override fun getByPk(pk: Long): Stuff {
        val stuff = stuffRepository.findByPk(pk)
        return stuff ?: throw NullPointerException("Stuff not found")
    }
}