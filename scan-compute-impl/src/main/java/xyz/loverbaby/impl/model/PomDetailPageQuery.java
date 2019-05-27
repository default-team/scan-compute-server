package xyz.loverbaby.impl.model;

import lombok.Data;

import java.util.Date;

/**
 * @Classname PomDetailPageQuery
 * @Description
 * @Date 2019/5/23 下午23:23
 * @Created by Minghao Sun
 */
@Data
public class PomDetailPageQuery {
    /**
     * pom
     */
    private String pom;

    /**
     * 创建时间
     */
    private Date createDatetime;

    /**
     * 当前页
     */
    private Integer currentPage;

    /**
     * 每页显示数量
     */
    private Integer pageSize;

}
