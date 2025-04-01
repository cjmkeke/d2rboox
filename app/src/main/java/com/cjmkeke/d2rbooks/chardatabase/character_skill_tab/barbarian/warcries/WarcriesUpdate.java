package com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.barbarian.warcries;

public class WarcriesUpdate {

    public static String warcriesSkill1(String lv, String c1, String c2, String c3, String n1, String n2, String n3) {
        return
                "<font color='#48AE4A'>표호</font>" +
                        "<br>주위의 괴물들이<br>공포에 질려 도망치게 합니다." +
                        "<br><br>마나 소모: 4" +

                        "<br><br>현재 기술 레벨: " + lv +
                        "<br>반경: " + c1 + "미터" +
                        "<br>괴물 도망 거리 최대 " + c2 + "미터" +
                        "<br>지속시간: " + c3 + "초" +

                        "<br><br>다음 레벨" +
                        "<br>반경: " + n1 + "미터" +
                        "<br>괴물 도망 거리 최대 " + n2 + "미터" +
                        "<br>지속시간: " + n3 + "초";
    }

    public static String warcriesSkill2(String lv, String c1, String n1) {
        return
                "<font color='#48AE4A'>물약 발견</font>" +
                        "<br>처치한 괴물의 시체에 사용하여<br>일정 확률로 물약을 발견합니다." +
                        "<br><br>마나 소모: 2" +

                        "<br><br>현재 기술 레벨: " + lv +
                        "<br>"+c1+"% 확률" +

                        "<br><br>다음 레벨" +
                        "<br>"+n1+"% 확률";
    }

    public static String warcriesSkill3(String lv, String c1, String c2, String n1, String n2) {
        return
                "<font color='#48AE4A'>주위의 고물을 격분시켜 맹렬히 공격하게 합니다.</font>" +
                        "<br><br>마나 소모: 3" +

                        "<br><br>현재 기술 레벨: " + lv +
                        "<br>대상의 명중률: -"+c1+"%" +
                        "<br>적 공격력: -"+c2+"%" +

                        "<br><br>다음 레벨" +
                        "<br>대상의 명중률: -"+n1+"%" +
                        "<br>적 공격력: -"+n2+"%";
    }

    public static String warcriesSkill4(String lv, String c2, String c3, String n2, String n3) {
        return
                "<font color='#48AE4A'>외침</font>" +
                        "<br>임박한 위험을 경고하여<br>자신과 파티원의 방어력을 증가시킵니다." +
                        "<br><br>마나소모: 6" +

                        "<br><br>현재 기술 레벨: " + lv +
                        "<br>반경: 12.6미터" +
                        "<br>방어력: +"+c2+"%" +
                        "<br>지속시간: "+c3+"초" +

                        "<br><br>다음 레벨" +
                        "<br>반경: 12.6미터" +
                        "<br>방어력: +"+n2+"%" +
                        "<br>지속시간: "+n3+"초" +

                        "<br><br><font color='#48AE4A'>외침에 보너스 적용:</font>" +
                        "<br>전투 지시: 레벨당 +5초" +
                        "<br>전투 명령: 레벨당 +5초";
    }

    public static String warcriesSkill5(String lv, String c1, String n2) {
        return
                "<font color='#48AE4A'>아이템 발견</font>" +
                        "<br>처치한 괴물의 시체에 사용하여<br>일정 확률로 숨겨진 보물을 발견합니다." +
                        "<br><br>마나 소모: 7" +

                        "<br><br>현재 기술 레벨: " + lv +
                        "<br>"+c1+"% 확률" +

                        "<br><br>다음 레벨" +
                        "<br>"+n2+"% 확률" +

                        "<br><br><font color='#48AE4A'>아이템 발견에 보너스 적용:</font>" +
                        "<br>물약 발견: 레벨당 확률 +1%";
    }

