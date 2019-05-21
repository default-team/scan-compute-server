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
public class BuildRecordEditRequest extends BaseRequest{

    /**
     * id
     */
    private Long id;

    /**
     * 构建结果
     */
    private String result;

}
