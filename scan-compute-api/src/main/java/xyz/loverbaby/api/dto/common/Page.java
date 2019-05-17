package xyz.loverbaby.api.dto.common;

import lombok.Data;

import java.util.List;

/**
 * @Classname Page
 * @Description
 * @Date 2019/5/16 下午11:40
 * @Created by yccao
 */
@Data
public class Page <T>{

    private Integer pageNo;
    private Integer pageSize;
    private Long totalCount;
    private List<T> list;
    private Long pageCount;

    public Page(Integer pageNo, Integer pageSize, Long totalCount, List<T> list) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.list = list;
        if (totalCount != null && pageSize != null && pageSize != 0) {
            this.pageCount = totalCount % (long)pageSize > 0L ? totalCount / (long)pageSize + 1L : totalCount / (long)pageSize;
        } else {
            this.pageCount = 1L;
        }

    }


}
