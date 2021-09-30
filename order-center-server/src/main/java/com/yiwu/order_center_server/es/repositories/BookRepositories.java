package com.yiwu.order_center_server.es.repositories;

import com.yiwu.order_center_server.es.bean.Book;
import org.elasticsearch.index.query.QueryBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.Optional;

/**
 * @Author fuzf
 * @Date 2021/9/26:11:05
 * @Description:
 */
public class BookRepositories implements ElasticsearchRepository<Book, String> {

    @Override
    public <S extends Book> S indexWithoutRefresh(S s) {
        return null;
    }

    @Override
    public Iterable<Book> search(QueryBuilder queryBuilder) {
        return null;
    }

    @Override
    public Page<Book> search(QueryBuilder queryBuilder, Pageable pageable) {
        return null;
    }

    @Override
    public Page<Book> search(Query query) {
        return null;
    }

    @Override
    public Page<Book> searchSimilar(Book book, String[] strings, Pageable pageable) {
        return null;
    }

    @Override
    public void refresh() {

    }

    @Override
    public Iterable<Book> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Book> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Book> S save(S s) {
        return null;
    }

    @Override
    public <S extends Book> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Book> findById(String s) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public Iterable<Book> findAll() {
        return null;
    }

    @Override
    public Iterable<Book> findAllById(Iterable<String> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public void delete(Book book) {

    }

    @Override
    public void deleteAll(Iterable<? extends Book> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
