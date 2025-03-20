package com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.paladins.defense;

public class DefenseUpdate {

    public static String defenseSkill1(String 레벨, String 현재마나소모, String 현재치유, String 현재반경, String 다음마나소모, String 다음치유, String 다음반경){
        return
                "<font color='#48AE4A'>기도</font>" +
                "<br>오로라를 활성화하면 자신과 파티원의<br>생명력이 서서히 회복됩니다." +
                "<br><br>현재 기술 레벨: +"+레벨+ // 변경됨 1에서 2
                "<br>치유: +"+현재마나소모 + // 변경 2에서 3
                "<br>반경: "+현재치유+"미터"+ // 10.6미터에서 12미터
                "<br>마나 소모: 초당 "+현재반경+ // 초당 1에서 1.1
                "<br><br>다음 레벨"+
                "<br>치유: +"+다음마나소모+ // 변경 3에서 4
                "<br>반경: "+다음치유+"미터"+ // 12미터에서 13.3미터
                "<br>마나 소모: 초당 "+다음반경; // 초당 1.1에서 1.3
    }

    public static String defenseSkill2(String 레벨, String 현재화염저항, String 현재화염저항활성화, String 현재화염저항지속효과, String 현재반경, String 다음화염저항, String 다음화염저항활성화, String 다음화염저항지속효과, String 다음반경){
        return
                "<font color='#48AE4A'>화염 저항</font>" +
                        "<br>오로라를 활성화하면 자신과 파티원이<br>받는 화염 피해가 감소합니다." +
                        "<br><br>현재 기술 레벨: +"+레벨+ // 변경됨 1에서 2
                        "<br>화염 저항:: +"+현재화염저항 + // 변경 2에서 3
                        "<br>최대 화염 저항: +"+현재화염저항활성화 +"% ( 활성화)"+ // 변경 2에서 3
                        "<br>최대 화염 저항: "+현재화염저항지속효과+"% ( 지속효과)"+ // 10.6미터에서 12미터
                        "<br>반경: "+현재반경+"미터"+ // 초당 1에서 1.1
                        "<br><br>다음 레벨" +
                        "<br>화염 저항: +"+다음화염저항+ // 변경 3에서 4
                        "<br>최대 화염 저항: "+다음화염저항활성화+"% ( 활성화)"+ // 12미터에서 13.3미터
                        "<br>최대 화염 저항:: "+다음화염저항지속효과+"% ( 지속효과)"+  // 12미터에서 13.3미터
                        "<br>반경: "+다음반경+"미터"; // 초당 1.1에서 1.3
    }

    public static String defenseSkill3(String 레벨, String 현재방어력, String 현재반경, String 다음방어력, String 다음반경){
        return
                "<font color='#48AE4A'>인내</font>" +
                        "<br>오로라를 활성화하면 자신과 파티원의<br>방어력이 증가합니다." +
                        "<br><br>현재 기술 레벨: "+레벨+
                        "<br>방어력: +"+현재방어력 +"%"+
                        "<br>반경: "+현재반경+"미터"+
                        "<br><br>다음 레벨" +
                        "<br>방어력: +"+다음방어력+ "%"+
                        "<br>반경: "+다음반경+"미터";
    }

    public static String defenseSkill4(String 레벨, String 현재냉기저항, String 현재냉기저항활성화, String 현재냉기저항지속효과, String 현재반경, String 다음냉기저항, String 다음냉기저항활성화, String 다음냉기저황지속화, String 다음반경){
        return
                "<font color='#48AE4A'>냉기 저항</font>" +
                        "<br>오로라를 활성화하면 자신과 파티원이<br>받는 냉기 피해가 감소합니다." +
                        "<br><br>현재 기술 레벨: "+레벨+
                        "<br>냉기 저항: +"+현재냉기저항+"%"+
                        "<br>최대 냉기 저항: +"+현재냉기저항활성화+"%(활성화)"+
                        "<br>최대 냉기 저항: +" +현재냉기저항지속효과+"%(지속 효과)"+
                        "<br>반경: "+현재반경+"미터"+
                        "<br><br>다음 레벨"+
                        "<br>냉기 저항: +"+다음냉기저항+"%"+
                        "<br>최대 냉기 저항: +"+다음냉기저항활성화+"%(활성화)"+
                        "<br>최대 냉기 저항: +"+다음냉기저황지속화+"%(지속 효과)"+
                        "<br>반경: "+다음반경 +"미터";
    }

    public static String defenseSkill5(String 레벨, String 생명력치유, String 현재지속시간, String 현재반경, String 다음지속시간, String 다음반경){
        return
                "<font color='#48AE4A'>정화</font>" +
                        "<br>오로라를 활성화하면 자신과 파티원에게<br>걸린 독 또는 저주의 지속시간이 감소합니다." +
                        "<br><br>기도: 2초마다 생명력 치유 +"+생명력치유+
                        "<br><br>현재 기술 레벨: "+레벨+
                        "<br>지속시간: "+현재지속시간+ "% 감소"+
                        "<br>반경: "+현재반경+
                        "<br><br>다음 레벨"+
                        "<br>지속시간: "+다음지속시간+ "% 감소"+
                        "<br>반경: "+다음반경 +"미터" +
                        "<br><br><font color='#48AE4A'>정화에 보너스 적용 :</font>" +
                        "<br>기도";
    }

