package org.fuckboi

import org.parboiled.errors.ParsingException

class ArithmeticTest extends FuckboiGeneratorTest {

  it should "function when a variable is declared" in {
    val code: String =
      "NETFLIX\n" +
        "YO var\n" +
        "ASL? 123\n" +
        "CHILL\n"
    getOutput(code) should equal("")
  }

  it should "function when an integer is printed" in {
    val code: String =
      "NETFLIX\n" +
        "IS IT TOO LATE NOW TO SAY SORRY? 123\n" +
        "CHILL\n"
    getOutput(code) should equal("123\n")
  }

  it should "evaluate when a negative integer is printed" in {
    val code: String =
      "NETFLIX\n" +
        "IS IT TOO LATE NOW TO SAY SORRY? -111\n" +
        "CHILL\n"
    getOutput(code) should equal("-111\n")
  }

  it should "evaluate when a 'boolean' is printed" in {
    val code: String =
      "NETFLIX\n" +
        "YO varfalse\n" +
        "ASL? @I LIED\n" +
        "IS IT TOO LATE NOW TO SAY SORRY? varfalse\n" +
        "CHILL\n"
    getOutput(code) should equal("0\n")
  }

  it should "evaluate when a string is printed" in {
    val code: String =
      "NETFLIX\n" +
        "IS IT TOO LATE NOW TO SAY SORRY? \"this should be printed\"\n" +
        "CHILL\n"
    getOutput(code) should equal("this should be printed\n")
  }

  it should "evaluate when a more exotic string is printed" in {
    val code: String =
      "NETFLIX\n" +
        "IS IT TOO LATE NOW TO SAY SORRY? \"!!! ??? äöäöäöä@#0123=+-,.\"\n" +
        "CHILL\n"
    getOutput(code) should equal("!!! ??? äöäöäöä@#0123=+-,.\n")
  }

  it should "evaluate when an integer is declared and printed" in {
    val code: String =
      "NETFLIX\n" +
        "YO A\n" +
        "ASL? 999\n" +
        "YO B\n" +
        "ASL? 555\n" +
        "IS IT TOO LATE NOW TO SAY SORRY? A\n" +
        "IS IT TOO LATE NOW TO SAY SORRY? B\n" +
        "CHILL\n"
    getOutput(code) should equal("999\n555\n")
  }
  it should "evaluate when a negative integer is declared and printed" in {
    val code: String =
      "NETFLIX\n" +
        "YO a\n" +
        "ASL? -999\n" +
        "YO b\n" +
        "ASL? -555\n" +
        "IS IT TOO LATE NOW TO SAY SORRY? a\n" +
        "IS IT TOO LATE NOW TO SAY SORRY? b\n" +
        "CHILL\n"
    getOutput(code) should equal("-999\n-555\n")
  }

  it should "evaluate when assigning a variable" in {
    val code =
      "NETFLIX\n" +
        "YO var\n" +
        "ASL? 22\n" +
        "HEY var\n" +
        "TINDER 123\n" +
        "BYE\n" +
        "IS IT TOO LATE NOW TO SAY SORRY? var\n" +
        "CHILL\n"

    getOutput(code) should equal("123\n")
  }


  it should "evaluate when assigning multiple variables " in {
    val code =
      "NETFLIX\n" +
        "YO var\n" +
        "ASL? 22\n" +
        "YO var2\n" +
        "ASL? 27\n" +
        "HEY var\n" +
        "TINDER 123\n" +
        "BYE\n" +
        "HEY var2\n" +
        "TINDER 707\n" +
        "BYE\n" +
        "HEY var\n" +
        "TINDER var2\n" +
        "ADD ME var\n" +
        "BYE\n" +
        "IS IT TOO LATE NOW TO SAY SORRY? var\n" +
        "CHILL\n"

    getOutput(code) should equal("830\n")
  }

  it should "evaluate when an integer is incremented and printed" in {
    val code =
      "NETFLIX\n" +
        "YO VAR\n" +
        "ASL? 22\n" +
        "HEY VAR\n" +
        "TINDER VAR\n" +
        "ADD ME 44\n" +
        "BYE\n" +
        "IS IT TOO LATE NOW TO SAY SORRY? VAR\n" +
        "CHILL\n"
    getOutput(code) should equal("66\n")
  }

