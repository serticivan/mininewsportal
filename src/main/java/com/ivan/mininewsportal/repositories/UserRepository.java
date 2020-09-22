package com.ivan.mininewsportal.repositories;

import com.ivan.mininewsportal.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
