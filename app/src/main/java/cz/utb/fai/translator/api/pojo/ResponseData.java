package cz.utb.fai.translator.api.pojo;
import com.google.gson.annotations.SerializedName;
public class ResponseData {
    @SerializedName("translatedText")
    private String translatedText;
    @SerializedName("match")
    private float matchPercentage;
    public float getMatchPercentage() {
        return matchPercentage;
    }
    public void setMatchPercentage(float matchPercentage) {
        this.matchPercentage = matchPercentage;
    }
    public String getTranslatedText() {
        return translatedText;
    }
    public void setTranslatedText(String translatedText) {
        this.translatedText = translatedText;
    }
}
