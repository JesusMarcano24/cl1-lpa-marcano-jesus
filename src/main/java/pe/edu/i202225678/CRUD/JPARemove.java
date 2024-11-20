package pe.edu.i202225678.CRUD;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.i202225678.entity.Country;

public class JPARemove {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("world");
        EntityManager em = emf.createEntityManager();

            // Buscamos el país creado anteriormente
            Country country = em.find(Country.class, "DLD");

            if (country != null) {
                // Eliminar  país
                em.remove(country);
                System.out.println("País DLD eliminado con éxito.");
            } else {
                System.out.println("País DLD no encontrado.");
            }

            em.getTransaction().begin();
            em.getTransaction().commit();
            em.close();
            emf.close();
    }
}
