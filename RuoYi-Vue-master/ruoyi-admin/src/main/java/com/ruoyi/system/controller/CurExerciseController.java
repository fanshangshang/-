package com.ruoyi.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.CurExercise;
import com.ruoyi.system.service.ICurExerciseService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 题目，用于生成试卷或者平时测试用Controller
 * 
 * @author ruoyi
 * @date 2023-07-16
 */
@RestController
@RequestMapping("/system/exercise")
public class CurExerciseController extends BaseController
{
    @Autowired
    private ICurExerciseService curExerciseService;

    /**
     * 查询题目，用于生成试卷或者平时测试用列表
     */
    @PreAuthorize("@ss.hasPermi('system:exercise:list')")
    @GetMapping("/list")
    public TableDataInfo list(CurExercise curExercise)
    {
        startPage();
        List<CurExercise> list = curExerciseService.selectCurExerciseList(curExercise);
        return getDataTable(list);
    }

    /**
     * 导出题目，用于生成试卷或者平时测试用列表
     */
    @PreAuthorize("@ss.hasPermi('system:exercise:export')")
    @Log(title = "题目，用于生成试卷或者平时测试用", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CurExercise curExercise)
    {
        List<CurExercise> list = curExerciseService.selectCurExerciseList(curExercise);
        ExcelUtil<CurExercise> util = new ExcelUtil<CurExercise>(CurExercise.class);
        util.exportExcel(response, list, "题目，用于生成试卷或者平时测试用数据");
    }

    /**
     * 获取题目，用于生成试卷或者平时测试用详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:exercise:query')")
    @GetMapping(value = "/{exerciseId}")
    public AjaxResult getInfo(@PathVariable("exerciseId") Long exerciseId)
    {
        return success(curExerciseService.selectCurExerciseByExerciseId(exerciseId));
    }

    /**
     * 新增题目，用于生成试卷或者平时测试用
     */
    @PreAuthorize("@ss.hasPermi('system:exercise:add')")
    @Log(title = "题目，用于生成试卷或者平时测试用", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CurExercise curExercise)
    {
        return toAjax(curExerciseService.insertCurExercise(curExercise));
    }

    /**
     * 修改题目，用于生成试卷或者平时测试用
     */
    @PreAuthorize("@ss.hasPermi('system:exercise:edit')")
    @Log(title = "题目，用于生成试卷或者平时测试用", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CurExercise curExercise)
    {
        return toAjax(curExerciseService.updateCurExercise(curExercise));
    }

    /**
     * 删除题目，用于生成试卷或者平时测试用
     */
    @PreAuthorize("@ss.hasPermi('system:exercise:remove')")
    @Log(title = "题目，用于生成试卷或者平时测试用", businessType = BusinessType.DELETE)
	@DeleteMapping("/{exerciseIds}")
    public AjaxResult remove(@PathVariable Long[] exerciseIds)
    {
        return toAjax(curExerciseService.deleteCurExerciseByExerciseIds(exerciseIds));
    }
}
