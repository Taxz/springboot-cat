package com.study.edu.mapper;

import com.study.edu.annotation.CatAnnotation;
import com.study.edu.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.dianping.cat.Constants.CAT;

/**
 * Created by Administrator on 2018/3/13.
 */
@Repository
public interface UserMapper {
    @CatAnnotation
    List<User> getAll();
    @CatAnnotation
    User getOne(Long id);
    @Transactional
    void insert(User user);
    @Transactional
    void update(User user);
    @Transactional
    void delete(Long id);

}
