package baseball.utils;

public class ValidationUtil {

  private static final String REG_EXP = "^[1-9]{3}$";

  /**
   * 입력한 텍스트가 게임을 진행하는 조건에 부합하는지 확인
   * @param answer 사용자가 입력한 텍스트
   * @return 해당 조건에 부합할 경우 true, 아닐 경우 false
   */
  public static boolean validateAnswer(final String answer) {

    if (answer == null || answer.length() != 3) return false;

    if (answer.charAt(0) == answer.charAt(1) ||
      answer.charAt(0) == answer.charAt(2) ||
      answer.charAt(1) == answer.charAt(2)) {
      return false;
    }

    if (answer.charAt(0) == 0 ||
      answer.charAt(1) == 0 ||
      answer.charAt(2) == 0) {
      return false;
    }

    return answer.matches(REG_EXP);
  }

  /**
   * 입력한 텍스트가 게임을 다시 시작하는 조건에 부합하는지 확인
   * @param answer 사용자가 입력한 넥스트
   * @return 해당 조건에 부합할 경우 true, 아닐 경우 false
   */
  public static boolean validateAgainAnswer(final String answer) {

    if (!answer.equals("1") && !answer.equals("2")) {
      System.out.println("[ERROR] 잘못된 입력입니다. 다시 입력해주세요.");
      return false;
    }

    return true;
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
    }

    if (index == 2) {
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
