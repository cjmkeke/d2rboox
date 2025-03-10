package com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.assassin.traps;

public class TrapsUpdate {

    public static String trapsSkill1(String 레벨, String 현재화염피해, String 현재마나소모, String 다음화염피해, String 다음마나소모) {
        return
                "<font color='#48AE4A'>화염 작렬</font>" +
                        "<br>화염 폭탄을 투척하여<br>적을 산산이 조각냅니다." +
                        "<br><br>반경: 3.3미터" +
                        "<br><br>현재 기술 레벨: "+레벨+
                        "<br>화염 피해: "+현재화염피해 +
                        "<br>마나 소모 "+현재마나소모 +
                        "<br><br>다음 레벨"+
                        "<br>화염 피해: "+다음화염피해 +
                        "<br>마나 소모 3"+다음마나소모 +
                        "<br><br><font color='#48AE4A'>화염 작렬에 보너스 적용:</font>" +
                        "<br>감전 그물: 레벨당 화염 피해 +11%" +
                        "<br>번개 줄기 파수기: 레벨당 화염 피해 +11%" +
                        "<br>불의 파동: 레벨당 화염 피해 +11%" +
                        "<br>번개 파수기: 레벨당 화염 피해 +11%" +
                        "<br>지옥불의 파동: 레벨당 화염 피해 +11%";

    }

    public static String trapsSkill2(String 레벨, String 현재쐐기, String 현재번개피해, String 다음쐐기, String 다음번개피해) {
        return
                "<font color='#48AE4A'>감전 그물</font>" +
                        "<br>번개 그물을 투척하여<br>적을 감전시킵니다." +
                        "<br>요구 레벨: 6" +
                        "<br><br>시전 지연 시간: 0.6초" +
                        "<br>마나 소모: 6" +
                        "<br><br>현재 기술 레벨: "+레벨+
                        "<br>쐐기: "+현재쐐기+"개" +
                        "<br>평균 번개 피해: 초당 "+현재번개피해 +
                        "<br>지속시간: 3.6초" +
                        "<br><br>다음 레벨"+
                        "<br>쐐기: "+다음쐐기+"개" +
                        "<br>평균 번개 피해: 초당 "+다음번개피해+
                        "<br>지속시간: 3.6초" +
                        "<br><br><font color='#48AE4A'>감전 그물에 보너스 적용:</font>" +
                        "<br>화염 작렬: 3레벨당 쐐기 +1개" +
                        "<br>번개 줄기 파수기: 레벨당 번개 피해 +17%" +
                        "<br>번개 파수기: 레벨당 번개 피해 +17%";
    }


    public static String trapsSkill3(String 레벨, String 현재공격력, String 현재지속시간, String 다음공격력, String 다음지속시간) {
        return
                "<font color='#48AE4A'>파수꾼의 칼날</font>" +
                        "<br>회전하는 칼날을 내보내<br>자신과 목표 지점 사이를 오가게 합니다." +
                        "<br><br>무기 공격력 75%" +
                        "<br>시전 지연 시간: 1초" +
                        "<br>마나 소모: 7" +
                        "<br><br>현재 기술 레벨: "+레벨+
                        "<br>공격력: "+현재공격력 +
                        "<br>지속시간: "+현재지속시간+"초" +
                        "<br><br>다음 레벨"+
                        "<br>공격력: "+다음공격력 +
                        "<br>지속시간: "+다음지속시간+"초" +
                        "<br><br><font color='#48AE4A'>파수꾼의 칼날에 보너스 적용:</font>" +
                        "<br>분노의 칼날: 레벨당 피해 +10%" +
                        "<br>칼날 방패: 레벨당 피해 +10%";
    }

    public static String trapsSkill4(String 레벨, String 현재번개피해, String 다음번개피해) {
        return
                "<font color='#48AE4A'>번개 줄기 파수기</font>" +
                        "<br>근처를 지나가는 적에게 번개 줄기를 방출하는<br>덫을 설치합니다." +
                        "<br>요구 레벨: 12" +
                        "<br><br>5회 발사" +
                        "<br>번개 줄기 5개 방출" +
                        "<br>마나 소모: 13" +
                        "<br><br>현재 기술 레벨: "+레벨+
                        "<br>번개 피해: "+현재번개피해 +
                        "<br><br>다음 레벨"+
                        "<br>번개 피해: "+다음번개피해 +
                        "<br><br><font color='#48AE4A'>번개 줄기 파수기에 보너스 적용:</font>" +
                        "<br>감전 그물: 3레벨당 투사체 +1개" +
                        "<br>번개 파수기: 4레벨당 발사 횟수 +1회" +
                        "<br>화염 작렬: 레벨당 번개 피해 +9%" +
                        "<br>번개 파수기: 레벨당 번개 피해 +9%";
    }


    public static String trapsSkill5(String 레벨, String 현재화염피해, String 다음화염피해) {
        return
                "<font color='#48AE4A'>불의 파동</font>" +
                        "<br>화염 파동을 방출하는 덫을 설치합니다." +
                        "<br>요구 레벨: 12" +
                        "<br><br>5회 발사" +
                        "<br>마나 소모: 13" +
                        "<br><br>현재 기술 레벨: "+레벨+
                        "<br>화염 피해: "+현재화염피해 +
                        "<br><br>다음 레벨"+
                        "<br>화염 피해: "+다음화염피해 +
                        "<br><br><font color='#48AE4A'>불의 파동에 보너스 적용:</font>" +
                        "<br>화염 작렬: 레벨당 화염 피해 +10%" +
                        "<br>지옥불의 파동: 레벨당 화염 피해 +10%";
    }

