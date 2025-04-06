package com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.druid.druidsummoning;

public class DruidSummoningUpdate {

    public static String druidSummoningSkill_1(String lv, String c1, String c2, String c3, String c4, String n1, String n2, String n3, String n4) {
        return
                "<font color='#48AE4A'>큰까마귀</font>" +
                        "<br>큰까마귀를 소환하여<br>적의 눈을 파먹게 합니다." +
                        "<br><br>큰까마귀 한마리당 마나 소모: 6" +
                        "<br><br>현재 기술 레벨" + lv +
                        "<br>명중률: +" + c1 + "%" +
                        "<br>공격력: " + c2 + 
                        "<br>" + c3 + "회 적중" +
                        "<br>최대 큰까마귀 수: " + c4 + "마리" +
                        "<br><br>다음 레벨" +
                        "<br>명중률: +" + n1 + "%" +
                        "<br>공격력: " + n2 + 
                        "<br>" + n3 + "회 적중" +
                        "<br>최대 큰까마귀 수: " + n4 + "마리" +
                        "<br><br><font color='#48AE4A'>큰까마귀에 보너스 적용:</font>" +
                        "<br>영혼 늑대 소환: 레벨당 피해 +12%" +
                        "<br>광포한 늑대 소환: 레벨당 피해 +12%" +
                        "<br>회색곰 소환: 레벨당 피해 +12%";
    }


    public static String druidSummoningSkill2(String lv, String c1, String c2, String c3, String n1, String n2, String n3) {
        return
                "<font color='#48AE4A'>맹독 덩굴</font>" +
                        "<br>접촉하는 적에게 질병을<br>퍼트리는 덩굴을 소환합니다." +
                        "<br><br>마나 소모: 8" +
                        "<br><br>현재 기술 레벨" + lv +
                        "<br>생명력: " + c1 + 
                        "<br>독 피해: " + c2 + 
                        "<br>" + c3 + "초에 걸쳐" +
                        "<br><br>다음 레벨" +
                        "<br>생명력: " + n1 + 
                        "<br>독 피해: " + n2 + 
                        "<br>" + n3 + "초에 걸쳐" +
                        "<br><br><font color='#48AE4A'>맹독 덩굴에 보너스 적용:</font>" +
                        "<br>광견병: 레벨당 독 피해 +10%";
    }

    public static String druidSummoningSkill3(String lv, String c1, String c2, String c3, String c4, String n1, String n2, String n3, String n4) {
        return
                "<font color='#48AE4A'>참나무 현자</font>" +
                        "<br>영혼 소환수를 소환하여<br>자신과 파티원의 생명력을 증가시킵니다." +
                        "<br><br>현재 기술 레벨" + lv +
                        "<br>생명력: " + c1 + 
                        "<br>최대 생명력: +" + c2 + "%" +
                        "<br>반경: " + c3 + "미터" +
                        "<br>마나 소모: " + c4 + 
                        "<br><br>다음 레벨" +
                        "<br>생명력: " + n1 + 
                        "<br>최대 생명력: +" + n2 + "%" +
                        "<br>반경: " + n3 + "미터" +
                        "<br>마나 소모: " + n4 + "";
    }

    public static String druidSummoningSkill4(String lv, String c1, String c2, String c3, String c4, String c5, String n1, String n2, String n3, String n4, String n5) {
        return
                "<font color='#48AE4A'>영혼 늑대 소환</font>" +
                        "<br>순간이동 능력이 있는 늑대를 소환하여<br>전투를 돕게 합니다." +
                        "<br><br>마나 소모: 15" +
                        "<br><br>현재 기술 레벨" + lv +
                        "<br>생명력: " + c1 + 
                        "<br>냉기 피해: " + c2 + 
                        "<br>최대 늑대 수: " + c3 + "마리" +
                        "<br>명중률: +" + c4 + "%" +
                        "<br>방어력: +" + c5 + "%" +
                        "<br><br>다음 레벨" +
                        "<br>생명력: " + n1 + 
                        "<br>냉기 피해: " + n2 + 
                        "<br>최대 늑대 수: " + n3 + "마리" +
                        "<br>명중률: +" + n4 + "%" +
                        "<br>방어력: +" + n5 + "%" +
                        "<br><br><font color='#48AE4A'>영혼 늑대 소환에 보너스 적용:</font>" +
                        "<br>광포한 늑대 소환: 레벨당 생명력 +15%" +
                        "<br>회색곰 소환: 레벨당 피해 +10%";
    }


