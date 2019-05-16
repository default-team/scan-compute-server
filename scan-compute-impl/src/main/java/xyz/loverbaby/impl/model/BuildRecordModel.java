package xyz.loverbaby.impl.model;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author default
 * @since 2019-05-16
 */
@Data

public class BuildRecordModel {

    private static final long serialVersionUID = 1L;

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
    private LocalDateTime createDatetime;

    /**
     * 更新时间
     */
    private LocalDateTime updateDatetime;

    /**
     * 状态 -1：已废弃，0：正常
     */
    private Integer status;

    private Integer detailId;
}
