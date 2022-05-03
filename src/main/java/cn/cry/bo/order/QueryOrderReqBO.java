package cn.cry.bo.order;

import lombok.Data;

@Data
public class QueryOrderReqBO {
    private String userName;

    /**
     * 用户号码
     */
    private String userPhone;
    private String tenantId;
    private Integer userId;
    private String productName;
}
