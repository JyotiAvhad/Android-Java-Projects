package model;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {

//    @FormUrlEncoded
//    @POST("users/register")
//    Call<ResponseRegistration> createUser(
//            @Field("first_name") String first_name,
//            @Field("last_name") String last_name,
//            @Field("email") String email,
//            @Field("password") String password,
//            @Field("confirm_password") String confirm_password,
//            @Field("gender") String gender,
//            @Field("phone_no") String phone_no
//    );
//
//    @FormUrlEncoded
//    @POST("users/login")
//    Call<ResponseLogin> loginuser(
//            @Field("email") String email,
//            @Field("password") String password
//    );
//
    @GET("products/getList")
    Call<TableListResponse> getTablesList(
            @Query("product_category_id") String id
    );
//
//    @GET("products/getDetail")
//    Call<ResponseDetails> getDetails(
//            @Query("product_id") String id
//    );
//
//    @FormUrlEncoded
//    @POST("addToCart")
//    Call<ResponseAddCart> addcart(
//            @Header("access_token") String token,
//
//            @Field("product_id") String id,
//            @Field("quantity") String quantity
//    );
//
//    @GET("cart")
//    Call<ResponseCart> listcart(
//            @Header("access_token") String String
//    );
//
//    @FormUrlEncoded
//    @POST("products/setRating")
//    Call<ResponseRate> setRating(
//            @Field("product_id") String id,
//            @Field("rating") String rate
//    );
//
//    @FormUrlEncoded
//    @POST("editCart")
//    Call<ResponseEditCart> editCart(
//            @Header("access_token") String token,
//            @Field("product_id") String id,
//            @Field("quantity") String quantity
//    );
//
//    @FormUrlEncoded
//    @POST("deleteCart")
//    Call<ResponseDeleteCart> deleteCart(
//            @Header("access_token") String token,
//            @Field("product_id") String id
//
//    );
//
//    @FormUrlEncoded
//    @POST("order")
//    Call<ResponseOrder> placeorder(
//            @Header("access_token") String token,
//            @Field("address") String address
//    );

}
