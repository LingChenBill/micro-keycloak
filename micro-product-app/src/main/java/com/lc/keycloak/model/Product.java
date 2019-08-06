package com.lc.keycloak.model;

import lombok.Data;

import java.math.BigDecimal;

/**
 * product Bean.
 *
 * @author zyz.
 */
@Data
public class Product {
    // 产品ID.
    private String id;

    // 产品名称.
    private String name;

    // 产品价格.
    private BigDecimal price;

}
