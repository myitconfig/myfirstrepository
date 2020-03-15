package org.gengce.springbootjpa;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import javax.persistence.criteria.Predicate;
import org.gengce.springbootjpa.dao.RolesJpaRepository;
import org.gengce.springbootjpa.dao.UsersCrudRepository;
import org.gengce.springbootjpa.dao.UsersJapRepository;
import org.gengce.springbootjpa.dao.UsersJpaSpecificationRepository;
import org.gengce.springbootjpa.dao.UsersPagingAndSortRepository;
import org.gengce.springbootjpa.dao.UsersRepository;
import org.gengce.springbootjpa.pojo.LegalRight;
import org.gengce.springbootjpa.pojo.Roles;
import org.gengce.springbootjpa.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class SpringBootJpaApplicationTests {

	@Autowired
	UsersRepository usersRepository;
	@Autowired
	UsersCrudRepository usersCrudRepository;
	@Autowired
	UsersPagingAndSortRepository usersPagingAndSortRepository; 
	@Autowired
	UsersJapRepository usersJapRepository;
	@Autowired
	UsersJpaSpecificationRepository usersJpaSpecificationRepository;
	@Autowired
	RolesJpaRepository rolesJpaRepository;
	/**
	 * 多对多关联添加
	 */
	@Test
	void testManyToMany() {
		Roles role=new Roles();
		role.setRoleName("RMB购买去广告");
		
		LegalRight lr0=new LegalRight();
		lr0.setLrName("去广告");
		lr0.setLrDescribe("电影开始跳过广告");
		
//		LegalRight lr1=new LegalRight();
//		lr1.setLrName("下载速度快");
//		lr1.setLrDescribe("下载速度比非会员快一百倍");
		
		role.getLegalRight().add(lr0);
//		role.getLegalRight().add(lr1);
		lr0.getRoles().add(role);
//		lr1.getRoles().add(role);
		
		this.rolesJpaRepository.save(role);
	}
	@Test
	void testByRoles() {
		Roles roles = this.rolesJpaRepository.findById(3).get();
		if (roles == null) {
			System.out.println("无此角色");
		}else {
			System.out.println("角色名:"+roles.getRoleName());
		}
		
		Set<User> users=roles.getUsers();
		if (users.isEmpty()) {
			System.out.println("此角色下无用户");
		}else {
			for (User user : users) {
				System.out.println("拥有此角色的用户:"+user.getName());
			}
		}
		
		
		Set<LegalRight> legalRights=roles.getLegalRight();
		if (legalRights.isEmpty()) {
			System.out.println("此角色无权益");
		}else {
			for (LegalRight legalRight : legalRights) {
				System.out.println("此角色用户拥有的权益:"+legalRight.getLrName());
			}
		}
		
		
	}
	/**
	 * 多对多关联查询
	 */
	@Test
	void testManyToManyQue() {
		Optional<User> usersOp=this.usersJapRepository.findById(74);
		User users=usersOp.get();
		System.out.println(users.getName());
		Roles role=users.getRoles();
		System.out.println(role.getRoleName());
		Set<LegalRight> legalRight=role.getLegalRight();
		for (LegalRight legalRight2 : legalRight) {
			System.out.println(legalRight2.getLrName());
		}
	}
	
	/**
	 * 一对多关联添加
	 */
	@Test
	void testOneToMany() {
		
		User user=new User();
		user.setAddress("山东");
		user.setAge(30);
		user.setName("霍元甲");
		
		Roles role=new Roles();
		role.setRoleName("会员VIP");
		
		role.getUsers().add(user);
		user.setRoles(role);
		this.usersCrudRepository.save(user);
	}
	/*
	 * 一对多关联查询
	 */
	@Test
	void testOneToManyQue() {
		Optional<User> userOpt=this.usersJapRepository.findById(111);
		Roles role=userOpt.get().getRoles();
		System.out.println(userOpt.get().toString()+role.getRoleName());
	}
	@Test
	void testJpaSpecificationRepository() {
		Specification<User> spec=(root, query, criteriaBuilder) -> {
//			List<Predicate> predicatesList=new ArrayList<>();
//			predicatesList.add(criteriaBuilder.equal(root.get("name"), "李1龙"));
//			predicatesList.add(criteriaBuilder.equal(root.get("address"), "邹平市"));
//			Predicate[] preArr=new Predicate[predicatesList.size()];
			Predicate preEq1=criteriaBuilder.equal(root.get("name"), "李1龙");
			Predicate preEq2=criteriaBuilder.equal(root.get("address"), "邹平市");
			Predicate preEq3=criteriaBuilder.equal(root.get("name"), "李小龙");
			Predicate preEq4=criteriaBuilder.equal(root.get("address"), "邹平市");
			Predicate preAnd1=criteriaBuilder.and(preEq1,preEq2);
			Predicate preAnd2=criteriaBuilder.and(preEq3,preEq4);
			return criteriaBuilder.or(preAnd1,preAnd2);
		};
		
		Sort sort=Sort.by(new Order(Direction.DESC, "id"));
		Pageable pageable=PageRequest.of(0, 2,sort);
		Page<User> page=this.usersJpaSpecificationRepository.findAll(spec, pageable);
		List<User> usersList=page.getContent();
		for (User user : usersList) {
			System.out.println(user.toString());
		}
	}
	
	
	@Test
	void testPagingAndSortRepositiory() {
		
		//排序规则
		Order order=new Order(Direction.DESC, "id");
		//Sort封装排序规则
		Sort sort=Sort.by(order);
		List<User> usersList=(List<User>) this.usersPagingAndSortRepository.findAll(sort);
		for (User user : usersList) {
			System.out.println(user.toString());
		}
		
		
		Pageable pageable=PageRequest.of(0, 10);
		Page<User> page=this.usersPagingAndSortRepository.findAll(pageable);
		System.out.println(page.getSize());
		System.out.println(page.getTotalPages());
		System.out.println(page.getTotalElements());
		List<User> usersList1=page.getContent();
		for (User user : usersList1) {
			System.out.println(user.toString());
		}
		
		
	}
	
	@Test
	void contextLoads() {
		User user=new User();
		user.setAddress("邹平市");
		user.setAge(25);
		user.setName("李小龙");
		this.usersJapRepository.save(user);
	}
	
	@Test
	@Transactional
	@Rollback(false)
	void update() {
		
		this.usersRepository.updateUserById("叶问",60,1);
		
	}
	
	@Test
	void testCrudRepository() {
		/*
			User user=new User();
			user.setId(50);
			user.setAddress("邹平市");
			user.setAge(25);
			user.setName("李龙");
			this.usersCrudRepository.save(user);
		*/
		
		List<User> usersList=(List<User>) this.usersCrudRepository.findAll();
		for (User user : usersList) {
			System.out.println(user.toString());
		}
		
		
//		this.usersCrudRepository.deleteById(45);
	}

}
