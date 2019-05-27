package xyz.loverbaby.impl.facade;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.loverbaby.api.BuildRecordFacade;
import xyz.loverbaby.api.PomDetailFacade;
import xyz.loverbaby.api.dto.common.CommonResult;
import xyz.loverbaby.api.dto.common.Page;
import xyz.loverbaby.api.dto.request.*;
import xyz.loverbaby.api.dto.response.BuildRecordVO;
import xyz.loverbaby.api.dto.response.PomDetailVO;
import xyz.loverbaby.impl.biz.manager.BuildRecordBiz;
import xyz.loverbaby.impl.biz.manager.PomDetailBiz;
import xyz.loverbaby.impl.common.handler.CallBack;
import xyz.loverbaby.impl.common.handler.ScanComputeHandler;
import xyz.loverbaby.impl.common.verify.ArgumentVerify;
import xyz.loverbaby.impl.convert.BuildRecordConvert;
import xyz.loverbaby.impl.convert.PomDetailConvert;
import xyz.loverbaby.impl.dao.domain.BuildRecord;
import xyz.loverbaby.impl.dao.domain.PomDetail;
import xyz.loverbaby.impl.model.*;
import xyz.loverbaby.impl.utils.PageUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Classname PomDetailFacadeRest
 * @Description
 * @Date 2019/5/23 下午1:55
 * @Created by Minghao Sun
 */
@RestController
@RequestMapping("/scan/compute/server/pomDetailFacade")
public class PomDetailFacadeRest implements PomDetailFacade {

    @Autowired
    private PomDetailBiz pomDetailBiz;

    @Override
    public CommonResult<Boolean> insertPomDetail(@RequestBody PomDetailAddRequest pomDetailAddRequest) {
        CommonResult<Boolean> result = new CommonResult<>();
        ScanComputeHandler.execute(pomDetailAddRequest,result, new CallBack() {
            @Override
            public void check() {
                ArgumentVerify.assertParam(pomDetailAddRequest.getPom()!= null, "pom内容为空");
            }

            @Override
            public void invoke() {
                PomDetailModel pomDetailModel = PomDetailConvert.requestToModel(pomDetailAddRequest);
                result.setData(pomDetailBiz.insert(pomDetailModel).getData());
            }
        });
        return result;
    }

    @Override
    public CommonResult<Page<PomDetailVO>> listPomDetailByPage(PomDetailPageRequest pomDetailPageRequest) {
        CommonResult<Page<PomDetailVO>> result = new CommonResult<>();
        ScanComputeHandler.execute(pomDetailPageRequest, result, new CallBack() {
            @Override
            public void check() {

            }

            @Override
            public void invoke() {
                PageUtils.defaultPage(pomDetailPageRequest);
                PomDetailPageQuery pageQuery = PomDetailConvert.requestToQuery(pomDetailPageRequest);
                IPage<PomDetail> voiPage = pomDetailBiz.queryPage(pageQuery);
                Page<PomDetailVO> pomDetailPage = new Page<>(pomDetailPageRequest.getPageSize(), pomDetailPageRequest.getPageSize(), voiPage.getTotal());
                List<PomDetailVO> pomDetailVOS = voiPage.getRecords().stream().map(PomDetailConvert::doToVO).collect(Collectors.toList());
                pomDetailPage.setList(pomDetailVOS);
                result.setData(pomDetailPage);

            }
        });
        return result;
    }


    /**
     *  修改方法
     * @param pomDetailEditRequest
     * @return
     */
    @Override
    public CommonResult<Boolean> updatePomDetail(@RequestBody PomDetailEditRequest pomDetailEditRequest) {
        CommonResult<Boolean> result = new CommonResult<>();
        ScanComputeHandler.execute(pomDetailEditRequest,result, new CallBack() {
            @Override
            public void check() {
                ArgumentVerify.assertParam(pomDetailEditRequest.getId()!= null, "pom详情id为空");
            }

            @Override
            public void invoke() {
                PomDetailEditModel pomDetailEditModel = PomDetailConvert.requestToModel(pomDetailEditRequest);
                result.setData(pomDetailBiz.update(pomDetailEditModel).getData());
            }
        });
        return result;
    }

}
