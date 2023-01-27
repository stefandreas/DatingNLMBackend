package com.example.datingnlmbackend.UserQualifications;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserQRepository extends JpaRepository<UserQualifications,Long> {
    UserQualifications findUserQualificationsByUserId(Long userId);
}
