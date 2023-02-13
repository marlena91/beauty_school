package com.marlena.beautyschool.repository;

import com.marlena.beautyschool.model.BeautyClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeautyClassRepository extends JpaRepository<BeautyClass, Integer> {
}
