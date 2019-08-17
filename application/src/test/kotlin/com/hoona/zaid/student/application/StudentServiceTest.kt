package com.hoona.zaid.student.application

import com.hoona.zaid.student.application.exception.StudentNotFoundException
import com.hoona.zaid.student.application.repo.StudentRepository
import com.hoona.zaid.student.domain.Student
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.*
import java.util.*
import kotlin.properties.Delegates

class StudentServiceTest {

    private var studentService: StudentService by Delegates.notNull()
    private var studentRepository: StudentRepository by Delegates.notNull()
    private val id = "0000"

    @Before
    fun setUp() {
        studentRepository = mock(StudentRepository::class.java)
        studentService = StudentService(studentRepository)
    }

    private fun stubStudent(): Student {
        return Student(id, "XXX", "YYY", "US")
    }

    @Test
    fun `should call student repository to get student by id`() {
        val student = stubStudent()
        doReturn(Optional.of(student)).`when`(studentRepository).findById(id)

        studentService.findStudentById(id)

        verify(studentRepository).findById(id)
    }


    @Test(expected = StudentNotFoundException::class)
    fun `should throw exception when no student is found`() {
        studentService.findStudentById("id")

        verify(studentRepository).findById("id")
    }
}
