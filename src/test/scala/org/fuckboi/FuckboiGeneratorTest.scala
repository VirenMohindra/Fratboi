package org.fuckboi

import org.scalatest._

abstract  class FuckboiGeneratorTest extends FlatSpec with Matchers {

  val fuckboiGenerator = new FuckboiGenerator
  val byteCodeExecutor = new ByteCodeExecutor
  var className = "Hello"

  def getOutput(fuckboiCode: String): String = {
    val (bytecode, root) = fuckboiGenerator.generate(fuckboiCode, className)
    byteCodeExecutor.getOutput(bytecode, className)
  }

}