package com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.paladins.offensive;

public class OffensiveUpdate {

    public static String offensiveSkill1(String 레벨, String 현재공격력, String 다음공격력, String 다음반경, String 현재반경) {
        return
                "<font color='#48AE4A'>위세</font>" +
                        "<br>오로라를 활성화하면 자신과 파티원의<br>공격력이 증가합니다." +
                        "<br><br>현재 기술 레벨: " + 레벨 +
                        "<br>공격력: " + 현재공격력 +
                        "<br>반경: " + 현재반경 +
                        "<br><br>다음 레벨" +
                        "<br>공격력:" + 다음공격력 +
                        "<br>반경: " + 다음반경;
    }

    public static String offensiveSkill2(String 레벨, String 현재화염피해공격시, String 현재화염피해, String 현재반경, String 다음화염피해공격시, String 다음화염피해,  String 다음반경, String 보너스1, String 보너스2) {
        return
                "<font color='#48AE4A'>신성한 불꽃</font>" +
                        "<br>오로라를 활성화하면 천상의 불길로<br>주위의 적에게 피해를 주고<br>공격에 화염 피해를 추가합니다." +
                        "<br><br>대상과 가까울수록 광역 피해 증가" +
                        "<br><br>현재 기술 레벨: " + 레벨 +
                        "<br>화염 피해: 공격 시 " + 현재화염피해공격시 +
                        "<br>화염 피해: " + 현재화염피해 +
                        "<br>반경: " + 현재반경 + "미터" +
                        "<br><br>다음 레벨" +
                        "<br>화염 피해: 공격 시 " + 다음화염피해공격시 +
                        "<br>화염 피해: " + 다음화염피해 +
                        "<br>반경: " + 다음반경 + "미터" +
                        "<br><br><font color='#48AE4A'>신성한 불꽃에 보너스 적용:</font>" +
                        "<br>화염 저항: 레벨당 화염 피해 +" + 보너스1 + "%" +
                        "<br>구원: 레벨당 화염 피해 +" + 보너스2 + "%";
    }


    public static String offensiveSkill3(String 레벨, String 현재피해반사, String 현재피해, String 현재반경, String 다음피해반사, String 다음피해, String 다음반경) {
        return
                "<font color='#48AE4A'>가시</font>" +
                        "<br>오로라를 활성화하면 자신과 파티원이<br>받는 근접 피해를 적에게 반사합니다." +
                        "<br><br>현재 기술 레벨: " + 레벨 +
                        "<br>" + 현재피해반사 + "의 피해를 반사" +
                        "<br>공격자가 피해를 " + 현재피해 + " 받음" +
                        "<br>반경: " + 현재반경 + "미터" +
                        "<br><br>다음 레벨" +
                        "<br>" + 다음피해반사 + "의 피해를 반사" +
                        "<br>공격자가 피해를 " + 다음피해 + " 받음" +
                        "<br>반경: " + 다음반경 + "미터";
    }

    public static String offensiveSkill4(String 레벨, String 현재활성화, String 현재지속효과, String 현재반경, String 다음활성화, String 다음지속효과, String 다음반경) {
        return
                "<font color='#48AE4A'>축복받은 조준</font>" +
                        "<br>오로라를 활성화하면 자신과 파티원의<br>명중률이 증가합니다." +
                        "<br><br>현재 기술 레벨: " + 레벨 +
                        "<br>명중률: +" + 현재활성화 + "% (활성화)" +
                        "<br>명중률: +" + 현재지속효과 + "% (지속 효과)" +
                        "<br>반경: " + 현재반경 + "미터" +
                        "<br><br>다음 레벨" +
                        "<br>명중률: +" + 다음활성화 + "% (활성화)" +
                        "<br>명중률: +" + 다음지속효과 + "% (지속 효과)" +
                        "<br>반경: " + 다음반경 + "미터";
    }


    public static String offensiveSkill5(String 레벨, String 현재방해불가확률, String 현재공격력, String 현재반경 , String 다음공격력, String 다음반경) {
        return
                "<font color='#48AE4A'>집중</font>" +
                        "<br>오로라를 활성화하면 자신과 파티원의<br>공격력이 증가하고 공격이<br>방해받을 확률이 감소합니다." +
                        "<br><br>방해 불가 확률: " + 현재방해불가확률 + "%" +
                        "<br><br>현재 기술 레벨: " + 레벨 +
                        "<br>공격력: +" + 현재공격력 + "%" +
                        "<br>반경: " + 현재반경 + "미터" +
                        "<br><br>다음 레벨" +
                        "<br>공격력: +" + 다음공격력 + "%" +
                        "<br>반경: " + 다음반경 + "미터";
    }

