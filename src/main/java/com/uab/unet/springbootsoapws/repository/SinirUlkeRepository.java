package com.uab.unet.springbootsoapws.repository;

import com.uab.unet.springbootsoapws.entity.SinirUlke;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SinirUlkeRepository extends JpaRepository<SinirUlke, Long> {
}
