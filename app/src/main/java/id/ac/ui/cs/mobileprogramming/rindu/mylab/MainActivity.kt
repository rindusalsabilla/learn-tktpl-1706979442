package id.ac.ui.cs.mobileprogramming.rindu.mylab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener{
            Toast.makeText(this@MainActivity, R.string.btn_clicked, Toast.LENGTH_SHORT).show()
        }
    }
}
