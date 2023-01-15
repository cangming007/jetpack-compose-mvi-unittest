package com.cangming.jetpack.repo

import com.cangming.jetpack.service.LoginService
import com.linx.net.base.ServiceCreator

object LoginRepo {

    /**
     * 登录
     */
    fun getUserLogin(username: String, password: String) =
        ServiceCreator.getService<LoginService>().getUserLogin(username, password)

}