    public static String warcriesSkill6(String lv, String c2, String c3, String c4, String n2, String n3, String n4) {
        return
                "<font color='#48AE4A'>전투의 합성</font>" +
                        "<br>공포의 외침으로 적의 방어력과 공격력을<br>감소시킵니다." +
                        "<br><br>마나 소모: 5" +

                        "<br><br>현재 기술 레벨: " + lv +
                        "<br>반경: 3.3미터" +
                        "<br>적 공격력: -"+c2+"%" +
                        "<br>적 방어력: -"+c3+"%" +
                        "<br>지속시간: "+c4+"초" +

                        "<br><br>다음 레벨" +
                        "<br>반경: 3.3미터" +
                        "<br>적 공격력: -"+n2+"%" +
                        "<br>적 방어력: -"+n3+"%" +
                        "<br>지속시간: "+n4+"초";
    }

    public static String warcriesSkill7(String lv, String c1, String c2, String c3, String c4, String n1, String n2, String n3, String n4) {
        return
                "<font color='#48AE4A'>전투 지시</font>" +
                        "<br>자신과 파티원의 최대 마나, 생명력,<br>지구력이 증가합니다." +
                        "<br><br>마나 소모: 7" +

                        "<br><br>현재 기술 레벨: " + lv +
                        "<br>반경: 12.6미터" +
                        "<br>최대 생명력: +"+c1+"%" +
                        "<br>최대 마나: +"+c2+"%" +
                        "<br>최대 지구력: +"+c3+"%" +
                        "<br>지속시간: "+c4+"초" +

                        "<br><br>다음 레벨" +
                        "<br>반경: 12.6미터" +
                        "<br>최대 생명력: +"+n1+"%" +
                        "<br>최대 마나: +"+n2+"%" +
                        "<br>최대 지구력: +"+n3+"%" +
                        "<br>지속시간: "+n4+"초" ;
    }

    public static String warcriesSkill8(String lv, String c1, String c2, String n1, String n2) {
        return
                "<font color='#48AE4A'>섬뜩한 호신부</font>" +
                        "<br>처치한 괴물의 시체에 사용하여<br>주위 괴물이 도망치게 하는<br>섬뜩한 토템을 생성합니다." +
                        "<br><br>적이 받는 피해: +20%" +
                        "<br>지속시간: 40초" +
                        "<br>마나 소모: 4" +

                        "<br><br>현재 기술 레벨: " + lv +
                        "<br>반경: "+c1+"미터" +
                        "<br>적 감속: "+c2+"%" +

                        "<br><br>다음 레벨" +
                        "<br>반경: "+n1+"미터" +
                        "<br>적 감속: "+n2+"%" +

                        "<br><br><font color='#48AE4A'>섬뜩한 호신부에 보너스 적용:</font>" +
                        "<br>물약 발견: 레벨당 받는 피해 +5%";
    }

    public static String warcriesSkill9(String lv, String c2, String c3, String c4, String n2, String n3, String n4) {
        return
                "<font color='#48AE4A'>전장의 합성</font>" +
                        "<br>주위의 모든 괴물에게 피해를 주고 기절시킵니다." +

                        "<br><br>현재 기술 레벨: " + lv +
                        "<br>반경: 4.6미터" +
                        "<br>공격력: "+c2+"" +
                        "<br>기절 지속시간: "+c3+"초" +
                        "<br>마나 소모: "+c4+"" +

                        "<br><br>다음 레벨" +
                        "<br>반경: 4.6미터" +
                        "<br>공격력: "+n2+"" +
                        "<br>기절 지속시간: "+n3+"초" +
                        "<br>마나 소모: "+n4+"" +

                        "<br><br><font color='#48AE4A'>전장의 합성에 보너스 적용:</font>" +
                        "<br>포효: 레벨당 피해 +6%" +
                        "<br>도발: 레벨당 피해 +6%" +
                        "<br>전투의 합성: 레벨당 피해 +6%";
    }

