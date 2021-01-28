package com.uab.unet.springbootsoapws.repository;

import com.uab.unet.springbootsoapws.entity.YbsIl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface YbsIlRepository extends JpaRepository<YbsIl, Long> {
    YbsIl findByYbsIlId(long articleId);
    List<YbsIl> findByAdOrIlKodu(String ad, String ilKodu);
}
