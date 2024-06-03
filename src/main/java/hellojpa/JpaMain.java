package hellojpa;

import hellojpa.entity.MemberEntity;
import hellojpa.entity.TeamEntity;
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
            TeamEntity aTeam = em.find(TeamEntity.class, 1L);


            MemberEntity memberEntity = new MemberEntity();
            memberEntity.setUserName("nari");
            memberEntity.setTeamEntity(aTeam);
            em.persist(memberEntity);

            // 단방향 매핑 관계: 즉 MemberEntity에서 TeamEntity로의 참조만 가능
            MemberEntity findMember = em.find(MemberEntity.class, 1L);
            System.out.println("findMember.getUserName() = " + findMember.getUserName());
            System.out.println("findMember.getTeamEntity().getTeamName() = " + findMember.getTeamEntity().getTeamName());

            TeamEntity teamEntity = em.find(TeamEntity.class, 1L);
            teamEntity.getMembers().forEach(m -> System.out.println("m.getUserName() = " + m.getUserName()));


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
