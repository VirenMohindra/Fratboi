package org.fuckboi

class BranchStatementTest extends FuckboiGeneratorTest {
  it should "function using simple if statements" in {
    val code =
      "NETFLIX\n" +
        "YO vartrue\n" +
        "ASL? @FINALLY THE TRUTH\n" +
        "PLEASE? vartrue\n" +
        "IS IT TOO LATE NOW TO SAY SORRY? \"this branch should be reached\"\n" +
        "YOU HAVE NO RESPECT FOR ME\n" +
        "CHILL\n"
    getOutput(code) should equal("this branch should be reached\n")
  }

  it should "function using simple if statements vol2" in {
    val code =
      "NETFLIX\n" +
        "YO vartrue\n" +
        "ASL? @I LIED\n" +
        "PLEASE? vartrue\n" +
        "IS IT TOO LATE NOW TO SAY SORRY? \"this branch should not be reached\"\n" +
        "YOU HAVE NO RESPECT FOR ME\n" +
        "CHILL\n"
    getOutput(code) should equal("")
  }

  it should "function using simple if else statements" in {
    val code =
      "NETFLIX\n" +
        "YO vartrue\n" +
        "ASL? @FINALLY THE TRUTH\n" +
        "PLEASE? vartrue\n" +
        "IS IT TOO LATE NOW TO SAY SORRY? \"this branch should be reached\"\n" +
        "BAE\n" +
        "IS IT TOO LATE NOW TO SAY SORRY? \"this branch should not be reached\"\n" +
        "YOU HAVE NO RESPECT FOR ME\n" +
        "CHILL\n"
    getOutput(code) should equal("this branch should be reached\n")
  }

  it should "function using simple if else statements vol2" in {
    val code =
      "NETFLIX\n" +
        "YO varfalse\n" +
        "ASL? @I LIED\n" +
        "PLEASE? varfalse\n" +
        "IS IT TOO LATE NOW TO SAY SORRY? \"this branch should not be reached\"\n" +
        "BAE\n" +
        "IS IT TOO LATE NOW TO SAY SORRY? \"this branch should be reached\"\n" +
        "YOU HAVE NO RESPECT FOR ME\n" +
        "CHILL\n"
    getOutput(code) should equal("this branch should be reached\n")
  }

  it should "function using assigning variables in if statements" in {
    val code =
      "NETFLIX\n" +
        "YO var\n" +
        "ASL? 0\n" +
        "YO vartrue\n" +
        "ASL? @FINALLY THE TRUTH\n" +
        "PLEASE? vartrue\n" +
        "HEY var\n" +
        "TINDER 3\n" +
        "BYE\n" +
        "YOU HAVE NO RESPECT FOR ME\n" +
        "IS IT TOO LATE NOW TO SAY SORRY? var\n" +
        "CHILL\n"
    getOutput(code) should equal("3\n")
  }


  it should "function using stub while statement" in {
    val code =
      "NETFLIX\n" +
        "YO varfalse\n" +
        "ASL? @I LIED\n" +
        "STICK AROUND varfalse\n" +
        "G2G\n" +
        "CHILL\n"
    getOutput(code) should equal("")
  }


  it should "function using stub while statement vol2" in {
    val code =
      "NETFLIX\n" +
        "STICK AROUND @I LIED\n" +
        "G2G\n" +
        "CHILL\n"
    getOutput(code) should equal("")
  }



  it should "function when while loop executed once" in {
    val code =
      "NETFLIX\n" +
        "YO varfalse\n" +
        "ASL? @FINALLY THE TRUTH\n" +
        "STICK AROUND varfalse\n" +
        "HEY varfalse\n" +
        "TINDER @I LIED\n" +
        "BYE\n" +
        "IS IT TOO LATE NOW TO SAY SORRY? \"while statement printed once\"\n" +
        "G2G\n" +
        "CHILL\n"
    getOutput(code) should equal("while statement printed once\n")
  }

  it should "function when while loop executed consequently" in {
    val code =
      "NETFLIX\n" +
        "YO isLessThan10\n" +
        "ASL? @FINALLY THE TRUTH\n" +
        "YO n\n" +
        "ASL? 0\n" +
        "STICK AROUND isLessThan10\n" +
        "HEY n\n" +
        "TINDER n\n" +
        "ADD ME 1\n" +
        "BYE\n" +
        "IS IT TOO LATE NOW TO SAY SORRY? n\n" +
        "HEY isLessThan10\n" +
        "TINDER 10\n" +
        "YOU LIFT? n\n" +
        "BYE\n" +
        "G2G\n" +
        "CHILL\n"
    getOutput(code) should equal("1\n2\n3\n4\n5\n6\n7\n8\n9\n10\n")
  }
}
