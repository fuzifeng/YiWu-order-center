package designPattern.door;

/**
 * @Author fuzf
 * @Date 2021/6/7:14:53
 * @Description:
 */
public class EmailSmsServiceImpl implements EmailSmsService {
    @Override
    public void sendSms() {
        System.out.println("发送邮件消息");
    }
}
