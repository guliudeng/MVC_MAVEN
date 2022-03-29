package cn.cry.bo.product;

import lombok.Data;

@Data
public class AddProductReqBO {
    private String productName;
    private String productPrice;
    private String tenantId;
    private String productPhoto;
    private String productType;
}
