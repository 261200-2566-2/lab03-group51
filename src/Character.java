
public class Character {
    private int max_HP = 100, max_Mana = 50;
    private static final int base_Damage = 5;
    private static final int Run = 10;

    private static int level = 1;
    String name;
    double max_Speed ;
    int HP, Mana, Defend, Damage;
    boolean Eq_Sword;
    boolean Eq_Shield;

    public Character(String name) {
        this.name = name;
        HP = max_HP;
        Mana = max_Mana;
        calculate();
    }

    private void calculate() {
        max_HP += 10 * (level - 1);
        max_Mana += 2 * (level - 1);
        HP += 10 * (level - 1);
        Mana += 2 * (level - 1);
        Defend += 10 * (level - 1);
        max_Speed = Run+Run * (0.1 + 0.03 * (level - 1));
        Damage = base_Damage + base_Damage + (1 + 2 * (level - 1));
    }
    public void level_UP(){
        level++;
        Equipment.sword.lv_up();
        Equipment.shield.lv_up();
        calculate();
    }
    public void Attack(Character a){
        a.HP -= Damage-(Defend/2);
        if(a.HP<=0){
            a.HP = 0;
            System.out.println("Game Over");
        }
    }
    public void Equip_Sw(Equipment.sword x) {
        if(!Eq_Sword){
            Eq_Sword = true;
            x.speed_SW = Run * (0.1 + 0.04 * level);
            max_Speed = max_Speed - x.speed_SW;
            Damage += Equipment.sword.sword_Dmg;

        }
    }
    public void Un_EquipSw(Equipment.sword x){
        if(Eq_Sword){
            Eq_Sword = false;
            max_Speed = max_Speed + x.speed_SW;
            Damage -= Equipment.sword.sword_Dmg;
        }
    }
    public void Equip_Sh(Equipment.shield x){
        if(!Eq_Shield){
            Eq_Shield = true;
            x.speed_SH = Run * (0.1 + 0.08 * level);
            max_Speed = max_Speed - x.speed_SH;
            Defend += Equipment.shield.shield_Def;
        }
    }
    public void Un_EquipSh(Equipment.shield x){
        if(Eq_Shield){
            Eq_Shield = false;
            max_Speed = max_Speed + x.speed_SH;
        }
    }


}
