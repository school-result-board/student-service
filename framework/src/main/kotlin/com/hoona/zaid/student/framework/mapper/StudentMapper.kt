package com.hoona.zaid.student.framework.mapper

import com.hoona.zaid.student.framework.data.entity.StudentEntity
import com.hoona.zaid.student.domain.Student

class StudentMapper: Mapper<StudentEntity, Student> {

    override fun toEntity(domain: Student): StudentEntity {
        val (id, firstName, lastName, address) = domain
        return StudentEntity(id, firstName, lastName, address)
    }

    override fun toDomain(entity: StudentEntity): Student {
        val (id, firstName, lastName, address) = entity
        return Student(id, firstName, lastName, address)
    }

}
