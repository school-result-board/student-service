package com.hoona.zaid.student.application

import com.hoona.zaid.student.application.exception.StudentNotFoundException
import com.hoona.zaid.student.application.repo.StudentRepository
import com.hoona.zaid.student.domain.Student

class StudentService(private val studentRepository: StudentRepository) {

    @Throws(StudentNotFoundException::class)
    fun findStudentById(id: String): Student {
        val student = studentRepository.findById(id)
        return student.orElseThrow { StudentNotFoundException(id) }
    }

    fun createStudent(student: Student): Student {
        return studentRepository.saveStudent(student)
    }

    @Throws(StudentNotFoundException::class)
    fun updateStudent(student: Student): Student {
        val fetchedStudent = studentRepository.findById(student.id).orElseThrow { StudentNotFoundException(student.id) }
        val updatedStudent = fetchedStudent.copy(firstName = student.firstName, lastName = student.lastName, address = student.address)
        return studentRepository.saveStudent(updatedStudent)
    }

    @Throws(StudentNotFoundException::class)
    fun deleteStudent(id: String): Student {
        val fetchedStudent = studentRepository.findById(id).orElseThrow { StudentNotFoundException(id) }
        return studentRepository.deleteStudent(fetchedStudent)
    }
}
