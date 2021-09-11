package com.wafflestudio.seminar.domain.user.service

import com.wafflestudio.seminar.domain.user.dto.UserDto
import com.wafflestudio.seminar.domain.user.exception.UserEmailConflictException
import com.wafflestudio.seminar.domain.user.exception.UserNotFoundException
import com.wafflestudio.seminar.domain.user.model.User
import com.wafflestudio.seminar.domain.user.repository.UserRepository
import org.modelmapper.ModelMapper
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
    private val modelMapper: ModelMapper
) {

    fun createUser(user: UserDto.CreateRequest): User{
        if (userRepository.existsByEmail(user.email)){
            throw UserEmailConflictException()
        }
        val newUser = modelMapper.map(user, User::class.java)
        return userRepository.save(newUser)
    }

    fun getUserById(id :Long) : User?{
        return userRepository.findByIdOrNull(id) ?: throw UserNotFoundException()
    }
}