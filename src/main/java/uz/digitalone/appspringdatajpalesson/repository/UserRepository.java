package uz.digitalone.appspringdatajpalesson.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.digitalone.appspringdatajpalesson.entity.Role;
import uz.digitalone.appspringdatajpalesson.entity.User;

import java.util.List;

/**
 * Author: khamza@nightwell-logistics.com
 * Date: 11/2/2022
 * Time: 10:33 PM
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /*
            SELECT u.* FROM users u
                            INNER JOIN roles r on u.role_id = r.id WHERE r.id = ?
     */

    List<User> findAllByRole(Role role);        // JPA Query

    List<User> findAllByRoleId(Long role_id);

    boolean existsByEmail(String emailAddress);

    boolean existsByPhone(String phone);

}
