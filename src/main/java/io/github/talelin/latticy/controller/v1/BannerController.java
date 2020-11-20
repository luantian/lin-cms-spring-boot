package io.github.talelin.latticy.controller.v1;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import io.github.talelin.autoconfigure.exception.NotFoundException;
import io.github.talelin.latticy.model.BannerDO;
import io.github.talelin.latticy.service.BannerService;
import io.github.talelin.latticy.vo.PageResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import java.util.List;

@RequestMapping("/v1/banner")
@RestController
@Validated
public class BannerController {

    @Autowired
    private BannerService bannerService;

    @GetMapping("/{id}")
    public BannerDO getBannerById(
            @PathVariable @Positive Integer id
    ) {
        BannerDO bannerDO = bannerService.getById(id);

        if (bannerDO == null) throw new NotFoundException(90001);

        return bannerDO;
    }

    @GetMapping("/page")
    public PageResponseVO<BannerDO> getBannersByPage(
            @RequestParam(defaultValue = "0") @Min(value = 0) Integer page,
            @RequestParam(defaultValue = "10") @Min(value = 0) Integer count
    ) {

        IPage<BannerDO> banners = bannerService.getBannersByPage(page, count);

        Integer total = (int)banners.getTotal();
        List<BannerDO> items = banners.getRecords();
        Integer current = (int)banners.getCurrent();
        Integer counts = (int)banners.getSize();

        return new PageResponseVO<>(total, items, current, counts);
    }


}
