package com.ordersystem.study.domain.item;

import lombok.NoArgsConstructor;

import lombok.Setter;

import lombok.Getter;

import lombok.ToString;

/**
 * 상품 정보 엔티티 기반 DTO
 * @author Johnny
 */
@ToString
@Getter
@Setter
@NoArgsConstructor
public class ItemDTO {

	private String itemName;
	private int itemPrice;
	private int itemStockQuantity;
	
	
	/**
	 * 상품 정보 DTO to 엔티티
	 * @author Johnny
	 * @return Item
	 */
	public Item toEntity() {
		return Item.builder()
				.itemName(this.itemName)
				.itemPrice(this.itemPrice)
				.itemStockQuantity(this.itemStockQuantity)
				.build();
	}
}
