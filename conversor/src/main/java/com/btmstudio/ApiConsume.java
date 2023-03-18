package com.btmstudio;
import java.io.*;
import okhttp3.*;

public class ApiConsume {

    public ApiConsume(){
      
    }
    public void convertir(String to, String from,String amount) throws IOException{
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder()
          .url("https://api.apilayer.com/fixer/convert?to="+ to+"&from="+from+"&amount="+amount)
          .addHeader("apikey", "uSBX1EqIFt5bSPxpSkb0XgqBByaFGS4C")
          .method("GET",null)
          .build();
        Response response = client.newCall(request).execute();
        System.out.println(response.body().string());
    }
    public String factorConversion(String fecha,String origen,String destinos ) throws IOException{
        OkHttpClient client = new OkHttpClient().newBuilder().build();

        Request request = new Request.Builder() // 2023-03-10
          .url("https://api.apilayer.com/fixer/"+fecha+"?symbols="+destinos+"&base="+origen)
          .addHeader("apikey", "uSBX1EqIFt5bSPxpSkb0XgqBByaFGS4C")
          .method("GET", null)
          .build();
        Response response = client.newCall(request).execute();
       // System.out.println(response.body().string());
        return response.body().string();
    }
}