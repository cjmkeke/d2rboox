package com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.sorceress.cold;

public class ColdUpdate {

    public static String coldSkill1(String lv, String c1, String c2, String n1, String n2) {
        return "<font color='#48AE4A'>얼음살</font>" +
                "<br>마법 얼음 화살을 생성하여 적에게 피해를 주고<br>이동 속도를 감소시킵니다." +
                "<br><br>마나 소모: 3" +
                "<br><br>현재 기술 레벨: " + lv +
                "<br>냉기 피해: "+c1+"" +
                "<br>냉기 지속시간: "+c2+"초" +
                "<br><br>다음 레벨" +
                "<br>냉기 피해: "+n1+"" +
                "<br>냉기 지속시간: "+n2+"초" +
                "<br><br><font color='#48AE4A'>얼음살에 보너스 적용:</font>" +
                "<br>서릿발: 레벨당 냉기 피해 +15%" +
                "<br>얼음 작렬: 레벨당 냉기 피해 +15%" +
                "<br>빙하 가시: 레벨당 냉기 피해 +15%" +
                "<br>눈보라: 레벨당 냉기 피해 +15%" +
                "<br>얼음 보주: 레벨당 냉기 피해 +15%";
    }


    public static String coldSkill2(String lv, String c1, String c2, String c3, String n1, String n2, String n3) {
        return "<font color='#48AE4A'>얼어붙은 갑옷</font>" +
                "<br>자신의 방어력을 증가시키고<br>자신을 공격한 적을 빙결시킵니다." +
                "<br><br>마나 소모: 7" +
                "<br><br>현재 기술 레벨: " + lv +
                "<br>방어력: +"+c1+"%" +
                "<br>"+c2+"초 동안 빙결 "+
                "<br>지속시간: "+c3+"초" +
                "<br><br>다음 레벨" +
                "<br>방어력: +"+n1+"%" +
                "<br>"+n2+"초 동안 빙결 "+
                "<br>지속시간: "+n3+"초" +
                "<br><br><font color='#48AE4A'>얼어붙은 갑옷에 보너스 적용:</font>" +
                "<br>오한 갑옷: 레벨당 빙결 지속시간 +5%" +
                "<br>오한 반옥: 레벨당 +10초" +
                "<br>냉기 갑옷: 레벨당 빙결 지속시간 +5%" +
                "<br>냉기 갑옷: 레벨당 +10초";
    }


    public static String coldSkill3(String lv, String c1, String c2, String c3, String n1, String n2, String n3) {
        return "<font color='#48AE4A'>서릿발</font>" +
                "<br>냉기 파장을 방출하여<br>주위의 모든 적에게 피해를 주고<br>이동 속도를 감소시킵니다." +
                "<br><br>현재 기술 레벨: " + lv +
                "<br>냉기 피해: "+c1+"" +
                "<br>냉기 지속시간: "+c2+"초" +
                "<br>마나 소모: "+c3+"" +
                "<br><br>다음 레벨" +
                "<br>냉기 피해: "+n1+"" +
                "<br>냉기 지속시간: "+n2+"초" +
                "<br>마나 소모: "+n3+"" +
                "<br><br><font color='#48AE4A'>서릿발에 보너스 적용:</font>" +
                "<br>눈보라: 레벨당 냉기 피해 +10%" +
                "<br>얼음 보주: 레벨당 냉기 피해 +10%";
    }

    public static String coldSkill4(String lv, String c1, String c2, String c3, String n1, String n2, String n3) {
        return "<font color='#48AE4A'>얼음 작렬</font>" +
                "<br>마법 얼음 구체를 생성하여<br>적에게 피해를 주고 빙결시킵니다." +
                "<br><br>현재 기술 레벨: " + lv +
                "<br>냉기 피해: "+c1+"" +
                "<br>빙결 지속시간: "+c2+"초" +
                "<br>마나 소모: "+c3+"" +
                "<br><br>다음 레벨" +
                "<br>냉기 피해: "+n1+"" +
                "<br>빙결 지속시간: "+n2+"초" +
                "<br>마나 소모: "+n3+"" +
                "<br><br><font color='#48AE4A'>얼음 작렬에 보너스 적용:</font>" +
                "<br>얼음살: 레벨당 냉기 피해 +8%" +
                "<br>빙하 가시: 레벨당 빙결 지속시간 +10%" +
                "<br>눈보라: 레벨당 냉기 피해 +8%" +
                "<br>얼음 보주: 레벨당 냉기 피해 +8%";
    }