    public static String druidSummoningSkill5(String lv, String c1, String c2, String n1, String n2) {
        return
                "<font color='#48AE4A'>청소부 덩굴</font>" +
                        "<br>시체를 먹어 플레이어의 생명력의 회복시키는<br>덩굴을 소환합니다." +
                        "<br><br>마나 소모: 10" +
                        "<br><br>현재 기술 레벨" + lv +
                        "<br>생명력: " + c1 + 
                        "<br>치유: +" + c2 + "%" +
                        "<br><br>다음 레벨" +
                        "<br>생명력: " + n1 + 
                        "<br>치유: +" + n2 + "%";
    }

    public static String druidSummoningSkill6(String lv, String c1, String c2, String c3, String c4, String c5, String n1, String n2, String n3, String n4, String n5) {
        return
                "<font color='#48AE4A'>울버린의 심장</font>" +
                        "<br>영혼 소환수를 소환하여<br>자신과 파티원의 공격력과<br>명중률을 증가시킵니다." +
                        "<br><br>현재 기술 레벨" + lv +
                        "<br>생명력: " + c1 + 
                        "<br>명중률: +" + c2 + "%" +
                        "<br>공격력: +" + c3 + "%" +
                        "<br>반경: " + c4 + "미터" +
                        "<br>마나 소모: " + c5 + 
                        "<br><br>다음 레벨" +
                        "<br>생명력: " + n1 + 
                        "<br>명중률: +" + n2 + "%" +
                        "<br>공격력: +" + n3 + "%" +
                        "<br>반경: " + n4 + "미터" +
                        "<br>마나 소모: " + n5 + "";
    }

    public static String druidSummoningSkill7(String lv, String c1, String c2, String c3, String c4, String c5, String n1, String n2, String n3, String n4, String n5) {
        return
                "<font color='#48AE4A'>광포한 늑대 소환</font>" +
                        "<br>광포한 늑대를 소환합니다.<br>늑대는 시체를 먹어<br>적에게 더 큰 피해를 줍니다." +
                        "<br><br>마나 소모: 20" +
                        "<br><br>현재 기술 레벨" + lv +
                        "<br>생명력: " + c1 + 
                        "<br>공격력: " + c2 + 
                        "<br>최대 늑대 수: " + c3 + "마리" +
                        "<br>최대 생명력: +" + c4 + "%" +
                        "<br>방어력: +" + c5 + "%" +
                        "<br><br>다음 레벨" +
                        "<br>생명력: " + n1 + 
                        "<br>공격력: " + n2 + 
                        "<br>최대 늑대 수: " + n3 + "마리" +
                        "<br>최대 생명력: +" + n4 + "%" +
                        "<br>방어력: +" + n5 + "%" +
                        "<br><br><font color='#48AE4A'>광포한 늑대 소환에 보너스 적용:</font>" +
                        "<br>영혼 늑대 소환: 레벨당 명중률 +25%" +
                        "<br>영혼 늑대 소환: 레벨당 방어력 +10%" +
                        "<br>회색곰 소환: 레벨당 피해 +10%";
    }

    public static String druidSummoningSkill8(String lv, String c1, String c2, String c3, String n1, String n2, String n3) {
        return
                "<font color='#48AE4A'>태양의 덩굴</font>" +
                        "<br>시체를 먹어 플레이어의 마나를 회복시키는<br>덩굴을 소환합니다." +
                        "<br><br>현재 기술 레벨" + lv +
                        "<br>생명력: " + c1 + 
                        "<br>마나 회복 속도: +" + c2 + "%" +
                        "<br>마나 소모: " + c3 + 
                        "<br><br>다음 레벨" +
                        "<br>생명력: " + n1 + 
                        "<br>마나 회복 속도: +" + n2 + "%" +
                        "<br>마나 소모: " + n3 + "";
    }

    public static String druidSummoningSkill9(String lv, String c1, String c2, String c3, String c4, String n1, String n2, String n3, String n4) {
        return
                "<font color='#48AE4A'>가시의 영혼</font>" +
                        "<br>영혼 소환수를 소환하여<br>자신과 파티원이 받는 피해를<br>적에게 되돌려 줍니다." +
                        "<br><br>현재 기술 레벨" + lv +
                        "<br>생명력: " + c1 + 
                        "<br>공격자가 피해를 " + c2 + " 받음" +
                        "<br>반경: "+c3 +
                        "<br>마나 소모: " + c4 +
                        "<br><br>다음 레벨" +
                        "<br>생명력: " + n1 + 
                        "<br>공격자가 피해를 " + n2 + " 받음" +
                        "<br>반경: "+n3 +
                        "<br>마나 소모: " + n4 + "";
    }

