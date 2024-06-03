package hellojpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "member")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(name = "user_name")
    private String userName;

//    @Column(name = "team_id")
//    private Long teamId;


    // Member : N, Team : 1 관계 이므로 MemberEntity Many, TeamEntity One
    @ManyToOne
    @JoinColumn(name = "team_id") // join column name
    private TeamEntity teamEntity;

}
