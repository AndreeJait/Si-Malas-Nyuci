package student.kelompok_6.simalasnyuci.api;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import student.kelompok_6.simalasnyuci.ResponseApi.LoginApiResponse;

public interface ApiSiMalasNyuci {
    @FormUrlEncoded
    @POST("login")
    Call<LoginApiResponse> loginApi(@Field("email") String email,
                  @Field("password") String password);
}
