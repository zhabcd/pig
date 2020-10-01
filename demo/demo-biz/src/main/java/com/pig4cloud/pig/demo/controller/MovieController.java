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
import com.pig4cloud.pig.demo.entity.Movie;
import com.pig4cloud.pig.demo.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;


/**
 * 电影表
 *
 * @author pig code generator
 * @date 2020-10-01 12:44:02
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/movie" )
@Api(value = "movie", tags = "电影表管理")
@Slf4j
public class MovieController {

    private final MovieService movieService;
    private LocalDateTime localDateTime = LocalDateTime.now();

    /**
     * 分页查询
     * @param page 分页对象
     * @param movie 电影表
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    @PreAuthorize("@pms.hasPermission('demo_movie_get')" )
    public R getMoviePage(Page page, Movie movie) {
    	log.info("分页查询："+ page);
    	log.info("分页查询："+ movie);
        return R.ok(movieService.page(page, Wrappers.query(movie)));
    }


    /**
     * 通过id查询电影表
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission('demo_movie_get')" )
    public R getById(@PathVariable("id" ) Long id) {
		log.info("通过id查询："+ id);
        return R.ok(movieService.getById(id));
    }

    /**
     * 新增电影表
     * @param movie 电影表
     * @return R
     */
    @ApiOperation(value = "新增电影表", notes = "新增电影表")
    @SysLog("新增电影表" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('demo_movie_add')" )
    public R save(@RequestBody Movie movie) {
		log.info("新增电影表："+ movie);
    	movie.setIsShow(1);// 默认显示
    	movie.setCreateTime(localDateTime);
    	movie.setUpdateTime(localDateTime);
        return R.ok(movieService.save(movie));
    }

    /**
     * 修改电影表
     * @param movie 电影表
     * @return R
     */
    @ApiOperation(value = "修改电影表", notes = "修改电影表")
    @SysLog("修改电影表" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('demo_movie_edit')" )
    public R updateById(@RequestBody Movie movie) {
		log.info("修改电影表："+ movie);
    	movie.setUpdateTime(localDateTime);
        return R.ok(movieService.updateById(movie));
    }

    /**
     * 通过id删除电影表
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除电影表", notes = "通过id删除电影表")
    @SysLog("通过id删除电影表" )
    @DeleteMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission('demo_movie_del')" )
    public R removeById(@PathVariable Long id) {
		log.info("通过id删除电影表："+ id);
        return R.ok(movieService.removeById(id));
    }

}
