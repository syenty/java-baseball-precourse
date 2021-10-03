package baseball;

public class Application {

    private static final String REG_EXP = "^[1-9]{3}$";

    public static void main(String[] args) {

        // TODO 숫자 야구 게임 구현
        boolean isFinish = false;
        int[] computerArray = new int[3];
        int[] playerArray = new int[3];
    }

    /**
     * 입력한 숫자가 0을 포함하지 않는 3자리의 숫자인지 확인
     * @param answer 사용자가 입력한 숫자
     * @return 해당 조건에 부합할 경우 true, 아닐 경우 false
     */
    public static boolean validateAnswer(final String answer) {

        if (answer == null) return false;

        return answer.matches(REG_EXP);
    }

    /**
     * 배열 안에 중복되는 숫자가 있는지 확인
     * 진행 중인 index를 확인해 0일 경우 반드시 false를 return (index가 0일 경우 중복이 일어날 수 없다.)
     * @param array 대상 배열
     * @param number 대상 숫자
     * @param index 숫자 입력을 진행 중인 index
     * @return 중복되는 숫자가 있다면 true, 없다면 false
     */
    public static boolean isDuplicateNumberInArray(final int[] array,
                                                   final int number,
                                                   final int index) {

        if (index == 1) {
            return array[0] == number || array[1] == number;
        } else if (index == 2) {
            return array[0] == number || array[1] == number || array[2] == number;
        }

        return false;
    }

    /**
     * 대상 배열이 0을 포함하고 있는지 확인
     * @param array 대상 배열
     * @return 0을 포함하고 있지 않으면 true, 포함한다면 false
     */
    public static boolean hasNotZero(final int[] array) {
        return array[0] != 0 && array[1] != 0 && array[2] != 0;
    }

}
