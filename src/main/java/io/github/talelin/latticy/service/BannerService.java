package io.github.talelin.latticy.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import io.github.talelin.latticy.model.BannerDO;

import java.util.List;

public interface BannerService extends IService<BannerDO> {

    public IPage<BannerDO> getBannersByPage(Integer page, Integer count);

}
