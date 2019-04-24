package com.ordersystem.study.domain.orderitem;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ordersystem.study.domain.item.Item;
import com.ordersystem.study.domain.order.Order;

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
	
	@ManyToOne
	@JoinColumn(name="item_id")
	private Item item;
	
	@ManyToOne
	@JoinColumn(name="order_id")
	private Order order;
	
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
	public OrderItem(Item item, Order order, int orderPrice, int orderCount) {
		this.item = item;
		this.order = order;
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
		dto.setItem(this.item);
		dto.setOrder(this.order);
		dto.setOrderPrice(this.orderPrice);
		dto.setOrderCount(this.orderCount);
		
		return dto;
	}
}
