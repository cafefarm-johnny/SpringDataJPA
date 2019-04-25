package com.ordersystem.study.domain.order;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.ordersystem.study.domain.delivery.Delivery;
import com.ordersystem.study.domain.delivery.DeliveryDTO;
import com.ordersystem.study.domain.member.Member;
import com.ordersystem.study.domain.orderitem.OrderItem;
import com.ordersystem.study.domain.orderitem.OrderItemDTO;

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
	
	@ManyToOne
	@JoinColumn(name="member_id")
	private Member member;
	
	@OneToMany(mappedBy="order")
	private List<OrderItem> orderItems = new ArrayList<>();
	
	@OneToOne
	@JoinColumn(name="delivery_id")
	private Delivery delivery;
	
	private LocalDateTime orderDate;
	
	@Enumerated(EnumType.STRING)
	private OrderStatus status;
	
	
	/**
	 * 연관 관계 setter
	 * @author Johnny
	 * @param member 회원 정보 엔티티
	 */
	public void setMember(Member member) {
		// 기존의 연관 관계를 해제한다.
		// 기존의 연관 관계를 해제하지 않으면, 새로운 객체를 할당(set)해도 새로운 객체를 조회할 수 있는 것이 아닌 기존의 연관 관계를 조회하게 된다.
		if (this.member != null)
		{
			this.member.getOrders().remove(this);
		}
		this.member = member;
		member.getOrders().add(this);
		
		// 해당 메소드를 구현하지 않을 경우
		// Member member = new Member();
		// Order order = new Order();
		// member.getOrders().add(order); // member -> order
		// order.setMember(member); // order -> member
		
		// 해당 메소드를 구현한 경우
		// Member member = new Member();
		// Order order = new Order();
		// order.setMember(member); // member -> order, order -> member
		
		// !: 연관관계 편의 메소드는 양 쪽의 엔티티에서 모두 작성하면 무한 루프에 빠질 수 있으므로 반드시 한 쪽의 엔티티에만 작성한다.
	}
	
	/**
	 * 연관 관계 편의 메소드 (List add = set)
	 * @author Johnny
	 * @param orderItemDTO
	 */
	public void addOrderItem(OrderItemDTO orderItemDTO) {
		this.orderItems.add(orderItemDTO.toEntity());
		if (orderItemDTO.getOrder() != this)
		{
			orderItemDTO.setOrder(this);
		}
	}
	
	/**
	 * 연관 관계 setter
	 * @author Johnny
	 * @param delivery 배송 정보 엔티티
	 */
	public void setDelivery(DeliveryDTO deliveryDTO) {
		this.delivery = deliveryDTO.toEntity();
		deliveryDTO.setOrder(this);
	}
	
	
	/**
	 * 주문 정보 엔티티 빌더
	 * @author Johnny
	 * @param memberId 회원 식별자
	 * @param orderDate 주문 날짜
	 * @param status 주문 상태
	 */
	@Builder
	public Order(Member member, List<OrderItem> orderItems, LocalDateTime orderDate, OrderStatus status) {
		this.member = member;
		this.orderItems = orderItems;
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
		dto.setMember(this.member);
		dto.setOrderItems(this.orderItems);
		dto.setOrderDate(this.orderDate);
		dto.setStatus(this.status);
		
		return dto;
	}
}
