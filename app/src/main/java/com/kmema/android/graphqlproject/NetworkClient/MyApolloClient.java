package com.kmema.android.graphqlproject.NetworkClient;

import com.apollographql.apollo.ApolloClient;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

public class MyApolloClient {


    /**
     * user supposed to upload their IP address (at BASE_URL) and port address before running this application
    run npm start command in Node.js command prompt inside respective root folder
    copy your local address and replace with this base address*/
    private static final String BASE_URL = "";

    public static ApolloClient getMyApolloClient() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build();

        return ApolloClient.builder()
                .serverUrl(BASE_URL)
                .okHttpClient(okHttpClient)
                .build();
    }

}
