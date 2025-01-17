package com.wafflestudio.seminar.domain.os.service

import com.wafflestudio.seminar.domain.os.dto.OperatingSystemDto
import com.wafflestudio.seminar.domain.os.exception.OsNotFoundException
import com.wafflestudio.seminar.domain.os.model.OperatingSystem
import com.wafflestudio.seminar.domain.os.repository.OperatingSystemRepository
import org.modelmapper.ModelMapper
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class OperatingSystemService(
    private val operatingSystemRepository: OperatingSystemRepository,
) {
    fun getAllOperatingSystems(): List<OperatingSystem> {
        return operatingSystemRepository.findAll()
    }

    fun getOperatingSystemById(id: Long): OperatingSystem {
        return operatingSystemRepository.findByIdOrNull(id) ?: throw OsNotFoundException()
    }

    fun getOperatingSystemByName(name: String) : OperatingSystem{
        return operatingSystemRepository.findByNameEquals(name) ?: throw OsNotFoundException()
    }
}