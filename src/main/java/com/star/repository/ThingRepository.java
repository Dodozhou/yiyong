package com.star.repository;

import com.star.entity.MyThing;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hp on 2017/9/8.
 */
@Repository
public interface ThingRepository extends JpaRepository<MyThing,Integer> {

    @Query("from MyThing t where concat(t.name,t.desc,t.lowP,t.highP,t.category) like ?1 ")
    List<MyThing> searchMyThing(String key);

    List<MyThing> findByCategory(String category);


}
