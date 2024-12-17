package com.freezefootball.frzftball;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {
    @Autowired
    private final UserList userList;
    public UserRestController(UserList userList) {
        this.userList = userList;
    }

       @GetMapping("/users")
    public List<String> getLoggedUserList() {
        return userList.getLoggedUsers();
    }

}
