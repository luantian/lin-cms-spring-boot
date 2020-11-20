package io.github.talelin.latticy.controller.v1;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.github.talelin.latticy.model.BannerDO;
import io.github.talelin.latticy.service.BannerService;
import io.github.talelin.latticy.vo.PageResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import sun.util.resources.ga.LocaleNames_ga;

import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping("/v1/banner")
@Validated
public class BannerController {

    @Autowired
    private BannerService bannerService;

    @GetMapping("/{id}")
    public BannerDO getById(
            @PathVariable @Positive Long id
    ) {
        return bannerService.getById(id);
    }

    @GetMapping("/page")
    public PageResponseVO<BannerDO> getBannerPage(
            @RequestParam @Min(0) Integer page,
            @RequestParam @Min(0) Integer count
    ) {

        IPage<BannerDO> paging = bannerService.getBannerByPage(page, count);

        Integer total = (int)paging.getTotal();
        List<BannerDO> items = paging.getRecords();
        Integer current = (int)paging.getCurrent();
        Integer size = (int)paging.getSize();
        return new PageResponseVO<>(total, items, current, size);

    }

}
