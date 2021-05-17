package student.kelompok_6.simalasnyuci.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RESTClient {
    private static ApiSiMalasNyuci REST_CLIENT;

    static {
        setupRestClient();
    }
    private RESTClient(){}
    private static void setupRestClient() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://simalasnyuci-backend.awesomeproject.id/server/public/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        REST_CLIENT = retrofit.create(ApiSiMalasNyuci.class);
    }
    public static ApiSiMalasNyuci get(){
        return REST_CLIENT;
    }
}
