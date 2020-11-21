package io.github.talelin.latticy.controller.v1;

import io.github.talelin.latticy.bo.BannerWithItemsBO;
import io.github.talelin.latticy.dto.Banner.BannerDTO;
import io.github.talelin.latticy.model.BannerDO;
import io.github.talelin.latticy.service.BannerService;
import io.github.talelin.latticy.vo.CreatedVO;
import io.github.talelin.latticy.vo.DeletedVO;
import io.github.talelin.latticy.vo.PageResponseVO;
import io.github.talelin.latticy.vo.UpdatedVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;

@RestController
@RequestMapping("/v1/banner")
@Validated
public class BannerController {

    @Autowired
    private BannerService bannerService;

    @PostMapping("/create")
    public CreatedVO create(
            @RequestBody @Valid BannerDTO bannerDTO
    ) {
        bannerService.create(bannerDTO);
        return new CreatedVO();
    }

    @DeleteMapping("/{id}")
    public DeletedVO delete(
            @PathVariable @Positive Long id
    ) {
        bannerService.delete(id);
        return new DeletedVO();
    }

    @PutMapping("/{id}")
    public UpdatedVO update(
            @PathVariable @Positive Long id,
            @RequestBody @Valid BannerDTO bannerDTO
    ) {
        bannerService.update(bannerDTO, id);
        return new UpdatedVO();
    }

    @GetMapping("/{id}")
    public BannerWithItemsBO getBannerWithItems(
            @PathVariable @Positive Long id
    ) {
        return bannerService.getBannerWithItems(id);
    }

    @GetMapping("/page")
    public PageResponseVO<BannerDO> getBannerPage(
            @RequestParam @Min(0) Integer page,
            @RequestParam @Min(0) Integer count
    ) {

        return bannerService.getBannerByPage(page, count);

    }

}
