package com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.amazon.javelin;

public class JavelinUpdate {

    /**@apiNote Variable 7 **/
    public static String javelinSkill1(String 레벨, String 현재명중률, String 현재공격력, String 현재마나소모, String 다음명중률, String 다음공격력, String 다음마나소모) {
        return
                "<font color='#48AE4A'>찌르기</font>" +
                        "<br>투창 또는 창 유형의 무기를<br>빠르게 연속으로 찔러 공격합니다." +
                        "<br><br>다중 적중" +
                        "<br><br>현재 기술 레벨: "+레벨+
                        "<br>명중률: +"+현재명중률+"%" +
                        "<br>공격력: "+현재공격력+"%" +
                        "<br>마나 소모: "+현재마나소모+
                        "<br><br>다음 레벨"+
                        "<br>명중률: +"+다음명중률+"%" +
                        "<br>공격력: "+다음공격력+"%" +
                        "<br>마나 소모: "+다음마나소모;

    }
    /**@apiNote Variable 7 **/
    public static String javelinSkill2(String 레벨, String 현재명중률, String 현재번개피해, String 현재마나소모, String 다음명중률, String 다음번개피해, String 다음마나소모) {
        return
                "<font color='#48AE4A'>전기의 일격</font>" +
                        "<br>투창 및 창 유형의 무기에<br>번개 피해를 추가합니다." +
                        "<br><br>현재 기술 레벨: "+레벨+
                        "<br>명중률: +"+현재명중률+"%"+
                        "<br>번개 피해: "+현재번개피해 +
                        "<br>마나 소모: "+현재마나소모 +
                        "<br><br>다음 레벨"+
                        "<br>명중률: +"+다음명중률+"%"+
                        "<br>번개 피해: "+다음번개피해 +
                        "<br>마나 소모: "+다음마나소모 +
                        "<br><br><font color='#48AE4A'>전기의 일격에 보너스 적용:</font>" +
                        "<br>번갯불: 레벨당 번개 피해 +14%" +
                        "<br>전류의 일격: 레벨당 번개 피해 +14%" +
                        "<br>번개의 일격: 레벨당 번개 피해 +14%";
    }

    /**@apiNote Variable 5 **/
    public static String javelinSkill3(String 레벨, String 현재독피해, String 현재초, String 현재마나소모, String 다음독피해, String 다음초, String 다음마나소모) {
        return
                "<font color='#48AE4A'>맹독 투창</font>" +
                        "<br>마법으로 투창을 강화하여<br>독 구름의 흔적을 남기게 합니다." +
                        "<br><br>시전 지연 시간: 0.6초" +
                        "<br><br>현재 기술 레벨: "+레벨+
                        "<br>독 피해: "+현재독피해+
                        "<br>"+현재초+"초에 걸쳐" +
                        "<br>마나 소모: "+현재마나소모+
                        "<br><br>다음 레벨"+
                        "<br>독 피해: "+다음독피해+
                        "<br>"+다음초+"초에 걸쳐" +
                        "<br>마나 소모: "+다음마나소모+
                        "<br><br><font color='#48AE4A'>맹독 투창에 보너스 적용:</font>" +
                        "<br>역병 투창: 레벨당 독 피해 +12%";
    }

    /**@apiNote Variable 7 **/
    public static String javelinSkill4(String 레벨, String 현재공격력, String 현재적감소, String 현재내구도감소, String 다음공격력, String 다음적감소, String 다음내구도감소) {
        return
                "<font color='#48AE4A'>꿰뚫기</font>" +
                        "<br>공격력이 증가하지만 무기가 빠르게 손상됩니다." +
                        "<br><br>항상적중" +
                        "<br>방해받지 않음" +
                        "<br>마나 소모: 3" +
                        "<br><br>현재 기술 레벨: "+레벨+
                        "<br>공격력: +"+현재공격력+"%" +
                        "<br>적 감소: "+현재적감소+"%" +
                        "<br>내구도 감소 확률: "+현재내구도감소+"%"+
                        "<br><br>다음 레벨"+
                        "<br>공격력: +"+다음공격력+"%" +
                        "<br>적 감소: "+다음적감소+"%" +
                        "<br>내구도 감소 확률: "+다음내구도감소+"%";
    }

    /**@apiNote Variable 5 **/
    public static String javelinSkill5(String 레벨, String 현재번개피해, String 현재마나소모, String 다음번개피해, String 다음마나소모) {
        return
                "<font color='#48AE4A'>번갯불</font>" +
                        "<br>마법으로 투창을 번개의 창으로 전환합니다." +
                        "<br><br>무기 공격력 75%" +
                        "<br>100%의 물리 피해를 원소 피해로 전환" +
                        "<br><br>현재 기술 레벨: "+레벨+
                        "<br>번개 피해: "+현재번개피해+
                        "<br>마나 소모: "+현재마나소모+
                        "<br><br>다음 레벨"+
                        "<br>번개 피해: "+다음번개피해+
                        "<br>마나 소모: "+다음마나소모+
                        "<br><br><font color='#48AE4A'>번갯불에 보너스 적용:</font>" +
                        "<br>전기의 일격: 레벨당 번개 피해 +3%" +
                        "<br>전류의 일격: 레벨당 번개 피해 +3%" +
                        "<br>번개의 일격: 레벨당 번개 피해 +3%" +
                        "<br>번개의 격노: 레벨당 번개 피해 +3%";
    }

