package com.sz.gmall.vo;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@ApiModel(value="PageInfoVO对象", description="分页vo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageInfoVO implements Serializable {
    @ApiModelProperty("总记录数")
    private Long total;
    @ApiModelProperty("总页码")
    private Long totalPage;
    @ApiModelProperty("每页显示的记录数")
    private Long pageSize;
    @ApiModelProperty("每页显示的数据")
    private List<? extends Object> list;
    @ApiModelProperty("当前页的页码")
    private Long pageNum;

    public static PageInfoVO getPage(IPage iPage,Long pageSize){
        return new PageInfoVO(iPage.getTotal(),iPage.getPages(),pageSize,iPage.getRecords(),iPage.getCurrent());
    }

}
