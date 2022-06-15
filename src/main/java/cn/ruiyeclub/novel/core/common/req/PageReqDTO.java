package cn.ruiyeclub.novel.core.common.req;

/**
 * 分页请求数据格式封装，所有分页请求的 DTO 类都应继承该类
 *
 * @author: Cr.
 * @date: 2022/6/14
 */
public class PageReqDTO {

    /**
     * 请求页码，默认第一页
     */
    private Integer pageNum = 1;

    /**
     * 分页大小，默认每页十条
     */
    private Integer pageSize = 10;

    /**
     * 是否查询所有，默认不查所有
     * 为true时，pageNum和pageSize无效
     */
    private Boolean fetchAll = false;
}
