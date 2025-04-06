package com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.barbarian.combat;

public class CombatBarbarianUpdate {

    public static String combatSkill1(String lv, String c1, String c2, String c3, String n1, String n2, String n3) {
        return
                "<font color='#48AE4A'>강격</font>" +
                        "<br>강력한 타격으로 적에게 주는 피해량이 증가하고<br>적을 뒤로 밀쳐냅니다." +
                        "<br><br>마나 소모: 2" +

                        "<br><br>현재 기술 레벨: " + lv +
                        "<br>명중률: +"+c1+"%" +
                        "<br>공격력: +"+c2+"%" +
                        "<br>공격력: +"+c3+"" +

                        "<br><br>다음 레벨" +
                        "<br>명중률: +"+n1+"%" +
                        "<br>공격력: +"+n2+"%" +
                        "<br>공격력: +"+n3+"" +

                        "<br><br><font color='#48AE4A'>강격에 보너스 적용:</font>" +
                        "<br>기절: 레벨당 피해 +5%" +
                        "<br>집중 공격: 레벨당 명중률 +5%";
    }

    public static String combatSkill2(String lv, String c1, String c2, String n1, String n2) {
        return
                "<font color='#48AE4A'>도약</font>" +
                        "<br>공중으로 도약한 후 착지하여<br>주위의 적을 뒤로 밀쳐냅니다." +
                        "<br><br>마나 소모: 2" +

                        "<br><br>현재 기술 레벨: " + lv +
                        "<br>범위 반경: "+c1+"미터" +
                        "<br>밀쳐내기 반경: "+c2+"미터" +

                        "<br><br>다음 레벨" +
                        "<br>범위 반경: "+n1+"미터" +
                        "<br>밀쳐내기 반경: "+n2+"미터" ;
    }

    public static String combatSkill3(String lv, String c1, String c2, String n1, String n2) {
        return
                "<font color='#48AE4A'>이중 타격</font>" +
                        "<br>두 개의 무기를 장착하고 있을 때<br>가능하면 두 명의 대상을 공격하며<br>아니면 한 대상을 두 번 공격합니다." +
                        "<br><br>공격력: +10%" +

                        "<br><br>현재 기술 레벨: " + lv +
                        "<br>명중률: +"+c1+"%" +
                        "<br>마나 소모: "+c2+"" +

                        "<br><br>다음 레벨" +
                        "<br>명중률: +"+n1+"%" +
                        "<br>마나 소모: "+n2+"" +

                        "<br><br><font color='#48AE4A'>이중 타격에 보너스 적용:</font>" +
                        "<br>강격: 레벨당 피해 +10%";
    }

    public static String combatSkill4(String lv, String c1, String c2, String n1, String n2) {
        return
                "<font color='#48AE4A'>기절</font>" +
                        "<br>대상을 잠시 동안 기절시키고<br>자신의 명중률을 증가시킵니다." +
                        "<br>공격력: +8%" +
                        "<br>마나 소모: 2" +

                        "<br><br>현재 기술 레벨: " + lv +
                        "<br>명중률: +"+c1+"%" +
                        "<br>기절 지속시간: "+c2+"초" +

                        "<br><br>다음 레벨" +
                        "<br>명중률: +"+n1+"%" +
                        "<br>기절 지속시간: "+n2+"초" +

                        "<br><br><font color='#48AE4A'>기절에 보너스 적용:</font>" +
                        "<br>강격: 레벨당 피해 +8%" +
                        "<br>집중 공격: 레벨당 명중률 +5%" +
                        "<br>전장의 합성: 레벨당 지속시간 +5%";
    }

    public static String combatSkill5(String lv, String c1, String c2, String n1, String n2) {
        return
                "<font color='#48AE4A'>이중 투척</font>" +
                        "<br>서로 다른 투척 무기 두 개를<br>동시에 투척할 수 있습니다." +
                        "<br><br>마나 소모: 2" +

                        "<br><br>현재 기술 레벨: " + lv +
                        "<br>명중률: +"+c1+"%" +
                        "<br>공격력: +"+c2+"%" +

                        "<br><br>다음 레벨" +
                        "<br>명중률: +"+n1+"%" +
                        "<br>공격력: +"+n2+"%" +

                        "<br><br><font color='#48AE4A'>이중 투척에 보너스 적용:</font>" +
                        "<br>이중 타격: 레벨당 피해 +8%";

    }

