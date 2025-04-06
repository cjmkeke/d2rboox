package com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.druid.elemental;

public class ElementalUpdate {

    public static String elementalSkill1(String lv, String c1, String n1) {
        return
                "<font color='#48AE4A'>화염폭풍</font>" +
                        "<br>혼돈의 화염을 방출하여 적을 부태웁니다." +
                        "<br><br>시전 지연 시간: 0.6초" +
                        "<br>마나 소모: 4" +
                        "<br><br>현재 기술 레벨: "+lv+
                        "<br>평균 화염 피해: 초당 "+c1+"" +
                        "<br><br>다음 레벨"+
                        "<br>평균 화염 피해: 초당 "+n1+"" +
                        "<br><br><font color='#48AE4A'>화염폭풍에 보너스 적용:</font>" +
                        "<br>타오르는 바위: 레벨당 화염 피해 +23%" +
                        "<br>균열: 레벨당 화염 피해 +23%";
    }


    public static String elementalSkill2(String lv, String c1, String c2, String c3, String c4, String n1, String n2, String n3, String n4) {
        return
                "<font color='#48AE4A'>타오르는 바위</font>" +
                        "<br>타오르는 용암 바위를 날려<br>적을 뒤로 밀쳐냅니다." +
                        "<br><br>시전 지연 시간: 1초" +
                        "<br><br>현재 기술 레벨: "+lv+
                        "<br>공격력: "+c1+"" +
                        "<br>화염 피해: "+c2+"" +
                        "<br>평균 화염 피해: 초당 "+c3+"" +
                        "<br>마나 소모: "+c4+"" +
                        "<br><br>다음 레벨"+
                        "<br>공격력: "+n1+"" +
                        "<br>화염 피해: "+n2+"" +
                        "<br>평균 화염 피해: 초당 "+n3+"" +
                        "<br>마나 소모: "+n4+"" +
                        "<br><br><font color='#48AE4A'>타오르는 바위에 보너스 적용:</font>" +
                        "<br>화산: 레벨당 피해 +12%" +
                        "<br>화염폭풍: 레벨당 화염 피해 +8%";
    }

    public static String elementalSkill3(String lv, String c1, String c2, String c3, String c4, String n1, String n2, String n3, String n4) {
        return
                "<font color='#48AE4A'>극지 돌풍</font>" +
                        "<br>연속으로 얼음 줄기를 방출하여<br>서리로 적을 태웁니다." +
                        "<br><br>시전에 필요한 최소 마나: 4" +
                        "<br><br>현재 기술 레벨: "+lv+
                        "<br>평균 냉기 피해: 초당 "+c1+"" +
                        "<br>냉기 지속시간: "+c2+"초" +
                        "<br>범위: "+c3+"미터" +
                        "<br>마나 소모: 초당 "+c4+"" +
                        "<br><br>다음 레벨"+
                        "<br>평균 냉기 피해: 초당 "+n1+"" +
                        "<br>냉기 지속시간: "+n2+"초" +
                        "<br>범위: "+n3+"미터" +
                        "<br>마나 소모: 초당 "+n4+"" +
                        "<br><br><font color='#48AE4A'>극지 돌풍에 보너스 적용:</font>" +
                        "<br>회오리 갑옷: 레벨당 냉기 피해 +15%";
    }

    public static String elementalSkill4(String lv, String c1, String n1) {
        return
                "<font color='#48AE4A'>균열</font>" +
                        "<br>적의 발밑에 화도를 열어<br>대상을 까맣게 불태웁니다." +
                        "<br><br>지속시간: 1.6초" +
                        "<br>시전 지연 시간: 2초" +
                        "<br>마나 소모: 15" +
                        "<br><br>현재 기술 레벨: "+lv+
                        "<br>화염 피해: "+c1+"" +
                        "<br><br>다음 레벨"+
                        "<br>화염 피해: "+n1+"" +
                        "<br><br><font color='#48AE4A'>균열에 보너스 적용:</font>" +
                        "<br>화염폭풍: 레벨당 화염 피해 +12%"+
                        "<br>화산: 레벨당 화염 피해 +12%";

    }


