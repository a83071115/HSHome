package com.ruoyi.project.api.current.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.api.current.domain.WxMemberLocationCurrent;
import com.ruoyi.project.api.current.service.IWxMemberLocationCurrentService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 会员当前位置Controller
 * 
 * @author alex
 * @date 2019-11-29
 */
@Controller
@RequestMapping("/wxMemberLocationCurrent/current")
public class MemberLocationCurrentController extends BaseController
{
    private String prefix = "wxMemberLocationCurrent/current";

    @Autowired
    private IWxMemberLocationCurrentService wxMemberLocationCurrentService;

    @RequiresPermissions("wxMemberLocationCurrent:current:view")
    @GetMapping()
    public String current()
    {
        return prefix + "/current";
    }

    /**
     * 查询会员当前位置列表
     */
    @RequiresPermissions("wxMemberLocationCurrent:current:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(WxMemberLocationCurrent wxMemberLocationCurrent)
    {
        startPage();
        List<WxMemberLocationCurrent> list = wxMemberLocationCurrentService.selectWxMemberLocationCurrentList(wxMemberLocationCurrent);
        return getDataTable(list);
    }

    /**
     * 导出会员当前位置列表
     */
    @RequiresPermissions("wxMemberLocationCurrent:current:export")
    @Log(title = "会员当前位置", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(WxMemberLocationCurrent wxMemberLocationCurrent)
    {
        List<WxMemberLocationCurrent> list = wxMemberLocationCurrentService.selectWxMemberLocationCurrentList(wxMemberLocationCurrent);
        ExcelUtil<WxMemberLocationCurrent> util = new ExcelUtil<WxMemberLocationCurrent>(WxMemberLocationCurrent.class);
        return util.exportExcel(list, "current");
    }

    /**
     * 新增会员当前位置
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存会员当前位置
     */
    @RequiresPermissions("wxMemberLocationCurrent:current:add")
    @Log(title = "会员当前位置", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(WxMemberLocationCurrent wxMemberLocationCurrent)
    {
        return toAjax(wxMemberLocationCurrentService.insertWxMemberLocationCurrent(wxMemberLocationCurrent));
    }

    /**
     * 修改会员当前位置
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        WxMemberLocationCurrent wxMemberLocationCurrent = wxMemberLocationCurrentService.selectWxMemberLocationCurrentById(id);
        mmap.put("wxMemberLocationCurrent", wxMemberLocationCurrent);
        return prefix + "/edit";
    }

    /**
     * 修改保存会员当前位置
     */
    @RequiresPermissions("wxMemberLocationCurrent:current:edit")
    @Log(title = "会员当前位置", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(WxMemberLocationCurrent wxMemberLocationCurrent)
    {
        return toAjax(wxMemberLocationCurrentService.updateWxMemberLocationCurrent(wxMemberLocationCurrent));
    }

    /**
     * 删除会员当前位置
     */
    @RequiresPermissions("wxMemberLocationCurrent:current:remove")
    @Log(title = "会员当前位置", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(wxMemberLocationCurrentService.deleteWxMemberLocationCurrentByIds(ids));
    }
}
