package io.github.talelin.latticy.controller.v1;


import io.github.talelin.latticy.dto.category.CategoryDTO;
import io.github.talelin.latticy.model.CategoryDO;
import io.github.talelin.latticy.service.CategoryService;
import io.github.talelin.latticy.vo.CreatedVO;
import io.github.talelin.latticy.vo.DeletedVO;
import io.github.talelin.latticy.vo.UpdatedVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping("/v1/category")
@Validated
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/create")
    public CreatedVO create(
            @RequestBody @Valid CategoryDTO categoryDTO
    ) {
        categoryService.create(categoryDTO);
        return new CreatedVO();
    }

    @DeleteMapping("/{id}")
    public DeletedVO delete(
            @PathVariable @Positive Integer id
    ) {

        categoryService.delete(id);

        return new DeletedVO();
    }

    @PutMapping("/{id}")
    public UpdatedVO update(
            @PathVariable @Positive Integer id,
            @RequestBody @Valid CategoryDTO categoryDTO
    ) {

        categoryService.update(categoryDTO, id);

        return new UpdatedVO();
    }

    @GetMapping("/root")
    public List<CategoryDO> getRoot() {
        return categoryService.getRoot();
    }

    /**
     * 存在问题，并没有返回当前parentId的相关数据，后续需要添加
     * @param parentId
     * @return
     */
    @GetMapping("/subs/{parentId}")
    public List<CategoryDO> getSubs(
            @PathVariable @Positive Integer parentId
    ) {

        return categoryService.getSubs(parentId);
    }

}
