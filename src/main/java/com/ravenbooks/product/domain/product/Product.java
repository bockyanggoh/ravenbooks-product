package com.ravenbooks.product.domain.product;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_products")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {
    @Id
    @Column(name = "product_id")
    private String id;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "product_description")
    private String productDescription;
    @Column(name = "img_url")
    private String imgUrl;
    @Column(name = "isbn")
    private String isbn;
    @Column(name = "stocks")
    private int stocks;
    @Column(name = "created_ts")
    private LocalDateTime createdTs;
    @Column (name = "updated_ts")
    private LocalDateTime updatedTs;

}
