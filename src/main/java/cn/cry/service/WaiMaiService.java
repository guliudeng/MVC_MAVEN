package cn.cry.service;

import cn.cry.bo.base.Rsp;
import cn.cry.bo.base.RspList;
import cn.cry.bo.waiMai.AddWaiMaiReqBO;
import cn.cry.bo.waiMai.QueryWaiMaiReqBO;
import cn.cry.bo.waiMai.UpdateWaiMaiReqBO;

public interface WaiMaiService {
    /**
     * 添加外卖人员
     * @param reqBO
     * @return
     */
    Rsp add(AddWaiMaiReqBO reqBO);

    /**
     * 更新外卖人员信息
     * @param reqBO
     * @return
     */
    Rsp update(UpdateWaiMaiReqBO reqBO);

    /**
     * 查询外卖人员
     * @param reqBO
     * @return
     */
    RspList query(QueryWaiMaiReqBO reqBO);

    /**
     * 删除外卖人员
     * @param waiMaiId
     * @return
     */
    Rsp delete(Integer waiMaiId);
}
