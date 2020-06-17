package com.leelen.community.account.constance;

/**
 * @description: http请求url常量类
 * @copyright: Copyright (c) 2019 厦门立林科技有限公司
 * @author: cwx
 * @date: 2017/5/13
 * @version: 1.00
 * @history:
 */
public interface HttpConst {
    String HTTP_PROTOCOL_VERSION = "V1.0";

    /**
     * 获取uuid
     */
    String GET_UUID = "/rest/app/community/safe/getUuid";

    /////////////////////////////////////////帐号相关////////////////////////////////////////////

    /**
     * 帐号注册
     */
    String ACCOUNT_REGISTER = "/rest/app/community/user/register";

    /**
     * 加密帐号注册
     */
    String ENCRYPT_ACCOUNT_REGISTER = "/rest/app/community/user/encryptRegister";


    /**
     * 加密帐号注册
     */
    String ENCRYPT_V1_ACCOUNT_REGISTER = "/rest/app/community/user/encryptV1Register";

    /**
     * 获取验证码
     */
    String GET_VERIFY_CODE = "/rest/app/community/security/getVerifyCode";

    /**
     * 校验验证码
     */
    String VALIDATE_VERIFY_CODE = "/rest/app/community/security/validateVerifyCode";

    /**
     * 帐号登录
     */
    String LOGIN = "/rest/app/community/user/login";


    /**
     * 加密登录
     */
    String ENCRYPT_LOGIN = "/rest/app/community/user/encryptLogin";

    /**
     * 加密登录
     */
    String ENCRYPT_V1_LOGIN = "/rest/app/community/user/encryptV1Login";


    /**
     * 帐号退出
     */
    String LOGOUT = "/rest/app/community/user/logout";

    /**
     * 修改密码
     */
    String MODIFY_PASSWORD = "/rest/app/community/user/modifyPassword";

    /**
     * 加密修改密码
     */
    String ENCRYPT_MODIFY_PASSWORD = "/rest/app/community/user/encryptModifyPassword";

    /**
     * 加密修改密码
     */
    String ENCRYPT_V1_MODIFY_PASSWORD = "/rest/app/community/user/encryptV1ModifyPassword";

    /**
     * 重置密码
     */
    String RESET_PASSWORD = "/rest/app/community/user/resetPassword";

    /**
     * 加密重置密码
     */
    String ENCRYPT_RESET_PASSWORD = "/rest/app/community/user/encryptResetPassword";

    /**
     * 加密重置密码
     */
    String ENCRYPT_V1_RESET_PASSWORD = "/rest/app/community/user/encryptV1ResetPassword";

    /**
     * 设备登录授权
     */
    String AUTH_TERMINAL = "/rest/app/community/security/authTerminal";

    /**
     * 取消设备登录授权
     */
    String CANCEL_TERMINAL = "/rest/app/community/security/cancelTerminal";

    /**
     * 获取设备登录授权列表
     */
    String GET_TERMINAL_LIST = "/rest/app/community/security/getTerminalList";

    /**
     * 刷新访问令牌
     */
    String REFRESH_TOKEN = "/rest/app/community/security/refreshToken";

    /**
     * 保存推送token
     */
    String SAVE_PUSH_TOKEN = "/rest/app/community/user/savePushToken";

    /**
     * 获取我的住家列表
     */
    String GET_MY_HOUSE_LIST = "/rest/app/community/house/getMyHouseList";

    /**
     * 获取住家帐号列表
     */
    String GET_ACCOUNT_LIST = "/rest/app/community/house/getAccountList";

    /**
     * 获取监控或者门禁设备列表
     */
    String GET_DEVICE_LIST = "/rest/app/community/outdoor/getDeviceList";

    /**
     * 获取对讲记录列表
     */
    String GET_TELECOM_RECORDS = "/rest/app/community/telecom/getTelecomRecords";

    /**
     * 删除对讲记录（支持多条）
     */
    String DEL_TELECOM_RECORDS = "/rest/app/community/telecom/delTelecomRecords";

    /**
     * 是否存在子帐号
     */
    String EXIST_SUB_MEMBER = "/rest/app/community/house/existSubMember";

    /**
     * 帐号解绑住家
     */
    String UNBIND_SELF_HOUSE = "/rest/app/community/house/unbindingSelf";

    /**
     * 获取家庭成员列表
     */
    String GET_MEMBER_LIST = "/rest/app/community/house/getMemberList";

    /**
     * 添加家庭成员
     */
    String ADD_MEMBER = "/rest/app/community/house/addMember";

    /**
     * 编辑家庭成员
     */
    String EDIT_MEMBER = "/rest/app/community/house/editMember";

    /**
     * 删除家庭成员
     */
    String DEL_MEMBER = "/rest/app/community/house/delMember";

    /**
     * 获取人员类型
     */
    String GET_MEMBER_TYPE = "/rest/app/community/house/getMemberType";