    public static String trapsSkill6(String 레벨, String 현재명중률, String 현재공격력, String 현재마나소모, String 다음명중률, String 다음공격력, String 다음마나소모) {
        return
                "<font color='#48AE4A'>분노의 칼날</font>" +
                        "<br>회전하는 칼날을 투척하여<br>적을 뱁니다." +
                        "<br>요구 레벨: 18" +
                        "<br><br>무기 공격력 75%" +
                        "<br>시전에 필요한 최소 마나: 3" +
                        "<br><br>현재 기술 레벨: "+레벨+
                        "<br>명중률: +"+현재명중률+"%" +
                        "<br>공격력: "+현재공격력 +
                        "<br>마나 소모: 칼날 하나당 "+현재마나소모 +
                        "<br><br>다음 레벨"+
                        "<br>명중률: +"+다음명중률+"%" +
                        "<br>공격력: "+다음공격력 +
                        "<br>마나 소모: 칼날 하나당 "+다음마나소모 +
                        "<br><br><font color='#48AE4A'>분노의 칼날에 보너스 적용:</font>" +
                        "<br>파수꾼의 칼날: 레벨당 피해 +10%" +
                        "<br>칼날 방패: 레벨당 피해 +10%";
    }

    public static String trapsSkill7(String 레벨, String 현재번개피해, String 다음번개피해) {
        return
                "<font color='#48AE4A'>번개 파수기</font>" +
                        "<br>번개를 방출하여 지나가는 적을 불태우는<br>덫을 설치합니다." +
                        "<br>요구 레벨: 24" +
                        "<br><br>10회 발사" +
                        "<br>마나 소모: 20" +
                        "<br><br>현재 기술 레벨: "+레벨+
                        "<br>번개 피해: "+현재번개피해 +
                        "<br><br>다음 레벨"+
                        "<br>번개 피해: "+다음번개피해 +
                        "<br><br><font color='#48AE4A'>번개 파수기에 보너스 적용:</font>" +
                        "<br>감전 그물: 레벨당 번개 피해 +18%%" +
                        "<br>번개 줄기 파수기: 레벨당 번개 피해 +18%";
    }

    public static String trapsSkill8(String 레벨, String 현재화염피해, String 다음화염피해) {
        return
                "<font color='#48AE4A'>지옥불의 파동</font>" +
                        "<br>지나가는 적에게 화염을 내뿜는 덫을 설치합니다." +
                        "<br>요구 레벨: 24" +
                        "<br><br>10회 발사" +
                        "<br>범위: 6.6미터" +
                        "<br>마나 소모: 20" +
                        "<br><br>현재 기술 레벨: "+레벨+
                        "<br>평균 화염 피해: 초당 "+현재화염피해 +
                        "<br><br>다음 레벨"+
                        "<br>평균 화염 피해: 초당 "+다음화염피해 +
                        "<br><br><font color='#48AE4A'>지옥불의 파동에 보너스 적용:</font>" +
                        "<br>불의 파동: 레벨당 +0.5미터" +
                        "<br>화염 작렬: 레벨당 화염 피해 +18%" +
                        "<br>불의 파동: 레벨당 화염 피해 +18%";
    }

    public static String trapsSkill9(String 레벨, String 현재번개피해, String 현재반경, String 다음번개피해, String 다음반경) {
        return
                "<font color='#48AE4A'>죽음 파수기</font>" +
                        "<br>적에게 번개를 발사하거나<br>주위의 시체를 폭발시켜 적을 사멸시키는 덫을 설치합니다." +
                        "<br>요구 레벨: 30" +
                        "<br><br>시체 폭발 피해: 사체 생명력의 40-80%" +
                        "<br>5회 발사" +
                        "<br>마나 소모: 20" +
                        "<br><br>현재 기술 레벨: "+레벨+
                        "<br>번개 피해: "+현재번개피해 +
                        "<br>반경: "+현재반경+"미터" +
                        "<br><br>다음 레벨"+
                        "<br>번개 피해: "+다음번개피해 +
                        "<br>반경: "+다음반경+"미터" +
                        "<br><br><font color='#48AE4A'>죽음 파수기에 보너스 적용:</font>" +
                        "<br>화염 작렬: 3레벨당 발쇠 횟수 +1회" +
                        "<br>번개 파수기: 레벨당 번개 피해 +12%";
    }

    public static String trapsSkill10(String 레벨, String 현재공격력, String 현재지속시간, String 현재마나소모, String 다음공격력, String 다음지속시간, String 다음마나소모) {
        return
                "<font color='#48AE4A'>칼날 방패</font>" +
                        "<br>칼날이 주변을 회전하여<br>가까이 다가오는 적을 벱니다." +
                        "<br>요구 레벨: 30" +
                        "<br><br>무기 공격력 75%" +
                        "<br>반경: 4미터" +
                        "<br><br>현재 기술 레벨: "+레벨+
                        "<br>공격력: "+현재공격력 +
                        "<br>지속시간: "+현재지속시간+"초" +
                        "<br>마나 소모: "+현재마나소모 +
                        "<br><br>다음 레벨"+
                        "<br>공격력: "+다음공격력 +
                        "<br>지속시간: "+다음지속시간+"초" +
                        "<br>마나 소모: "+다음마나소모 +
                        "<br><br><font color='#48AE4A'>칼날 방패에 보너스 적용:</font>" +
                        "<br>파수꾼의 칼날: 레벨당 피해 +10%" +
                        "<br>분노의 칼날: 레벨당 피해 +10%";
    }


}
