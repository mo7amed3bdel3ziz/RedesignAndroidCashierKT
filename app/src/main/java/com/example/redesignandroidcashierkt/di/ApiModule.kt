package com.tbi.supplierplus.di

import com.example.redesignandroidcashierkt.dataSource.network.CashierAPI
import com.facebook.stetho.okhttp3.StethoInterceptor

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.simpleframework.xml.convert.AnnotationStrategy
import org.simpleframework.xml.core.Persister
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApiModule {


  // @Provides
  // @Singleton
  // fun provideSimpleXML(): SimpleXmlConverterFactory {
  //     var strategy = AnnotationStrategy()
  //     var serializer = Persister(strategy)
  //     return SimpleXmlConverterFactory.createNonStrict(serializer)
  // }

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        var client = OkHttpClient.Builder()
       // try {

            //client.cache(cache)

      //  client  .addInterceptor(object  LoggingInterceptor())
        client.networkInterceptors().add(StethoInterceptor())
           // client.connectTimeout(10, TimeUnit.SECONDS)

     // client.addNetworkInterceptor(interceptor) // same for .addInterceptor(...)
        client  .connectTimeout(30, TimeUnit.SECONDS) //Backend is really slow
        client   .writeTimeout(30, TimeUnit.SECONDS)
        client   .readTimeout(30, TimeUnit.SECONDS)
            return client.build()

      //  }catch ( ex:Exception){
      //       return client.callTimeout(23,TimeUnit.DAYS)
      //  }


    }


    @Singleton
    @Provides
    fun provideTBIAPI( client: OkHttpClient): CashierAPI {
       // try {
            return Retrofit.Builder()
             // .addConverterFactory(xmlFactory)
                .addConverterFactory(GsonConverterFactory.create())
               // .addCallAdapterFactory(CoroutineCallAdapterFactory())
              //.baseUrl(TBI_BASE_URL)
                .baseUrl("http://scopos-arch.cloud/")
                .client(client)
                .build()
                .create(CashierAPI::class.java)

  }



   // @Singleton
   // @Provides
   // fun provideGeoLocationAPI(): GoogleMapsAPI = Retrofit.Builder()
   //     .addConverterFactory(GsonConverterFactory.create())
   //     .addCallAdapterFactory(CoroutineCallAdapterFactory())
   //     .baseUrl(GOOGLE_BASE_URL)
   //     .build().create(GoogleMapsAPI::class.java)
}