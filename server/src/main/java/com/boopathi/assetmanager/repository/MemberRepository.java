package com.boopathi.assetmanager.repository;

import com.boopathi.assetmanager.entity.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member,Long> {
}

