package cn.cry.bo.waiMai;

import lombok.Data;

@Data
public class AddWaiMaiReqBO {
    private String waiMaiName;
    private String waiMaiPhone;
    private String waiMaiAddress;
    private String tenantId;
}
