package com.e.usertp

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import java.io.Serializable

class User(val nom: String, val prenom: String, val age: Int) : BaseObservable(), Serializable {
    @get:Bindable
    var isSelected: Boolean = false
        set(value) {
            field = value
            notifyPropertyChanged(BR.selected)
        }
}