package com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.amazon.passive;

public class PassiveUpdate {

    public static String passiveSkill1(String 레벨, String 자신에게피해, String 현재명중률, String 현재공격력, String 다음명중률, String 다음공격력) {
        return
                "<font color='#48AE4A'>희생</font>" +
                        "<br>생명력을 희생하여<br>명중률과 공격력을 증가시킵니다." +
                        "<br><br>자신에게 "+자신에게피해+"%의 피해" +
                        "<br><br>현재 기술 레벨: " + 레벨 +
                        "<br>명중률: +"+현재명중률+"%" +
                        "<br>공격력: + "+현재공격력+"%" +
                        "<br><br>다음 레벨" +
                        "<br>명중률: +"+다음명중률+"%" +
                        "<br>공격력: + "+다음공격력+"%" +
                        "<br><br><font color='#48AE4A'>희생에 보너스 적용:</font>" +
                        "<br>속죄: 레벨당 피해 +15%" +
                        "<br>광신: 레벨당 피해 +5%";

    }

    public static String passiveSkill2(String 레벨, String 현재공격력, String 현재기절지속시간, String 다음공격력, String 다음기절지속시간) {
        return
                "<font color='#48AE4A'>강타</font>" +
                        "<br>적을 방패로 강타하여<br>일시적으로 기절시킵니다." +
                        "<br><br>항상 적중" +
                        "<br>마나 소모: 2" +
                        "<br><br>현재 기술 레벨: " + 레벨 +
                        "<br>공격력: +"+현재공격력+"%" +
                        "<br>기절 지속시간: "+현재기절지속시간+"초" +
                        "<br><br>다음 레벨"+
                        "<br>공격력: +"+다음공격력+"%" +
                        "<br>기절 지속시간: "+다음기절지속시간+"초";
    }


    public static String passiveSkill3(String 레벨, String 현재마법피해, String 현재치유, String 현재마나소모, String 다음마법피해, String 다음치유, String 다음마나소모) {
        return
                "<font color='#48AE4A'>신성한 빛줄기</font>" +
                        "<br>신성한 마력으로<br>악마 및 언데드에게 피해를 주고<br>아군을 치유합니다." +
                        "<br><br>현재 기술 레벨: " + 레벨 +
                        "<br>마법 피해: "+현재마법피해+"" +
                        "<br>치유: "+현재치유+"" +
                        "<br>마나 소모: "+현재마나소모+"" +
                        "<br><br>다음 레벨" +
                        "<br>마법 피해: "+다음마법피해+"" +
                        "<br>치유: "+다음치유+"" +
                        "<br>마나 소모: "+다음마나소모+"" +
                        "<br><br><font color='#48AE4A'>신성한 빛줄기에 보너스 적용:</font>" +
                        "<br>천상의 주먹: 레벨당 마법 피해 +50%" +
                        "<br>기도: 레벨당 생명력 치유 +20%";
    }

    public static String passiveSkill4(String 레벨, String 현재적중, String 현재적중률, String 현재공격력, String 다음적중, String 다음적중률, String 다음공격력) {
        return
                "<font color='#48AE4A'>열의</font>" +
                        "<br>한 번의 공격으로<br>인접한 다수의 적을 공격합니다." +
                        "<br><br>마나 소모: 2" +
                        "<br><br>현재 기술 레벨: " + 레벨 +
                        "<br>"+현재적중+"회 적중" +
                        "<br>적중률: +"+현재적중률+"%" +
                        "<br>공격력: +"+현재공격력+"%" +
                        "<br><br>다음 레벨" +
                        "<br>"+다음적중+"회 적중" +
                        "<br>적중률: +"+다음적중률+"%" +
                        "<br>공격력: +"+다음공격력+"%" +
                        "<br><br><font color='#48AE4A'>열의에 보너스 적용:</font>" +
                        "<br>희생: 레벨당 피해 +12%";
    }


    public static String passiveSkill5(String 레벨, String 현재명중률, String 현재공격력, String 다음명중률, String 다음공격력) {
        return
                "<font color='#48AE4A'>돌진</font>" +
                        "<br>적에게 돌진하여 공격합니다." +
                        "<br><br>마나 소모: 9" +
                        "<br><br>현재 기술 레벨: " + 레벨 +
                        "<br>명중률: +"+현재명중률+"%" +
                        "<br>공격력: +"+현재공격력+"%" +
                        "<br><br>다음 레벨" +
                        "<br>명중률: +"+다음명중률+"%" +
                        "<br>공격력: +"+다음공격력+"%" +
                        "<br><br><font color='#48AE4A'>돌진에 보너스 적용:</font>" +
                        "<br>원기: 레벨당 피해 +20%" +
                        "<br>위세: 레벨당 피해 +20%";
    }

