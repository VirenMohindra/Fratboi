package org.fuckboi

import org.parboiled.errors.ParsingException

class MethodTest extends FuckboiGeneratorTest {

  it should "evalute method other than main" in {
    val code =
      "LISTEN TO ME VERY CAREFULLY mymethod\n" +
        "SRY BBY\n" +
        "NETFLIX\n" +
        "IS IT TOO LATE NOW TO SAY SORRY? \"Hello\"\n" +
        "CHILL\n"
    getOutput(code) should equal("Hello\n")
  }

  it should "evalute method other than main2" in {
    val code =
      "LISTEN TO ME VERY CAREFULLY mymethod\n" +
        "SRY BBY\n" +
        "NETFLIX\n" +
        "IS IT TOO LATE NOW TO SAY SORRY? \"Hello\"\n" +
        "CHILL"
    getOutput(code) should equal("Hello\n")
  }

  it should "evalute method other than main3" in {
    val code =
      "NETFLIX\n" +
        "IS IT TOO LATE NOW TO SAY SORRY? \"Hello\"\n" +
        "CHILL\n" +
        "LISTEN TO ME VERY CAREFULLY mymethod\n" +
        "SRY BBY\n"
    getOutput(code) should equal("Hello\n")
  }
  it should "evalute method other than main4" in {
    val code =
      "NETFLIX\n" +
        "IS IT TOO LATE NOW TO SAY SORRY? \"Hello\"\n" +
        "CHILL\n" +
        "LISTEN TO ME VERY CAREFULLY mymethod\n" +
        "SRY BBY"
    getOutput(code) should equal("Hello\n")
  }

  it should "evalute a plain method call" in {
    val code =
      "NETFLIX\n" +
        "SNAP printHello\n" +
        "CHILL\n" +
        "LISTEN TO ME VERY CAREFULLY printHello\n" +
        "IS IT TOO LATE NOW TO SAY SORRY? \"Hello\"\n" +
        "SRY BBY"
    getOutput(code) should equal("Hello\n")
  }

  it should "evalute a method call that takes an argument" in {
    val code =
      "NETFLIX\n" +
        "YO argument\n" +
        "ASL? 123\n" +
        "SNAP printInteger argument\n" +
        "CHILL\n" +
        "LISTEN TO ME VERY CAREFULLY printInteger\n" +
        "MMHMM value\n" +
        "IS IT TOO LATE NOW TO SAY SORRY? value\n" +
        "SRY BBY"
    getOutput(code) should equal("123\n")
  }

  it should "evalute multiple method calls" in {
    val code =
      "NETFLIX\n" +
        "SNAP printHello\n" +
        "SNAP printCheers\n" +
        "CHILL\n" +
        "LISTEN TO ME VERY CAREFULLY printHello\n" +
        "IS IT TOO LATE NOW TO SAY SORRY? \"Hello\"\n" +
        "SRY BBY\n" +
        "LISTEN TO ME VERY CAREFULLY printCheers\n" +
        "IS IT TOO LATE NOW TO SAY SORRY? \"Cheers\"\n" +
        "SRY BBY"
    getOutput(code) should equal("Hello\nCheers\n")
  }

  it should "evalute method calls inside method calls" in {
    val code =
      "NETFLIX\n" +
        "SNAP printHello\n" +
        "CHILL\n" +
        "LISTEN TO ME VERY CAREFULLY printHello\n" +
        "IS IT TOO LATE NOW TO SAY SORRY? \"Hello\"\n" +
        "SNAP printCheers\n" +
        "SNAP printHejsan\n" +
        "SRY BBY\n" +
        "LISTEN TO ME VERY CAREFULLY printCheers\n" +
        "IS IT TOO LATE NOW TO SAY SORRY? \"Cheers\"\n" +
        "SRY BBY\n" +
        "LISTEN TO ME VERY CAREFULLY printHejsan\n" +
        "IS IT TOO LATE NOW TO SAY SORRY? \"Hejsan\"\n" +
        "SRY BBY"
    getOutput(code) should equal("Hello\nCheers\nHejsan\n")
  }

  it should "evalute a return statement in void calls" in {
    val code =
      "NETFLIX\n" +
        "SNAP method\n" +
        "CHILL\n" +
        "LISTEN TO ME VERY CAREFULLY method\n" +
        "LONG TIME...\n" +
        "SRY BBY\n"

    getOutput(code) should equal("")
  }

  it should "evalute multiple return statemenents in void calls" in {
    val code = "NETFLIX\n" +
      "SNAP printboolean @FINALLY THE TRUTH\n" +
      "SNAP printboolean @I LIED\n" +
      "CHILL\n" +
      "LISTEN TO ME VERY CAREFULLY printboolean\n" +
      "MMHMM value\n" +
      "PLEASE? value\n" +
      "IS IT TOO LATE NOW TO SAY SORRY? \"true\"\n" +
      "LONG TIME...\n" +
      "BAE\n" +
      "IS IT TOO LATE NOW TO SAY SORRY? \"false\"\n" +
      "LONG TIME...\n" +
      "YOU HAVE NO RESPECT FOR ME\n" +
      "SRY BBY\n"

    getOutput(code) should equal("true\nfalse\n")
  }

  it should "evalute multiple return statemenents in void calls permutation2" in {
    val code = "NETFLIX\n" +
      "SNAP printboolean @FINALLY THE TRUTH\n" +
      "SNAP printboolean @I LIED\n" +
      "CHILL\n" +
      "LISTEN TO ME VERY CAREFULLY printboolean\n" +
      "MMHMM value\n" +
      "PLEASE? value\n" +
      "IS IT TOO LATE NOW TO SAY SORRY? \"true\"\n" +
      "BAE\n" +
      "IS IT TOO LATE NOW TO SAY SORRY? \"false\"\n" +
      "YOU HAVE NO RESPECT FOR ME\n" +
      "SRY BBY\n"
    getOutput(code) should equal("true\nfalse\n")
  }

