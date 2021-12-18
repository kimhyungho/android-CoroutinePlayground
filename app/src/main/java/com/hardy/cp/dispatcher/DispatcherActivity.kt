package com.hardy.cp.dispatcher

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.hardy.cp.R
import com.hardy.cp.base.ActivityLauncher
import com.hardy.cp.base.BaseActivity
import com.hardy.cp.databinding.ActivityDispatcherBinding
import kotlinx.coroutines.*
import kotlin.reflect.KClass

class DispatcherActivity : BaseActivity<ActivityDispatcherBinding, DispatcherViewModelType>(
    R.layout.activity_dispatcher
) {
    private val _viewModel: DispatcherViewModel by viewModels()
    override val viewModel: DispatcherViewModelType get() = _viewModel

    override fun onWillAttachViewModel(
        viewDataBinding: ActivityDispatcherBinding,
        viewModel: DispatcherViewModelType
    ) {
        super.onWillAttachViewModel(viewDataBinding, viewModel)

        // 디스패쳐는 코루튼을 적당한 스레드에 할당하고, 코루틴 실행 도중 일시 정지 or 실행 재개를 담당.

        // 안드로이드 기본 스레드풀을 사용, CPU 를 많이 쓰는 작업에 최적화 := 데이터 정렬, 복잡한 연산 등.
        CoroutineScope(Dispatchers.Default).launch {
            // DO IT
        }

        GlobalScope.launch(Dispatchers.Default) {

        }

        lifecycleScope.launch(Dispatchers.Default) {

        }

        // 이미지 다운로드, 파일 입출력 등 입출력에 최적화 := 네트워크, 디스크, DB 작업 등.
        CoroutineScope(Dispatchers.IO).launch {
            // DO IT
        }

        GlobalScope.launch(Dispatchers.IO) {

        }

        lifecycleScope.launch(Dispatchers.IO) {

        }

        // 안드로이드 기본 스레드에서 코루틴 실행. UI 상호작용에 최적화.
        CoroutineScope(Dispatchers.Main).launch {
            // DO IT
        }

        GlobalScope.launch(Dispatchers.Main) {

        }

        lifecycleScope.launch(Dispatchers.Main) {

        }

        // 호출한 Context 를 기본으로 사용하고 중단 후 다시 실행될 때 Context 가 바뀌면 바뀐 Context 를 따라감.
        CoroutineScope(Dispatchers.Unconfined).launch {
            // DO IT
        }

        GlobalScope.launch(Dispatchers.Unconfined) {

        }

        lifecycleScope.launch(Dispatchers.Unconfined) {

        }

    }

    companion object : ActivityLauncher<DispatcherActivity>() {
        override val activityClass: KClass<DispatcherActivity>
            get() = DispatcherActivity::class
    }
}