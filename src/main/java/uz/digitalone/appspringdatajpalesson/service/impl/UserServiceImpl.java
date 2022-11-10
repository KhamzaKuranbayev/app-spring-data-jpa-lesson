package uz.digitalone.appspringdatajpalesson.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import uz.digitalone.appspringdatajpalesson.entity.Role;
import uz.digitalone.appspringdatajpalesson.entity.User;
import uz.digitalone.appspringdatajpalesson.repository.RoleRepository;
import uz.digitalone.appspringdatajpalesson.repository.UserRepository;
import uz.digitalone.appspringdatajpalesson.rest.dto.UserDto;
import uz.digitalone.appspringdatajpalesson.rest.request.UserRequest;
import uz.digitalone.appspringdatajpalesson.rest.response.SingleResponse;
import uz.digitalone.appspringdatajpalesson.service.UserService;

import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Author: khamza@nightwell-logistics.com
 * Date: 11/8/2022
 * Time: 9:19 PM
 */

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final RoleRepository roleRepository;

    @Override
    public SingleResponse save(UserRequest request) {
        if (repository.existsByEmail(request.getEmail()))
            return new SingleResponse(false, "Such Email is already exists!", HttpStatus.BAD_REQUEST);

        if (repository.existsByPhone(request.getPhone()))
            return new SingleResponse(false, "Such Phone is already exists!", HttpStatus.BAD_REQUEST);

        if (request.getPhone().length() > 9)
            return new SingleResponse(false, "Phone length must be less than 9 digits", HttpStatus.BAD_REQUEST);

        Optional<Role> optionalRole = roleRepository.findById(request.getRoleId());
        if (optionalRole.isEmpty())
            return new SingleResponse(false, "Role Not Found with ID {" + request.getRoleId() + "}", HttpStatus.NOT_FOUND);

        Role role = optionalRole.get();
        User user = new User(
                request.getFirstname(),
                request.getLastname(),
                request.getPhone(),
                request.getEmail(),
                request.getPassword(),
                role);
        User savedUser = repository.save(user);
        return new SingleResponse(true, "User successfully saved!", savedUser.getId());
    }

    @Override
    public SingleResponse findAll() {
        return new SingleResponse(true,
                "User List",
                repository.findAll()
                        .stream()
                        .map(this::fromEntity)
                        .collect(Collectors.toList()));
    }

    @Override
    public SingleResponse findById(Long id) {
        User entity = repository.findById(id).orElse(null);
        if (entity == null)
            return new SingleResponse(false, "User Not Found ID {" + id + "}", HttpStatus.NOT_FOUND);

        return new SingleResponse(true,
                "User By ID {" + id + "}",
                fromEntity(entity));
    }

    // MapStruct

    public UserDto fromEntity(User entity) {
        return new UserDto(
                entity.getId(),
                entity.getFirstname(),
                entity.getLastname(),
                entity.getPhone(),
                entity.getEmail(),
                entity.getPassword(),
                entity.getRole().getId(),
                entity.getRole().getRoleName().name()
        );
    }

    @Override
    public SingleResponse edit(Long id, UserRequest request) {
        Optional<User> optionalUser = repository.findById(id);
        if (optionalUser.isPresent()) {
            User entity = optionalUser.get();

            if (request.getFirstname() != null
                    && !request.getFirstname().equals(entity.getFirstname()))
                entity.setFirstname(request.getFirstname());

            if (request.getLastname() != null
                    && !request.getLastname().equals(entity.getLastname()))
                entity.setLastname(request.getLastname());

            /*if(request.getPhone() != null
                    && !request.getPhone().equals(entity.getPhone()))
                entity.setPhone(request.getPhone());

            if(request.getEmail() != null
                    && !request.getPhone().equals(entity.getPhone()))
                entity.setPhone(request.getPhone());
            */

            if (request.getRoleId() != null
                    && entity.getRole() != null
                    && !entity.getRole().getId().equals(request.getRoleId())) {
                Optional<Role> optionalRole = roleRepository.findById(request.getRoleId());
                if (optionalRole.isPresent()) {
                    Role newRole = optionalRole.get();
                    entity.setRole(newRole);
                }
            }

            repository.save(entity);
            return new SingleResponse(true, "User successfully updated!");

        }
        return new SingleResponse(false, "User Not Found", HttpStatus.NOT_FOUND);
    }

    @Override
    public SingleResponse delete(Long id) {
        Optional<User> optionalUser = repository.findById(id);
        if (optionalUser.isPresent()) {
            repository.delete(optionalUser.get());
            return new SingleResponse(true, "User successfully deleted", HttpStatus.NO_CONTENT);
        }
        return new SingleResponse(false, "User Not Found", HttpStatus.NOT_FOUND);
    }
}