    public static String combatSkill6(String lv, String c1, String c2, String c3, String n1, String n2, String n3) {
        return
                "<font color='#48AE4A'>도약 공격</font>" +
                        "<br>대상 적에게 도약 공격하여<br>주위 적들에게 피해를 줍니다." +
                        "<br><br>마나 소모: 10" +

                        "<br><br>현재 기술 레벨: " + lv +
                        "<br>반경: 4.6미터" +
                        "<br>공격력: "+c1+"" +
                        "<br>명중률: +"+c2+"%" +
                        "<br>공격력: +"+c3+"%" +

                        "<br><br>다음 레벨" +
                        "<br>반경: 4.6미터" +
                        "<br>공격력: "+n1+"" +
                        "<br>명중률: +"+n2+"%" +
                        "<br>공격력: +"+n3+"%" +

                        "<br><br><font color='#48AE4A'>도약 공격에 보너스 적용:</font>" +
                        "<br>도약: 레벨당 피해 +10%";

    }

    public static String combatSkill7(String lv, String c1, String c2, String c3, String n1, String n2, String n3) {
        return
                "<font color='#48AE4A'>집중 공격</font>" +
                        "<br>방해받지 않으며 명중률과 방어력을<br>증가시키는 공격입니다." +
                        "<br>마법 피해: +1%" +
                        "<br><br>마나 소모: 2" +

                        "<br><br>현재 기술 레벨: " + lv +
                        "<br>명중률: +"+c1+"%" +
                        "<br>공격력: +"+c2+"%" +
                        "<br>방어력: +"+c3+"%" +

                        "<br><br>다음 레벨" +
                        "<br>명중률: +"+n1+"%" +
                        "<br>공격력: +"+n2+"%" +
                        "<br>방어력: +"+n3+"%" +

                        "<br><br><font color='#48AE4A'>집중 공격에 보너스 적용:</font>" +
                        "<br>강격: 레벨당 피해 +5%" +
                        "<br>전투 지시: 레벨당 피해 +10%" +
                        "<br>광폭화: 레벨당 마법 피해 +1%";
    }

    public static String combatSkill8(String lv, String c1, String c2, String c3, String c4, String n1, String n2, String n3, String n4) {
        return
                "<font color='#48AE4A'>광분</font>" +
                        "<br>두 개의 무기를 한 번에 휘두릅니다.<br>공격이 적중할 때마다 전체 속도가 증가합니다.<br>두 개의 무기를 장착해야 합니다." +
                        "<br><br>마법 피해: +1%" +
                        "<br>지속시간: 6초" +
                        "<br>마나 소모: 3" +

                        "<br><br>현재 기술 레벨: " + lv +
                        "<br>명중률: +"+c1+"%" +
                        "<br>공격력: +"+c2+"%" +
                        "<br>공격 속도: +"+c3+"%" +
                        "<br>걷기/달리기 속도: +"+c4+"%" +

                        "<br><br>다음 레벨" +
                        "<br>명중률: +"+n1+"%" +
                        "<br>공격력: +"+n2+"%" +
                        "<br>공격 속도: +"+n3+"%" +
                        "<br>걷기/달리기 속도: +"+n4+"%" +

                        "<br><br><font color='#48AE4A'>광분에 보너스 적용:</font>" +
                        "<br>이중 타격: 레벨당 피해 +8%" +
                        "<br>도발: 레벨당 피해 +8%" +
                        "<br>지구력 증가: 레벨당 +0.4초" +
                        "<br>광폭화: 레벨당 마법 피해 +1%";

    }

    public static String combatSkill9(String lv, String c1, String c2, String c3, String n1, String n2, String n3) {
        return
                "<font color='#48AE4A'>소용돌이</font>" +
                        "<br>소용돌이치는 죽음의 무도로<br>적 군단을 돌파합니다." +

                        "<br><br>현재 기술 레벨: " + lv +
                        "<br>명중률: +"+c1+"%" +
                        "<br>공격력: +"+c2+"%" +
                        "<br>마나 소모: "+c3+"" +

                        "<br><br>다음 레벨" +
                        "<br>명중률: +"+n1+"%" +
                        "<br>공격력: +"+n2+"%" +
                        "<br>마나 소모: "+n3+"";
    }

    public static String combatSkill10(String lv, String c1, String c2, String c3, String n1, String n2, String n3) {
        return
                "<font color='#48AE4A'>광폭화</font>" +
                        "<br>강력하지만 무모한 공격으로<br>공격력과 명중률이 증가하지만<br>방어력이 감소합니다." +
                        "<br><br>마나 소모: 4" +

                        "<br><br>현재 기술 레벨: " + lv +
                        "<br>명중률: +"+c1+"%" +
                        "<br>마법 피해: +"+c2+"%" +
                        "<br>지속시간: "+c3+"초" +

                        "<br><br>다음 레벨" +
                        "<br>명중률: +"+n1+"%" +
                        "<br>마법 피해: +"+n2+"%" +
                        "<br>지속시간: "+n3+"초" +

                        "<br><br><font color='#48AE4A'>광폭화에 보너스 적용:</font>" +
                        "<br>포효: 레벨당 마법 피해 +10%" +
                        "<br>전투 지시: 레벨당 마법 피해 +10%";
    }


