package designPattern.builder;

/**
 * @Author fuzf
 * @Date 2021/6/7:09:47
 * @Description:
 */
public class SuperArmsBuilder implements PersonBuilder {
    private Arms arms;

    public SuperArmsBuilder() {
        arms = new Arms();
    }

    @Override
    public void buildHelmet() {
        arms.setHelmet("super helmet");
    }

    @Override
    public void buildArmor() {
        arms.setArmor("super armor");
    }

    @Override
    public void buildWeapon() {
        arms.setWeapon("super weapon");
    }

    @Override
    public Arms build() {
        return arms;
    }
}