    public static String elementalSkill5(String lv, String c1, String c2, String n1, String n2) {
        return
                "<font color='#48AE4A'>회오리 갑옷</font>" +
                        "<br>화염, 냉기, 번개 피해로부터<br>자신을 보호합니다." +
                        "<br><br>현재 기술 레벨: "+lv+
                        "<br>"+c1+"의 피해 흡수" +
                        "<br>마나 소모: "+c2+"" +
                        "<br><br>다음 레벨"+
                        "<br>"+n1+"의 피해 흡수" +
                        "<br>마나 소모: "+n2+"" +
                        "<br><br><font color='#48AE4A'>회오리 갑옷에 보너스 적용:</font>" +
                        "<br>돌개바람: 레벨당 피해 +7%"+
                        "<br>회오리바람: 레벨당 피해 +7%"+
                        "<br>허리케인: 레벨당 피해 +7%";
    }

    public static String elementalSkill6(String lv, String c1, String n1) {
        return
                "<font color='#48AE4A'>돌개바람</font>" +
                        "<br>적들을 뚫고 지나가는<br>작은 회오리바람을 여럿 내보냅니다." +
                        "<br><br>기절 지속시간: 0.4초" +
                        "<br>마나 소모: 7" +
                        "<br><br>현재 기술 레벨: "+lv+
                        "<br>공격력: "+c1+"" +
                        "<br><br>다음 레벨"+
                        "<br>공격력: "+n1+"" +
                        "<br><br><font color='#48AE4A'>돌개바람에 보너스 적용:</font>" +
                        "<br>극지 돌풍: 레벨당 지속시간 +20%%"+
                        "<br>회오리바람: 레벨당 피해 +10%"+
                        "<br>허리케인: 레벨당 피해 +10%";
    }

    public static String elementalSkill7(String lv, String c1, String c2, String n1, String n2) {
        return
                "<font color='#48AE4A'>화산</font>" +
                        "<br>화산을 소환하여 적에게<br>죽음과 파괴의 비를 퍼붓습니다." +
                        "<br><br>지속시간: 6초" +
                        "<br>시전 지연 시간: 4초" +
                        "<br>마나 소모: 25" +
                        "<br><br>현재 기술 레벨: "+lv+
                        "<br>공격력: "+c1+"" +
                        "<br>화염 피해: "+c2+"" +
                        "<br><br>다음 레벨"+
                        "<br>공격력: "+n1+"" +
                        "<br>화염 피해: "+n2+"" +
                        "<br><br><font color='#48AE4A'>화산에 보너스 적용:</font>" +
                        "<br>타오르는 바위: 레벨당 피해 +16%" +
                        "<br>균열: 레벨당 화염 피해 +12%" +
                        "<br>아마겟돈: 레벨당 화염 피해 +12%";
    }

    public static String elementalSkill8(String lv, String c1, String n1) {
        return
                "<font color='#48AE4A'>회오리바람</font>" +
                        "<br>바람과 잔해의 회오리 바람으로<br>적을 강타합니다." +
                        "<br><br>마나 소모: 10" +
                        "<br><br>현재 기술 레벨: "+lv+
                        "<br>공격력: "+c1+"" +
                        "<br><br>다음 레벨"+
                        "<br>공격력: "+n1+"" +
                        "<br><br><font color='#48AE4A'>회오리바람에 보너스 적용:</font>" +
                        "<br>회오리 갑옷: 레벨당 피해 +9%" +
                        "<br>돌개바람: 레벨당 피해 +9%" +
                        "<br>허리케인: 레벨당 피해 +9%";
    }

