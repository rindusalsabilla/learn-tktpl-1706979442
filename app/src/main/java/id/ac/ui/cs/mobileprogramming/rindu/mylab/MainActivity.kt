package id.ac.ui.cs.mobileprogramming.rindu.mylab


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


class MainActivity : AppCompatActivity() {

    private val taskListFragment = TaskListFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .add(R.id.container, taskListFragment)
            .addToBackStack("task_list")
            .commit()
    }
}