    public static String coldSkill5(String lv, String c1, String c2, String c3, String n1, String n2, String n3) {
        return "<font color='#48AE4A'>오한 갑옷</font>" +
                "<br>자신의 방어력을 증가시키고 공격한 적에게 피해를 주고 빙결시킵니다." +
                "<br><br>마나 소모: 11" +
                "<br><br>현재 기술 레벨: " + lv +
                "<br>방어력: +"+c1+"%" +
                "<br>냉기 피해: "+c2+"" +
                "<br>냉기 지속시간: 4초" +
                "<br>지속시간: "+c3+"초" +
                "<br><br>다음 레벨" +
                "<br>방어력: +"+n1+"%" +
                "<br>냉기 피해: "+n2+"" +
                "<br>냉기 지속시간: 4초" +
                "<br>지속시간: "+n3+"초" +
                "<br><br><font color='#48AE4A'>오한 갑옷에 보너스 적용:</font>" +
                "<br>얼어붙은 갑옷: 레벨당 냉기 피해 +9%" +
                "<br>얼어붙은 갑옷: 레벨당 +10초" +
                "<br>냉기 갑옷: 레벨당 냉기 피해 +9%" +
                "<br>냉기 갑옷: 레벨당 +10초";
    }

    public static String coldSkill6(String lv, String c1, String c2, String c3, String n1, String n2, String n3) {
        return "<font color='#48AE4A'>빙하 가시</font>" +
                "<br>마법 얼음 혜성을 생성하여 주위의 적을 빙결시키고 피해를 줍니다." +
                "<br><br>반경: 2.6미터" +
                "<br><br>현재 기술 레벨: " + lv +
                "<br>냉기 피해: "+c1+"" +
                "<br>빙결 지속시간: "+c2+"초" +
                "<br>마나 소모: "+c3+"" +
                "<br><br>다음 레벨" +
                "<br>냉기 피해: "+n1+"" +
                "<br>빙결 지속시간: "+n2+"초" +
                "<br>마나 소모: "+n3+"" +
                "<br><br><font color='#48AE4A'>빙하 가시에 보너스 적용:</font>" +
                "<br>얼음살: 레벨당 냉기 피해 +5%" +
                "<br>얼음 작렬: 레벨당 냉기 피해 +5%" +
                "<br>눈보라: 레벨당 빙결 지속시간 +3%" +
                "<br>얼음 보주: 레벨당 냉기 피해 +5%";
    }

    public static String coldSkill7(String lv, String c1, String c2, String n1, String n2) {
        return "<font color='#48AE4A'>눈보라</font>" +
                "<br>거대한 얼음 조각들을 쏴부어 적을 파괴합니다." +
                "<br><br>시전 지연 시간: 1.8초" +
                "<br>지속시간: 4초" +
                "<br><br>현재 기술 레벨: " + lv +
                "<br>냉기 피해: "+c1+"" +
                "<br>마나 소모: "+c2+"" +
                "<br><br>다음 레벨" +
                "<br>냉기 피해: "+n1+"" +
                "<br>마나 소모: "+n2+"" +
                "<br><br><font color='#48AE4A'>눈보라에 보너스 적용:</font>" +
                "<br>얼음살: 레벨당 냉기 피해 +5%" +
                "<br>얼음 작렬: 레벨당 냉기 피해 +5%" +
                "<br>빙하 가시: 레벨당 냉기 피해 +5%";
    }