    public static String elementalSkill9(String lv, String c1, String c2, String c3, String n1, String n2, String n3) {
        return
                "<font color='#48AE4A'>아마겟돈</font>" +
                        "<br>유성우를 생성하여 주위의 적에게<br>불타는 파괴의 비를 퍼붓습니다." +
                        "<br><br>지속시간: 10초" +
                        "<br>반경: 5.3미터" +
                        "<br>마나 소모: 35" +
                        "<br><br>현재 기술 레벨: "+lv+
                        "<br>공격력: "+c1+"" +
                        "<br>화염 피해: "+c2+"" +
                        "<br>평균 화염 피해: 초당 "+c3+"" +
                        "<br><br>다음 레벨"+
                        "<br>공격력: "+n1+"" +
                        "<br>화염 피해: "+n2+"" +
                        "<br>평균 화염 피해: 초당 "+n3+"" +
                        "<br><br><font color='#48AE4A'>아마겟돈에 보너스 적용:</font>" +
                        "<br>균열: 레벨당 +2초" +
                        "<br>화염폭풍: 레벨당 화염 피해 +14%" +
                        "<br>타오르는 바위: 레벨당 화염 피해 +14%" +
                        "<br>화산: 레벨당 피해 +18%";
    }

    public static String elementalSkill10(String lv, String c1,String n1) {
        return
                "<font color='#48AE4A'>허리케인</font>" +
                        "<br>거대한 바람과 잔해의 폭풍을 생성하여<br>적을 산산이 조각냅니다." +
                        "<br><br>지속시간: 10초" +
                        "<br>반경: 6미터" +
                        "<br>마나 소모: 30" +
                        "<br><br>현재 기술 레벨: "+lv+
                        "<br>냉기 피해: "+c1+"" +
                        "<br><br>다음 레벨"+
                        "<br>냉기 피해: "+n1+"" +
                        "<br><br><font color='#48AE4A'>허리케인에 보너스 적용:</font>" +
                        "<br>회오리 갑옷: 레벨당 피해 +2초" +
                        "<br>돌개바람: 레벨당 피해 +9%" +
                        "<br>회오리바람: 레벨당 피해 +9%";
    }

    /*********************************************************************************************************************************************************************************************************/
    /*********************************************************************************************************************************************************************************************************/
    /*********************************************************************************************************************************************************************************************************/

    public static String elementalSkill1_end(String lv, String c1, String c2, String c3, String c4, String c5, String c6, String c7, String c8, String c9) {
        return
                "<font color='#48AE4A'>화염폭풍</font>" +
                        "<br><font color='#A95750'>혼돈의 화염을 방출하여 적을 부태웁니다." +
                        "<br>최대 레벨 도달" +
                        "<br><br>시전 지연 시간: 0.6초" +
                        "<br>마나 소모: 4" +
                        "<br><br>현재 기술 레벨: "+lv+
                        "<br>평균 화염 피해: 초당 "+c1+"분노</font>" +
                        "<br><br><font color='#48AE4A'>화염폭풍에 보너스 적용:</font>" +
                        "<br><font color='#A95750'>타오르는 바위: 레벨당 화염 피해 +23%" +
                        "<br>균열: 레벨당 화염 피해 +23%";
    }


    public static String elementalSkill2_end(String lv, String c1, String c2, String c3, String c4, String c5, String c6, String c7, String c8, String c9) {
        return
                "<font color='#48AE4A'>타오르는 바위</font>" +
                        "<br><font color='#A95750'>타오르는 용암 바위를 날려<br>적을 뒤로 밀쳐냅니다." +
                        "<br>최대 레벨 도달" +
                        "<br><br>시전 지연 시간: 1초" +
                        "<br><br>현재 기술 레벨: "+lv+
                        "<br>공격력: "+c1+"" +
                        "<br>화염 피해: "+c2+"" +
                        "<br>평균 화염 피해: 초당 "+c3+"" +
                        "<br>마나 소모: "+c4+"분노</font>" +
                        "<br><br><font color='#48AE4A'>타오르는 바위에 보너스 적용:</font>" +
                        "<br><font color='#A95750'>화산: 레벨당 피해 +12%" +
                        "<br>화염폭풍: 레벨당 화염 피해 +8%";
    }

