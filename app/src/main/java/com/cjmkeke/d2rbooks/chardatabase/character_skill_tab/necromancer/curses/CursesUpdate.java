package com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.necromancer.curses;

public class CursesUpdate {

    public static String cursesSkill1(String lv, String c1, String c2, String n1, String n2) {
        return
                "<font color='#48AE4A'>피해 증폭</font>" +
                        "<br>적 무리에 저주를 걸어 대상이<br>받는 비마법 피해를 증가시킵니다." +
                        "<br><br>받는 피해: +100%" +
                        "<br>마나 소모: 4" +
                        "<br><br>현재 기술 레벨: "+lv +
                        "<br>반경: "+c1+"미터" +
                        "<br>지속시간: "+c2+"초"+
                        "<br><br>다음 레벨" +
                        "<br>반경: "+n1+"미터" +
                        "<br>지속시간: "+n2+"초";

    }

    public static String cursesSkill2(String lv, String c1, String c2, String n1, String n2) {
        return
                "<font color='#48AE4A'>시야 흐리기</font>" +
                        "<br>괴물 무리에 저주를 걸어<br>대상의 시야 범위를 감소시킵니다." +
                        "<br><br>마나 소모: 9" +
                        "<br><br>현재 기술 레벨: "+lv +
                        "<br>반경: "+c1+"미터" +
                        "<br>지속시간: "+c2+"초"+
                        "<br><br>다음 레벨" +
                        "<br>반경: "+n1+"미터" +
                        "<br>지속시간: "+n2+"초";
    }


    public static String cursesSkill3(String lv, String c1, String c2, String c3, String n1, String n2, String n3) {
        return
                "<font color='#48AE4A'>약화</font>" +
                        "<br>괴물 무리에 저주를 걸어<br>대상이 주는 피해량을 감소시킵니다." +
                        "<br><br>마나 소모: 4" +
                        "<br><br>현재 기술 레벨: "+lv +
                        "<br>적 공격력: -"+c1+"%" +
                        "<br>반경: "+c2+"미터" +
                        "<br>지속시간: "+c3+"초"+
                        "<br><br>다음 레벨" +
                        "<br>적 공격력: -"+n1+"%" +
                        "<br>반경: "+n2+"미터" +
                        "<br>지속시간: "+n3+"초";
    }

    public static String cursesSkill4(String lv, String c1, String c2, String n1, String n2) {
        return
                "<font color='#48AE4A'>가시 박힌 철관</font>" +
                        "<br>괴물 무리에 저주를 걸어<br>대상이 근접 공격으로 피해를 줄 때<br>자신도 피해를 입게 합니다." +
                        "<br><br>반경: 4.6미터" +
                        "<br>마나 소모: 5" +
                        "<br><br>현재 기술 레벨: "+lv +
                        "<br>"+c1+"%의 피해를 반사" +
                        "<br>지속시간: "+c2+"초"+
                        "<br><br>다음 레벨" +
                        "<br>"+n1+"%의 피해를 반사" +
                        "<br>지속시간: "+n2+"초";
    }


    public static String cursesSkill5(String lv, String c1,String n1) {
        return
                "<font color='#48AE4A'>공포</font>" +
                        "<br>괴물 무리에 저주를 걸어<br>공포에 질려 달아나게 합니다." +
                        "<br><br>반경: 2.6미터" +
                        "<br>마나 소모: 7" +
                        "<br><br>현재 기술 레벨: "+lv +
                        "<br>지속시간: "+c1+"초"+
                        "<br><br>다음 레벨" +
                        "<br>지속시간: "+n1+"초";
    }

    public static String cursesSkill6(String lv, String c1, String c2, String n1, String n2) {
        return
                "<font color='#48AE4A'>혼란</font>" +
                        "<br>괴물 무리에 저주를 걸어 무작위 대상을 공격하게 합니다." +
                        "<br><br>마나 소모: 13" +
                        "<br><br>현재 기술 레벨: "+lv +
                        "<br>반경: "+c1+"미터" +
                        "<br>지속시간: "+c2+"초"+
                        "<br><br>다음 레벨" +
                        "<br>반경: "+n1+"미터" +
                        "<br>지속시간: "+n2+"초";
    }

    public static String cursesSkill7(String lv, String c1, String c2, String n1, String n2) {
        return
                "<font color='#48AE4A'>생명력 추출</font>" +
                        "<br>괴물 무리에 저주를 걸어<br>대상을 공격하면 공격자가 생명력을 회복하게 합니다." +
                        "<br><br>치유: 공격 피해의 50%" +
                        "<br>마나 소모: 9" +
                        "<br><br>다음 레벨" +
                        "<br>반경: "+c1+"미터" +
                        "<br>지속시간: "+c2+"초"+
                        "<br><br>다음 레벨" +
                        "<br>반경: "+n1+"미터" +
                        "<br>지속시간: "+n2+"초";
    }

    public static String cursesSkill8(String lv, String c1, String n1) {
        return
                "<font color='#48AE4A'>유혹</font>" +
                        "<br>괴물 무리에 저주를 걸어 주위 모든 괴물의<br>공격 대상이 되게 합니다.<br>이 저주는 다른 저주에 무효화될 수 없습니다." +
                        "<br><br>반경: 6미터" +
                        "<br>마나 소모: 17" +
                        "<br><br>현재 기술 레벨: "+lv +
                        "<br>지속시간: "+c1+"초"+
                        "<br><br>다음 레벨" +
                        "<br>지속시간: "+n1+"초";
    }

    public static String cursesSkill9(String lv, String c1, String c2, String n1, String n2) {
        return
                "<font color='#48AE4A'>노화</font>" +
                        "<br>괴물 무리에 저주를 걸어<br>대상의 이동 속도를 감소시키고,<br>약화시켜 받는 피해를 증가시킵니다." +
                        "<br><br>적 공격력: -50%" +
                        "<br>공격 속도: -50%" +
                        "<br>걷기/달리기 속도: -50%" +
                        "<br>반경: 4미터" +
                        "<br><br>현재 기술 레벨: "+lv +
                        "<br>지속시간: "+c1+"초" +
                        "<br>마나 소모: "+c2+
                        "<br><br>다음 레벨" +
                        "<br>지속시간: "+n1+"초" +
                        "<br>마나 소모: "+n2;
    }

    public static String cursesSkill10(String lv, String c1, String c2, String n1, String n2) {
        return
                "<font color='#48AE4A'>저항 감소</font>" +
                        "<br>적에 저주를 걸어 모든 마법 공격으로 받는 피해를 증가시킵니다.<br>괴물들의 저항을 감소시킵니다.<br>적대적 플레이어의 최대 저항을 감시시킵니다." +
                        "<br><br>마나 소모: 22" +
                        "<br><br>현재 기술 레벨: "+lv +
                        "<br>모든 저항: -31%" +
                        "<br>반경: "+c1+"미터" +
                        "<br>지속시간: "+c2+"초"+
                        "<br><br>다음 레벨" +
                        "<br>모든 저항: -31%" +
                        "<br>반경: "+n1+"미터" +
                        "<br>지속시간: "+n2+"초";

    }


}
