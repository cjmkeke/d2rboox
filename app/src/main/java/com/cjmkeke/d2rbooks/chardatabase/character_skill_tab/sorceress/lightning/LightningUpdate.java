package com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.sorceress.lightning;

public class LightningUpdate {

    public static String lightningSkill1(String lv, String c1, String c2, String c3, String c4, String c5, String c6) {
        return "<font color='#48AE4A'>번개 즐기</font>" +
                "<br>무작위 방향으로 날아가는<br>전기 마력 즐기를 다수 생성합니다." +
                "<br><br>현재 기술 레벨: " + lv +
                "<br>투사체 "+c1+"개" +
                "<br>번개 피해: "+c2+"" +
                "<br>마나 소모: "+c3+"" +
                "<br><br>다음 레벨" +
                "<br>투사체 "+c4+"개" +
                "<br>번개 피해: "+c5+"" +
                "<br>마나 소모: "+c6+"" +
                "<br><br><font color='#48AE4A'>번개 즐기에 보너스 적용:</font>" +
                "<br>번개: 레벨당 번개 피해 +6%";
    }


    public static String lightningSkill2(String lv, String c1, String c2) {
        return "<font color='#48AE4A'>전자기장</font>" +
                "<br>전기장을 생성하여 주위 모든 적의<br>생명력을 감소시킵니다." +
                "<br><br>적을 25% 약화시킴" +
                "<br>마나 소모: 9" +
                "<br><br>현재 기술 레벨: " + lv +
                "<br>반경: "+c1+"미터" +
                "<br><br>다음 레벨" +
                "<br>반경: "+c2+"미터";
    }

    public static String lightningSkill3(String lv, String c1, String c2) {
        return "<font color='#48AE4A'>염력</font>" +
                "<br>정신의 힘을 사용하여<br>아이템을 줍거나, 물체를 사용하거나,<br>적을 뒤로 밀쳐냅니다." +
                "<br><br>마나 소모: 7" +
                "<br><br>현재 기술 레벨: " + lv +
                "<br>번개 피해: "+c1+"" +
                "<br><br>다음 레벨" +
                "<br>번개 피해: "+c2+"";
    }

    public static String lightningSkill4(String lv, String c1, String c2, String c3, String c4) {
        return "<font color='#48AE4A'>번개 파장</font>" +
                "<br>번개 파장을 방출하여<br>주위의 적에게 충격을 줍니다." +
                "<br><br>현재 기술 레벨: " + lv +
                "<br>번개 피해: "+c1+"" +
                "<br>마나 소모: "+c2+"" +
                "<br><br>다음 레벨" +
                "<br>번개 피해: "+c3+"" +
                "<br>마나 소모: "+c4+"" +
                "<br><br><font color='#48AE4A'>번개 파장에 보너스 적용:</font>" +
                "<br>전자기장: 레벨당 번개 피해 +5%";
    }

    public static String lightningSkill5(String lv, String c1, String c2, String c3, String c4) {
        return "<font color='#48AE4A'>번개</font>" +
                "<br>강력한 번개를 생성하여<br>적을 사멸시킵니다." +
                "<br><br>현재 기술 레벨: " + lv +
                "<br>번개 피해: "+c1+"" +
                "<br>마나 소모: "+c2+"" +
                "<br><br>다음 레벨" +
                "<br>번개 피해: "+c3+"" +
                "<br>마나 소모: "+c4+"" +
                "<br><br><font color='#48AE4A'>번개에 보너스 적용:</font>" +
                "<br>번개 즐기: 레벨당 번개 피해 +8%" +
                "<br>번개 파장: 레벨당 번개 피해 +8%" +
                "<br>연쇄 번개: 레벨당 번개 피해 +8%";
    }

    public static String lightningSkill6(String lv, String c1, String c2, String c3, String c4, String c5, String c6) {
        return "<font color='#48AE4A'>연쇄 번개</font>" +
                "<br>다수의 대상에게 튕기는<br>강력한 번개를 생성합니다." +
                "<br><br>현재 기술 레벨: " + lv +
                "<br>"+c1+"회 적중" +
                "<br>번개 피해: "+c2+"" +
                "<br>마나 소모: "+c3+"" +
                "<br><br>다음 레벨" +
                "<br>"+c4+"회 적중" +
                "<br>번개 피해: "+c5+"" +
                "<br>마나 소모: "+c6+"" +
                "<br><br><font color='#48AE4A'>연쇄 번개에 보너스 적용:</font>" +
                "<br>번개 즐기: 레벨당 번개 피해 +4%" +
                "<br>번개 파장: 레벨당 번개 피해 +4%" +
                "<br>번개: 레벨당 번개 피해 +4%";
    }

