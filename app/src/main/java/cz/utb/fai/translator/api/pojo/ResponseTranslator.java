package cz.utb.fai.translator.api.pojo;
import com.google.gson.annotations.SerializedName;
public class ResponseTranslator {
    @SerializedName("responseData")
    private ResponseData responseData;
    public ResponseData getResponseData() {
        return responseData;
    }
    public void setResponseData(ResponseData responseData) {
        this.responseData = responseData;
    }
}
