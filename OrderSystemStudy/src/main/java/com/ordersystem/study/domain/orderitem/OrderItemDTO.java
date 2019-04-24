package com.ordersystem.study.domain.orderitem;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 주문 상품 정보 엔티티 기반 DTO
 * @author Johnny
 */
@ToString
@Getter
@Setter
@NoArgsConstructor
public class OrderItemDTO {

	private Long itemId;
	private Long orderId;
	
	private int orderPrice;
	private int orderCount;
	

	/**
	 * 주문 상품 정보 DTO to 엔티티
	 * @author Johnny
	 * @return OrderItem
	 */
	public OrderItem toEntity() {
		return OrderItem.builder()
				.itemId(this.itemId)
				.orderId(this.orderId)
				.orderPrice(this.orderPrice)
				.orderCount(this.orderCount)
				.build();
	}
}
