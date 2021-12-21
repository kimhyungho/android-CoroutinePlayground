package com.hardy.cp.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel(), ViewModelCoroutineLifecycle {
    // https://developer.android.com/topic/libraries/architecture/coroutines?hl=ko
    // 라이브 데이터와 코루틴을 함께 사용하는 공식문서.

    // viewModelScope 의 경우 androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0 이상 버전 필요.
    init {
        // leaking warning
        onWillAttachCoroutine()

        viewModelScope.launch {
            // 코루틴은 뷰모델이 클리어 됨과 동시에 취소될 것이다.
            onDidAttachCoroutine()
        }
    }


    override fun onCleared() {
        // 뷰모델 스코프 내부의 코루틴이 클리어와 동시에 종료.
        onDetachCoroutine()
        super.onCleared()
    }
}