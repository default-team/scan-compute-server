package xyz.loverbaby.api;


import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import xyz.loverbaby.api.dto.common.CommonResult;
import xyz.loverbaby.api.dto.common.Page;
import xyz.loverbaby.api.dto.request.BuildRecordAddRequest;
import xyz.loverbaby.api.dto.request.BuildRecordEditRequest;
import xyz.loverbaby.api.dto.request.BuildRecordPageRequest;
import xyz.loverbaby.api.dto.response.BuildRecordVO;

/**
 * @Classname BuildRecordFacade
 * @Description
 * @Date 2019/5/17 下午1:31
 * @Created by yccao
 */
@FeignClient(value = "scan-compute-server", path = "/scan/compute/server/buildRecord")
public interface BuildRecordFacade {

    @PostMapping("/:saveForBuild")
    CommonResult<Boolean> insertBuildRecord(@RequestBody BuildRecordAddRequest buildRecordAddRequest);

    @PostMapping("/:query")
    CommonResult<Page<BuildRecordVO>> listBuildRecordByPage(@RequestBody BuildRecordPageRequest buildRecordPageRequest);


    @PostMapping("/:updateForBuild")
    CommonResult<Boolean> updateBuildRecord(@RequestBody BuildRecordEditRequest buildRecordEditRequest);

}
