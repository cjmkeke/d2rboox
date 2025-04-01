package com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.sorceress.fire;

public class FireUpdate {

    public static String fireSkill1(String lv, String c1, String n1) {
        return "<font color='#48AE4A'>화염탄</font>" +
                "<br>불타오르는 마법 투사체를 생성합니다." +
                "<br><br>마나 소모: 2.5" +
                "<br><br>현재 기술 레벨: " + lv +
                "<br>화염 피해: "+c1+"" +
                "<br><br>다음 레벨" +
                "<br>화염 피해: "+n1+"" +
                "<br><br><font color='#48AE4A'>화염탄에 보너스 적용:</font>" +
                "<br>화염구: 레벨당 화염 피해 +16%" +
                "<br>운석 낙하: 레벨당 화염 피해 +16%";
    }

    public static String fireSkill2(String lv, String c1, String n1) {
        return "<font color='#48AE4A'>온기</font>" +
                "<br>지속 효과 - 마나 회복 속도가 증가합니다." +
                "<br><br>현재 기술 레벨: " + lv +
                "<br>마나 회복 속도: +"+c1+"%" +
                "<br><br>다음 레벨" +
                "<br>마나 회복 속도: +"+n1+"%";
    }

    public static String fireSkill3(String lv, String c1, String c2, String c3, String n1, String n2, String n3) {
        return "<font color='#48AE4A'>지옥불</font>" +
                "<br>연속으로 불줄기를 방출하여<br>적을 불태웁니다." +
                "<br><br>시전에 필요한 최소 마나: 4" +
                "<br><br>현재 기술 레벨: " + lv +
                "<br>평균 화염 피해: 초당 "+c1+"" +
                "<br>범위: "+c2+"미터" +
                "<br>마나 소모: 초당 "+c3+"" +
                "<br><br>다음 레벨" +
                "<br>평균 화염 피해: 초당 "+n1+"" +
                "<br>범위: "+n2+"미터" +
                "<br>마나 소모: 초당 "+n3+"" +
                "<br><br><font color='#48AE4A'>지옥불에 보너스 적용:</font>" +
                "<br>온기: 레벨당 화염 피해 +16%";
    }

    public static String fireSkill4(String lv, String c1, String c2, String c3, String c4, String c5, String n1, String n2, String n3, String n4, String n5) {
        return "<font color='#48AE4A'>불길</font>" +
                "<br>지나간 자리에 불길을 남겨<br>적을 불태웁니다." +
                "<br><br>현재 기술 레벨: " + lv +
                "<br>평균 화염 피해: 초당 "+c1+"" +
                "<br>화염 지속시간: "+c2+"초" +
                "<br>걷기/달리기 속도: +"+c3+"%" +
                "<br>불길 지속시간: "+c4+"초" +
                "<br>마나 소모: "+c5+"" +
                "<br><br>다음 레벨" +
                "<br>평균 화염 피해: 초당 "+n1+"" +
                "<br>화염 지속시간: "+n2+"초" +
                "<br>걷기/달리기 속도: +"+n3+"%" +
                "<br>불길 지속시간: "+n4+"초" +
                "<br>마나 소모: "+n5+"" +
                "<br><br><font color='#48AE4A'>불길에 보너스 적용:</font>" +
                "<br>온기: 레벨당 화염 피해 +6%";
    }

    public static String fireSkill5(String lv, String c1, String c2, String n1, String n2) {
        return "<font color='#48AE4A'>화염구</font>" +
                "<br>폭발하는 죽음의 화염 구체를 생성하여 <br>을 던집니다." +
                "<br>반경: 2.6미터" +
                "<br><br>현재 기술 레벨: " + lv +
                "<br>화염 피해: "+c1+"" +
                "<br>마나 소모: "+c2+"" +
                "<br><br>다음 레벨" +
                "<br>화염 피해: "+n1+"" +
                "<br>마나 소모: "+n2+"" +
                "<br><br><font color='#48AE4A'>화염구에 보너스 적용:</font>" +
                "<br>화염탄: 레벨당 화염 피해 +14%" +
                "<br>운석 낙하: 레벨당 화염 피해 +14%";
    }

