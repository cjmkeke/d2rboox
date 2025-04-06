package com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.druid.shape;

public class ShapeUpdate {

    public static String shapeSkill1(String lv, String c1, String c2, String n1, String n2) {
        return
                "<font color='#48AE4A'>늑대인간</font>" +
                        "<br>늑대인간으로 변신합니다." +
                        "<br><br>최대 생명력: +25%" +
                        "<br>최대 지구력: +25%" +
                        "<br>지속시간: 40초" +
                        "<br>시전 지연 시간: 1초" +
                        "<br>마나 소모: 15" +
                        "<br><br>현재 기술 레벨: "+lv +
                        "<br>명중률: +"+c1+"%" +
                        "<br>공격 속도: +"+c2+"%" +
                        "<br><br>다음 레벨"+
                        "<br>명중률: +"+n1+"%" +
                        "<br>공격 속도: +"+n2+"%" +
                        "<br><br><font color='#48AE4A'>늑대인간에 보너스 적용:</font>" +
                        "<br>변신술";
    }


    public static String shapeSkill2(String lv, String c1, String c2, String n1, String n2) {
        return
                "<font color='#48AE4A'>변신술</font>" +
                        "<br>지속 효과 - 늑대인간이나 곰인간 형태일 때<br>지속시간과 생명력이 증가합니다." +
                        "<br><br>현재 기술 레벨: "+lv +
                        "<br>최대 생명력: +"+c1+"%" +
                        "<br>지속시간: +"+c2+"초"+
                        "<br><br>다음 레벨"+
                        "<br>최대 생명력: +"+n1+"%" +
                        "<br>지속시간: +"+n2+"초";
    }

    public static String shapeSkill3(String lv, String c1, String c2, String n1, String n2) {
        return
                "<font color='#48AE4A'>곰인간</font>" +
                        "<br>저지 불가 공격을 가하는<br>곰인간으로 변신합니다." +
                        "<br><br>최대 생명력: +75%" +
                        "<br>지속시간: 40초" +
                        "<br>시전 지연 시간: 1초" +
                        "<br>마나 소모: 15" +
                        "<br><br>현재 기술 레벨: "+lv +
                        "<br>공격력: +"+c1+"%" +
                        "<br>방어력: +"+c2+"%" +
                        "<br><br>다음 레벨"+
                        "<br>공격력: +"+n1+"%" +
                        "<br>방어력: +"+n2+"%" +
                        "<br><br><font color='#48AE4A'>곰인간에 보너스 적용:</font>" +
                        "<br>변신술";
    }

    public static String shapeSkill4(String lv, String c1, String c2, String c3, String c4, String n1, String n2, String n3, String n4) {
        return
                "<font color='#48AE4A'>흉포한 격노</font>" +
                        "<br>늑대인간 형태일 때<br>광분 상태가 되어<br>공격을 적중시킬 때마다<br>훔치는 생명력의 양이 점차 증가합니다." +
                        "<br><br>마나 소모: 3" +
                        "<br>지속시간: 20초" +
                        "<br><br>현재 기술 레벨: "+lv +
                        "<br>명중률: +"+c1+"%" +
                        "<br>걷기/달리기 속도: +"+c2+"%" +
                        "<br>생명력 훔치기: +"+c3+"%" +
                        "<br>공격력: +"+c4+"%"+
                        "<br><br>다음 레벨"+
                        "<br>명중률: +"+n1+"%" +
                        "<br>걷기/달리기 속도: +"+n2+"%" +
                        "<br>생명력 훔치기: +"+n3+"%" +
                        "<br>공격력: +"+n4+"%";

    }


    public static String shapeSkill5(String lv, String c1, String c2, String c3, String c4, String n1, String n2, String n3, String n4) {
        return
                "<font color='#48AE4A'>후려치기</font>" +
                        "<br>곰인간 성태일 때<br>적을 강하게 후려쳐<br>공격을 적중시킬 때마다<br>점점 더 큰 피해를 줍니다." +
                        "<br><br>마나 소모: 3" +
                        "<br>지속시간: 20초" +
                        "<br><br>현재 기술 레벨: "+lv +
                        "<br>명중률: +"+c1+"%" +
                        "<br>공격 속도: +"+c2+"%" +
                        "<br>공격력: +"+c3+"%" +
                        "<br>기절 지속시간: "+c4+"초"+
                        "<br><br>다음 레벨"+
                        "<br>명중률: +"+n1+"%" +
                        "<br>공격 속도: +"+n2+"%" +
                        "<br>공격력: +"+n3+"%" +
                        "<br>기절 지속시간: "+n4+"초";
    }

