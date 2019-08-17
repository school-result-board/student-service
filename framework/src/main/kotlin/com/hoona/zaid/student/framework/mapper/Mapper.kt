package com.hoona.zaid.student.framework.mapper

interface Mapper<ENTITY, DOMAIN> {
    fun toDomain(entity: ENTITY): DOMAIN
    fun toEntity(domain: DOMAIN): ENTITY
}
