public class Equipment {
    public static class sword {
        double speed_SW = 0;
        static int baseDamageSw ,sword_Dmg ,level = 1;
        public sword(int baseDamage_Sw){
            baseDamageSw = baseDamage_Sw;
            sword_Dmg = baseDamage_Sw*(1+level+1);
        }
        public static void lv_up(){
            level++;
            sword_Dmg = baseDamageSw*(1+level+1);
        }
    }
    public static class shield {
        double speed_SH = 0;
        static int baseDefenseSh ,shield_Def ,level = 1;

        public shield(int baseDefense_Sh){
            baseDefenseSh = baseDefense_Sh;
            shield_Def = baseDefenseSh*(1+level);
        }
        public static void lv_up(){
            level++;
            shield_Def = baseDefenseSh*(1+level);
        }
    }
}
