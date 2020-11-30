package id.ac.ui.cs.mobileprogramming.rindu.mylab

import android.Manifest
import android.content.Context
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.net.wifi.WifiManager
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private lateinit var wifiBroadcaster: WifiBroadcaster
    private lateinit var wifiManager: WifiManager
    private val MY_PERMISSIONS_ACCESS_COARSE_LOCATION = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startWifiManager()
        startView()
    }

    private fun startWifiManager() {
        wifiManager = applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
        if (!wifiManager.isWifiEnabled) {
            Toast.makeText(this, "Turn On The Wifi", Toast.LENGTH_LONG).show()
            wifiManager.isWifiEnabled = true
        }
    }

    private fun startView() {
        scanButton.setOnClickListener {
            if (ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION),
                    MY_PERMISSIONS_ACCESS_COARSE_LOCATION
                )
            } else {
                wifiManager.startScan()
            }
        }
    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(wifiBroadcaster)
    }

    override fun onPostResume() {
        super.onPostResume()
        wifiBroadcaster = WifiBroadcaster(wifiManager, listWifi)
        val intentFilter: IntentFilter = IntentFilter()
        intentFilter.addAction(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION)
        registerReceiver(wifiBroadcaster, intentFilter)
        getWifi()
    }

    private fun getWifi() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Toast.makeText(this, "Version Acceptable", Toast.LENGTH_SHORT).show()
            if (ContextCompat.checkSelfPermission(
                    this,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                Toast.makeText(this, "Location turned off", Toast.LENGTH_SHORT).show()
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION),
                    MY_PERMISSIONS_ACCESS_COARSE_LOCATION
                )
            } else {
                Toast.makeText(this, "Location turned on", Toast.LENGTH_SHORT).show()
                wifiManager.startScan()
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            MY_PERMISSIONS_ACCESS_COARSE_LOCATION -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "Permission granted", Toast.LENGTH_SHORT).show()
                    wifiManager.startScan()
                } else {
                    Toast.makeText(this, "Permission not granted", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }




}