    public static String fireSkill6(String lv, String c1, String c2, String c3, String n1, String n2, String n3) {
        return "<font color='#48AE4A'>화염벽</font>" +
                "<br>화염벽을 생성하여 주위의 적을 불태웁니다." +
                "<br><br>화염 지속시간: 3.6초" +
                "<br>시전 지연 시간: 1.4초" +
                "<br><br>현재 기술 레벨: " + lv +
                "<br>평균 화염 피해: 초당 "+c1+"" +
                "<br>범위: "+c2+"미터" +
                "<br>마나 소모: "+c3+"" +
                "<br><br>다음 레벨" +
                "<br>평균 화염 피해: 초당 "+n1+"" +
                "<br>범위: "+n2+"미터" +
                "<br>마나 소모: "+n3+"" +
                "<br><br><font color='#48AE4A'>화염벽에 보너스 적용:</font>" +
                "<br>온기: 레벨당 화염 피해 +4%" +
                "<br>지옥불: 레벨당 화염 피해 +1%";
    }

    public static String fireSkill7(String lv, String c1, String c2, String c3, String c4, String n1, String n2, String n3, String n4) {
        return "<font color='#48AE4A'>마법부여</font>" +
                "<br>대상 캐릭터 또는 하수인이 장착한 무기에 마법을 부여합니다.<br>모든 무기에 화염 피해를 추가합니다." +
                "<br><br>현재 기술 레벨: " + lv +
                "<br>명중률: +"+c1+"%" +
                "<br>화염 피해: "+c2+"" +
                "<br>지속시간: "+c3+"초" +
                "<br>마나 소모: "+c4+"" +
                "<br><br>다음 레벨" +
                "<br>명중률: +"+n1+"%" +
                "<br>화염 피해: "+n2+"" +
                "<br>지속시간: "+n3+"초" +
                "<br>마나 소모: "+n4+"" +
                "<br><br><font color='#48AE4A'>마법부여에 보너스 적용:</font>" +
                "<br>온기: 레벨당 화염 피해 +9%";
    }

    public static String fireSkill8(String lv, String c1, String c2, String c3, String n1, String n2, String n3) {
        return "<font color='#48AE4A'>운석 낙하</font>" +
                "<br>하늘에서 운석을 소환하여<br>적을 으스러뜨리고 불태웁니다." +
                "<br><br>반경: 4미터" +
                "<br>시전 지연 시간: 1.2초" +
                "<br><br>현재 기술 레벨: " + lv +
                "<br>화염 피해: "+c1+"" +
                "<br>평균 화염 피해: 초당 "+c2+"" +
                "<br>마나 소모: "+c3+"" +
                "<br><br>다음 레벨" +
                "<br>화염 피해: "+n1+"" +
                "<br>평균 화염 피해: 초당 "+n2+"" +
                "<br>마나 소모: "+n3+"" +
                "<br><br><font color='#48AE4A'>운석 낙하에 보너스 적용:</font>" +
                "<br>화염탄: 레벨당 화염 피해 +5%" +
                "<br>화염구: 레벨당 화염 피해 +5%" +
                "<br>지옥불: 레벨당 평균 초당 화염 피해 +3%";
    }

    public static String fireSkill9(String lv, String c1, String n1) {
        return "<font color='#48AE4A'>화염 숙련</font>" +
                "<br>지속 효과 - 화염 주문으로 주는 모든 피해가 증가합니다." +
                "<br><br>현재 기술 레벨: " + lv +
                "<br>화염 피해: +"+c1+"%" +
                "<br><br>다음 레벨" +
                "<br>화염 피해: +"+n1+"%";
    }

    public static String fireSkill10(String lv, String c1, String c2, String n1, String n2) {
        return "<font color='#48AE4A'>히드라</font>" +
                "<br>머리가 여러 개인 화염의 야수를 소환하여<br>적을 쐈더미로 만듭니다." +
                "<br><br>최대 히드라 수: 6마리" +
                "<br>지속시간: 10초" +
                "<br><br>현재 기술 레벨: " + lv +
                "<br>히드라 화염 피해: "+c1+"" +
                "<br>마나 소모: "+c2+"" +
                "<br><br>다음 레벨" +
                "<br>히드라 화염 피해: "+n1+"" +
                "<br>마나 소모: "+n2+"" +
                "<br><br><font color='#48AE4A'>히드라에 보너스 적용:</font>" +
                "<br>화염탄: 레벨당 화염 피해 +3%" +
                "<br>화염구: 레벨당 화염 피해 +3%";
    }

