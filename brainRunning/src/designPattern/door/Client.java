package designPattern.door;

/**
 * @Author fuzf
 * @Date 2021/6/7:14:57
 * @Description:
 */
public class Client {
    public static void main(String[] args) {
        //普通模式需要这样
        AliSmsService aliSmsService = new AliSmsServiceImpl();
        EmailSmsService emailSmsService = new EmailSmsServiceImpl();
        WeiXinSmsService weiXinSmsService = new WeiXinSmsServiceImpl();
        aliSmsService.sendSms();
        emailSmsService.sendSms();
        weiXinSmsService.sendSms();

        //利用外观模式简化方法
        new Computer().sendMsg();
    }
}
