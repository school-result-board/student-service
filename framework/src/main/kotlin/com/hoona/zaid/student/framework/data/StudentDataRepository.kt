package com.hoona.zaid.student.framework.data

import com.hoona.zaid.student.application.exception.StudentNotFoundException
import com.hoona.zaid.student.application.repo.StudentRepository
import com.hoona.zaid.student.domain.Student
import com.hoona.zaid.student.framework.data.jpa.StudentJpaRepository
import com.hoona.zaid.student.framework.mapper.StudentMapper
import org.springframework.beans.BeanUtils
import java.util.*

class StudentDataRepository(
        private val studentJpaRepository: StudentJpaRepository,
        private val studentMapper: StudentMapper) : StudentRepository {

    override fun findById(id: String): Optional<Student> {
        val studentEntity = studentJpaRepository.findById(id)
        return studentEntity.map { studentMapper.toDomain(it) }
    }

    override fun saveStudent(student: Student): Student {
        val studentEntity = studentMapper.toEntity(student)
        val savedStudentEntity = studentJpaRepository.save(studentEntity)
        return studentMapper.toDomain(savedStudentEntity)
    }

    override fun deleteStudent(student: Student): Student {
        val studentEntity = studentJpaRepository.findById(student.id).orElseThrow { StudentNotFoundException(student.id) }
        studentJpaRepository.delete(studentEntity)
        return studentMapper.toDomain(studentEntity)
    }
}
