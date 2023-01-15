package pjwstk.aidietgenerator.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "user_extras")
public class UserExtras {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "background_image")
    private String background_image;

    @Column(name = "about_me")
    private String about_me;

    @Column(name = "profession")
    private String profession;

    @OneToOne
    @JoinColumn(name = "creator_id")
    @JsonIgnore
    private User user;
}