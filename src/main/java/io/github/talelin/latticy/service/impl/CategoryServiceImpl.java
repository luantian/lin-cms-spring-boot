package io.github.talelin.latticy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.talelin.autoconfigure.exception.NotFoundException;
import io.github.talelin.latticy.dto.category.CategoryDTO;
import io.github.talelin.latticy.mapper.CategoryMapper;
import io.github.talelin.latticy.model.CategoryDO;
import io.github.talelin.latticy.service.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, CategoryDO> implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public void create(CategoryDTO categoryDTO) {
        CategoryDO categoryDO = new CategoryDO();
        BeanUtils.copyProperties(categoryDTO, categoryDO);
        categoryMapper.insert(categoryDO);
    }

    @Override
    public void delete(Integer id) {
        CategoryDO categoryDO = categoryMapper.selectById(id);
        if (categoryDO == null) throw new NotFoundException(10020);
        categoryMapper.deleteById(id);
    }

    @Override
    public void update(CategoryDTO categoryDTO, Integer id) {
        CategoryDO categoryDO = categoryMapper.selectById(id);
        if (categoryDO == null) throw new NotFoundException(10020);

        BeanUtils.copyProperties(categoryDTO, categoryDO);
        categoryMapper.updateById(categoryDO);
    }

    @Override
    public List<CategoryDO> getRoot() {

        QueryWrapper<CategoryDO> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(CategoryDO::getIsRoot, 1);

        return categoryMapper.selectList(wrapper);
    }

    @Override
    public List<CategoryDO> getSubs(Integer parentId) {
        QueryWrapper<CategoryDO> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(CategoryDO::getParentId, parentId);

        return categoryMapper.selectList(wrapper);
    }
}
