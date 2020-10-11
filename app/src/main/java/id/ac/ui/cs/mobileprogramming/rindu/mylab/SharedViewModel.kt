package id.ac.ui.cs.mobileprogramming.rindu.mylab

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    val selected = MutableLiveData<Item>()

    fun setSelected(item: Item) {
        selected.value = item
    }
}

