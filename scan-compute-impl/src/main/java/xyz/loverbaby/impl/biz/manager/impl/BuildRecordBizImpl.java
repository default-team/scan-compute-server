package xyz.loverbaby.impl.biz.manager.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.loverbaby.api.dto.request.BuildRecordAddRequest;
import xyz.loverbaby.api.dto.request.BuildRecordEditRequest;
import xyz.loverbaby.api.dto.request.BuildRecordPageRequest;
import xyz.loverbaby.api.dto.response.BuildRecordVO;
import xyz.loverbaby.impl.biz.manager.BuildRecordBiz;
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
    public IPage<BuildRecordVO> queryPage(BuildRecordPageRequest request) {
        return null;
    }

    @Override
    public boolean insertCrawlerSkuBrand(BuildRecordAddRequest request) {
        return false;
    }

    @Override
    public boolean upCrawlerSkuBrand(BuildRecordEditRequest request) {
        return false;
    }

    @Override
    public boolean delCrawlerSkuBrand(BuildRecordEditRequest request) {
        return false;
    }
}
