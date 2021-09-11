package com.wafflestudio.seminar.domain.user.api

import com.wafflestudio.seminar.domain.survey.dto.SurveyResponseDto
import com.wafflestudio.seminar.domain.user.dto.UserDto
import com.wafflestudio.seminar.domain.user.exception.UserEmailConflictException
import com.wafflestudio.seminar.domain.user.exception.UserNotFoundException
import com.wafflestudio.seminar.domain.user.model.User
import com.wafflestudio.seminar.domain.user.repository.UserRepository
import com.wafflestudio.seminar.domain.user.service.UserService
import org.modelmapper.ModelMapper
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/v1/user")
class UserController(
    private val userService: UserService,
    private val modelMapper: ModelMapper
) {
    @PostMapping("/")
    fun addUser(
        @RequestBody @Valid body: UserDto.CreateRequest,
    ): ResponseEntity<UserDto.Response>{
        return try {
            val createdUser = userService.createUser(body)
            val userBody = modelMapper.map(createdUser, UserDto.Response::class.java)
            ResponseEntity.status(201).body(userBody)
        } catch (e: UserEmailConflictException){
            ResponseEntity.status(HttpStatus.CONFLICT).build()
        }
    }

    @GetMapping("/me/")
    fun getMyUser(
        @RequestHeader("User-Id") userId :Long
    ) : ResponseEntity<UserDto.Response>{
        return try{
            val user = userService.getUserById(userId)
            val userBody = modelMapper.map(user, UserDto.Response::class.java)
            ResponseEntity.ok(userBody)
        } catch (e: UserNotFoundException) {
            ResponseEntity.notFound().build()
        }

    }
}