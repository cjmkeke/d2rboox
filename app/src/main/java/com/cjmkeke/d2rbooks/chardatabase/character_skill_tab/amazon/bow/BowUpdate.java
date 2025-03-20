package com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.amazon.bow;

public class BowUpdate {

    public static String bowSkill1(String 레벨, String 현재물리피해, String 현재명중률, String 현재공격력, String 현재마나소모, String 다음물리피해, String 다음명중률, String 다음공격력, String 다음마나소모) {
        return
                "<font color='#48AE4A'>마법 화살</font>" +
                        "<br>추가 피해를 주는<br>마법 화살을 생성합니다." +
                        "<br><br>현재 기술 레벨: "+레벨+
                        "<br>"+현재물리피해+"%의 물리 피해를 마법 피해로 전환" +
                        "<br>명중률: +"+현재명중률+"%" +
                        "<br>공격력: +"+현재공격력+
                        "<br>마나 소모: "+현재마나소모+
                        "<br><br>다음 레벨"+
                        "<br>"+다음물리피해+"%의 물리 피해를 마법 피해로 전환" +
                        "<br>명중률: +"+다음명중률+"%" +
                        "<br>공격력: +"+다음공격력+
                        "<br>마나 소모: "+다음마나소모;

    }

    public static String bowSkill2(String 레벨, String 현재옵션1, String 현재옵션2, String 현재옵션3, String 현재옵션4, String 다음옵션1, String 다음옵션2, String 다음옵션3, String 다음옵션4) {
        return
                "<font color='#48AE4A'>불꽃 화살</font>" +
                        "<br>마법으로 화살을 강화하여<br>화염 피해를 줍니다." +
                        "<br><br>현재 기술 레벨: "+레벨+
                        "<br>"+현재옵션1+"%의 물리 피해를 원소 피해로 전환" +
                        "<br>명중률: +"+현재옵션2+"%" +
                        "<br>화염 피해: "+현재옵션3 +
                        "<br>마나 소모: "+현재옵션4 +
                        "<br><br><font color='#48AE4A'>불꽃 화살에 보너스 적용:</font>" +
                        "<br>폭팔 화살: 레벨당 화염 피해 +12%"+
                        "<br><br>다음 레벨"+
                        "<br>"+다음옵션1+"%의 물리 피해를 원소 피해로 전환" +
                        "<br>명중률: +"+다음옵션2+"%" +
                        "<br>화염 피해: "+다음옵션3 +
                        "<br>마나 소모: "+다음옵션4 +
                        "<br><br><font color='#48AE4A'>불꽃 화살에 보너스 적용:</font>" +
                        "<br>폭팔 화살: 레벨당 화염 피해 +12%";
    }


    public static String bowSkill3(String 레벨, String 현재옵션1, String 현재옵션2, String 현재옵션3, String 현재옵션4, String 현재옵션5, String 다음옵션1, String 다음옵션2, String 다음옵션3, String 다음옵션4, String 다음옵션5) {
        return
                "<font color='#48AE4A'>냉기 화살</font>" +
                        "<br>마법으로 화살을 강화하여<br>냉기 피해와 감속 효과를 추가합니다.<br>냉기 화살은 일반 피해의 절반에 해당하는 피해를 줍니다." +
                        "<br><br>현재 기술 레벨: "+레벨+
                        "<br>"+현재옵션1+"%의 물리 피해를 원소 피해로 전환" +
                        "<br>명중률: +"+현재옵션2+"%" +
                        "<br>냉기 피해: "+현재옵션3+
                        "<br>냉기 지속시간: "+현재옵션4+"초" +
                        "<br>마나 소모: "+현재옵션5+
                        "<br><br>다음 레벨"+
                        "<br>"+다음옵션1+"%의 물리 피해를 원소 피해로 전환" +
                        "<br>명중률: +"+다음옵션2+"%" +
                        "<br>냉기 피해: "+다음옵션3+
                        "<br>냉기 지속시간: "+다음옵션4+"초" +
                        "<br>마나 소모: "+다음옵션5+
                        "<br><br><font color='#48AE4A'>냉기 화살에 보너스 적용:</font>" +
                        "<br>얼음 화살: 레벨당 냉기 피해 +12%";
    }

