package project.cmm.myccm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.cmm.myccm.core.model.dto.UserDto;
import project.cmm.myccm.core.model.response.UserResponse;
import project.cmm.myccm.service.AppUserService;

import java.util.List;


@RestController
@RequestMapping(path = "/user/")
public class AppUserController {

    @Autowired
    private AppUserService userService;


    @GetMapping(path = "{id}")
    public ResponseEntity<UserResponse> findById(@PathVariable long id) {
        UserResponse response = userService.findByUserId(id);
        if (response != null) {
            return new ResponseEntity<UserResponse>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(path = "username/{username}")
    public ResponseEntity<UserResponse> findByUsername(@PathVariable String username) {
        UserResponse response = userService.findByUsername(username);
        if (response != null) {
            return new ResponseEntity<UserResponse>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @GetMapping(path = "admin/all")
    public ResponseEntity<List<UserResponse>> findAllUsers() {
        return new ResponseEntity<List<UserResponse>>(userService.findAllUsers(), HttpStatus.OK);
    }


    @PostMapping(path = "register")
    public ResponseEntity<UserResponse> saveNewUser(@RequestBody UserDto dto) {
        UserResponse response = userService.saveAppUser(dto);
        if (response != null) {
            return new ResponseEntity<UserResponse>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping(path = "user/{username}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable String username, @RequestBody UserDto dto) {
        UserResponse response = userService.updateUser(username, dto);
        if (response != null) {
            return new ResponseEntity<UserResponse>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(path = "{username}")
    public ResponseEntity<UserResponse> deleteUserByUsername(@PathVariable String username) {
        try {
            userService.deleteUserByUsername(username);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