    /*********************************************************************************************************************************************************************************************************/
    /*********************************************************************************************************************************************************************************************************/
    /*********************************************************************************************************************************************************************************************************/

    public static String combatSkill1_end(String lv, String c1, String c2, String c3, String c4, String c5, String c6, String c7, String c8, String c9) {
        return "<font color='#48AE4A'>강격</font>" +
                "<br><font color='#A95750'>강력한 타격으로 적에게 주는 피해량이 증가하고<br>적을 뒤로 밀쳐냅니다." +
                "<br>최고 레벨 도달" +
                "<br><br>마나 소모: 2" +
                "<br><br>현재 기술 레벨: " + lv +
                "<br>명중률: +" + c1 + "%" +
                "<br>공격력: +" + c2 + "%" +
                "<br>공격력: +" + c3 + "</font>"+
                "<br><br><font color='#48AE4A'>강격에 보너스 적용:</font>" +
                "<br><font color='#A95750'>기절: 레벨당 피해 +5%" +
                "<br>집중 공격: 레벨당 명중률 +5%";
    }

    public static String combatSkill2_end(String lv, String c1, String c2, String c3, String c4, String c5, String c6, String c7, String c8, String c9) {
        return "<font color='#48AE4A'>도약</font>" +
                "<br><font color='#A95750'>공중으로 도약한 후 착지하여<br>주위의 적을 뒤로 밀쳐냅니다." +
                "<br>최고 레벨 도달" +
                "<br><br>마나 소모: 2" +
                "<br><br>현재 기술 레벨: " + lv +
                "<br>범위 반경: " + c1 + "미터" +
                "<br>밀쳐내기 반경: " + c2 + "미터";
    }

    public static String combatSkill3_end(String lv, String c1, String c2, String c3, String c4, String c5, String c6, String c7, String c8, String c9) {
        return "<font color='#48AE4A'>이중 타격</font>" +
                "<br><font color='#A95750'>두 개의 무기를 장착하고 있을 때<br>가능하면 두 명의 대상을 공격하며<br>아니면 한 대상을 두 번 공격합니다." +
                "<br>최고 레벨 도달" +
                "<br><br>공격력: +200%" +
                "<br><br>현재 기술 레벨: " + lv +
                "<br>명중률: +" + c1 + "%" +
                "<br>마나 소모: " + c2 + "</font>"+
                "<br><br><font color='#48AE4A'>이중 타격에 보너스 적용:</font>" +
                "<br><font color='#A95750'>강격: 레벨당 피해 +10%";
    }

    public static String combatSkill4_end(String lv, String c1, String c2, String c3, String c4, String c5, String c6, String c7, String c8, String c9) {
        return "<font color='#48AE4A'>기절</font>" +
                "<br><font color='#A95750'>대상을 잠시 동안 기절시키고<br>자신의 명중률을 증가시킵니다." +
                "<br>최고 레벨 도달" +
                "<br>공격력: +160%" +
                "<br><br>마나 소모: 2" +
                "<br><br>현재 기술 레벨: " + lv +
                "<br>명중률: +" + c1 + "%" +
                "<br>기절 지속시간: " + c2 + "초</font>" +
                "<br><br><font color='#48AE4A'>기절에 보너스 적용:</font>" +
                "<br><font color='#A95750'>강격: 레벨당 피해 +8%" +
                "<br>집중 공격: 레벨당 명중률 +5%" +
                "<br>전장의 합성: 레벨당 지속시간 +5%";
    }

    public static String combatSkill5_end(String lv, String c1, String c2, String c3, String c4, String c5, String c6, String c7, String c8, String c9) {
        return "<font color='#48AE4A'>이중 투척</font>" +
                "<br><font color='#A95750'>서로 다른 투척 무기 두 개를<br>동시에 투척할 수 있습니다." +
                "<br>최고 레벨 도달" +
                "<br><br>마나 소모: 2" +
                "<br><br>현재 기술 레벨: " + lv +
                "<br>명중률: +" + c1 + "%" +
                "<br>공격력: +" + c2 + "%</font>" +
                "<br><br><font color='#48AE4A'>이중 투척에 보너스 적용:</font>" +
                "<br><font color='#A95750'>이중 타격: 레벨당 피해 +8%";
    }

