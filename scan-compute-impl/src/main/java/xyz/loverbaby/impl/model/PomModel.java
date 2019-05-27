package xyz.loverbaby.impl.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Classname BaseModel
 * @Description
 * @Date 2019/5/23 上午23:17
 * @Created by Minghao Sun
 */
@Data
public class PomModel implements Serializable {
    /**
     * 创建时间
     */
    private Date createDatetime;

    /**
     * 更新时间
     */
    private Date updateDatetime;


}
