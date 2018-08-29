package com.yang.test.mybatis.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.yang.test.mybatis.entity.Author;
import com.yang.test.mybatis.service.AuthorService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/data/mybatis/author")
public class AuthorMybatisController {
 
  @Resource(name = "authorService")
  private AuthorService authorService;
  
  /**
   * 查询用户列表
   */
  @ApiOperation(value="获取用户列表", notes="")
  @RequestMapping(method = RequestMethod.GET)
  public Map<String,Object> getAuthorList(HttpServletRequest request) {        
    List<Author> authorList = this.authorService.findAuthorList();
    Map<String,Object> param = new HashMap<String,Object>();
    param.put("total", authorList.size());
    param.put("rows", authorList);
    return param;
  }
  /**
   * 查询用户信息
   */
  @ApiOperation(value="创建用户", notes="根据User对象创建用户")
  @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
  @RequestMapping(value = "/{userId:\\d+}", method = RequestMethod.GET)
  public Author getAuthor(@PathVariable Long userId, HttpServletRequest request) {
    Author author = this.authorService.findAuthor(userId);
    if(author == null){
        throw new RuntimeException("查询错误");
    }
    return author;
  }
 
  /**
   * 新增方法
   */
  @RequestMapping(method = RequestMethod.POST)
  public void add(@RequestBody JSONObject jsonObject) {
    //String userId = jsonObject.getString("user_id");
    String realName = jsonObject.getString("real_name");
    String nickName = jsonObject.getString("nick_name");
 
    try{
        this.authorService.add(realName, nickName);
    }catch(Exception e){
        e.printStackTrace();
        throw new RuntimeException("新增错误");
    }
  }
  /**
   * 更新方法
   */
  @RequestMapping(value = "/{userId:\\d+}", method = RequestMethod.PUT)
    public void update(@PathVariable Long userId, @RequestBody JSONObject jsonObject) {
    Author author = this.authorService.findAuthor(userId);
    String realName = jsonObject.getString("real_name");
    String nickName = jsonObject.getString("nick_name");
 
    try{
        this.authorService.update(realName, nickName, author.getId());
    }catch(Exception e){
        e.printStackTrace();
        throw new RuntimeException("更新错误");
    } 
  }
  /**
   * 删除方法
   */
    @RequestMapping(value = "/{userId:\\d+}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long userId) {
    try{
        this.authorService.delete(userId);
    }catch(Exception e){
        throw new RuntimeException("删除错误");
    }
  }
}