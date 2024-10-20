import java.util.HashMap;
import java.util.Map;

public class SaleEvent {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> wants = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wants.put(want[i], number[i]);
        }

        for (int i = 0; i <= discount.length - 10; i++) {
            Map<String, Integer> discounts = new HashMap<>();

            for (int j = i; j < i + 10; j++) {
                discounts.put(discount[j], discounts.getOrDefault(discount[j], 0) + 1);
            }

            boolean can = true;
            for (String product : wants.keySet()) {
                if (discounts.getOrDefault(product, 0) != wants.get(product)) {
                    can = false;
                    break;
                }
            }

            if (can) {
                answer++;
            }
        }

        return answer;
    }

}