  it should "evalute multiple return statemenents in void calls permutation3" in {
    val code = "NETFLIX\n" +
      "SNAP printboolean @FINALLY THE TRUTH\n" +
      "SNAP printboolean @I LIED\n" +
      "CHILL\n" +
      "LISTEN TO ME VERY CAREFULLY printboolean\n" +
      "MMHMM value\n" +
      "PLEASE? value\n" +
      "IS IT TOO LATE NOW TO SAY SORRY? \"true\"\n" +
      "BAE\n" +
      "IS IT TOO LATE NOW TO SAY SORRY? \"false\"\n" +
      "YOU HAVE NO RESPECT FOR ME\n" +
      "LONG TIME...\n" +
      "LONG TIME...\n" +
      "SRY BBY\n"
    getOutput(code) should equal("true\nfalse\n")
  }


  it should "evalute multiple return statemenents in void calls with unreachable code" in {
    val code = "NETFLIX\n" +
      "SNAP method\n" +
      "CHILL\n" +
      "LISTEN TO ME VERY CAREFULLY method\n" +
      "IS IT TOO LATE NOW TO SAY SORRY? \"reached codeblock\"\n" +
      "LONG TIME...\n" +
      "IS IT TOO LATE NOW TO SAY SORRY? \"unreached codeblock\"\n" +
      "SRY BBY\n"

    getOutput(code) should equal("reached codeblock\n")
  }

  it should "evalute void method calls returning from branched statements" in {
    val code =
      "NETFLIX\n" +
        "SNAP reverse @FINALLY THE TRUTH\n" +
        "CHILL\n" +
        "LISTEN TO ME VERY CAREFULLY reverse\n" +
        "MMHMM value\n" +
        "PLEASE? value\n" +
        "IS IT TOO LATE NOW TO SAY SORRY? \"evaluated\"\n" +
        "LONG TIME...\n" +
        "YOU HAVE NO RESPECT FOR ME\n" +
        "IS IT TOO LATE NOW TO SAY SORRY? \"not evaluated\"\n"+
        "LONG TIME...\n" +
        "SRY BBY\n"
    getOutput(code) should equal("evaluated\n")
  }

  it should "evalute non void method calls returning from branched statements" in {
    val code =
      "NETFLIX\n" +
        "SNAP reverse @FINALLY THE TRUTH\n" +
        "CHILL\n" +
        "LISTEN TO ME VERY CAREFULLY reverse\n" +
        "MMHMM value\n" +
        "SMILE MORE\n" +
        "PLEASE? value\n" +
        "IS IT TOO LATE NOW TO SAY SORRY? \"evaluated\"\n" +
        "LONG TIME... 0\n" +
        "IS IT TOO LATE NOW TO SAY SORRY? \"evaluated\"\n" +
        "YOU HAVE NO RESPECT FOR ME\n" +
        "IS IT TOO LATE NOW TO SAY SORRY? \"not evaluated\"\n"+
        "LONG TIME... 0\n" +
        "SRY BBY\n"
    getOutput(code) should equal("evaluated\n")
  }

  it should "evalute assignments to variables from method calls " in {
    val code =
      "NETFLIX\n" +
        "YO result\n" +
        "ASL? 0\n" +
        "GET YOUR ASS HERE result\n" +
        "SNAP square 7\n" +
        "IS IT TOO LATE NOW TO SAY SORRY? result\n" +
        "CHILL\n" +
        "LISTEN TO ME VERY CAREFULLY square\n" +
        "MMHMM value\n" +
        "SMILE MORE\n" +
        "HEY value\n" +
        "TINDER value\n" +
        "MULTIPLY value\n" +
        "BYE\n" +
        "LONG TIME... value\n" +
        "SRY BBY\n"
    getOutput(code) should equal("49\n")
  }

  it should "detect unclosed main method" in {
    val code =
      "NETFLIX\n" +
        "LISTEN TO ME VERY CAREFULLY printHello\n" +
        "IS IT TOO LATE NOW TO SAY SORRY? \"Hello\"\n"
    intercept[ParsingException] {
      getOutput(code)
    }
  }
  it should "detect unclosed methods" in {
    val code =
      "NETFLIX\n" +
        "CHILL\n" +
        "LISTEN TO ME VERY CAREFULLY printHello\n" +
        "IS IT TOO LATE NOW TO SAY SORRY? \"Hello\"\n"
    intercept[ParsingException] {
      getOutput(code)
    }
  }

  it should "detect calls to methods that are not declared" in {
    val code =
      "NETFLIX\n" +
        "SNAP noSuchMethod\n" +
        "CHILL\n"
    intercept[ParsingException] {
      getOutput(code)
    }
  }

  it should "detect if void method tries to return a parameter" in {
    val code = "NETFLIX\n" +
      "SNAP method\n" +
      "CHILL\n" +
      "LISTEN TO ME VERY CAREFULLY method\n" +
      "LONG TIME... 0\n" +
      "SRY BBY\n"

    intercept[ParsingException] {
      getOutput(code)
    }
  }

  it should "detect if a non-void method tries to return a without a parameter" in {
    val code = "NETFLIX\n" +
      "SNAP method 0\n" +
      "CHILL\n" +
      "LISTEN TO ME VERY CAREFULLY method\n" +
      "MMHMM value\n" +
      "SMILE MORE\n" +
      "LONG TIME...\n" +
      "SRY BBY\n"

    intercept[ParsingException] {
      getOutput(code)
    }
  }
}
