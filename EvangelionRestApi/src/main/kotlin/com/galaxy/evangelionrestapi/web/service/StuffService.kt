package com.galaxy.evangelionrestapi.web.service

import com.galaxy.evangelionrestapi.domain.model.Stuff

interface StuffService {
    fun getStuff(): List<Stuff>
    fun geByName(name: String): Stuff
    fun getByPk(pk: Long): Stuff
}