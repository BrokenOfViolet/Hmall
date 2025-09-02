package com.hmall.domain.query;

import com.hmall.common.domain.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true) // 自动生成equals()和hascode()方法,参数表示如果继承了父类,则在计算时也会考虑父类的字段
@Data // 自动生成构造方法
@ApiModel(description = "商品分页查询条件") // swagger文档描述
public class ItemPageQuery extends PageQuery {
    @ApiModelProperty("搜索关键字")
    private String key;
    @ApiModelProperty("商品分类")
    private String category;
    @ApiModelProperty("商品品牌")
    private String brand;
    @ApiModelProperty("价格最小值")
    private Integer minPrice;
    @ApiModelProperty("价格最大值")
    private Integer maxPrice;
}
