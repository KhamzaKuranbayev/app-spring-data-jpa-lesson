package uz.digitalone.appspringdatajpalesson.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.digitalone.appspringdatajpalesson.entity.Car;

/**
 * Author: khamza@nightwell-logistics.com
 * Date: 11/10/2022
 * Time: 10:34 PM
 */

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    boolean existsByName(String name);
}
