package com.ordersystem.study.domain.item;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.ordersystem.study.domain.category.Category;

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
	
	@ManyToMany(mappedBy="items")
	private List<Category> categories = new ArrayList<>();
	
	/**
	 * 상품 정보 엔티티 빌더 
	 * @author Johnny
	 * @param itemName 상품명
	 * @param itemPrice 상품 가격
	 * @param itemStockQuantity 상품 재고수량
	 * @param categories 카테고리 리스트
	 */
	@Builder
	public Item(String itemName, int itemPrice, int itemStockQuantity, List<Category> categories) {
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemStockQuantity = itemStockQuantity;
		this.categories = categories;
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
		dto.setCategories(this.categories);
		
		return dto;
	}
}