    public static String coldSkill8(String lv, String c1, String c2, String c3, String n1, String n2, String n3) {
        return "<font color='#48AE4A'>냉기 갓옷</font>" +
                "<br>방어력이 증가하고 원거리 공격자에게<br>얼음살을 방출하여 보복합니다." +
                "<br><br>마나 소모: 17" +
                "<br><br>현재 기술 레벨: " + lv +
                "<br>방어력: "+c1+"%" +
                "<br>냉기 피해: "+c2+"" +
                "<br>지속시간: "+c3+"초" +
                "<br><br>다음 레벨" +
                "<br>방어력: "+n1+"%" +
                "<br>냉기 피해: "+n2+"" +
                "<br>지속시간: "+n3+"초" +
                "<br><br><font color='#48AE4A'>냉기 갓옷에 보너스 적용:</font>" +
                "<br>얼어붙은 갓옷: 레벨당 냉기 피해 +9%" +
                "<br>얼어붙은 갓옷: 레벨당 +10초" +
                "<br>냉한 갓옷: 레벨당 냉기 피해 +9%" +
                "<br>냉한 갓옷: 레벨당 +10초";
    }

    public static String coldSkill9(String lv, String c1, String c2, String c3, String n1, String n2, String n3) {
        return "<font color='#48AE4A'>얼음 보주</font>" +
                "<br>얼음살을 퍼붓는 마법 구체를 생성하여<br>적을 사멸시킵니다." +
                "<br><br>시전 지연 시간: 1초" +
                "<br><br>현재 기술 레벨: " + lv +
                "<br>냉기 피해: "+c1+"" +
                "<br>냉기 지속시간: "+c2+"초" +
                "<br>마나 소모: "+c3+"" +
                "<br><br>다음 레벨" +
                "<br>냉기 피해: "+n1+"" +
                "<br>냉기 지속시간: "+n2+"초" +
                "<br>마나 소모: "+n3+"" +
                "<br><br><font color='#48AE4A'>얼음 보주에 보너스 적용:</font>" +
                "<br>얼음살: 레벨당 냉기 피해 +2%";
    }

    public static String coldSkill10(String lv, String c1, String n1) {
        return "<font color='#48AE4A'>냉기 속련</font>" +
                "<br>지속 효과 - 적의 냉기 저항을 감소시켜<br>냉기 주문으로 주는 피해가 증가합니다." +
                "<br><br>현재 기술 레벨: " + lv +
                "<br>적의 냉기 저항: -"+c1+"%" +
                "<br><br>다음 레벨" +
                "<br>적의 냉기 저항: -"+n1+"%";
    }

    /*********************************************************************************************************************************************************************************************************/
    /*********************************************************************************************************************************************************************************************************/
    /*********************************************************************************************************************************************************************************************************/

    public static String coldSkill1_end(String lv, String c1, String c2, String c3, String c4, String c5, String c6, String c7, String c8, String c9) {
        return "<font color='#48AE4A'>얼음살</font>" +
                "<br><font color='#A95750'>마법 얼음 화살을 생성하여 적에게 피해를 주고<br>이동 속도를 감소시킵니다." +
                "<br>최대 레벨 도달" +
                "<br><br>마나 소모: 3" +
                "<br><br>현재 기술 레벨: " + lv +
                "<br>냉기 피해: "+c1+"" +
                "<br>냉기 지속시간: "+c2+"초</font>" +
                "<br><br><font color='#48AE4A'>얼음살에 보너스 적용:</font>" +
                "<br><font color='#A95750'>서릿발: 레벨당 냉기 피해 +15%" +
                "<br>얼음 작렬: 레벨당 냉기 피해 +15%" +
                "<br>빙하 가시: 레벨당 냉기 피해 +15%" +
                "<br>눈보라: 레벨당 냉기 피해 +15%" +
                "<br>얼음 보주: 레벨당 냉기 피해 +15%</font>";
    }

    public static String coldSkill2_end(String lv, String c1, String c2, String c3, String c4, String c5, String c6, String c7, String c8, String c9) {
        return "<font color='#48AE4A'>얼어붙은 갑옷</font>" +
                "<br><font color='#A95750'>자신의 방어력을 증가시키고<br>자신을 공격한 적을 빙결시킵니다." +
                "<br>최대 레벨 도달" +
                "<br><br>마나 소모: 7" +
                "<br><br>현재 기술 레벨: " + lv +
                "<br>방어력: +"+c1+"%" +
                "<br>"+c2+"초 동안 빙결"+
                "<br>지속시간: "+c3+"초</font>" +
                "<br><br><font color='#48AE4A'>얼어붙은 갑옷에 보너스 적용:</font>" +
                "<br><font color='#A95750'>오한 갑옷: 레벨당 빙결 지속시간 +5%" +
                "<br>오한 갑옷: 레벨당 +10초" +
                "<br>냉기 갑옷: 레벨당 빙결 지속시간 +5%" +
                "<br>냉기 갑옷: 레벨당 +10초</font>";
    }