    public static String offensiveSkill6(String 레벨, String 현재공격시냉기피해, String 현재냉기피해, String 현재적이동속도, String 현재반경, String 다음공격시냉기피해, String 다음냉기피해, String 다음적이동속도, String 다음반경, String 보너스1, String 보너스2) {
        return
                "<font color='#48AE4A'>신성한 빙결</font>" +
                        "<br>오로라를 활성화하면 주위의 괴물을 빙결시키고<br>공격에 냉기 피해를 추가합니다." +
                        "<br><br>대상과 가까울수록 광역 피해 증가" +
                        "<br><br>현재 기술 레벨: " + 레벨 +
                        "<br>냉기 피해: 공격 시 " + 현재공격시냉기피해 +
                        "<br>냉기 피해: " + 현재냉기피해 +
                        "<br>적의 이동 속도 " + 현재적이동속도 + "% 감소" +
                        "<br>반경: " + 현재반경 + "미터" +
                        "<br><br>다음 레벨" +
                        "<br>냉기 피해: 공격 시 " + 다음공격시냉기피해 +
                        "<br>냉기 피해: " + 다음냉기피해 +
                        "<br>적의 이동 속도 " + 다음적이동속도 + "% 감소" +
                        "<br>반경: " + 다음반경 + "미터" +
                        "<br><br><font color='#48AE4A'>신성한 빙결에 보너스 적용:</font>" +
                        "<br>냉기 저항: 레벨당 냉기 피해 +" + 보너스1 + "%" +
                        "<br>구원: 레벨당 화염 피해 +" + 보너스2 + "%";
    }

    public static String offensiveSkill7(String 레벨, String 현재공격시번개, String 현재공격피해, String 현재반경, String 다음공격시번개, String 다음공격피해, String 다음반경, String 보너스1, String 보너스2) {
        return
                "<font color='#48AE4A'>신성한 충격</font>" +
                        "<br>오로라를 활성화하면 전기 파동을 방출하여<br>주위의 적에게 피해를 주고<br>공격에 번개 피해를 추가합니다." +
                        "<br><br>대상과 가까울수록 광역 피해 증가" +
                        "<br><br>현재 기술 레벨: " + 레벨 +
                        "<br>번개 피해: 공격 시 " + 현재공격시번개 +
                        "<br>번개 피해: " + 현재공격피해 +
                        "<br>반경: " + 현재반경 + "미터" +
                        "<br><br>다음 레벨" +
                        "<br>번개 피해: 공격 시 " + 다음공격시번개 +
                        "<br>번개 피해: " + 다음공격피해 +
                        "<br>반경: " + 다음반경 + "미터" +
                        "<br><br><font color='#48AE4A'>신성한 충격에 보너스 적용:</font>" +
                        "<br>번개 저항: 레벨당 번개 피해 +" + 보너스1 + "%" +
                        "<br>구원: 레벨당 번개 피해 +" + 보너스2 + "%";
    }

    public static String offensiveSkill8(String 레벨, String 현재언데드피해, String 현재마법피해, String 현재반경, String 다음언데드피해, String 다음마법피해, String 다음반경, String 보너스1) {
        return
                "<font color='#48AE4A'>성역</font>" +
                        "<br>오로라를 활성화하면 언데드에게 피해를 주고<br>뒤로 밀쳐냅니다." +
                        "<br><br>대상과 가까울수록 광역 피해 증가" +
                        "<br><br>현재 기술 레벨: " + 레벨 +
                        "<br>언데드에게 주는 피해: +" + 현재언데드피해 + "%" +
                        "<br>마법 피해: " + 현재마법피해 +
                        "<br>반경: " + 현재반경 + "미터" +
                        "<br><br>다음 레벨" +
                        "<br>언데드에게 주는 피해: +" + 다음언데드피해 + "%" +
                        "<br>마법 피해: " + 다음마법피해 +
                        "<br>반경: " + 다음반경 + "미터" +
                        "<br><br><font color='#48AE4A'>성역에 보너스 적용:</font>" +
                        "<br>정화: 레벨당 마법 피해 +" + 보너스1 + "%";
    }

    public static String offensiveSkill9(String 레벨, String 현재명중률, String 현재내공격력, String 현재파티공격력, String 현재공격속도, String 현재반경, String 다음명중률, String 다음내공격력, String 다음파티공격력, String 다음공격속도, String 다음반경) {
        return
                "<font color='#48AE4A'>광신</font>" +
                        "<br>오로라를 활성화하면 자신과 파티원의<br>공격력, 공격 속도, 명줄률이 증가합니다." +
                        "<br><br>현재 기술 레벨: " + 레벨 +
                        "<br>명중률: +" + 현재명중률 + "%" +
                        "<br>내 공격력: +" + 현재내공격력 + "%" +
                        "<br>파티 공격력: +" + 현재파티공격력 + "%" +
                        "<br>공격 속도: +" + 현재공격속도 + "%" +
                        "<br>반경: " + 현재반경 + "미터"+
                        "<br><br>다음 레벨"+
                        "<br>명중률: +" + 다음명중률 + "%" +
                        "<br>내 공격력: +" + 다음내공격력 + "%" +
                        "<br>파티 공격력: +" + 다음파티공격력 + "%" +
                        "<br>공격 속도: +" + 다음공격속도 + "%" +
                        "<br>반경: " + 다음반경 + "미터";
    }

    public static String offensiveSkill10(String 레벨, String 현재방어력, String 현재모든저항, String 현재반경, String 다음방어력, String 다음모든저항, String 다음반경) {
        return
                "<font color='#48AE4A'>선고</font>" +
                        "<br>오로라를 활성화하면 주위 적의<br>방어력과 저항이 감소합니다." +
                        "<br><br>현재 기술 레벨: "+레벨 +
                        "<br>방어력: -"+현재방어력+"%" +
                        "<br>모든 저항: -"+현재모든저항+"%" +
                        "<br>반경: "+현재반경+"미터"+
                        "<br><br>다음 레벨"+
                        "<br>방어력: -"+다음방어력+"%" +
                        "<br>모든 저항: -"+다음모든저항+"%" +
                        "<br>반경: "+다음반경+"미터";
    }


}
