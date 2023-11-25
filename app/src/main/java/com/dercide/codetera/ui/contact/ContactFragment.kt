package com.dercide.codetera.ui.contact

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dercide.codetera.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class ContactFragment : Fragment(), OnMapReadyCallback {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_contact, container, false)

        mapView = rootView.findViewById(R.id.mapView)
        mapView.onCreate(savedInstanceState)
        mapView.getMapAsync(this)

        return rootView
    }

    private lateinit var mapView: MapView
    private lateinit var googleMap: GoogleMap
    override fun onMapReady(map: GoogleMap) {
        googleMap = map
        // Escalar el icono al tamaño deseado (en este caso, 50x50 dp)
        val anchoDp = 50
        val altoDp = 50
        val escala = resources.displayMetrics.density
        val anchoPx = (anchoDp * escala + 0.5f).toInt()
        val altoPx = (altoDp * escala + 0.5f).toInt()

        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.marker)
        val iconoEscalado = Bitmap.createScaledBitmap(bitmap, anchoPx, altoPx, true)
        // Configuraciones adicionales del mapa si es necesario
        val ubicacion = LatLng(20.2158059,-100.8817551)
        googleMap.addMarker(MarkerOptions().position(ubicacion).title("CodeTera").icon(BitmapDescriptorFactory.fromBitmap(iconoEscalado)))
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ubicacion, 16.5f))
    }

    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapView.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapView.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView.onLowMemory()
    }
}