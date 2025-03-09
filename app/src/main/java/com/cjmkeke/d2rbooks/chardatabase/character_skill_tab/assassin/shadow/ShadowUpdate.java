package com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.assassin.shadow;

public class ShadowUpdate {

    public static String shadowSkill1(String 레벨, String 현재명중률, String 현재공격력, String 현재극대화, String 다음명중률, String 다음공격력, String 다음극대화) {
        return
                "<font color='#48AE4A'>손톱 숙련</font>" +
                        "<br>지속 효과 - 손톱 유형 무기의<br>숙련도를 향상 시킵니다." +
                        "<br><br>현재 기술 레벨: "+레벨+
                        "<br>명중률: +"+현재명중률+"%" +
                        "<br>공격력: +"+현재공격력+"%" +
                        "<br>극대화 확률 "+현재극대화+"%"+
                        "<br><br>다음 레벨" +
                        "<br>명중률: +"+다음명중률+"%" +
                        "<br>공격력: +"+다음공격력+"%" +
                        "<br>극대화 확률 "+다음극대화+"%";

    }

    public static String shadowSkill2(String 레벨, String 현재공격력, String 현재마법피해, String 현재마나소모, String 다음공격력, String 다음마법피해, String 다음마나소모) {
        return
                "<font color='#48AE4A'>정신의 망치</font>" +
                        "<br>정신의 힘으로 정신 폭발을 일으켜<br>적을 제압하고 뒤로 밀쳐냅니다." +
                        "<br><br>현재 기술 레벨: "+레벨+
                        "<br>공격력: "+현재공격력 +
                        "<br>마법 피해: "+현재마법피해 +
                        "<br>마나 소모: "+현재마나소모+
                        "<br><br>다음 레벨" +
                        "<br>공격력: "+다음공격력 +
                        "<br>마법 피해: "+다음마법피해 +
                        "<br>마나 소모: "+다음마나소모;
    }


    public static String shadowSkill3(String 레벨, String 현재공격속도, String 현재걷기달리기, String 현재지속시간, String 다음공격속도, String 다음걷기달리기, String 다음지속시간) {
        return
                "<font color='#48AE4A'>폭발적인 속도</font>" +
                        "<br>일정 시간 동안 공격 및 이동 속도가<br>증가합니다." +
                        "<br>요구 레벨: 6" +
                        "<br>마나 소모: 10" +
                        "<br><br>현재 기술 레벨: "+레벨+
                        "<br>공격 속도: +"+현재공격속도+"%" +
                        "<br>걷기/달리기 속도: +"+현재걷기달리기+"%" +
                        "<br>지속시간: "+현재지속시간+"초"+
                        "<br><br>다음 레벨" +
                        "<br>공격 속도: +"+다음공격속도+"%" +
                        "<br>걷기/달리기 속도: +"+다음걷기달리기+"%" +
                        "<br>지속시간: "+다음지속시간+"초";
    }

    public static String shadowSkill4(String 레벨, String 현재확률, String 다음확률) {
        return
                "<font color='#48AE4A'>무기 막기</font>" +
                        "<br>지속 효과 - 쌍수 손톱 유형의 무기를 사용할 때<br>일정 확률로 적의 공격을 막습니다." +
                        "<br>요구 레벨: 12" +
                        "<br><br>현재 기술 레벨: "+레벨+
                        "<br>"+현재확률+"% 확률"+
                        "<br><br>다음 레벨" +
                        "<br>"+다음확률+"% 확률";
    }


    public static String shadowSkill5(String 레벨, String 현재방어력, String 현재적방어력, String 현재지속시간, String 다음방어력, String 다음적방어력, String 다음지속시간) {
        return
                "<font color='#48AE4A'>그림자 망토</font>" +
                        "<br>그림자를 드리워 주위 적의 눈을 멀게 하고<br>일정 시간 동안 대상의 방어력을 감소시킵니다." +
                        "<br>요구 레벨: 12" +
                        "<br><br>범위: 20미터" +
                        "<br>마나 소모: 13" +
                        "<br><br>현재 기술 레벨: "+레벨+
                        "<br>방어력: +"+현재방어력+"%" +
                        "<br>적 방어력: -"+현재적방어력+"%" +
                        "<br>지속시간: "+현재지속시간+"초"+
                        "<br><br>다음 레벨" +
                        "<br>방어력: +"+다음방어력+"%" +
                        "<br>적 방어력: -"+다음적방어력+"%" +
                        "<br>지속시간: "+다음지속시간+"초";

    }

