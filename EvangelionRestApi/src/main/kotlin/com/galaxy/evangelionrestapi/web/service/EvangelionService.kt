package com.galaxy.evangelionrestapi.web.service

import com.galaxy.evangelionrestapi.domain.model.Evangelion

interface EvangelionService {
    fun getByName(name: String): Evangelion
    fun getEvangelions(): List<Evangelion>
    fun getByPk(pk: Long): Evangelion
}