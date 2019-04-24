package com.ordersystem.study.domain.item;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 상품 정보 엔티티
 * @author Johnny
 */
@ToString
@Entity
@Getter
@NoArgsConstructor
public class Item {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="item_id")
	private Long id;
	
	private String itemName;
	private int itemPrice;
	private int itemStockQuantity;
	
	
	/**
	 * 상품 정보 엔티티 빌더 
	 * @author Johnny
	 * @param itemName 상품명
	 * @param itemPrice 상품 가격
	 * @param itemStockQuantity 상품 재고수량
	 */
	@Builder
	public Item(String itemName, int itemPrice, int itemStockQuantity) {
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemStockQuantity = itemStockQuantity;
	}
	
	/**
	 * 상품 정보 엔티티 to DTO
	 * @author Johnny
	 * @return ItemDTO
	 */
	public ItemDTO toDTO() {
		ItemDTO dto = new ItemDTO();
		dto.setItemName(this.itemName);
		dto.setItemPrice(this.itemPrice);
		dto.setItemStockQuantity(this.itemStockQuantity);
		
		return dto;
	}
}
