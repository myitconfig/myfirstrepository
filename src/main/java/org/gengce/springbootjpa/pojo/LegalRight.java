package org.gengce.springbootjpa.pojo;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "t_legalright")
public class LegalRight {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "lr_id")
	private Integer lrId;
	@Column(name = "lr_name")
	private String lrName;
	@Column(name = "lr_describe")
	private String lrDescribe;
	@ManyToMany(mappedBy = "legalRight")
	private Set<Roles> roles=new HashSet<>();
	
	public Integer getLrId() {
		return lrId;
	}
	public void setLrId(Integer lrId) {
		this.lrId = lrId;
	}
	public String getLrName() {
		return lrName;
	}
	public void setLrName(String lrName) {
		this.lrName = lrName;
	}
	public String getLrDescribe() {
		return lrDescribe;
	}
	public void setLrDescribe(String lrDescribe) {
		this.lrDescribe = lrDescribe;
	}
	public Set<Roles> getRoles() {
		return roles;
	}
	public void setRoles(Set<Roles> roles) {
		this.roles = roles;
	}
	@Override
	public String toString() {
		return "LegalRight [lrId=" + lrId + ", lrName=" + lrName + ", lrDescribe=" + lrDescribe + "]";
	}
	
	
	
}
