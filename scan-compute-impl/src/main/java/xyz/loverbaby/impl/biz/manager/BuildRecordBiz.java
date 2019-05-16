package xyz.loverbaby.impl.biz.manager;


import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.stereotype.Service;
import xyz.loverbaby.api.dto.request.BuildRecordAddRequest;
import xyz.loverbaby.api.dto.request.BuildRecordEditRequest;
import xyz.loverbaby.api.dto.request.BuildRecordPageRequest;
import xyz.loverbaby.api.dto.response.BuildRecordVO;

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

    IPage<BuildRecordVO> queryPage(BuildRecordPageRequest request);

    boolean insertCrawlerSkuBrand(BuildRecordAddRequest request);

    boolean upCrawlerSkuBrand(BuildRecordEditRequest request);

    boolean delCrawlerSkuBrand(BuildRecordEditRequest request);
}
