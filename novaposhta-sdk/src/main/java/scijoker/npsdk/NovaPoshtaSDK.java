package scijoker.npsdk;

import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import scijoker.npsdk.api.DictionariesApi;
import scijoker.npsdk.common.ApiConst;

/**
 * Created by scijoker on 15.10.16.
 */

public class NovaPoshtaSDK {
    private static DictionariesApi dictionariesApi;
    private static Retrofit retrofit;
    private static OkHttpClient okHttpClient;

    public static void setup(String apiKey, boolean needLogging) {
        ApiConst.API_KEY = apiKey;
        retrofit = new Retrofit.Builder()
                .baseUrl(ApiConst.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(provideHttpClient(needLogging))
                .build();
        dictionariesApi = retrofit.create(DictionariesApi.class);
    }

    public static DictionariesApi getDictionariesApi() {
        return dictionariesApi;
    }

    private static OkHttpClient provideHttpClient(boolean needLogging) {
        if (okHttpClient == null) {
            okHttpClient = new OkHttpClient.Builder()
                    .connectTimeout(10, TimeUnit.SECONDS)
                    .readTimeout(5, TimeUnit.SECONDS)
                    .writeTimeout(5, TimeUnit.SECONDS)
                    .addInterceptor(provideInterceptor(needLogging))
                    .build();
        }
        return okHttpClient;
    }

    private static Interceptor provideInterceptor(boolean needLogging) {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(needLogging ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);
        return logging;
    }
}