    /*********************************************************************************************************************************************************************************************************/
    /*********************************************************************************************************************************************************************************************************/
    /*********************************************************************************************************************************************************************************************************/

    public static String fireSkill1_end(String lv, String c1, String c2, String c3, String c4, String c5, String c6, String c7, String c8, String c9) {
        return "<font color='#48AE4A'>화염탄</font>" +
                "<br>불타오르는 마법 투사체를 생성합니다." +
                "<br>최대 레벨 도달" +
                "<br><br>마나 소모: 2.5" +
                "<br><br>현재 기술 레벨: " + lv +
                "<br>화염 피해: "+c1+"" +
                "<br><br><font color='#48AE4A'>화염탄에 보너스 적용:</font>" +
                "<br>화염구: 레벨당 화염 피해 +16%" +
                "<br>운석 낙하: 레벨당 화염 피해 +16%";
    }

    public static String fireSkill2_end(String lv, String c1, String c2, String c3, String c4, String c5, String c6, String c7, String c8, String c9) {
        return "<font color='#48AE4A'>온기</font>" +
                "<br>지속 효과 - 마나 회복 속도가 증가합니다." +
                "<br>최대 레벨 도달" +
                "<br><br>현재 기술 레벨: " + lv +
                "<br>마나 회복 속도: +"+c1+"%";
    }

    public static String fireSkill3_end(String lv, String c1, String c2, String c3, String c4, String c5, String c6, String c7, String c8, String c9) {
        return "<font color='#48AE4A'>지옥불</font>" +
                "<br>연속으로 불줄기를 방출하여<br>적을 불태웁니다." +
                "<br>최대 레벨 도달" +
                "<br><br>시전에 필요한 최소 마나: 4" +
                "<br><br>현재 기술 레벨: " + lv +
                "<br>평균 화염 피해: 초당 "+c1+"" +
                "<br>범위: "+c2+"미터" +
                "<br>마나 소모: 초당 "+c3+"" +
                "<br><br><font color='#48AE4A'>지옥불에 보너스 적용:</font>" +
                "<br>온기: 레벨당 화염 피해 +16%";
    }

    public static String fireSkill4_end(String lv, String c1, String c2, String c3, String c4, String c5, String c6, String c7, String c8, String c9) {
        return "<font color='#48AE4A'>불길</font>" +
                "<br>지나간 자리에 불길을 남겨<br>적을 불태웁니다." +
                "<br>최대 레벨 도달" +
                "<br><br>현재 기술 레벨: " + lv +
                "<br>평균 화염 피해: 초당 "+c1+"" +
                "<br>화염 지속시간: "+c2+"초" +
                "<br>걷기/달리기 속도: +"+c3+"%" +
                "<br>불길 지속시간: "+c4+"초" +
                "<br>마나 소모: "+c5+"" +
                "<br><br><font color='#48AE4A'>불길에 보너스 적용:</font>" +
                "<br>온기: 레벨당 화염 피해 +6%";
    }

    public static String fireSkill5_end(String lv, String c1, String c2, String c3, String c4, String c5, String c6, String c7, String c8, String c9) {
        return "<font color='#48AE4A'>화염구</font>" +
                "<br>폭발하는 죽음의 화염 구체를 생성하여<br>적을 덮칩니다." +
                "<br>최대 레벨 도달" +
                "<br><br>반경: 2.6미터" +
                "<br><br>현재 기술 레벨: " + lv +
                "<br>화염 피해: "+c1+"" +
                "<br>마나 소모: "+c2+"" +
                "<br><br><font color='#48AE4A'>화염구에 보너스 적용:</font>" +
                "<br>화염탄: 레벨당 화염 피해 +14%" +
                "<br>운석 낙하: 레벨당 화염 피해 +14%";
    }

