package xyz.loverbaby.impl.biz.manager.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.loverbaby.api.dto.common.CommonResult;
import xyz.loverbaby.impl.biz.manager.BuildRecordBiz;
import xyz.loverbaby.impl.biz.manager.PomDetailBiz;
import xyz.loverbaby.impl.convert.BuildRecordConvert;
import xyz.loverbaby.impl.convert.PomDetailConvert;
import xyz.loverbaby.impl.dao.domain.BuildRecord;
import xyz.loverbaby.impl.dao.domain.PomDetail;
import xyz.loverbaby.impl.model.*;
import xyz.loverbaby.impl.service.BuildRecordService;
import xyz.loverbaby.impl.service.PomDetailService;

import java.util.Objects;

/**
 * <p>
 * 
 * </p>
 *
 * @author Minghao Sun
 * @since 2019-05-23
 */
@Service
public class PomDetailBizImpl implements PomDetailBiz {

    @Autowired
    private PomDetailService pomDetailService;

    @Override
    public IPage<PomDetail> queryPage(PomDetailPageQuery request) {
        Page<PomDetail> page = new Page<>(request.getCurrentPage(),request.getPageSize());
        LambdaQueryWrapper<PomDetail> wrapper = createQueryWrapper(request);
        IPage<PomDetail> iPage = pomDetailService.page(page, wrapper);
        iPage.setTotal(pomDetailService.count(wrapper));
        return iPage;
    }
    @Override
    public CommonResult<Boolean> insert(PomDetailModel request) {
        CommonResult<Boolean> result = new CommonResult<>();
        PomDetail pomDetail = PomDetailConvert.modelToDO(request);
        result.setData(pomDetailService.save(pomDetail));
        return result;
    }

    @Override
    public CommonResult<Boolean> update(PomDetailEditModel request) {
        CommonResult<Boolean> result = new CommonResult<>();
        PomDetail pomDetail = PomDetailConvert.modelToDO(request);
        pomDetail = pomDetailService.getById(pomDetail.getId());
        pomDetail.setPom(request.getPom());
        result.setData(pomDetailService.updateById(pomDetail));
        return result;
    }


    private LambdaQueryWrapper<PomDetail> createQueryWrapper(PomDetailPageQuery request) {
        LambdaQueryWrapper<PomDetail> wrapper = Wrappers.lambdaQuery();
         wrapper.eq(Objects.nonNull(request.getPom()),PomDetail::getPom,request.getPom());
         // 排序
         wrapper.orderByDesc(PomDetail::getCreateDatetime);
        return wrapper;
    }

}
