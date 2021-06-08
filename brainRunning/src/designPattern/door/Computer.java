package designPattern.door;

/**
 * 1. 创建门面（门面看起来很简单使用，复杂的东西以及被门面给封装好了）
 *
 * @Author fuzf
 * @Date 2021/6/7:14:54
 * @Description:
 */
public class Computer {

    AliSmsService aliSmsService;
    EmailSmsService emailSmsService;
    WeiXinSmsService weiXinSmsService;

    public Computer() {
        aliSmsService = new AliSmsServiceImpl();
        emailSmsService = new EmailSmsServiceImpl();
        weiXinSmsService = new WeiXinSmsServiceImpl();
    }

    //只需要调用它
    public void sendMsg() {
        aliSmsService.sendSms();
        emailSmsService.sendSms();
        weiXinSmsService.sendSms();
    }
}
