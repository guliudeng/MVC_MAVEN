package cn.cry.po;

import lombok.Data;

@Data
public class BsWaiMai {
    /**
     * 外卖人员id
     */
    private Integer waiMaiId;

    /**
     * 外卖人员姓名
     */
    private String waiMaiName;

    /**
     * 外卖人员电话
     */
    private String waiMaiPhone;

    /**
     * 外卖人员地址
     */
    private String waiMaiAddress;

    /**
     * 租户id
     */
    private String tenantId;

    /**
     * 删除标识
     */
    private String deleteFlag;

    /**
     * 创建时间
     */
    private String createTime;
}