package org.fuckboi

import org.parboiled.errors.ParsingException

class LogicalTest extends FuckboiGeneratorTest {
  it should "False Or True Evaluate True" in {
    val code = "NETFLIX\n" +
      "YO var\n" +
      "ASL? 0\n" +
      "HEY var\n" +
      "TINDER 0\n" +
      "DAMN GIRL 1\n" +
      "BYE\n" +
      "IS IT TOO LATE NOW TO SAY SORRY? var\n" +
      "CHILL\n"
    getOutput(code) should equal("1\n")
  }


  it should "True Or False Evaluate True" in {
    val code = "NETFLIX\n" +
      "YO var\n" +
      "ASL? @I LIED\n" +
      "HEY var\n" +
      "TINDER @FINALLY THE TRUTH\n" +
      "DAMN GIRL @I LIED\n" +
      "BYE\n" +
      "IS IT TOO LATE NOW TO SAY SORRY? var\n" +
      "CHILL\n"
    getOutput(code) should equal("1\n")
  }

  it should "True Or True Evaluate True" in {
    val code = "NETFLIX\n" +
      "YO var\n" +
      "ASL? @I LIED\n" +
      "HEY var\n" +
      "TINDER @FINALLY THE TRUTH\n" +
      "DAMN GIRL @FINALLY THE TRUTH\n" +
      "BYE\n" +
      "IS IT TOO LATE NOW TO SAY SORRY? var\n" +
      "CHILL\n"
    getOutput(code) should equal("1\n")
  }

  it should "False Or False Evaluate False" in {
    val code = "NETFLIX\n" +
      "YO var\n" +
      "ASL? @I LIED\n" +
      "HEY var\n" +
      "TINDER @I LIED\n" +
      "DAMN GIRL @I LIED\n" +
      "BYE\n" +
      "IS IT TOO LATE NOW TO SAY SORRY? var\n" +
      "CHILL\n"
    getOutput(code) should equal("0\n")
  }

  it should "False And True Evaluate False" in {
    val code = "NETFLIX\n" +
      "YO var\n" +
      "ASL? @I LIED\n" +
      "HEY var\n" +
      "TINDER @I LIED\n" +
      "KNOCK KNOCK @FINALLY THE TRUTH\n" +
      "BYE\n" +
      "IS IT TOO LATE NOW TO SAY SORRY? var\n" +
      "CHILL\n"
    getOutput(code) should equal("0\n")
  }

  it should "True And False Evaluate False" in {
    val code = "NETFLIX\n" +
      "YO var\n" +
      "ASL? @I LIED\n" +
      "HEY var\n" +
      "TINDER @FINALLY THE TRUTH\n" +
      "KNOCK KNOCK @I LIED\n" +
      "BYE\n" +
      "IS IT TOO LATE NOW TO SAY SORRY? var\n" +
      "CHILL\n"
    getOutput(code) should equal("0\n")
  }

  it should "True And True Evaluate True" in {
    val code = "NETFLIX\n" +
      "YO var\n" +
      "ASL? @I LIED\n" +
      "HEY var\n" +
      "TINDER @FINALLY THE TRUTH\n" +
      "KNOCK KNOCK @FINALLY THE TRUTH\n" +
      "BYE\n" +
      "IS IT TOO LATE NOW TO SAY SORRY? var\n" +
      "CHILL\n"
    getOutput(code) should equal("1\n")
  }

  it should "True and True and False evaluates False" in {
    val code =
    "NETFLIX\n" +
    "YO var\n" +
    "ASL? @I LIED\n" +
    "HEY var\n" +
    "TINDER 1\n" +
    "KNOCK KNOCK 1\n" +
    "KNOCK KNOCK 0\n" +
    "BYE\n" +
    "IS IT TOO LATE NOW TO SAY SORRY? var\n" +
    "CHILL\n"
    getOutput(code) should equal("0\n")
  }

  it should "True and True and True evaluates False" in {
    val code =
    "NETFLIX\n" +
    "YO var\n" +
    "ASL? @I LIED\n" +
    "HEY var\n" +
    "TINDER 1\n" +
    "KNOCK KNOCK 1\n" +
    "KNOCK KNOCK 1\n" +
    "BYE\n" +
    "IS IT TOO LATE NOW TO SAY SORRY? var\n" +
    "CHILL\n"
    getOutput(code) should equal("1\n")
  }

