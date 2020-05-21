package com.lr.jooq.application;

/**
 * @author liurui
 * @date 2020/5/15 4:33 下午
 */
public class CommonException extends RuntimeException {


    public static CommonException SystemError = new CommonException(1000, "系统异常!");
    public static CommonException ParamNotLegal = new CommonException(1001, "参数错误！");
    public static CommonException AccessDeniedException = new CommonException(1002, "没有权限！");

    public static CommonException UserNotFoundException = new CommonException(10001, "用户信息不存在!");
    public static CommonException CaptchaNotMatch = new CommonException(10002, "验证码错误!");
    public static CommonException UserLoginFailure = new CommonException(10003, "用户登录失败!");
    public static CommonException UserIllegal = new CommonException(10004, "账号密码错误！");
    public static CommonException UserNotLogin = new CommonException(10005, "用户未登录！");
    public static CommonException UserStatusNotLegal = new CommonException(10006, "用户状态信息不正确！");
    public static CommonException RoleNotExist = new CommonException(10007, "角色不存在！");
    public static CommonException UserDuplicateEmail = new CommonException(10008, "重复邮箱！");
    public static CommonException SessionFail = new CommonException(10009, "token失效！");
    public static CommonException SessionFailToGet = new CommonException(10010, "token没有获取到！");
    public static CommonException SubscribeError = new CommonException(10011, "未关注公众号！");

    public static CommonException CustomerNotFoundException = new CommonException(12000, "客户信息不存在!");
    public static CommonException CustomerReAssign = new CommonException(12001, "重复分配!");

    public static CommonException MainTainTypeNotExist = new CommonException(14000, "客户维护方式不存在!");
    public static CommonException HttpRequestException = new CommonException(13000, "http异常");

    public static CommonException ChatRoomHaveNoPermission = new CommonException(15001, "没有权限!");
    public static CommonException ChatVoiceLaterPull = new CommonException(15002, "服务器繁忙，请稍后获取!");

    public static CommonException UserNotPassGdpr = new CommonException(20001, "该候选人没有通过GDPR检测");

    public static CommonException FILE_REQUIRED = new CommonException(30001, "文件是必填项!");
    public static CommonException FILE_ERROR = new CommonException(30002, "文件超过2m!");

    public static CommonException EMPLOYEE_CHECK_FAILED = new CommonException(99999, "该用户不是员工");
    public static CommonException NOT_FOUNT_HR_ACCOUNT = new CommonException(19001, "很抱歉，未能找到您的账户，请联系您的HR管理员。");



    public CommonException(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    /**
     * 创建参数不合法异常
     * @param message 异常消息
     * @return
     */
    public static CommonException buildParamNotLegal(String message) {
        return new CommonException(1001, message);
    }
}
