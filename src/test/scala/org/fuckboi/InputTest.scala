package org.fuckboi
import org.scalatest.{Matchers, FlatSpec}
import java.io._

class InputTest extends FuckboiGeneratorTest{

  it should "read integer from input" in {
    writeToFile(path, "123")
    val code =
      "NETFLIX\n" +
      "IS IT TOO LATE NOW TO SAY SORRY? \"Input a number:\"\n" +
      "YO result\n" +
      "ASL? 0\n" +
      "GET YOUR ASS HERE result\n" +
      "SNAP\n" +
      "WHAT DO YOU MEAN?\n" +
      "IS IT TOO LATE NOW TO SAY SORRY? result\n" +
      "IS IT TOO LATE NOW TO SAY SORRY? \"Bye\"\n" +
      "CHILL\n"
    getOutput(code) should equal("Input a number:\n123\nBye\n")
  }

  val path = "test.in"

  override val byteCodeExecutor = new ByteCodeExecutor{

    override def getOutput(bytecode: Array[Byte], className: String): String = {

      val originalIn = System.in
      val outputRedirectionStream = new ByteArrayOutputStream()
      val fileInput = new BufferedInputStream(new FileInputStream(path))
      System.setOut(new PrintStream(outputRedirectionStream))
      System.setIn(fileInput)

      try {
        invokeMainMethod(bytecode, className)
      } finally {
        System.setOut(originalOutputStream)
        System.setIn(originalIn)
      }
      outputRedirectionStream.toString
    }
  }

  def writeToFile(file:String, data:String) = {
    val out = new FileOutputStream(file)
    out.write(data.getBytes)
    out.close()
  }


}