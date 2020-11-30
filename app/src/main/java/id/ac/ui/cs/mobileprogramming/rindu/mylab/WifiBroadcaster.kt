package id.ac.ui.cs.mobileprogramming.rindu.mylab

import android.R
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.wifi.WifiManager
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response.ErrorListener
import com.android.volley.Response.Listener
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONException
import org.json.JSONObject
import java.util.*


class WifiBroadcaster(var wifiManager: WifiManager, var wifiDeviceList: ListView) :
    BroadcastReceiver() {
    var stringBuilder: StringBuilder? = null
    override fun onReceive(context: Context, intent: Intent) {
        val action = intent.action
        if (WifiManager.SCAN_RESULTS_AVAILABLE_ACTION == action) {
            stringBuilder = StringBuilder()
            val listOfWifi =
                wifiManager.scanResults
            val listOfDevice =
                ArrayList<String>()
            for (scanResult in listOfWifi) {
                stringBuilder!!.append("\n").append(scanResult.SSID).append(" - ")
                    .append(scanResult.capabilities)
                listOfDevice.add(scanResult.SSID + " - " + scanResult.capabilities)
            }
            Toast.makeText(context, stringBuilder, Toast.LENGTH_SHORT).show()
            val arrayAdapter: ArrayAdapter<*> = ArrayAdapter<Any?>(
                context,
                R.layout.simple_list_item_1,
                listOfDevice.toTypedArray()
            )
            wifiDeviceList.adapter = arrayAdapter
            postWifiToRequestBin(context, listOfDevice)
        }
    }

    private fun postWifiToRequestBin(
        context: Context,
        deviceList: ArrayList<String>
    ) {
        val url = "https://1b163a5de98a37e3adadc96e06086d76.m.pipedream.net"
        val requestQueue = Volley.newRequestQueue(context)
        val postData = JSONObject()
        try {
            postData.put("wifi", deviceList)
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.POST,
            url,
            postData,
            Listener { response -> Log.d("Response", response.toString()) },
            ErrorListener { error -> error.printStackTrace() })
        requestQueue.add(jsonObjectRequest)
    }


}