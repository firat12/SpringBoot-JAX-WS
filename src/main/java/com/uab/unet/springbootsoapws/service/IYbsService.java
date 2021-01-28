package com.uab.unet.springbootsoapws.service;

import com.uab.unet.springbootsoapws.entity.YbsIl;

import java.util.List;

public interface IYbsService {
    List<YbsIl> getAllYbsIller();
    YbsIl getYbsIlById(long ybsIlId);
    boolean addYbsIl(YbsIl article);
    void updateYbsIl(YbsIl article);
    void deleteYbsIl(YbsIl article);
}
