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

package com.pig4cloud.pig.demo.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pig4cloud.pig.common.core.util.R;
import com.pig4cloud.pig.common.log.annotation.SysLog;
import com.pig4cloud.pig.demo.entity.MovieCategory;
import com.pig4cloud.pig.demo.service.MovieCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;


/**
 * 电影分类表
 *
 * @author pig code generator
 * @date 2020-10-01 12:44:02
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/moviecategory" )
@Api(value = "moviecategory", tags = "电影分类表管理")
@Slf4j
public class MovieCategoryController {

    private final  MovieCategoryService movieCategoryService;
	private LocalDateTime localDateTime = LocalDateTime.now();

    /**
     * 分页查询
     * @param page 分页对象
     * @param movieCategory 电影分类表
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    @PreAuthorize("@pms.hasPermission('demo_moviecategory_get')" )
    public R getMovieCategoryPage(Page page, MovieCategory movieCategory) {
		log.info("分页查询："+ page);
		log.info("分页查询："+ movieCategory);
        return R.ok(movieCategoryService.page(page, Wrappers.query(movieCategory)));
    }


    /**
     * 通过id查询电影分类表
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission('demo_moviecategory_get')" )
    public R getById(@PathVariable("id" ) Long id) {
		log.info("通过id查询："+ id);
        return R.ok(movieCategoryService.getById(id));
    }

    /**
     * 新增电影分类表
     * @param movieCategory 电影分类表
     * @return R
     */
    @ApiOperation(value = "新增电影分类表", notes = "新增电影分类表")
    @SysLog("新增电影分类表" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('demo_moviecategory_add')" )
    public R save(@RequestBody MovieCategory movieCategory) {
		log.info("新增电影分类表："+ movieCategory);
		movieCategory.setIsShow(1);// 默认显示
		movieCategory.setCreateTime(localDateTime);
		movieCategory.setUpdateTime(localDateTime);
        return R.ok(movieCategoryService.save(movieCategory));
    }

    /**
     * 修改电影分类表
     * @param movieCategory 电影分类表
     * @return R
     */
    @ApiOperation(value = "修改电影分类表", notes = "修改电影分类表")
    @SysLog("修改电影分类表" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('demo_moviecategory_edit')" )
    public R updateById(@RequestBody MovieCategory movieCategory) {
		log.info("修改电影分类表："+ movieCategory);
		movieCategory.setUpdateTime(localDateTime);
        return R.ok(movieCategoryService.updateById(movieCategory));
    }

    /**
     * 通过id删除电影分类表
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除电影分类表", notes = "通过id删除电影分类表")
    @SysLog("通过id删除电影分类表" )
    @DeleteMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission('demo_moviecategory_del')" )
    public R removeById(@PathVariable Long id) {
		log.info("通过id删除电影分类表："+ id);
        return R.ok(movieCategoryService.removeById(id));
    }

}
