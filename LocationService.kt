import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class LocationService : Service() {

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        // Code to save location in background
        Log.d("LocationService", "Service is running")
        return START_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("LocationService", "Service is destroyed")
    }
}