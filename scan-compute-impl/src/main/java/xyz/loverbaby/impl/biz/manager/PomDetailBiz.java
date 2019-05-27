package xyz.loverbaby.impl.biz.manager;


import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.stereotype.Service;
import xyz.loverbaby.api.dto.common.CommonResult;
import xyz.loverbaby.impl.dao.domain.BuildRecord;
import xyz.loverbaby.impl.dao.domain.PomDetail;
import xyz.loverbaby.impl.model.*;

/**
 * <p>
 * 
 * </p>
 *
 * @author Minghao Sun
 * @since 2019-05-23
 */
@Service
public interface PomDetailBiz {

    IPage<PomDetail> queryPage(PomDetailPageQuery request);

    CommonResult<Boolean> insert(PomDetailModel request);

    CommonResult<Boolean> update(PomDetailEditModel request);

}
