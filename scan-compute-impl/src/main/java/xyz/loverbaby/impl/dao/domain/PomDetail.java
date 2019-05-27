package xyz.loverbaby.impl.dao.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
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
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("scan_pom_detail")
public class PomDetail implements Serializable {

    private static final long serialVersionUID = 1L;

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
