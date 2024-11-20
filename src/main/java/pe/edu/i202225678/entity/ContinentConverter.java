package pe.edu.i202225678.entity;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class ContinentConverter implements AttributeConverter<Country.Continent, String> {

    @Override
    public String convertToDatabaseColumn(Country.Continent attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.toString();
    }

    @Override
    public Country.Continent convertToEntityAttribute(String dbData) {
        if (dbData == null || dbData.isEmpty()) {
            return null;
        }
        for (Country.Continent continent : Country.Continent.values()) {
            if (continent.toString().equalsIgnoreCase(dbData)) {
                return continent;
            }
        }
        throw new IllegalArgumentException("Unknown value for continent: " + dbData);
    }
}
