package com.ruoyi.project.api.current.domain;

import com.google.common.collect.Maps;
import com.ruoyi.framework.web.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * 用于地图显示车辆信息使用
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MarkerInfo extends BaseEntity {


    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 用户id */
    private String openid;

    /** 纬度 */
    private String latitude;

    /** 经度 */
    private String longitude;

    /** 速度 */
    private String speed;

    /** 昵称 */
    private String nickname;

    /** 头像 */
    private String avatar;

    /** 手机号 */
    private String mobile;

    /** 弹窗信息 */
    private HashMap<String, Object> callout;

    /** 弹窗信息 */
    private String iconPath;

    /** 宽度 */
    private String width;

    /** 高度 */
    private String height;

    public HashMap<String, Object> getCallout() {
        if (callout == null)
        {
            callout = Maps.newHashMap();
        }
        return callout;
    }

    public void setCallout(HashMap<String, Object> callout) {
        this.callout = callout;
    }

}
