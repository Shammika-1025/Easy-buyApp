package com.example.easybuy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class ShopSelect extends AppCompatActivity {

    EditText edtAddress,edtTitle,edtNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_select);
        edtAddress = findViewById(R.id.edtShopAddress);
        edtTitle = findViewById(R.id.edtShopName);
        edtNumber = findViewById(R.id.edtShopPhn);
        getLocationData();
    }

    void getLocationData() {
        ActivityCompat.requestPermissions(ShopSelect.this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        Location location;
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED)
        {
            Log.d("No permission","");
            return;
        }else
        {
            LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            Log.d("Latitude",""+location.getLatitude());

            // Instantiate the RequestQueue.
            RequestQueue queue = Volley.newRequestQueue(this);
            String url ="https://easybuy-525be.herokuapp.com/shop?lat="+location.getLatitude()+"&long="+location.getLongitude();
            JsonObjectRequest request = new JsonObjectRequest(url, null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            if (null != response) {
                                try {
                                    String address = response.getString("Address");
                                    String contact = response.getString("Contact");
                                    String shopName = response.getString("ShopName");

                                    edtAddress.setText(address);
                                    edtNumber.setText(contact);
                                    edtTitle.setText(shopName);

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                //handle your response
                            }
                        }
                    }, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.d("Request failed","");
                }
            });
            queue.add(request);

        }
    }
}
