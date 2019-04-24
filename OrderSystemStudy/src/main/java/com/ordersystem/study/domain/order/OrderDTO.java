package com.ordersystem.study.domain.order;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 주문 정보 엔티티 기반 DTO
 * @author Johnny
 */
@ToString
@Getter
@Setter
@NoArgsConstructor
public class OrderDTO {

	private Long memberId;
	
	private LocalDateTime orderDate;
	
	private OrderStatus status;
	
	
	/**
	 * 주문 정보 DTO to 엔티티
	 * @author Johnny
	 * @return Order
	 */
	public Order toEntity() {
		return Order.builder()
				.memberId(this.memberId)
				.orderDate(this.orderDate)
				.status(this.status)
				.build();
	}
}
