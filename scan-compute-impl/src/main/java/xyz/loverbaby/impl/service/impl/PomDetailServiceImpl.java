package xyz.loverbaby.impl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import xyz.loverbaby.impl.dao.domain.BuildRecord;
import xyz.loverbaby.impl.dao.domain.PomDetail;
import xyz.loverbaby.impl.dao.mapper.BuildRecordMapper;
import xyz.loverbaby.impl.dao.mapper.PomDetailMapper;
import xyz.loverbaby.impl.service.BuildRecordService;
import xyz.loverbaby.impl.service.PomDetailService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Minghao Sun
 * @since 2019-05-23
 */
@Service
public class PomDetailServiceImpl extends ServiceImpl<PomDetailMapper, PomDetail> implements PomDetailService {

}