package xyz.loverbaby.impl.model;

import lombok.Data;

/**
 * <p>
 * 
 * </p>
 *
 * @author default
 * @since 2019-05-16
 */
@Data

public class BuildRecordModel extends BaseModel{

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
     * 详情id
     */
    private Integer detailId;
}
