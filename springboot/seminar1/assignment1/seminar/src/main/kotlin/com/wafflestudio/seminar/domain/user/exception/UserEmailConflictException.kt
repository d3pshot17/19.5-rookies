package com.wafflestudio.seminar.domain.user.exception

import com.wafflestudio.seminar.common.exception.WaffleException

class UserEmailConflictException : WaffleException("USER EMAIL ALREADY EXISTS")