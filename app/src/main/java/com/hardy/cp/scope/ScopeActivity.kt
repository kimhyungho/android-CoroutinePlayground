package com.hardy.cp.scope

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.hardy.cp.R
import com.hardy.cp.base.BaseActivity
import com.hardy.cp.databinding.ActivityScopeBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ScopeActivity : BaseActivity<ActivityScopeBinding, ScopeViewModelType>(
    R.layout.activity_scope
) {

    private val _viewModel: ScopeViewModel by viewModels()
    override val viewModel: ScopeViewModelType get() = _viewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 코루틴 스코프는 코루틴 Context 타입 필드를 launch 등의 확장 함수 내부에서 사용하기 위한 매개체 역할만 담당.
        // 코루틴 Context 는 실제 코루틴이 실행중인 여러 작업과 디스패처를 저장하는 일종의 맵이다.
        // 이를 통해 코틀린 런타임은 다음에 실행할 작업을 고르고 어떤 스레드에 배정할지 결정한다.

        // 코루틴은 항상 자신이 속한 스코프를 참조해야한다.
        // 코루틴 스코프는 글로벌 스코프와 코루틴스코프가 존재한다.

        // 글로벌 스코프 => 앱의 생명주기와 함께 동작하기 때문에 실행 도중에 별도 생명 주기 관리가 필요없다.
        // 앱의 시작 ~ 종료 까지 긴 기간 실행되는 코루틴의 경우 적합하다.
        // Application 에서 사용하거나 / 액티비티 종료시 코루틴을 잘 종료해서 사용해야 할 것 같다.
        GlobalScope.launch {
            // DO IT
        }

        //코루틴 스코프 => 버튼을 눌러 서버와 통신할 때 등. 필요한 순간에만 열고 완료 후 닫아주는는 경우 코루틴 스코프가 유용하다.
        with(viewDataBinding) {
            button.setOnClickListener {
                CoroutineScope(Dispatchers.IO).launch {
                    // DO IT
                }
            }
        }

        // 뷰모델 스코프 => BaseViewModel & ScopeViewModel 에서 확인.


    }
}