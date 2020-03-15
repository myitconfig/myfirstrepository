package org.gengce.springbootjpa.dao;

import org.gengce.springbootjpa.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersJapRepository extends JpaRepository<User, Integer> {

}
