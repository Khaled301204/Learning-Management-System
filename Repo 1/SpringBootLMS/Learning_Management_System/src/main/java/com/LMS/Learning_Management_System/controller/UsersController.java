package com.LMS.Learning_Management_System.controller;

import com.LMS.Learning_Management_System.entity.Users;
import com.LMS.Learning_Management_System.entity.UsersType;
import com.LMS.Learning_Management_System.service.UsersService;
import com.LMS.Learning_Management_System.service.UsersTypeService;
import com.LMS.Learning_Management_System.util.UserSignUpRequest;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    private final UsersService usersService;
    private final UsersTypeService usersTypeService;

    @Autowired
    public UsersController(UsersService usersService, UsersTypeService usersTypeService) {
        this.usersService = usersService;
        this.usersTypeService = usersTypeService;
    }

    /**
     * Endpoint to register a new user. Only an Admin can perform this action.
     */
    @PostMapping("/signup")
    public ResponseEntity<String> registerUser(@Validated @RequestBody UserSignUpRequest signUpRequest, HttpServletRequest request) {
        try {
            usersService.save(signUpRequest, request);
            return ResponseEntity.ok("User registered successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * Endpoint to get all user types (Admin, Student, Instructor).
     */
    @GetMapping("/types")
    public ResponseEntity<List<UsersType>> getAllUserTypes() {
        List<UsersType> userTypes = usersTypeService.getAll();
        return ResponseEntity.ok(userTypes);
    }

    /**
     * Endpoint to get user info by email.
     */
    @GetMapping("/find")
    public ResponseEntity<Users> findUserByEmail(@RequestParam String email) {
        Users user = usersService.findByEmail(email);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }
}
