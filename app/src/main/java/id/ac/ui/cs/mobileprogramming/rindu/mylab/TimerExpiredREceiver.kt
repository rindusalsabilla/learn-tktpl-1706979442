package id.ac.ui.cs.mobileprogramming.rindu.mylab

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import id.ac.ui.cs.mobileprogramming.rindu.mylab.PrefUtil

class TimerExpiredREceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        //TODO: show notification

        PrefUtil.setTimerState(MainActivity.TimerState.Stopped, context)
        PrefUtil.setAlarmSetTime(0, context)
    }
}