    public static String shapeSkill6(String lv, String c1, String c2, String c3, String n1, String n2, String n3) {
        return
                "<font color='#48AE4A'>광견병</font>" +
                        "<br>늑대인간 형태일 때<br>적을 물어뜯어<br>다른 괴물들에게 퍼지는<br>질병에 감염시킵니다." +
                        "<br><br>마나 소모: 10" +
                        "<br><br>현재 기술 레벨: "+lv +
                        "<br>명중률: +"+c1+"%" +
                        "<br>독 피해: "+c2+"" +
                        "<br>"+c3+"초에 걸쳐"+
                        "<br><br>다음 레벨"+
                        "<br>명중률: +"+n1+"%" +
                        "<br>독 피해: "+n2+"" +
                        "<br>"+n3+"초에 걸쳐";
    }

    public static String shapeSkill7(String lv, String c1, String c2, String n1, String n2) {
        return
                "<font color='#48AE4A'>화염 발톱</font>" +
                        "<br>늑대인간이나 곰인간 형태일 때<br>화염 발톱으로 적을<br>강하게 후려칩니다." +
                        "<br><br>마나 소모: 4" +
                        "<br><br>현재 기술 레벨: "+lv +
                        "<br>명중률: +"+c1+"%" +
                        "<br>화염 피해: "+c2+"" +
                        "<br><br>다음 레벨"+
                        "<br>명중률: +"+n1+"%" +
                        "<br>화염 피해: "+n2+"" +
                        "<br><br><font color='#48AE4A'>화염 발톱에 보너스 적용:</font>" +
                        "<br>화염폭풍: 레벨당 화염 피해 +22%" +
                        "<br>타오르는 바위: 레벨당 화염 피해 +22%";
    }

    public static String shapeSkill8(String lv, String c1, String c2, String c3, String n1, String n2, String n3) {
        return
                "<font color='#48AE4A'>굶주림</font>" +
                        "<br>늑대인간이나 곰인간 형태일 때<br>적을 물어뜯어<br>생명력과 마나를 흡수합니다." +
                        "<br><br>공격력: -75%" +
                        "<br>마나 소모: 3" +
                        "<br><br>현재 기술 레벨: "+lv +
                        "<br>명중률: +"+c1+"%" +
                        "<br>생명력 훔치기: +"+c2+"%" +
                        "<br>마나 훔치기: +"+c3+"%"+
                        "<br><br>다음 레벨"+
                        "<br>명중률: +"+n1+"%" +
                        "<br>생명력 훔치기: +"+n2+"%" +
                        "<br>마나 훔치기: +"+n3+"%";
    }

    public static String shapeSkill9(String lv, String c1, String c2, String n1, String n2) {
        return
                "<font color='#48AE4A'>충격파</font>" +
                        "<br>곰인간 형태일 때<br>충격파를 일으켜<br>주위의 적을 기절시킵니다." +
                        "<br><br>마나 소모: 7" +
                        "<br><br>현재 기술 레벨: "+lv +
                        "<br>공격력: "+c1+"" +
                        "<br>기절 지속시간: "+c2+"초" +
                        "<br><br>다음 레벨"+
                        "<br>공격력: "+n1+"" +
                        "<br>기절 지속시간: "+n2+"초" +
                        "<br><br><font color='#48AE4A'>충격파에 보너스 적용:</font>" +
                        "<br>후려치기: 레벨당 피해 +10%";
    }

    public static String shapeSkill10(String lv, String c1, String c2, String c3, String n1, String n2, String n3) {
        return
                "<font color='#48AE4A'>분노</font>" +
                        "<br>늑대인간 형태일 떄<br>인접한 다수의 대상을 동시에 공격하거나<br>하나의 대상을 여러 번 공격합니다." +
                        "<br><br>마나 소모: 4" +
                        "<br><br>현재 기술 레벨: "+lv +
                        "<br>"+c1+"회 적중" +
                        "<br>명중률: +"+c2+"%" +
                        "<br>공격력: +"+c3+"%"+
                        "<br><br>다음 레벨"+
                        "<br>"+n1+"회 적중" +
                        "<br>명중률: +"+n2+"%" +
                        "<br>공격력: +"+n3+"%";
    }

