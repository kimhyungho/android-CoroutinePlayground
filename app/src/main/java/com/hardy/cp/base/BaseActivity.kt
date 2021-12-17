package com.hardy.cp.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.hardy.cp.BR
import java.lang.IllegalStateException


abstract class BaseActivity<VD : ViewDataBinding, VM : ViewModelType<*, *>>(
    @LayoutRes
    private val layoutResId: Int
) : AppCompatActivity(), ViewModelLifecycle<VD, VM> {

    private var _viewDataBinding: VD? = null
    protected val viewDataBinding: VD
        get() = _viewDataBinding ?: throw IllegalStateException("viewDataBinding can not be null")

    abstract val viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<VD>(this, layoutResId).also { viewDataBinding ->
            viewDataBinding.lifecycleOwner = this

            onWillAttachViewModel(viewDataBinding, viewModel)

            viewDataBinding.setVariable(BR.input, viewModel.input)
            viewDataBinding.setVariable(BR.output, viewModel.output)


            onDidAttachViewModel(viewDataBinding, viewModel)

            this._viewDataBinding = viewDataBinding
        }.root
    }


    override fun onDestroy() {
        onWillDetachViewModel(viewDataBinding, viewModel)

        _viewDataBinding = null

        onDidDetachViewModel()
        super.onDestroy()
    }
}