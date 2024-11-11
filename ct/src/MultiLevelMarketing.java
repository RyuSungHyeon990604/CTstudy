import java.util.HashMap;
import java.util.Map;

public class MultiLevelMarketing {
    class Member{
        String name;
        int fee;
        int sal;
        Member invited;
        public Member(String name) {
            this.name = name;
        }
        public void invite(Member member) {
            member.invited = this;
        }
        public void sale(int amt){
            this.sal+=amt * 100 - amt * 10; // 수수료를 제외한 판매익
            if(invited != null){
                invited.payFee(amt * 10);//초대 멤버에게 수수료 지불
            }

        }
        public void payFee(int fee){
            this.fee+=fee - fee/10;// 10%를 제외한 수수료를 내 수수료금액에 넣고
            if(fee /10 != 0 && invited != null)//지불해야할 금액이 0원이 아니라면
                invited.payFee(fee/10);//초대 멤버에게 수수료 지불
        }
        public int getTotalMargin(){
            return sal + fee;
        }
    }
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        Map<String, Member> members = new HashMap<>();
        for(String name : enroll){
            Member member = new Member(name);
            members.put(name, member);
        }
        for(int i = 0; i < referral.length; i++){
            Member member = members.get(referral[i]);
            if(member != null){
                member.invite(members.get(enroll[i]));
            }
        }
        for (int i = 0; i < seller.length; i++){
            Member member = members.get(seller[i]);
            member.sale(amount[i]);
        }
        for (int i = 0; i < answer.length; i++){
            answer[i] = members.get(enroll[i]).getTotalMargin();
        }
        return answer;
    }

    public static void main(String[] args) {
        MultiLevelMarketing obj = new MultiLevelMarketing();
        obj.solution(new String[]{"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"},new String[]{"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"},new String[]{"young", "john", "tod", "emily", "mary"},new int[]{12, 4, 2, 5, 10});
    }
}
