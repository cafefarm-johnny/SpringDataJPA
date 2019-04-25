package com.ordersystem.study.domain.delivery;

import com.ordersystem.study.domain.order.Order;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 배송 정보 엔티티 기반 DTO
 * @author Johnny
 */
@ToString
@Getter
@Setter
@NoArgsConstructor
public class DeliveryDTO {

	private Order order;
	
	private String city;
	private String street;
	private String zipcode;
	
	private DeliveryStatus status;
	
	
	/**
	 * 배송 정보 DTO to 엔티티
	 * @author Johnny
	 * @return Delivery 엔티티
	 */
	public Delivery toEntity() {
		return Delivery.builder()
				.order(this.order)
				.city(this.city)
				.street(this.street)
				.zipcode(this.zipcode)
				.build();
	}
}
