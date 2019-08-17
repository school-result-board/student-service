package com.hoona.zaid.student.config

import com.hoona.zaid.student.application.StudentService
import com.hoona.zaid.student.application.repo.StudentRepository
import com.hoona.zaid.student.framework.data.StudentDataRepository
import com.hoona.zaid.student.framework.data.jpa.StudentJpaRepository
import com.hoona.zaid.student.framework.mapper.StudentMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ApplicationConfig {

    @Bean
    fun studentService(studentRepository: StudentRepository): StudentService {
        return StudentService(studentRepository)
    }

    @Bean
    fun studentRepository(studentJpaRepository: StudentJpaRepository , studentMapper: StudentMapper): StudentRepository {
        return StudentDataRepository(studentJpaRepository, studentMapper)
    }

    @Bean
    fun studentMapper(): StudentMapper {
        return StudentMapper()
    }
}
