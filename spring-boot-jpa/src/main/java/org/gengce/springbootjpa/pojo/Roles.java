package org.gengce.springbootjpa.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "t_roles")
public class Roles {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "r_id")
	private Integer roleId;
	
	@Column(name = "r_name")
	private String roleName;
	
	@OneToMany(mappedBy = "roles",fetch = FetchType.EAGER)
	private Set<User> users=new HashSet<>();
	
	@ManyToMany(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
	@JoinTable(name = "t_roles_lr",joinColumns =@JoinColumn(name="r_id"),inverseJoinColumns = @JoinColumn(name="lr_id") )
	private Set<LegalRight> legalRight=new HashSet<>();
	
	
	
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
	public Set<LegalRight> getLegalRight() {
		return legalRight;
	}
	public void setLegalRight(Set<LegalRight> legalRight) {
		this.legalRight = legalRight;
	}
	@Override
	public String toString() {
		return "Roles [roleId=" + roleId + ", roleName=" + roleName + "]";
	}
	
	
	
	
	
}
