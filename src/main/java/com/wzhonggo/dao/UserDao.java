package com.wzhonggo.dao;

import com.wzhonggo.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

import javax.persistence.QueryHint;
import java.util.List;

/**
 * Created by wzgong on 7/16/2015.
 */
@Repository
public interface UserDao extends JpaRepository<User, Long> {
    @QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") ,@QueryHint(name = "org.hibernate.cacheRegion", value ="com.wzhonggo.domain.User") })
    List<User> findByEmail(String email);

}
