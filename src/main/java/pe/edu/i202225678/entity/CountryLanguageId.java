package pe.edu.i202225678.entity;

import java.io.Serializable;

public class CountryLanguageId implements Serializable {

    private String CountryCode;
    private String Language;

    public CountryLanguageId(String countryCode, String language) {
        CountryCode = countryCode;
        Language = language;
    }

    public CountryLanguageId() {
    }

    public String getCountryCode() {
        return CountryCode;
    }

    public void setCountryCode(String countryCode) {
        CountryCode = countryCode;
    }

    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String language) {
        Language = language;
    }

    @Override
    public String toString() {
        return "CountryLanguageId{" +
                "CountryCode='" + CountryCode + '\'' +
                ", Language='" + Language + '\'' +
                '}';
    }
}
