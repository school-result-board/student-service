package com.hoona.zaid.student.framework.data.entity

import org.hibernate.annotations.GenericGenerator
import javax.persistence.*

@Entity
@Table(name = "student")
data class StudentEntity(
        @Column
        @Id
        @GeneratedValue(generator = "UUID")
        @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
        val id: String,

        @Column
        val firstName: String,

        @Column
        val lastName: String,

        @Column
        val address: String
)
