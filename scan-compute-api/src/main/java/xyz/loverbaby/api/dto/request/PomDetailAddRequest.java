package xyz.loverbaby.api.dto.request;

import lombok.Data;

/**
 *
 * @Date 2019/5/23 下午22:35
 * @Created by Minghao Sun
 */
@Data
public class PomDetailAddRequest extends BaseRequest{

    /**
     * pom内容
     */
    private String pom;
}
