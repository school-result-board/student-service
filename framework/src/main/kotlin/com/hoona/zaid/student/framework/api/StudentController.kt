package com.hoona.zaid.student.framework.api

import com.hoona.zaid.student.application.StudentService
import com.hoona.zaid.student.domain.Student
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/student")
class StudentController(@Autowired private val studentService: StudentService) {

    @GetMapping("/{id}")
    fun getStudentById(@PathVariable id: String): Student {
        return studentService.findStudentById(id)
    }

    @PostMapping
    fun createStudent(@RequestBody student: Student): Student {
        return studentService.createStudent(student)
    }

    @PutMapping
    fun updateStudent(@RequestBody student: Student): Student {
        return studentService.updateStudent(student)
    }

    @DeleteMapping("/{id}")
    fun deleteStudent(@PathVariable id: String): Student {
        return studentService.deleteStudent(id)
    }
}