    public static String passiveSkill6(String 레벨, String 현재명중률, String 현재화염피해, String 현재냉기피해, String 현재냉기지속시간, String 현재번개피해, String 현재마나소모, String 다음명중률, String 다음화염피해, String 다음냉기피해, String 다음냉기지속시간, String 다음번개피해, String 다음마나소모) {
        return
                "<font color='#48AE4A'>복수</font>" +
                        "<br>공격이 적중할 때마다<br>화염, 번개, 냉기 피해가 추가됩니다." +
                        "<br><br>현재 기술 레벨: " + 레벨 +
                        "<br>명중률: +"+현재명중률+"%" +
                        "<br>화염 피해: +"+현재화염피해+"%" +
                        "<br>냉기 피해: +"+현재냉기피해+"%" +
                        "<br>냉기 지속시간: "+현재냉기지속시간+"초" +
                        "<br>번개 피해: +"+현재번개피해+"%" +
                        "<br>마나 소모: "+현재마나소모+"" +
                        "<br><br>다음 레벨" +
                        "<br>명중률: +"+다음명중률+"%" +
                        "<br>화염 피해: +"+다음화염피해+"%" +
                        "<br>냉기 피해: +"+다음냉기피해+"%" +
                        "<br>냉기 지속시간: "+다음냉기지속시간+"초" +
                        "<br>번개 피해: +"+다음번개피해+"%" +
                        "<br>마나 소모: "+다음마나소모+"" +
                        "<br><br><font color='#48AE4A'>복수에 보너스 적용:</font>" +
                        "<br>화염 저항: 레벨당 화염 피해 +10%" +
                        "<br>냉기 저항: 레벨당 냉기 피해 +10%" +
                        "<br>번개 저항: 레벨당 번개 피해 +10%" +
                        "<br>구원: 레벨당 원소 피해 +2%";
    }

    public static String passiveSkill7(String 레벨, String 현재마법피해, String 현재마나소모, String 다음마법피해, String 다음마나소모) {
        return
                "<font color='#48AE4A'>축복받은 망치</font>" +
                        "<br>소용돌이를 그리며 뻗어 나가는<br>무형의 망치를 소환하여 적중한 적에게 피해를 줍니다." +
                        "<br><br>언데드에게 주는 피해: +50%" +
                        "<br><br>현재 기술 레벨: " + 레벨 +
                        "<br>마법 피해: "+현재마법피해 +
                        "<br>마나 소모: "+현재마나소모 +
                        "<br><br>다음 레벨" +
                        "<br>마법 피해: "+다음마법피해 +
                        "<br>마나 소모: "+다음마나소모 +
                        "<br><br><font color='#48AE4A'>축복받은 망치에 보너스 적용:</font>" +
                        "<br>축복받은 조준: 레벨당 마법 피해 +14%" +
                        "<br>원기: 레벨당 마법 피해 +14%";
    }

    public static String passiveSkill8(String 레벨, String 현재전향확률, String 다음전향확률) {
        return
                "<font color='#48AE4A'>전향</font>" +
                        "<br>괴물을 전향시켜 다른 사악한 악마와 야수에<br>맞서 싸우게 합니다." +
                        "<br><br>지속시간: 16초" +
                        "<br>마나 소모: 4" +
                        "<br><br>현재 기술 레벨: " + 레벨 +
                        "<br>전향 확률: "+현재전향확률+"%"+
                        "<br><br>다음 레벨" +
                        "<br>전향 확률: "+다음전향확률+"%";
    }

    public static String passiveSkill9(String 레벨, String 현재강타피해, String 현재방어력, String 현재막기성공확률, String 현재지속시간, String 다음강타피해, String 다음방어력, String 다음막기성공확률, String 다음지속시간) {
        return
                "<font color='#48AE4A'>신성한 방패</font>" +
                        "<br>신성한 힘으로 방패를 강화합니다." +
                        "<br><br>마나 소모: 35" +
                        "<br><br>현재 기술 레벨: " + 레벨 +
                        "<br>강타 피해: +"+현재강타피해 +
                        "<br>방어력: +"+현재방어력+"%" +
                        "<br>막기 성공 확률: +"+현재막기성공확률+"%" +
                        "<br>지속시간: "+현재지속시간+"초" +
                        "<br><br>다음 레벨" +
                        "<br>강타 피해: +"+다음강타피해 +
                        "<br>방어력: +"+다음방어력+"%" +
                        "<br>막기 성공 확률: +"+다음막기성공확률+"%" +
                        "<br>지속시간: "+다음지속시간+"초" +
                        "<br><br><font color='#48AE4A'>신성한 방패에 보너스 적용:</font>" +
                        "<br>인내: 레벨당 방어력 +15%";
    }

    public static String passiveSkill10(String 레벨, String 현재번개피해, String 현재신성한빛줄기피해, String 다음번개피해, String 다음신성한빛줄기피해) {
        return
                "<font color='#48AE4A'>천상의 주먹</font>" +
                        "<br>번개로 대상을 강타하여 피해를 주고<br>대상 주위의 적에게 신성한 빛줄기가 퍼져 나갑니다." +
                        "<br><br>시전 지연 시간: 0.4초" +
                        "<br>마나 소모: 25" +
                        "<br><br>현재 기술 레벨: " + 레벨 +
                        "<br>번개 피해: "+현재번개피해 +
                        "<br>신성한 빛줄기 피해: "+현재신성한빛줄기피해 +
                        "<br><br>다음 레벨" +
                        "<br>번개 피해: "+다음번개피해 +
                        "<br>신성한 빛줄기 피해: "+다음신성한빛줄기피해 +
                        "<br><br><font color='#48AE4A'>천상의 주먹에 보너스 적용:</font>" +
                        "<br>신성한 빛줄기: 레벨당 신성한 빛줄기 피해 +15%" +
                        "<br>신성한 충격: 레벨당 번개 피해 +7%";
    }


}
