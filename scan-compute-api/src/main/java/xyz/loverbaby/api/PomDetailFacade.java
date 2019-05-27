package xyz.loverbaby.api;


import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import xyz.loverbaby.api.dto.common.CommonResult;
import xyz.loverbaby.api.dto.common.Page;
import xyz.loverbaby.api.dto.request.*;
import xyz.loverbaby.api.dto.response.BuildRecordVO;
import xyz.loverbaby.api.dto.response.PomDetailVO;

/**
 * @Classname PomDetailFacade
 * @Description
 * @Date 2019/5/23 下午22:31
 * @Created by Minghao Sun
 */
@FeignClient(value = "scan-compute-server", path = "/scan/compute/server/pomDetailFacade")
public interface PomDetailFacade {

    @PostMapping("/:savePomDetail")
    CommonResult<Boolean> insertPomDetail(@RequestBody PomDetailAddRequest pomDetailAddRequest);

    @PostMapping("/:queryPomDetail")
    CommonResult<Page<PomDetailVO>> listPomDetailByPage(@RequestBody PomDetailPageRequest pomDetailPageRequest);


    @PostMapping("/:updatePomDetail")
    CommonResult<Boolean> updatePomDetail(@RequestBody PomDetailEditRequest pomDetailEditRequest);

}
