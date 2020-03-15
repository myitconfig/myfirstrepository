package org.gengce.springbootjpa.dao;

import org.gengce.springbootjpa.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UsersJpaSpecificationRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {

}
