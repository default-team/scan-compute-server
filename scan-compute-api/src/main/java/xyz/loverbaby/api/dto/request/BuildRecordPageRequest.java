package xyz.loverbaby.api.dto.request;

import lombok.Data;

import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author default
 * @since 2019-05-16
 */
@Data
public class BuildRecordPageRequest extends PageRequest{


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
     * 更新时间
     */
    private Date updateDatetime;


    private Integer detailId;
}
