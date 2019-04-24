package com.ordersystem.study.domain.member;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.ordersystem.study.domain.order.Order;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 회원 정보 엔티티
 * @author Johnny
 */
@ToString
@Entity
@Getter
@NoArgsConstructor
public class Member {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="member_id")
	private Long id;
	
	private String name;
	
	private String city;
	private String street;
	private String zipcode;
	
	@OneToMany(mappedBy="member")
	private List<Order> orders = new ArrayList<>();
	
	/**
	 * 회원 정보 엔티티 빌더
	 * @author Johnny
	 * @param name 회원 이름
	 * @param city 회원 도시
	 * @param street 회원 거리
	 * @param zipcode 회원 우편번호
	 */
	@Builder
	public Member(String name, String city, String street, String zipcode, List<Order> orders) {
		this.name = name;
		this.city = city;
		this.street = street;
		this.zipcode = zipcode;
		this.orders = orders;
	}
	
	/**
	 * 회원 정보 엔티티 to DTO 변환
	 * @author Johnny
	 * @return MemberDTO
	 */
	public MemberDTO toDTO() {
		MemberDTO dto = new MemberDTO();
		dto.setName(this.name);
		dto.setCity(this.city);
		dto.setStreet(this.street);
		dto.setZipcode(this.zipcode);
		dto.setOrders(this.orders);
		
		return dto;
	}
}
