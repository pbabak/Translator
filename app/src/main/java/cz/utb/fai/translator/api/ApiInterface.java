package cz.utb.fai.translator.api;
import cz.utb.fai.translator.api.pojo.ResponseTranslator;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    /**
     *
     * @param searchedString Searched string
     * @param langPair e.g. cs|en
     * @return
     */
    @GET("get")
    Call<ResponseTranslator> getTranslation(
            @Query("q") String searchedString,
            @Query("langpair") String langPair
    );
}
