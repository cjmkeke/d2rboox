package com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.necromancer.poison;

public class PoisonUpdate {

    public static String poisonSkill1(String lv, String c1, String c2, String c3, String n1, String n2, String n3) {
        return
                "<font color='#48AE4A'>이빨</font>" +
                        "<br>가시 이빨을 소환하여 연속으로 발사합니다." +
                        "<br><br>현재 기술 레벨: "+lv+
                        "<br>이빨 "+c1+"개" +
                        "<br>마법 피해: "+c2 +
                        "<br>마나 소모: "+c3 +
                        "<br><br>다음 레벨"+
                        "<br>이빨 "+n1+"개" +
                        "<br>마법 피해: "+n2 +
                        "<br>마나 소모: "+n3 +
                        "<br><br><font color='#48AE4A'>이빨에 보너스 적용:</font>" +
                        "<br>뼈의 벽: 레벨당 마법 피해 +15%"+
                        "<br>뼈 창: 레벨당 마법 피해 +15%"+
                        "<br>뼈 감옥: 레벨당 마법 피해 +15%"+
                        "<br>뼈 영혼: 레벨당 마법 피해 +15%";

    }

    public static String poisonSkill2(String lv, String c1, String c2, String n1, String n2) {
        return
                "<font color='#48AE4A'>뼈 갑옷</font>" +
                        "<br>자신의 주위를 도는 뼈의 방패를 만들어<br>근접 피해를 흡수합니다." +
                        "<br><br>현재 기술 레벨: "+lv+
                        "<br>"+c1+"의 피해 흡수" +
                        "<br>마나 소모: "+c2 +
                        "<br><br>다음 레벨"+
                        "<br>"+n1+"의 피해 흡수" +
                        "<br>마나 소모: "+n2 +
                        "<br><br><font color='#48AE4A'>뼈 갑옷에 보너스 적용:</font>" +
                        "<br>뼈의 벽: 레벨당 마법 피해 +15%"+
                        "<br>뼈 감옥: 레벨당 마법 피해 +15%";
    }


    public static String poisonSkill3(String lv, String c1, String c2, String c3, String c4, String n1, String n2, String n3, String n4) {
        return
                "<font color='#48AE4A'>맹독 단도</font>" +
                        "<br>단도 공격에 독 피해를 추가합니다." +
                        "<br><br>마나 소모: 3" +
                        "<br><br>현재 기술 레벨: "+lv+
                        "<br>명중률: +"+c1+"%" +
                        "<br>독 피해: "+c2 +
                        "<br>"+c3+"초에 걸쳐" +
                        "<br>마나 소모: "+c4+
                        "<br><br>다음 레벨"+
                        "<br>명중률: +"+n1+"%" +
                        "<br>독 피해: "+n2 +
                        "<br>"+n3+"초에 걸쳐" +
                        "<br>마나 소모: "+n4+
                        "<br><br><font color='#48AE4A'>맹독 단도에 보너스 적용:</font>" +
                        "<br>맹독 폭발: 레벨당 독 피해 +20%"+
                        "<br>맹독 확산: 레벨당 독 피해 +20%";
    }

    public static String poisonSkill4(String lv, String c1, String c2, String n1, String n2) {
        return
                "<font color='#48AE4A'>시체 폭발</font>" +
                        "<br>처치한 괴물의 시체에 시전하여<br>폭발시키고 주위의 적에게 피해를 줍니다." +
                        "<br><br>피해: 시체 생명력의 70-120%" +
                        "<br><br>현재 기술 레벨: "+lv+
                        "<br>반경: "+c1+"미터" +
                        "<br>마나 소모: "+c2+
                        "<br><br>다음 레벨"+
                        "<br>반경: "+n1+"미터" +
                        "<br>마나 소모: "+n2;
    }


    public static String poisonSkill5(String lv, String c1, String n1) {
        return
                "<font color='#48AE4A'>뼈의 벽</font>" +
                        "<br>뼈와 잔해로 지나갈 수 없는<br>방볍을 생성합니다." +
                        "<br><br>지속시간: 24초" +
                        "<br>마나 소모: 17" +
                        "<br><br>현재 기술 레벨: "+lv+
                        "<br>생명력: "+c1+
                        "<br><br>다음 레벨"+
                        "<br>생명력: "+n1+
                        "<br><br><font color='#48AE4A'>뼈의 벽에 보너스 적용:</font>" +
                        "<br>뼈 갑옷: 레벨당 생명력 +10%"+
                        "<br>뼈 감옥: 레벨당 생명력 +10%";
    }

