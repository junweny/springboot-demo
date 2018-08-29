package com.yang.test.mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yang.test.mybatis.dao.AuthorMapper;
import com.yang.test.mybatis.entity.Author;

@Service("authorService")
public class AuthorService {
    @Autowired
    private AuthorMapper authorMapper;
 
    public int add(String realName, String nickName) {
        return this.authorMapper.add(realName, nickName);
    }
    public int update(String realName, String nickName, Long id) {
        return this.authorMapper.update(realName, nickName, id);      
    }
    public int delete(Long id) {
        return this.authorMapper.delete(id);
    }
    public Author findAuthor(Long id) {
        return this.authorMapper.findAuthor(id);
    }
    public List<Author> findAuthorList() {
        return this.authorMapper.findAuthorList();
    }
}
