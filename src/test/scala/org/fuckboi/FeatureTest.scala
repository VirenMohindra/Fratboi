package org.fuckboi

class FeatureTest extends FuckboiGeneratorTest {

  it should "Print Fibonacci Numbers from 1 to 10" in {
    val code = "NETFLIX\n" +
      "YO prev\n" +
      "ASL? -1\n" +
      "YO result\n" +
      "ASL? 1\n" +
      "YO sum\n" +
      "ASL? 0\n" +
      "YO loop\n" +
      "ASL? @FINALLY THE TRUTH\n" +
      "YO index\n" +
      "ASL? 0\n" +
      "YO limit\n" +
      "ASL? 10\n" +
      "\nSTICK AROUND loop\n" +
      "\tHEY sum\n" +
      "\tTINDER result\n" +
      "\tADD ME prev\n" +
      "\tBYE\n" +
      "\n\tHEY prev\n" +
      "\tTINDER result\n" +
      "\tBYE\n\t" +
      "\n\tHEY result\n" +
      "\tTINDER sum\n" +
      "\tBYE\n\t" +
      "\n\tHEY index\n" +
      "\tTINDER index\n" +
      "\tADD ME 1\n" +
      "\tBYE\n\t" +
      "\n\tHEY loop\n" +
      "\tTINDER limit\n" +
      "\tYOU LIFT? index\n" +
      "\tBYE\n\t" +
      "\n\tIS IT TOO LATE NOW TO SAY SORRY? sum\n" +
      "G2G\n" +
      "\nCHILL"

    getOutput(code) should equal("0\n1\n1\n2\n3\n5\n8\n13\n21\n34\n")
  }


  it should "print fibonacci when using recursion" in {
    val code = "NETFLIX\n" +
      "YO result\n" +
      "ASL? 0\n" +
      "GET YOUR ASS HERE result\n" +
      "SNAP fib 9\n" +
      "IS IT TOO LATE NOW TO SAY SORRY? result\n" +
      "CHILL\n" +
      "\nLISTEN TO ME VERY CAREFULLY fib\n" +
      "MMHMM val\n" +
      "SMILE MORE\n" +
      "\tYO endrecursion\n" +
      "\tASL? @I LIED\n" +
      "\tHEY endrecursion\n" +
      "\tTINDER 2\n" +
      "\tYOU LIFT? val\n" +
      "\tBYE\n\n" +
      "\tPLEASE? endrecursion\n" +
      "\t\tLONG TIME... val\t\n" +
      "\tBAE\n" +
      "\t\tYO temp1\n" +
      "\t\tASL? 0\n" +
      "\t\tYO temp2\n" +
      "\t\tASL? 0\n\n" +
      "\t\tHEY val\n" +
      "\t\tTINDER val\n" +
      "\t\tDON'T DELETE ME 1\n" +
      "\t\tBYE\n" +
      "\t\tGET YOUR ASS HERE temp1\n" +
      "\t\tSNAP fib val\n" +
      "\t\tHEY val\n" +
      "\t\tTINDER val\n" +
      "\t\tDON'T DELETE ME 1\n" +
      "\t\tBYE\n" +
      "\t\tGET YOUR ASS HERE temp2\n" +
      "\t\tSNAP fib val\n" +
      "\t\tHEY val\n" +
      "\t\tTINDER temp1\n" +
      "\t\tADD ME temp2\n" +
      "\t\tBYE\n" +
      "\t\tLONG TIME... val\n" +
      "\t\tYOU HAVE NO RESPECT FOR ME\n\n" +
      "\nSRY BBY"

    getOutput(code) should equal("34\n")
  }


  it should "printf modulos when a modulo function is defined" in {
    val code = "NETFLIX\n" +
      "YO result1\n" +
      "ASL? 0\n" +
      "YO result2\n" +
      "ASL? 0\n" +
      "YO result3\n" +
      "ASL? 0\n" +
      "YO result4\n" +
      "ASL? 0\n" +
      "GET YOUR ASS HERE result1\n" +
      "SNAP modulo 9 4\n" +
      "IS IT TOO LATE NOW TO SAY SORRY? result1\n" +
      "GET YOUR ASS HERE result2\n" +
      "SNAP modulo 4795 87\n" +
      "IS IT TOO LATE NOW TO SAY SORRY? result2\n" +
      "GET YOUR ASS HERE result3\n" +
      "SNAP modulo 3978 221\n" +
      "IS IT TOO LATE NOW TO SAY SORRY? result3\n" +
      "GET YOUR ASS HERE result4\n" +
      "SNAP modulo 5559 345\n" +
      "IS IT TOO LATE NOW TO SAY SORRY? result4\n" +
      "CHILL\n" +
      "LISTEN TO ME VERY CAREFULLY modulo\n" +
      "MMHMM dividend\n" +
      "MMHMM divisor\n" +
      "SMILE MORE\n" +
      "YO quotient\n" +
      "ASL? 0\n" +
      "YO remainder\n" +
      "ASL? 0\n" +
      "YO product\n" +
      "ASL? 0\n" +
      "HEY quotient\n" +
      "TINDER dividend\n" +
      "DIVIDE AND CONQUER divisor\n" +
      "BYE\n" +
      "HEY product\n" +
      "TINDER divisor\n" +
      "MULTIPLY quotient\n" +
      "BYE\n" +
      "HEY remainder\n" +
      "TINDER dividend\n" +
      "DON'T DELETE ME product\n" +
      "BYE\n" +
      "LONG TIME... remainder\n" +
      "SRY BBY"

    getOutput(code) should equal("1\n10\n0\n39\n")
  }

  it should "print squares from 1 to 10" in {
    val code = "NETFLIX\n" +
      "YO limit\n" +
      "ASL? 10\n" +
      "YO index\n" +
      "ASL? 1\n" +
      "YO squared\n" +
      "ASL? 1\n" +
      "YO loop\n" +
      "ASL? @FINALLY THE TRUTH \n\n" +
      "STICK AROUND loop\n\n" +
      "\tHEY squared\n" +
      "\tTINDER index\n" +
      "\tMULTIPLY index\n" +
      "\tBYE\n" +
      "\tIS IT TOO LATE NOW TO SAY SORRY? squared\n\t\n" +
      "\tHEY loop\n" +
      "\tTINDER limit\n" +
      "\tYOU LIFT? index\n" +
      "\tBYE\n\t\n" +
      "\tHEY index\n" +
      "\tTINDER index\n" +
      "\tADD ME 1\n" +
      "\tBYE\n\t\n" +
      "G2G\n" +
      "CHILL"

    getOutput(code) should equal("1\n4\n9\n16\n25\n36\n49\n64\n81\n100\n")
  }

}
