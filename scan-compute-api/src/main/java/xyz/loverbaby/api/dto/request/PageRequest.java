package xyz.loverbaby.api.dto.request;

import lombok.Data;

/**
 * @Classname PageRequest
 * @Description
 * @Date 2019/5/21 下午4:03
 * @Created by yccao
 */
@Data
public class PageRequest extends BaseRequest {
    /**
     * 当前页
     */
    private Integer currentPage;

    /**
     * 每页显示数量
     */
    private Integer pageSize;

    /**
     * 起始位置
     */
    private Integer offset;
}
