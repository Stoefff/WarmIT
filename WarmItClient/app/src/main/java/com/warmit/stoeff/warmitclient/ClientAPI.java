package com.warmit.stoeff.warmitclient;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ServerAPI {

    @GET("/{ip}")
    Call<String> getIP(@Path("ip") String ip, @Body String termalId);


}