    public static String elementalSkill3_end(String lv, String c1, String c2, String c3, String c4, String c5, String c6, String c7, String c8, String c9) {
        return
                "<font color='#48AE4A'>극지 돌풍</font>" +
                        "<br><font color='#A95750'>연속으로 얼음 줄기를 방출하여<br>서리로 적을 태웁니다." +
                        "<br>최대 레벨 도달" +
                        "<br><br>시전에 필요한 최소 마나: 4" +
                        "<br><br>현재 기술 레벨: "+lv+
                        "<br>평균 냉기 피해: 초당 "+c1+"" +
                        "<br>냉기 지속시간: "+c2+"초" +
                        "<br>범위: "+c3+"미터" +
                        "<br>마나 소모: 초당 "+c4+"분노</font>" +
                        "<br><br><font color='#48AE4A'>극지 돌풍에 보너스 적용:</font>" +
                        "<br><font color='#A95750'>회오리 갑옷: 레벨당 냉기 피해 +15%";
    }

    public static String elementalSkill4_end(String lv, String c1, String c2, String c3, String c4, String c5, String c6, String c7, String c8, String c9) {
        return
                "<font color='#48AE4A'>균열</font>" +
                        "<br><font color='#A95750'>적의 발밑에 화도를 열어<br>대상을 까맣게 불태웁니다." +
                        "<br>최대 레벨 도달" +
                        "<br><br>지속시간: 1.6초" +
                        "<br>시전 지연 시간: 2초" +
                        "<br>마나 소모: 15" +
                        "<br><br>현재 기술 레벨: "+lv+
                        "<br>화염 피해: "+c1+"분노</font>" +
                        "<br><br><font color='#48AE4A'>균열에 보너스 적용:</font>" +
                        "<br><font color='#A95750'>화염폭풍: 레벨당 화염 피해 +12%"+
                        "<br>화산: 레벨당 화염 피해 +12%";

    }


    public static String elementalSkill5_end(String lv, String c1, String c2, String c3, String c4, String c5, String c6, String c7, String c8, String c9) {
        return
                "<font color='#48AE4A'>회오리 갑옷</font>" +
                        "<br><font color='#A95750'>화염, 냉기, 번개 피해로부터<br>자신을 보호합니다." +
                        "<br>최대 레벨 도달" +
                        "<br><br>현재 기술 레벨: "+lv+
                        "<br>"+c1+"의 피해 흡수" +
                        "<br>마나 소모: "+c2+"분노</font>" +
                        "<br><br><font color='#48AE4A'>회오리 갑옷에 보너스 적용:</font>" +
                        "<br><font color='#A95750'>돌개바람: 레벨당 피해 +7%"+
                        "<br>회오리바람: 레벨당 피해 +7%"+
                        "<br>허리케인: 레벨당 피해 +7%";
    }

    public static String elementalSkill6_end(String lv, String c1, String c2, String c3, String c4, String c5, String c6, String c7, String c8, String c9) {
        return
                "<font color='#48AE4A'>돌개바람</font>" +
                        "<br><font color='#A95750'>적들을 뚫고 지나가는<br>작은 회오리바람을 여럿 내보냅니다." +
                        "<br>최대 레벨 도달" +
                        "<br><br>기절 지속시간: 0.4초" +
                        "<br>마나 소모: 7" +
                        "<br><br>현재 기술 레벨: "+lv+
                        "<br>공격력: "+c1+"분노</font>" +
                        "<br><br><font color='#48AE4A'>돌개바람에 보너스 적용:</font>" +
                        "<br><font color='#A95750'>극지 돌풍: 레벨당 지속시간 +20%%"+
                        "<br>회오리바람: 레벨당 피해 +10%"+
                        "<br>허리케인: 레벨당 피해 +10%";
    }

