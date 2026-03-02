import android.app.Service
import android.content.Intent
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.os.IBinder
import android.util.Log

class LocationService : Service(), LocationListener {

    private lateinit var locationManager: LocationManager

    override fun onCreate() {
        super.onCreate()
        locationManager = getSystemService(LOCATION_SERVICE) as LocationManager
        try {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 10f, this)
        } catch (e: SecurityException) {
            Log.e("LocationService", "Permission not granted for location updates", e)
        }
    }

    override fun onLocationChanged(location: Location) {
        Log.d("LocationService", "Location changed: ${location.latitude}, ${location.longitude}")
        // Here you can handle the new location, e.g., send it to your server or update the UI
    }

    override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {}

    override fun onProviderEnabled(provider: String) {}

    override fun onProviderDisabled(provider: String) {}

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onDestroy() {
        super.onDestroy()
        locationManager.removeUpdates(this)
    }
}