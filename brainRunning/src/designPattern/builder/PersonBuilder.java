package designPattern.builder;

/**
 * @Author fuzf
 * @Date 2021/6/4:17:39
 * @Description:
 */
public interface PersonBuilder {
    void buildHelmet();

    void buildArmor();

    void buildWeapon();

    Arms build();
}
