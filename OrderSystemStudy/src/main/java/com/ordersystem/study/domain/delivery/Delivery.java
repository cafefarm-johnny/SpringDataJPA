package com.ordersystem.study.domain.delivery;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.ordersystem.study.domain.order.Order;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 배송 정보 엔티티
 * @author Johnny
 */
@ToString
@Entity
@Getter
@NoArgsConstructor
public class Delivery {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="delivery_id")
	private Long id;
	
	@OneToOne(mappedBy="delivery")
	private Order order;
	
	private String city;
	private String street;
	private String zipcode;
	
	@Enumerated(EnumType.STRING)
	private DeliveryStatus status;
	
	
	/**
	 * 배송 정보 엔티티 빌더
	 * @author Johnny
	 * @param order 주문 식별자
	 * @param city 도시 정보
	 * @param street 도로 정보
	 * @param zipcode 우편번호 정보
	 */
	@Builder
	public Delivery(Order order, String city, String street, String zipcode) {
		this.order = order;
		this.city = city;
		this.street = street;
		this.zipcode = zipcode;
	}
	
	/**
	 * 배송정보 엔티티 to DTO
	 * @author Johnny
	 * @return DeliveryDTO
	 */
	public DeliveryDTO toDTO() {
		DeliveryDTO dto = new DeliveryDTO();
		dto.setOrder(this.order);
		dto.setCity(this.city);
		dto.setStreet(this.street);
		dto.setZipcode(this.zipcode);
		
		return dto;
	}
}
