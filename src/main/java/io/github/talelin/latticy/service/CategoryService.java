package io.github.talelin.latticy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.github.talelin.latticy.dto.category.CategoryDTO;
import io.github.talelin.latticy.model.CategoryDO;

import java.util.List;

public interface CategoryService extends IService<CategoryDO> {

    List<CategoryDO> getRoot();

    List<CategoryDO> getSubs(Integer parentId);

    void create(CategoryDTO categoryDTO);

    void delete(Integer id);

    void update(CategoryDTO categoryDTO, Integer id);

}
