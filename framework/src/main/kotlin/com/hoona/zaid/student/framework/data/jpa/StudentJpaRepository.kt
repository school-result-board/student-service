package com.hoona.zaid.student.framework.data.jpa

import com.hoona.zaid.student.framework.data.entity.StudentEntity
import org.springframework.data.jpa.repository.JpaRepository

interface StudentJpaRepository: JpaRepository<StudentEntity, String>