    /**
     * 获取证件类型
     */
    String GET_CERT_TYPE = "/rest/app/community/house/getCertType";

    /**
     * APP通用资源上传
     */
    String UPLOAD = "/rest/app/community/resource/upload";

    /**
     * APP通用资源删除
     */
    String DELETE = "/rest/app/community/resource/delete";

    /**
     * 远程开门
     */
    String REMOTE_OPENING = "/rest/app/community/outdoor/remoteOpening";

    /**
     * 获取转接电话
     */
    String GET_CALL_PHONE = "/rest/app/community/house/getCallPhoneList";

    /**
     * 设置转接电话
     */
    String SET_CALL_PHONE = "/rest/app/community/house/addCallPhone";

    /**
     * 删除转接电话
     */
    String DEL_CALL_PHONE = "/rest/app/community/house/delCallPhone";

    /**
     * 获取添加成员权限
     */
    String GET_Add_MEMBER_PERMISSIONS = "/rest/app/community/house/getAddMemberPermissions";

    /**
     * 添加帐号
     */
    String BINDING_ACCOUNT = "/rest/app/community/house/bindingAccount";

    /**
     * 解绑帐号
     */
    String UNBINDING_ACCOUNT = "/rest/app/community/house/unbindingAccount";

    /**
     * 编辑帐号
     */
    String EDIT_BINDING_ACCOUNT = "/rest/app/community/house/editBindingAccount";

    /**
     * 获取消息列表
     */
    String GET_MESSAGE_LIST = "/rest/app/community/message/getList";

    /**
     * 获取商城url
     */
    String GET_MALL_URL = "/rest/app/community/setting/getMallUrl";

    /**
     * 获取消息详情
     */
    String GET_MESSAGE_DETAILS = "/rest/app/community/message/getDetail";

    /**
     * 设置消息已读
     */
    String SET_MESSAGE_READ = "/rest/app/community/message/read";

    /**
     * 删除消息
     */
    String DELETE_MESSAGE = "/rest/app/community/message/del";

    /**
     * 检查版本
     */
    String CHECK_VERSION = "/rest/app/community/version/check";

    /**
     * 获取下载二维码链接
     */
    String GET_DOWNLOAD_URL = "/rest/app/community/version/downloadPageUrl";

    /**
     * 获取转电话通讯录
     */
    String GET_CALL_BOOK = "/rest/app/community/house/getCallBook";

    /**
     * 推送设置
     */
    String SET_PUSH_CONFIG = "/rest/app/community/setting/setPushConfig";

    /**
     * 查询推送设置
     */
    String GET_PUSH_CONFIG = "/rest/app/community/setting/getPushConfig";

    /**
     * 获取报警记录列表
     */
    String GET_ALARM_LIST = "/rest/app/community/house/getAlarmList";

    /**
     * 查看报警记录
     */
    String READ_ALARM = "/rest/app/community/house/readAlarm";

    /**
     * 呼梯
     */
    String CALL_ELEVATOR = "/rest/app/community/house/callElevator";

    /**
     * 获取我的车辆列表
     */
    String GET_CAR_LIST = "/rest/app/community/house/getCarList";

    /**
     * 获取我的车位列表
     */
    String GET_PARKING_LIST = "/rest/app/community/house/getParkingList";

    /**
     * 车辆解锁或锁定
     */
    String CAR_LOCK_CTRL = "/rest/app/community/house/carLockCtrl";

    /**
     * 获取车辆出入场记录
     */
    String GET_CAR_ACCESS_LIST = "/rest/app/community/house/getCarAccessList";

    /**
     * 获取车辆报警记录列表
     */
    String GET_CAR_ALARM_LIST = "/rest/app/community/house/getCarAlarmList";

    /**
     * 查看车辆报警记录
     */
    String READ_CAR_ALARM = "/rest/app/community/house/readCarAlarm";


    /**
     * 新增报修
     */
    String ADD_REPAIR = "/rest/app/community/repair/addRepair";

    /**
     * 我的报修列表
     */
    String MY_REPAIR_LIST = "/rest/app/community/repair/listMyRepair";

    /**
     * 获取报修详情
     */
    String GET_REPAIR_DETAIL = "/rest/app/community/repair/getRepair";

    /**
     * 确认报修
     */
    String CHECK_REPAIR = "/rest/app/community/repair/checkRepair";

    /**
     * 评价报修
     */
    String PRAISE_REPAIR = "/rest/app/community/repair/praiseRepair";

    /**
     * 新增投诉
     */
    String ADD_COMPLAINT = "/rest/app/community/complaint/addComplaint";

    /**
     * 我的投诉列表
     */
    String MY_COMPLAINT_LIST = "/rest/app/community/complaint/listMyComplaint";

    /**
     * 获取投诉详情
     */
    String GET_COMPLAINT_DETAIL = "/rest/app/community/complaint/getComplaint";

    /**
     * 确认投诉
     */
    String CHECK_COMPLAINT = "/rest/app/community/complaint/checkComplaint";