    public static String fireSkill6_end(String lv, String c1, String c2, String c3, String c4, String c5, String c6, String c7, String c8, String c9) {
        return "<font color='#48AE4A'>화염벽</font>" +
                "<br>화염벽을 생성하여<br>주위의 적을 불태웁니다." +
                "<br>최대 레벨 도달" +
                "<br><br>화염 지속시간: 3.6초" +
                "<br>시전 지역 시간: 1.4초" +
                "<br><br>현재 기술 레벨: " + lv +
                "<br>평균 화염 피해: 초당 "+c1+"" +
                "<br>범위: "+c2+"미터" +
                "<br>마나 소모: "+c3+"" +
                "<br><br><font color='#48AE4A'>화염벽에 보너스 적용:</font>" +
                "<br>온기: 레벨당 화염 피해 +4%" +
                "<br>지옥불: 레벨당 화염 피해 +1%";
    }

    public static String fireSkill7_end(String lv, String c1, String c2, String c3, String c4, String c5, String c6, String c7, String c8, String c9) {
        return "<font color='#48AE4A'>마법부여</font>" +
                "<br>대상 캐릭터 또는 하수인이 장착한 무기에 마법을 부여합니다." +
                "<br>모든 무기에 화염 피해를 추가합니다." +
                "<br>최대 레벨 도달" +
                "<br><br>현재 기술 레벨: " + lv +
                "<br>명중률: +"+c1+"%" +
                "<br>화염 피해: "+c2+"" +
                "<br>지속시간: "+c3+"초" +
                "<br>마나 소모: "+c4+"" +
                "<br><br><font color='#48AE4A'>마법부여에 보너스 적용:</font>" +
                "<br>온기: 레벨당 화염 피해 +9%";
    }

    public static String fireSkill8_end(String lv, String c1, String c2, String c3, String c4, String c5, String c6, String c7, String c8, String c9) {
        return "<font color='#48AE4A'>운석 낙하</font>" +
                "<br>하늘에서 운석을 소환하여" +
                "<br>적을 으스러뜨리고 불태웁니다." +
                "<br>최대 레벨 도달" +
                "<br><br>반경: 4미터" +
                "<br>시전 지연 시간: 1.2초" +
                "<br><br>현재 기술 레벨: " + lv +
                "<br>화염 피해: 1781 - 1900" +
                "<br>평균 화염 피해: 초당 257 - 281" +
                "<br>마나 소모: 26.5" +
                "<br><br><font color='#48AE4A'>운석 낙하에 보너스 적용:</font>" +
                "<br>화염구: 레벨당 화염 피해 +5%" +
                "<br>화염구: 레벨당 화염 피해 +5%" +
                "<br>지옥불: 레벨당 평균 초당 화염 피해 +3%";
    }

    public static String fireSkill9_end(String lv, String c1, String c2, String c3, String c4, String c5, String c6, String c7, String c8, String c9) {
        return "<font color='#48AE4A'>화염 숙련</font>" +
                "<br>지속 효과 - 화염 주문으로 주는 모든 피해가 증가합니다." +
                "<br>최대 레벨 도달" +
                "<br><br>현재 기술 레벨: " + lv +
                "<br>화염 피해: +"+c1+"%";
    }

    public static String fireSkill10_end(String lv, String c1, String c2, String c3, String c4, String c5, String c6, String c7, String c8, String c9) {
        return "<font color='#48AE4A'>히드라</font>" +
                "<br>머리가 여러 개인 화염의 야수를 소환하여" +
                "<br>적을 잿더미로 만듭니다." +
                "<br>최대 레벨 도달" +
                "<br><br>최대 히드라 수: 6마리" +
                "<br>지속시간: 10초" +
                "<br><br>현재 기술 레벨: " + lv +
                "<br>히드라 화염 피해: "+c1+"" +
                "<br>마나 소모: "+c2+"" +
                "<br><br><font color='#48AE4A'>히드라에 보너스 적용:</font>" +
                "<br>화염탄: 레벨당 화염 피해 +3%" +
                "<br>화염구: 레벨당 화염 피해 +3%";
    }

}
