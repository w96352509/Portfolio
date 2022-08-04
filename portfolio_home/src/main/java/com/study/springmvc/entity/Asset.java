package com.study.springmvc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

@Entity
@Immutable
@Subselect("SELECT ROW_NUMBER() OVER() AS id, p.investor_id as invid, c.name as name, SUM(p.amount * s.price) as subtotal "
		+  "FROM Classify c, Portfolio p, TStock s "
		+  "WHERE p.t_stock_id = s.id AND s.classify_id = c.id "
		+  "GROUP BY p.investor_id, c.name;")
// 投資者的購買股市訂單的股市價值與各資訊
public class Asset {

	    @Id
	    private Integer id;      
	    
	    @Column
	    private Integer invid; // 訂單投資者 ID 
	    
	    @Column
	    private String name;   // 商品類型名稱
	    
	    @Column
	    private Double subtotal; // 價值

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public Integer getInvid() {
			return invid;
		}

		public void setInvid(Integer invid) {
			this.invid = invid;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Double getSubtotal() {
			return subtotal;
		}

		public void setSubtotal(Double subtotal) {
			this.subtotal = subtotal;
		}
	
	    
	    
}
