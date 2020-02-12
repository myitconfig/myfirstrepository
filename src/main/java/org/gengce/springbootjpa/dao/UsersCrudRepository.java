package org.gengce.springbootjpa.dao;

import org.gengce.springbootjpa.pojo.User;
import org.springframework.data.repository.CrudRepository;

public interface UsersCrudRepository extends CrudRepository<User, Integer> {

}