    public static String warcriesSkill10(String lv, String c1, String n1) {
        return
                "<font color='#48AE4A'>전투 명령</font>" +
                        "<br>자신과 파티원의 현재 기술 레벨이 모두 증가합니다." +
                        "<br><br>마나 소모: 11" +

                        "<br><br>현재 기술 레벨: " + lv +
                        "<br>반경: 12.6미터" +
                        "<br>지속시간: "+c1+"초" +

                        "<br><br>다음 레벨" +
                        "<br>반경: 12.6미터" +
                        "<br>지속시간: "+n1+"초" +

                        "<br><br><font color='#48AE4A'>전투 명령에 보너스 적용:</font>" +
                        "<br>외침: 레벨당 +5초" +
                        "<br>전투 지시: 레벨당 +5초";

    }


    /*********************************************************************************************************************************************************************************************************/
    /*********************************************************************************************************************************************************************************************************/
    /*********************************************************************************************************************************************************************************************************/

    public static String warcriesSkill1_end (String lv, String c1, String c2, String c3, String c4, String c5, String c6, String c7, String c8, String c9) {
        return
                "<font color='#48AE4A'>표호</font>" +
                        "<br>주위의 괴물들이<br>공포에 질려 도망치게 합니다." +
                        "<br>최고 레벨 도달" +
                        "<br><br>마나 소모: 4" +

                        "<br><br>현재 기술 레벨: " + lv +
                        "<br>반경: " + c1 + "미터" +
                        "<br>괴물 도망 거리 최대 " + c2 + "미터" +
                        "<br>지속시간: " + c3 + "초";
    }

    public static String warcriesSkill2_end (String lv, String c1, String c2, String c3, String c4, String c5, String c6, String c7, String c8, String c9) {
        return
                "<font color='#48AE4A'>물약 발견</font>" +
                        "<br>처치한 괴물의 시체에 사용하여<br>일정 확률로 물약을 발견합니다." +
                        "<br>최고 레벨 도달" +
                        "<br><br>마나 소모: 2" +

                        "<br><br>현재 기술 레벨: " + lv +
                        "<br>"+c1+"% 확률";
    }

    public static String warcriesSkill3_end (String lv, String c1, String c2, String c3, String c4, String c5, String c6, String c7, String c8, String c9) {
        return
                "<font color='#48AE4A'>주위의 고물을 격분시켜 맹렬히 공격하게 합니다.</font>" +
                        "<br>최고 레벨 도달" +
                        "<br><br>마나 소모: 3" +

                        "<br><br>현재 기술 레벨: " + lv +
                        "<br>대상의 명중률: -"+c1+"%" +
                        "<br>적 공격력: -"+c2+"%";
    }

    public static String warcriesSkill4_end (String lv, String c2, String c3, String c4, String c5, String c6, String c7, String c8, String c9) {
        return
                "<font color='#48AE4A'>외침</font>" +
                        "<br>임박한 위험을 경고하여<br>자신과 파티원의 방어력을 증가시킵니다." +
                        "<br>최고 레벨 도달" +
                        "<br><br>마나소모: 6" +

                        "<br><br>현재 기술 레벨: " + lv +
                        "<br>반경: 12.6미터" +
                        "<br>방어력: +"+c2+"%" +
                        "<br>지속시간: "+c3+"초" +

                        "<br><br><font color='#48AE4A'>외침에 보너스 적용:</font>" +
                        "<br>전투 지시: 레벨당 +5초" +
                        "<br>전투 명령: 레벨당 +5초";
    }

    public static String warcriesSkill5_end (String lv, String c1, String c2, String c3, String c4, String c5, String c6, String c7, String c8, String c9) {
        return
                "<font color='#48AE4A'>아이템 발견</font>" +
                        "<br>처치한 괴물의 시체에 사용하여<br>일정 확률로 숨겨진 보물을 발견합니다." +
                        "<br>최고 레벨 도달" +
                        "<br><br>마나 소모: 7" +

                        "<br><br>현재 기술 레벨: " + lv +
                        "<br>"+c1+"% 확률" +

                        "<br><br><font color='#48AE4A'>아이템 발견에 보너스 적용:</font>" +
                        "<br>물약 발견: 레벨당 확률 +1%";
    }

