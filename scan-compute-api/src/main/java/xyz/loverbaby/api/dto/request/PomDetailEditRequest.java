package xyz.loverbaby.api.dto.request;

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
public class PomDetailEditRequest extends BaseRequest{

    /**
     * id
     */
    private Long id;

    /**
     * pom
     */
    private String pom;

}
