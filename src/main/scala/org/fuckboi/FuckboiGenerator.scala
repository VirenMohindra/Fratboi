package org.fuckboi

import org.fuckboi.ast.RootNode


class FuckboiGenerator extends ClassLoader {

  def generate(fuckboiCode: String, filename: String): (Array[Byte], RootNode) = {
    val parser = new FuckboiParser
    val rootNode = parser.parse(fuckboiCode)
    (rootNode.generateByteCode(filename), rootNode)
  }
}