  it should "evaluate when an integer is decremented and printed" in {
    val code =
      "NETFLIX\n" +
        "YO VAR\n" +
        "ASL? 22\n" +
        "HEY VAR\n" +
        "TINDER VAR\n" +
        "DON'T DELETE ME 44\n" +
        "BYE\n" +
        "IS IT TOO LATE NOW TO SAY SORRY? VAR\n" +
        "CHILL\n"
    getOutput(code) should equal("-22\n")
  }

  it should "evaluate when an integer is decremented with a negative value" in {
    val code =
      "NETFLIX\n" +
        "YO VAR\n" +
        "ASL? 22\n" +
        "HEY VAR\n" +
        "TINDER VAR\n" +
        "DON'T DELETE ME -44\n" +
        "BYE\n" +
        "IS IT TOO LATE NOW TO SAY SORRY? VAR\n" +
        "CHILL\n"
    getOutput(code) should equal("66\n")
  }


  it should "evaluate when an integer is incremented with a negative value" in {
    val code =
      "NETFLIX\n" +
        "YO VAR\n" +
        "ASL? 22\n" +
        "HEY VAR\n" +
        "TINDER VAR\n" +
        "ADD ME -44\n" +
        "BYE\n" +
        "IS IT TOO LATE NOW TO SAY SORRY? VAR\n" +
        "CHILL\n"
    getOutput(code) should equal("-22\n")
  }

  it should "evaluate when multiplying variables" in {
    val code =
      "NETFLIX\n" +
        "YO VAR\n" +
        "ASL? 22\n" +
        "HEY VAR\n" +
        "TINDER VAR\n" +
        "MULTIPLY 13\n" +
        "BYE\n" +
        "IS IT TOO LATE NOW TO SAY SORRY? VAR\n" +
        "CHILL\n"
    getOutput(code) should equal("286\n")
  }

  it should "evaluate when multiplying variables with different signs" in {
    val code =
      "NETFLIX\n" +
        "YO VAR\n" +
        "ASL? 22\n" +
        "HEY VAR\n" +
        "TINDER VAR\n" +
        "MULTIPLY -13\n" +
        "BYE\n" +
        "IS IT TOO LATE NOW TO SAY SORRY? VAR\n" +
        "CHILL\n"
    getOutput(code) should equal("-286\n")
  }

  it should "evaluate when multiplying variables with zero" in {
    val code =
      "NETFLIX\n" +
        "YO VAR\n" +
        "ASL? 22\n" +
        "HEY VAR\n" +
        "TINDER VAR\n" +
        "MULTIPLY 0\n" +
        "BYE\n" +
        "IS IT TOO LATE NOW TO SAY SORRY? VAR\n" +
        "CHILL\n"
    getOutput(code) should equal("0\n")
  }

  it should "evaluate when multiplying assigned variables" in {
    val code =
      "NETFLIX\n" +
        "YO VAR\n" +
        "ASL? 7\n" +
        "YO VAR2\n" +
        "ASL? 4\n" +
        "HEY VAR\n" +
        "TINDER VAR\n" +
        "MULTIPLY VAR2\n" +
        "BYE\n" +
        "IS IT TOO LATE NOW TO SAY SORRY? VAR\n" +
        "CHILL\n"
    getOutput(code) should equal("28\n")
  }

  it should "evaluate when dividing variables" in {
    val code =
      "NETFLIX\n" +
        "YO VAR\n" +
        "ASL? 100\n" +
        "HEY VAR\n" +
        "TINDER VAR\n" +
        "DIVIDE AND CONQUER 4\n" +
        "BYE\n" +
        "IS IT TOO LATE NOW TO SAY SORRY? VAR\n" +
        "CHILL\n"
    getOutput(code) should equal("25\n")
  }

  it should "evaluate when dividing variables with different signs" in {
    val code =
      "NETFLIX\n" +
        "YO VAR\n" +
        "ASL? 99\n" +
        "HEY VAR\n" +
        "TINDER VAR\n" +
        "DIVIDE AND CONQUER -33\n" +
        "BYE\n" +
        "IS IT TOO LATE NOW TO SAY SORRY? VAR\n" +
        "CHILL\n"
    getOutput(code) should equal("-3\n")
  }

