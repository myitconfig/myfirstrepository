package org.gengce.springbootjpa.dao;

import org.gengce.springbootjpa.pojo.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UsersPagingAndSortRepository extends PagingAndSortingRepository<User, Integer> {

}
