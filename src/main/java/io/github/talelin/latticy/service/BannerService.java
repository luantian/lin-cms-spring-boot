package io.github.talelin.latticy.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import io.github.talelin.latticy.model.BannerDO;

public interface BannerService extends IService<BannerDO> {
    public IPage<BannerDO> getBannerByPage(Integer page, Integer count);
}
