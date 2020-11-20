package io.github.talelin.latticy.controller.v1;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.github.talelin.autoconfigure.exception.NotFoundException;
import io.github.talelin.latticy.dto.Banner.BannerDTO;
import io.github.talelin.latticy.model.BannerDO;
import io.github.talelin.latticy.service.BannerService;
import io.github.talelin.latticy.vo.DeletedVO;
import io.github.talelin.latticy.vo.PageResponseVO;
import io.github.talelin.latticy.vo.UpdatedVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping("/v1/banner")
@Validated
public class BannerController {

    @Autowired
    private BannerService bannerService;

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
    public BannerDO getById(
            @PathVariable @Positive Long id
    ) {

        BannerDO bannerDO = bannerService.getById(id);

        if (bannerDO == null) throw new NotFoundException();

        return bannerDO;
    }

    @GetMapping("/page")
    public PageResponseVO<BannerDO> getBannerPage(
            @RequestParam @Min(0) Integer page,
            @RequestParam @Min(0) Integer count
    ) {

        return bannerService.getBannerByPage(page, count);

    }

}
