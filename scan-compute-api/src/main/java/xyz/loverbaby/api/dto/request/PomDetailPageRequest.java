package xyz.loverbaby.api.dto.request;

import lombok.Data;

import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author Minghao Sun
 * @since 2019-05-23
 */
@Data
public class PomDetailPageRequest extends PageRequest{


    /**
     * pom
     */
    private String pom;

    /**
     * 创建时间
     */
    private Date createDatetime;

    /**
     * 更新时间
     */
    private Date updateDatetime;

}