    public static String shadowSkill6(String 레벨, String 현재저주지속시간, String 현재물리피해, String 현재저항, String 현재지속시간, String 다음저주지속시간, String 다음물리피해, String 다음저항, String 다음지속시간) {
        return
                "<font color='#48AE4A'>흐리기</font>" +
                        "<br>일정 시간 동안 모든 저항을 증가시키고<br>저주에 저항합니다." +
                        "<br>요구 레벨: 18" +
                        "<br><br>마나 소모: 10" +
                        "<br><br>현재 기술 레벨: "+레벨+
                        "<br>저주의 지속시간 "+현재저주지속시간+"% 감소" +
                        "<br>받는 물리 피해 "+현재물리피해+"% 감소" +
                        "<br>모든 저항: +"+현재저항+"%" +
                        "<br>지속시간: "+현재지속시간+"초"+
                        "<br><br>다음 레벨" +
                        "<br>저주의 지속시간 "+다음저주지속시간+"% 감소" +
                        "<br>받는 물리 피해 "+다음물리피해+"% 감소" +
                        "<br>모든 저항: +"+다음저항+"%" +
                        "<br>지속시간: "+다음지속시간+"초";
    }

    public static String shadowSkill7(String 레벨, String 현재생명력, String 현재명중률, String 현재방어력, String 현재마나소모, String 다음생명력, String 다음명중률, String 다음방어력, String 다음마나소모) {
        return
                "<font color='#48AE4A'>그림자 전사</font>" +
                        "<br>자신의 그림자를 소환하여<br>자신의 기술을 흉내내며 전투를 돕게 합니다." +
                        "<br>요구 레벨: 18" +
                        "<br><br>시전 지연 시간: 0.6초" +
                        "<br><br>현재 기술 레벨: "+레벨+
                        "<br>생명력: "+현재생명력+
                        "<br>명중률: "+현재명중률 +
                        "<br>방어력: "+현재방어력 + "%"+
                        "<br>마나 소모: "+현재마나소모+
                        "<br><br>다음 레벨" +
                        "<br>생명력: "+다음생명력 +
                        "<br>명중률: "+다음명중률 +
                        "<br>방어력: "+다음방어력 + "%"+
                        "<br>마나 소모: "+다음마나소모;
    }

    public static String shadowSkill8(String 레벨, String 현재공격력, String 현재기절시간, String 현재전향, String 다음공격력, String 다음기절시간, String 다음전향) {
        return
                "<font color='#48AE4A'>정신 폭발</font>" +
                        "<br>정신의 힘을 사용하여<br>적 무리를 기절시키고<br>정신력이 약한 대상을 전향시킵니다." +
                        "<br>요구 레벨: 24" +
                        "<br><br>지속시간: 6-10초" +
                        "<br>마나 소모: 15" +
                        "<br><br>현재 기술 레벨: "+레벨+
                        "<br>공격력: "+현재공격력 +
                        "<br>기절 시속시간: "+현재기절시간+"초" +
                        "<br>전향 확률: "+현재전향+"%"+
                        "<br><br>다음 레벨" +
                        "<br>공격력: "+다음공격력+
                        "<br>기절 시속시간: "+다음기절시간+"초" +
                        "<br>전향 확률: "+다음전향+"%";
    }

    public static String shadowSkill9(String 레벨, String 현재독피해, String 현재지속시간, String 다음독피해, String 다음지속시간) {
        return
                "<font color='#48AE4A'>맹독</font>" +
                        "<br>무기에 독 피해를 추가합니다." +
                        "<br>요구 레벨: 30" +
                        "<br><br>마나 소모: 12" +
                        "<br><br>현재 기술 레벨: "+레벨+
                        "<br>독 피해: "+현재독피해 +
                        "<br>0.4초에 걸쳐" +
                        "<br>지속시간: "+현재지속시간+"초"+
                        "<br><br>다음 레벨" +
                        "<br>독 피해: "+다음독피해 +
                        "<br>0.4초에 걸쳐" +
                        "<br>지속시간: "+다음지속시간+"초";
    }

    public static String shadowSkill10(String 레벨, String 현재생명력, String 현재명중률, String 현재모든저항, String 현재마나소모, String 다음생명력, String 다음명중률, String 다음모든저항, String 다음마나소모) {
        return
                "<font color='#48AE4A'>자신의 강한 그림자를 소환하여<br>전투를 돕게합니다.</font>" +
                        "<br>요구 레벨: 30" +
                        "<br><br>시전 지연 시간: 0.6초" +
                        "<br><br>현재 기술 레벨: "+레벨+
                        "<br>생명력: "+현재생명력 +
                        "<br>명중률: "+현재명중률 +
                        "<br>모든 저항: +"+현재모든저항+"%" +
                        "<br>마나 소모: "+현재마나소모+
                        "<br><br>다음 레벨" +
                        "<br>생명력: "+다음생명력 +
                        "<br>명중률: "+다음명중률 +
                        "<br>모든 저항: +"+다음모든저항+"%" +
                        "<br>마나 소모: "+다음마나소모;
    }


}