    public static String bowSkill4(String 레벨, String 현재옵션1, String 현재옵션2, String 다음옵션1, String 다음옵션2) {
        return
                "<font color='#48AE4A'>다발 사격</font>" +
                        "<br>마법으로 하나의 화살을<br>여 개로 분열시킵니다." +
                        "<br><br>무기 공격력 75%" +
                        "<br><br>현재 기술 레벨: "+레벨+
                        "<br>화살 "+현재옵션1+"개" +
                        "<br>마나 소모: "+현재옵션2+
                        "<br><br>다음 레벨"+
                        "<br>화살 "+다음옵션1+"개" +
                        "<br>마나 소모: "+다음옵션2+
                        "<br><br><font color='#48AE4A'>다발 사격에 보너스 적용:</font>" +
                        "<br>유도 화살: 레벨당 피해 +12%";
    }


    public static String bowSkill5(String 레벨, String 현재옵1, String 현재옵2, String 현재옵3, String 다음옵1, String 다음옵2, String 다음옵3) {
        return
                "<font color='#48AE4A'>폭팔 화살</font>" +
                        "<br>화살을 강화하여 접촉 시 폭발을 일으키고<br>주위의 모든 적에게 피해를 줍니다." +
                        "<br><br>현재 기술 레벨: "+레벨+
                        "<br>명중률: +"+현재옵1+"%" +
                        "<br>화염 피해: "+현재옵2+
                        "<br>마나 소모: "+현재옵3+
                        "<br><br>다음 레벨"+
                        "<br>명중률: +"+다음옵1+"%" +
                        "<br>화염 피해: "+다음옵2+
                        "<br>마나 소모: "+다음옵3+
                        "<br><br><font color='#48AE4A'>폭팔 화살에 보너스 적용:</font>" +
                        "<br>불꽃 화살: 레벨당 화염 피해 +14%";
    }

    public static String bowSkill6(String 레벨, String 현재옵1, String 현재옵2, String 현재옵3, String 현재옵4, String 다음옵1, String 다음옵2, String 다음옵3, String 다음옵4) {
        return
                "<font color='#48AE4A'>얼음 화살</font>" +
                        "<br>마법으로 화살을 강화하여<br>적을 빙결시킵니다." +
                        "<br><br>현재 기술 레벨: "+레벨+
                        "<br>명중률: +"+현재옵1+"%" +
                        "<br>냉기 피해: "+현재옵2 +
                        "<br>"+현재옵3+"초 동안 빙결" +
                        "<br>마나 소모: "+현재옵4 +
                        "<br><br>다음 레벨"+
                        "<br>명중률: +"+다음옵1+"%" +
                        "<br>냉기 피해: "+다음옵2 +
                        "<br>"+다음옵3+"초 동안 빙결" +
                        "<br>마나 소모: "+다음옵4 +
                        "<br><br><font color='#48AE4A'>얼음 화살에 보너스 적용:</font>" +
                        "<br>냉기 화살: 레벨당 냉기 피해 +8%" +
                        "<br>빙결 화살: 레벨당 빙결 지속시간 +5%";
    }

    public static String bowSkill7(String 레벨, String 현재1, String 현재2, String 다음1, String 다음2) {
        return
                "<font color='#48AE4A'>유도 화살</font>" +
                        "<br>화살을 강화하여 대상 또는 다른 적을<br>추적하게 합니다." +
                        "<br><br>항상 적중" +
                        "<br><br>현재 기술 레벨: "+레벨+
                        "<br>공격력: +"+현재1+"%" +
                        "<br>마나 소모: "+현재2 +
                        "<br><br>다음 레벨"+
                        "<br>공격력: +"+다음1+"%" +
                        "<br>마나 소모: "+다음2 +
                        "<br><br><font color='#48AE4A'>유도 화살에 보너스 적용:</font>" +
                        "<br>다발 사격: 레벨당 피해 +12%";
    }

