package com.boopathi.assetmanager.controller;

import com.boopathi.assetmanager.entity.User;
import com.boopathi.assetmanager.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@CrossOrigin(origins = "http://localhost:4200")
@RestController("/users")
@Controller()
public class UserController {
    //TODO implement logging
    //Logger logger = new Logger(this.getClass(),"");
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<JsonNode> getAll() throws JsonProcessingException {
        return ResponseEntity.ok(new ObjectMapper().readTree(userService.getList().toString()));
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<JsonNode> get(@PathVariable Long id) throws JsonProcessingException, JSONException {
        try {
            return ResponseEntity.ok(new ObjectMapper().readTree(userService.get(id).toString()));
        }
        catch (Exception exception){
            return ResponseEntity.ok(new ObjectMapper().readTree(new JSONObject().put("status", "failed").put("error code", 4001).put("message", "Invalid ID").toString()));
        }
    }

    @PostMapping("/users")
    public ResponseEntity<JsonNode> add(@RequestBody User user) throws JsonProcessingException {
        User resultUser = userService.add(user);
        return ResponseEntity.ok(new ObjectMapper().readTree(resultUser.toString()));
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<JsonNode> update(@RequestBody User user, @PathVariable Long id) throws JsonProcessingException {
        user.setId(id);
        User resultUser = userService.add(user);
        return ResponseEntity.ok(new ObjectMapper().readTree(resultUser.toString()));
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id){
        userService.delete(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
