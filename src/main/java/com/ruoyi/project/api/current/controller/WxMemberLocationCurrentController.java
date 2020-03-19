package com.ruoyi.project.api.current.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.project.api.current.domain.MarkerInfo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.aspectj.weaver.loadtime.Aj;
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
import com.ruoyi.project.api.current.domain.WxMemberLocationCurrent;
import com.ruoyi.project.api.current.service.IWxMemberLocationCurrentService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 会员当前位置Controller
 * 
 * @author alex
 * @date 2019-11-29
 */
@Controller
@RequestMapping("/api/current")
public class WxMemberLocationCurrentController extends BaseController
{

    @Autowired
    private IWxMemberLocationCurrentService wxMemberLocationCurrentService;



    /**
     * 查询会员当前位置列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(WxMemberLocationCurrent wxMemberLocationCurrent)
    {
        List<WxMemberLocationCurrent> list = wxMemberLocationCurrentService.selectWxMemberLocationCurrentList(wxMemberLocationCurrent);
        return getDataTable(list);
    }

    /**
     * 新增保存会员当前位置
     */
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(WxMemberLocationCurrent wxMemberLocationCurrent)
    {
        return toAjax(wxMemberLocationCurrentService.insertWxMemberLocationCurrent(wxMemberLocationCurrent));
    }

    /**
     * 修改保存会员当前位置
     */
    @PostMapping("/update")
    @ResponseBody
    public AjaxResult editSave(WxMemberLocationCurrent wxMemberLocationCurrent)
    {
        if(null == wxMemberLocationCurrent || StringUtils.isEmpty(wxMemberLocationCurrent.getOpenid())){
            return AjaxResult.error("获取openid失败");
        }

        return toAjax(wxMemberLocationCurrentService.updateWxMemberLocationCurrent(wxMemberLocationCurrent));
    }

    /**
     * 删除会员当前位置
     */
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(wxMemberLocationCurrentService.deleteWxMemberLocationCurrentByIds(ids));
    }

    /**
     * 删除会员当前位置
     */
    @PostMapping( "/getMemberInfoToMap")
    @ResponseBody
    public AjaxResult getMemberInfoToMap(MarkerInfo info)
    {
        Map<String, Object> markers = new HashMap<>();
        markers.put("markers",wxMemberLocationCurrentService.getMemberInfoToMapMarkers(info));
        return AjaxResult.success(markers);
    }
}
