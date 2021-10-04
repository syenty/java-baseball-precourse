package baseball;

import baseball.utils.GameUtil;

import nextstep.utils.Console;

public class Application {

  public static int[] computerArray = new int[3];

  public static void main(String[] args) {

    String answer;

    GameUtil.setRandomArray(computerArray);

    System.out.print("숫자를 입력해주세요 : ");
    answer = Console.readLine();

    while (!GameUtil.isFinish(computerArray, answer)) {
      System.out.print("숫자를 입력해주세요 : ");
      answer = Console.readLine();
    }
  }

}
