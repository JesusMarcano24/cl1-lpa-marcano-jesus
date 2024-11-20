package pe.edu.i202225678.CRUD;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.i202225678.entity.City;
import pe.edu.i202225678.entity.Country;
import pe.edu.i202225678.entity.CountryLanguage;

import java.util.ArrayList;
import java.util.Arrays;

public class JPAPersist {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("world");
        EntityManager em = emf.createEntityManager();

        // Create pais
        Country country = new Country();
        country.setName("DreamLand");
        country.setCode("DLD");
        country.setContinent(Country.Continent.AFRICA);
        System.out.println(Country.Continent.SOUTH_AMERICA);
        country.setRegion("Region Somnifera");
        country.setSurfaceArea(12345.67);
        country.setPopulation(1000000);
        country.setIndepYear(2024);
        country.setLocalName("Tierra de los sueños");
        country.setGovernmentForm("Capitalista");
        country.setCities(null);
        country.setLanguages(null);
        country.setCode2("DL");

        // create 3 ciudades
        City city1 = new City();
        city1.setName("La ciudad de los deseos");
        city1.setDistrict("Distrito central");
        city1.setPopulation(500000);
        city1.setCountry(country);

        City city2 = new City();
        city2.setName("La ciudad de nunca jamas");
        city2.setDistrict("Distrito medio");
        city2.setPopulation(300000);
        city2.setCountry(country);

        City city3 = new City();
        city3.setName("Narnia");
        city3.setDistrict("Distrito alto");
        city3.setPopulation(200000);
        city3.setCountry(country);

        // Create 2 lenguajes nativos
        CountryLanguage language1 = new CountryLanguage();
        language1.setCountryCode("DLD");
        language1.setLanguage("Niahuatle");
        language1.setIsOfficial("T");
        language1.setPercentage(50.0);
        language1.setCountry(country);

        CountryLanguage language2 = new CountryLanguage();
        language2.setCountryCode("DLD");
        language2.setLanguage("Magiclina");
        language2.setIsOfficial("F");
        language2.setPercentage(30.0);
        language2.setCountry(country);

        // Asociar las ciudades y lenguajes al país
        country.setCities(Arrays.asList(city1, city2, city3));
        country.setLanguages(Arrays.asList(language1, language2));

        //Persist
        em.getTransaction().begin();
        em.persist(country);
        em.getTransaction().commit();

        System.out.println("-------------------------------------------------------");
        System.out.println("------------------- Creando País ---------------------");
        System.out.println(country);
        System.out.println("País imaginario creado con éxito.");
        System.out.println("-------------------------------------------------------");

        em.close();
        emf.close();
    }
}
