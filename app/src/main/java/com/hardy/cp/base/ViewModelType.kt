package com.hardy.cp.base

interface ViewModelType<Input : ViewModelType.Input, Output : ViewModelType.Output> {

    val input: Input

    val output: Output

    interface Input

    interface Output
}