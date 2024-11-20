package pe.edu.i202225678.CRUD;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.i202225678.entity.Country;

public class JPAFind {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("world");
        EntityManager em = emf.createEntityManager();

            // Buscamos el país con el código "PER"
            Country peru = em.find(Country.class, "PER");

            if (peru != null) {
                System.out.println("Ciudades peruanas con más de 700k habitantes:");

                peru.getCities().stream()
                        .filter(city -> city.getPopulation() > 700000)
                        .forEach(city -> System.out.println("- " + city.getName()));
            } else {
                System.out.println("País con código 'PER' no encontrado.");
            }
            em.close();
            emf.close();
    }
}
