package com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.amazon.passive;

public class PassiveUpdate {

    public static String passiveSkill1(String 레벨, String 현재적방어력, String 현재지속시간, String 다음적방어력, String 다음지속시간) {
        return
                "<font color='#48AE4A'>내면의 시야</font>" +
                        "<br>주위의 적에게 빛을 비춰 자신과 파티원의<br>적중률을 향상시킵니다." +
                        "<br><br>반경: 18미터" +
                        "<br>마나 소모: 5" +
                        "<br><br>현재 기술 레벨 : "+레벨+
                        "<br>적 방어력: -"+현재적방어력+
                        "<br>지속시간: "+현재지속시간+"초"+
                        "<br><br>다음 레벨"+
                        "<br>적 방어력: -"+다음적방어력+
                        "<br>지속시간: "+다음지속시간+"초";

    }

    public static String passiveSkill2(String 레벨, String 현재확률, String 다음확률) {
        return
                "<font color='#48AE4A'>치명타</font>" +
                        "<br>지속 효과 - 공격할 때 일정 확률로 2배의 피해를 줍니다." +
                        "<br><br>현재 기술 레벨 : "+레벨+
                        "<br>"+현재확률+"% 확률"+
                        "<br><br>다음 레벨"+
                        "<br>"+다음확률+"% 확률";
    }


    public static String passiveSkill3(String 레벨, String 현재확률, String 다음확률) {
        return
                "<font color='#48AE4A'>흘리기</font>" +
                        "<br>지속 효과 - 공격하거나 가만히 서 있을때<br>일정 확룰로 근접 공격을 흘려 냅니다." +
                        "<br><br>현재 기술 레벨 : "+레벨+
                        "<br>"+현재확률+"% 확률"+
                        "<br><br>다음 레벨"+
                        "<br>"+다음확률+"% 확률";
    }

    public static String passiveSkill4(String 레벨, String 현재투사체, String 현재물리피해, String 현재지속시간, String 다음투사체, String 다음물리피해, String 다음지속시간) {
        return
                "<font color='#48AE4A'>투사체 감속</font>" +
                        "<br>주위의 적에게 빛을 비추고 대상의 투사체 속도를 감소시킵니다." +
                        "<br><br>반경: 18미터" +
                        "<br>마나 소모: 5" +
                        "<br><br>현재 기술 레벨 : "+레벨+
                        "<br>투사체 속도가 "+현재투사체+"%로 감소" +
                        "<br>받는 물리 피해 "+현재물리피해+"% 감소" +
                        "<br>지속시간: "+현재지속시간+"초"+
                        "<br><br>다음 레벨"+
                        "<br>투사체 속도가 "+다음투사체+"%로 감소" +
                        "<br>받는 물리 피해 "+다음물리피해+"% 감소" +
                        "<br>지속시간: "+다음지속시간+"초";
    }


    public static String passiveSkill5(String 레벨, String 현재확률, String 다음확률) {
        return
                "<font color='#48AE4A'>회피</font>" +
                        "<br>지속 효과 - 공격하거나 가만히 서 있을때<br>일정 확률로 적의 투사체를 회피합니다." +
                        "<br><br>현재 기술 레벨 : "+레벨+
                        "<br>"+현재확률+"% 확률"+
                        "<br><br>다음 레벨"+
                        "<br>"+다음확률+"% 확률";
    }

    public static String passiveSkill6(String 레벨, String 현재명중률, String 다음명중률) {
        return
                "<font color='#48AE4A'>간파</font>" +
                        "<br>지속 효과 - 명중률이 증가합니다." +
                        "<br>요구 레벨: 18" +
                        "<br><br>현재 기술 레벨 : "+레벨+
                        "<br>명중률: +"+현재명중률+"%"+
                        "<br><br>다음 레벨"+
                        "<br>명중률: +"+다음명중률+"%";
    }

    public static String passiveSkill7(String 레벨, String 현재생명력, String 현재지속시간, String 현재마나소모, String 다음생명력, String 다음지속시간, String 다음마나소모) {
        return
                "<font color='#48AE4A'>미끼</font>" +
                        "<br>자신의 복제물을 만들어<br>적의 공격을 유도합니다." +
                        "<br><br>현재 기술 레벨 : "+레벨+
                        "<br>생명력: +"+현재생명력+"%" +
                        "<br>지속시간: "+현재지속시간+"초" +
                        "<br>마나 소모: "+현재마나소모+
                        "<br><br>다음 레벨"+
                        "<br>생명력: +"+다음생명력+"%" +
                        "<br>지속시간: "+다음지속시간+"초" +
                        "<br>마나 소모: "+다음마나소모;
    }

    public static String passiveSkill8(String 레벨, String 현재확률, String 다음확률) {
        return
                "<font color='#48AE4A'>피하기</font>" +
                        "<br>지속 효과 - 걷거나 뛰고 있을 때<br>일정 확률로 근접 또는 투사체 공격을 회피합니다." +
                        "<br><br>현재 기술 레벨 : "+레벨+
                        "<br>"+현재확률+"% 확률"+
                        "<br><br>다음 레벨"+
                        "<br>"+다음확률+"% 확률";
    }

    public static String passiveSkill9(String 레벨, String 현재생명력, String 현재명중률, String 현재공격력, String 현재방어력, String 현재마나소모, String 다음생명력, String 다음명중률, String 다음공격력, String 다음방어력, String 다음마나소모) {
        return
                "<font color='#48AE4A'>발키리</font>" +
                        "<br>강력한 발키리 동료를 소환합니다." +
                        "<br><br>시전 지연 시간: 0.6초" +
                        "<br><br>현재 기술 레벨 : "+레벨+
                        "<br>생명력: "+현재생명력 +
                        "<br>명중률: +"+현재명중률+"%" +
                        "<br>공격력: +"+현재공격력+"%" +
                        "<br>방어력: +"+현재방어력+"%" +
                        "<br>마나 소모: "+현재마나소모 +
                        "<br><br>다음 레벨"+
                        "<br>생명력: "+다음생명력 +
                        "<br>명중률: +"+다음명중률+"%" +
                        "<br>공격력: +"+다음공격력+"%" +
                        "<br>방어력: +"+다음방어력+"%" +
                        "<br>마나 소모: "+다음마나소모 +
                        "<br><br><font color='#48AE4A'>발키리에 보너스 적용:</font>" +
                        "<br>미끼: 레벨당 생명력 +20%"+
                        "<br>간파: 레벨당 생명력 +40%"+
                        "<br>치명타"+
                        "<br>흘리기"+
                        "<br>회피"+
                        "<br>피하기";
    }

    public static String passiveSkill10(String 레벨, String 현재확률, String 다음확률) {
        return
                "<font color='#48AE4A'>관통</font>" +
                        "<br>지속 효과 - 투사체가 일정 확률로<br>적중한 적을 관통합니다." +
                        "<br><br>현재 기술 레벨 : "+레벨+
                        "<br>"+현재확률+"% 확률"+
                        "<br><br>다음 레벨"+
                        "<br>"+다음확률+"% 확률";
    }


}
