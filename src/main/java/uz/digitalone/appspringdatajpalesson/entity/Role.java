package uz.digitalone.appspringdatajpalesson.entity;

import lombok.*;
import org.hibernate.Hibernate;
import uz.digitalone.appspringdatajpalesson.entity.enums.RoleName;

import javax.persistence.*;
import java.util.Objects;

/**
 * Author: khamza@nightwell-logistics.com
 * Date: 10/26/2022
 * Time: 10:09 PM
 */

@Entity
@Table(name = "roles")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private RoleName roleName;

    @Column(name = "description", length = 500)
    private String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Role role = (Role) o;
        return id != null && Objects.equals(id, role.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
