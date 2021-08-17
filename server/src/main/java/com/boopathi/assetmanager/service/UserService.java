package com.boopathi.assetmanager.service;

import com.boopathi.assetmanager.entity.User;
import com.boopathi.assetmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> getList(){
        List<User> list = new ArrayList<>();
        userRepository.findAll().forEach(list::add);
        return list;
    }

    public User get(Long id) throws Exception {
        Optional<User> result = userRepository.findById(id);
        if(result.isPresent()){
            return result.get();
        }
        else {
            throw new Exception("User not found");
        }
    }

    public User add(User user){
        return userRepository.save(user);
    }

    public void delete(Long id){
        userRepository.deleteById(id);
    }

    public String getEntityName(){
        return "user";
    }
}