    /*********************************************************************************************************************************************************************************************************/
    /*********************************************************************************************************************************************************************************************************/
    /*********************************************************************************************************************************************************************************************************/

    public static String shapeSkill1_end(String lv, String c1, String c2, String c3, String c4, String c5, String c6, String c7, String c8, String c9) {
        return
                "<font color='#48AE4A'>늑대인간</font>" +
                        "<br><font color='#A95750'>늑대인간으로 변신합니다." +
                        "<br>최대 레벨 도달" +
                        "<br><br>최대 생명력: +25%" +
                        "<br>최대 지구력: +25%" +
                        "<br>지속시간: 40초" +
                        "<br>시전 지연 시간: 1초" +
                        "<br>마나 소모: 15" +
                        "<br><br>현재 기술 레벨: "+lv +
                        "<br>명중률: +"+c1+"%" +
                        "<br>공격 속도: +"+c2+"%분노</font>" +
                        "<br><br><font color='#48AE4A'>늑대인간에 보너스 적용:</font>" +
                        "<br><font color='#A95750'>변신술";
    }


    public static String shapeSkill2_end(String lv, String c1, String c2, String c3, String c4, String c5, String c6, String c7, String c8, String c9) {
        return
                "<font color='#48AE4A'>변신술</font>" +
                        "<br><font color='#A95750'>지속 효과 - 늑대인간이나 곰인간 형태일 때<br>지속시간과 생명력이 증가합니다." +
                        "<br>최대 레벨 도달" +
                        "<br><br>현재 기술 레벨: "+lv +
                        "<br>최대 생명력: +"+c1+"%" +
                        "<br>지속시간: +"+c2+"초";
    }

    public static String shapeSkill3_end(String lv, String c1, String c2, String c3, String c4, String c5, String c6, String c7, String c8, String c9) {
        return
                "<font color='#48AE4A'>곰인간</font>" +
                        "<br><font color='#A95750'>저지 불가 공격을 가하는<br>곰인간으로 변신합니다." +
                        "<br>최대 레벨 도달" +
                        "<br><br>최대 생명력: +75%" +
                        "<br>지속시간: 40초" +
                        "<br>시전 지연 시간: 1초" +
                        "<br>마나 소모: 15" +
                        "<br><br>현재 기술 레벨: "+lv +
                        "<br>공격력: +"+c1+"%" +
                        "<br>방어력: +"+c2+"%분노</font>" +
                        "<br><br><font color='#48AE4A'>곰인간에 보너스 적용:</font>" +
                        "<br><font color='#A95750'>변신술";
    }

    public static String shapeSkill4_end(String lv, String c1, String c2, String c3, String c4, String c5, String c6, String c7, String c8, String c9) {
        return
                "<font color='#48AE4A'>흉포한 격노</font>" +
                        "<br><font color='#A95750'>늑대인간 형태일 때<br>광분 상태가 되어<br>공격을 적중시킬 때마다<br>훔치는 생명력의 양이 점차 증가합니다." +
                        "<br>최대 레벨 도달" +
                        "<br><br>마나 소모: 3" +
                        "<br>지속시간: 20초" +
                        "<br><br>현재 기술 레벨: "+lv +
                        "<br>명중률: +"+c1+"%" +
                        "<br>걷기/달리기 속도: +"+c2+"%" +
                        "<br>생명력 훔치기: +"+c3+"%" +
                        "<br>공격력: +"+c4+"%";

    }


    public static String shapeSkill5_end(String lv, String c1, String c2, String c3, String c4, String c5, String c6, String c7, String c8, String c9) {
        return
                "<font color='#48AE4A'>후려치기</font>" +
                        "<br><font color='#A95750'>곰인간 성태일 때<br>적을 강하게 후려쳐<br>공격을 적중시킬 때마다<br>점점 더 큰 피해를 줍니다." +
                        "<br>최대 레벨 도달" +
                        "<br><br>마나 소모: 3" +
                        "<br>지속시간: 20초" +
                        "<br><br>현재 기술 레벨: "+lv +
                        "<br>명중률: +"+c1+"%" +
                        "<br>공격 속도: +"+c2+"%" +
                        "<br>공격력: +"+c3+"%" +
                        "<br>기절 지속시간: "+c4+"초";
    }