    public static String poisonSkill6(String lv, String c1, String c2, String n1, String n2) {
        return
                "<font color='#48AE4A'>맹독 폭발</font>" +
                        "<br>처치한 괴물의 시체에 시전하여<br>독성 가스를 방출시키고<br>주위의 적을 중독시킵니다." +
                        "<br><br>마나 소모: 8" +
                        "<br><br>현재 기술 레벨: "+lv+
                        "<br>독 피해: "+c1 +
                        "<br>"+c2+"초에 걸쳐" +
                        "<br><br>다음 레벨"+
                        "<br>독 피해: "+n1 +
                        "<br>"+n2+"초에 걸쳐" +
                        "<br><br><font color='#48AE4A'>맹독 폭발에 보너스 적용:</font>" +
                        "<br>맹독 단도: 레벨당 독 피해 +15%" +
                        "<br>맹독 확산: 레벨당 독 피해 +15%";
    }

    public static String poisonSkill7(String lv, String c1, String c2, String n1, String n2) {
        return
                "<font color='#48AE4A'>뼈 창</font>" +
                        "<br>치명적인 뼈 쐐기를 소환하여 적을 관통합니다." +
                        "<br><br>현재 기술 레벨: "+lv+
                        "<br>마법 피해: "+c1 +
                        "<br>마나 소모: "+c2 +
                        "<br><br>다음 레벨"+
                        "<br>마법 피해: "+n1 +
                        "<br>마나 소모: "+n2 +
                        "<br><br><font color='#48AE4A'>뼈 창에 보너스 적용:</font>" +
                        "<br>이빨: 레벨당 마법 피해 +8%"+
                        "<br>뼈의 벽: 레벨당 마법 피해 +8%"+
                        "<br>뼈 감옥: 레벨당 마법 피해 +8%"+
                        "<br>뼈 영혼: 레벨당 마법 피해 +8%";
    }

    public static String poisonSkill8(String lv, String c1, String c2, String n1, String n2) {
        return
                "<font color='#48AE4A'>뼈 감옥</font>" +
                        "<br>대상 주위에 화석화된 뼈의 방벽을 생성합니다." +
                        "<br><br>지속시간: 24초" +
                        "<br><br>현재 기술 레벨: "+lv+
                        "<br>생명력: "+c1+
                        "<br>마나 소모: "+c2+
                        "<br><br>다음 레벨"+
                        "<br>생명력: "+n1+
                        "<br>마나 소모: "+n2+
                        "<br><br><font color='#48AE4A'>뼈 감옥에 보너스 적용:</font>" +
                        "<br>뼈 감옥: 레벨당 마법 피해 +8%"+
                        "<br>뼈의 벽: 레벨당 마법 피해 +8%";
    }

    public static String poisonSkill9(String lv, String c1, String n1) {
        return
                "<font color='#48AE4A'>맹독 확산</font>" +
                        "<br>사방으로 퍼지는 맹독을 방출합니다." +
                        "<br><br>마나 소모: 20" +
                        "<br><br>현재 기술 레벨: "+lv+
                        "<br>독 피해: "+c1+
                        "<br>2초에 걸쳐" +
                        "<br><br>다음 레벨"+
                        "<br>독 피해: "+n1+
                        "<br>2초에 걸쳐" +
                        "<br><br><font color='#48AE4A'>맹독 확산에 보너스 적용:</font>" +
                        "<br>맹독 단도: 레벨당 독 피해 +10%"+
                        "<br>맹독 폭발: 레벨당 독 피해 +10%";
    }

    public static String poisonSkill10(String lv, String c1, String c2, String n1, String n2) {
        return
                "<font color='#48AE4A'>뼈 영혼</font>" +
                        "<br>안석을 찾지 못한 언데드 영혼을 내보내<br>대상을 추적하거나 동족을 찾게 합니다." +
                        "<br><br>현재 기술 레벨: "+lv+
                        "<br>마법 피해: "+c1+
                        "<br>마나 소모: "+c2+
                        "<br><br>다음 레벨"+
                        "<br>마법 피해: "+n1+
                        "<br>마나 소모: "+n2+
                        "<br><br><font color='#48AE4A'>뼈 영혼에 보너스 적용:</font>" +
                        "<br>이빨: 레벨당 마법 피해 +8%" +
                        "<br>뼈의 벽: 레벨당 마법 피해 +8%" +
                        "<br>뼈 창: 레벨당 마법 피해 +8%" +
                        "<br>뼈 감옥: 레벨당 마법 피해 +8%";

    }


}
