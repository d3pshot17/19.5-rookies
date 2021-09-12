package com.wafflestudio.seminar.domain.user.dto

import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

class UserDto {
    data class Response(
        var id: Long? = null,
        var name: String? = "",
        var email: String? = "",
    )

    data class CreateRequest(
        @field:NotNull
        @field:NotBlank
        var name: String = "",

        @field:NotNull
        @field:NotBlank
        @field:Email
        var email: String = ""
    )
}