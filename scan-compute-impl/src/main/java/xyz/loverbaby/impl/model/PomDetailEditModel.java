package xyz.loverbaby.impl.model;

import lombok.Data;

/**
 * <p>
 * 
 * </p>
 *
 * @author Minghao Sun
 * @since 2019-05-23
 */
@Data
public class PomDetailEditModel {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * pom内容
     */
    private String pom;

}
