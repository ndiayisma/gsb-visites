package com.example.gsb_visites.data.network;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import retrofit2.Retrofit;

@Module
@InstallIn(SingletonComponent.class)
public class NetworkModule {

    @Provides
    @Singleton
    public Retrofit provideRetrofit() {
        return RetrofitClientInstance.getInstance();
    }

    @Provides
    @Singleton
    public GsbApi provideGsbApi(Retrofit retrofit) {
        return retrofit.create(GsbApi.class);
    }
}