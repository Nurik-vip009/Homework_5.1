package com.main

import android.graphics.Color
import com.model.CounterModel
import com.view.CounterView

class Presenter {

    var model = CounterModel()
    lateinit var view: CounterView

    fun increment() {
        model.increment()
        view.updateActualCounter(model.count)

        if (model.count == 10) {
            view.showToast()
        }

        if (model.count == 15) {
            view.changeColor(Color.GREEN)
        }

    }


    fun attachView(view: MainActivity) {
        this.view = view

    }
}
