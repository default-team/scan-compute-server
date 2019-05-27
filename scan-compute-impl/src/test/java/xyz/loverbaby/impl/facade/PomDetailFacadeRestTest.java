package xyz.loverbaby.impl.facade;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.loverbaby.api.dto.common.CommonResult;
import xyz.loverbaby.api.dto.common.Page;
import xyz.loverbaby.api.dto.request.*;
import xyz.loverbaby.api.dto.response.BuildRecordVO;

/**
 * @Classname PomDetailFacadeRestTest
 * @Description
 * @Date 2019/5/23 上午23:33
 * @Created by Minghao Sun
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@EnableEurekaClient
public class PomDetailFacadeRestTest {

    @Autowired
    private PomDetailFacadeRest pomDetailFacadeRest;

    @Test
    public void insertPomDetail() {
        PomDetailAddRequest request = new PomDetailAddRequest();
        request.setPom("<properties></properties>");
        CommonResult<Boolean> result = pomDetailFacadeRest.insertPomDetail(request);
        Assert.assertTrue(result.isSuccess());
    }

    @Test
    public void updatePomDetail() {
        PomDetailEditRequest request = new PomDetailEditRequest();
        request.setPom("<properties>success</properties>");
        request.setId(1L);
        CommonResult<Boolean> result = pomDetailFacadeRest.updatePomDetail(request);
        Assert.assertTrue(result.isSuccess());
    }



/*    @Test
    public void queryBuildRecordPage() {
        BuildRecordPageRequest buildRecordPageRequest = new BuildRecordPageRequest();
        CommonResult<Page<BuildRecordVO>> result = buildRecordFacadeRest.listBuildRecordByPage(buildRecordPageRequest);
        Assert.assertTrue(result.isSuccess());
    }*/

}