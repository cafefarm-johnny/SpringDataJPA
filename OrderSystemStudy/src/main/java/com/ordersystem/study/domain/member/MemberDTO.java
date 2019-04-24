package com.ordersystem.study.domain.member;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 회원 정보 엔티티를 기반으로한 회원 DTO
 * @author Johnny
 */
@ToString
@Getter
@Setter
@NoArgsConstructor
public class MemberDTO {

	private String name;
	
	private String city;
	private String street;
	private String zipcode;
	
	
	/**
	 * 회원 정보 DTO to 엔티티
	 * @author Johnny
	 * @return Member
	 */
	public Member toEntity() {
		return Member.builder()
				.name(this.name)
				.city(this.city)
				.street(this.street)
				.zipcode(this.zipcode)
				.build();
	}
}