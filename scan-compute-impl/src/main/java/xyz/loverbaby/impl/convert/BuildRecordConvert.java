package xyz.loverbaby.impl.convert;

import org.springframework.beans.BeanUtils;
import xyz.loverbaby.api.dto.request.BuildRecordAddRequest;
import xyz.loverbaby.api.dto.request.BuildRecordEditRequest;
import xyz.loverbaby.api.dto.request.BuildRecordPageRequest;
import xyz.loverbaby.api.dto.response.BuildRecordVO;
import xyz.loverbaby.impl.dao.domain.BuildRecord;
import xyz.loverbaby.impl.model.BuildRecordEditModel;
import xyz.loverbaby.impl.model.BuildRecordModel;
import xyz.loverbaby.impl.model.BuildRecordPageQuery;

import java.util.Objects;

/**
 * <p>
 *  Convert
 * </p>
 *
 * @author default
 * @since 2019-05-16
 */

public class BuildRecordConvert {
    /**
     * modelToDO
     * @param model
     * @return
     */
    public static BuildRecord modelToDO(BuildRecordModel model) {
        BuildRecord entityDo = new BuildRecord();
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
    public static BuildRecord modelToDO(BuildRecordEditModel model) {
        BuildRecord entityDo = new BuildRecord();
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
    public static BuildRecordModel requestToModel(BuildRecordAddRequest request) {
        BuildRecordModel model = new BuildRecordModel();
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
    public static BuildRecordEditModel requestToModel(BuildRecordEditRequest request) {
        BuildRecordEditModel model = new BuildRecordEditModel();
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
    public static BuildRecordPageQuery requestToQuery(BuildRecordPageRequest request) {
        BuildRecordPageQuery query = new BuildRecordPageQuery();
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
    public static BuildRecordVO doToVO(BuildRecord entityDo) {
            BuildRecordVO vo = new BuildRecordVO();
        if (Objects.nonNull(entityDo)) {
            BeanUtils.copyProperties(entityDo, vo);
        }
        return vo;
    }

}