    public static String defenseSkill6(String 레벨, String 현재번개저항, String 현재번개저항활성화, String 현재번개저항지속효과, String 현재반경, String 다음번개저항, String 다음번개저항활성화, String 다음번개저황지속화, String 다음반경){
        return
                "<font color='#48AE4A'>번개 저항</font>" +
                        "<br>오로라를 활성화하면 자신과 파티원이<br>받는 번개 피해가 감소합니다." +
                        "<br><br>현재 기술 레벨: "+레벨+
                        "<br>번개 저항: +"+현재번개저항+
                        "<br>최대 번개 저항: +"+현재번개저항활성화+"(활성화)"+
                        "<br>최대 번개 저항: +" +현재번개저항지속효과+"(지속 효과)"+
                        "<br>반경: "+현재반경+
                        "<br><br>다음 레벨"+
                        "<br>번개 저항: +"+다음번개저항+
                        "<br>최대 번개 저항: +"+다음번개저항활성화+"(활성화)"+
                        "<br>최대 번개 저항: +"+다음번개저황지속화+"(지속 효과)"+
                        "<br>반경: "+다음반경 +"미터";
    }

    public static String defenseSkill7(String 레벨, String 현재걷기달리기, String 현재지구력, String 현재지구력회복속도, String 현재반경, String 다음걷기달리기, String 다음지구력, String 다음지구력회복속도, String 다음반경){
        return
                "<font color='#48AE4A'>원기</font>" +
                        "<br>오로라를 활성화하면 자신과 파티원의<br>지구력 회복 속도, 최대 지구력, 이동 속도가 증가합니다." +
                        "<br><br>현재 기술 레벨: "+레벨+
                        "<br>걷기/달리기 속도: +"+현재걷기달리기+ "%"+
                        "<br>최대 지구력: +"+현재지구력+ "%"+
                        "<br>지구력 회복 속도: +"+현재지구력회복속도+ "%"+
                        "<br>반경: +"+현재반경+ "미터"+
                        "<br><br>다음 레벨"+
                        "<br>걷기/달리기 속도: +"+다음걷기달리기+ "%"+
                        "<br>최대 지구력: +"+다음지구력+ "%"+
                        "<br>지구력 회복 속도: +"+다음지구력회복속도+ "%"+
                        "<br>반경: +"+다음반경+"미터";
    }

    public static String defenseSkill8(String 레벨, String 치유, String 현재마나회복속도, String 현재반경, String 다음마나회복속도, String 다음반경){
        return
                "<font color='#48AE4A'>명상</font>" +
                        "<br>오로라를 활성화 하면 자신과 파티원의<br>마나 회복 속도가 증가합니다." +
                        "<br><br>기도: 2초마다 생명력 치유 +"+치유+
                        "<br><br>현재 기술 레벨: "+레벨+
                        "<br>마나 회복 속도: +"+현재마나회복속도+
                        "<br>반경: +"+현재반경+
                        "<br><br>다음 레벨"+
                        "<br>마나 회복 속도: +"+다음마나회복속도+
                        "<br>반경: "+다음반경 +"미터"+
                        "<br><br><font color='#48AE4A'>명상에 보너스 적용:</font>"+
                        "<br><font color='#FFFFFFFF'>기도</font>";
    }


    public static String defenseSkill9(String 레벨, String 현재반경, String 현재속죄확률, String 현재생마회복, String 다음속죄확률, String 다음생마회복){
        return
                "<font color='#48AE4A'>속죄</font>" +
                        "<br>오로라를 활성화하면 처치한 적의 영혼을<br>구원하여 자신의 생명력과 마나를 회복합니다." +
                        "<br><br>반경: "+현재반경+"미터"+
                        "<br><br>현재 기술 레벨: "+레벨+
                        "<br>영혼 속죄 확률: +"+현재속죄확률+ "%"+
                        "<br>생명력/마나 회복: +"+현재생마회복+
                        "<br><br>다음 레벨"+
                        "<br>영혼 속죄 확률: +"+다음속죄확률+ "%"+
                        "<br>생명력/마나 회복: "+다음생마회복;
    }

    public static String defenseSkill10(String 레벨, String 현재모든저항, String 현재반경, String 다음모든저항, String 다음반경){
        return
                "<font color='#48AE4A'>구원</font>" +
                        "<br>오로라를 활성화하면 자신과 파티원이<br>받는 화염, 냉기, 번개 피해가 감소합니다." +
                        "<br><br>현재 기술 레벨: "+레벨+
                        "<br>모든 저항: +"+현재모든저항+ "%"+
                        "<br>반경: +"+현재반경+"미터"+
                        "<br><br>다음 레벨"+
                        "<br>모든 저항: +"+다음모든저항+ "%"+
                        "<br>반경: "+다음반경+"미터";
    }

}
