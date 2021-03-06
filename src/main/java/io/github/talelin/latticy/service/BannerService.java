package io.github.talelin.latticy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.github.talelin.latticy.bo.BannerWithItemsBO;
import io.github.talelin.latticy.dto.Banner.BannerDTO;
import io.github.talelin.latticy.model.BannerDO;
import io.github.talelin.latticy.vo.PageResponseVO;

public interface BannerService extends IService<BannerDO> {

    Boolean create(BannerDTO bannerDTO);

    BannerWithItemsBO getBannerWithItems(Long id);

    /**
     * 分页查询banner列表
     * @param page 页码
     * @param count 每页显示的条数
     * @return 返回PageResponseVO
     */
    PageResponseVO<BannerDO> getBannerByPage(Integer page, Integer count);

    /**
     * 更新banner
     * @param bannerDTO bannerDTO
     * @param id id
     */
    void update(BannerDTO bannerDTO, Long id);

    /**
     * 删除banner
     * @param id id
     */
    void delete(Long id);

}
