package com.hardy.cp.scope

import com.hardy.cp.base.BaseViewModel

class ScopeViewModel: BaseViewModel() {
    override fun willAttachCoroutine() {
        // DO IT BEFORE COROUTINE SCOPE ATTACHED
        // leaking warning, don't use
    }

    override fun didAttachCoroutine() {
        // DO IT WHEN COROUTINE SCOPE ATTACHED
    }

    override fun detachCoroutine() {
        // DO IT WHEN COROUTINE END
    }
}