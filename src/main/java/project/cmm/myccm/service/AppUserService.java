package project.cmm.myccm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import project.cmm.myccm.core.model.AppUser;
import project.cmm.myccm.core.model.dto.UserDto;
import project.cmm.myccm.core.model.response.UserResponse;
import project.cmm.myccm.repository.AppUserRepository;
import project.cmm.myccm.repository.UserJpaRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppUserService {

    @Autowired
    private AppUserRepository appUserRepository;
    @Autowired
    private UserJpaRepository userJpaRepository;


    public UserResponse findByUserId(long id) {
        AppUser user = appUserRepository.findUserById(id);
        if (user != null) {
            return new UserResponse(user);
        }
        return null;
    }

    public UserResponse findByUsername(String username) {
        AppUser user = appUserRepository.findUserByUsername(username);
        if (user != null) {
            return new UserResponse(user);
        }
        return null;
    }

    public List<UserResponse> findAllUsers() {
        List<AppUser> users = appUserRepository.findAllUsers();
        List<UserResponse> userResponseList = new ArrayList<>();
        for (AppUser user : users) {
            userResponseList.add(new UserResponse(user));
        }
        return userResponseList;
    }

    public UserResponse saveAppUser(UserDto dto) {
        if (findByUsername(dto.getUsername()) == null) {
            AppUser appUser = new AppUser(dto.getUsername(), encodeThePassword(dto.getPassword()), dto.getTitle(),
                    dto.getFirstName(), dto.getLastName(), dto.getEmail());
            appUserRepository.saveNewUser(appUser);
            return findByUsername(dto.getUsername());
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "This username '" + dto.getUsername() + "' is not available!");
        }
    }

    public UserResponse updateUser(String username, UserDto dto) {
        AppUser user = appUserRepository.findUserByUsername(username);
        AppUser userCheck = appUserRepository.findUserByUsername(dto.getUsername());
        if (user != userCheck) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        if (user != null) {
            if (dto.getFirstName() != null && !dto.getFirstName().isEmpty() && !dto.getFirstName().isBlank()
                    && user.getFirstName() != dto.getFirstName()) {
                user.setFirstName(dto.getFirstName());
            }
            if (dto.getLastName() != null && !dto.getLastName().isEmpty() && !dto.getLastName().isBlank()
                    && user.getLastName() != dto.getLastName()) {
                user.setLastName(dto.getLastName());
            }
            if (dto.getTitle() != null && !dto.getTitle().isEmpty() && !dto.getTitle().isBlank()
                    && user.getTitle() != dto.getTitle()) {
                user.setTitle(dto.getTitle());
            }
            if (dto.getEmail() != null && !dto.getEmail().isEmpty() && !dto.getEmail().isBlank()
                    && user.getEmail() != dto.getEmail()) {
                user.setEmail(dto.getEmail());
            }
            appUserRepository.updateUser(user);
            return findByUsername(dto.getUsername());
        }
        return null;
    }

    public void deleteUserByUsername(String username) throws NotFoundException {
        AppUser user = appUserRepository.findUserByUsername(username);
        if (user != null) {
            userJpaRepository.delete(user);
        } else {
            throw new NotFoundException();
        }
    }

    private String encodeThePassword(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(password);
        return encodedPassword;
    }

}
