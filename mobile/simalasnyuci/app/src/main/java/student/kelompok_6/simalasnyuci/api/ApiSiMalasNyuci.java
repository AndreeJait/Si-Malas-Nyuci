package student.kelompok_6.simalasnyuci.api;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import student.kelompok_6.simalasnyuci.ResponseApi.DataGetResponse;
import student.kelompok_6.simalasnyuci.ResponseApi.LoginApiResponse;

public interface ApiSiMalasNyuci {

    @FormUrlEncoded
    @POST("api/login")
    Call<LoginApiResponse> loginApi(@Field("email") String email,
                  @Field("password") String password);
    @FormUrlEncoded
    @POST("api/register")
    Call<LoginApiResponse> registerApi(@Field("email") String email,
                                       @Field("password") String password,
                                       @Field("phone_number") String phoneNumber,
                                       @Field("full_name") String full_name,
                                       @Field("role") int role,
                                       @Field("kode") String kode);

    @GET("api/laundry/DJKFDFLMNJ?key=siallangjagal00011212")
    Call<DataGetResponse> getLaundry();
}
