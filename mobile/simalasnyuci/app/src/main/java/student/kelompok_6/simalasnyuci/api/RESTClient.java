package student.kelompok_6.simalasnyuci.api;

import retrofit2.Retrofit;

public class RESTClient {
    private static ApiSiMalasNyuci REST_CLIENT;
    private static String BASE_URL = "192";
    static {
        setupRestClient();
    }

    private static void setupRestClient() {
        Retrofit retrofit =new Retrofit.Builder()
                .baseUrl()
                .build();
    }
}
