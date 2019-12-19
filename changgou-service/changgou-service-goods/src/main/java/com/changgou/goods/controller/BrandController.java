package com.changgou.goods.controller;

import com.changgou.goods.pojo.Brand;
import com.changgou.goods.service.BrandService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: nullWagesException
 * @Date: 2019/12/19 15:30
 * @Description:
 */
@RestController
@RequestMapping("/brand")
@CrossOrigin
public class BrandController {

    @Autowired
    private BrandService brandService;

    /***
     * 查询全部数据
     * @return
     */
    @GetMapping
    public Result<Brand> findAll(){
        List<Brand> brandList = brandService.findAll();
        return new Result<Brand>(true, StatusCode.OK,"查询成功",brandList) ;
    }

    /***
     * 根据ID查询品牌数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<Brand> findById(@PathVariable Integer id){
        //根据ID查询
        Brand brand = brandService.findById(id);
        return new Result<Brand>(true,StatusCode.OK,"查询成功",brand);
    }

    /***
     * 新增品牌数据
     * @param brand
     * @return
     */
    @PostMapping
    public Result add(@RequestBody Brand brand){
        brandService.add(brand);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 修改品牌数据
     * @param brand
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody Brand brand,@PathVariable Integer id){
        //设置ID
        brand.setId(id);
        //修改数据
        brandService.update(brand);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        brandService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }
}