    /**@apiNote Variable 7 **/
    public static String javelinSkill6(String 레벨, String 현재번개방출, String 현재번개피해, String 현재마나소모, String 다음번개방출, String 다음번개피해, String 다음마나소모) {
        return
                "<font color='#48AE4A'>전류의 일격</font>" +
                        "<br>투창 및 창 유형의 무기에 번개 피해를 추가하고,<br>적중 시 번개 줄기를 방출하게 합니다." +
                        "<br><br>현재 기술 레벨: "+레벨+
                        "<br>번개 줄기 "+현재번개방출+"개 방출" +
                        "<br>번개 피해: "+현재번개피해 +
                        "<br>마나 소모: "+현재마나소모 +
                        "<br><br>다음 레벨"+
                        "<br>번개 줄기 "+다음번개방출+"개 방출" +
                        "<br>번개 피해: "+다음번개피해 +
                        "<br>마나 소모: "+다음마나소모 +
                        "<br><br><font color='#48AE4A'>전류의 일격에 보너스 적용:</font>" +
                        "<br>전기의 일격: 레벨당 번개 피해 +14%" +
                        "<br>번갯불: 레벨당 번개 피해 +14%" +
                        "<br>번개의 일격: 레벨당 번개 피해 +14%";
    }

    /**@apiNote Variable 9 **/
    public static String javelinSkill7(String 레벨, String 현재명중률, String 현재독피해, String 현재초, String 현재마나소모, String 다음명중률, String 다음독피해, String 다음초, String 다음마나소모) {
        return
                "<font color='#48AE4A'>역병 투창</font>" +
                        "<br>마법으로 투창을 강화하여 적중 시<br>점점 커지는 독 구름을 방출하게 합니다." +
                        "<br><br>시전 지연 시간: 1초" +
                        "<br><br>현재 기술 레벨: "+레벨+
                        "<br>명중률: +"+현재명중률+"%" +
                        "<br>독 피해: "+현재독피해 +
                        "<br>"+현재초+"초에 걸쳐" +
                        "<br>마나 소모: "+현재마나소모 +
                        "<br><br>다음 레벨"+
                        "<br>명중률: +"+다음명중률+"%" +
                        "<br>독 피해: "+다음독피해 +
                        "<br>"+다음초+"초에 걸쳐" +
                        "<br>마나 소모: "+다음마나소모 +
                        "<br><br><font color='#48AE4A'>역병 투창에 보너스 적용:</font>" +
                        "<br>맹독 투창: 레벨당 독 피해 +14%";
    }

    /**@apiNote Variable 5 **/
    public static String javelinSkill8(String 레벨, String 현재명중률, String 현재공격력, String 다음명중률, String 다음공격력) {
        return
                "<font color='#48AE4A'>난격</font>" +
                        "<br>인접한 대상을 모두 공격합니다." +
                        "<br><br>마나 소모: 5" +
                        "<br><br>현재 기술 레벨: "+레벨+
                        "<br>명중률: +"+현재명중률+"%" +
                        "<br>공격력: +"+현재공격력+"%"+
                        "<br><br>다음 레벨"+
                        "<br>명중률: +"+다음명중률+"%" +
                        "<br>공격력: +"+다음공격력+"%";
    }

    /**@apiNote Variable 5 **/
    public static String javelinSkill9(String 레벨, String 현재적중, String 현재번개피해, String 다음적중, String 다음번개피해) {
        return
                "<font color='#48AE4A'>번개의 일격</font>" +
                        "<br>투창 및 창 유형의 무기에 번개 피해를 추가하고,<br>적중 시 연쇄 번개를 방출하게 합니다." +
                        "<br><br>마나 소모: 9" +
                        "<br><br>현재 기술 레벨: "+레벨+
                        "<br>"+현재적중+"회 적중" +
                        "<br>번개 피해: "+현재번개피해 +
                        "<br><br>다음 레벨"+
                        "<br>"+다음적중+"회 적중" +
                        "<br>번개 피해: "+다음번개피해 +
                        "<br><br><font color='#48AE4A'>전류의 일격에 보너스 적용:</font>" +
                        "<br>전기의 일격: 레벨당 번개 피해 +11%" +
                        "<br>번갯불: 레벨당 번개 피해 +11%" +
                        "<br>전류의 일격: 레벨당 번개 피해 +11%";
    }

    /**@apiNote Variable 7 **/
    public static String javelinSkill10(String 레벨, String 현재투사체, String 현재번개피해, String 현재마나소모, String 다음투사체, String 다음번개피해, String 다음마나소모) {
        return
                "<font color='#48AE4A'>번개의 격노</font>" +
                        "<br>투척한 투창을 강력한 번개의 창으로 번형하고<br>적중 시 여러 개로 분열시킵니다." +
                        "<br><br>현재 기술 레벨: "+레벨+
                        "<br>투사체 "+현재투사체+"개 방출" +
                        "<br>번개 피해: "+현재번개피해 +
                        "<br>마나 소모: "+현재마나소모 +
                        "<br><br>다음 레벨"+
                        "<br>투사체 "+다음투사체+"개 방출" +
                        "<br>번개 피해: "+다음번개피해 +
                        "<br>마나 소모: "+다음마나소모 +
                        "<br><br><font color='#48AE4A'>번개의 격노에 보너스 적용:</font>" +
                        "<br>전기의 일격: 레벨당 번개 피해 +1%" +
                        "<br>번갯불: 레벨당 번개 피해 +1%" +
                        "<br>전류의 일격: 레벨당 번개 피해 +1%" +
                        "<br>번개의 일격: 레벨당 번개 피해 +1%";
    }


}
