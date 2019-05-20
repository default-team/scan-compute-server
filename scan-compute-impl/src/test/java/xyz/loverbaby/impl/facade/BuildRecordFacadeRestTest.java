package xyz.loverbaby.impl.facade;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.loverbaby.api.dto.common.CommonResult;
import xyz.loverbaby.api.dto.request.BuildRecordAddRequest;

import java.util.Date;

import static org.junit.Assert.*;

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
}