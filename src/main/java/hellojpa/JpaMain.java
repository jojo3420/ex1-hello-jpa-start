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

//            TeamEntity teamEntity = new TeamEntity();
//            teamEntity.setTeamName("teamA");
//            em.persist(teamEntity);
//
//
//            MemberEntity memberEntity = new MemberEntity();
//            memberEntity.setUserName("joel1");
//            memberEntity.setTeamId(teamEntity.getTeamId());
//            em.persist(memberEntity);


            MemberEntity findMember = em.find(MemberEntity.class, 1L);
            System.out.println("findMember.getUserName() = " + findMember.getUserName());
            System.out.println("findMember = " + findMember);
            System.out.println("findMember.getTeamEntity().getTeamName() = " + findMember.getTeamEntity().getTeamName());
//            TeamEntity findTeam = em.find(TeamEntity.class, findMember.getTeamId());
//            System.out.println("findTeam.getTeamName() = " + findTeam.getTeamName());



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