    /**
     * 评价投诉
     */
    String PRAISE_COMPLAINT = "/rest/app/community/complaint/praiseComplaint";

    /**
     * 获取未缴费列表
     */
    String GET_UNPAID_LIST = "/rest/app/community/bill/unpaidList";

    /**
     * 获取账单详情
     */
    String GET_BILL_DETAIL = "/rest/app/community/bill/getDetail";

    /**
     * 获取已缴费账单列表
     */
    String GET_PAID_LIST = "/rest/app/community/bill/paidList";

    /**
     * 账单结算
     */
    String PAY = "/rest/app/community/bill/pay";

    /**
     * 获取社区公告列表
     */
    String GET_ANNOUNCE_LIST = "/rest/app/community/announce/list";

    /**
     * 获取社区公告详情
     */
    String GET_ANNOUNCE_DETAIL = "/rest/app/community/announce/get";

    /**
     * 获取数据字典表
     */
    String GET_DICTIONARY_LIST = "/rest/app/community/dictionary/list";

    /**
     * 获取访客预约列表
     */
    String GET_RESERVATION_LIST = "/rest/app/community/house/getReservationList";

    /**
     * 访客预约
     */
    String RESERVE_VISITOR = "/rest/app/community/house/reserveVisitor";

    /**
     * 访客预约重试
     */
    String RESERVE_VISITOR_RETRY = "/rest/app/community/house/reserveVisitorRetry";

    /**
     * 取消访客预约
     */
    String CANCEL_RESERVE_VISITOR = "/rest/app/community/house/cancelReserveVisitor";

    /**
     * 获取访客预约详情
     */
    String GET_RESERVATION_DETAIL = "/rest/app/community/house/getReservationDetail";


    /**
     * 获取2.0平台用户名密码
     */
    String GET_USER = "/rest/app/community/platform/getUser";


    /////////////////////////////////////////请求应答码////////////////////////////////////////////
    /**
     * 请求成功码
     */
    int RESULT_CODE_SUCCESS = 1;

    /**
     * 非法请求
     */
    int RESULT_CODE_ILLEGAL_REQUEST = 10000;

    /**
     * 访问令牌过期
     */
    int RESULT_CODE_ACCESS_TOKEN_EXPIRED = 10001;

    /**
     * 刷新令牌过期
     */
    int RESULT_CODE_REFRESH_TOKEN_EXPIRED = 10002;

    /**
     * 帐号已存在
     */
    int RESULT_CODE_ACCOUNT_EXIST = 10011;

    /**
     * 帐号未注册
     */
    int RESULT_CODE_ACCOUNT_NO_REGISTER = 10012;

    /**
     * 帐号异地登录
     */
    int RESULT_CODE_ACCOUNT_REMOTE_LOGIN = 10013;

    /**
     * 帐号被锁定，解锁时间xxx, 需要解析message内容获取解锁时间
     */
    int RESULT_CODE_ACCOUNT_LOCKED = 10014;

    /**
     * 帐号已注销
     */
    int RESULT_CODE_ACCOUNT_LOGOUT = 10015;

    /**
     * 帐号被禁用
     */
    int RESULT_CODE_ACCOUNT_DISABLED = 10016;

    /**
     * 帐号登录密码错误，剩余x次, 需要解析message内容获取剩余次数
     */
    int RESULT_CODE_LOGIN_PASSWORD_ERROR = 10017;

    /**
     * 帐号原密码错误
     */
    int RESULT_CODE_OLD_PASSWORD_ERROR = 10018;

    /**
     * 帐号密码被修改
     */
    int RESULT_CODE_PASSWORD_CHANGED = 10019;

    /**
     * 设备未授权
     */
    int RESULT_CODE_DEVICE_NO_AUTH = 10020;

    /**
     * 无效验证码
     */
    int RESULT_CODE_INVALID_VERIFY_CODE = 10024;

    /**
     * 验证码过期
     */
    int RESULT_CODE_VERIFY_CODE_EXPIRED = 10025;

    /**
     * 发送太过频繁,超过xx限额， 需要解析message内容获取限额次数
     */
    int RESULT_CODE_VERIFY_CODE_SEND_FREQUENTLY = 10026;

    /**
     * 账单已缴清
     */
    int BILL_PAID = 10040;

    /**
     * 存在已缴账单
     */
    int EXIST_PAID_BILL = 10041;

    /**
     * 解绑住家有成员错误码
     */
    int RESULT_CODE_UNBIND_SELF_HAD_FAMILY = -40001;

    /**
     * 车辆外出时锁车
     */
    int RESULT_CODE_CAR_OUTSIDE_LOCK = -40007;

    /**
     * 社区服务器不在线，请稍后再试
     */
    int RESULT_CODE_PROPERTY_OFFLINE = 10030;


    /**
     * 手机时间异常，登录失败
     */
    int RESULT_CODE_PHONE_TIME_ABNORMAL = 10034;
}
