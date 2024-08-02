package com.cinzogoni.springsecuritycustomform.repositories;

import com.cinzogoni.springsecuritycustomform.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority,Integer> {
}