    it should "True and True and True and True and False evaluates False" in {
    val code =
    "NETFLIX\n" +
    "YO var\n" +
    "ASL? @I LIED\n" +
    "HEY var\n" +
    "TINDER @FINALLY THE TRUTH\n" +
    "KNOCK KNOCK @FINALLY THE TRUTH\n" +
    "KNOCK KNOCK @FINALLY THE TRUTH\n" +
    "KNOCK KNOCK @FINALLY THE TRUTH\n" +
    "KNOCK KNOCK @I LIED\n" +
    "BYE\n" +
    "IS IT TOO LATE NOW TO SAY SORRY? var\n" +
    "CHILL\n"
    getOutput(code) should equal("0\n")
  }

    it should "False or False or False evaluates False" in {
    val code =
    "NETFLIX\n" +
    "YO var\n" +
    "ASL? @I LIED\n" +
    "HEY var\n" +
    "TINDER @I LIED\n" +
    "DAMN GIRL @I LIED\n" +
    "DAMN GIRL @I LIED\n" +
    "BYE\n" +
    "IS IT TOO LATE NOW TO SAY SORRY? var\n" +
    "CHILL\n"
    getOutput(code) should equal("0\n")
  }

    it should "False or True and False evaluates False" in {
    val code =
    "NETFLIX\n" +
    "YO var\n" +
    "ASL? @I LIED\n" +
    "HEY var\n" +
    "TINDER @I LIED\n" +
    "DAMN GIRL @FINALLY THE TRUTH\n" +
    "KNOCK KNOCK @I LIED\n" +
    "BYE\n" +
    "IS IT TOO LATE NOW TO SAY SORRY? var\n" +
    "CHILL\n"
    getOutput(code) should equal("0\n")
  }

  it should "False And False Evaluate False" in {
    val code = "NETFLIX\n" +
      "YO var\n" +
      "ASL? @I LIED\n" +
      "HEY var\n" +
      "TINDER @I LIED\n" +
      "KNOCK KNOCK @I LIED\n" +
      "BYE\n" +
      "IS IT TOO LATE NOW TO SAY SORRY? var\n" +
      "CHILL\n"
    getOutput(code) should equal("0\n")
  }

  it should "False Equals False evaluates True" in {
    val code =
      "NETFLIX\n" +
        "YO varfalse\n" +
        "ASL? @I LIED\n" +
        "YO varfalse2\n" +
        "ASL? @I LIED\n" +
        "HEY varfalse\n" +
        "TINDER @I LIED\n" +
        "B'FUL varfalse2\n" +
        "BYE\n" +
        "IS IT TOO LATE NOW TO SAY SORRY? varfalse\n" +
        "CHILL\n"
    getOutput(code) should equal("1\n")
  }
  it should "True Equals False evaluates False" in {
    val code =
      "NETFLIX\n" +
        "YO varfalse\n" +
        "ASL? @I LIED\n" +
        "YO result\n" +
        "ASL? @I LIED\n" +
        "HEY result\n" +
        "TINDER @FINALLY THE TRUTH\n" +
        "B'FUL varfalse\n" +
        "BYE\n" +
        "IS IT TOO LATE NOW TO SAY SORRY? result\n" +
        "CHILL\n"
    getOutput(code) should equal("0\n")
  }

    it should "True Equals True Equals True evaluates True" in {
    val code =
      "NETFLIX\n" +
        "YO result\n" +
        "ASL? @I LIED\n" +
        "HEY result\n" +
        "TINDER @FINALLY THE TRUTH\n" +
        "B'FUL @FINALLY THE TRUTH\n" +
        "B'FUL @FINALLY THE TRUTH\n" +
        "BYE\n" +
        "IS IT TOO LATE NOW TO SAY SORRY? result\n" +
        "CHILL\n"
    getOutput(code) should equal("1\n")
  }

   it should "(13 Equals 13) equals True evaluates True" in {
    val code =
      "NETFLIX\n" +
        "YO result\n" +
        "ASL? @I LIED\n" +
        "HEY result\n" +
        "TINDER 13\n" +
        "B'FUL 13\n" +
        "B'FUL @FINALLY THE TRUTH\n" +
        "BYE\n" +
        "IS IT TOO LATE NOW TO SAY SORRY? result\n" +
        "CHILL\n"
    getOutput(code) should equal("1\n")
  }

