package com.ordersystem.study.domain.orderitem;

import com.ordersystem.study.domain.item.Item;
import com.ordersystem.study.domain.order.Order;

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

	private Item item;
	private Order order;
	
	private int orderPrice;
	private int orderCount;
	

	/**
	 * 주문 상품 정보 DTO to 엔티티
	 * @author Johnny
	 * @return OrderItem
	 */
	public OrderItem toEntity() {
		return OrderItem.builder()
				.item(this.item)
				.order(this.order)
				.orderPrice(this.orderPrice)
				.orderCount(this.orderCount)
				.build();
	}
}