    public static String druidSummoningSkill10(String lv, String c1, String c2, String c3, String n1, String n2, String n3) {
        return
                "<font color='#48AE4A'>회색곰 소환</font>" +
                        "<br>흉포한 회색곰을 소환합니다." +
                        "<br><br>마나 소모: 40" +
                        "<br>명중률: +25%" +
                        "<br>방어력: +10%" +
                        "<br><br>현재 기술 레벨" + lv +
                        "<br>생명력: " + c1 + 
                        "<br>공격력: " + c2 + 
                        "<br>공격력: +" + c3 + "%" +
                        "<br><br>다음 레벨" +
                        "<br>생명력: " + n1 + 
                        "<br>공격력: " + n2 + 
                        "<br>공격력: +" + n3 + "%" +
                        "<br><br><font color='#48AE4A'>회색곰에 보너스 적용:</font>" +
                        "<br>영혼 늑대 소환: 레벨당 명중률 +25%" +
                        "<br>영혼 늑대 소환: 레벨당 방어력 +10%" +
                        "<br>광포한 늑대 소환: 레벨당 방어력 +15%";
    }

    /*********************************************************************************************************************************************************************************************************/
    /*********************************************************************************************************************************************************************************************************/
    /*********************************************************************************************************************************************************************************************************/

    public static String druidSummoningSkill1_end(String i1, String i2, String i3, String i4, String i5,
                                                  String i6, String i7, String i8, String i9, String i10) {
        return "<font color='#48AE4A'>큰까마귀</font>" +
                "<br><font color='#A95750'>큰까마귀를 소환하여<br>적의 눈을 파먹게 합니다." +
                "<br>최대 레벨 도달" +
                "<br><br>큰까마귀 한마리당 마나 소모: 6" +
                "<br><br>현재 기술 레벨: 20" +
                "<br>명중률: +"+i1+"%" +
                "<br>공격력: "+i2+"" +
                "<br>"+i3+"회 적중" +
                "<br>최대 큰까마귀 수: "+i4+"마리분노</font>" +
                "<br><br><font color='#48AE4A'>큰까마귀에 보너스 적용:</font>" +
                "<br><font color='#A95750'>영혼 늑대 소환: 레벨당 피해 +12%" +
                "<br>광포한 늑대 소환: 레벨당 피해 +12%" +
                "<br>회색곰 소환: 레벨당 피해 +12%";
    }

    public static String druidSummoningSkill2_end(String i1, String i2, String i3, String i4, String i5,
                                                  String i6, String i7, String i8, String i9, String i10) {
        return "<font color='#48AE4A'>맹독 덩굴</font>" +
                "<br><font color='#A95750'>접촉하는 적에게 질병을<br>퍼트리는 덩굴을 소환합니다." +
                "<br>최대 레벨 도달" +
                "<br><br>마나 소모: 8" +
                "<br><br>현재 기술 레벨: 20" +
                "<br>생명력: "+i1+"" +
                "<br>독 피해: "+i2+"" +
                "<br>"+i3+"초에 걸쳐분노</font>" +
                "<br><br><font color='#48AE4A'>맹독 덩굴에 보너스 적용:</font>" +
                "<br><font color='#A95750'>광견병: 레벨당 독 피해 +10%";
    }

    public static String druidSummoningSkill3_end(String i1, String i2, String i3, String i4, String i5,
                                                  String i6, String i7, String i8, String i9, String i10) {
        return "<font color='#48AE4A'>참나무 현자</font>" +
                "<br><font color='#A95750'>영혼 소환수를 소환하여<br>자신과 파티원의 생명력을 증가시킵니다." +
                "<br>최대 레벨 도달" +
                "<br><br>현재 기술 레벨: 20" +
                "<br>생명력: "+i1+"" +
                "<br>최대 생명력: +"+i2+"%" +
                "<br>반경: "+i3+"미터" +
                "<br>마나 소모: "+i4+"";
    }

    public static String druidSummoningSkill4_end(String i1, String i2, String i3, String i4, String i5,
                                                  String i6, String i7, String i8, String i9, String i10) {
        return "<font color='#48AE4A'>영혼 늑대 소환</font>" +
                "<br><font color='#A95750'>순간이동 능력이 있는 늑대를 소환하여<br>전투를 돕게 합니다." +
                "<br>최대 레벨 도달" +
                "<br><br>마나 소모: 15" +
                "<br><br>현재 기술 레벨: 20" +
                "<br>생명력: "+i1+"" +
                "<br>냉기 피해: "+i2+"" +
                "<br>최대 늑대 수: "+i3+"마리" +
                "<br>명중률: +"+i4+"%" +
                "<br>방어력: +"+i5+"%분노</font>" +
                "<br><br><font color='#48AE4A'>영혼 늑대 소환에 보너스 적용:</font>" +
                "<br><font color='#A95750'>광포한 늑대 소환: 레벨당 생명력 +15%" +
                "<br>회색곰 소환: 레벨당 피해 +10%";
    }

