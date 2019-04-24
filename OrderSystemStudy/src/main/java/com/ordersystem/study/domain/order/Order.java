package com.ordersystem.study.domain.order;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * 주문 정보 엔티티
 * @author Johnny
 */
@ToString
@Entity
@Getter
@Table(name="orders")
public class Order {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="order_id")
	private Long id;
	
	@Column(name="member_id")
	private Long memberId;
	
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime orderDate;
	
	@Enumerated(EnumType.STRING)
	private OrderStatus status;
	
	
	/**
	 * 주문 정보 엔티티 빌더
	 * @author Johnny
	 * @param memberId 회원 식별자
	 * @param orderDate 주문 날짜
	 * @param status 주문 상태
	 */
	@Builder
	public Order(Long memberId, LocalDateTime orderDate, OrderStatus status) {
		this.memberId = memberId;
		this.orderDate = orderDate;
		this.status = status;
	}
	
	/**
	 * 회원 정보 엔티티 to DTO
	 * @author Johnny
	 * @return OrderDTO
	 */
	public OrderDTO toDTO() {
		OrderDTO dto = new OrderDTO();
		dto.setMemberId(this.memberId);
		dto.setOrderDate(this.orderDate);
		dto.setStatus(this.status);
		
		return dto;
	}
}
