package xyz.loverbaby.impl.biz.manager;


import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.stereotype.Service;
import xyz.loverbaby.api.dto.common.CommonResult;
import xyz.loverbaby.api.dto.response.BuildRecordVO;
import xyz.loverbaby.impl.model.BuildRecordEditModel;
import xyz.loverbaby.impl.model.BuildRecordModel;
import xyz.loverbaby.impl.model.BuildRecordPageQuery;

/**
 * <p>
 * 
 * </p>
 *
 * @author default
 * @since 2019-05-16
 */
@Service
public interface BuildRecordBiz {

    IPage<BuildRecordVO> queryPage(BuildRecordPageQuery request);

    CommonResult<Boolean> insert(BuildRecordModel request);

    CommonResult<Boolean> update(BuildRecordEditModel request);

    CommonResult<Boolean> delete(Integer id);
}
