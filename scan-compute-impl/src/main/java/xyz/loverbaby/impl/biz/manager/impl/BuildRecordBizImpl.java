package xyz.loverbaby.impl.biz.manager.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.loverbaby.api.dto.common.CommonResult;
import xyz.loverbaby.impl.biz.manager.BuildRecordBiz;
import xyz.loverbaby.impl.convert.BuildRecordConvert;
import xyz.loverbaby.impl.dao.domain.BuildRecord;
import xyz.loverbaby.impl.model.BuildRecordEditModel;
import xyz.loverbaby.impl.model.BuildRecordModel;
import xyz.loverbaby.impl.model.BuildRecordPageQuery;
import xyz.loverbaby.impl.service.BuildRecordService;

import java.util.Objects;

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
    public IPage<BuildRecord> queryPage(BuildRecordPageQuery request) {
        Page<BuildRecord> page = new Page<>(request.getCurrentPage(),request.getPageSize());
        LambdaQueryWrapper<BuildRecord> wrapper = createQueryWrapper(request);
        IPage<BuildRecord> iPage = buildRecordService.page(page, wrapper);
        iPage.setTotal(buildRecordService.count(wrapper));
        return iPage;
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


    private LambdaQueryWrapper<BuildRecord> createQueryWrapper(BuildRecordPageQuery request) {
        LambdaQueryWrapper<BuildRecord> wrapper = Wrappers.lambdaQuery();
         wrapper.eq(Objects.nonNull(request.getProjectName()),BuildRecord::getProjectName,request.getProjectName())
                .eq(Objects.nonNull(request.getInsecurity()),BuildRecord::getInsecurity,request.getInsecurity())
                .eq(Objects.nonNull(request.getResult()),BuildRecord::getResult,request.getResult())
                .eq(Objects.nonNull(request.getDescription()),BuildRecord::getDescription,request.getDescription());
         // 排序
         wrapper.orderByDesc(BuildRecord::getCreateDatetime);
        return wrapper;
    }

}
