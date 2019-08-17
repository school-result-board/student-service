package com.hoona.zaid.student.framework.exception

import org.springframework.http.HttpStatus

class SimpleErrorMessage(val status: HttpStatus, val message: String?)
