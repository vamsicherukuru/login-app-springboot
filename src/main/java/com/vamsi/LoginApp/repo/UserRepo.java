package com.vamsi.LoginApp.repo;

import com.vamsi.LoginApp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepo extends JpaRepository<User,Integer> {

    User findByEmail(String email);
}
