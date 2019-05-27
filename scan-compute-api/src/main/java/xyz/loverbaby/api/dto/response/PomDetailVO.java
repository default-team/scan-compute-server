package xyz.loverbaby.api.dto.response;

import lombok.Data;

import java.util.Date;

/**
 *
 * @Date 2019/5/23 下午22:39
 * @Created by Minghao Sun
 */
@Data
public class PomDetailVO {

    /**
     * id
     */
    private Long id;
    /**
     * pom内容
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
