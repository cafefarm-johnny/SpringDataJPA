package com.ordersystem.study.domain.orderitem;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 주문 상품 정보 엔티티
 * @author Johnny
 */
@ToString
@Entity
@Getter
@NoArgsConstructor
@Table(name="order_item")
public class OrderItem {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="order_item_id")
	private Long id;
	
	@Column(name="item_id")
	private Long itemId;
	@Column(name="order_id")
	private Long orderId;
	
	private int orderPrice;
	private int orderCount;
	
	/**
	 * 주문 상품 정보 빌더
	 * @author Johnny
	 * @param itemId 상품 식별자
	 * @param orderId 주문 식별자
	 * @param orderPrice 주문 금액
	 * @param orderCount 주문 수량
	 */
	@Builder
	public OrderItem(Long itemId, Long orderId, int orderPrice, int orderCount) {
		this.itemId = itemId;
		this.orderId = orderId;
		this.orderPrice = orderPrice;
		this.orderCount = orderCount;
	}
	
	/**
	 * 주문 상품 정보 엔티티 to DTO
	 * @author Johnny
	 * @return OrderItemDTO
	 */
	public OrderItemDTO toDTO() {
		OrderItemDTO dto = new OrderItemDTO();
		dto.setItemId(this.itemId);
		dto.setOrderId(this.orderId);
		dto.setOrderPrice(this.orderPrice);
		dto.setOrderCount(this.orderCount);
		
		return dto;
	}
}
