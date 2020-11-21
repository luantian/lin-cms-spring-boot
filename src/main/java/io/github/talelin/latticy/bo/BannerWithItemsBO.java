package io.github.talelin.latticy.bo;


import io.github.talelin.latticy.model.BannerDO;
import io.github.talelin.latticy.model.BannerItemsDO;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.List;

@Data
@NoArgsConstructor
public class BannerWithItemsBO {
    private Integer id;
    private String name;
    private String title;
    private String img;
    private String description;

    List<BannerItemsDO> items;

    public BannerWithItemsBO(BannerDO bannerDO, List<BannerItemsDO> items) {
        BeanUtils.copyProperties(bannerDO, this);
        this.setItems(items);
    }

}
