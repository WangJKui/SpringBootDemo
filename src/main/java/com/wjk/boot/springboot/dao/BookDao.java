package com.wjk.boot.springboot.dao;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.wjk.boot.springboot.vo.Book;

public interface BookDao extends ElasticsearchRepository<Book,String>{

}