package com.uab.unet.springbootsoapws.service.impl;

import com.uab.unet.springbootsoapws.entity.YbsIl;
import com.uab.unet.springbootsoapws.repository.SinirUlkeRepository;
import com.uab.unet.springbootsoapws.repository.YbsIlRepository;
import com.uab.unet.springbootsoapws.service.IYbsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class YbsService implements IYbsService {
    @Autowired
    private YbsIlRepository ybsIlRepository;

    @Autowired
    private SinirUlkeRepository sinirUlkeRepository;

    @Override
    public List<YbsIl> getAllYbsIller() {
        List<YbsIl> list = new ArrayList<>();
        ybsIlRepository.findAll().forEach(i -> list.add(i));
        return list;
    }

    @Override
    public YbsIl getYbsIlById(long ybsIlId) {
        YbsIl il = ybsIlRepository.findByYbsIlId(ybsIlId);
        return il;
    }

    @Override
    @Transactional
    public synchronized boolean addYbsIl(YbsIl il) {
        List<YbsIl> list = ybsIlRepository.findByAdOrIlKodu(il.getAd(), il.getIlKodu());
        if(list.size() > 0){
            return false;

        }else {
            ybsIlRepository.save(il);
            return true;
        }
    }

    @Override
    public void updateYbsIl(YbsIl article) {
        ybsIlRepository.save(article);
    }

    @Override
    public void deleteYbsIl(YbsIl article) {
        ybsIlRepository.delete(article);
    }
}
