package org.gengce.springbootjpa.dao;

import java.util.List;

import org.gengce.springbootjpa.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;


public interface UsersRepository extends Repository<User, Integer> {
	
	@Query(value = "select u_id,u_name,u_age,u_address from t_users where u_id= ?",nativeQuery = true)
	List<User> queryByIdUseSQL(Integer id);
	
	@Query("update User set name= ?1 , age= ?2 where u_id= ?3")
	@Modifying
	void updateUserById(String name,Integer age,Integer id);
	

}
