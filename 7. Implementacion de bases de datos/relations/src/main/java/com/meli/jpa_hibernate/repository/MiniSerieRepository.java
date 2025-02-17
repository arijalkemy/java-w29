package com.meli.jpa_hibernate.repository;

import com.meli.jpa_hibernate.model.MiniSerie;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class MiniSerieRepository implements IMiniSerieRepository {
    @Override
    public void flush() {

    }

    @Override
    public <S extends MiniSerie> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends MiniSerie> List<S> saveAllAndFlush(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public void deleteAllInBatch(Iterable<MiniSerie> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public MiniSerie getOne(Long aLong) {
        return null;
    }

    @Override
    public MiniSerie getById(Long aLong) {
        return null;
    }

    @Override
    public MiniSerie getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends MiniSerie> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends MiniSerie> List<S> findAll(Example<S> example) {
        return List.of();
    }

    @Override
    public <S extends MiniSerie> List<S> findAll(Example<S> example, Sort sort) {
        return List.of();
    }

    @Override
    public <S extends MiniSerie> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends MiniSerie> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends MiniSerie> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends MiniSerie, R> R findBy(Example<S> example,
            Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends MiniSerie> S save(S entity) {
        return null;
    }

    @Override
    public <S extends MiniSerie> List<S> saveAll(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public Optional<MiniSerie> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<MiniSerie> findAll() {
        return List.of();
    }

    @Override
    public List<MiniSerie> findAllById(Iterable<Long> longs) {
        return List.of();
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(MiniSerie entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends MiniSerie> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<MiniSerie> findAll(Sort sort) {
        return List.of();
    }

    @Override
    public Page<MiniSerie> findAll(Pageable pageable) {
        return null;
    }
}

