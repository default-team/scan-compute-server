package xyz.loverbaby.impl.facade;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import xyz.loverbaby.api.BuildRecordFacade;
import xyz.loverbaby.api.dto.common.CommonResult;
import xyz.loverbaby.api.dto.request.BuildRecordAddRequest;
import xyz.loverbaby.impl.biz.manager.BuildRecordBiz;
import xyz.loverbaby.impl.common.handler.CallBack;
import xyz.loverbaby.impl.common.handler.ScanComputeHandler;
import xyz.loverbaby.impl.common.verify.ArgumentVerify;
import xyz.loverbaby.impl.convert.BuildRecordConvert;
import xyz.loverbaby.impl.model.BuildRecordModel;

/**
 * @Classname BuildRecordFacadeRest
 * @Description
 * @Date 2019/5/17 下午1:55
 * @Created by yccao
 */
@Service
public class BuildRecordFacadeRest implements BuildRecordFacade {

    private BuildRecordBiz buildRecordBiz;

    @Override
    public CommonResult<Boolean> insertBuildRecord(@RequestBody BuildRecordAddRequest buildRecordAddRequest) {
        CommonResult<Boolean> result = new CommonResult<>();
        ScanComputeHandler.execute(result, new CallBack() {
            @Override
            public void check() {
                ArgumentVerify.assertParam(buildRecordAddRequest.getProjectName()!= null, "项目名称为空");
                ArgumentVerify.assertParam(buildRecordAddRequest.getInsecurity()!= null, "目标jar为空");
                ArgumentVerify.assertParam(buildRecordAddRequest.getDetailId()!= null, "详情id为空");
            }

            @Override
            public CommonResult invoke() {
                BuildRecordModel buildRecordModel = BuildRecordConvert.requestToModel(buildRecordAddRequest);
                return buildRecordBiz.insert(buildRecordModel);
            }
        });
        return result;
    }
}
