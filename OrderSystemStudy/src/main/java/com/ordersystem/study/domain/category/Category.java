package com.ordersystem.study.domain.category;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.ordersystem.study.domain.item.Item;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


/**
 * 상품 카테고리 정보 엔티티
 * @author Johnny
 */
@ToString
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Category {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="category_id")
	private Long id;
	
	private String name;
	
	@ManyToMany
	@JoinTable(name="category_item", 
			joinColumns=@JoinColumn(name="category_id"), 
			inverseJoinColumns=@JoinColumn(name="item_id"))
	private List<Item> items = new ArrayList<>();
	
	// 카테고리의 계층 구조를 위한 필드들
	@ManyToOne
	@JoinColumn(name="parent_id")
	private Category parent;
	
	@OneToMany(mappedBy="parent")
	private List<Category> child = new ArrayList<>();
	
	/**
	 * 연관 관계 메소드
	 * @author Johnny
	 * @param child
	 */
	public void addChildCategory(Category child) {
		this.child.add(child);
		child.setParent(this);
	}
	
	/**
	 * 연관 관계 메소드
	 * @author Johnny
	 * @param item
	 */
	public void addItem(Item item) {
		items.add(item);
	}
}
