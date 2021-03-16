package tmp;

import java.util.Date;

/**
 * app广告激活、注册消息事件dto
 * @author by shibo on 2020/9/23.
 */

public class AppEventMsgInfo {
    // ios设备号
    private String idfa;
    // andriod设备号
    private String oaid;
    // 操作时间
    private Date createTime;
    // 操作
    private Integer eventStatus;
    // 操作系统类型
    private Integer osType;
    // App类型
    private String appId;
    // 新老用户判断 1：老用户
    private Integer oldUser;

    public String getIdfa() {
        return idfa;
    }

    public void setIdfa(String idfa) {
        this.idfa = idfa;
    }

    public String getOaid() {
        return oaid;
    }

    public void setOaid(String oaid) {
        this.oaid = oaid;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getEventStatus() {
        return eventStatus;
    }

    public void setEventStatus(Integer eventStatus) {
        this.eventStatus = eventStatus;
    }

    public Integer getOsType() {
        return osType;
    }

    public void setOsType(Integer osType) {
        this.osType = osType;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public Integer getOldUser() {
        return oldUser;
    }

    public void setOldUser(Integer oldUser) {
        this.oldUser = oldUser;
    }
}
