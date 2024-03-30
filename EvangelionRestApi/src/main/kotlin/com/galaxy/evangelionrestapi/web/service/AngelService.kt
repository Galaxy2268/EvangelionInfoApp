package com.galaxy.evangelionrestapi.web.service

import com.galaxy.evangelionrestapi.domain.model.Angel

interface AngelService {
    fun getAngels(): List<Angel>
    fun getByName(name: String): Angel
    fun getByPk(pk: Long): Angel
}