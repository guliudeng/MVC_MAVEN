package cn.cry.bo.product;

import lombok.Data;

@Data
public class UpdateProductReqBO {
    private String productName;
    private String productPrice;
    private Integer productId;
    private String productPhoto;
    private String productType;
}