    public static String lightningSkill7(String lv, String c1, String c2) {
        return "<font color='#48AE4A'>순간 이동</font>" +
                "<br>시야 내의 목적지로 즉시 이동합니다." +
                "<br><br>현재 기술 레벨: " + lv +
                "<br>마나 소모: "+c1+"" +
                "<br><br>다음 레벨" +
                "<br>마나 소모: "+c2+"";
    }

    public static String lightningSkill8(String lv, String c1, String c2, String c3, String c4) {
        return "<font color='#48AE4A'>뇌우</font>" +
                "<br>치명적인 뇌우를 소환하여<br>적에게 버락을 내립니다." +
                "<br><br>반경: 11.3미터" +
                "<br>마나 소모: 19" +
                "<br><br>현재 기술 레벨: " + lv +
                "<br>번개 피해: "+c1+"" +
                "<br>지속시간: "+c2+"초" +
                "<br><br>다음 레벨" +
                "<br>번개 피해: "+c3+"" +
                "<br>지속시간: "+c4+"초" +
                "<br><br><font color='#48AE4A'>뇌우에 보너스 적용:</font>" +
                "<br>전자기장: 레벨당 번개 피해 +7%";
    }

    public static String lightningSkill9(String lv, String c1, String c2, String c3, String c4) {
        return "<font color='#48AE4A'>마력 보호막</font>" +
                "<br>마법 보호막을 생성하여 피해를 받을 때<br>생명력 대신 마나를 소모합니다." +
                "<br><br>피해당 마나 소모: 194%" +
                "<br>마나 소모: 5" +
                "<br><br>현재 기술 레벨: " + lv +
                "<br>흡수 "+c1+"%" +
                "<br>지속시간: "+c2+"초" +
                "<br><br>다음 레벨" +
                "<br>흡수 "+c3+"%" +
                "<br>지속시간: "+c4+"초" +
                "<br><br><font color='#48AE4A'>마력 보호막에 보너스 적용:</font>" +
                "<br>염력: 레벨당 마나 소모 -6%";
    }

    public static String lightningSkill10(String lv, String c1, String c2) {
        return "<font color='#48AE4A'>번개 숙련</font>" +
                "<br>지속 효과 - 번개 주문으로 주는 모든 피해가 증가합니다." +
                "<br><br>현재 기술 레벨: " + lv +
                "<br>번개 피해: +"+c1+"%" +
                "<br><br>다음 레벨" +
                "<br>번개 피해: +"+c2+"%";
    }

    /*********************************************************************************************************************************************************************************************************/
    /*********************************************************************************************************************************************************************************************************/
    /*********************************************************************************************************************************************************************************************************/

    public static String lightningSkill1_end(String lv, String c1, String c2, String c3, String c4, String c5, String c6, String c7, String c8, String c9) {
        return "<font color='#48AE4A'>번개 줄기</font>" +
                "<br><font color='#A95750'>무작위 방향으로 날아가는" +
                "<br>전기 마력 줄기로 다수 생성합니다." +
                "<br>최대 레벨 도달" +
                "<br><br>현재 기술 레벨: " + lv +
                "<br>투사체 "+c1+"개" +
                "<br>번개 피해: "+c2+"" +
                "<br>마나 소모: "+c3+"</font>" +
                "<br><br><font color='#48AE4A'>번개 줄기에 보너스 적용:</font>" +
                "<br><font color='#A95750'>번개: 레벨당 번개 피해 +6%";
    }

    public static String lightningSkill2_end(String lv, String c1, String c2, String c3, String c4, String c5, String c6, String c7, String c8, String c9) {
        return "<font color='#48AE4A'>전자 기장</font>" +
                "<br><font color='#A95750'>전기장을 생성하여 주위 모든 적의" +
                "<br>생명력을 감소시킵니다." +
                "<br>최대 레벨 도달" +
                "<br><br>적을 25% 약화시킴" +
                "<br>마나 소모: 9" +
                "<br><br>현재 기술 레벨: " + lv +
                "<br>반경: "+c1+"미터";
    }

    public static String lightningSkill3_end(String lv, String c1, String c2, String c3, String c4, String c5, String c6, String c7, String c8, String c9) {
        return "<font color='#48AE4A'>염력</font>" +
                "<br><font color='#A95750'>정신의 힘을 사용하여" +
                "<br>아이템을 줍거나, 물체를 사용하거나," +
                "<br>적을 뒤로 밀쳐냅니다." +
                "<br>최대 레벨 도달" +
                "<br><br>마나 소모: 7" +
                "<br><br>현재 기술 레벨: " + lv +
                "<br>번개 피해: "+c1+"";
    }

