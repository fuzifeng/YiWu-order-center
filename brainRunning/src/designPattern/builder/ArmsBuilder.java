package designPattern.builder;

/**
 * @Author fuzf
 * @Date 2021/6/4:17:42
 * @Description:
 */
public class ArmsBuilder implements PersonBuilder {

    private Arms arms;

    public ArmsBuilder() {
        arms = new Arms();
    }

    @Override
    public void buildHelmet() {
        arms.setHelmet("夺命头盔");
    }

    @Override
    public void buildArmor() {
        arms.setArmor("夺命铠甲");
    }

    @Override
    public void buildWeapon() {
        arms.setWeapon("夺命武器");
    }

    @Override
    public Arms build() {
        return arms;
    }
}
