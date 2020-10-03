package id.ac.ui.cs.mobileprogramming.rindu.mylab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var id : Int = 0

    fun countUp(num : Int): NumResult{
        id = num + 1
        return NumResult(id)

    }

    fun countDown(num : Int): NumResult{
        id = num - 1
        return NumResult(id)

    }

    data class NumResult(val num: Int)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_motiv.setOnClickListener {
            motivation()
        }

        value.text = id.toString()

        plusBtn.setOnClickListener {
            countUp(id)
            value.text = id.toString()
        }

        minusBtn.setOnClickListener {
            countDown(id)
            value.text = id.toString()
        }
    }

    fun motivation() {
        Toast.makeText(this, "Have a Nice Day", Toast.LENGTH_SHORT).show()
    }
}