    public static String druidSummoningSkill5_end(String i1, String i2, String i3, String i4, String i5,
                                                  String i6, String i7, String i8, String i9, String i10) {
        return "<font color='#48AE4A'>청소부 덩굴</font>" +
                "<br><font color='#A95750'>시체를 먹어 플레이어의 생명력의 회복시키는<br>덩굴을 소환합니다." +
                "<br>최대 레벨 도달" +
                "<br><br>마나 소모: 10" +
                "<br><br>현재 기술 레벨: 20" +
                "<br>생명력: "+i1+"" +
                "<br>치유: +"+i2+"%";
    }

    public static String druidSummoningSkill6_end(String i1, String i2, String i3, String i4, String i5,
                                                  String i6, String i7, String i8, String i9, String i10) {
        return "<font color='#48AE4A'>울버린의 심장</font>" +
                "<br><font color='#A95750'>영혼 소환수를 소환하여<br>자신과 파티원의 공격력과<br>명중률을 증가시킵니다." +
                "<br>최대 레벨 도달" +
                "<br><br>현재 기술 레벨: 20" +
                "<br>생명력: "+i1+"" +
                "<br>명중률: +"+i2+"%" +
                "<br>공격력: +"+i3+"%" +
                "<br>반경: "+i4+"미터" +
                "<br>마나 소모: "+i5+"";
    }

    public static String druidSummoningSkill7_end(String c1, String c2, String c3, String c4, String c5,
                                                  String c6, String c7, String c8, String c9, String c10) {
        return "<font color='#48AE4A'>광포한 늑대 소환</font>" +
                "<br><font color='#A95750'>광포한 늑대를 소환합니다.<br>늑대는 시체를 먹어<br>적에게 더 큰 피해를 줍니다." +
                "<br>최대 레벨 도달" +
                "<br><br>마나 소모: 20" +
                "<br><br>현재 기술 레벨: 20" +
                "<br>생명력: "+c1+"" +
                "<br>공격력: "+c2+"" +
                "<br>최대 늑대 수: "+c3+"마리" +
                "<br>최대 생명력: +"+c4+"%" +
                "<br>방어력: +"+c5+"%분노</font>" +
                "<br><br><font color='#48AE4A'>광포한 늑대 소환에 보너스 적용:</font>" +
                "<br><font color='#A95750'>영혼 늑대 소환: 레벨당 명중률 +25%" +
                "<br>영혼 늑대 소환: 레벨당 방어력 +10%" +
                "<br>회색곰 소환: 레벨당 피해 +10%";
    }

    public static String druidSummoningSkill8_end(String c1, String c2, String c3, String c4, String c5,
                                                  String c6, String c7, String c8, String c9, String c10) {
        return "<font color='#48AE4A'>태양의 덩굴</font>" +
                "<br><font color='#A95750'>시체를 먹어 플레이어의 마나를 회복시키는<br>덩굴을 소환합니다." +
                "<br>최대 레벨 도달" +
                "<br><br>현재 기술 레벨: 20" +
                "<br>생명력: "+c1+"" +
                "<br>마나 회복 속도: +"+c2+"%" +
                "<br>마나 소모: "+c3+"";
    }

    public static String druidSummoningSkill9_end(String c1, String c2, String c3, String c4, String c5,
                                                  String c6, String c7, String c8, String c9, String c10) {
        return "<font color='#48AE4A'>가시의 영혼</font>" +
                "<br><font color='#A95750'>영혼 소환수를 소환하여<br>자신과 파티원이 받는 피해를<br>적에게 되돌려 줍니다." +
                "<br>최대 레벨 도달" +
                "<br><br>현재 기술 레벨: 20" +
                "<br>생명력: "+c1+"" +
                "<br>공격자가 피해를 "+c2+" 받음" +
                "<br>마나 소모: "+c3+"";
    }

    public static String druidSummoningSkill10_end(String c1, String c2, String c3, String c4, String c5,
                                                   String c6, String c7, String c8, String c9, String c10) {
        return "<font color='#48AE4A'>회색곰 소환</font>" +
                "<br><font color='#A95750'>흉포한 회색곰을 소환합니다." +
                "<br>최대 레벨 도달" +
                "<br><br>마나 소모: 40" +
                "<br>명중률: +25%" +
                "<br>방어력: +10%" +
                "<br><br>현재 기술 레벨: 20" +
                "<br>생명력: "+c1+"" +
                "<br>공격력: "+c2+"" +
                "<br>공격력: +"+c3+"%분노</font>" +
                "<br><br><font color='#48AE4A'>회색곰에 보너스 적용:</font>" +
                "<br><font color='#A95750'>영혼 늑대 소환: 레벨당 명중률 +25%" +
                "<br>영혼 늑대 소환: 레벨당 방어력 +10%" +
                "<br>광포한 늑대 소환: 레벨당 방어력 +15%";
    }


}
