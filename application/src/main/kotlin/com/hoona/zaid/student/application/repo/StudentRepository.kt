package com.hoona.zaid.student.application.repo

import com.hoona.zaid.student.domain.Student
import java.util.*

interface StudentRepository {
    fun findById(id: String): Optional<Student>
    fun saveStudent(student: Student): Student
    fun deleteStudent(student: Student): Student
}
