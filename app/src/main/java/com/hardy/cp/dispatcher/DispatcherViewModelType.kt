package com.hardy.cp.dispatcher

import com.hardy.cp.base.ViewModelType

interface DispatcherViewModelType :
    ViewModelType<DispatcherViewModelType.Input, DispatcherViewModelType.Output> {

    interface Input : ViewModelType.Input {

    }

    interface Output : ViewModelType.Output {

    }
}