package xyz.loverbaby.api;


import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import xyz.loverbaby.api.dto.common.CommonResult;
import xyz.loverbaby.api.dto.request.BuildRecordAddRequest;
import xyz.loverbaby.api.dto.request.BuildRecordDeleteRequest;
import xyz.loverbaby.api.dto.request.BuildRecordEditRequest;

/**
 * @Classname BuildRecordFacade
 * @Description
 * @Date 2019/5/17 下午1:31
 * @Created by yccao
 */
@FeignClient(value = "${spring.application.name}", path = "/scan/compute/server/buildRecord")
public interface BuildRecordFacade {

    @PostMapping("/:saveForBuild")
    CommonResult<Boolean> insertBuildRecord(@RequestBody BuildRecordAddRequest buildRecordAddRequest);


    @PostMapping("/:updateForBuild")
    CommonResult<Boolean> updateBuildRecord(@RequestBody BuildRecordEditRequest buildRecordEditRequest);

    @PostMapping("/:deleteForBuild")
    CommonResult<Boolean> deleteBuildRecord(@RequestBody BuildRecordDeleteRequest buildRecordDeleteRequest);
}
