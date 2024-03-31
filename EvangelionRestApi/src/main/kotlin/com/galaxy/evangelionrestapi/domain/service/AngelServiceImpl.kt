package com.galaxy.evangelionrestapi.domain.service

import com.galaxy.evangelionrestapi.data.repository.AngelRepository
import com.galaxy.evangelionrestapi.domain.model.Angel
import com.galaxy.evangelionrestapi.domain.service.util.Path.PICTURE_PATH
import com.galaxy.evangelionrestapi.web.service.AngelService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AngelServiceImpl(
    @Autowired
    private val angelRepository: AngelRepository
): AngelService{
    override fun getAngels(): List<Angel> {
        return angelRepository.findAll().onEach { it.picture = PICTURE_PATH + it.picture }
    }

    override fun getByName(name: String): Angel {
        val angel = angelRepository.findByName(name).also { it?.picture = PICTURE_PATH + it?.picture}
        return angel ?: throw NullPointerException("Angel not found")
    }

    override fun getByPk(pk: Long): Angel {
        val angel = angelRepository.findByPk(pk).also { it?.picture = PICTURE_PATH + it?.picture}
        return angel ?: throw NullPointerException("Angel not found")
    }
}