   it should "(13 Equals 14) equals False evaluates True" in {
    val code =
      "NETFLIX\n" +
        "YO result\n" +
        "ASL? @I LIED\n" +
        "HEY result\n" +
        "TINDER 13\n" +
        "B'FUL 14\n" +
        "B'FUL @I LIED\n" +
        "BYE\n" +
        "IS IT TOO LATE NOW TO SAY SORRY? result\n" +
        "CHILL\n"
    getOutput(code) should equal("1\n")
  }

   it should "(1 Equals 2) equals 3 evaluates False" in {
    val code =
      "NETFLIX\n" +
        "YO result\n" +
        "ASL? @I LIED\n" +
        "HEY result\n" +
        "TINDER 1\n" +
        "B'FUL 2\n" +
        "B'FUL 3\n" +
        "BYE\n" +
        "IS IT TOO LATE NOW TO SAY SORRY? result\n" +
        "CHILL\n"
    getOutput(code) should equal("0\n")
  }

  it should "13 Equals 13 Equals 14 evaluates False" in {
    val code =
      "NETFLIX\n" +
        "YO result\n" +
        "ASL? @I LIED\n" +
        "HEY result\n" +
        "TINDER 13\n" +
        "B'FUL 13\n" +
        "B'FUL 14\n" +
        "BYE\n" +
        "IS IT TOO LATE NOW TO SAY SORRY? result\n" +
        "CHILL\n"
    getOutput(code) should equal("0\n")
  }

  it should "1 Equals 2 evaluates False" in {
    val code =
      "NETFLIX\n" +
        "YO one\n" +
        "ASL? 1\n" +
        "YO two\n" +
        "ASL? 2\n" +
        "YO result\n" +
        "ASL? @FINALLY THE TRUTH\n" +
        "HEY result\n" +
        "TINDER one\n" +
        "B'FUL two\n" +
        "BYE\n" +
        "IS IT TOO LATE NOW TO SAY SORRY? result\n" +
        "CHILL\n"
    getOutput(code) should equal("0\n")
  }

  it should "2 is greater than 1 evaluates True" in {
    val code =
      "NETFLIX\n" +
        "YO one\n" +
        "ASL? 1\n" +
        "YO two\n" +
        "ASL? 2\n" +
        "YO result\n" +
        "ASL? @FINALLY THE TRUTH\n" +
        "HEY result\n" +
        "TINDER two\n" +
        "YOU LIFT? one\n" +
        "BYE\n" +
        "IS IT TOO LATE NOW TO SAY SORRY? result\n" +
        "CHILL\n"
    getOutput(code) should equal("1\n")
  }

  it should "1 is greater than 2 evaluates False" in {
    val code =
      "NETFLIX\n" +
        "YO one\n" +
        "ASL? 1\n" +
        "YO two\n" +
        "ASL? 2\n" +
        "YO result\n" +
        "ASL? @FINALLY THE TRUTH\n" +
        "HEY result\n" +
        "TINDER one\n" +
        "YOU LIFT? two\n" +
        "BYE\n" +
        "IS IT TOO LATE NOW TO SAY SORRY? result\n" +
        "CHILL\n"
    getOutput(code) should equal("0\n")
  }

  it should "3 is greater than 3 evaluates False" in {
    val code =
      "NETFLIX\n" +
        "YO three\n" +
        "ASL? 3\n" +
        "YO three2\n" +
        "ASL? 3\n" +
        "YO result\n" +
        "ASL? @FINALLY THE TRUTH\n" +
        "HEY result\n" +
        "TINDER three\n" +
        "YOU LIFT? three2\n" +
        "BYE\n" +
        "IS IT TOO LATE NOW TO SAY SORRY? result\n" +
        "CHILL\n"
    getOutput(code) should equal("0\n")
  }

  it should "detect faulty logical operations" in {
    val code = "NETFLIX\n" +
      "RIGHT? WRONG! VAR\n" +
      "ASL? @I LIED\n" +
      "HEY VAR\n" +
      "@I LIED\n" +
      "@I LIED\n" +
      "DAMN GIRL\n" +
      "@FINALLY THE TRUTH\n" +
      "BYE\n" +
      "CHILL\n"
    intercept[ParsingException] {
      getOutput(code)
    }
  }
}
