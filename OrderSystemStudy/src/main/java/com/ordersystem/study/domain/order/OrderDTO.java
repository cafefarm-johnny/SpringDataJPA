package com.ordersystem.study.domain.order;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.ordersystem.study.domain.member.Member;
import com.ordersystem.study.domain.orderitem.OrderItem;

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

	private Member member;
	
	private List<OrderItem> orderItems = new ArrayList<>();
	
	private LocalDateTime orderDate;
	
	private OrderStatus status;
	
	
	/**
	 * 주문 정보 DTO to 엔티티
	 * @author Johnny
	 * @return Order
	 */
	public Order toEntity() {
		return Order.builder()
				.member(this.member)
				.orderItems(this.orderItems)
				.orderDate(this.orderDate)
				.status(this.status)
				.build();
	}
}
