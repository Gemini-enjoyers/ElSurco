package com.elSurco.ElSurco_in5bv.Service;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GoogleMapsService {

    private final GeoApiContext context;

    public GoogleMapsService(@Value("${google.maps.api-key}") String apiKey) {
        this.context = new GeoApiContext.Builder()
                .apiKey(apiKey)
                .build();
    }

    public String obtenerCoordenadas(String direccion) {
        try {
            GeocodingResult[] results = GeocodingApi.geocode(context, direccion).await();

            if (results.length > 0) {
                double lat = results[0].geometry.location.lat;
                double lng = results[0].geometry.location.lng;
                return lat + "," + lng;
            }
        } catch (Exception e) {
            System.out.println("No se pudo obtener el GPS de Google Maps: " + e.getMessage());
        }
        return null;
    }
}