    public static String coldSkill3_end(String lv, String c1, String c2, String c3, String c4, String c5, String c6, String c7, String c8, String c9) {
        return "<font color='#48AE4A'>서릿발</font>" +
                "<br><font color='#A95750'>냉기 파장을 방출하여<br>주위의 모든 적에게 피해를 주고<br>이동 속도를 감소시킵니다." +
                "<br>최대 레벨 도달" +
                "<br><br>현재 기술 레벨: " + lv +
                "<br>냉기 피해: "+c1+"" +
                "<br>냉기 지속시간: "+c2+"초" +
                "<br>마나 소모: "+c3+"</font>" +
                "<br><br><font color='#48AE4A'>서릿발에 보너스 적용:</font>" +
                "<br><font color='#A95750'>눈보라: 레벨당 냉기 피해 +10%" +
                "<br>얼음 보주: 레벨당 냉기 피해 +10%</font>";
    }

    public static String coldSkill4_end(String lv, String c1, String c2, String c3, String c4, String c5, String c6, String c7, String c8, String c9) {
        return "<font color='#48AE4A'>얼음 작렬</font>" +
                "<br><font color='#A95750'>마법 얼음 구체를 생성하여<br>적에게 피해를 주고 빙결시킵니다." +
                "<br>최대 레벨 도달" +
                "<br><br>현재 기술 레벨: " + lv +
                "<br>냉기 피해: "+c1+"" +
                "<br>빙결 지속시간: "+c2+"초" +
                "<br>마나 소모: "+c3+"</font>" +
                "<br><br><font color='#48AE4A'>얼음 작렬에 보너스 적용:</font>" +
                "<br><font color='#A95750'>얼음살: 레벨당 냉기 피해 +8%" +
                "<br>빙하 가시: 레벨당 빙결 지속시간 +10%" +
                "<br>눈보라: 레벨당 냉기 피해 +8%" +
                "<br>얼음 보주: 레벨당 냉기 피해 +8%</font>";
    }

    public static String coldSkill5_end(String lv, String c1, String c2, String c3, String c4, String c5, String c6, String c7, String c8, String c9) {
        return "<font color='#48AE4A'>오한 갑옷</font>" +
                "<br><font color='#A95750'>자신의 방어력을 증가시키고<br공격한 적에게 피해를 주고 빙결시킵니다." +
                "<br>최대 레벨 도달" +
                "<br>마나 소모: 11" +
                "<br><br>현재 기술 레벨: " + lv +
                "<br>방어력: +"+c1+"%" +
                "<br>냉기 피해: "+c2+"" +
                "<br>냉기 지속시간: 20초" +
                "<br>지속시간: "+c3+"초</font>" +
                "<br><br><font color='#48AE4A'>오한 갑옷에 보너스 적용:</font>" +
                "<br><font color='#A95750'>얼어붙은 갑옷: 레벨당 냉기 피해 +9%" +
                "<br>얼어붙은 갑옷: 레벨당 +10초" +
                "<br>냉기 갑옷: 레벨당 냉기 피해 +9%" +
                "<br>냉기 갑옷: 레벨당 +10초</font>";
    }


