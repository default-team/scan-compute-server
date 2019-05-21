package xyz.loverbaby.impl.model;

import lombok.Data;

import java.util.Date;

/**
 * @Classname BuildRecordPageQuery
 * @Description
 * @Date 2019/5/16 下午11:14
 * @Created by yccao
 */
@Data
public class BuildRecordPageQuery {
    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 构建结果
     */
    private String result;

    /**
     * insecurity jar
     */
    private String insecurity;

    /**
     * 描述
     */
    private String description;

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