    public static String lightningSkill4_end(String lv, String c1, String c2, String c3, String c4, String c5, String c6, String c7, String c8, String c9) {
        return "<font color='#48AE4A'>번개 파장</font>" +
                "<br><font color='#A95750'>번개 파장을 방출하여" +
                "<br>주위의 적에게 충격을 줍니다." +
                "<br>최대 레벨 도달" +
                "<br><br>현재 기술 레벨: " + lv +
                "<br>번개 피해: "+c1+"" +
                "<br>마나 소모: "+c2+"</font>" +
                "<br><br><font color='#48AE4A'>번개 파장에 보너스 적용:</font>" +
                "<br><font color='#A95750'>전자기장: 레벨당 번개 피해 +5%";
    }

    public static String lightningSkill5_end(String lv, String c1, String c2, String c3, String c4, String c5, String c6, String c7, String c8, String c9) {
        return "<font color='#48AE4A'>번개</font>" +
                "<br><font color='#A95750'>강력한 번개를 생성하여" +
                "<br>적을 사멸시킵니다." +
                "<br>최대 레벨 도달" +
                "<br><br>현재 기술 레벨: " + lv +
                "<br>번개 피해: "+c1+"" +
                "<br>마나 소모: "+c2+"</font>" +
                "<br><br><font color='#48AE4A'>번개에 보너스 적용:</font>" +
                "<br><font color='#A95750'>번개 줄기: 레벨당 번개 피해 +8%" +
                "<br>번개 파장: 레벨당 번개 피해 +8%" +
                "<br>연쇄 번개: 레벨당 번개 피해 +8%";
    }

    public static String lightningSkill6_end(String lv, String c1, String c2, String c3, String c4, String c5, String c6, String c7, String c8, String c9) {
        return "<font color='#48AE4A'>연쇄 번개</font>" +
                "<br><font color='#A95750'>다수의 대상에게 튕기는" +
                "<br>강력한 번개를 생성합니다." +
                "<br>최대 레벨 도달" +
                "<br><br>현재 기술 레벨: " + lv +
                "<br>"+c1+"회 적중" +
                "<br>번개 피해: "+c2+"" +
                "<br>마나 소모: "+c3+"</font>" +
                "<br><br><font color='#48AE4A'>연쇄 번개에 보너스 적용:</font>" +
                "<br><font color='#A95750'>번개 줄기: 레벨당 번개 피해 +4%" +
                "<br>번개 파장: 레벨당 번개 피해 +4%" +
                "<br>번개: 레벨당 번개 피해 +4%";
    }

    public static String lightningSkill7_end(String lv, String c1, String c2, String c3, String c4, String c5, String c6, String c7, String c8, String c9) {
        return "<font color='#48AE4A'>순간이동</font>" +
                "<br><font color='#A95750'>시야 내의 목적지로 즉시 이동합니다." +
                "<br>최대 레벨 도달" +
                "<br><br>현재 기술 레벨: " + lv +
                "<br>마나 소모: "+c1+"</font>";
    }

    public static String lightningSkill8_end(String lv, String c1, String c2, String c3, String c4, String c5, String c6, String c7, String c8, String c9) {
        return "<font color='#48AE4A'>뇌우</font>" +
                "<br><font color='#A95750'>치명적인 뇌우를 소환하여 적에게 벼락을 내리칩니다." +
                "<br>최대 레벨 도달" +
                "<br>남은 기술 포인트 8개" +
                "<br><br>반경: 11.3미터" +
                "<br>마나 소모: 19" +
                "<br><br>현재 기술 레벨: " + lv +
                "<br>번개 피해: "+c1+"" +
                "<br>지속시간: "+c2+"초</font>" +
                "<br><br><font color='#48AE4A'>뇌우에 보너스 적용:</font>" +
                "<br><font color='#A95750'>전자기장: 레벨당 번개 피해 +7%";
    }

    public static String lightningSkill9_end(String lv, String c1, String c2, String c3, String c4, String c5, String c6, String c7, String c8, String c9) {
        return "<font color='#48AE4A'>마력 보호막</font>" +
                "<br><font color='#A95750'>마법 보호막을 생성하여 피해를 받을 때" +
                "<br>생명력 대신 마나를 소모합니다." +
                "<br>최대 레벨 도달" +
                "<br><br>피해당 마나 소모: 194%" +
                "<br>마나 소모: 5" +
                "<br><br>현재 기술 레벨: " + lv +
                "<br>흡수 "+c1+"%" +
                "<br>지속시간: "+c2+"초</font>" +
                "<br><br><font color='#48AE4A'>마력 보호막에 보너스 적용:</font>" +
                "<br><font color='#A95750'>염력: 레벨당 마나 소모 -6%";
    }

    public static String lightningSkill10_end(String lv, String c1, String c2, String c3, String c4, String c5, String c6, String c7, String c8, String c9) {
        return "<font color='#48AE4A'>번개 숙련</font>" +
                "<br><font color='#A95750'>지속 효과 - 번개 주문◎로 주는 모든 피해가 증가합니다." +
                "<br>최대 레벨 도달" +
                "<br><br>현재 기술 레벨: " + lv +
                "<br>번개 피해: +"+c1+"%";
    }


}
