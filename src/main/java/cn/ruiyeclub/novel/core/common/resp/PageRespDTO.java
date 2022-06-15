package cn.ruiyeclub.novel.core.common.resp;

import lombok.Getter;

import java.util.List;

/**
 * 分页响应数据格式封装
 *
 * @author: Cr.
 * @date: 2022/6/14
 */
@Getter
public class PageRespDTO<T> {

    /**
     * 页码
     */
    private final Long pageNum;

    /**
     * 每页大小
     */
    private final Long pageSize;

    /**
     * 总记录数
     */
    private final Long total;

    /**
     * 分页数据集
     */
    private final List<? extends T> list;

    /**
     * 该构造函数用于通用分页查询的场景
     * 接收普通分页数据和普通集合
     */
    public PageRespDTO(Long pageNum, Long pageSize, Long total, List<T> list) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.total = total;
        this.list = list;
    }

    public static <T> PageRespDTO<T> of(Long pageNum, Long pageSize, Long total, List<T> list) {
        return new PageRespDTO<>(pageNum, pageSize, total, list);
    }

    /**
     * 获取分页数
     */
    public Long getPages() {
        if (this.pageSize == 0L) {
            return 0L;
        } else {
            Long pages = this.total / this.pageSize;
            if (this.total % this.pageSize != 0L) {
                ++pages;
            }
            return pages;
        }
    }
}
