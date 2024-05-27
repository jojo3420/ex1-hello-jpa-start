package hellojpa;

import jakarta.persistence.*;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-core");
        EntityManager em = emf.createEntityManager();
        //code

        em.close();
        emf.close();
    }
}
