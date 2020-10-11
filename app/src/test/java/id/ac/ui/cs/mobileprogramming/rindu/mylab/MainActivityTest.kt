package id.ac.ui.cs.mobileprogramming.rindu.mylab

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class MainActivityTest {
    private val num : Int = 0

    @Test
    fun countUp_isCorrect() {
        val mainActivity = MainActivity()
        val result = mainActivity.countUp(num)
        assertEquals(result.num, 1)
    }

    @Test
    fun countDown_isCorrect() {
        val mainActivity = MainActivity()
        val result = mainActivity.countDown(num)
        assertEquals(result.num, -1)
    }
    
}
