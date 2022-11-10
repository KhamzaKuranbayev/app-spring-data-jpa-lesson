package uz.digitalone.appspringdatajpalesson.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Author: khamza@nightwell-logistics.com
 * Date: 10/26/2022
 * Time: 10:46 PM
 */


@Entity
@Table(name = "auto_shops")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AutoShop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "shop_cars",
            joinColumns = @JoinColumn(name = "shop_id"),
            inverseJoinColumns = @JoinColumn(name = "car_id"))
    @ToString.Exclude
    private Set<Car> carSet = new HashSet<>();
}
