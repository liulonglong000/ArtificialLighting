package com.face.common;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Page<T> {
    private int pageIndex;
    private int pageSize;
    private int totalItemCount;
    private int totalPageCount;
    private List<T> data;

    
    
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	public Page() {
		// TODO Auto-generated constructor stub
	}
    /**
     *
     * @param pageIndex // 当前第多少页
     * @param pageSize // 每页大小
     * @param totalItemCount // 总数
     * @param data // 数据载体
     * @param hasPaged // 是否已经分页
     */
    public Page(int pageIndex, int pageSize, int totalItemCount, List<T> data, boolean hasPaged) {
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.totalItemCount = totalItemCount;
        initPage(pageIndex, pageSize, totalItemCount, data, hasPaged);
    }

    private void initPage(int pageIndex, int pageSize, int totalItemCount, List<T> data, boolean hasPaged) {
        // 计算总页数
        if (totalItemCount > 0 && pageSize > 0) {
            this.totalPageCount = totalItemCount % pageSize == 0 ? totalItemCount/pageSize :totalItemCount/pageSize + 1;
        }
        // 截取当前页数据
        if (null == data) {
            this.data = new ArrayList<T>();
        } else if (data.isEmpty() || hasPaged) {
            this.data = data;
        } else {
            if (pageIndex == this.totalPageCount || pageIndex > this.totalPageCount) { // 最后一页
                pageIndex = this.totalPageCount;
                this.data = data.subList((pageIndex-1)*pageSize, data.size());
            } else if (pageIndex < this.totalPageCount) { // 不是最后一页
                this.data = data.subList((pageIndex-1)*pageSize, pageIndex*pageSize);
            } else { // 当前页超出总页数
                throw new IndexOutOfBoundsException("当前页数超出总页数范围");
            }
        }
    }

}
