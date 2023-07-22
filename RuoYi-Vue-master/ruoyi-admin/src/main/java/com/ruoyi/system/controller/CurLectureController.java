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
import com.ruoyi.system.domain.CurLecture;
import com.ruoyi.system.service.ICurLectureService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 示某一讲Controller
 * 
 * @author ruoyi
 * @date 2023-07-16
 */
@RestController
@RequestMapping("/system/lecture")
public class CurLectureController extends BaseController
{
    @Autowired
    private ICurLectureService curLectureService;

    /**
     * 查询示某一讲列表
     */
    @PreAuthorize("@ss.hasPermi('system:lecture:list')")
    @GetMapping("/list")
    public TableDataInfo list(CurLecture curLecture)
    {
        startPage();
        List<CurLecture> list = curLectureService.selectCurLectureList(curLecture);
        return getDataTable(list);
    }

    /**
     * 导出示某一讲列表
     */
    @PreAuthorize("@ss.hasPermi('system:lecture:export')")
    @Log(title = "示某一讲", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CurLecture curLecture)
    {
        List<CurLecture> list = curLectureService.selectCurLectureList(curLecture);
        ExcelUtil<CurLecture> util = new ExcelUtil<CurLecture>(CurLecture.class);
        util.exportExcel(response, list, "示某一讲数据");
    }

    /**
     * 获取示某一讲详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:lecture:query')")
    @GetMapping(value = "/{lectureId}")
    public AjaxResult getInfo(@PathVariable("lectureId") Long lectureId)
    {
        return success(curLectureService.selectCurLectureByLectureId(lectureId));
    }

    /**
     * 新增示某一讲
     */
    @PreAuthorize("@ss.hasPermi('system:lecture:add')")
    @Log(title = "示某一讲", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CurLecture curLecture)
    {
        return toAjax(curLectureService.insertCurLecture(curLecture));
    }

    /**
     * 修改示某一讲
     */
    @PreAuthorize("@ss.hasPermi('system:lecture:edit')")
    @Log(title = "示某一讲", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CurLecture curLecture)
    {
        return toAjax(curLectureService.updateCurLecture(curLecture));
    }

    /**
     * 删除示某一讲
     */
    @PreAuthorize("@ss.hasPermi('system:lecture:remove')")
    @Log(title = "示某一讲", businessType = BusinessType.DELETE)
	@DeleteMapping("/{lectureIds}")
    public AjaxResult remove(@PathVariable Long[] lectureIds)
    {
        return toAjax(curLectureService.deleteCurLectureByLectureIds(lectureIds));
    }
}
