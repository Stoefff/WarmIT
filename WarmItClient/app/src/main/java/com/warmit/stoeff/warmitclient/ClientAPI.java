package com.warmit.stoeff.warmitclient;

import com.warmit.stoeff.warmitclient.model.Heat;
import com.warmit.stoeff.warmitclient.model.Ip;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ClientAPI {

    @GET("/id/{termal_id}")
    Call<Ip> fetchIP(@Path("termal_id") String termalId);

    @POST("/{ip}")
    Call<ResponseBody> changeHeat(@Body Heat heat);
}

//192.168.0.10/id/1929281
// IP: "192.168.10.2"
// Heat: 4

//note CHECK Ip and Heat serialized names !!!