package baseball.utils;

import nextstep.utils.Randoms;

public class GameUtil {

  /**
   * 게임을 진행을 위한 메서드
   * 생성된 3자리 난수와 사용자가 입력한 값을 비교하고 결과를 출력한다
   * @param computerArray 게임 시작 시 생성된 3자리 난수
   * @param answer 사용자가 입력한 값
   * @return
   */
  public static boolean isFinish(final int[] computerArray,
                                 final String answer) {

    int[] playerArray = new int[3];
    int strikeCount = 0;
    int ballCount = 0;

    if (!ValidationUtil.validateAnswer(answer)) {
      System.out.println("[ERROR] 잘못된 입력입니다. 다시 입력해주세요.");
      return false;
    }

    for(int i=0; i<answer.length(); i++) {
      playerArray[i] = Character.getNumericValue(answer.charAt(i));
    }

    for(int i=0; i<playerArray.length; i++) {
      strikeCount += getStrikeCount(computerArray, playerArray[i], i);
      ballCount += getBallCount(computerArray, playerArray[i], i);
    }

    System.out.println(getResultMessage(strikeCount, ballCount));

    return false;
  }

  /**
   * 길이가 3인 배열을 받아 해당 배열을 중복되지 않는 1~9 중 3개를 담은 배열로 만든다
   * @param array 숫자를 담을 배열
   */
  public static void setRandomArray(final int[] array) {

    if (array.length != 3) return;

    int index = 0;

    while(index < 3 && !ValidationUtil.hasNotZero(array)) {
      array[index] = getDistinctNumber(array, index);
      index++;
    }
  }

  /**
   * 배열을 확인해 중복되지 않는 숫자를 반환
   * @param array 대상 배열
   * @param index 숫자 입력을 진행 중인 index
   * @return 대상 배열에 없는 1~9 사이의 숫자
   */
  public static int getDistinctNumber(final int[] array,
                                      final int index) {

    int number;

    do {
      number = Randoms.pickNumberInRange(1,9);
    } while(ValidationUtil.isDuplicateNumberInArray(array, number, index));

    return number;
  }

  /**
   * 생성된 난수와 사용자의 입력값을 비교해 스트라이크인지 확인하고 결과값을 반환
   * @param computerArray 생성된 난수 배열
   * @param playerNumber 사용자의 입력한 숫자의 인덱스 값
   * @param index 사용자의 입력한 숫자의 인덱스
   * @return 스트라이크일 경우 1, 아닐 경우 0
   */
  public static int getStrikeCount(final int[] computerArray,
                                   final int playerNumber,
                                   final int index) {

    if (computerArray[index] == playerNumber) {
      return 1;
    }

    return 0;
  }

  /**
   * 생성된 난수와 사용자의 입력값을 비교해 볼인지 확인하고 결과값을 반환
   * @param computerArray 생성된 난수 배열
   * @param playerNumber 사용자의 입력한 숫자의 인덱스 값
   * @param index 사용자의 입력한 숫자의 인덱스
   * @return 볼일 경우 1, 아닐 경우 0
   */
  public static int getBallCount(final int[] computerArray,
                                 final int playerNumber,
                                 final int index) {

    if (computerArray[(index+1)%3] == playerNumber || computerArray[(index+2)%3] == playerNumber) {
      return 1;
    }

    return 0;
  }

  /**
   * 스트라이크와 볼의 카운트값을 받아 적합한 결과 메시지 반환
   * @param strike 스트라이크 카운트
   * @param ball 볼 카운트
   * @return 결과 메시지
   */
  public static String getResultMessage(final int strike,
                                        final int ball) {

    StringBuilder sb = new StringBuilder();

    if (strike > 0) {
      sb.append(strike);
      sb.append("스트라이크 ");
    }

    if (ball > 0) {
      sb.append(ball);
      sb.append("볼");
    }

    if (strike == 0 && ball == 0) {
      sb.append("낫싱");
    }

    return sb.toString();
  }

}
