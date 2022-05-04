package cn.cry.service.imp;

import cn.cry.bo.base.Rsp;
import cn.cry.bo.base.RspList;
import cn.cry.bo.waiMai.AddWaiMaiReqBO;
import cn.cry.bo.waiMai.QueryWaiMaiReqBO;
import cn.cry.bo.waiMai.UpdateWaiMaiReqBO;
import cn.cry.mapper.BsWaiMaiMapper;
import cn.cry.po.BsWaiMai;
import cn.cry.service.WaiMaiService;
import cn.cry.utils.BaseRspUtils;
import cn.cry.utils.DateUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class WaiMaiServiceImp implements WaiMaiService {

    @Resource
    private BsWaiMaiMapper bsWaiMaiMapper;

    @Override
    public Rsp add(AddWaiMaiReqBO reqBO) {
        System.out.println("添加外卖人员入参="+reqBO);
        BsWaiMai po = new BsWaiMai();
        po.setTenantId(reqBO.getTenantId());
        po.setWaiMaiAddress(reqBO.getWaiMaiAddress());
        po.setWaiMaiName(reqBO.getWaiMaiName());
        po.setWaiMaiPhone(reqBO.getWaiMaiPhone());
        po.setCreateTime(DateUtils.timeForm());
        int i = bsWaiMaiMapper.insertSelective(po);
        if (i > 0 ) {
            return BaseRspUtils.createSuccessRsp("添加外卖人员成功");
        }
        return BaseRspUtils.createErrorRsp("添加外卖人员失败");
    }

    @Override
    public Rsp update(UpdateWaiMaiReqBO reqBO) {
        System.out.println("更新外卖人员入参="+reqBO);
        BsWaiMai po = new BsWaiMai();
       po.setWaiMaiId(reqBO.getWaiMaiId());
       po.setWaiMaiPhone(reqBO.getWaiMaiPhone());
       po.setWaiMaiName(reqBO.getWaiMaiName());
       po.setWaiMaiAddress(reqBO.getWaiMaiAddress());
        int i = bsWaiMaiMapper.updateByPrimaryKeySelective(po);
        if (i > 0 ) {
            return BaseRspUtils.createSuccessRsp("修改外卖人员成功");
        }
        return BaseRspUtils.createErrorRsp("修改外卖人员失败");
    }

    @Override
    public RspList query(QueryWaiMaiReqBO reqBO) {
        System.out.println("查询外卖人员入参="+reqBO);
        BsWaiMai po = new BsWaiMai();
        po.setWaiMaiName(reqBO.getWaiMaiName());
        po.setWaiMaiPhone(reqBO.getWaiMaiPhone());
        po.setTenantId(reqBO.getTenantId());
        List<BsWaiMai> waiMaiList = bsWaiMaiMapper.selectActive(po);
        //分页
        return BaseRspUtils.createSuccessRspList(waiMaiList);
    }

    @Override
    public Rsp delete(Integer waiMaiId) {
        BsWaiMai bsWaiMai = new BsWaiMai();
        bsWaiMai.setDeleteFlag("1");
        bsWaiMai.setWaiMaiId(waiMaiId);
        int i = bsWaiMaiMapper.updateByPrimaryKeySelective(bsWaiMai);

        if (i > 0 ) {
            return BaseRspUtils.createSuccessRsp("删除外卖人员成功");
        }
        return BaseRspUtils.createErrorRsp("删除外卖人员失败");
    }
}