    public static String elementalSkill7_end(String lv, String c1, String c2, String c3, String c4, String c5, String c6, String c7, String c8, String c9) {
        return
                "<font color='#48AE4A'>화산</font>" +
                        "<br><font color='#A95750'>화산을 소환하여 적에게<br>죽음과 파괴의 비를 퍼붓습니다." +
                        "<br>최대 레벨 도달" +
                        "<br><br>지속시간: 6초" +
                        "<br>시전 지연 시간: 4초" +
                        "<br>마나 소모: 25" +
                        "<br><br>현재 기술 레벨: "+lv+
                        "<br>공격력: "+c1+"" +
                        "<br>화염 피해: "+c2+"분노</font>" +
                        "<br><br><font color='#48AE4A'>화산에 보너스 적용:</font>" +
                        "<br><font color='#A95750'>타오르는 바위: 레벨당 피해 +16%" +
                        "<br>균열: 레벨당 화염 피해 +12%" +
                        "<br>아마겟돈: 레벨당 화염 피해 +12%";
    }

    public static String elementalSkill8_end(String lv, String c1, String c2, String c3, String c4, String c5, String c6, String c7, String c8, String c9) {
        return
                "<font color='#48AE4A'>회오리바람</font>" +
                        "<br><font color='#A95750'>바람과 잔해의 회오리 바람으로<br>적을 강타합니다." +
                        "<br>최대 레벨 도달" +
                        "<br><br>마나 소모: 10" +
                        "<br><br>현재 기술 레벨: "+lv+
                        "<br>공격력: "+c1+"분노</font>" +
                        "<br><br><font color='#48AE4A'>회오리바람에 보너스 적용:</font>" +
                        "<br><font color='#A95750'>회오리 갑옷: 레벨당 피해 +9%" +
                        "<br>돌개바람: 레벨당 피해 +9%" +
                        "<br>허리케인: 레벨당 피해 +9%";
    }

    public static String elementalSkill9_end(String lv, String c1, String c2, String c3, String c4, String c5, String c6, String c7, String c8, String c9) {
        return
                "<font color='#48AE4A'>아마겟돈</font>" +
                        "<br><font color='#A95750'>유성우를 생성하여 주위의 적에게<br>불타는 파괴의 비를 퍼붓습니다." +
                        "<br>최대 레벨 도달" +
                        "<br><br>지속시간: 10초" +
                        "<br>반경: 5.3미터" +
                        "<br>마나 소모: 35" +
                        "<br><br>현재 기술 레벨: "+lv+
                        "<br>공격력: "+c1+"" +
                        "<br>화염 피해: "+c2+"" +
                        "<br>평균 화염 피해: 초당 "+c3+"분노</font>" +
                        "<br><br><font color='#48AE4A'>아마겟돈에 보너스 적용:</font>" +
                        "<br><font color='#A95750'>균열: 레벨당 +2초" +
                        "<br>화염폭풍: 레벨당 화염 피해 +14%" +
                        "<br>타오르는 바위: 레벨당 화염 피해 +14%" +
                        "<br>화산: 레벨당 피해 +18%";
    }

    public static String elementalSkill10_end(String lv, String c1, String c2, String c3, String c4, String c5, String c6, String c7, String c8, String c9) {
        return
                "<font color='#48AE4A'>허리케인</font>" +
                        "<br><font color='#A95750'>거대한 바람과 잔해의 폭풍을 생성하여<br>적을 산산이 조각냅니다." +
                        "<br>최대 레벨 도달" +
                        "<br><br>지속시간: 10초" +
                        "<br>반경: 6미터" +
                        "<br>마나 소모: 30" +
                        "<br><br>현재 기술 레벨: "+lv+
                        "<br>냉기 피해: "+c1+"분노</font>" +
                        "<br><br><font color='#48AE4A'>허리케인에 보너스 적용:</font>" +
                        "<br><font color='#A95750'>회오리 갑옷: 레벨당 피해 +2초" +
                        "<br>돌개바람: 레벨당 피해 +9%" +
                        "<br>회오리바람: 레벨당 피해 +9%";
    }


}
