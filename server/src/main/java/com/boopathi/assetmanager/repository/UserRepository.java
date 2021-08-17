package com.boopathi.assetmanager.repository;

import com.boopathi.assetmanager.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
}