    public static String combatSkill6_end(String lv, String c1, String c2, String c3, String c4, String c5, String c6, String c7, String c8, String c9) {
        return "<font color='#48AE4A'>도약 공격</font>" +
                "<br><font color='#A95750'>대상 적에게 도약 공격하여<br>주위 적들에게 피해를 줍니다." +
                "<br>최고 레벨 도달" +
                "<br><br>마나 소모: 10" +
                "<br><br>현재 기술 레벨: " + lv +
                "<br>반경: 4.6미터" +
                "<br>공격력: " + c1 +
                "<br>명중률: +" + c2 + "%" +
                "<br>공격력: +" + c3 + "%</font>" +
                "<br><br><font color='#48AE4A'>도약 공격에 보너스 적용:</font>" +
                "<br><font color='#A95750'>도약: 레벨당 피해 +10%";
    }

    public static String combatSkill7_end(String lv, String c1, String c2, String c3, String c4, String c5, String c6, String c7, String c8, String c9) {
        return "<font color='#48AE4A'>집중 공격</font>" +
                "<br><font color='#A95750'>방해받지 않으며 명중률과 방어력을<br>증가시키는 공격입니다." +
                "<br>최고 레벨 도달" +
                "<br><br>마나 소모: 2" +
                "<br><br>현재 기술 레벨: " + lv +
                "<br>명중률: +" + c1 + "%" +
                "<br>공격력: +" + c2 + "%" +
                "<br>방어력: +" + c3 + "%</font>" +
                "<br><br><font color='#48AE4A'>집중 공격에 보너스 적용:</font>" +
                "<br><font color='#A95750'>강격: 레벨당 피해 +5%" +
                "<br>전투 지시: 레벨당 피해 +10%" +
                "<br>광폭화: 레벨당 마법 피해 +1%";
    }

    public static String combatSkill8_end(String lv, String c1, String c2, String c3, String c4, String c5, String c6, String c7, String c8, String c9) {
        return "<font color='#48AE4A'>광분</font>" +
                "<br><font color='#A95750'>두 개의 무기를 한 번에 휘두릅니다.<br>공격이 적중할 때마다 전체 속도가 증가합니다.<br>두 개의 무기를 장착해야 합니다." +
                "<br>최고 레벨 도달" +
                "<br><br>지속시간: 6초" +
                "<br>마나 소모: 3" +
                "<br><br>현재 기술 레벨: " + lv +
                "<br>명중률: +" + c1 + "%" +
                "<br>공격력: +" + c2 + "%" +
                "<br>공격 속도: +" + c3 + "%" +
                "<br>걷기/달리기 속도: +" + c4 + "%</font>" +
                "<br><br><font color='#48AE4A'>광분에 보너스 적용:</font>" +
                "<br><font color='#A95750'>이중 타격: 레벨당 피해 +8%" +
                "<br>도발: 레벨당 피해 +8%" +
                "<br>지구력 증가: 레벨당 +0.4초" +
                "<br>광폭화: 레벨당 마법 피해 +1%";
    }

    public static String combatSkill9_end(String lv, String c1, String c2, String c3, String c4, String c5, String c6, String c7, String c8, String c9) {
        return "<font color='#48AE4A'>소용돌이</font>" +
                "<br><font color='#A95750'>소용돌이치는 죽음의 무도로<br>적 군단을 돌파합니다." +
                "<br>최고 레벨 도달" +
                "<br><br>현재 기술 레벨: " + lv +
                "<br>명중률: +" + c1 + "%" +
                "<br>공격력: +" + c2 + "%" +
                "<br>마나 소모: " + c3;
    }

    public static String combatSkill10_end(String lv, String c1, String c2, String c3, String c4, String c5, String c6, String c7, String c8, String c9) {
        return "<font color='#48AE4A'>광폭화</font>" +
                "<br><font color='#A95750'>강력하지만 무모한 공격으로<br>공격력과 명중률이 증가하지만<br>방어력이 감소합니다." +
                "<br>최고 레벨 도달" +
                "<br><br>마나 소모: 4" +
                "<br><br>현재 기술 레벨: " + lv +
                "<br>명중률: +" + c1 + "%" +
                "<br>마법 피해: +" + c2 + "%" +
                "<br>지속시간: " + c3 + "초</font>" +
                "<br><br><font color='#48AE4A'>광폭화에 보너스 적용:</font>" +
                "<br><font color='#A95750'>포효: 레벨당 마법 피해 +10%" +
                "<br>전투 지시: 레벨당 마법 피해 +10%";
    }



}
