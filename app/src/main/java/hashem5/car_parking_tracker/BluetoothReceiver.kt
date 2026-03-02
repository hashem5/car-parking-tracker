// BluetoothReceiver.kt

import android.bluetooth.BluetoothAdapter
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter

class BluetoothReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val action = intent.action

        if (BluetoothAdapter.ACTION_DISCOVERY_FINISHED == action) {
            // Handle Bluetooth disconnection detection here
            println("Bluetooth device disconnected")
        }
    }

    fun registerReceiver(context: Context) {
        val filter = IntentFilter(BluetoothAdapter.ACTION_DISCOVERY_FINISHED)
        context.registerReceiver(this, filter)
    }

    fun unregisterReceiver(context: Context) {
        context.unregisterReceiver(this)
    }
}