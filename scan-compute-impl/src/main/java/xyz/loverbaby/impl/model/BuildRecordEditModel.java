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
public class BuildRecordEditModel {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * 构建结果
     */
    private String result;

}
