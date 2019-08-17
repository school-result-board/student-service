package com.hoona.zaid.student.framework.data

import com.hoona.zaid.student.framework.data.entity.StudentEntity
import com.hoona.zaid.student.framework.data.jpa.StudentJpaRepository
import com.hoona.zaid.student.framework.mapper.StudentMapper
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.*
import java.util.*
import kotlin.properties.Delegates


class StudentDataRepositoryTest {

    private var studentDataRepository: StudentDataRepository by Delegates.notNull()
    private var studentJpaRepository: StudentJpaRepository by Delegates.notNull()
    private var studentMapper: StudentMapper by Delegates.notNull()

    @Before
    fun setup() {
        studentJpaRepository = mock(StudentJpaRepository::class.java)
        studentMapper = mock(StudentMapper::class.java)
        studentDataRepository = StudentDataRepository(studentJpaRepository, studentMapper)
    }

    private fun stubStudentEntity(): StudentEntity {
        return StudentEntity("0000", "XXX", "YYY", "US")
    }

    @Test
    fun `should call StudentJpaRepository to find student by id`() {
        val stubEntity = stubStudentEntity()
        val studentId = stubEntity.id
        doReturn(Optional.of(stubEntity)).`when`(studentJpaRepository).findById("0000")

        studentDataRepository.findById(studentId)

        verify(studentJpaRepository).findById(studentId)
        verify(studentMapper).toDomain(stubEntity)
    }
}
