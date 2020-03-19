package com.ruoyi.project.api.history.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.api.history.domain.WxMemberLocationHistory;
import com.ruoyi.project.api.history.service.IWxMemberLocationHistoryService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 会员历史位置Controller
 * 
 * @author alex
 * @date 2019-11-29
 */
@Controller
@RequestMapping("/wxMemberLocationHistory/history")
public class WxMemberLocationHistoryController extends BaseController
{
    private String prefix = "wxMemberLocationHistory/history";

    @Autowired
    private IWxMemberLocationHistoryService wxMemberLocationHistoryService;

    @RequiresPermissions("wxMemberLocationHistory:history:view")
    @GetMapping()
    public String history()
    {
        return prefix + "/history";
    }

    /**
     * 查询会员历史位置列表
     */
    @RequiresPermissions("wxMemberLocationHistory:history:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(WxMemberLocationHistory wxMemberLocationHistory)
    {
        startPage();
        List<WxMemberLocationHistory> list = wxMemberLocationHistoryService.selectWxMemberLocationHistoryList(wxMemberLocationHistory);
        return getDataTable(list);
    }

    /**
     * 导出会员历史位置列表
     */
    @RequiresPermissions("wxMemberLocationHistory:history:export")
    @Log(title = "会员历史位置", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(WxMemberLocationHistory wxMemberLocationHistory)
    {
        List<WxMemberLocationHistory> list = wxMemberLocationHistoryService.selectWxMemberLocationHistoryList(wxMemberLocationHistory);
        ExcelUtil<WxMemberLocationHistory> util = new ExcelUtil<WxMemberLocationHistory>(WxMemberLocationHistory.class);
        return util.exportExcel(list, "history");
    }

    /**
     * 新增会员历史位置
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存会员历史位置
     */
    @RequiresPermissions("wxMemberLocationHistory:history:add")
    @Log(title = "会员历史位置", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(WxMemberLocationHistory wxMemberLocationHistory)
    {
        return toAjax(wxMemberLocationHistoryService.insertWxMemberLocationHistory(wxMemberLocationHistory));
    }

    /**
     * 修改会员历史位置
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        WxMemberLocationHistory wxMemberLocationHistory = wxMemberLocationHistoryService.selectWxMemberLocationHistoryById(id);
        mmap.put("wxMemberLocationHistory", wxMemberLocationHistory);
        return prefix + "/edit";
    }

    /**
     * 修改保存会员历史位置
     */
    @RequiresPermissions("wxMemberLocationHistory:history:edit")
    @Log(title = "会员历史位置", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(WxMemberLocationHistory wxMemberLocationHistory)
    {
        return toAjax(wxMemberLocationHistoryService.updateWxMemberLocationHistory(wxMemberLocationHistory));
    }

    /**
     * 删除会员历史位置
     */
    @RequiresPermissions("wxMemberLocationHistory:history:remove")
    @Log(title = "会员历史位置", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(wxMemberLocationHistoryService.deleteWxMemberLocationHistoryByIds(ids));
    }
}
