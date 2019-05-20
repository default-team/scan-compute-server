package xyz.loverbaby.impl.facade;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.loverbaby.api.dto.common.CommonResult;
import xyz.loverbaby.api.dto.request.BuildRecordAddRequest;
import xyz.loverbaby.api.dto.request.BuildRecordDeleteRequest;
import xyz.loverbaby.api.dto.request.BuildRecordEditRequest;

/**
 * @Classname BuildRecordFacadeRestTest
 * @Description
 * @Date 2019/5/20 上午10:02
 * @Created by yccao
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BuildRecordFacadeRestTest {

    @Autowired
    private BuildRecordFacadeRest buildRecordFacadeRest;

    @Test
    public void insertBuildRecord() {
        BuildRecordAddRequest request = new BuildRecordAddRequest();
        request.setProjectName("gtr");
        request.setDescription("desc");
        request.setInsecurity("<project></project>");
        request.setDetailId(1);
        request.setResult("success");
        CommonResult<Boolean> result = buildRecordFacadeRest.insertBuildRecord(request);
        Assert.assertTrue(result.isSuccess());
    }

    @Test
    public void updateBuildRecord() {
        BuildRecordEditRequest request = new BuildRecordEditRequest();
        request.setProjectName("gtr");
        request.setDescription("desc");
        request.setInsecurity("<project></project>");
        request.setDetailId(1);
        request.setResult("success");
        request.setId(1L);
        request.setStatus(0);
        CommonResult<Boolean> result = buildRecordFacadeRest.updateBuildRecord(request);
        Assert.assertTrue(result.isSuccess());
    }


    @Test
    public void deleteBuildRecord() {
        BuildRecordDeleteRequest request = new BuildRecordDeleteRequest();
        request.setId(1);
        CommonResult<Boolean> result = buildRecordFacadeRest.deleteBuildRecord(request);
        Assert.assertTrue(result.isSuccess());
    }
}