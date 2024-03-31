package com.galaxy.evangelionrestapi.domain.service

import com.galaxy.evangelionrestapi.data.repository.StuffRepository
import com.galaxy.evangelionrestapi.domain.model.Stuff
import com.galaxy.evangelionrestapi.domain.service.util.Path.PICTURE_PATH
import com.galaxy.evangelionrestapi.web.service.StuffService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class StuffServiceImpl(
    @Autowired
    private val stuffRepository: StuffRepository
): StuffService {
    override fun getStuff(): List<Stuff> {
        return stuffRepository.findAll().onEach { it.picture = PICTURE_PATH + it.picture }
    }

    override fun geByName(name: String): Stuff {
        val stuff = stuffRepository.findByName(name).also { it?.picture = PICTURE_PATH + it?.picture}
        return stuff ?: throw NullPointerException("Stuff not found")
    }

    override fun getByPk(pk: Long): Stuff {
        val stuff = stuffRepository.findByPk(pk).also { it?.picture = PICTURE_PATH + it?.picture}
        return stuff ?: throw NullPointerException("Stuff not found")
    }
}