    public static String coldSkill6_end(String lv, String c1, String c2, String c3, String c4, String c5, String c6, String c7, String c8, String c9) {
        return "<font color='#48AE4A'>빙하 가시</font>" +
                "<br><font color='#A95750'>마법 얼음 혜성을 생성하여<br주위의 적을 빙결시키고 피해를 줍니다." +
                "<br>최대 레벨 도달" +
                "<br>반경: 2.6미터" +
                "<br><br>현재 기술 레벨: " + lv +
                "<br>냉기 피해: "+c1+"" +
                "<br>빙결 지속시간: "+c2+"초" +
                "<br>마나 소모: "+c3+"</font>" +
                "<br><br><font color='#48AE4A'>빙하 가시에 보너스 적용:</font>" +
                "<br><font color='#A95750'>얼음살: 레벨당 냉기 피해 +5%" +
                "<br>얼음 작렬: 레벨당 냉기 피해 +5%" +
                "<br>눈보라: 레벨당 빙결 지속시간 +3%" +
                "<br>얼음 보주: 레벨당 냉기 피해 +5%</font>";
    }

    public static String coldSkill7_end(String lv, String c1, String c2, String c3, String c4, String c5, String c6, String c7, String c8, String c9) {
        return "<font color='#48AE4A'>눈보라</font>" +
                "<br><font color='#A95750'>거대한 얼음 조각들을 쏴서 부비며 적을 파괴합니다." +
                "<br>최대 레벨 도달" +
                "<br><br>시전 지역 시간: 1.8초" +
                "<br>지속시간: 4초" +
                "<br><br>현재 기술 레벨: " + lv +
                "<br>냉기 피해: "+c1+"" +
                "<br>마나 소모: "+c2+"</font>" +
                "<br><br><font color='#48AE4A'>눈보라에 보너스 적용:</font>" +
                "<br><font color='#A95750'>얼음살: 레벨당 냉기 피해 +5%" +
                "<br>얼음 작렬: 레벨당 냉기 피해 +5%" +
                "<br>빙하 가시: 레벨당 냉기 피해 +5%</font>";
    }

    public static String coldSkill8_end(String lv, String c1, String c2, String c3, String c4, String c5, String c6, String c7, String c8, String c9) {
        return "<font color='#48AE4A'>냉기 갑옷</font>" +
                "<br><font color='#A95750'>방어력이 증가하고 원거리 공격자에게 얼음살을 방출하여 보복합니다." +
                "<br>최대 레벨 도달" +
                "<br><br>마나 소모: 17" +
                "<br><br>현재 기술 레벨: " + lv +
                "<br>방어력: +"+c1+"%" +
                "<br>냉기 피해: "+c2+"" +
                "<br>지속시간: "+c3+"초</font>" +
                "<br><br><font color='#48AE4A'>냉기 갑옷에 보너스 적용:</font>" +
                "<br><font color='#A95750'>얼어불은 갑옷: 레벨당 냉기 피해 +9%" +
                "<br>얼어불은 가슴: 레벨당 +10초" +
                "<br>오한 갑옷: 레벨당 냉기 피해 +9%" +
                "<br>오한 갑옷: 레벨당 +10초</font>";
    }

    public static String coldSkill9_end(String lv, String c1, String c2, String c3, String c4, String c5, String c6, String c7, String c8, String c9) {
        return "<font color='#48AE4A'>얼음 보주</font>" +
                "<br><font color='#A95750'>얼음살을 퍼붓는 마법 구체를 생성하여<br>적을 사멸시킵니다." +
                "<br>최대 레벨 도달" +
                "<br><br>시전 지연 시간: 1초" +
                "<br><br>현재 기술 레벨: " + lv +
                "<br>냉기 피해: "+c1+"" +
                "<br>냉기 지속시간: "+c2+"초" +
                "<br>마나 소모: "+c3+"</font>" +
                "<br><br><font color='#48AE4A'>얼음 보주에 보너스 적용:</font>" +
                "<br><font color='#A95750'>얼음살: 레벨당 냉기 피해 +2%</font>";
    }

    public static String coldSkill10_end(String lv, String c1, String c2, String c3, String c4, String c5, String c6, String c7, String c8, String c9) {
        return "<font color='#48AE4A'>냉기 숙련</font>" +
                "<br><font color='#A95750'>지속 효과 - 적의 냉기 저항을 감소시켜<br>냉기 주문으로 주는 피해가 증가합니다." +
                "<br>최대 레벨 도달" +
                "<br><br>현재 기술 레벨: " + lv +
                "<br>적의 냉기 저항: -"+c1+"%";
    }


}
