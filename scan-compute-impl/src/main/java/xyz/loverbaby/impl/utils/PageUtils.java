package xyz.loverbaby.impl.utils;


import xyz.loverbaby.api.dto.request.PageRequest;

/**
 * @Classname PageUtils
 * @Description 分页参数默认工具类
 * @Date 2019/5/21 下午8:17
 * @Created by default
 */
public class PageUtils {

    private static final Integer DEFAULT_CURRENT_PAGE = 1;
    private static final Integer DEFAULT_PAGE_SIZE_PAGE = 10;

    public static void defaultPage(PageRequest request){
        if (request.getCurrentPage() == null || request.getCurrentPage() < 0 ){
            request.setCurrentPage(DEFAULT_CURRENT_PAGE);
        }
        if (request.getPageSize() == null || request.getPageSize() < 0 ){
            request.setPageSize(DEFAULT_PAGE_SIZE_PAGE);
        }
    }

    private PageUtils() {
    }
}
