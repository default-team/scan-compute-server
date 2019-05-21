package xyz.loverbaby.impl.biz.manager.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.loverbaby.api.dto.common.CommonResult;
import xyz.loverbaby.api.dto.response.BuildRecordVO;
import xyz.loverbaby.impl.biz.manager.BuildRecordBiz;
import xyz.loverbaby.impl.convert.BuildRecordConvert;
import xyz.loverbaby.impl.dao.domain.BuildRecord;
import xyz.loverbaby.impl.model.BuildRecordEditModel;
import xyz.loverbaby.impl.model.BuildRecordModel;
import xyz.loverbaby.impl.model.BuildRecordPageQuery;
import xyz.loverbaby.impl.service.BuildRecordService;

/**
 * <p>
 * 
 * </p>
 *
 * @author default
 * @since 2019-05-16
 */
@Service
public class BuildRecordBizImpl implements BuildRecordBiz {

    @Autowired
    private BuildRecordService buildRecordService;

    @Override
    public IPage<BuildRecordVO> queryPage(BuildRecordPageQuery request) {
        return null;
    }

    @Override
    public CommonResult<Boolean> insert(BuildRecordModel request) {
        CommonResult<Boolean> result = new CommonResult<>();
        BuildRecord buildRecord = BuildRecordConvert.modelToDO(request);
        result.setData(buildRecordService.save(buildRecord));
        return result;
    }

    @Override
    public CommonResult<Boolean> update(BuildRecordEditModel request) {
        CommonResult<Boolean> result = new CommonResult<>();
        BuildRecord buildRecord = BuildRecordConvert.modelToDO(request);
        buildRecord = buildRecordService.getById(buildRecord.getId());
        buildRecord.setResult(request.getResult());
        result.setData(buildRecordService.updateById(buildRecord));
        return result;
    }

}
