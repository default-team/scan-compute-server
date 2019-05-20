package xyz.loverbaby.impl.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Classname BaseModel
 * @Description
 * @Date 2019/5/20 上午10:53
 * @Created by yccao
 */
@Data
public class BaseModel implements Serializable {
    /**
     * 创建时间
     */
    private Date createDatetime;

    /**
     * 更新时间
     */
    private Date updateDatetime;

    /**
     * 状态
     */
    private String status;


}
