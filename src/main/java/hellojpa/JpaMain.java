package hellojpa;

import hellojpa.entity.MemberEntity;
import jakarta.persistence.*;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-core");
        EntityManager em = emf.createEntityManager();
        //code
        try {
            EntityTransaction tx = em.getTransaction();
            tx.begin();


            MemberEntity member = MemberEntity.builder()
                    .id(1L)
                    .userName("joel.silver")
                    .build();


            em.persist(member);
            tx.commit();

        } catch (Exception e) {
            log.error("Error: ", e);
        } finally {
            // close code
            em.close();
            emf.close();
        }
    }
}