    public static String shapeSkill6_end(String lv, String c1, String c2, String c3, String c4, String c5, String c6, String c7, String c8, String c9) {
        return
                "<font color='#48AE4A'>광견병</font>" +
                        "<br><font color='#A95750'>늑대인간 형태일 때<br>적을 물어뜯어<br>다른 괴물들에게 퍼지는<br>질병에 감염시킵니다." +
                        "<br>최대 레벨 도달" +
                        "<br><br>마나 소모: 10" +
                        "<br><br>현재 기술 레벨: "+lv +
                        "<br>명중률: +"+c1+"%" +
                        "<br>독 피해: "+c2+"" +
                        "<br>"+c3+"초에 걸쳐";
    }

    public static String shapeSkill7_end(String lv, String c1, String c2, String c3, String c4, String c5, String c6, String c7, String c8, String c9) {
        return
                "<font color='#48AE4A'>화염 발톱</font>" +
                        "<br><font color='#A95750'>늑대인간이나 곰인간 형태일 때<br>화염 발톱으로 적을<br>강하게 후려칩니다." +
                        "<br>최대 레벨 도달" +
                        "<br><br>마나 소모: 4" +
                        "<br><br>현재 기술 레벨: "+lv +
                        "<br>명중률: +"+c1+"%" +
                        "<br>화염 피해: "+c2+"분노</font>" +
                        "<br><br><font color='#48AE4A'>화염 발톱에 보너스 적용:</font>" +
                        "<br><font color='#A95750'>화염폭풍: 레벨당 화염 피해 +22%" +
                        "<br>타오르는 바위: 레벨당 화염 피해 +22%";
    }

    public static String shapeSkill8_end(String lv, String c1, String c2, String c3, String c4, String c5, String c6, String c7, String c8, String c9) {
        return
                "<font color='#48AE4A'>굶주림</font>" +
                        "<br><font color='#A95750'>늑대인간이나 곰인간 형태일 때<br>적을 물어뜯어<br>생명력과 마나를 흡수합니다." +
                        "<br>최대 레벨 도달" +
                        "<br><br>공격력: -75%" +
                        "<br>마나 소모: 3" +
                        "<br><br>현재 기술 레벨: "+lv +
                        "<br>명중률: +"+c1+"%" +
                        "<br>생명력 훔치기: +"+c2+"%" +
                        "<br>마나 훔치기: +"+c3+"%";
    }

    public static String shapeSkill9_end(String lv, String c1, String c2, String c3, String c4, String c5, String c6, String c7, String c8, String c9) {
        return
                "<font color='#48AE4A'>충격파</font>" +
                        "<br><font color='#A95750'>곰인간 형태일 때<br>충격파를 일으켜<br>주위의 적을 기절시킵니다." +
                        "<br>최대 레벨 도달" +
                        "<br><br>마나 소모: 7" +
                        "<br><br>현재 기술 레벨: "+lv +
                        "<br>공격력: "+c1+"" +
                        "<br>기절 지속시간: "+c2+"초분노</font>" +
                        "<br><br><font color='#48AE4A'>충격파에 보너스 적용:</font>" +
                        "<br><font color='#A95750'>후려치기: 레벨당 피해 +10%";
    }

    public static String shapeSkill10_end(String lv, String c1, String c2, String c3, String c4, String c5, String c6, String c7, String c8, String c9) {
        return
                "<font color='#48AE4A'>분노</font>" +
                        "<br><font color='#A95750'>늑대인간 형태일 떄<br>인접한 다수의 대상을 동시에 공격하거나<br>하나의 대상을 여러 번 공격합니다." +
                        "<br>최대 레벨 도달" +
                        "<br><br>마나 소모: 4" +
                        "<br><br>현재 기술 레벨: "+lv +
                        "<br>"+c1+"회 적중" +
                        "<br>명중률: +"+c2+"%" +
                        "<br>공격력: +"+c3+"%";
    }


}
