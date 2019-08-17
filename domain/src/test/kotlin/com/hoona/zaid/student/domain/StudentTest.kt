package com.hoona.zaid.student.domain

import org.assertj.core.api.Assertions
import org.junit.Test

class StudentTest {
    @Test
    fun should_create_student() {
        val student = Student("1", "John", "Wick", "USA")
        Assertions.assertThat(student).isNotNull
        Assertions.assertThat(student.firstName).isEqualTo("John")
        Assertions.assertThat(student.lastName).isEqualTo("Wick")
        Assertions.assertThat(student.address).isEqualTo("USA")
        Assertions.assertThat(student.id).isEqualTo("1")
    }
}


