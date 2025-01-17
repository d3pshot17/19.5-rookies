package com.wafflestudio.seminar.domain.survey.dto

import com.fasterxml.jackson.annotation.JsonProperty
import com.wafflestudio.seminar.common.exception.WaffleException
import com.wafflestudio.seminar.domain.os.dto.OperatingSystemDto
import com.wafflestudio.seminar.domain.os.model.OperatingSystem
import com.wafflestudio.seminar.domain.os.repository.OperatingSystemRepository
import com.wafflestudio.seminar.domain.user.dto.UserDto
import com.wafflestudio.seminar.domain.user.repository.UserRepository
import org.springframework.data.annotation.Reference
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

class SurveyResponseDto {

    data class Response(
        var id: Long? = 0,
        var user: UserDto.Response? = null,
        var os: OperatingSystem? = null,
        var springExp: Int = 0,
        var rdbExp: Int = 0,
        var programmingExp: Int = 0,
        var major: String? = "",
        var grade: String? = "",
        var backendReason: String? = "",
        var waffleReason: String? = "",
        var somethingToSay: String? = "",
        var timestamp: LocalDateTime? = null
    )

    // TODO: 아래 두 DTO 완성
    data class CreateRequest(

        @field:NotNull
        var userId: Long = 0,

        @field:NotNull
        @field:NotBlank
        var os: String = "",

        @field:NotNull
        @field:Min(1, message = "The value must be between 1 and 5")
        @field:Max(5, message = "The value must be between 1 and 5")
        var springExp: Int = 0,

        @field:NotNull
        @field:Min(1, message = "The value must be between 1 and 5")
        @field:Max(5, message = "The value must be between 1 and 5")
        var rdbExp: Int = 0,

        @field:NotNull
        @field:Min(1, message = "The value must be between 1 and 5")
        @field:Max(5, message = "Te value must be between 1 and 5")
        var programmingExp: Int = 0,

        @field:NotBlank
        var major: String? = null,

        @field:NotBlank
        var grade: String? = null,

        var backendReason: String? = null,

        var waffleReason: String? = null,

        var somethingToSay: String? = null,

        )

    data class ModifyRequest(
        var something: String? = ""
        // 예시 - 지우고 새로 생성
    )
}
