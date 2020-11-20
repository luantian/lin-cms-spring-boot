package io.github.talelin.latticy.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.talelin.latticy.common.mybatis.Page;
import io.github.talelin.latticy.mapper.BannerMapper;
import io.github.talelin.latticy.model.BannerDO;
import io.github.talelin.latticy.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannerServiceImpl extends ServiceImpl<BannerMapper, BannerDO> implements BannerService {
    @Autowired
    private BannerMapper bannerMapper;

    @Override
    public IPage<BannerDO> getBannersByPage(Integer page, Integer count) {

        Page<BannerDO> pager = new Page<>(page, count);

        IPage<BannerDO> banners = bannerMapper.selectPage(pager, null);

        return banners;
    }


}
