package uz.digitalone.appspringdatajpalesson.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.digitalone.appspringdatajpalesson.entity.Category;

/**
 * Author: khamza@nightwell-logistics.com
 * Date: 11/10/2022
 * Time: 10:49 PM
 */

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
