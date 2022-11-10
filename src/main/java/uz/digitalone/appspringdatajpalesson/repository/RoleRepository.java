package uz.digitalone.appspringdatajpalesson.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.digitalone.appspringdatajpalesson.entity.Role;

/**
 * Author: khamza@nightwell-logistics.com
 * Date: 11/2/2022
 * Time: 9:58 PM
 */

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