    public static String bowSkill8(String 레벨, String 현1, String 현2, String 현3, String 다1, String 다2, String 다3) {
        return
                "<font color='#48AE4A'>속사</font>" +
                        "<br>마법으로 하나의 화살을 여러 개로 분열시켜<br>주위의 적 다수를 공격합니다." +
                        "<br><br>마나 소모: 11" +
                        "<br><br>현재 기술 레벨: "+레벨+
                        "<br>명중률: +"+현1+"%" +
                        "<br>최대 "+현2+"명의 대상을 공격" +
                        "<br>공격력: +"+현3+"%" +
                        "<br><br>다음 레벨"+
                        "<br>명중률: +"+다1+"%" +
                        "<br>최대 "+다2+"명의 대상을 공격" +
                        "<br>공격력: +"+다3+"%" +
                        "<br><br><font color='#48AE4A'>속사에 보너스 적용:</font>" +
                        "<br>다발 사격: 레벨당 피해 +5%"+
                        "<br>유도 화살: 레벨당 피해 +10%";
    }

    public static String bowSkill9(String 레벨, String 현1, String 현2, String 현3, String 현4, String 현5, String 다1, String 다2, String 다3, String 다4, String 다5) {
        return
                "<font color='#48AE4A'>점화 화살</font>" +
                        "<br>화살을 강화하여<br>큰 화염 피해를 주고<br>적중 시 거대한 불길을 생성합니다." +
                        "<br><br>시전 지연 시간: 0.6초" +
                        "<br><br>현재 기술 레벨: "+레벨+
                        "<br>명중률: +"+현1+"%" +
                        "<br>화염 폭발 피해: "+현2 +
                        "<br>평균 화염 피해: 초당 "+현3  +
                        "<br>화염 지속시간: "+현4+"초" +
                        "<br>마나 소모: "+현5 +
                        "<br><br>다음 레벨"+
                        "<br>명중률: +"+다1+"%" +
                        "<br>화염 폭발 피해: "+다2 +
                        "<br>평균 화염 피해: 초당 "+다3  +
                        "<br>화염 지속시간: "+다4+"초" +
                        "<br>마나 소모: "+다5 +
                        "<br><br><font color='#48AE4A'>점화 화살에 보너스 적용:</font>" +
                        "<br>불꽃 화살: 레벨당 평균 초당 화염 피해 +5%"+
                        "<br>폭발 화살: 레벨당 화염 피해 +10%";
    }

    public static String bowSkill10(String 레벨, String 현1, String 현2, String 현3, String 현4, String 다1, String 다2, String 다3, String 다4) {
        return
                "<font color='#48AE4A'>빙결 화살</font>" +
                        "<br>마법으로 화살을 강화하여<br>적 두무리를 모두 빙결시킵니다." +
                        "<br><br>반경: 3.3미터" +
                        "<br><br>현재 기술 레벨: "+레벨+
                        "<br>명중률: +"+현1+"%" +
                        "<br>냉기 피해: "+현2 +
                        "<br>"+현3+"초 동안 빙결" +
                        "<br>마나 소모: "+현4 +
                        "<br><br>다음 레벨"+
                        "<br>명중률: +"+다1+"%" +
                        "<br>냉기 피해: "+다2 +
                        "<br>"+다3+"초 동안 빙결" +
                        "<br>마나 소모: "+다4 +
                        "<br><br><font color='#48AE4A'>빙결 화살에 보너스 적용:</font>" +
                        "<br>냉기 화살: 레벨당 냉기 피해 +12%" +
                        "<br>얼음 화살: 레벨당 빙결 지속시간 +5%";

    }


}
