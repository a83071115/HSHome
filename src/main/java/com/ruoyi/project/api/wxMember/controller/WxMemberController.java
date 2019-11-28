package com.ruoyi.project.api.wxMember.controller;

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
import com.ruoyi.project.api.wxMember.domain.WxMember;
import com.ruoyi.project.api.wxMember.service.IWxMemberService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 会员Controller
 * 
 * @author alex
 * @date 2019-11-28
 */
@Controller
@RequestMapping("/wechat/wxMember")
public class WxMemberController extends BaseController
{
    private String prefix = "wechat/wxMember";

    @Autowired
    private IWxMemberService wxMemberService;

    @RequiresPermissions("wechat:wxMember:view")
    @GetMapping()
    public String wxMember()
    {
        return prefix + "/wxMember";
    }

    /**
     * 查询会员列表
     */
    @RequiresPermissions("wechat:wxMember:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(WxMember wxMember)
    {
        startPage();
        List<WxMember> list = wxMemberService.selectWxMemberList(wxMember);
        return getDataTable(list);
    }

    /**
     * 导出会员列表
     */
    @RequiresPermissions("wechat:wxMember:export")
    @Log(title = "会员", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(WxMember wxMember)
    {
        List<WxMember> list = wxMemberService.selectWxMemberList(wxMember);
        ExcelUtil<WxMember> util = new ExcelUtil<WxMember>(WxMember.class);
        return util.exportExcel(list, "wxMember");
    }

    /**
     * 新增会员
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存会员
     */
    @RequiresPermissions("wechat:wxMember:add")
    @Log(title = "会员", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(WxMember wxMember)
    {
        return toAjax(wxMemberService.insertWxMember(wxMember));
    }

    /**
     * 修改会员
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        WxMember wxMember = wxMemberService.selectWxMemberById(id);
        mmap.put("wxMember", wxMember);
        return prefix + "/edit";
    }

    /**
     * 修改保存会员
     */
    @RequiresPermissions("wechat:wxMember:edit")
    @Log(title = "会员", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(WxMember wxMember)
    {
        return toAjax(wxMemberService.updateWxMember(wxMember));
    }

    /**
     * 删除会员
     */
    @RequiresPermissions("wechat:wxMember:remove")
    @Log(title = "会员", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(wxMemberService.deleteWxMemberByIds(ids));
    }
}
