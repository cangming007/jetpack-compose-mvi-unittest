package com.cangming.jetpack.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.cangming.jetpack.base.BaseViewModel
import com.cangming.jetpack.repo.LoginRepo
import com.linx.net.ext.*
import kotlin.onFailure

/**
 * 登录
 */
class LoginViewModel : BaseViewModel() {

    //用于执行Toast的变量
    val mToast = MutableLiveData<String>()

    //用户名
    val userName = mutableStateOf(TextFieldValue(""))

    //密码
    val passWord = mutableStateOf(TextFieldValue(""))

    //密码是否可见
    val passwordVisible = mutableStateOf(false)

    //登录信息
    private val _userLoginData = MutableLiveData<String>()
    val userLoginData: LiveData<String>
        get() = _userLoginData

    /**
     * 登录
     */
    fun getUserLoginData() = serverAwait {

        if (userName.value.text == "") {
            mToast.value = "用户名不能为空"
            return@serverAwait
        }

        if (passWord.value.text == "") {
            mToast.value = "密码不能为空"
            return@serverAwait
        }

        LoginRepo.getUserLogin(userName.value.text, passWord.value.text).serverData().onSuccess {
            onBizError { code, message ->
                mToast.postValue("登录失败 $message")
                Log.e("xxx", "登录 接口异常 $code $message")
            }
            onBizOK<String> { code, data, message ->
                _userLoginData.postValue("登录成功")
            }
        }.onFailure {
            mToast.postValue("登录失败 $it")
            Log.e("xxx", "登录 接口异常 $it")
        }
    }

}