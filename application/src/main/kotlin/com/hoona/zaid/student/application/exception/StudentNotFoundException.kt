package com.hoona.zaid.student.application.exception

class StudentNotFoundException(id: String?) : Exception("Cannot find student with id: $id")
