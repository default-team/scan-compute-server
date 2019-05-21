package xyz.loverbaby.impl.facade;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.loverbaby.api.BuildRecordFacade;
import xyz.loverbaby.api.dto.common.CommonResult;
import xyz.loverbaby.api.dto.common.Page;
import xyz.loverbaby.api.dto.request.BuildRecordAddRequest;
import xyz.loverbaby.api.dto.request.BuildRecordEditRequest;
import xyz.loverbaby.api.dto.request.BuildRecordPageRequest;
import xyz.loverbaby.api.dto.response.BuildRecordVO;
import xyz.loverbaby.impl.biz.manager.BuildRecordBiz;
import xyz.loverbaby.impl.common.handler.CallBack;
import xyz.loverbaby.impl.common.handler.ScanComputeHandler;
import xyz.loverbaby.impl.common.verify.ArgumentVerify;
import xyz.loverbaby.impl.convert.BuildRecordConvert;
import xyz.loverbaby.impl.dao.domain.BuildRecord;
import xyz.loverbaby.impl.model.BuildRecordEditModel;
import xyz.loverbaby.impl.model.BuildRecordModel;
import xyz.loverbaby.impl.model.BuildRecordPageQuery;
import xyz.loverbaby.impl.utils.PageUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Classname BuildRecordFacadeRest
 * @Description
 * @Date 2019/5/17 下午1:55
 * @Created by yccao
 */
@RestController
@RequestMapping("/scan/compute/server/buildRecord")
public class BuildRecordFacadeRest implements BuildRecordFacade {

    @Autowired
    private BuildRecordBiz buildRecordBiz;

    @Override
    public CommonResult<Boolean> insertBuildRecord(@RequestBody BuildRecordAddRequest buildRecordAddRequest) {
        CommonResult<Boolean> result = new CommonResult<>();
        ScanComputeHandler.execute(buildRecordAddRequest,result, new CallBack() {
            @Override
            public void check() {
                ArgumentVerify.assertParam(buildRecordAddRequest.getProjectName()!= null, "项目名称为空");
                ArgumentVerify.assertParam(buildRecordAddRequest.getInsecurity()!= null, "目标jar为空");
                ArgumentVerify.assertParam(buildRecordAddRequest.getDetailId()!= null, "详情id为空");
            }

            @Override
            public void invoke() {
                BuildRecordModel buildRecordModel = BuildRecordConvert.requestToModel(buildRecordAddRequest);
                result.setData(buildRecordBiz.insert(buildRecordModel).getData());
            }
        });
        return result;
    }

    @Override
    public CommonResult<Page<BuildRecordVO>> listBuildRecordByPage(BuildRecordPageRequest buildRecordPageRequest) {
        CommonResult<Page<BuildRecordVO>> result = new CommonResult<>();
        ScanComputeHandler.execute(buildRecordPageRequest, result, new CallBack() {
            @Override
            public void check() {

            }

            @Override
            public void invoke() {
                PageUtils.defaultPage(buildRecordPageRequest);
                BuildRecordPageQuery pageQuery = BuildRecordConvert.requestToQuery(buildRecordPageRequest);
                IPage<BuildRecord> voiPage = buildRecordBiz.queryPage(pageQuery);
                Page<BuildRecordVO> buildRecordPage = new Page<>(buildRecordPageRequest.getPageSize(), buildRecordPageRequest.getPageSize(), voiPage.getTotal());
                List<BuildRecordVO> buildRecordVOS = voiPage.getRecords().stream().map(BuildRecordConvert::doToVO).collect(Collectors.toList());
                buildRecordPage.setList(buildRecordVOS);
                result.setData(buildRecordPage);

            }
        });
        return result;
    }


    /**
     *  修改方法
     * @param buildRecordEditRequest
     * @return
     */
    @Override
    public CommonResult<Boolean> updateBuildRecord(@RequestBody BuildRecordEditRequest buildRecordEditRequest) {
        CommonResult<Boolean> result = new CommonResult<>();
        ScanComputeHandler.execute(buildRecordEditRequest,result, new CallBack() {
            @Override
            public void check() {
                ArgumentVerify.assertParam(buildRecordEditRequest.getId()!= null, "项目id为空");
            }

            @Override
            public void invoke() {
                BuildRecordEditModel buildRecordEditModel = BuildRecordConvert.requestToModel(buildRecordEditRequest);
                result.setData(buildRecordBiz.update(buildRecordEditModel).getData());
            }
        });
        return result;
    }

}