  it should "evaluate when dividing variables with one" in {
    val code =
      "NETFLIX\n" +
        "YO VAR\n" +
        "ASL? 22\n" +
        "HEY VAR\n" +
        "TINDER VAR\n" +
        "DIVIDE AND CONQUER 1\n" +
        "BYE\n" +
        "IS IT TOO LATE NOW TO SAY SORRY? VAR\n" +
        "CHILL\n"
    getOutput(code) should equal("22\n")
  }

  it should "evaluate when dividing assigned variables" in {
    val code =
      "NETFLIX\n" +
        "YO VAR\n" +
        "ASL? 9\n" +
        "YO VAR2\n" +
        "ASL? 4\n" +
        "HEY VAR\n" +
        "TINDER VAR\n" +
        "DIVIDE AND CONQUER VAR2\n" +
        "BYE\n" +
        "IS IT TOO LATE NOW TO SAY SORRY? VAR\n" +
        "CHILL\n"
    getOutput(code) should equal("2\n")
  }

  it should "evaluate when calculating modulo variables vol1" in {
    val code =
      "NETFLIX\n" +
        "YO var\n" +
        "ASL? 1\n" +
        "HEY var\n" +
        "TINDER var\n" +
        "DON'T LEAVE ME 2\n" +
        "BYE\n" +
        "IS IT TOO LATE NOW TO SAY SORRY? var\n" +
        "CHILL\n"
    getOutput(code) should equal("1\n")
  }

  it should "evaluate when calculating modulo variables vol2" in {
    val code =
      "NETFLIX\n" +
        "YO var\n" +
        "ASL? 2\n" +
        "HEY var\n" +
        "TINDER var\n" +
        "DON'T LEAVE ME 2\n" +
        "BYE\n" +
        "IS IT TOO LATE NOW TO SAY SORRY? var\n" +
        "CHILL\n"
    getOutput(code) should equal("0\n")
  }

  it should "evaluate using different arithmetic operations" in {
    val code =
      "NETFLIX\n" +
        "YO VAR\n" +
        "ASL? 22\n" +
        "HEY VAR\n" +
        "TINDER 11\n" +
        "DON'T DELETE ME 43\n" +
        "ADD ME 54\n" +
        "ADD ME 44\n" +
        "BYE\n" +
        "IS IT TOO LATE NOW TO SAY SORRY? VAR\n" +
        "CHILL\n"
    getOutput(code) should equal("66\n")
  }

  it should "evaluate using different arithmetic operations vol2" in {
    val code =
      "NETFLIX\n" +
        "YO VAR\n" +
        "ASL? 22\n" +
        "HEY VAR\n" +
        "TINDER 11\n" +
        "DON'T DELETE ME 55\n" +
        "ADD ME 11\n" +
        "ADD ME 22\n" +
        "ADD ME 23\n" +
        "DON'T DELETE ME 0\n" +
        "ADD ME 0\n" +
        "ADD ME 1\n" +
        "BYE\n" +
        "IS IT TOO LATE NOW TO SAY SORRY? VAR\n" +
        "CHILL\n"
    getOutput(code) should equal("13\n")
  }

  it should "evaluate using different arithmetic operations vol3" in {
    val code =
      "NETFLIX\n" +
        "YO VAR\n" +
        "ASL? 22\n" +
        "HEY VAR\n" +
        "TINDER 11\n" +
        "DON'T DELETE ME 22\n" +
        "DIVIDE AND CONQUER -11\n" +
        "MULTIPLY 23\n" +
        "ADD ME 23\n" +
        "DON'T DELETE ME 22\n" +
        "DIVIDE AND CONQUER 2\n" +
        "BYE\n" +
        "IS IT TOO LATE NOW TO SAY SORRY? VAR\n" +
        "CHILL\n"
    getOutput(code) should equal("12\n")
  }

  it should "detect duplicate variable declarations" in {
    val code =
      "NETFLIX\n" +
        "YO VAR\n" +
        "ASL? 22\n" +
        "YO VAR\n" +
        "ASL? 22\n" +
        "CHILL\n"
    intercept[ParsingException] {
      getOutput(code)
    }
  }

  it should "detect faulty variable names" in {
    val code =
      "NETFLIX\n" +
        "YO 1VAR\n" +
        "ASL? 123\n" +
        "CHILL\n"
    intercept[ParsingException] {
      getOutput(code)
    }
  }
}
