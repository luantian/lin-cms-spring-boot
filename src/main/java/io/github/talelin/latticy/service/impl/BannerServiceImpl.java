package io.github.talelin.latticy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.talelin.autoconfigure.exception.NotFoundException;
import io.github.talelin.latticy.bo.BannerWithItemsBO;
import io.github.talelin.latticy.common.mybatis.Page;
import io.github.talelin.latticy.dto.Banner.BannerDTO;
import io.github.talelin.latticy.mapper.BannerItemsMapper;
import io.github.talelin.latticy.mapper.BannerMapper;
import io.github.talelin.latticy.model.BannerDO;
import io.github.talelin.latticy.model.BannerItemsDO;
import io.github.talelin.latticy.service.BannerService;
import io.github.talelin.latticy.vo.PageResponseVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannerServiceImpl extends ServiceImpl<BannerMapper, BannerDO> implements BannerService {

    @Autowired
    private BannerMapper bannerMapper;

    @Autowired
    private BannerItemsMapper bannerItemsMapper;

    @Override
    public BannerWithItemsBO getBannerWithItems(Long id) {
        BannerDO banner = bannerMapper.selectById(id);

        if (banner == null) throw new NotFoundException(10020);

        QueryWrapper<BannerItemsDO> wrapper = new QueryWrapper<>();

        wrapper.lambda().eq(BannerItemsDO::getBannerId, id);

        List<BannerItemsDO> bannerItems = bannerItemsMapper.selectList(wrapper);

        return new BannerWithItemsBO(banner, bannerItems);

    }

    @Override
    public PageResponseVO<BannerDO> getBannerByPage(Integer page, Integer count) {

        Page<BannerDO> pager = new Page<>(page, count);

        IPage<BannerDO> paging = bannerMapper.selectPage(pager, null);

        Integer total = (int)paging.getTotal();
        List<BannerDO> items = paging.getRecords();
        Integer current = (int)paging.getCurrent();
        Integer size = (int)paging.getSize();

        return new PageResponseVO<>(total, items, current, size);
    }

    @Override
    public void update(BannerDTO bannerDTO, Long id) {
        BannerDO bannerDO = this.getById(id);
        if (bannerDO == null) throw new NotFoundException();
        BeanUtils.copyProperties(bannerDTO, bannerDO);
        this.updateById(bannerDO);
    }

    @Override
    public void delete(Long id) {
        BannerDO bannerDO = bannerMapper.selectById(id);
        if (bannerDO == null) throw new NotFoundException();
        this.removeById(id);
    }

}
