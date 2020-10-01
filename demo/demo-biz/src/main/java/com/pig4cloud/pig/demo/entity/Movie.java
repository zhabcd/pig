/*
 *    Copyright (c) 2018-2025, lengleng All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 * Neither the name of the pig4cloud.com developer nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 * Author: lengleng (wangiegie@gmail.com)
 */

package com.pig4cloud.pig.demo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 电影表
 *
 * @author pig code generator
 * @date 2020-10-01 12:44:02
 */
@Data
@TableName("movie")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "电影表")
public class Movie extends Model<Movie> {
private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId
    @ApiModelProperty(value="ID")
    private Long id;
    /**
     * 名称
     */
    @ApiModelProperty(value="名称")
    private String name;
    /**
     * 描述
     */
    @ApiModelProperty(value="描述")
    private String description;
    /**
     * 封面地址
     */
    @ApiModelProperty(value="封面地址")
    private String picUrl;
    /**
     * 电影地址
     */
    @ApiModelProperty(value="电影地址")
    private String url;
    /**
     * 分类，如国产、欧美、日韩等
     */
    @ApiModelProperty(value="分类，如国产、欧美、日韩等")
    private String category;
    /**
     * 类型，1为普通电影，2为收费电影，3为VIP电影
     */
    @ApiModelProperty(value="类型，1为普通电影，2为收费电影，3为VIP电影")
    private Integer type;
    /**
     * 是否显示，0为false，1为true
     */
    @ApiModelProperty(value="是否显示，0为false，1为true")
    private Integer isShow;
    /**
     * 备注
     */
    @ApiModelProperty(value="备注")
    private String remark;
    /**
     * 创建时间
     */
    @ApiModelProperty(value="创建时间")
    private LocalDateTime createTime;
    /**
     * 更新时间
     */
    @ApiModelProperty(value="更新时间")
    private LocalDateTime updateTime;
    }
