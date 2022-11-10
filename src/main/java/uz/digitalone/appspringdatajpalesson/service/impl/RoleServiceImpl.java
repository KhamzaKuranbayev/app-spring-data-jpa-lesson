package uz.digitalone.appspringdatajpalesson.service.impl;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import uz.digitalone.appspringdatajpalesson.entity.Role;
import uz.digitalone.appspringdatajpalesson.entity.User;
import uz.digitalone.appspringdatajpalesson.repository.RoleRepository;
import uz.digitalone.appspringdatajpalesson.repository.UserRepository;
import uz.digitalone.appspringdatajpalesson.rest.dto.RoleDto;
import uz.digitalone.appspringdatajpalesson.rest.response.RoleResponse;
import uz.digitalone.appspringdatajpalesson.rest.response.SingleResponse;
import uz.digitalone.appspringdatajpalesson.service.RoleService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Author: khamza@nightwell-logistics.com
 * Date: 11/2/2022
 * Time: 9:31 PM
 */

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository repository;
    private final UserRepository userRepository;

    public RoleServiceImpl(RoleRepository repository,
                           UserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }

    @Override
    public SingleResponse save(RoleDto dto) {
        Role role = new Role();
        role.setRoleName(dto.getRoleName());
        role.setDescription(dto.getDescription());
        Role savedRole = repository.save(role);
        return new SingleResponse(true, "Role successfully created!");
    }

    @Override
    public SingleResponse findAll() {
        List<Role> roleList = repository.findAll();
        List<RoleResponse> resultList = new ArrayList<>();

        for (Role role : roleList) {
            RoleResponse roleResponse =
                    new RoleResponse(
                            role.getId(),
                            role.getRoleName(),
                            role.getDescription());
            resultList.add(roleResponse);
        }

        return new SingleResponse(true, "Role List", resultList);
    }

    @Override
    public SingleResponse findById(Long roleId) {
        Optional<Role> optionalRole = repository.findById(roleId);
        if (optionalRole.isPresent()) {
            Role role = optionalRole.get();
            RoleResponse roleResponse = new RoleResponse(
                    role.getId(),
                    role.getRoleName(),
                    role.getDescription()
            );
            return new SingleResponse(true, "Role with ID {" + roleId + "}", roleResponse);
        }
        return new SingleResponse(false, "Role Not Found with ID {" + roleId + "}", HttpStatus.NOT_FOUND);
    }

    @Override
    public SingleResponse edit(Long roleId, RoleDto dto) {
        Optional<Role> optionalRole = repository.findById(roleId);
        if (optionalRole.isPresent()) {
            Role entity = optionalRole.get();

            if (dto.getRoleName() != null && !entity.getRoleName().equals(dto.getRoleName()))
                entity.setRoleName(dto.getRoleName());

            if (dto.getDescription() != null && !entity.getDescription().equals(dto.getDescription()))
                entity.setDescription(dto.getDescription());

            repository.save(entity);
            return new SingleResponse(true, "Role successfully updated!");
        }
        return new SingleResponse(false, "Role Not Found with ID {" + roleId + "}", HttpStatus.NOT_FOUND);
    }

    @Override
    public SingleResponse delete(Long roleId) {
        Optional<Role> optionalRole = repository.findById(roleId);
        if (optionalRole.isPresent()) {
            Role role = optionalRole.get();

            List<User> userList = userRepository.findAllByRole(role);
            for (User user : userList) {
                userRepository.delete(user);
            }


        }
        return new SingleResponse(true, "Role Successfully deleted!");
    }
}