    public static String warcriesSkill6_end (String lv, String c1, String c2, String c3, String c4, String c5, String c6, String c7, String c8, String c9) {
        return
                "<font color='#48AE4A'>전투의 합성</font>" +
                        "<br>공포의 외침으로 적의 방어력과 공격력을<br>감소시킵니다." +
                        "<br>최고 레벨 도달" +
                        "<br><br>마나 소모: 5" +

                        "<br><br>현재 기술 레벨: " + lv +
                        "<br>반경: 3.3미터" +
                        "<br>적 공격력: -"+c1+"%" +
                        "<br>적 방어력: -"+c2+"%" +
                        "<br>지속시간: "+c3+"초";
    }

    public static String warcriesSkill7_end (String lv, String c1, String c2, String c3, String c4, String c5, String c6, String c7, String c8, String c9) {
        return
                "<font color='#48AE4A'>전투 지시</font>" +
                        "<br>자신과 파티원의 최대 마나, 생명력,<br>지구력이 증가합니다." +
                        "<br>최고 레벨 도달" +
                        "<br><br>마나 소모: 7" +

                        "<br><br>현재 기술 레벨: " + lv +
                        "<br>반경: 12.6미터" +
                        "<br>최대 생명력: +"+c1+"%" +
                        "<br>최대 마나: +"+c2+"%" +
                        "<br>최대 지구력: +"+c3+"%" +
                        "<br>지속시간: "+c4+"초" ;
    }

    public static String warcriesSkill8_end (String lv, String c1, String c2, String c3, String c4, String c5, String c6, String c7, String c8, String c9) {
        return
                "<font color='#48AE4A'>섬뜩한 호신부</font>" +
                        "<br>처치한 괴물의 시체에 사용하여<br>주위 괴물이 도망치게 하는<br>섬뜩한 토템을 생성합니다." +
                        "<br>최고 레벨 도달" +
                        "<br><br>적이 받는 피해: +20%" +
                        "<br>지속시간: 40초" +
                        "<br>마나 소모: 4" +

                        "<br><br>현재 기술 레벨: " + lv +
                        "<br>반경: "+c1+"미터" +
                        "<br>적 감속: "+c2+"%" +

                        "<br><br><font color='#48AE4A'>섬뜩한 호신부에 보너스 적용:</font>" +
                        "<br>물약 발견: 레벨당 받는 피해 +5%";
    }

    public static String warcriesSkill9_end (String lv, String c1, String c2, String c3, String c4, String c5, String c6, String c7, String c8, String c9) {
        return
                "<font color='#48AE4A'>전장의 합성</font>" +
                        "<br>주위의 모든 괴물에게 피해를 주고 기절시킵니다." +
                        "<br>최고 레벨 도달" +
                        "<br><br>현재 기술 레벨: " + lv +
                        "<br>반경: 4.6미터" +
                        "<br>공격력: "+c1+"" +
                        "<br>기절 지속시간: "+c2+"초" +
                        "<br>마나 소모: "+c3+"" +

                        "<br><br><font color='#48AE4A'>전장의 합성에 보너스 적용:</font>" +
                        "<br>포효: 레벨당 피해 +6%" +
                        "<br>도발: 레벨당 피해 +6%" +
                        "<br>전투의 합성: 레벨당 피해 +6%";
    }

    public static String warcriesSkill10_end (String lv, String c1, String c2, String c3, String c4, String c5, String c6, String c7, String c8, String c9) {
        return
                "<font color='#48AE4A'>전투 명령</font>" +
                        "<br>자신과 파티원의 현재 기술 레벨이 모두 증가합니다." +
                        "<br>최고 레벨 도달" +
                        "<br><br>마나 소모: 11" +

                        "<br><br>현재 기술 레벨: " + lv +
                        "<br>반경: 12.6미터" +
                        "<br>지속시간: "+c1+"초" +

                        "<br><br><font color='#48AE4A'>전투 명령에 보너스 적용:</font>" +
                        "<br>외침: 레벨당 +5초" +
                        "<br>전투 지시: 레벨당 +5초";

    }


}
