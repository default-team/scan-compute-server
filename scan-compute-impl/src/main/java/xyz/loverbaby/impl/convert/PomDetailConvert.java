package xyz.loverbaby.impl.convert;

import org.springframework.beans.BeanUtils;
import xyz.loverbaby.api.dto.request.*;
import xyz.loverbaby.api.dto.response.BuildRecordVO;
import xyz.loverbaby.api.dto.response.PomDetailVO;
import xyz.loverbaby.impl.dao.domain.BuildRecord;
import xyz.loverbaby.impl.dao.domain.PomDetail;
import xyz.loverbaby.impl.model.*;

import java.util.Objects;

/**
 * <p>
 *  Convert
 * </p>
 *
 * @author Minghao Sun
 * @since 2019-05-23
 */

public class PomDetailConvert {
    /**
     * modelToDO
     * @param model
     * @return
     */
    public static PomDetail modelToDO(PomDetailModel model) {
        PomDetail entityDo = new PomDetail();
        if (Objects.nonNull(model)) {
            BeanUtils.copyProperties(model, entityDo);
        }
        return entityDo;
    }

    /**
     * modelToDO
     * @param model
     * @return
     */
    public static PomDetail modelToDO(PomDetailEditModel model) {
        PomDetail entityDo = new PomDetail();
        if (Objects.nonNull(model)) {
            BeanUtils.copyProperties(model, entityDo);
            //entityDo.setStatus(StatusEnum.valueOf(model.getStatus()).getCode());
        }
        return entityDo;
    }


    /**
     * doToModel
     * @param entityDo
     * @return
     */
    public static BuildRecordModel doToModel(BuildRecord entityDo) {
        BuildRecordModel model = new BuildRecordModel();
        if (Objects.nonNull(entityDo)) {
            BeanUtils.copyProperties(entityDo, model);
        }
        return model;
    }

    /**
     * requestToModel
     * @param request
     * @return
     */
    public static PomDetailModel requestToModel(PomDetailAddRequest request) {
        PomDetailModel model = new PomDetailModel();
        if (Objects.nonNull(request)) {
            BeanUtils.copyProperties(request, model);
        }
        return model;
    }

    /**
     * requestToModel
     * @param request
     * @return
     */
    public static PomDetailEditModel requestToModel(PomDetailEditRequest request) {
        PomDetailEditModel model = new PomDetailEditModel();
        if (Objects.nonNull(request)) {
            BeanUtils.copyProperties(request, model);
        }
        return model;
    }

    /**
     * requestToQuery
     * @param request
     * @return
     */
    public static PomDetailPageQuery requestToQuery(PomDetailPageRequest request) {
        PomDetailPageQuery query = new PomDetailPageQuery();
        if (Objects.nonNull(request)) {
            BeanUtils.copyProperties(request, query);
        }
        return query;
    }

    /**
     * modelToVO
     * @param model
     * @return
     */
    public static BuildRecordVO modelToVO(BuildRecordModel model) {
        BuildRecordVO vo = new BuildRecordVO();
        if (Objects.nonNull(model)) {
            BeanUtils.copyProperties(model, vo);
        }
        return vo;
    }
    /**
     * doToVO
     * @param entityDo
     * @return
     */
    public static PomDetailVO doToVO(PomDetail entityDo) {
        PomDetailVO vo = new PomDetailVO();
        if (Objects.nonNull(entityDo)) {
            BeanUtils.copyProperties(entityDo, vo);
        }
        return vo;
    }

}
