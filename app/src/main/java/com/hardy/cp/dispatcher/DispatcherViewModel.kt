package com.hardy.cp.dispatcher

import com.hardy.cp.base.BaseViewModel

class DispatcherViewModel : BaseViewModel(), DispatcherViewModelType, DispatcherViewModelType.Input,
    DispatcherViewModelType.Output {

    override val input: DispatcherViewModelType.Input = this
    override val output: DispatcherViewModelType.Output = this

    override fun onWillAttachCoroutine() {
    }

    override fun onDidAttachCoroutine() {
    }

    override fun onDetachCoroutine() {
    }
}